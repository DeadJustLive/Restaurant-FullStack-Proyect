package cl.triskeledu.sucursales.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * =============================================================================
 * ENTIDAD: Sucursal
 * =============================================================================
 *
 * PROPÓSITO:
 *   Representa un local físico del restaurante.
 *   Es una entidad maestra (Master Data) consumida por el resto de los microservicios.
 *
 * TABLA EN BD: `sucursales` (PostgreSQL — base de datos `sucursales`)
 *
 * REGLAS:
 *   - No se implementa borrado físico (soft delete mediante campo `activa`).
 *   - Si una sucursal pasa a `activa = false`, ms-pedidos no debería aceptar
 *     nuevos pedidos para este ID.
 *
 * =============================================================================
 */
@Entity
@Table(name = "sucursales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;

    @Column(name = "telefono", length = 20)
    private String telefono;

    /**
     * Flag operativo.
     * true = operando normalmente.
     * false = cerrada temporal o permanentemente (soft delete).
     */
    @Column(name = "activa", nullable = false)
    @Builder.Default
    private Boolean activa = true;

    @CreationTimestamp
    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    @UpdateTimestamp
    @Column(name = "actualizado_en", nullable = false)
    private LocalDateTime actualizadoEn;
}
