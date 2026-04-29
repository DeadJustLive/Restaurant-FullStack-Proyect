package cl.triskeledu.categorias.service;

import cl.triskeledu.categorias.dto.request.CategoriaRequestDTO;
import cl.triskeledu.categorias.dto.response.CategoriaResponseDTO;

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
