package cl.triskeledu.pagos.repository;

import cl.triskeledu.pagos.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * =============================================================================
 * REPOSITORY: PagoRepository
 * =============================================================================
 */
@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    List<Pago> findByPedidoId(Long pedidoId);
}
