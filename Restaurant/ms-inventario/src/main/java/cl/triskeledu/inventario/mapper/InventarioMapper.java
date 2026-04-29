package cl.triskeledu.inventario.mapper;

import cl.triskeledu.inventario.dto.request.InsumoRequestDTO;
import cl.triskeledu.inventario.dto.response.InsumoResponseDTO;
import cl.triskeledu.inventario.dto.response.MovimientoResponseDTO;
import cl.triskeledu.inventario.entity.Insumo;
import cl.triskeledu.inventario.entity.MovimientoInventario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * =============================================================================
 * MAPPER: InventarioMapper
 * =============================================================================
 */
@Mapper(componentModel = "spring")
public interface InventarioMapper {

    InsumoResponseDTO toInsumoResponseDTO(Insumo insumo);

    Insumo toInsumoEntity(InsumoRequestDTO dto);

    void updateInsumoFromDto(InsumoRequestDTO dto, @MappingTarget Insumo entity);

    MovimientoResponseDTO toMovimientoResponseDTO(MovimientoInventario movimiento);
}
