package cl.triskeledu.carrito.dto.response;

import lombok.*;

import java.math.BigDecimal;

/**
 * =============================================================================
 * DTO RESPONSE: CarritoItemResponseDTO
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarritoItemResponseDTO {

    private Long id;
    private Long menuItemId;
    private BigDecimal precioUnitario;
    private Integer cantidad;
    private BigDecimal subtotal;
}
