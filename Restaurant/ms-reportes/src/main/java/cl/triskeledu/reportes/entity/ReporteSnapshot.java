package cl.triskeledu.reportes.entity;

import cl.triskeledu.reportes.entity.enums.TipoReporte;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * =============================================================================
 * ENTIDAD: ReporteSnapshot
 * =============================================================================
 */
@Entity
@Table(name = "reporte_snapshots")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReporteSnapshot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sucursal_id")
    private Long sucursalId; // Puede ser null si es un reporte global consolidado

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 50)
    private TipoReporte tipo;

    // Dependiendo de PostgreSQL se puede usar @Type(JsonType.class) de Hypersistence
    // Por simplicidad del scaffolding, usaremos String simulando JSON TEXT
    @Column(name = "data_json", columnDefinition = "TEXT", nullable = false)
    private String dataJson;

    @CreationTimestamp
    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;
}
