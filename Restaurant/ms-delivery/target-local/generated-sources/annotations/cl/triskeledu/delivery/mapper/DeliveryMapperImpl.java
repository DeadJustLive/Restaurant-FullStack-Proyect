package cl.triskeledu.delivery.mapper;

import cl.triskeledu.delivery.dto.request.DeliveryRequestDTO;
import cl.triskeledu.delivery.dto.response.DeliveryResponseDTO;
import cl.triskeledu.delivery.entity.Delivery;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-17T21:34:27-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.2 (Red Hat, Inc.)"
)
@Component
public class DeliveryMapperImpl implements DeliveryMapper {

    @Override
    public DeliveryResponseDTO toResponseDTO(Delivery delivery) {
        if ( delivery == null ) {
            return null;
        }

        DeliveryResponseDTO.DeliveryResponseDTOBuilder deliveryResponseDTO = DeliveryResponseDTO.builder();

        deliveryResponseDTO.id( delivery.getId() );
        deliveryResponseDTO.pedidoId( delivery.getPedidoId() );
        deliveryResponseDTO.repartidorId( delivery.getRepartidorId() );
        deliveryResponseDTO.direccionEntrega( delivery.getDireccionEntrega() );
        deliveryResponseDTO.estado( delivery.getEstado() );
        deliveryResponseDTO.observaciones( delivery.getObservaciones() );
        deliveryResponseDTO.creadoEn( delivery.getCreadoEn() );
        deliveryResponseDTO.actualizadoEn( delivery.getActualizadoEn() );

        return deliveryResponseDTO.build();
    }

    @Override
    public Delivery toEntity(DeliveryRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Delivery.DeliveryBuilder delivery = Delivery.builder();

        delivery.pedidoId( dto.getPedidoId() );
        delivery.direccionEntrega( dto.getDireccionEntrega() );

        return delivery.build();
    }
}
