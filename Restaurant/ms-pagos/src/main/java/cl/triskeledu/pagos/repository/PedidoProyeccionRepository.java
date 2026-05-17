package cl.triskeledu.pagos.repository;

import cl.triskeledu.pagos.proyecciones.PedidoProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoProyeccionRepository extends JpaRepository<PedidoProyeccion, Long> {
}