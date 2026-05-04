package cl.triskeledu.inventario.service.impl;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
@Slf4j
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InsumoRepository insumoRepository;
    
    @Autowired
    private MovimientoRepository movimientoRepository;
    
    @Autowired
    private cl.triskeledu.inventario.mapper.InventarioMapper inventarioMapper;

    @Override
    @Transactional
    public InsumoResponseDTO crearInsumo(InsumoRequestDTO dto) {
        /*
         * INTENCIÓN: Registrar un nuevo insumo en el catálogo de una sucursal.
         *
         * FLUJO IMPLEMENTADO:
         *   1. Validar existencia de la sucursal (ms-sucursales). TODO: Feign
         *   2. Validar que no exista ya un insumo con ese nombre en esa sucursal.
         *   3. Guardar en InsumoRepository con stock_actual = 0.
         */
        log.info("Creando insumo {} en sucursal {}", dto.getNombre(), dto.getSucursalId());
        
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
    public InsumoResponseDTO actualizarInsumo(Long id, InsumoRequestDTO dto) {
        /*
         * INTENCIÓN: Modificar datos básicos del insumo (ej. stock_minimo).
         * NOTA: Nunca modificar el stock_actual desde aquí, solo a través de registrarMovimiento().
         */
        log.info("Actualizando insumo ID {}", id);
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
    public MovimientoResponseDTO registrarMovimiento(MovimientoRequestDTO dto) {
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
        
        // TODO: Notificar si stock_actual <= stock_minimo
        
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
    
}
