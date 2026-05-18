package cl.triskeledu.pedidos.proyecciones;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "proyeccion_carritos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarritoProyeccion {

    @Id
    private Long id;

    private Long usuarioId;

    private Long sucursalId;

    private BigDecimal total;

    private String estado;
}