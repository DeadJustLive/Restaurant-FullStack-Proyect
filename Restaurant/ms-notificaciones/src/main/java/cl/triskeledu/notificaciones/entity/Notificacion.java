package cl.triskeledu.notificaciones.entity;

import cl.triskeledu.notificaciones.entity.enums.EstadoNotificacion;
import cl.triskeledu.notificaciones.entity.enums.TipoNotificacion;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * =============================================================================
 * ENTIDAD: Notificacion
 * =============================================================================
 */
@Entity
@Table(name = "notificaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "destinatario", nullable = false, length = 255)
    private String destinatario;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 20)
    private TipoNotificacion tipo;

    @Column(name = "asunto", length = 150)
    private String asunto;

    @Column(name = "cuerpo", columnDefinition = "TEXT", nullable = false)
    private String cuerpo;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    @Builder.Default
    private EstadoNotificacion estado = EstadoNotificacion.PENDIENTE;

    @CreationTimestamp
    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;
}
