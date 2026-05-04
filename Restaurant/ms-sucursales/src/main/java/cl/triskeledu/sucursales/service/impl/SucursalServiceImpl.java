package cl.triskeledu.sucursales.service.impl;

import cl.triskeledu.sucursales.dto.request.SucursalRequestDTO;
import cl.triskeledu.sucursales.dto.response.SucursalResponseDTO;
import cl.triskeledu.sucursales.entity.Sucursal;
import cl.triskeledu.sucursales.exception.SucursalNotFoundException;
import cl.triskeledu.sucursales.mapper.SucursalMapper;
import cl.triskeledu.sucursales.repository.SucursalRepository;
import cl.triskeledu.sucursales.service.SucursalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * =============================================================================
 * SERVICE IMPL: SucursalServiceImpl
 * =============================================================================
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository sucursalRepository;
    private final SucursalMapper sucursalMapper;

    @Override
    @Transactional
    public SucursalResponseDTO crear(SucursalRequestDTO dto) {
        log.info("Creando sucursal: {}", dto.getNombre());

        Sucursal sucursal = sucursalMapper.toEntity(dto);
        sucursal.setActiva(true);

        Sucursal saved = sucursalRepository.save(sucursal);
        log.info("Sucursal creada con ID: {}", saved.getId());
        return sucursalMapper.toResponseDTO(saved);
    }

    @Override
    public SucursalResponseDTO getById(Long id) {
        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new SucursalNotFoundException("Sucursal no encontrada con ID: " + id));
        return sucursalMapper.toResponseDTO(sucursal);
    }

    @Override
    public List<SucursalResponseDTO> listarActivas() {
        return sucursalRepository.findByActivaTrueOrderByNombreAsc().stream()
                .map(sucursalMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SucursalResponseDTO> listarTodas() {
        return sucursalRepository.findAll().stream()
                .map(sucursalMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public SucursalResponseDTO actualizar(Long id, SucursalRequestDTO dto) {
        log.info("Actualizando sucursal ID: {}", id);

        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new SucursalNotFoundException("Sucursal no encontrada con ID: " + id));

        sucursalMapper.updateEntityFromDto(dto, sucursal);

        Sucursal updated = sucursalRepository.save(sucursal);
        return sucursalMapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public SucursalResponseDTO cambiarEstado(Long id, Boolean activa) {
        log.info("Cambiando estado de sucursal ID: {} a activa={}", id, activa);

        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new SucursalNotFoundException("Sucursal no encontrada con ID: " + id));

        sucursal.setActiva(activa);
        Sucursal updated = sucursalRepository.save(sucursal);

        log.info("Estado actualizado correctamente para sucursal ID: {}", id);
        return sucursalMapper.toResponseDTO(updated);
    }
}
