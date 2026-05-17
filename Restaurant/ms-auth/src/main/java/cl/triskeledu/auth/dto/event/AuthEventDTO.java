package cl.triskeledu.auth.dto.event;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthEventDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
}