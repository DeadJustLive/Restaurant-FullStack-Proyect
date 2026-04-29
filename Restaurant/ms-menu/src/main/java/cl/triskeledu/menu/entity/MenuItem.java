package cl.triskeledu.menu.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * =============================================================================
 * ENTIDAD: MenuItem
 * =============================================================================
 *
 * PROPÓSITO:
 *   Representa un producto del catálogo del restaurante que puede ser ordenado
 *   por los clientes. Es el agregado raíz del dominio de menú.
 *
 * TABLA EN BD: `menu_items` (PostgreSQL — base de datos exclusiva `menu`)
 *
 * ROL CRÍTICO EN EL SISTEMA:
 *   Esta entidad es la FUENTE DE VERDAD del precio y nombre del producto.
 *   Cuando ms-pedidos crea un PedidoItem, consulta a ms-menu para obtener
 *   `precio` y `nombre`, y los guarda como SNAPSHOT histórico.
 *   Por ello, cualquier cambio a `precio` o `nombre` solo afecta pedidos FUTUROS.
 *
 * PRINCIPIO DATABASE-PER-SERVICE:
 *   `categoriaId` y `sucursalId` son IDs lógicos que referencian entidades
 *   en ms-categorias y ms-sucursales respectivamente. NO existen como FK físicas.
 *   La validación de existencia se hace mediante llamadas Feign al crear/actualizar.
 *
 * SOFT DELETE:
 *   Se recomienda implementar soft delete en lugar de eliminación física.
 *   Eliminar físicamente un MenuItem con ID referenciado en pedidos históricos
 *   rompe la trazabilidad, aunque los snapshots en PedidoItem preserven nombre/precio.
 *   TODO: Agregar campo `eliminado BOOLEAN DEFAULT FALSE` para soft delete.
 *
 * =============================================================================
 */
