package cl.triskeledu.menu.entity.proyecciones;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * ENTIDAD DE PROYECCIÓN
 * Esta clase es una copia de la categoría que vive originalmente en ms-categorias.
 * Se guarda en la base de datos de 'ms-menu' para evitar consultas por red.
 */
@Entity
@Table(name = "categorias_proyeccion")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class CategoriaProyeccion {

    @Id 
    // IMPORTANTE: Sin @GeneratedValue, porque el ID lo define ms-categorias
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private Boolean activa;
}