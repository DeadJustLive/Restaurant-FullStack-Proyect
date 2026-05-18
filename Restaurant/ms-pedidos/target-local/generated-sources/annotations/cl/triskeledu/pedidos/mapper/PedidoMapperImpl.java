package cl.triskeledu.pedidos.mapper;

import cl.triskeledu.pedidos.dto.response.PedidoItemResponseDTO;
import cl.triskeledu.pedidos.dto.response.PedidoResponseDTO;
import cl.triskeledu.pedidos.entity.Pedido;
import cl.triskeledu.pedidos.entity.PedidoItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-17T20:45:46-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.2 (Red Hat, Inc.)"
)
@Component
public class PedidoMapperImpl implements PedidoMapper {

    @Override
    public PedidoResponseDTO toResponseDTO(Pedido pedido) {
        if ( pedido == null ) {
            return null;
        }

        PedidoResponseDTO.PedidoResponseDTOBuilder pedidoResponseDTO = PedidoResponseDTO.builder();

        pedidoResponseDTO.id( pedido.getId() );
        pedidoResponseDTO.numeroPedido( pedido.getNumeroPedido() );
        pedidoResponseDTO.usuarioId( pedido.getUsuarioId() );
        pedidoResponseDTO.sucursalId( pedido.getSucursalId() );
        pedidoResponseDTO.estado( pedido.getEstado() );
        pedidoResponseDTO.tipo( pedido.getTipo() );
        pedidoResponseDTO.total( pedido.getTotal() );
        pedidoResponseDTO.notas( pedido.getNotas() );
        pedidoResponseDTO.items( pedidoItemListToPedidoItemResponseDTOList( pedido.getItems() ) );
        pedidoResponseDTO.creadoEn( pedido.getCreadoEn() );
        pedidoResponseDTO.actualizadoEn( pedido.getActualizadoEn() );

        return pedidoResponseDTO.build();
    }

    @Override
    public PedidoItemResponseDTO toItemResponseDTO(PedidoItem item) {
        if ( item == null ) {
            return null;
        }

        PedidoItemResponseDTO.PedidoItemResponseDTOBuilder pedidoItemResponseDTO = PedidoItemResponseDTO.builder();

        pedidoItemResponseDTO.id( item.getId() );
        pedidoItemResponseDTO.menuItemId( item.getMenuItemId() );
        pedidoItemResponseDTO.nombreSnapshot( item.getNombreSnapshot() );
        pedidoItemResponseDTO.precioUnitario( item.getPrecioUnitario() );
        pedidoItemResponseDTO.cantidad( item.getCantidad() );
        pedidoItemResponseDTO.subtotal( item.getSubtotal() );

        return pedidoItemResponseDTO.build();
    }

    protected List<PedidoItemResponseDTO> pedidoItemListToPedidoItemResponseDTOList(List<PedidoItem> list) {
        if ( list == null ) {
            return null;
        }

        List<PedidoItemResponseDTO> list1 = new ArrayList<PedidoItemResponseDTO>( list.size() );
        for ( PedidoItem pedidoItem : list ) {
            list1.add( toItemResponseDTO( pedidoItem ) );
        }

        return list1;
    }
}
