package cl.triskeledu.inventario.repository;

import cl.triskeledu.inventario.entity.MovimientoInventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * =============================================================================
 * REPOSITORY: MovimientoRepository
 * =============================================================================
 */
@Repository
public interface MovimientoRepository extends JpaRepository<MovimientoInventario, Long> {

    List<MovimientoInventario> findByInsumoIdOrderByCreadoEnDesc(Long insumoId);
}
