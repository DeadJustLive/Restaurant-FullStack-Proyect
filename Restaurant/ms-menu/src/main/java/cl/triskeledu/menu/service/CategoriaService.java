package cl.triskeledu.menu.service;

import cl.triskeledu.menu.dto.request.CategoriaRequestDTO;
import cl.triskeledu.menu.dto.response.CategoriaResponseDTO;

import java.util.List;

/**
 * =============================================================================
 * SERVICE INTERFACE: CategoriaService
 * =============================================================================
 */
public interface CategoriaService {

    CategoriaResponseDTO crear(CategoriaRequestDTO dto);

    CategoriaResponseDTO getById(Long id);

    List<CategoriaResponseDTO> listarActivas();

    List<CategoriaResponseDTO> listarTodas();

    CategoriaResponseDTO actualizar(Long id, CategoriaRequestDTO dto);

    CategoriaResponseDTO cambiarEstado(Long id, Boolean activa);
}
