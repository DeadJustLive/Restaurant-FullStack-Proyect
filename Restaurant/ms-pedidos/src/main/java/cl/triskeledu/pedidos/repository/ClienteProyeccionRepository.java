package cl.triskeledu.pedidos.repository;

import cl.triskeledu.pedidos.proyecciones.ClienteProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteProyeccionRepository extends JpaRepository<ClienteProyeccion, Long> {
}