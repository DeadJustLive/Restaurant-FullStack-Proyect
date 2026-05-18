package cl.triskeledu.sucursales.dto.event;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SucursalEventDTO {

    private Long id;
    private String nombre;
    private String direccion;
    private boolean activa;
}