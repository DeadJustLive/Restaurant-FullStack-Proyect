package cl.triskeledu.delivery.repository;

import cl.triskeledu.delivery.proyecciones.SucursalProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalProyeccionRepository extends JpaRepository<SucursalProyeccion, Long> {
}