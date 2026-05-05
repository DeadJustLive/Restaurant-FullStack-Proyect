package cl.triskeledu.menu.repository.proyecciones;

import cl.triskeledu.menu.entity.proyecciones.CategoriaProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaProyeccionRepository extends JpaRepository<CategoriaProyeccion, Long> {
}