package cl.triskeledu.delivery.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * =============================================================================
 * DTO REQUEST: AsignarRepartidorDTO
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AsignarRepartidorDTO {

    @NotNull(message = "El ID del repartidor es obligatorio")
    private Long repartidorId;
}
