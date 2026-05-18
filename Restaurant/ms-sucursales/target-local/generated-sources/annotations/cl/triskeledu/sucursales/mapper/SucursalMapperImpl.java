package cl.triskeledu.sucursales.mapper;

import cl.triskeledu.sucursales.dto.request.SucursalRequestDTO;
import cl.triskeledu.sucursales.dto.response.SucursalResponseDTO;
import cl.triskeledu.sucursales.entity.Sucursal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-17T21:34:23-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.2 (Red Hat, Inc.)"
)
@Component
public class SucursalMapperImpl implements SucursalMapper {

    @Override
    public SucursalResponseDTO toResponseDTO(Sucursal sucursal) {
        if ( sucursal == null ) {
            return null;
        }

        SucursalResponseDTO.SucursalResponseDTOBuilder sucursalResponseDTO = SucursalResponseDTO.builder();

        sucursalResponseDTO.id( sucursal.getId() );
        sucursalResponseDTO.nombre( sucursal.getNombre() );
        sucursalResponseDTO.direccion( sucursal.getDireccion() );
        sucursalResponseDTO.telefono( sucursal.getTelefono() );
        sucursalResponseDTO.activa( sucursal.isActiva() );
        sucursalResponseDTO.creadoEn( sucursal.getCreadoEn() );
        sucursalResponseDTO.actualizadoEn( sucursal.getActualizadoEn() );

        return sucursalResponseDTO.build();
    }

    @Override
    public Sucursal toEntity(SucursalRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Sucursal.SucursalBuilder sucursal = Sucursal.builder();

        sucursal.nombre( dto.getNombre() );
        sucursal.direccion( dto.getDireccion() );
        sucursal.telefono( dto.getTelefono() );

        return sucursal.build();
    }

    @Override
    public void updateEntityFromDto(SucursalRequestDTO dto, Sucursal target) {
        if ( dto == null ) {
            return;
        }

        target.setNombre( dto.getNombre() );
        target.setDireccion( dto.getDireccion() );
        target.setTelefono( dto.getTelefono() );
    }
}
