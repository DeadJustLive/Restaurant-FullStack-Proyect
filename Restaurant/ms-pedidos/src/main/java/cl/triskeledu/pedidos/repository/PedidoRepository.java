package cl.triskeledu.pedidos.repository;

import cl.triskeledu.pedidos.entity.Pedido;
import cl.triskeledu.pedidos.entity.enums.EstadoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * =============================================================================
 * REPOSITORY: PedidoRepository
 * =============================================================================
 *
 * PROPÓSITO:
 *   Capa de acceso a datos para la entidad Pedido.
 *   Extiende JpaRepository para heredar operaciones CRUD estándar:
 *   save(), findById(), findAll(), deleteById(), etc.
 *
 * BASE DE DATOS:
 *   PostgreSQL — esquema `pedidos` — tabla `pedidos`
 *
 * DEPENDENCIAS:
 *   - Pedido (entity): mapeo JPA a la tabla `pedidos`.
 *   - EstadoPedido (enum): usado en filtros de estado.
 *
 * CONVENCIÓN DE NOMBRES:
 *   - Métodos derivados (Spring Data): findBy{Campo}[And|Or]{Campo}
 *     Generan SQL automáticamente desde el nombre del método.
 *   - Métodos @Query: se usa JPQL (orientado a entidades, no SQL puro).
 *     Usar SQL nativo solo cuando JPQL sea insuficiente (nativeQuery=true).
 *
 * REGLAS PARA QUERIES PERSONALIZADAS:
 *   1. Siempre ordenar listas por creadoEn DESC para mostrar lo más reciente primero.
 *   2. Filtrar por sucursalId + estado para la vista de cocina (KDS).
 *   3. Filtrar por usuarioId para el historial del cliente.
 *   4. Evitar SELECT * en queries de alto volumen: seleccionar solo campos necesarios
 *      con proyecciones o DTOs cuando sea posible (Projections / DTO constructor).
 *
 * REGLA DE PERFORMANCE:
 *   La relación @OneToMany con items es FetchType.LAZY.
 *   Si se necesita cargar el pedido CON sus ítems en una sola query,
 *   usar el método findByIdWithItems() con JOIN FETCH para evitar el problema N+1.
 *
 * =============================================================================
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    /*
     * -----------------------------------------------------------------------
     * QUERIES DERIVADAS (Spring Data genera el SQL automáticamente)
     * -----------------------------------------------------------------------
     */

    /**
     * CONSULTA: Historial de pedidos de un usuario, ordenado por fecha descendente.
     *
     * CASO DE USO:
     *   Pantalla "Mis Pedidos" del CLIENTE. Devuelve todos los pedidos del usuario
     *   sin importar el estado, para mostrar historial completo.
     *
     * INPUT:  usuarioId (Long) — ID del usuario autenticado (extraído del JWT).
     * OUTPUT: List<Pedido> — ordenada por creadoEn DESC (más reciente primero).
     *
     * SQL GENERADO APROXIMADO:
     *   SELECT * FROM pedidos WHERE usuario_id = ? ORDER BY creado_en DESC
     *
     * NOTA DE SEGURIDAD:
     *   El Controller debe verificar que el usuarioId del JWT coincide con el
     *   usuarioId del path parameter antes de invocar este método.
     *   Un ADMIN puede consultar cualquier usuario; un CLIENTE solo el suyo.
     */
    List<Pedido> findByUsuarioIdOrderByCreadoEnDesc(Long usuarioId);

    /**
     * CONSULTA: Cola activa de pedidos de una sucursal para la vista de cocina (KDS).
     *
     * CASO DE USO:
     *   Pantalla KDS (Kitchen Display System) del COCINERO.
     *   Devuelve solo los pedidos en estado CONFIRMADO o EN_PREPARACION
     *   de la sucursal del cocinero autenticado.
     *
     * INPUT:
     *   - sucursalId (Long): ID de la sucursal del cocinero.
     *   - estado (EstadoPedido): estado a filtrar (típicamente CONFIRMADO o EN_PREPARACION).
     * OUTPUT: List<Pedido> — ordenada por creadoEn ASC (más antiguo primero = prioridad FIFO).
     *
     * SQL GENERADO APROXIMADO:
     *   SELECT * FROM pedidos WHERE sucursal_id = ? AND estado = ? ORDER BY creado_en ASC
     */
    List<Pedido> findBySucursalIdAndEstadoOrderByCreadoEnAsc(Long sucursalId, EstadoPedido estado);

    /**
     * CONSULTA: Pedidos de una sucursal en múltiples estados.
     *
     * CASO DE USO:
     *   Vista ADMIN que necesita ver pedidos activos (todos excepto ENTREGADO y CANCELADO).
     *   También útil para el dashboard de operaciones en tiempo real.
     *
     * INPUT:
     *   - sucursalId (Long): ID de la sucursal.
     *   - estados (List<EstadoPedido>): lista de estados a incluir.
     * OUTPUT: List<Pedido> — ordenada por creadoEn DESC.
     *
     * JPQL:
     *   SELECT p FROM Pedido p WHERE p.sucursalId = :sucursalId
     *   AND p.estado IN :estados ORDER BY p.creadoEn DESC
     */
    @Query("SELECT p FROM Pedido p WHERE p.sucursalId = :sucursalId AND p.estado IN :estados ORDER BY p.creadoEn DESC")
    List<Pedido> findBySucursalIdAndEstadoIn(@Param("sucursalId") Long sucursalId,
                                             @Param("estados") List<EstadoPedido> estados);

    /**
     * CONSULTA: Pedido por ID con ítems cargados en una sola query (evita N+1).
     *
     * CASO DE USO:
     *   Cualquier endpoint que devuelva el detalle completo de un pedido incluyendo
     *   sus ítems. Sin JOIN FETCH, Hibernate haría una query adicional por cada ítem.
     *
     * INPUT:  id (Long) — ID del pedido.
     * OUTPUT: Pedido con su lista de items inicializada (no lazy).
     *
     * JPQL:
     *   SELECT p FROM Pedido p LEFT JOIN FETCH p.items WHERE p.id = :id
     *
     * PROBLEMA N+1 EVITADO:
     *   Sin este método, acceder a pedido.getItems() después de cerrar la sesión
     *   lanzaría LazyInitializationException.
     *   Con JOIN FETCH, Hibernate trae todo en una sola query SQL.
     */
    @Query("SELECT p FROM Pedido p LEFT JOIN FETCH p.items WHERE p.id = :id")
    java.util.Optional<Pedido> findByIdWithItems(@Param("id") Long id);

    /**
     * CONSULTA: Pedidos creados en un rango de fechas (para ms-reportes).
     *
     * CASO DE USO:
     *   ms-reportes o el ADMIN necesita obtener todos los pedidos de un día/semana/mes
     *   para calcular métricas de ventas.
     *
     * INPUT:
     *   - desde (LocalDateTime): inicio del rango.
     *   - hasta (LocalDateTime): fin del rango.
     * OUTPUT: List<Pedido> — todos los pedidos en el rango, sin filtro de estado.
     *
     * JPQL:
     *   SELECT p FROM Pedido p WHERE p.creadoEn BETWEEN :desde AND :hasta
     *   ORDER BY p.creadoEn ASC
     *
     * NOTA DE PERFORMANCE:
     *   TODO: Agregar índice en la columna `creado_en` si el volumen de datos crece.
     *         Para consultas de millones de registros, considerar paginación (Pageable).
     */
    @Query("SELECT p FROM Pedido p WHERE p.creadoEn BETWEEN :desde AND :hasta ORDER BY p.creadoEn ASC")
    List<Pedido> findByRangoFechas(@Param("desde") LocalDateTime desde,
                                   @Param("hasta") LocalDateTime hasta);
}
