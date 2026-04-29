package cl.triskeledu.pedidos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * =============================================================================
 * ENTIDAD: PedidoItem
 * =============================================================================
 *
 * PROPÓSITO:
 *   Representa un ítem individual dentro de un pedido. Implementa el patrón
 *   de SNAPSHOT de precio: los campos `nombreSnapshot` y `precioUnitario`
 *   guardan los valores del producto al momento exacto de la compra,
 *   desacoplándose de futuros cambios en ms-menu.
 *
 * TABLA EN BD: `pedido_items` (dentro de la BD exclusiva `pedidos`)
 *
 * RELACIONES:
 *   - MANY-TO-ONE con Pedido: Varios ítems pertenecen a un mismo pedido.
 *     La FK `pedido_id` es la clave foránea en esta tabla (lado "many").
 *
 * PRINCIPIO SNAPSHOT:
 *   Si el restaurante actualiza el precio de un producto en ms-menu,
 *   los pedidos históricos NO deben verse afectados. Por eso se guardan
 *   `nombreSnapshot` y `precioUnitario` en esta entidad.
 *   NUNCA consultar ms-menu para obtener el precio de un ítem ya persistido.
 *
 * INVARIANTES:
 *   - `cantidad` debe ser >= 1.
 *   - `subtotal` = `precioUnitario * cantidad`. Calculado en PedidoServiceImpl.
 *   - `menuItemId` es una referencia lógica; si el producto es eliminado en
 *     ms-menu, el ítem histórico sigue siendo válido por su snapshot.
 *
 * =============================================================================
 */
@Entity
@Table(name = "pedido_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoItem {

    /**
     * ATRIBUTO: id
     * Tipo: Long (BIGSERIAL)
     * Rol: Clave primaria autoincremental del ítem.
     * Riesgo: CRÍTICO. No modificar ni reasignar. Identidad única del ítem.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ATRIBUTO: pedido
     * Tipo: Pedido (FK pedido_id)
     * Rol: Referencia al pedido padre. Define la relación bidireccional.
     *      FetchType.LAZY para no cargar el pedido completo al consultar solo ítems.
     * Riesgo: CRÍTICO. El campo `mappedBy = "pedido"` en Pedido.items debe coincidir
     *         con este nombre de campo exactamente. Un error aquí causa excepciones en runtime.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    /**
     * ATRIBUTO: menuItemId
     * Tipo: Long (BIGINT)
     * Rol: FK lógica al producto en ms-menu. Permite rastrear qué producto original
     *      corresponde este ítem, útil para reportes históricos y métricas de ventas.
     * Riesgo: ALTO. Si ms-menu elimina el producto, este ID quedará como referencia huérfana.
     *         El snapshot (nombreSnapshot, precioUnitario) garantiza que el ítem siga siendo legible.
     *         TODO: Validar existencia del menuItemId en ms-menu solo al momento de crear el pedido.
     */
    @Column(name = "menu_item_id", nullable = false)
    private Long menuItemId;

    /**
     * ATRIBUTO: nombreSnapshot
     * Tipo: String (VARCHAR 100)
     * Rol: Nombre del producto tal como estaba definido en ms-menu AL MOMENTO DE LA COMPRA.
     *      Es un snapshot histórico, no debe sincronizarse con cambios futuros en ms-menu.
     * Riesgo: BAJO. Registro de auditoría. Si se actualiza, se pierde la fidelidad histórica.
     *         Solo se asigna una vez en la creación del pedido.
     */
    @Column(name = "nombre_snapshot", nullable = false, length = 100)
    private String nombreSnapshot;

    /**
     * ATRIBUTO: precioUnitario
     * Tipo: BigDecimal (DECIMAL 10,2)
     * Rol: Precio del producto AL MOMENTO DE LA COMPRA. Snapshot histórico.
     *      Se obtiene de ms-menu via MenuItemClient.getById() solo al crear el pedido.
     * Riesgo: CRÍTICO. Si se recibe del cliente en lugar de consultarse en ms-menu,
     *         se abre una vulnerabilidad grave de manipulación de precios.
     *         El Service SIEMPRE debe consultar ms-menu para obtener este valor.
     */
    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    /**
     * ATRIBUTO: cantidad
     * Tipo: Integer (INT)
     * Rol: Número de unidades del producto en este ítem. Mínimo 1, máximo configurable.
     *      Multiplicado por precioUnitario para calcular el subtotal.
     * Riesgo: ALTO. Cambiar la cantidad en un pedido activo implica:
     *         1. Recalcular subtotal y total del pedido padre.
     *         2. Ajustar stock en ms-inventario.
     *         TODO: Implementar lógica de ajuste de cantidad solo en estado PENDIENTE.
     */
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    /**
     * ATRIBUTO: subtotal
     * Tipo: BigDecimal (DECIMAL 10,2)
     * Rol: Valor total de este ítem = precioUnitario * cantidad.
     *      Siempre calculado por PedidoServiceImpl. Nunca recibido del cliente.
     *      Almacenado para evitar recalcular en cada consulta y para auditoría.
     * Riesgo: CRÍTICO. Si se permite que el cliente envíe este campo, se habilita
     *         manipulación de precios. Siempre ignorar si viene en el DTO de request.
     */
    @Column(name = "subtotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;
}
