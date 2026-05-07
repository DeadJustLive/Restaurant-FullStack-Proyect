package cl.triskeledu.categorias.repository;

import cl.triskeledu.categorias.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * =============================================================================
 * REPOSITORY: CategoriaRepository
 * =============================================================================
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByNombreIgnoreCase(String nombre);

    boolean existsByNombreIgnoreCase(String nombre);

    List<Categoria> findByActivaTrueOrderByNombreAsc();

    @Modifying
    @Query("UPDATE Categoria c SET c.activa = :activa WHERE c.id = :id")
    int actualizarEstado(@Param("id") Long id, @Param("activa") Boolean activa);
}
