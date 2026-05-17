package cl.triskeledu.carrito.dto.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthEventDTO {
    private Long id;          // El ID que se generó en la base de datos de Auth
    private String nombre;    // El nombre del usuario
    private String apellido;  // El apellido del usuario
    private String rol;       // (Opcional) Si quieres saber qué rol tiene
}