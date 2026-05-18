package cl.triskeledu.notificaciones.service.impl;

import cl.triskeledu.notificaciones.dto.request.NotificacionRequestDTO;
import cl.triskeledu.notificaciones.dto.response.NotificacionResponseDTO;
import cl.triskeledu.notificaciones.entity.Notificacion;
import cl.triskeledu.notificaciones.entity.enums.EstadoNotificacion;
import cl.triskeledu.notificaciones.exception.NotificacionNotFoundException;
import cl.triskeledu.notificaciones.mapper.NotificacionMapper;
import cl.triskeledu.notificaciones.repository.NotificacionRepository;
import cl.triskeledu.notificaciones.service.NotificacionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1>Servicio de notificaciones</h1>
 * <p>
 * Implementa {@link NotificacionService} para la creación y envío (simulado)
 * de notificaciones en ms-notificaciones.
 * </p>
 *
 * <h2>Tipos de notificación soportados</h2>
 * <ul>
 *   <li><b>EMAIL</b> — correo electrónico transaccional</li>
 *   <li><b>SMS</b> — mensaje de texto</li>
 *   <li><b>PUSH</b> — notificación push móvil</li>
 * </ul>
 *
 * <h2>Simulación de envío</h2>
 * <p>
 * El método {@link #enviarNotificacion(NotificacionRequestDTO)} persiste la
 * entidad en estado {@code PENDIENTE}, luego ejecuta un bloque {@code try-catch}
 * que simula el envío. Si no ocurre excepción se marca como {@code ENVIADO};
 * en caso contrario como {@code FALLIDO}.
 * </p>
 * <p><b>Importante:</b> la integración real con proveedores externos
 * (AWS SES, Twilio, Firebase Cloud Messaging) está pendiente. Actualmente
 * el bloque {@code try} solo emite un log de advertencia.</p>
 *
 * <h2>Kafka Listener (externo a esta clase)</h2>
 * <p>
 * {@code NotificationEventListener} consume los tópicos {@code pedido-events}
 * y {@code delivery-events} y utiliza este servicio para crear notificaciones
 * automáticas cuando ocurren cambios de estado en pedidos o repartos.
 * </p>
 *
 * @see NotificacionService
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NotificacionServiceImpl implements NotificacionService {

    private final NotificacionRepository notificacionRepository;
    private final NotificacionMapper notificacionMapper;

    /**
     * Crea una notificación, persiste en estado {@code PENDIENTE}, simula el envío
     * y actualiza el estado final a {@code ENVIADO} o {@code FALLIDO}.
     * <p>
     * La simulación consiste en un bloque {@code try-catch} sin llamada real
     * a proveedor externo. La integración con AWS SES, Twilio o Firebase
     * está pendiente.
     * </p>
     *
     * @param dto datos de la notificación (destinatario, tipo, asunto, cuerpo)
     * @return DTO con la notificación creada y su estado final
     */
    @Override
    public NotificacionResponseDTO enviarNotificacion(NotificacionRequestDTO dto) {
        Notificacion notificacion = Notificacion.builder()
                .destinatario(dto.getDestinatario())
                .tipo(dto.getTipo())
                .asunto(dto.getAsunto())
                .cuerpo(dto.getCuerpo())
                .estado(EstadoNotificacion.PENDIENTE)
                .build();

        notificacion = notificacionRepository.save(notificacion);
        log.info("Notificación creada en estado PENDIENTE con id={}", notificacion.getId());

        try {
            log.warn("Simulación de envío: integración real con proveedor (AWS SES/Twilio/Firebase) pendiente para id={}", notificacion.getId());
            notificacion.setEstado(EstadoNotificacion.ENVIADO);
        } catch (Exception e) {
            log.error("Error al enviar notificación id={}: {}", notificacion.getId(), e.getMessage());
            notificacion.setEstado(EstadoNotificacion.FALLIDO);
        }

        notificacion = notificacionRepository.save(notificacion);
        return notificacionMapper.toResponseDTO(notificacion);
    }

    /**
     * Busca una notificación por su ID.
     * Lanza {@link NotificacionNotFoundException} si no existe.
     *
     * @param id identificador único de la notificación
     * @return DTO con los datos de la notificación encontrada
     * @throws NotificacionNotFoundException si el ID no corresponde a ninguna notificación
     */
    @Override
    public NotificacionResponseDTO getById(Long id) {
        Notificacion notificacion = notificacionRepository.findById(id)
                .orElseThrow(() -> new NotificacionNotFoundException("Notificación no encontrada con id=" + id));
        return notificacionMapper.toResponseDTO(notificacion);
    }

    /**
     * Lista todas las notificaciones que coinciden con un estado determinado
     * (ej. {@code PENDIENTE}, {@code ENVIADO}, {@code FALLIDO}).
     * Útil para monitoreo y reintentos de notificaciones fallidas.
     *
     * @param estado el estado por el cual filtrar
     * @return lista de DTOs con las notificaciones que coinciden con el estado
     */
    @Override
    public List<NotificacionResponseDTO> listarPorEstado(EstadoNotificacion estado) {
        return notificacionRepository.findByEstado(estado).stream()
                .map(notificacionMapper::toResponseDTO)
                .toList();
    }
}
