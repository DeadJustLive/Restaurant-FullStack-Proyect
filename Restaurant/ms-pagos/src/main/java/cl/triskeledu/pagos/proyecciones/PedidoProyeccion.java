package cl.triskeledu.pagos.proyecciones;

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
    private Long idPedido;
    
    private Long idCliente;
    private Double total;
    private String estadoPedido;
}