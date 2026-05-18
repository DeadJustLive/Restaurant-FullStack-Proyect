package cl.triskeledu.reportes.mapper;

import cl.triskeledu.reportes.dto.response.ReporteSnapshotResponseDTO;
import cl.triskeledu.reportes.entity.ReporteSnapshot;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-17T21:34:29-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.2 (Red Hat, Inc.)"
)
@Component
public class ReporteMapperImpl implements ReporteMapper {

    @Override
    public ReporteSnapshotResponseDTO toResponseDTO(ReporteSnapshot entity) {
        if ( entity == null ) {
            return null;
        }

        ReporteSnapshotResponseDTO.ReporteSnapshotResponseDTOBuilder reporteSnapshotResponseDTO = ReporteSnapshotResponseDTO.builder();

        reporteSnapshotResponseDTO.id( entity.getId() );
        reporteSnapshotResponseDTO.sucursalId( entity.getSucursalId() );
        reporteSnapshotResponseDTO.tipo( entity.getTipo() );
        reporteSnapshotResponseDTO.dataJson( entity.getDataJson() );
        reporteSnapshotResponseDTO.creadoEn( entity.getCreadoEn() );

        return reporteSnapshotResponseDTO.build();
    }
}
