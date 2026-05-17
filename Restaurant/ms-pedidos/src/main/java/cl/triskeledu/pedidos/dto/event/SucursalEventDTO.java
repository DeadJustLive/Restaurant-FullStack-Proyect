package cl.triskeledu.pedidos.dto.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SucursalEventDTO {
    private Long id;
    private String nombre;
    private boolean activa;
}