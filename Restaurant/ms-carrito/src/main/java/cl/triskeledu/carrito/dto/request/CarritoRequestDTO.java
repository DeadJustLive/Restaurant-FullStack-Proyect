package cl.triskeledu.carrito.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * =============================================================================
 * DTO REQUEST: CarritoRequestDTO
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarritoRequestDTO {

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;

    @NotNull(message = "El ID de la sucursal es obligatorio")
    private Long sucursalId;
}
