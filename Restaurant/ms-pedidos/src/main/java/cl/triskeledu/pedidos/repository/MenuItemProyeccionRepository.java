package cl.triskeledu.pedidos.repository;

import cl.triskeledu.pedidos.proyecciones.MenuItemProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemProyeccionRepository extends JpaRepository<MenuItemProyeccion, Long> {
}