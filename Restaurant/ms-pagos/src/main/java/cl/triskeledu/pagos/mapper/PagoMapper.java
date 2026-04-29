package cl.triskeledu.pagos.mapper;

import cl.triskeledu.pagos.dto.request.PagoRequestDTO;
import cl.triskeledu.pagos.dto.response.PagoResponseDTO;
import cl.triskeledu.pagos.entity.Pago;
import org.mapstruct.Mapper;

/**
 * =============================================================================
 * MAPPER: PagoMapper
 * =============================================================================
 */
@Mapper(componentModel = "spring")
public interface PagoMapper {

    PagoResponseDTO toResponseDTO(Pago pago);

    Pago toEntity(PagoRequestDTO dto);
}
