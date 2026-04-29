package cl.triskeledu.notificaciones.repository;

import cl.triskeledu.notificaciones.entity.Notificacion;
import cl.triskeledu.notificaciones.entity.enums.EstadoNotificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * =============================================================================
 * REPOSITORY: NotificacionRepository
 * =============================================================================
 */
@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

    List<Notificacion> findByEstado(EstadoNotificacion estado);
}
