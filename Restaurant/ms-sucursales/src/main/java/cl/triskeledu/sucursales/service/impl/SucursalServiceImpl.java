package cl.triskeledu.sucursales.service.impl;

import cl.triskeledu.sucursales.dto.event.SucursalEventDTO;
import cl.triskeledu.sucursales.dto.request.SucursalRequestDTO;
import cl.triskeledu.sucursales.dto.response.SucursalResponseDTO;
import cl.triskeledu.sucursales.entity.Sucursal;
import cl.triskeledu.sucursales.exception.SucursalNotFoundException;
import cl.triskeledu.sucursales.mapper.SucursalMapper;
import cl.triskeledu.sucursales.repository.SucursalRepository;
import cl.triskeledu.sucursales.service.SucursalService;
import cl.triskeledu.sucursales.client.AuthFeignClient;
import cl.triskeledu.sucursales.dto.response.PermisoResponseDTO;
import cl.triskeledu.sucursales.exception.AccesoDenegadoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio de gestión de sucursales (locales del restaurante).
 *
 * <h2>Responsabilidades</h2>
 * <ul>
 *   <li><strong>CRUD de sucursales:</strong> crear, leer, actualizar y cambiar estado
 *       de los locales del restaurante.</li>
 *   <li><strong>Kafka (CQRS):</strong> publica eventos en el tópico
 *       {@code sucursal-events} cada vez que se crea, actualiza o cambia el estado
 *       de una sucursal. Estos eventos son consumidos por {@code ms-menu} y
 *       {@code ms-pedidos} para mantener actualizadas sus proyecciones locales
 *       (proyección de sucursales en cada microservicio consumidor).</li>
 *   <li><strong>Feign (ms-auth):</strong> delega la validación de permisos en
 *       {@code ms-auth} a través del cliente Feign {@link AuthFeignClient}. Antes
 *       de ejecutar cualquier operación de escritura (crear, actualizar,
 *       cambiarEstado) se invoca la validación de acceso.</li>
 *   <li><strong>Publicación a Kafka:</strong> toda operación de creación,
 *       actualización y cambio de estado de una sucursal produce un evento
 *       {@link SucursalEventDTO} que se envía al tópico {@code sucursal-events}
 *       para su consumo por otros microservicios.</li>
 * </ul>
 *
 * @see SucursalService
 * @see SucursalRepository
 * @see AuthFeignClient
 * @see cl.triskeledu.sucursales.dto.event.SucursalEventDTO
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SucursalServiceImpl implements SucursalService {

    private final AuthFeignClient authFeignClient;
    private final SucursalRepository sucursalRepository;
    private final SucursalMapper sucursalMapper;
    private final KafkaTemplate<String, SucursalEventDTO> kafkaTemplate;

    private static final String TOPIC = "sucursal-events";

    /**
     * Crea una nueva sucursal con {@code activa=true}, valida permisos de escritura
     * vía ms-auth y publica un evento {@code sucursal-events} en Kafka para que los
     * microservicios consumidores actualicen sus proyecciones locales (CQRS).
     */
    @Override
    @Transactional
    public SucursalResponseDTO crear(Long credencialId, SucursalRequestDTO dto) {
        log.info("Creando sucursal: {}", dto.getNombre());
        PermisoResponseDTO permiso = validarAccesoConFallback(credencialId, "SUCURSALES", "ESCRITURA");
        if (!permiso.isPermitido()) {
            throw new AccesoDenegadoException("No tienes permisos para crear sucursales.");
        }

        Sucursal sucursal = sucursalMapper.toEntity(dto);
        sucursal.setActiva(true);

        Sucursal saved = sucursalRepository.save(sucursal);
        log.info("Sucursal creada con ID: {}", saved.getId());

        SucursalEventDTO event = SucursalEventDTO.builder()
                .id(saved.getId())
                .nombre(saved.getNombre())
                .direccion(saved.getDireccion())
                .activa(saved.isActiva())
                .build();
        kafkaTemplate.send(TOPIC, String.valueOf(saved.getId()), event);
        log.info("Evento Kafka enviado [sucursal creada]: id={}", saved.getId());

        return sucursalMapper.toResponseDTO(saved);
    }

    @Override
    public SucursalResponseDTO getById(Long id) {
        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new SucursalNotFoundException("Sucursal no encontrada con ID: " + id));
        return sucursalMapper.toResponseDTO(sucursal);
    }

    @Override
    public List<SucursalResponseDTO> listarActivas() {
        return sucursalRepository.findByActivaTrueOrderByNombreAsc().stream()
                .map(sucursalMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SucursalResponseDTO> listarTodas() {
        return sucursalRepository.findAll().stream()
                .map(sucursalMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    /**
     * Actualiza una sucursal existente, valida permisos de escritura vía ms-auth
     * y publica un evento de actualización en Kafka para sincronizar las
     * proyecciones locales en los microservicios consumidores.
     */
    @Override
    @Transactional
    public SucursalResponseDTO actualizar(Long credencialId, Long id, SucursalRequestDTO dto) {
        log.info("Actualizando sucursal ID: {}", id);
        PermisoResponseDTO permiso = validarAccesoConFallback(credencialId, "SUCURSALES", "ESCRITURA");
        if (!permiso.isPermitido()) {
            throw new AccesoDenegadoException("No tienes permisos para actualizar sucursales.");
        }

        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new SucursalNotFoundException("Sucursal no encontrada con ID: " + id));

        sucursalMapper.updateEntityFromDto(dto, sucursal);

        Sucursal updated = sucursalRepository.save(sucursal);

        SucursalEventDTO event = SucursalEventDTO.builder()
                .id(updated.getId())
                .nombre(updated.getNombre())
                .direccion(updated.getDireccion())
                .activa(updated.isActiva())
                .build();
        kafkaTemplate.send(TOPIC, String.valueOf(updated.getId()), event);
        log.info("Evento Kafka enviado [sucursal actualizada]: id={}", updated.getId());

        return sucursalMapper.toResponseDTO(updated);
    }

    /**
     * Habilita o deshabilita una sucursal (soft-disable mediante el flag
     * {@code activa}), valida permisos vía ms-auth y publica el evento de cambio
     * de estado en Kafka para que los consumidores reflejen la nueva disponibilidad
     * en sus proyecciones.
     */
    @Override
    @Transactional
    public SucursalResponseDTO cambiarEstado(Long credencialId, Long id, Boolean activa) {
        log.info("Cambiando estado de sucursal ID: {} a activa={}", id, activa);
        PermisoResponseDTO permiso = validarAccesoConFallback(credencialId, "SUCURSALES", "ESCRITURA");
        if (!permiso.isPermitido()) {
            throw new AccesoDenegadoException("No tienes permisos para cambiar el estado de sucursales.");
        }

        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new SucursalNotFoundException("Sucursal no encontrada con ID: " + id));

        sucursal.setActiva(activa);
        Sucursal updated = sucursalRepository.save(sucursal);

        log.info("Estado actualizado correctamente para sucursal ID: {}", id);

        SucursalEventDTO event = SucursalEventDTO.builder()
                .id(updated.getId())
                .nombre(updated.getNombre())
                .direccion(updated.getDireccion())
                .activa(updated.isActiva())
                .build();
        kafkaTemplate.send(TOPIC, String.valueOf(updated.getId()), event);
        log.info("Evento Kafka enviado [sucursal cambio estado]: id={}", updated.getId());

        return sucursalMapper.toResponseDTO(updated);
    }

    /**
     * Valida permisos de acceso contra ms-auth vía Feign. Si el servicio de
     * autorización no está disponible, opera en modo degradado otorgando acceso
     * por defecto ({@code permitido=true}) y registrando una advertencia en el log.
     *
     * @param credencialId identificador de la credencial del usuario
     * @param modulo       módulo sobre el que se solicita el permiso
     * @param accion       acción a validar (LECTURA, ESCRITURA)
     * @return {@link PermisoResponseDTO} con el resultado de la validación o
     *         acceso concedido por defecto en caso de fallback
     */
    private PermisoResponseDTO validarAccesoConFallback(Long credencialId, String modulo, String accion) {
        try {
            ResponseEntity<PermisoResponseDTO> response = authFeignClient.validarAcceso(credencialId, modulo, accion);
            PermisoResponseDTO permiso = response.getBody();
            if (permiso != null) {
                return permiso;
            }
        } catch (Exception e) {
            log.warn("{} - No se pudo validar acceso con ms-auth: {}. Operacion en modo degradado.",
                     getClass().getSimpleName(), e.getMessage());
        }
        return PermisoResponseDTO.builder()
                .permitido(true)
                .mensaje("Validacion no disponible - modo degradado")
                .build();
    }
}
