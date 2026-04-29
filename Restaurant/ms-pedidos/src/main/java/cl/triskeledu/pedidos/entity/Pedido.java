package cl.triskeledu.pedidos.entity;

import cl.triskeledu.pedidos.entity.enums.EstadoPedido;
import cl.triskeledu.pedidos.entity.enums.TipoPedido;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * =============================================================================
 * ENTIDAD: Pedido
 * =============================================================================
 *
 * PROPÓSITO:
 *   Representa el agregado raíz del dominio de pedidos. Contiene el estado
 *   actual, el tipo de entrega, el usuario que lo realizó y la referencia a
 *   la sucursal destino.
 *
 * TABLA EN BD: `pedidos` (PostgreSQL — base de datos exclusiva `pedidos`)
 *
 * RELACIONES:
 *   - ONE-TO-MANY con PedidoItem: Un pedido contiene uno o más ítems.
 *     CascadeType.ALL: al persistir/eliminar un pedido, se propaga a sus ítems.
 *     OrphanRemoval=true: si se elimina un ítem de la lista, se borra de la BD.
 *
 * INVARIANTES DEL AGREGADO:
 *   1. Un pedido debe tener al menos 1 ítem para ser válido.
 *   2. El campo `total` es siempre la suma de los subtotales de sus ítems.
 *   3. El campo `estado` solo puede cambiar siguiendo la máquina de estados de EstadoPedido.
 *   4. Los campos `creadoEn` y `actualizadoEn` son inmutables desde la capa de aplicación.
 *
 * PRINCIPIO DATABASE-PER-SERVICE:
 *   Los campos `usuarioId` y `sucursalId` son IDs lógicos que referencian
 *   entidades de otros microservicios. NO se definen como @ManyToOne ni @JoinColumn
 *   ya que no existe FK física entre bases de datos distintas.
 *
 * RIESGO GLOBAL:
 *   Modificar el nombre de la tabla o de cualquier columna requiere un script
 *   de migración de BD (Flyway/Liquibase). El ddl-auto=update de desarrollo
 *   NO es suficiente para renombrados seguros en producción.
 *
 * =============================================================================
 */
@Entity
@Table(name = "pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {

    /**
     * ATRIBUTO: id
     * Tipo: Long (BIGSERIAL en PostgreSQL)
     * Rol: Clave primaria autoincremental. Identificador único del pedido en este microservicio.
     * Riesgo: CRÍTICO. Nunca modificar ni reasignar. Es referenciado por ms-pagos y ms-delivery
     *         como ID foráneo lógico en sus propias bases de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ATRIBUTO: numeroPedido
     * Tipo: String (VARCHAR 20)
     * Rol: Código de negocio legible y auditable. Generado por el Service con formato
     *      PED-{YYYYMMDD}-{sequence}. Expuesto en notificaciones y reportes.
     * Riesgo: ALTO. Cambiar el formato rompe integraciones con ms-notificaciones y ms-reportes.
     *         La columna es UNIQUE para evitar duplicados.
     */
    @Column(name = "numero_pedido", nullable = false, unique = true, length = 20)
    private String numeroPedido;

    /**
     * ATRIBUTO: usuarioId
     * Tipo: Long (BIGINT)
     * Rol: FK lógica al usuario propietario del pedido, almacenado en ms-usuarios.
     *      Se usa para filtrar pedidos por usuario y para enviar notificaciones.
     * Riesgo: ALTO. Si ms-usuarios elimina el usuario, este campo queda como dato huérfano.
     *         TODO: Implementar política de soft-delete en ms-usuarios para evitar esto.
     */
    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    /**
     * ATRIBUTO: sucursalId
     * Tipo: Long (BIGINT)
     * Rol: FK lógica a la sucursal que debe atender el pedido, en ms-sucursales.
     *      Determina qué cocina y qué repartidores están asignados.
     * Riesgo: MEDIO. Si la sucursal se inhabilita, los pedidos activos quedan sin atención.
     *         TODO: Validar que la sucursal esté activa en ms-sucursales al crear el pedido.
     */
    @Column(name = "sucursal_id", nullable = false)
    private Long sucursalId;

    /**
     * ATRIBUTO: estado
     * Tipo: EstadoPedido (VARCHAR 20 — @Enumerated STRING)
     * Rol: Estado actual en la máquina de estados del pedido.
     *      Persiste como STRING para legibilidad y robustez ante reordenamientos del enum.
     * Riesgo: CRÍTICO. Solo PedidoServiceImpl puede modificar este campo,
     *         verificando siempre que la transición sea válida antes de persistir.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private EstadoPedido estado;

    /**
     * ATRIBUTO: tipo
     * Tipo: TipoPedido (VARCHAR 15 — @Enumerated STRING)
     * Rol: Modalidad de entrega del pedido. Inmutable después de la creación.
     *      Condiciona la activación de ms-delivery y la visibilidad en el frontend.
     * Riesgo: ALTO. No modificar una vez persistido. Cambiar de EN_LOCAL a DELIVERY
     *         requeriría un nuevo checkout, no una actualización del pedido existente.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 15)
    private TipoPedido tipo;

    /**
     * ATRIBUTO: total
     * Tipo: BigDecimal (DECIMAL 10,2)
     * Rol: Suma total del pedido. Calculado por PedidoServiceImpl como
     *      sum(item.precioUnitario * item.cantidad) para todos los ítems.
     *      Nunca calculado en el Controller ni recibido desde el cliente.
     * Riesgo: CRÍTICO. Si se acepta del cliente, abre vulnerabilidad de manipulación
     *         de precios. El valor debe derivarse siempre de los snapshots de precio.
     */
    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    /**
     * ATRIBUTO: notas
     * Tipo: String (TEXT)
     * Rol: Campo libre para instrucciones especiales del cliente:
     *      alergias, preferencias, número de mesa, etc.
     *      El frontend debe limitar la entrada a 500 caracteres.
     * Riesgo: BAJO. Validar longitud máxima para evitar abuso. Sanitizar antes de mostrar.
     */
    @Column(name = "notas", columnDefinition = "TEXT")
    private String notas;

    /**
     * ATRIBUTO: items
     * Tipo: List<PedidoItem>
     * Rol: Colección de ítems del pedido. Relación bidireccional con PedidoItem.
     *      Se inicializa con ArrayList para evitar NullPointerException.
     * Riesgo: ALTO. CascadeType.ALL implica que eliminar un Pedido elimina sus ítems en cascada.
     *         En producción, considerar soft-delete en lugar de eliminación física.
     */
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<PedidoItem> items = new ArrayList<>();

    /**
     * ATRIBUTO: creadoEn
     * Tipo: LocalDateTime (TIMESTAMP)
     * Rol: Marca temporal de creación. Gestionada automáticamente por Hibernate.
     *      Nunca debe ser asignada manualmente ni expuesta en DTOs de actualización.
     * Riesgo: CRÍTICO. Inmutable. Si se permite modificar desde la API, se pierde la
     *         trazabilidad de auditoría. No incluir en ningún DTO de request.
     */
    @CreationTimestamp
    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    /**
     * ATRIBUTO: actualizadoEn
     * Tipo: LocalDateTime (TIMESTAMP)
     * Rol: Marca temporal de última modificación. Actualizada automáticamente por Hibernate.
     *      Útil para ordenar por recencia y detectar conflictos de concurrencia.
     * Riesgo: BAJO. Gestionado por @UpdateTimestamp. No incluir en DTOs de request.
     */
    @UpdateTimestamp
    @Column(name = "actualizado_en", nullable = false)
    private LocalDateTime actualizadoEn;
}