@Entity
@Table(name = "menu_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItem {

    /**
     * ATRIBUTO: id
     * Tipo: Long (BIGSERIAL en PostgreSQL)
     * Rol: Clave primaria autoincremental del producto.
     * Riesgo: CRÍTICO. Referenciado en pedido_items.menu_item_id (FK lógica) y
     *         en carrito_items. Si se reasigna un ID, los historiales de pedidos
     *         apuntarán a un producto distinto (aunque el snapshot preserva nombre/precio).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ATRIBUTO: nombre
     * Tipo: String (VARCHAR 100)
     * Rol: Nombre comercial del producto visible para el cliente en el menú,
     *      en el carrito, en el detalle del pedido y en los tickets de compra.
     *      Es capturado como snapshot por ms-pedidos al crear un PedidoItem.
     * Riesgo: ALTO. Cambiar el nombre NO afecta snapshots históricos en pedidos pasados,
     *         pero sí actualiza lo que el cliente ve en el menú actual.
     *         Coordinar cambios de nombre con el equipo de marketing para evitar confusión.
     */
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    /**
     * ATRIBUTO: descripcion
     * Tipo: String (TEXT)
     * Rol: Descripción detallada del producto: ingredientes principales, modo de preparación,
     *      advertencias de alérgenos. Visible en la vista de detalle del producto en el frontend.
     * Riesgo: BAJO. Campo informativo sin impacto en cálculos ni transacciones.
     *         Validar longitud máxima para evitar abuso (recomendado: max 1000 chars).
     */
    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    /**
     * ATRIBUTO: precio
     * Tipo: BigDecimal (DECIMAL 10,2)
     * Rol: Precio de venta actual del producto en la moneda local (CLP, USD, etc.).
     *      Es el valor que ms-pedidos y ms-carrito consultan para sus cálculos de total.
     *      ms-pedidos lo captura como snapshot en el momento de crear el pedido.
     * Riesgo: CRÍTICO.
     *         - Cambiar el precio afecta solo pedidos FUTUROS (los pasados tienen snapshot).
     *         - Nunca poner precio en 0 sin deshabilitar el ítem: generaría pedidos con total $0.
     *         - TODO: Agregar validación: precio debe ser > 0 en el Service.
     *         - TODO: Registrar historial de cambios de precio en una tabla audit (precio_history).
     */
    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    /**
     * ATRIBUTO: imagenUrl
     * Tipo: String (VARCHAR 500)
     * Rol: URL completa de la imagen del producto servida desde CDN o almacenamiento externo.
     *      Mostrada en la lista del menú, detalle de producto y carrito.
     *      No almacenar la imagen en la BD directamente (performance).
     * Riesgo: BAJO. Si la URL es inválida, el frontend mostrará imagen rota.
     *         TODO: Validar formato de URL con @URL de Hibernate Validator en el DTO.
     *         TODO: Integrar con servicio de CDN (ej: AWS S3 + CloudFront) para gestión de imágenes.
     */
    @Column(name = "imagen_url", length = 500)
    private String imagenUrl;

    /**
     * ATRIBUTO: disponible
     * Tipo: Boolean
     * Rol: Flag que controla si el ítem puede ser ordenado actualmente.
     *      false = el ítem no aparece en el menú del cliente ni se acepta en pedidos nuevos.
     *      true  = ítem activo y ordenable.
     *      Puede cambiar dinámicamente (ej: se agotó el ingrediente principal).
     * Riesgo: ALTO. Si se pone en false sin aviso, clientes con el ítem en carrito
     *         recibirán error al intentar confirmar el pedido.
     *         TODO: ms-pedidos debe validar disponible == true al crear PedidoItem.
     *         TODO: ms-carrito debe invalidar ítems no disponibles en tiempo real.
     */
    @Column(name = "disponible", nullable = false)
    @Builder.Default
    private Boolean disponible = true;

    /**
     * ATRIBUTO: categoriaId
     * Tipo: Long (BIGINT)
     * Rol: FK lógica a la categoría del producto en ms-categorias.
     *      Permite filtrar el menú por tipo (Entradas, Platos principales, Bebidas, etc.).
     *      El frontend usa este campo para renderizar la navegación por categorías.
     * Riesgo: MEDIO. Si ms-categorias elimina la categoría, el ítem queda sin clasificación.
     *         TODO: Al eliminar una categoría en ms-categorias, notificar a ms-menu
     *               para que reasigne sus ítems a una categoría por defecto (o los marque como no disponibles).
     */
    @Column(name = "categoria_id", nullable = false)
    private Long categoriaId;

    /**
     * ATRIBUTO: sucursalId
     * Tipo: Long (BIGINT) — nullable
     * Rol: FK lógica opcional a la sucursal en ms-sucursales.
     *      NULL = ítem global: disponible en TODAS las sucursales.
     *      Valor concreto = ítem exclusivo de esa sucursal (ej: plato especial de temporada).
     *      El frontend filtra el menú por sucursalId del usuario para mostrar solo lo disponible.
     * Riesgo: MEDIO. Confundir ítems globales vs. específicos puede mostrar productos
     *         no disponibles en la sucursal del cliente.
     *         La lógica de filtrado en el Service debe manejar correctamente el null.
     */
    @Column(name = "sucursal_id")
    private Long sucursalId;

    /**
     * ATRIBUTO: creadoEn
     * Tipo: LocalDateTime (TIMESTAMP)
     * Rol: Marca temporal de creación del ítem. Gestionada automáticamente por Hibernate.
     *      Útil para ordenar el menú por ítems más nuevos y para auditoría.
     * Riesgo: CRÍTICO. Inmutable. updatable = false garantiza que Hibernate
     *         nunca sobreescriba este valor en un UPDATE. No incluir en DTOs de actualización.
     */
    @CreationTimestamp
    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    /**
     * ATRIBUTO: actualizadoEn
     * Tipo: LocalDateTime (TIMESTAMP)
     * Rol: Última modificación del ítem. Actualizada automáticamente en cada save().
     *      Útil para detectar cambios recientes (ej: cambio de precio en las últimas 24h).
     * Riesgo: BAJO. Gestionado por Hibernate. No modificar manualmente.
     */
    @UpdateTimestamp
    @Column(name = "actualizado_en", nullable = false)
    private LocalDateTime actualizadoEn;
}
