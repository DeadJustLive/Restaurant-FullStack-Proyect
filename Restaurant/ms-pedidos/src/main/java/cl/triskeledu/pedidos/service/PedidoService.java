package cl.triskeledu.pedidos.service;

import cl.triskeledu.pedidos.dto.request.PedidoRequestDTO;
import cl.triskeledu.pedidos.dto.response.PedidoResponseDTO;
import cl.triskeledu.pedidos.entity.enums.EstadoPedido;

import java.util.List;

/**
 * =============================================================================
 * SERVICE INTERFACE: PedidoService
 * =============================================================================
 *
 * PROPÓSITO:
 *   Define el contrato de negocio del módulo de pedidos.
 *   Desacopla el Controller de la implementación concreta (PedidoServiceImpl),
 *   permitiendo sustituir la implementación sin modificar la capa de presentación.
 *
 * PRINCIPIO:
 *   Programar hacia interfaces, no hacia implementaciones (Dependency Inversion).
 *   El Controller inyecta PedidoService, no PedidoServiceImpl directamente.
 *
 * CONVENCIONES DE RETORNO:
 *   - Operaciones de lectura: devuelven DTO de response.
 *   - Operaciones de escritura: devuelven el DTO actualizado (útil para el cliente).
 *   - Operaciones de eliminación: devuelven void o el DTO del recurso cancelado.
 *
 * EXCEPCIONES ESPERADAS (documentadas para cada método):
 *   - PedidoNotFoundException: cuando no existe un pedido con el ID dado.
 *   - EstadoInvalidoException: cuando se intenta una transición de estado no permitida.
 *   - Excepciones de Feign: propagadas desde ms-menu, ms-inventario, ms-pagos, ms-delivery.
 *
 * =============================================================================
 */
public interface PedidoService {

    /**
     * OPERACIÓN: Crear un nuevo pedido desde el checkout del carrito.
     *
     * FLUJO ESPERADO:
     *   Input:  PedidoRequestDTO con usuarioId, sucursalId, tipo, lista de ítems y notas.
     *   Process:
     *     1. Validar que la sucursal esté activa (llamada a ms-sucursales).
     *     2. Por cada ítem del request, consultar precio y nombre en ms-menu (MenuItemClient).
     *     3. Validar stock disponible en ms-inventario (InventarioClient).
     *     4. Calcular subtotal por ítem y total del pedido.
     *     5. Generar numeroPedido con formato PED-{YYYYMMDD}-{seq}.
     *     6. Crear Pedido con estado = PENDIENTE y persistir con Repository.
     *     7. Iniciar proceso de pago en ms-pagos (PagoClient).
     *   Output: PedidoResponseDTO con el pedido creado en estado PENDIENTE.
     *
     * @param dto PedidoRequestDTO validado con @Valid en el Controller.
     * @return PedidoResponseDTO del pedido recién creado.
     * @throws cl.triskeledu.pedidos.exception.EstadoInvalidoException si la sucursal no está activa.
     */
    PedidoResponseDTO crear(PedidoRequestDTO dto);

    /**
     * OPERACIÓN: Obtener el detalle completo de un pedido por su ID.
     *
     * FLUJO ESPERADO:
     *   Input:  id del pedido (Long).
     *   Process:
     *     1. Buscar pedido con ítems cargados (findByIdWithItems para evitar N+1).
     *     2. Verificar que el usuario autenticado tenga acceso (ROLE_CL solo ve los suyos).
     *   Output: PedidoResponseDTO con todos los campos incluyendo la lista de ítems.
     *
     * @param id ID del pedido a buscar.
     * @return PedidoResponseDTO con detalle completo.
     * @throws cl.triskeledu.pedidos.exception.PedidoNotFoundException si el ID no existe.
     */
    PedidoResponseDTO obtenerPorId(Long id);

    /**
     * OPERACIÓN: Obtener el historial de pedidos de un usuario.
     *
     * FLUJO ESPERADO:
     *   Input:  usuarioId (Long).
     *   Process:
     *     1. Consultar PedidoRepository.findByUsuarioIdOrderByCreadoEnDesc(usuarioId).
     *     2. Mapear cada entidad a PedidoResponseDTO.
     *   Output: List<PedidoResponseDTO> ordenada por fecha de creación descendente.
     *
     * NOTA DE SEGURIDAD:
     *   TODO: Verificar que el usuarioId del JWT coincide con el parámetro.
     *         Un CLIENTE solo puede ver sus propios pedidos.
     *         Un ADMIN o SUPER_ADMIN puede ver los de cualquier usuario.
     *
     * @param usuarioId ID del usuario a consultar.
     * @return Lista de pedidos del usuario.
     */
    List<PedidoResponseDTO> obtenerPorUsuario(Long usuarioId);

