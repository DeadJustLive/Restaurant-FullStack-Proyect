package cl.triskeledu.inventario.service.impl;

import cl.triskeledu.inventario.dto.request.InsumoRequestDTO;
import cl.triskeledu.inventario.dto.request.MovimientoRequestDTO;
import cl.triskeledu.inventario.dto.response.InsumoResponseDTO;
import cl.triskeledu.inventario.dto.response.MovimientoResponseDTO;
import cl.triskeledu.inventario.service.InventarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * =============================================================================
 * SERVICE IMPL: InventarioServiceImpl
 * =============================================================================
 */
@Service
@Slf4j
public class InventarioServiceImpl implements InventarioService {

    @Override
    public InsumoResponseDTO crearInsumo(InsumoRequestDTO dto) {
        /*
         * INTENCIÓN: Registrar un nuevo insumo en el catálogo de una sucursal.
         *
         * FLUJO ESPERADO:
         *   1. Validar existencia de la sucursal (ms-sucursales).
         *   2. Validar que no exista ya un insumo con ese nombre en esa sucursal.
         *   3. Guardar en InsumoRepository con stock_actual = 0.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public InsumoResponseDTO actualizarInsumo(Long id, InsumoRequestDTO dto) {
        /*
         * INTENCIÓN: Modificar datos básicos del insumo (ej. stock_minimo).
         * NOTA: Nunca modificar el stock_actual desde aquí, solo a través de registrarMovimiento().
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public InsumoResponseDTO getInsumoById(Long id) {
        /*
         * INTENCIÓN: Consultar detalle.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public List<InsumoResponseDTO> listarPorSucursal(Long sucursalId) {
        /*
         * INTENCIÓN: Obtener inventario actual de la sucursal.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public MovimientoResponseDTO registrarMovimiento(MovimientoRequestDTO dto) {
        /*
         * INTENCIÓN: Afectar el stock_actual y guardar registro en el Kardex.
         *
         * FLUJO ESPERADO:
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
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public List<MovimientoResponseDTO> historialKardex(Long insumoId) {
        /*
         * INTENCIÓN: Auditoría de movimientos de un insumo específico.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }
}
