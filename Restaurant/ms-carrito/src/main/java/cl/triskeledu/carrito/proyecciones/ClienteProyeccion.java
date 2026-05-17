package cl.triskeledu.carrito.proyecciones;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "clientes_proyeccion") // Nombre claro para no confundir
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteProyeccion {

    @Id
    @Column(name = "auth_user_id")
    private Long id;

    @Column(name = "nombre_completo", nullable = false, length = 150)
    private String nombreCompleto;

}

/*package cl.triskeledu.carrito.proyecciones;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proyeccion_clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteProyeccion {
    
    @Id
    private Long idCliente;
    
    private String nombre;
    private String email;
}*/