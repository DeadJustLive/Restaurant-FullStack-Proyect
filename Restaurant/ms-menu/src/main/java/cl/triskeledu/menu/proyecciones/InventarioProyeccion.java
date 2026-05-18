package cl.triskeledu.menu.proyecciones;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "proyeccion_inventario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventarioProyeccion {

    @Id
    private Long id;

    private Long sucursalId;

    @Column(name = "nombre_insumo")
    private String nombreInsumo;

    private BigDecimal stockActual;

    private BigDecimal stockMinimo;
}