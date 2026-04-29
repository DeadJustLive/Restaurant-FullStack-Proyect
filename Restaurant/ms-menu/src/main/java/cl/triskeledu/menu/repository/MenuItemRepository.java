package cl.triskeledu.menu.repository;

import cl.triskeledu.menu.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * =============================================================================
 * REPOSITORY: MenuItemRepository
 * =============================================================================
 *
 * PROPÓSITO:
 *   Capa de acceso a datos para la entidad MenuItem.
 *   Extiende JpaRepository para heredar operaciones CRUD estándar.
 *
 * BASE DE DATOS:
 *   PostgreSQL — base de datos `menu` — tabla `menu_items`
 *
 * REGLAS DE QUERIES:
 *   1. Siempre filtrar por `disponible = true` en consultas del catálogo público
 *      (lo que ve el cliente). El admin puede ver todos.
 *   2. Filtrar por `sucursalId IS NULL OR sucursalId = :id` para incluir
 *      ítems globales en el resultado de una sucursal específica.
 *   3. Ordenar por `nombre ASC` en listados para facilitar búsqueda visual.
 *   4. Para queries de alta frecuencia (catálogo), considerar Cacheable en el Service.
 *      TODO: Integrar Spring Cache (@Cacheable) con Redis para el catálogo de ítems.
 *
 * ÍNDICES RECOMENDADOS EN BD (para performance en producción):
 *   - `categoria_id`  : índice simple — filtros por categoría son frecuentes.
 *   - `sucursal_id`   : índice simple — filtros por sucursal son frecuentes.
 *   - `disponible`    : índice parcial WHERE disponible = true — consultas de catálogo.
 *   - `nombre`        : índice GIN (full-text) si se implementa búsqueda de texto.
 *
 * =============================================================================
 */
