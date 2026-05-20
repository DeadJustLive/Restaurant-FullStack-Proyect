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
    date = "2026-05-18T13:33:14-0400",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class InventarioMapperImpl implements InventarioMapper {

    @Override
    public InsumoResponseDTO toInsumoResponseDTO(Insumo insumo) {
        if ( insumo == null ) {
            return null;
        }

        InsumoResponseDTO.InsumoResponseDTOBuilder insumoResponseDTO = InsumoResponseDTO.builder();

        insumoResponseDTO.actualizadoEn( insumo.getActualizadoEn() );
        insumoResponseDTO.creadoEn( insumo.getCreadoEn() );
        insumoResponseDTO.id( insumo.getId() );
        insumoResponseDTO.nombre( insumo.getNombre() );
        insumoResponseDTO.stockActual( insumo.getStockActual() );
        insumoResponseDTO.stockMinimo( insumo.getStockMinimo() );
        insumoResponseDTO.sucursalId( insumo.getSucursalId() );
        insumoResponseDTO.unidadMedida( insumo.getUnidadMedida() );

        return insumoResponseDTO.build();
    }

    @Override
    public Insumo toInsumoEntity(InsumoRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Insumo.InsumoBuilder insumo = Insumo.builder();

        insumo.nombre( dto.getNombre() );
        insumo.stockMinimo( dto.getStockMinimo() );
        insumo.sucursalId( dto.getSucursalId() );
        insumo.unidadMedida( dto.getUnidadMedida() );

        return insumo.build();
    }

    @Override
    public void updateInsumoFromDto(InsumoRequestDTO dto, Insumo entity) {
        if ( dto == null ) {
            return;
        }

        entity.setNombre( dto.getNombre() );
        entity.setStockMinimo( dto.getStockMinimo() );
        entity.setSucursalId( dto.getSucursalId() );
        entity.setUnidadMedida( dto.getUnidadMedida() );
    }

    @Override
    public MovimientoResponseDTO toMovimientoResponseDTO(MovimientoInventario movimiento) {
        if ( movimiento == null ) {
            return null;
        }

        MovimientoResponseDTO.MovimientoResponseDTOBuilder movimientoResponseDTO = MovimientoResponseDTO.builder();

        movimientoResponseDTO.cantidad( movimiento.getCantidad() );
        movimientoResponseDTO.creadoEn( movimiento.getCreadoEn() );
        movimientoResponseDTO.id( movimiento.getId() );
        movimientoResponseDTO.insumoId( movimiento.getInsumoId() );
        movimientoResponseDTO.referencia( movimiento.getReferencia() );
        movimientoResponseDTO.tipo( movimiento.getTipo() );

        return movimientoResponseDTO.build();
    }
}
