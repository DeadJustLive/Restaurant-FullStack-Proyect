package cl.triskeledu.delivery.proyecciones;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proyeccion_pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoProyeccion {
    
    @Id
    private Long idPedido; //El mismo ID que viene del ms-pedidos
    
    private Long idCliente;
    private Long idSucursal;
    private String estadoPedido;
    private String direccionEntrega;
}