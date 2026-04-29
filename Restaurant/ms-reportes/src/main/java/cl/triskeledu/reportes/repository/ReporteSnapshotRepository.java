package cl.triskeledu.reportes.repository;

import cl.triskeledu.reportes.entity.ReporteSnapshot;
import cl.triskeledu.reportes.entity.enums.TipoReporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * =============================================================================
 * REPOSITORY: ReporteSnapshotRepository
 * =============================================================================
 */
@Repository
public interface ReporteSnapshotRepository extends JpaRepository<ReporteSnapshot, Long> {

    List<ReporteSnapshot> findByTipoOrderByCreadoEnDesc(TipoReporte tipo);
    
    List<ReporteSnapshot> findBySucursalIdAndTipoOrderByCreadoEnDesc(Long sucursalId, TipoReporte tipo);
}
