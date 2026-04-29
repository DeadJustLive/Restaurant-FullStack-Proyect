package cl.triskeledu.sucursales.repository;

import cl.triskeledu.sucursales.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * =============================================================================
 * REPOSITORY: SucursalRepository
 * =============================================================================
 *
 * PROPÓSITO:
 *   Acceso a datos de Sucursal.
 *
 * =============================================================================
 */
@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

    /**
     * Lista todas las sucursales que están activas.
     * Usado por clientes y el frontend público.
     */
    List<Sucursal> findByActivaTrueOrderByNombreAsc();

    /**
     * Cambia el estado activo de la sucursal.
     * @param id ID de la sucursal
     * @param activa Nuevo estado
     * @return filas afectadas
     */
    @Modifying
    @Query("UPDATE Sucursal s SET s.activa = :activa WHERE s.id = :id")
    int actualizarEstado(@Param("id") Long id, @Param("activa") Boolean activa);
}