    /**
     * OPERACIÓN: Obtener la cola de pedidos activos de una sucursal (vista KDS).
     *
     * FLUJO ESPERADO:
     *   Input:  sucursalId (Long).
     *   Process:
     *     1. Consultar pedidos en estados [CONFIRMADO, EN_PREPARACION] para la sucursal.
     *     2. Ordenar por fecha de creación ASC (FIFO: el más antiguo tiene prioridad).
     *   Output: List<PedidoResponseDTO> ordenada por urgencia.
     *
     * ACCESO REQUERIDO: ROLE_CO (Cocinero) o ROLE_AD (Admin) de la misma sucursal.
     *
     * @param sucursalId ID de la sucursal.
     * @return Cola de pedidos activos para el KDS.
     */
    List<PedidoResponseDTO> obtenerColaSucursal(Long sucursalId);

    /**
     * OPERACIÓN: Cambiar el estado de un pedido (máquina de estados).
     *
     * FLUJO ESPERADO:
     *   Input:  id del pedido (Long) + nuevoEstado (EstadoPedido).
     *   Process:
     *     1. Obtener el pedido actual del Repository.
     *     2. Validar que la transición es permitida (ver EstadoPedido).
     *        Si no es válida: lanzar EstadoInvalidoException.
     *     3. Si estado == LISTO y tipo == DELIVERY: llamar a DeliveryClient para asignar repartidor.
     *     4. Si estado == CONFIRMADO: llamar a InventarioClient para descontar stock definitivo.
     *     5. Persistir el nuevo estado.
     *     6. Notificar cambio de estado a ms-notificaciones (NotificacionClient).
     *   Output: PedidoResponseDTO con el estado actualizado.
     *
     * TRANSICIONES VÁLIDAS (ver EstadoPedido):
     *   PENDIENTE → CONFIRMADO, CANCELADO
     *   CONFIRMADO → EN_PREPARACION, CANCELADO
     *   EN_PREPARACION → LISTO
     *   LISTO → EN_CAMINO (DELIVERY) | ENTREGADO (EN_LOCAL)
     *   EN_CAMINO → ENTREGADO
     *
     * @param id         ID del pedido a actualizar.
     * @param nuevoEstado Estado destino de la transición.
     * @return PedidoResponseDTO actualizado.
     * @throws cl.triskeledu.pedidos.exception.PedidoNotFoundException si el ID no existe.
     * @throws cl.triskeledu.pedidos.exception.EstadoInvalidoException si la transición no es válida.
     */
    PedidoResponseDTO cambiarEstado(Long id, EstadoPedido nuevoEstado);

    /**
     * OPERACIÓN: Cancelar un pedido.
     *
     * FLUJO ESPERADO:
     *   Input:  id del pedido (Long).
     *   Process:
     *     1. Verificar que el pedido existe y que su estado es PENDIENTE o CONFIRMADO.
     *     2. Si estado == CONFIRMADO: solicitar reembolso a ms-pagos (PagoClient.reembolsar()).
     *     3. Restaurar stock en ms-inventario si ya fue descontado (InventarioClient).
     *     4. Cambiar estado a CANCELADO y persistir.
     *     5. Notificar cancelación al usuario via ms-notificaciones.
     *   Output: PedidoResponseDTO del pedido cancelado.
     *
     * REGLA DE NEGOCIO CRÍTICA:
     *   No se pueden cancelar pedidos en estado EN_PREPARACION, LISTO, EN_CAMINO o ENTREGADO.
     *   TODO: Definir política de compensación financiera si se cancela un pedido CONFIRMADO.
     *
     * @param id ID del pedido a cancelar.
     * @return PedidoResponseDTO con estado CANCELADO.
     * @throws cl.triskeledu.pedidos.exception.PedidoNotFoundException si el ID no existe.
     * @throws cl.triskeledu.pedidos.exception.EstadoInvalidoException si el estado no permite cancelación.
     */
    PedidoResponseDTO cancelar(Long id);
}
