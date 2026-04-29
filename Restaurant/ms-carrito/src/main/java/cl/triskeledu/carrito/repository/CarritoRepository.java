package cl.triskeledu.carrito.repository;

import cl.triskeledu.carrito.entity.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * =============================================================================
 * REPOSITORY: CarritoRepository
 * =============================================================================
 */
@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {

    Optional<Carrito> findByUsuarioId(Long usuarioId);
}
