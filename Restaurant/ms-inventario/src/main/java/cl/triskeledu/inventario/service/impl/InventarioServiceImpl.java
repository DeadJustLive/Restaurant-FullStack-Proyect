package cl.triskeledu.inventario.service.impl;

import cl.triskeledu.inventario.dto.event.StockEventDTO;
import cl.triskeledu.inventario.dto.request.InsumoRequestDTO;
import cl.triskeledu.inventario.dto.request.MovimientoRequestDTO;
import cl.triskeledu.inventario.dto.response.InsumoResponseDTO;
import cl.triskeledu.inventario.dto.response.MovimientoResponseDTO;
import cl.triskeledu.inventario.entity.Insumo;
import cl.triskeledu.inventario.entity.MovimientoInventario;
import cl.triskeledu.inventario.entity.enums.TipoMovimiento;
import cl.triskeledu.inventario.repository.InsumoRepository;
import cl.triskeledu.inventario.repository.MovimientoRepository;
import cl.triskeledu.inventario.service.InventarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import cl.triskeledu.inventario.client.AuthFeignClient;
import cl.triskeledu.inventario.dto.response.PermisoResponseDTO;
import cl.triskeledu.inventario.exception.AccesoDenegadoException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * =============================================================================
 * SERVICE IMPL: InventarioServiceImpl
 * =============================================================================
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class InventarioServiceImpl implements InventarioService {

    private static final String TOPIC = "stock-events";

    private final AuthFeignClient authFeignClient;
    private final KafkaTemplate<String, StockEventDTO> kafkaTemplate;
    private final InsumoRepository insumoRepository;
    private final MovimientoRepository movimientoRepository;
    private final cl.triskeledu.inventario.mapper.InventarioMapper inventarioMapper;

    @Override
    @Transactional
    public InsumoResponseDTO crearInsumo(Long credencialId, InsumoRequestDTO dto) {
        /*
         * INTENCIÓN: Registrar un nuevo insumo en el catálogo de una sucursal.
         *
         * FLUJO IMPLEMENTADO:
         *   1. Validar existencia de la sucursal (ms-sucursales). TODO: Feign
         *   2. Validar que no exista ya un insumo con ese nombre en esa sucursal.
         *   3. Guardar en InsumoRepository con stock_actual = 0.
         */
        log.info("Creando insumo {} en sucursal {}", dto.getNombre(), dto.getSucursalId());
        
        PermisoResponseDTO permiso = validarAccesoConFallback(credencialId, "INVENTARIO", "ESCRITURA");
        if (!permiso.isPermitido()) {
            throw new AccesoDenegadoException("No tienes permisos para gestionar el inventario.");
        }

        if (insumoRepository.existsBySucursalIdAndNombreIgnoreCase(dto.getSucursalId(), dto.getNombre())) {
            throw new cl.triskeledu.inventario.exception.InsumoDuplicadoException("El insumo ya existe en esta sucursal");
        }
        
        Insumo insumo = inventarioMapper.toInsumoEntity(dto);
        insumo.setStockActual(BigDecimal.ZERO);
                
        Insumo saved = insumoRepository.save(insumo);
        return inventarioMapper.toInsumoResponseDTO(saved);
    }

    @Override
    @Transactional
    public InsumoResponseDTO actualizarInsumo(Long credencialId, Long id, InsumoRequestDTO dto) {
        log.info("Actualizando insumo ID {}", id);
        PermisoResponseDTO permiso = validarAccesoConFallback(credencialId, "INVENTARIO", "ESCRITURA");
        if (!permiso.isPermitido()) {
            throw new AccesoDenegadoException("No tienes permisos para gestionar el inventario.");
        }
        Insumo insumo = insumoRepository.findById(id)
                .orElseThrow(() -> new cl.triskeledu.inventario.exception.InsumoNotFoundException("Insumo no encontrado"));
                
        inventarioMapper.updateInsumoFromDto(dto, insumo);
        
        Insumo updated = insumoRepository.save(insumo);
        return inventarioMapper.toInsumoResponseDTO(updated);
    }

    @Override
    public InsumoResponseDTO getInsumoById(Long id) {
        /*
         * INTENCIÓN: Consultar detalle.
         */
        Insumo insumo = insumoRepository.findById(id)
                .orElseThrow(() -> new cl.triskeledu.inventario.exception.InsumoNotFoundException("Insumo no encontrado"));
        return inventarioMapper.toInsumoResponseDTO(insumo);
    }

    @Override
    public List<InsumoResponseDTO> listarPorSucursal(Long sucursalId) {
        /*
         * INTENCIÓN: Obtener inventario actual de la sucursal.
         */
        return insumoRepository.findBySucursalId(sucursalId).stream()
                .map(inventarioMapper::toInsumoResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InsumoResponseDTO> listarTodos() {
        return insumoRepository.findAll().stream()
                .map(inventarioMapper::toInsumoResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MovimientoResponseDTO registrarMovimiento(Long credencialId, MovimientoRequestDTO dto) {
        /*
         * INTENCIÓN: Afectar el stock_actual y guardar registro en el Kardex.
         *
         * FLUJO IMPLEMENTADO:
         *   1. Buscar insumo por ID.
         *   2. Si Tipo == ENTRADA -> Sumar cantidad a stock_actual.
         *   3. Si Tipo == SALIDA -> 
         *       a. Verificar si stock_actual >= cantidad.
         *       b. Si no alcanza -> Lanzar StockInsuficienteException.
         *       c. Si alcanza -> Restar cantidad de stock_actual.
         *   4. Guardar cambios en InsumoRepository.
         *   5. Insertar nuevo registro en MovimientoRepository.
         *   6. (Futuro) Evaluar si stock_actual <= stock_minimo y notificar a ms-notificaciones.
         */
        log.info("Registrando movimiento {} para insumo ID {} con cantidad {}", dto.getTipo(), dto.getInsumoId(), dto.getCantidad());
        PermisoResponseDTO permiso = validarAccesoConFallback(credencialId, "INVENTARIO", "ESCRITURA");
        if (!permiso.isPermitido()) {
            throw new AccesoDenegadoException("No tienes permisos para gestionar el inventario.");
        }

        Insumo insumo = insumoRepository.findById(dto.getInsumoId())
                .orElseThrow(() -> new cl.triskeledu.inventario.exception.InsumoNotFoundException("Insumo no encontrado"));
                
        if (dto.getTipo() == TipoMovimiento.ENTRADA) {
            insumo.setStockActual(insumo.getStockActual().add(dto.getCantidad()));
        } else if (dto.getTipo() == TipoMovimiento.SALIDA) {
            if (insumo.getStockActual().compareTo(dto.getCantidad()) < 0) {
                throw new cl.triskeledu.inventario.exception.StockInsuficienteException("Stock insuficiente para realizar la salida");
            }
            insumo.setStockActual(insumo.getStockActual().subtract(dto.getCantidad()));
        }
        
        insumoRepository.save(insumo);
        
        MovimientoInventario movimiento = MovimientoInventario.builder()
                .insumoId(insumo.getId())
                .tipo(dto.getTipo())
                .cantidad(dto.getCantidad())
                .referencia(dto.getReferencia())
                .build();
                
        MovimientoInventario savedMov = movimientoRepository.save(movimiento);
        
        boolean stockBajo = insumo.getStockActual().compareTo(insumo.getStockMinimo()) <= 0;
        log.info("[Kafka] Enviando evento STOCK_MOVEMENT para insumo {}", insumo.getId());
        kafkaTemplate.send(TOPIC, String.valueOf(insumo.getId()), StockEventDTO.builder()
                .insumoId(insumo.getId())
                .sucursalId(insumo.getSucursalId())
                .tipoMovimiento(dto.getTipo().name())
                .cantidad(dto.getCantidad().doubleValue())
                .stockActual(insumo.getStockActual().doubleValue())
                .stockBajo(stockBajo)
                .build());
        
        return inventarioMapper.toMovimientoResponseDTO(savedMov);
    }

    @Override
    public List<MovimientoResponseDTO> historialKardex(Long insumoId) {
        /*
         * INTENCIÓN: Auditoría de movimientos de un insumo específico.
         */
        return movimientoRepository.findByInsumoIdOrderByCreadoEnDesc(insumoId).stream()
                .map(inventarioMapper::toMovimientoResponseDTO)
                .collect(Collectors.toList());
    }

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
