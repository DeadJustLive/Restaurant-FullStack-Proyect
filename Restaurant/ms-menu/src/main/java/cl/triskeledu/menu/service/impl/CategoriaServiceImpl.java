package cl.triskeledu.menu.service.impl;

import cl.triskeledu.menu.dto.request.CategoriaRequestDTO;
import cl.triskeledu.menu.dto.response.CategoriaResponseDTO;
import cl.triskeledu.menu.entity.Categoria;
import cl.triskeledu.menu.exception.CategoriaDuplicadaException;
import cl.triskeledu.menu.exception.CategoriaNotFoundException;
import cl.triskeledu.menu.mapper.CategoriaMapper;
import cl.triskeledu.menu.repository.CategoriaRepository;
import cl.triskeledu.menu.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import cl.triskeledu.menu.client.AuthFeignClient;
import cl.triskeledu.menu.dto.response.PermisoResponseDTO;
import cl.triskeledu.menu.exception.AccesoDenegadoException;
import org.springframework.http.ResponseEntity;
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
    private final AuthFeignClient authFeignClient;

    @Override
    @Transactional
    public CategoriaResponseDTO crear(CategoriaRequestDTO dto) {
        log.info("Creando categoría: {}", dto.getNombre());

        // TODO: Extraer el credencialId real desde el contexto de seguridad (JWT)
        Long currentUserId = 1L; 
        
        PermisoResponseDTO permiso = validarAccesoConFallback(currentUserId, "MENU", "ESCRITURA");
        if (!permiso.isPermitido()) {
            throw new AccesoDenegadoException("No tienes permisos para modificar el menú.");
        }

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

        // TODO: Extraer el credencialId real desde el contexto de seguridad (JWT)
        Long currentUserId = 1L; 
        
        PermisoResponseDTO permiso = validarAccesoConFallback(currentUserId, "MENU", "ESCRITURA");
        if (!permiso.isPermitido()) {
            throw new AccesoDenegadoException("No tienes permisos para modificar el menú.");
        }

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
