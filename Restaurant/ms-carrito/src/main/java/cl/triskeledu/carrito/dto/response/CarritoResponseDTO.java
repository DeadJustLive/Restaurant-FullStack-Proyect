package cl.triskeledu.carrito.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * =============================================================================
 * DTO RESPONSE: CarritoResponseDTO
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarritoResponseDTO {

    private Long id;
    private Long usuarioId;
    private Long sucursalId;
    private BigDecimal total;
    private List<CarritoItemResponseDTO> items;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;
}
