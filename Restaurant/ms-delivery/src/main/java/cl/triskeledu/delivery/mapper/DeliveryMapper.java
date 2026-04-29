package cl.triskeledu.delivery.mapper;

import cl.triskeledu.delivery.dto.request.DeliveryRequestDTO;
import cl.triskeledu.delivery.dto.response.DeliveryResponseDTO;
import cl.triskeledu.delivery.entity.Delivery;
import org.mapstruct.Mapper;

/**
 * =============================================================================
 * MAPPER: DeliveryMapper
 * =============================================================================
 */
@Mapper(componentModel = "spring")
public interface DeliveryMapper {

    DeliveryResponseDTO toResponseDTO(Delivery delivery);

    Delivery toEntity(DeliveryRequestDTO dto);
}
