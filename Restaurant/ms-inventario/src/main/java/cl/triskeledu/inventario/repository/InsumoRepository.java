package cl.triskeledu.inventario.repository;

import cl.triskeledu.inventario.entity.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * =============================================================================
 * REPOSITORY: InsumoRepository
 * =============================================================================
 */
@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Long> {

    List<Insumo> findBySucursalId(Long sucursalId);

    boolean existsBySucursalIdAndNombreIgnoreCase(Long sucursalId, String nombre);
}
