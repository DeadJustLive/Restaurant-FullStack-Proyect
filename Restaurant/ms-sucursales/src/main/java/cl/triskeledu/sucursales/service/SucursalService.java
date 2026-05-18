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

    SucursalResponseDTO crear(Long credencialId, SucursalRequestDTO dto);

    SucursalResponseDTO getById(Long id);

    List<SucursalResponseDTO> listarActivas();

    List<SucursalResponseDTO> listarTodas();

    SucursalResponseDTO actualizar(Long credencialId, Long id, SucursalRequestDTO dto);

    SucursalResponseDTO cambiarEstado(Long credencialId, Long id, Boolean activa);
}
