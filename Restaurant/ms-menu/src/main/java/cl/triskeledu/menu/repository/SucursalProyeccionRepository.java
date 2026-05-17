package cl.triskeledu.menu.repository;

import cl.triskeledu.menu.proyecciones.SucursalProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalProyeccionRepository extends JpaRepository<SucursalProyeccion, Long> {
}