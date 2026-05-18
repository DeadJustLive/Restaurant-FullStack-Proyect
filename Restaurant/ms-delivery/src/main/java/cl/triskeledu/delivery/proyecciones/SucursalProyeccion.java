package cl.triskeledu.delivery.proyecciones;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proyeccion_sucursales_delivery")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SucursalProyeccion {

    @Id
    @Column(name = "id_sucursal")
    private Long idSucursal;

    @Column(nullable = false)
    private String nombre;

    private String direccion;

    private boolean activa;
}