package cl.triskeledu.pedidos.repository;

import cl.triskeledu.pedidos.proyecciones.SucursalProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalProyeccionRepository extends JpaRepository<SucursalProyeccion, Long> {
}