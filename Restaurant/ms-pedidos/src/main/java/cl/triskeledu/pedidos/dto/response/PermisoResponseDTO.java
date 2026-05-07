package cl.triskeledu.pedidos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermisoResponseDTO {
    private boolean permitido;
    private String mensaje;
}
