package cl.triskeledu.notificaciones.repository;

import cl.triskeledu.notificaciones.proyecciones.ClienteProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteProyeccionRepository extends JpaRepository<ClienteProyeccion, Long> {
}