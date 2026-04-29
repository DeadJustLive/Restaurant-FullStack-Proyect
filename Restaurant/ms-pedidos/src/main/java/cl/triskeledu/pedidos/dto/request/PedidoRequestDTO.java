package cl.triskeledu.pedidos.dto.request;

import cl.triskeledu.pedidos.entity.enums.TipoPedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * =============================================================================
 * DTO REQUEST: PedidoRequestDTO
 * =============================================================================
 *
 * PROPÓSITO:
 *   Objeto de transferencia de datos para la CREACIÓN de un nuevo pedido.
 *   Representa el payload JSON que el cliente envía en POST /api/v1/pedidos.
 *
 * FLUJO DE DATOS:
 *   Cliente (JSON) → [Jackson deserializa] → PedidoRequestDTO
 *   → [Bean Validation @Valid] → PedidoController
 *   → PedidoService.crear(dto) → [ms-menu consulta precios] → PedidoItem (snapshot)
 *   → Pedido (entity) → [persistido] → PedidoResponseDTO (retornado al cliente)
 *
 * CAMPOS EXCLUIDOS INTENCIONALMENTE:
 *   - `total`: calculado por el Service consultando precios en ms-menu. NUNCA del cliente.
 *   - `estado`: siempre PENDIENTE al crear. No modificable desde este DTO.
 *   - `numeroPedido`: generado por el Service con lógica de secuencia.
 *   - `creadoEn`, `actualizadoEn`: timestamps automáticos de Hibernate.
 *
 * REGLAS DE VALIDACIÓN:
 *   - usuarioId: obligatorio, debe existir en ms-usuarios (validado en Service).
 *   - sucursalId: obligatorio, debe estar activa en ms-sucursales (validado en Service).
 *   - tipo: obligatorio, determina flujo de delivery.
 *   - items: al menos 1 ítem, cada uno validado con @Valid.
 *   - notas: opcional, máximo 500 caracteres.
 *
 * SEGURIDAD:
 *   El campo `usuarioId` NO debe ser enviado desde el cliente en producción.
 *   TODO: Extraer `usuarioId` del token JWT en el Controller/Service,
 *         no confiar en el campo del body del request.
 *
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequestDTO {

    /**
     * CAMPO: usuarioId
     * Tipo: Long
     * Rol: ID del usuario que realiza el pedido. Temporal: en producción se extrae del JWT.
     * Validación: No nulo.
     * TODO: Reemplazar por extracción desde SecurityContext en ms-auth integrado.
     */
    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;

    /**
     * CAMPO: sucursalId
     * Tipo: Long
     * Rol: ID de la sucursal a la que se dirige el pedido.
     *      El Service validará que la sucursal esté activa consultando ms-sucursales.
     * Validación: No nulo.
     */
    @NotNull(message = "El ID de la sucursal es obligatorio")
    private Long sucursalId;

    /**
     * CAMPO: tipo
     * Tipo: TipoPedido (Enum)
     * Rol: Modalidad del pedido. Determina si ms-delivery será invocado.
     *      Si es DELIVERY, el campo `direccionEntrega` en notas debe incluir la dirección.
     * Validación: No nulo. Valores válidos: DELIVERY, EN_LOCAL.
     */
    @NotNull(message = "El tipo de pedido es obligatorio (DELIVERY o EN_LOCAL)")
    private TipoPedido tipo;

    /**
     * CAMPO: items
     * Tipo: List<PedidoItemRequestDTO>
     * Rol: Lista de productos del pedido. Cada ítem es validado individualmente con @Valid.
     *      El Service consultará ms-menu por cada menuItemId para obtener precio y nombre.
     * Validación: No vacío, al menos 1 ítem.
     */
    @NotEmpty(message = "El pedido debe contener al menos un ítem")
    @Valid
    private List<PedidoItemRequestDTO> items;

    /**
     * CAMPO: notas
     * Tipo: String
     * Rol: Instrucciones adicionales del cliente (alergias, mesa, etc.).
     *      Para DELIVERY: puede incluir instrucciones de entrega.
     *      Para EN_LOCAL: puede incluir número de mesa (ej: "Mesa 7, sin cebolla").
     * Validación: Opcional, máximo 500 caracteres para evitar abuso.
     */
    @Size(max = 500, message = "Las notas no pueden superar los 500 caracteres")
    private String notas;
}
