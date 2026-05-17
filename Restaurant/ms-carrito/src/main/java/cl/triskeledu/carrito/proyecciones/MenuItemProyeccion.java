package cl.triskeledu.carrito.proyecciones;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "menu_proyeccion") 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItemProyeccion {

    @Id 
    @Column(name = "menu_id")
    private Long id;

    @Column(name = "nombre_producto", nullable = false)
    private String nombre;

    @Column(name = "precio_actual", nullable = false)
    private Integer precio;

    // 3. Bandera para saber si el plato sigue disponible o si lo sacaron del menú.
    @Column(name = "disponible")
    private boolean disponible;
}