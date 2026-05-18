package cl.triskeledu.menu.repository;

import cl.triskeledu.menu.proyecciones.InventarioProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioProyeccionRepository extends JpaRepository<InventarioProyeccion, Long> {
}