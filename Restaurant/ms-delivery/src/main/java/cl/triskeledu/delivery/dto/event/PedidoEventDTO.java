package cl.triskeledu.delivery.dto.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEventDTO {
    private Long idPedido;
    private Long idCliente;
    private Long idSucursal;
    private String estado;
    private String direccionEntrega;
}