@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    /*
     * -----------------------------------------------------------------------
     * CONSULTAS DEL CATÁLOGO PÚBLICO (filtro: disponible = true)
     * -----------------------------------------------------------------------
     */

    /**
     * CONSULTA: Todos los ítems disponibles para el catálogo público.
     *
     * CASO DE USO:
     *   GET /api/v1/menu — Vista del menú para el CLIENTE.
     *   Muestra solo ítems activos, ordenados alfabéticamente.
     *
     * OUTPUT: List<MenuItem> con disponible=true, ordenados por nombre ASC.
     *
     * SQL GENERADO:
     *   SELECT * FROM menu_items WHERE disponible = true ORDER BY nombre ASC
     */
    List<MenuItem> findByDisponibleTrueOrderByNombreAsc();

    /**
     * CONSULTA: Ítems disponibles por categoría.
     *
     * CASO DE USO:
     *   GET /api/v1/menu/categoria/{categoriaId}
     *   Navegación por categorías en el menú del cliente.
     *
     * INPUT:  categoriaId (Long) — ID de la categoría a filtrar.
     * OUTPUT: List<MenuItem> disponibles de esa categoría, ordenados por nombre.
     *
     * SQL GENERADO:
     *   SELECT * FROM menu_items WHERE categoria_id = ? AND disponible = true ORDER BY nombre ASC
     */
    List<MenuItem> findByCategoriaIdAndDisponibleTrueOrderByNombreAsc(Long categoriaId);

    /**
     * CONSULTA: Ítems disponibles en una sucursal (propios + globales).
     *
     * CASO DE USO:
     *   GET /api/v1/menu/sucursal/{sucursalId}
     *   Catálogo de una sucursal específica: incluye ítems propios (sucursal_id = ?)
     *   y los ítems globales (sucursal_id IS NULL).
     *
     * INPUT:  sucursalId (Long) — ID de la sucursal del usuario.
     * OUTPUT: List<MenuItem> disponibles para esa sucursal.
     *
     * JPQL:
     *   SELECT m FROM MenuItem m
     *   WHERE (m.sucursalId = :sucursalId OR m.sucursalId IS NULL)
     *   AND m.disponible = true
     *   ORDER BY m.nombre ASC
     *
     * LÓGICA CLAVE:
     *   La condición `OR m.sucursalId IS NULL` es la que incluye ítems globales.
     *   Sin esta condición, los clientes de una sucursal no verían el menú común.
     */
    @Query("""
            SELECT m FROM MenuItem m
            WHERE (m.sucursalId = :sucursalId OR m.sucursalId IS NULL)
            AND m.disponible = true
            ORDER BY m.nombre ASC
            """)
    List<MenuItem> findDisponiblesBySucursal(@Param("sucursalId") Long sucursalId);

    /**
     * CONSULTA: Buscar ítem por ID solo si está disponible (uso de ms-pedidos y ms-carrito).
     *
     * CASO DE USO:
     *   ms-pedidos llama: GET /api/v1/menu/{id}
     *   Antes de crear el PedidoItem, verifica que el ítem existe Y está disponible.
     *   Si retorna Optional.empty(), el Service lanza ItemNoDisponibleException.
     *
     * INPUT:  id (Long), disponible debe ser true.
     * OUTPUT: Optional<MenuItem> — empty si no existe o no está disponible.
     *
     * DECISIÓN DE DISEÑO:
     *   Se combina la búsqueda por ID con el filtro de disponibilidad en UNA sola query
     *   para evitar dos llamadas a la BD (findById + check disponible).
     */
    Optional<MenuItem> findByIdAndDisponibleTrue(Long id);

    /*
     * -----------------------------------------------------------------------
     * CONSULTAS ADMINISTRATIVAS (sin filtro de disponibilidad)
     * -----------------------------------------------------------------------
     */

    /**
     * CONSULTA: Todos los ítems de una categoría (admin incluye no disponibles).
     *
     * CASO DE USO:
     *   Vista de gestión de menú para ADMIN. Muestra todos los ítems de una categoría
     *   incluyendo los deshabilitados (para poder reactivarlos).
     *
     * INPUT:  categoriaId (Long).
     * OUTPUT: List<MenuItem> — todos (activos e inactivos) de la categoría.
     */
    List<MenuItem> findByCategoriaIdOrderByNombreAsc(Long categoriaId);

    /**
     * CONSULTA: Cambio masivo de disponibilidad por categoría (operación de admin).
     *
     * CASO DE USO:
     *   El admin decide deshabilitar toda una categoría (ej: "Postres" fuera de temporada).
     *   Una sola query UPDATE en lugar de cargar todos y actualizar uno a uno.
     *
     * INPUT:
     *   - categoriaId (Long): ID de la categoría a afectar.
     *   - disponible (Boolean): nuevo valor del flag.
     *
     * SQL:
     *   UPDATE menu_items SET disponible = :disponible WHERE categoria_id = :categoriaId
     *
     * NOTA: @Modifying requiere @Transactional en el Service que invoque este método.
     *       TODO: Notificar a ms-carrito para invalidar carritos con ítems de esta categoría.
     */
    @Modifying
    @Query("UPDATE MenuItem m SET m.disponible = :disponible WHERE m.categoriaId = :categoriaId")
    int actualizarDisponibilidadPorCategoria(@Param("categoriaId") Long categoriaId,
                                              @Param("disponible") Boolean disponible);

    /**
     * CONSULTA: Verificar si ya existe un ítem con el mismo nombre en la misma categoría.
     *
     * CASO DE USO:
     *   Prevenir duplicados al crear un nuevo ítem del menú.
     *   El Service llama a este método antes de persistir, lanzando excepción si existe.
     *
     * INPUT:  nombre (String), categoriaId (Long).
     * OUTPUT: boolean — true si ya existe un ítem con ese nombre en esa categoría.
     *
     * TODO: Evaluar si la unicidad debe ser (nombre, categoriaId, sucursalId) para permitir
     *       que diferentes sucursales tengan ítems con el mismo nombre en la misma categoría.
     */
    boolean existsByNombreIgnoreCaseAndCategoriaId(String nombre, Long categoriaId);
}
