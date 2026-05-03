package cl.triskeledu.pedidos.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEstadoRequestDTO {
    
    @NotBlank(message = "El estado no puede estar vacío")
    private String estado;
}
