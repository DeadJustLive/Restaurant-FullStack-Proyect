package cl.triskeledu.pagos.service.impl;

import cl.triskeledu.pagos.dto.event.PagoEventDTO;
import cl.triskeledu.pagos.dto.request.PagoRequestDTO;
import cl.triskeledu.pagos.dto.response.PagoResponseDTO;
import cl.triskeledu.pagos.entity.enums.EstadoPago;
import cl.triskeledu.pagos.exception.EstadoPagoInvalidoException;
import cl.triskeledu.pagos.mapper.PagoMapper;
import cl.triskeledu.pagos.service.PagoService;
import cl.triskeledu.pagos.entity.Pago;
import cl.triskeledu.pagos.repository.PagoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import cl.triskeledu.pagos.client.AuthFeignClient;
import cl.triskeledu.pagos.dto.response.PermisoResponseDTO;
import cl.triskeledu.pagos.exception.AccesoDenegadoException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Implementación del servicio de pagos ({@link PagoService}).
 *
 * <h2>Ciclo de vida del pago</h2>
 * <pre>
 * PENDIENTE ──► APROBADO ──► REEMBOLSADO
 *           └─► RECHAZADO
 * </pre>
 * Un pago se crea en estado {@code PENDIENTE}. Desde ahí puede transicionar a
 * {@code APROBADO} o {@code RECHAZADO}. Un pago {@code APROBADO} puede
 * posteriormente reembolsarse, pasando a {@code REEMBOLSADO}. Las transiciones
 * no contempladas en {@link #TRANSICIONES_VALIDAS} son rechazadas con
 * {@link cl.triskeledu.pagos.exception.EstadoPagoInvalidoException}.
 *
 * <h2>Máquina de estados: {@code TRANSICIONES_VALIDAS}</h2>
 * {@code EnumMap<EstadoPago, Set<EstadoPago>>} que define los saltos permitidos
 * entre estados. Se inicializa en un bloque {@code static} con las reglas:
 * <ul>
 *   <li>{@code PENDIENTE → [APROBADO, RECHAZADO]}</li>
 *   <li>{@code APROBADO  → [REEMBOLSADO]}</li>
 * </ul>
 *
 * <h2>Kafka :: topic {@code pago-events}</h2>
 * Cada operación que modifica el estado del pago publica un mensaje en el topic
 * {@code pago-events}. El microservicio {@code ms-reportes} consume estos eventos
 * para generar reportes financieros consolidados.
 *
 * <h2>Feign :: cliente {@code AuthFeignClient}</h2>
 * Las operaciones protegidas delegan la validación de acceso en el
 * microservicio {@code ms-auth} a través de Feign. Si {@code ms-auth} no está
 * disponible, el servicio opera en modo degradado (ver
 * {@link #validarAccesoConFallback(Long, String, String)}).
 *
 * @see PagoService
 * @see cl.triskeledu.pagos.entity.enums.EstadoPago
 * @see cl.triskeledu.pagos.client.AuthFeignClient
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PagoServiceImpl implements PagoService {

    private static final Map<EstadoPago, Set<EstadoPago>> TRANSICIONES_VALIDAS;

    static {
        TRANSICIONES_VALIDAS = new EnumMap<>(EstadoPago.class);
        TRANSICIONES_VALIDAS.put(EstadoPago.PENDIENTE, EnumSet.of(EstadoPago.APROBADO, EstadoPago.RECHAZADO));
        TRANSICIONES_VALIDAS.put(EstadoPago.APROBADO, EnumSet.of(EstadoPago.REEMBOLSADO));
    }

    private static final String TOPIC = "pago-events";

    private final AuthFeignClient authFeignClient;
    private final KafkaTemplate<String, PagoEventDTO> kafkaTemplate;
    private final PagoRepository pagoRepository;
    private final PagoMapper pagoMapper;

    /**
     * Crea un pago en estado {@code PENDIENTE} (happy path) y publica el evento
     * {@code PAGO_CREATED} en el topic {@code pago-events}. La validación de
     * permisos se delega en {@link #validarAccesoConFallback}.
     */
    @Override
    @Transactional
    public PagoResponseDTO iniciarPago(Long credencialId, PagoRequestDTO dto) {
        log.info("Iniciando pago mockeado (Happy Path) para pedido {}", dto.getPedidoId());
        PermisoResponseDTO permiso = validarAccesoConFallback(credencialId, "PAGOS", "ESCRITURA");
        if (!permiso.isPermitido()) {
            throw new AccesoDenegadoException("No tienes permisos para gestionar pagos.");
        }
        Pago pago = Pago.builder()
                .pedidoId(dto.getPedidoId())
                .monto(dto.getMonto())
                .metodo(dto.getMetodo())
                .estado(EstadoPago.PENDIENTE) // Lo marcamos como completado de inmediato para el happy path
                .build();
        
        Pago saved = pagoRepository.save(pago);
        log.info("[Kafka] Enviando evento PAGO_CREATED para pago {}", saved.getId());
        kafkaTemplate.send(TOPIC, String.valueOf(saved.getId()), PagoEventDTO.builder()
                .pagoId(saved.getId())
                .pedidoId(saved.getPedidoId())
                .estado("PAGO_CREATED")
                .monto(saved.getMonto().doubleValue())
                .metodo(saved.getMetodo().name())
                .build());
        return pagoMapper.toResponseDTO(saved);
    }

    /**
     * Valida que la transición al {@code estadoFinal} esté permitida según
     * {@link #TRANSICIONES_VALIDAS}; si es válida, persiste el nuevo estado,
     * asigna el ID de transacción y publica el cambio en el topic
     * {@code pago-events} con prefijo {@code PAGO_}.
     */
    @Override
    @Transactional
    public PagoResponseDTO confirmarPago(Long credencialId, Long id, String transaccionId, EstadoPago estadoFinal) {
        log.info("Confirmando pago {} con transaccion {} y estado {}", id, transaccionId, estadoFinal);
        PermisoResponseDTO permiso = validarAccesoConFallback(credencialId, "PAGOS", "ESCRITURA");
        if (!permiso.isPermitido()) {
            throw new AccesoDenegadoException("No tienes permisos para gestionar pagos.");
        }
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new cl.triskeledu.pagos.exception.PagoNotFoundException("Pago no encontrado con ID: " + id));

        EstadoPago estadoActual = pago.getEstado();
        Set<EstadoPago> estadosPermitidos = TRANSICIONES_VALIDAS.getOrDefault(
                estadoActual, EnumSet.noneOf(EstadoPago.class));

        if (!estadosPermitidos.contains(estadoFinal)) {
            throw new EstadoPagoInvalidoException("No se puede cambiar de " + estadoActual + " a " + estadoFinal);
        }

        pago.setEstado(estadoFinal);
        pago.setTransaccionId(transaccionId);
        Pago saved = pagoRepository.save(pago);
        log.info("[Kafka] Enviando evento PAGO_STATUS_CHANGED para pago {} estado {}", saved.getId(), saved.getEstado().name());
        kafkaTemplate.send(TOPIC, String.valueOf(saved.getId()), PagoEventDTO.builder()
                .pagoId(saved.getId())
                .pedidoId(saved.getPedidoId())
                .estado("PAGO_" + saved.getEstado().name())
                .monto(saved.getMonto().doubleValue())
                .metodo(saved.getMetodo().name())
                .build());
        return pagoMapper.toResponseDTO(saved);
    }

    @Override
    public PagoResponseDTO getById(Long id) {
        log.info("Consultando pago ID {}", id);
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new cl.triskeledu.pagos.exception.PagoNotFoundException("Pago no encontrado con ID: " + id));
        return pagoMapper.toResponseDTO(pago);
    }

    @Override
    public List<PagoResponseDTO> listarPorPedido(Long pedidoId) {
        log.info("Listando pagos por pedido {}", pedidoId);
        return pagoRepository.findByPedidoId(pedidoId).stream()
                .map(pagoMapper::toResponseDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    public List<PagoResponseDTO> listarTodos() {
        log.info("Listando todos los pagos");
        return pagoRepository.findAll().stream()
                .map(pagoMapper::toResponseDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    /**
     * Patrón de modo degradado: intenta validar el acceso llamando a
     * {@code ms-auth} vía Feign. Si el servicio remoto no responde (excepción
     * o {@code null}), retorna un permiso positivo por defecto para no bloquear
     * la operación, registrando la advertencia en el log.
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
