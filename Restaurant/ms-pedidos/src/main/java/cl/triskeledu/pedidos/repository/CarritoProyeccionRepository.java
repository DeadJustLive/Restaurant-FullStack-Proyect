package cl.triskeledu.pedidos.repository;

import cl.triskeledu.pedidos.proyecciones.CarritoProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoProyeccionRepository extends JpaRepository<CarritoProyeccion, Long> {
}