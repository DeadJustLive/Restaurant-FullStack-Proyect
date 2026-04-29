package cl.triskeledu.sucursales.mapper;

import cl.triskeledu.sucursales.dto.request.SucursalRequestDTO;
import cl.triskeledu.sucursales.dto.response.SucursalResponseDTO;
import cl.triskeledu.sucursales.entity.Sucursal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * =============================================================================
 * MAPPER: SucursalMapper
 * =============================================================================
 */
@Mapper(componentModel = "spring")
public interface SucursalMapper {

    SucursalResponseDTO toResponseDTO(Sucursal sucursal);

    Sucursal toEntity(SucursalRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activa", ignore = true)
    @Mapping(target = "creadoEn", ignore = true)
    @Mapping(target = "actualizadoEn", ignore = true)
    void updateEntityFromDto(SucursalRequestDTO dto, @MappingTarget Sucursal target);
}
