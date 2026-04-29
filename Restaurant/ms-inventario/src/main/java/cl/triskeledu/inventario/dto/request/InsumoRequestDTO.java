package cl.triskeledu.inventario.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

/**
 * =============================================================================
 * DTO REQUEST: InsumoRequestDTO
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsumoRequestDTO {

    @NotNull(message = "El ID de la sucursal es obligatorio")
    private Long sucursalId;

    @NotBlank(message = "El nombre del insumo es obligatorio")
    private String nombre;

    @NotBlank(message = "La unidad de medida es obligatoria")
    private String unidadMedida;

    @NotNull(message = "El stock mínimo es obligatorio")
    @DecimalMin(value = "0.0", message = "El stock mínimo no puede ser negativo")
    private BigDecimal stockMinimo;
}
