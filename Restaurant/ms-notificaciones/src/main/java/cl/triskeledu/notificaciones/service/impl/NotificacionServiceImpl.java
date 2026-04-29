package cl.triskeledu.notificaciones.service.impl;

import cl.triskeledu.notificaciones.dto.request.NotificacionRequestDTO;
import cl.triskeledu.notificaciones.dto.response.NotificacionResponseDTO;
import cl.triskeledu.notificaciones.entity.enums.EstadoNotificacion;
import cl.triskeledu.notificaciones.service.NotificacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * =============================================================================
 * SERVICE IMPL: NotificacionServiceImpl
 * =============================================================================
 */
@Service
@Slf4j
public class NotificacionServiceImpl implements NotificacionService {

    @Override
    public NotificacionResponseDTO enviarNotificacion(NotificacionRequestDTO dto) {
        /*
         * INTENCIÓN: Registrar y procesar el envío de una alerta.
         *
         * FLUJO ESPERADO:
         *   1. Crear entidad en estado PENDIENTE.
         *   2. Guardar en BD.
         *   3. Simular integración con AWS SES, Twilio, Firebase, etc.
         *   4. Si exitoso -> Actualizar a ENVIADO. Si falla -> FALLIDO.
         *   5. Guardar actualización en BD.
         *   Output: NotificacionResponseDTO con estado final.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public NotificacionResponseDTO getById(Long id) {
        /*
         * INTENCIÓN: Consultar si un mensaje específico se envió.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public List<NotificacionResponseDTO> listarPorEstado(EstadoNotificacion estado) {
        /*
         * INTENCIÓN: Listar para posible reintento (ej. buscar todas las FALLIDAS).
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }
}
