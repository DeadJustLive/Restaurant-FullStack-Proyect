package cl.triskeledu.delivery.service.impl;

import cl.triskeledu.delivery.dto.event.DeliveryEventDTO;
import cl.triskeledu.delivery.dto.request.AsignarRepartidorDTO;
import cl.triskeledu.delivery.dto.request.DeliveryRequestDTO;
import cl.triskeledu.delivery.dto.response.DeliveryResponseDTO;
import cl.triskeledu.delivery.entity.enums.EstadoDelivery;
import cl.triskeledu.delivery.exception.EstadoInvalidoException;
import cl.triskeledu.delivery.mapper.DeliveryMapper;
import cl.triskeledu.delivery.service.DeliveryService;
import cl.triskeledu.delivery.entity.Delivery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import cl.triskeledu.delivery.client.AuthFeignClient;
import cl.triskeledu.delivery.dto.response.PermisoResponseDTO;
import cl.triskeledu.delivery.exception.AccesoDenegadoException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.*;

/**
 * Implementación del servicio de delivery que gestiona el ciclo de vida completo
 * de las entregas del restaurante.
 *
 * <h2>Ciclo de vida y estados del delivery</h2>
 * El delivery transita por 5 estados posibles:
 * <ol>
 *   <li>{@code BUSCANDO_REPARTIDOR} — estado inicial al crear el delivery.</li>
 *   <li>{@code ASIGNADO} — se ha asignado un repartidor al delivery.</li>
 *   <li>{@code EN_CAMINO} — el repartidor está en ruta hacia el cliente.</li>
 *   <li>{@code ENTREGADO} — estado terminal: el pedido fue entregado exitosamente.</li>
 *   <li>{@code CANCELADO} — estado terminal: el delivery puede cancelarse desde
 *       cualquier estado previo (BUSCANDO_REPARTIDOR, ASIGNADO o EN_CAMINO).</li>
 * </ol>
 *
 * <h2>Integración con Kafka</h2>
 * Publica eventos en el tópico {@code delivery-events} cada vez que ocurre un
 * cambio significativo en el estado del delivery. Estos eventos son consumidos
 * por {@code ms-notificaciones} para notificar a los usuarios (cliente y/o
 * repartidor) sobre el progreso de la entrega. Tipos de evento publicados:
 * {@code DELIVERY_CREATED}, {@code DELIVERY_REPARTIDOR_ASIGNADO} y
 * {@code DELIVERY_<ESTADO>} (para cambios de estado genéricos).
 *
 * <h2>Integración con Feign (@use feign-auth-fallback)</h2>
 * Utiliza {@link AuthFeignClient} para comunicarse de forma síncrona con
 * {@code ms-auth} vía Eureka y validar los permisos del usuario antes de cada
 * operación. Si {@code ms-auth} no está disponible, el servicio opera en modo
 * degradado (@use degraded-mode), concediendo acceso por defecto para no
 * bloquear la operación del sistema.
 *
 * <h2>Patrón de autorización</h2>
 * Cada método de escritura invoca {@link #validarAccesoConFallback(Long, String, String)},
 * que encapsula la lógica de validación de permisos con degradación automática.
 *
 * <h2>Validación de máquina de estados</h2>
 * Las transiciones entre estados están gobernadas por el mapa
 * {@link #TRANSICIONES_VALIDAS}, que define estrictamente qué estados pueden
 * transicionar a cuáles. Cualquier transición no permitida lanza
 * {@link cl.triskeledu.delivery.exception.EstadoInvalidoException}.
 *
 * @see DeliveryService
 * @see AuthFeignClient
 * @see cl.triskeledu.delivery.entity.enums.EstadoDelivery
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryServiceImpl implements DeliveryService {

    /**
     * Máquina de estados que define las transiciones válidas entre estados del
     * delivery. Cada clave representa el estado actual y su conjunto de valores
     * indica los estados a los que puede transicionar.
     * <ul>
     *   <li>{@code BUSCANDO_REPARTIDOR} → {@code ASIGNADO}, {@code CANCELADO}</li>
     *   <li>{@code ASIGNADO} → {@code EN_CAMINO}, {@code CANCELADO}</li>
     *   <li>{@code EN_CAMINO} → {@code ENTREGADO}, {@code CANCELADO}</li>
     * </ul>
     * Los estados {@code ENTREGADO} y {@code CANCELADO} son terminales y no tienen
     * transiciones de salida.
     */
    private static final Map<EstadoDelivery, Set<EstadoDelivery>> TRANSICIONES_VALIDAS;

    static {
        TRANSICIONES_VALIDAS = new EnumMap<>(EstadoDelivery.class);
        TRANSICIONES_VALIDAS.put(EstadoDelivery.BUSCANDO_REPARTIDOR, EnumSet.of(EstadoDelivery.ASIGNADO, EstadoDelivery.CANCELADO));
        TRANSICIONES_VALIDAS.put(EstadoDelivery.ASIGNADO, EnumSet.of(EstadoDelivery.EN_CAMINO, EstadoDelivery.CANCELADO));
        TRANSICIONES_VALIDAS.put(EstadoDelivery.EN_CAMINO, EnumSet.of(EstadoDelivery.ENTREGADO, EstadoDelivery.CANCELADO));
    }

    private static final String TOPIC = "delivery-events";

    private final AuthFeignClient authFeignClient;
    private final KafkaTemplate<String, DeliveryEventDTO> kafkaTemplate;
    private final cl.triskeledu.delivery.repository.DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;

    /**
     * Crea un nuevo delivery en estado {@code BUSCANDO_REPARTIDOR} y publica un
     * evento {@code DELIVERY_CREATED} en el tópico {@code delivery-events} para
     * que {@code ms-notificaciones} notifique a los usuarios correspondientes.
     */
    @Override
    public DeliveryResponseDTO crearDelivery(Long credencialId, DeliveryRequestDTO dto) {
        log.info("Creando delivery para pedido {}", dto.getPedidoId());
        PermisoResponseDTO permiso = validarAccesoConFallback(credencialId, "DELIVERY", "ESCRITURA");
        if (!permiso.isPermitido()) {
            throw new AccesoDenegadoException("No tienes permisos para gestionar deliveries.");
        }
        Delivery delivery = Delivery.builder()
                .pedidoId(dto.getPedidoId())
                .direccionEntrega(dto.getDireccionEntrega())
                .estado(EstadoDelivery.BUSCANDO_REPARTIDOR)
                .build();
        Delivery saved = deliveryRepository.save(delivery);
        log.info("[Kafka] Enviando evento DELIVERY_CREATED para delivery {}", saved.getId());
        kafkaTemplate.send(TOPIC, String.valueOf(saved.getId()), DeliveryEventDTO.builder()
                .deliveryId(saved.getId())
                .pedidoId(saved.getPedidoId())
                .estado("DELIVERY_CREATED")
                .repartidorId(saved.getRepartidorId())
                .build());
        return deliveryMapper.toResponseDTO(saved);
    }

    @Override
    public DeliveryResponseDTO getByPedidoId(Long pedidoId) {
        log.info("Consultando delivery para pedido {}", pedidoId);
        Delivery delivery = deliveryRepository.findByPedidoId(pedidoId)
                .orElseThrow(() -> new cl.triskeledu.delivery.exception.DeliveryNotFoundException("Delivery no encontrado"));
        return deliveryMapper.toResponseDTO(delivery);
    }
    
    public DeliveryResponseDTO getById(Long id) {
        log.info("Consultando delivery ID {}", id);
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new cl.triskeledu.delivery.exception.DeliveryNotFoundException("Delivery no encontrado"));
        return deliveryMapper.toResponseDTO(delivery);
    }
    
    public java.util.List<DeliveryResponseDTO> listarTodos() {
        log.info("Listando todos los deliveries");
        return deliveryRepository.findAll().stream()
                .map(deliveryMapper::toResponseDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    /**
     * Asigna un repartidor al delivery identificado y transiciona su estado a
     * {@code ASIGNADO}. Publica un evento {@code DELIVERY_REPARTIDOR_ASIGNADO}
     * en el tópico {@code delivery-events}.
     */
    @Override
    public DeliveryResponseDTO asignarRepartidor(Long credencialId, Long id, AsignarRepartidorDTO dto) {
        log.info("Asignando repartidor {} a delivery {}", dto.getRepartidorId(), id);
        PermisoResponseDTO permiso = validarAccesoConFallback(credencialId, "DELIVERY", "ESCRITURA");
        if (!permiso.isPermitido()) {
            throw new AccesoDenegadoException("No tienes permisos para gestionar deliveries.");
        }
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new cl.triskeledu.delivery.exception.DeliveryNotFoundException("Delivery no encontrado"));
        delivery.setRepartidorId(dto.getRepartidorId());
        delivery.setEstado(EstadoDelivery.ASIGNADO);
        Delivery saved = deliveryRepository.save(delivery);
        log.info("[Kafka] Enviando evento DELIVERY_REPARTIDOR_ASIGNADO para delivery {}", saved.getId());
        kafkaTemplate.send(TOPIC, String.valueOf(saved.getId()), DeliveryEventDTO.builder()
                .deliveryId(saved.getId())
                .pedidoId(saved.getPedidoId())
                .estado("DELIVERY_REPARTIDOR_ASIGNADO")
                .repartidorId(saved.getRepartidorId())
                .build());
        return deliveryMapper.toResponseDTO(saved);
    }

    /**
     * Actualiza el estado de un delivery validando la transición contra la
     * máquina de estados definida en {@link #TRANSICIONES_VALIDAS}. Si la
     * transición no es válida, lanza {@link EstadoInvalidoException}. Publica el
     * nuevo estado como evento en el tópico {@code delivery-events} con prefijo
     * {@code DELIVERY_}.
     */
    @Override
    public DeliveryResponseDTO actualizarEstado(Long credencialId, Long id, EstadoDelivery nuevoEstado, String observaciones) {
        log.info("Actualizando estado de delivery {} a {}", id, nuevoEstado);
        PermisoResponseDTO permiso = validarAccesoConFallback(credencialId, "DELIVERY", "ESCRITURA");
        if (!permiso.isPermitido()) {
            throw new AccesoDenegadoException("No tienes permisos para gestionar deliveries.");
        }
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new cl.triskeledu.delivery.exception.DeliveryNotFoundException("Delivery no encontrado"));

        EstadoDelivery estadoActual = delivery.getEstado();
        Set<EstadoDelivery> estadosPermitidos = TRANSICIONES_VALIDAS.getOrDefault(
                estadoActual, EnumSet.noneOf(EstadoDelivery.class));

        if (!estadosPermitidos.contains(nuevoEstado)) {
            throw new EstadoInvalidoException("No se puede cambiar de " + estadoActual + " a " + nuevoEstado);
        }

        delivery.setEstado(nuevoEstado);
        if (observaciones != null) {
            delivery.setObservaciones(observaciones);
        }
        Delivery saved = deliveryRepository.save(delivery);
        log.info("[Kafka] Enviando evento DELIVERY_STATUS_CHANGED para delivery {} estado {}", saved.getId(), saved.getEstado().name());
        kafkaTemplate.send(TOPIC, String.valueOf(saved.getId()), DeliveryEventDTO.builder()
                .deliveryId(saved.getId())
                .pedidoId(saved.getPedidoId())
                .estado("DELIVERY_" + saved.getEstado().name())
                .repartidorId(saved.getRepartidorId())
                .build());
        return deliveryMapper.toResponseDTO(saved);
    }

    /**
     * Patrón de autorización con degradación automática (@use degraded-mode).
     * Intenta validar los permisos del usuario contra {@code ms-auth} vía Feign.
     * Si el servicio de autenticación no responde (timeout, conexión rechazada,
     * etc.), se registra una advertencia y se retorna un permiso concedido por
     * defecto para no bloquear la operación. Si {@code ms-auth} responde
     * exitosamente pero deniega el acceso, se lanza
     * {@link AccesoDenegadoException} en la capa superior.
     *
     * @param credencialId ID de la credencial a validar
     * @param modulo       módulo sobre el que se solicita el permiso
     * @param accion       acción a realizar (LECTURA, ESCRITURA, etc.)
     * @return {@link PermisoResponseDTO} con el resultado de la validación
     *         o con permiso concedido en modo degradado
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
