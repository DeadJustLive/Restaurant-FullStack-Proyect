package cl.triskeledu.delivery.proyecciones;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Proyección de Cliente para el microservicio de Delivery.
 * Aquí guardamos solo lo que el repartidor necesita saber para entregar el pedido.
 */
@Entity
@Table(name = "cliente_proyeccion")
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

    @Column(name = "direccion", nullable = false, length = 300)
    private String direccion;

    @Column(name = "telefono", length = 20)
    private String telefono;
}