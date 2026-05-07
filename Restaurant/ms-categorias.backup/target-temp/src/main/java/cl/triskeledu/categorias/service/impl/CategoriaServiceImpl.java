package cl.triskeledu.categorias.service.impl;

import cl.triskeledu.categorias.dto.request.CategoriaRequestDTO;
import cl.triskeledu.categorias.dto.response.CategoriaResponseDTO;
import cl.triskeledu.categorias.entity.Categoria;
import cl.triskeledu.categorias.exception.CategoriaDuplicadaException;
import cl.triskeledu.categorias.exception.CategoriaNotFoundException;
import cl.triskeledu.categorias.mapper.CategoriaMapper;
import cl.triskeledu.categorias.repository.CategoriaRepository;
import cl.triskeledu.categorias.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * =============================================================================
 * SERVICE IMPL: CategoriaServiceImpl
 * =============================================================================
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    @Override
    @Transactional
    public CategoriaResponseDTO crear(CategoriaRequestDTO dto) {
        log.info("Creando categoría: {}", dto.getNombre());

        if (categoriaRepository.existsByNombreIgnoreCase(dto.getNombre())) {
            throw new CategoriaDuplicadaException("Ya existe una categoría con el nombre: " + dto.getNombre());
        }

        Categoria categoria = categoriaMapper.toEntity(dto);
        categoria.setActiva(true);

        Categoria saved = categoriaRepository.save(categoria);
        log.info("Categoría creada con ID: {}", saved.getId());
        return categoriaMapper.toResponseDTO(saved);
    }

    @Override
    public CategoriaResponseDTO getById(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFoundException("Categoría no encontrada con ID: " + id));
        return categoriaMapper.toResponseDTO(categoria);
    }

    @Override
    public List<CategoriaResponseDTO> listarActivas() {
        return categoriaRepository.findByActivaTrueOrderByNombreAsc().stream()
                .map(categoriaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoriaResponseDTO> listarTodas() {
        return categoriaRepository.findAll().stream()
                .map(categoriaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CategoriaResponseDTO actualizar(Long id, CategoriaRequestDTO dto) {
        log.info("Actualizando categoría ID: {}", id);

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFoundException("Categoría no encontrada con ID: " + id));

        // Validar duplicado solo si el nombre cambió
        if (!categoria.getNombre().equalsIgnoreCase(dto.getNombre())
                && categoriaRepository.existsByNombreIgnoreCase(dto.getNombre())) {
            throw new CategoriaDuplicadaException("Ya existe una categoría con el nombre: " + dto.getNombre());
        }

        categoriaMapper.updateEntityFromDto(dto, categoria);
        Categoria updated = categoriaRepository.save(categoria);
        return categoriaMapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public CategoriaResponseDTO cambiarEstado(Long id, Boolean activa) {
        log.info("Cambiando estado de categoría ID: {} a activa={}", id, activa);

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFoundException("Categoría no encontrada con ID: " + id));

        categoria.setActiva(activa);
        Categoria updated = categoriaRepository.save(categoria);

        log.info("Estado actualizado para categoría ID: {}", id);
        return categoriaMapper.toResponseDTO(updated);
    }
}
