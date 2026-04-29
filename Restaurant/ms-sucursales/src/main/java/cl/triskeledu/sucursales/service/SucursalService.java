package cl.triskeledu.sucursales.service;

import cl.triskeledu.sucursales.dto.request.SucursalRequestDTO;
import cl.triskeledu.sucursales.dto.response.SucursalResponseDTO;

import java.util.List;

/**
 * =============================================================================
 * SERVICE INTERFACE: SucursalService
 * =============================================================================
 */
public interface SucursalService {

    SucursalResponseDTO crear(SucursalRequestDTO dto);

    SucursalResponseDTO getById(Long id);

    List<SucursalResponseDTO> listarActivas();

    List<SucursalResponseDTO> listarTodas();

    SucursalResponseDTO actualizar(Long id, SucursalRequestDTO dto);

    SucursalResponseDTO cambiarEstado(Long id, Boolean activa);
}
