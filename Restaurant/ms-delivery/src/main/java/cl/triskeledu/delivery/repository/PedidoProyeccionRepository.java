package cl.triskeledu.delivery.repository;

import cl.triskeledu.delivery.proyecciones.PedidoProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoProyeccionRepository extends JpaRepository<PedidoProyeccion, Long> {
}