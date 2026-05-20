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
    date = "2026-05-19T19:12:10-0400",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class CarritoMapperImpl implements CarritoMapper {

    @Override
    public CarritoResponseDTO toResponseDTO(Carrito carrito) {
        if ( carrito == null ) {
            return null;
        }

        CarritoResponseDTO.CarritoResponseDTOBuilder carritoResponseDTO = CarritoResponseDTO.builder();

        carritoResponseDTO.actualizadoEn( carrito.getActualizadoEn() );
        carritoResponseDTO.creadoEn( carrito.getCreadoEn() );
        carritoResponseDTO.id( carrito.getId() );
        carritoResponseDTO.items( carritoItemListToCarritoItemResponseDTOList( carrito.getItems() ) );
        carritoResponseDTO.sucursalId( carrito.getSucursalId() );
        carritoResponseDTO.total( carrito.getTotal() );
        carritoResponseDTO.usuarioId( carrito.getUsuarioId() );

        return carritoResponseDTO.build();
    }

    @Override
    public CarritoItemResponseDTO toItemResponseDTO(CarritoItem item) {
        if ( item == null ) {
            return null;
        }

        CarritoItemResponseDTO.CarritoItemResponseDTOBuilder carritoItemResponseDTO = CarritoItemResponseDTO.builder();

        carritoItemResponseDTO.cantidad( item.getCantidad() );
        carritoItemResponseDTO.id( item.getId() );
        carritoItemResponseDTO.menuItemId( item.getMenuItemId() );
        carritoItemResponseDTO.precioUnitario( item.getPrecioUnitario() );
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
