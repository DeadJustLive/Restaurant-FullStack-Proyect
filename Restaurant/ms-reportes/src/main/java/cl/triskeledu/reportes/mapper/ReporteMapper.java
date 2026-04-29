package cl.triskeledu.reportes.mapper;

import cl.triskeledu.reportes.dto.response.ReporteSnapshotResponseDTO;
import cl.triskeledu.reportes.entity.ReporteSnapshot;
import org.mapstruct.Mapper;

/**
 * =============================================================================
 * MAPPER: ReporteMapper
 * =============================================================================
 */
@Mapper(componentModel = "spring")
public interface ReporteMapper {

    ReporteSnapshotResponseDTO toResponseDTO(ReporteSnapshot entity);
}
