package cl.triskeledu.reportes.mapper;

import cl.triskeledu.reportes.dto.response.ReporteSnapshotResponseDTO;
import cl.triskeledu.reportes.entity.ReporteSnapshot;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-18T13:33:19-0400",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class ReporteMapperImpl implements ReporteMapper {

    @Override
    public ReporteSnapshotResponseDTO toResponseDTO(ReporteSnapshot entity) {
        if ( entity == null ) {
            return null;
        }

        ReporteSnapshotResponseDTO.ReporteSnapshotResponseDTOBuilder reporteSnapshotResponseDTO = ReporteSnapshotResponseDTO.builder();

        reporteSnapshotResponseDTO.creadoEn( entity.getCreadoEn() );
        reporteSnapshotResponseDTO.dataJson( entity.getDataJson() );
        reporteSnapshotResponseDTO.id( entity.getId() );
        reporteSnapshotResponseDTO.sucursalId( entity.getSucursalId() );
        reporteSnapshotResponseDTO.tipo( entity.getTipo() );

        return reporteSnapshotResponseDTO.build();
    }
}
