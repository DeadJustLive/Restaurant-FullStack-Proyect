package cl.triskeledu.carrito.proyecciones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemProyeccionRepository extends JpaRepository<MenuItemProyeccion, Long> {
}