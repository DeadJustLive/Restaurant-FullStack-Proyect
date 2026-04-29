package cl.triskeledu.carrito.mapper;

import cl.triskeledu.carrito.dto.response.CarritoItemResponseDTO;
import cl.triskeledu.carrito.dto.response.CarritoResponseDTO;
import cl.triskeledu.carrito.entity.Carrito;
import cl.triskeledu.carrito.entity.CarritoItem;
import org.mapstruct.Mapper;

/**
 * =============================================================================
 * MAPPER: CarritoMapper
 * =============================================================================
 */
@Mapper(componentModel = "spring")
public interface CarritoMapper {

    CarritoResponseDTO toResponseDTO(Carrito carrito);

    CarritoItemResponseDTO toItemResponseDTO(CarritoItem item);
}
