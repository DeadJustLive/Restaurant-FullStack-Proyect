package cl.triskeledu.pedidos.client;

import cl.triskeledu.pedidos.client.dto.MenuItemClientResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * =============================================================================
 * FEIGN CLIENT: MenuItemClient (en ms-pedidos)
 * =============================================================================
 *
 * PROPÓSITO:
 *   Cliente HTTP declarativo que permite a ms-pedidos consultar ms-menu
 *   para obtener el nombre y precio de un producto al momento de crear un pedido.
 *   El resultado se usa para construir el SNAPSHOT en PedidoItem.
 *
 * CONFIGURACIÓN:
 *   - name: nombre de registro en Eureka del servicio destino ("ms-menu").
 *     Eureka resuelve la IP/puerto actual de ms-menu automáticamente.
 *   - path: prefijo de ruta base del servicio destino.
 *
 * FUNCIONAMIENTO:
 *   @FeignClient genera una implementación proxy de esta interface.
 *   Al llamar a getById(id), Feign construye: GET http://ms-menu/api/v1/menu/{id}
 *   y deserializa el response JSON en MenuItemClientResponseDTO.
 *
 * MANEJO DE ERRORES:
 *   - HTTP 404: Feign lanza FeignException.NotFound.
 *     PedidoServiceImpl debe capturar y lanzar ItemNoDisponibleException local.
 *   - HTTP 409: Feign lanza FeignException.Conflict (ítem no disponible en ms-menu).
 *     PedidoServiceImpl debe capturar y lanzar ItemNoDisponibleException local.
 *   - Timeout / ms-menu caído: Feign lanza FeignException genérico.
 *     TODO: Implementar @FeignClient fallback con @CircuitBreaker (Resilience4j)
 *           para retornar un error controlado cuando ms-menu no esté disponible.
 *
 * DTO DE RESPUESTA PROPIO:
 *   Se usa MenuItemClientResponseDTO (local a ms-pedidos) en lugar del DTO de ms-menu.
 *   Esto desacopla ms-pedidos del contrato interno de ms-menu.
 *   Solo se mapean los campos necesarios: id, nombre, precio, disponible.
 *
 * ACTIVACIÓN:
 *   Requiere @EnableFeignClients en RestaurantPedidosApplication.
 *
 * =============================================================================
 */
@FeignClient(name = "ms-menu", path = "/api/v1/menu")
public interface MenuItemClient {

    /**
     * LLAMADA FEIGN: Obtener datos de un ítem de menú por ID.
     *
     * MAPEA A: GET http://ms-menu/api/v1/menu/{id}
     *
     * CASO DE USO EN ms-pedidos:
     *   PedidoServiceImpl.crear() llama este método por CADA ítem del PedidoRequestDTO.
     *   Con la respuesta construye el PedidoItem con snapshot de nombre y precio.
     *
     * RESPUESTA ESPERADA (MenuItemClientResponseDTO):
     * {
     *   "id":         7,
     *   "nombre":     "Hamburguesa Clásica",
     *   "precio":     8990.00,
     *   "disponible": true
     * }
     *
     * ERRORES POSIBLES:
     *   FeignException.NotFound (404)  → ítem no existe en ms-menu.
     *   FeignException.Conflict (409)  → ítem no disponible (disponible = false).
     *
     * @param id ID del MenuItem a consultar en ms-menu.
     * @return MenuItemClientResponseDTO con los datos necesarios para el snapshot.
     */
    @GetMapping("/{id}")
    MenuItemClientResponseDTO getById(@PathVariable Long id);
}
