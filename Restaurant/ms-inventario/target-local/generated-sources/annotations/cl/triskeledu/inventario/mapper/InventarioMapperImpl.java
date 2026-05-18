package cl.triskeledu.inventario.mapper;

import cl.triskeledu.inventario.dto.request.InsumoRequestDTO;
import cl.triskeledu.inventario.dto.response.InsumoResponseDTO;
import cl.triskeledu.inventario.dto.response.MovimientoResponseDTO;
import cl.triskeledu.inventario.entity.Insumo;
import cl.triskeledu.inventario.entity.MovimientoInventario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-17T20:45:51-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.2 (Red Hat, Inc.)"
)
@Component
public class InventarioMapperImpl implements InventarioMapper {

    @Override
    public InsumoResponseDTO toInsumoResponseDTO(Insumo insumo) {
        if ( insumo == null ) {
            return null;
        }

        InsumoResponseDTO.InsumoResponseDTOBuilder insumoResponseDTO = InsumoResponseDTO.builder();

        insumoResponseDTO.id( insumo.getId() );
        insumoResponseDTO.sucursalId( insumo.getSucursalId() );
        insumoResponseDTO.nombre( insumo.getNombre() );
        insumoResponseDTO.unidadMedida( insumo.getUnidadMedida() );
        insumoResponseDTO.stockActual( insumo.getStockActual() );
        insumoResponseDTO.stockMinimo( insumo.getStockMinimo() );
        insumoResponseDTO.creadoEn( insumo.getCreadoEn() );
        insumoResponseDTO.actualizadoEn( insumo.getActualizadoEn() );

        return insumoResponseDTO.build();
    }

    @Override
    public Insumo toInsumoEntity(InsumoRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Insumo.InsumoBuilder insumo = Insumo.builder();

        insumo.sucursalId( dto.getSucursalId() );
        insumo.nombre( dto.getNombre() );
        insumo.unidadMedida( dto.getUnidadMedida() );
        insumo.stockMinimo( dto.getStockMinimo() );

        return insumo.build();
    }

    @Override
    public void updateInsumoFromDto(InsumoRequestDTO dto, Insumo entity) {
        if ( dto == null ) {
            return;
        }

        entity.setSucursalId( dto.getSucursalId() );
        entity.setNombre( dto.getNombre() );
        entity.setUnidadMedida( dto.getUnidadMedida() );
        entity.setStockMinimo( dto.getStockMinimo() );
    }

    @Override
    public MovimientoResponseDTO toMovimientoResponseDTO(MovimientoInventario movimiento) {
        if ( movimiento == null ) {
            return null;
        }

        MovimientoResponseDTO.MovimientoResponseDTOBuilder movimientoResponseDTO = MovimientoResponseDTO.builder();

        movimientoResponseDTO.id( movimiento.getId() );
        movimientoResponseDTO.insumoId( movimiento.getInsumoId() );
        movimientoResponseDTO.tipo( movimiento.getTipo() );
        movimientoResponseDTO.cantidad( movimiento.getCantidad() );
        movimientoResponseDTO.referencia( movimiento.getReferencia() );
        movimientoResponseDTO.creadoEn( movimiento.getCreadoEn() );

        return movimientoResponseDTO.build();
    }
}
