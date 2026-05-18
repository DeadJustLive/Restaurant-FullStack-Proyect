package cl.triskeledu.menu.dto.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemEventDTO {
    private Long id;
    private String nombre;
    private Double precio;
    private boolean disponible;
}