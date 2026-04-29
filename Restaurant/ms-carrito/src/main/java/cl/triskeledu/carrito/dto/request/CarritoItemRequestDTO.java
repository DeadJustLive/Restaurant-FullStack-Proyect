package cl.triskeledu.carrito.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * =============================================================================
 * DTO REQUEST: CarritoItemRequestDTO
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarritoItemRequestDTO {

    @NotNull(message = "El ID del ítem del menú es obligatorio")
    private Long menuItemId;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer cantidad;
}
