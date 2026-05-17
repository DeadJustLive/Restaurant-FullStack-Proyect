package cl.triskeledu.pedidos.proyecciones;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proyeccion_menu_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemProyeccion {
    
    @Id
    private Long idItem;
    
    private String nombre;
    private Double precio;
    private boolean disponible;
}