package cl.triskeledu.carrito.repository;

import cl.triskeledu.carrito.proyecciones.MenuItemProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemProyeccionRepository extends JpaRepository<MenuItemProyeccion, Long> {
}