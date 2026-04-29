package cl.triskeledu.delivery.repository;

import cl.triskeledu.delivery.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * =============================================================================
 * REPOSITORY: DeliveryRepository
 * =============================================================================
 */
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    Optional<Delivery> findByPedidoId(Long pedidoId);
}
