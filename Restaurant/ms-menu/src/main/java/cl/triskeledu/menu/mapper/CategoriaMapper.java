package cl.triskeledu.menu.mapper;

import cl.triskeledu.menu.dto.request.CategoriaRequestDTO;
import cl.triskeledu.menu.dto.response.CategoriaResponseDTO;
import cl.triskeledu.menu.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * =============================================================================
 * MAPPER: CategoriaMapper
 * =============================================================================
 */
@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaResponseDTO toResponseDTO(Categoria categoria);

    Categoria toEntity(CategoriaRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activa", ignore = true)
    @Mapping(target = "creadoEn", ignore = true)
    @Mapping(target = "actualizadoEn", ignore = true)
    void updateEntityFromDto(CategoriaRequestDTO dto, @MappingTarget Categoria target);
}
