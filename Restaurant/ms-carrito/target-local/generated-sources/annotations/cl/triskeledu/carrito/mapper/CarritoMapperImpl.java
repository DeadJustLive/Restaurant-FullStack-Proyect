package cl.triskeledu.carrito.mapper;

import cl.triskeledu.carrito.dto.response.CarritoItemResponseDTO;
import cl.triskeledu.carrito.dto.response.CarritoResponseDTO;
import cl.triskeledu.carrito.entity.Carrito;
import cl.triskeledu.carrito.entity.CarritoItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-17T21:34:25-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.2 (Red Hat, Inc.)"
)
@Component
public class CarritoMapperImpl implements CarritoMapper {

    @Override
    public CarritoResponseDTO toResponseDTO(Carrito carrito) {
        if ( carrito == null ) {
            return null;
        }

        CarritoResponseDTO.CarritoResponseDTOBuilder carritoResponseDTO = CarritoResponseDTO.builder();

        carritoResponseDTO.id( carrito.getId() );
        carritoResponseDTO.usuarioId( carrito.getUsuarioId() );
        carritoResponseDTO.sucursalId( carrito.getSucursalId() );
        carritoResponseDTO.total( carrito.getTotal() );
        carritoResponseDTO.items( carritoItemListToCarritoItemResponseDTOList( carrito.getItems() ) );
        carritoResponseDTO.creadoEn( carrito.getCreadoEn() );
        carritoResponseDTO.actualizadoEn( carrito.getActualizadoEn() );

        return carritoResponseDTO.build();
    }

    @Override
    public CarritoItemResponseDTO toItemResponseDTO(CarritoItem item) {
        if ( item == null ) {
            return null;
        }

        CarritoItemResponseDTO.CarritoItemResponseDTOBuilder carritoItemResponseDTO = CarritoItemResponseDTO.builder();

        carritoItemResponseDTO.id( item.getId() );
        carritoItemResponseDTO.menuItemId( item.getMenuItemId() );
        carritoItemResponseDTO.precioUnitario( item.getPrecioUnitario() );
        carritoItemResponseDTO.cantidad( item.getCantidad() );
        carritoItemResponseDTO.subtotal( item.getSubtotal() );

        return carritoItemResponseDTO.build();
    }

    protected List<CarritoItemResponseDTO> carritoItemListToCarritoItemResponseDTOList(List<CarritoItem> list) {
        if ( list == null ) {
            return null;
        }

        List<CarritoItemResponseDTO> list1 = new ArrayList<CarritoItemResponseDTO>( list.size() );
        for ( CarritoItem carritoItem : list ) {
            list1.add( toItemResponseDTO( carritoItem ) );
        }

        return list1;
    }
}
