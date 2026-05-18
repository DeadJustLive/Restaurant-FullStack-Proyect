package cl.triskeledu.notificaciones.proyecciones;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proyeccion_clientes_notif")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteProyeccion {

    @Id
    @Column(name = "auth_user_id")
    private Long id;

    @Column(name = "nombre_completo", nullable = false, length = 150)
    private String nombreCompleto;

    @Column(length = 150)
    private String email;
}