package cl.triskeledu.menu.proyecciones;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proyeccion_sucursales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SucursalProyeccion {
    
    @Id
    private Long idSucursal;
    
    private String nombre;
    private String direccion;
    private boolean activa;
}