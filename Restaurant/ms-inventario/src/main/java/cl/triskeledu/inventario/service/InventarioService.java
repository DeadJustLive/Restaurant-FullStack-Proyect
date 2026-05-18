package cl.triskeledu.inventario.service;

import cl.triskeledu.inventario.dto.request.InsumoRequestDTO;
import cl.triskeledu.inventario.dto.request.MovimientoRequestDTO;
import cl.triskeledu.inventario.dto.response.InsumoResponseDTO;
import cl.triskeledu.inventario.dto.response.MovimientoResponseDTO;

import java.util.List;

/**
 * =============================================================================
 * SERVICE INTERFACE: InventarioService
 * =============================================================================
 */
public interface InventarioService {

    InsumoResponseDTO crearInsumo(Long credencialId, InsumoRequestDTO dto);

    InsumoResponseDTO actualizarInsumo(Long credencialId, Long id, InsumoRequestDTO dto);

    InsumoResponseDTO getInsumoById(Long id);

    List<InsumoResponseDTO> listarPorSucursal(Long sucursalId);

    MovimientoResponseDTO registrarMovimiento(Long credencialId, MovimientoRequestDTO dto);

    List<MovimientoResponseDTO> historialKardex(Long insumoId);

    List<InsumoResponseDTO> listarTodos();
}
