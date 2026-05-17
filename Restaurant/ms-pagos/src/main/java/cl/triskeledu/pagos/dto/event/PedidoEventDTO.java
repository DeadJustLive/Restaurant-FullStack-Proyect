package cl.triskeledu.pagos.dto.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEventDTO {
    private Long idPedido;
    private Long idCliente;
    private Double total; // ¡Vital para saber cuánto cobrar!
    private String estado;
}