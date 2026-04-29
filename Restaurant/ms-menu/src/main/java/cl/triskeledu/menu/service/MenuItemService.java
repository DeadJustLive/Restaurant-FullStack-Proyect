package cl.triskeledu.menu.service;

import cl.triskeledu.menu.dto.request.MenuItemRequestDTO;
import cl.triskeledu.menu.dto.response.MenuItemResponseDTO;

import java.util.List;

/**
 * =============================================================================
 * SERVICE INTERFACE: MenuItemService
 * =============================================================================
 *
 * PROPÓSITO:
 *   Define el contrato de negocio del dominio de menú.
 *   Desacopla el Controller de la implementación concreta (MenuItemServiceImpl).
 *
 * CONTRATO FEIGN:
 *   El método getById(Long id) es el más crítico del sistema.
 *   Es invocado internamente por el endpoint GET /api/v1/menu/{id}
 *   que ms-pedidos y ms-carrito consumen via Feign.
 *   No cambiar la firma de este método sin versionar el endpoint.
 *
 * EXCEPCIONES ESPERADAS:
 *   - MenuItemNotFoundException: ítem no encontrado por ID.
 *   - ItemNoDisponibleException: ítem encontrado pero disponible = false.
 *   - ItemDuplicadoException: nombre ya existe en la misma categoría (al crear).
 *   - Excepciones Feign: propagadas desde ms-categorias o ms-sucursales.
 *
 * =============================================================================
 */
public interface MenuItemService {

    /**
     * OPERACIÓN: Listar todos los ítems disponibles (catálogo público).
     *
     * FLUJO:
     *   Input:  (sin parámetros)
     *   Process: findByDisponibleTrueOrderByNombreAsc() → mapear a DTO
     *   Output: List<MenuItemResponseDTO> con todos los ítems disponibles.
     *
     * CACHÉ:
     *   TODO: @Cacheable("menu-catalogo") — alta frecuencia de lectura.
     *         Invalidar cache al crear/actualizar/cambiar disponibilidad de un ítem.
     *
     * @return Lista de ítems disponibles ordenados por nombre.
     */
    List<MenuItemResponseDTO> listarDisponibles();

    /**
     * OPERACIÓN: Listar ítems disponibles por categoría.
     *
     * FLUJO:
     *   Input:  categoriaId (Long)
     *   Process: findByCategoriaIdAndDisponibleTrue() → mapear a DTO
     *   Output: List<MenuItemResponseDTO> de la categoría, solo disponibles.
     *
     * @param categoriaId ID de la categoría a filtrar.
     * @return Lista de ítems disponibles de esa categoría.
     */
    List<MenuItemResponseDTO> listarPorCategoria(Long categoriaId);

    /**
     * OPERACIÓN: Listar ítems disponibles en una sucursal (globales + propios).
     *
     * FLUJO:
     *   Input:  sucursalId (Long)
     *   Process: findDisponiblesBySucursal(sucursalId) → incluye sucursalId IS NULL
     *   Output: List<MenuItemResponseDTO> disponibles para esa sucursal.
     *
     * REGLA CLAVE:
     *   Los ítems con sucursalId = null (globales) SIEMPRE deben aparecer.
     *   La query usa: WHERE (sucursal_id = :id OR sucursal_id IS NULL)
     *
     * @param sucursalId ID de la sucursal del usuario.
     * @return Lista unificada de ítems globales + específicos de la sucursal.
     */
    List<MenuItemResponseDTO> listarPorSucursal(Long sucursalId);

    /**
     * OPERACIÓN: Obtener un ítem por ID. ENDPOINT CRÍTICO para Feign.
     *
     * FLUJO:
     *   Input:  id (Long)
     *   Process:
     *     1. Buscar con findById(id). Si no existe → MenuItemNotFoundException.
     *     2. Verificar que disponible == true. Si no → ItemNoDisponibleException.
     *        NOTA: ms-pedidos necesita que este método falle si el ítem no está disponible.
     *   Output: MenuItemResponseDTO con nombre, precio y disponible = true garantizado.
     *
     * CONTRATO FEIGN CRÍTICO:
     *   ms-pedidos usa el campo `precio` y `nombre` de este response para el snapshot.
     *   ms-carrito usa `precio` y `disponible` para calcular el total.
     *   No modificar el formato del response sin actualizar los clientes Feign.
     *
     * @param id ID del MenuItem a buscar.
     * @return MenuItemResponseDTO del ítem existente y disponible.
     * @throws cl.triskeledu.menu.exception.MenuItemNotFoundException si id no existe.
     * @throws cl.triskeledu.menu.exception.ItemNoDisponibleException si disponible = false.
     */
    MenuItemResponseDTO getById(Long id);

    /**
     * OPERACIÓN: Crear un nuevo ítem del menú.
     *
     * FLUJO:
     *   Input:  MenuItemRequestDTO validado.
     *   Process:
     *     1. Verificar que no existe un ítem con el mismo nombre en la misma categoría.
     *     2. Validar categoriaId en ms-categorias (CategoriaClient.existsById()).
     *     3. Si sucursalId != null: validar en ms-sucursales (SucursalClient.isActiva()).
     *     4. Asignar disponible = true si no se especifica.
     *     5. Mapear DTO → Entity y persistir.
     *   Output: MenuItemResponseDTO del ítem creado con su ID asignado.
     *
     * ACCESO: Solo ROLE_AD y ROLE_SA.
     *
     * @param dto MenuItemRequestDTO con los datos del nuevo ítem.
     * @return MenuItemResponseDTO del ítem creado.
     * @throws cl.triskeledu.menu.exception.ItemDuplicadoException si el nombre ya existe en la categoría.
     */
    MenuItemResponseDTO crear(MenuItemRequestDTO dto);

    /**
     * OPERACIÓN: Actualizar completamente un ítem del menú (PUT).
     *
     * FLUJO:
     *   Input:  id (Long) + MenuItemRequestDTO con los nuevos datos.
     *   Process:
     *     1. Buscar el ítem existente. Si no existe → MenuItemNotFoundException.
     *     2. Validar categoriaId y sucursalId como en crear().
     *     3. Si el precio cambió: registrar en log de auditoría.
     *        TODO: Implementar PrecioHistorialRepository para trazabilidad.
     *     4. Actualizar todos los campos y persistir.
     *   Output: MenuItemResponseDTO actualizado.
     *
     * ACCESO: Solo ROLE_AD y ROLE_SA.
     *
     * @param id  ID del ítem a actualizar.
     * @param dto Datos nuevos del ítem.
     * @return MenuItemResponseDTO actualizado.
     * @throws cl.triskeledu.menu.exception.MenuItemNotFoundException si el ID no existe.
     */
    MenuItemResponseDTO actualizar(Long id, MenuItemRequestDTO dto);

    /**
     * OPERACIÓN: Cambiar el flag de disponibilidad de un ítem (PATCH).
     *
     * FLUJO:
     *   Input:  id (Long) + disponible (Boolean).
     *   Process:
     *     1. Buscar el ítem. Si no existe → MenuItemNotFoundException.
     *     2. Actualizar campo `disponible` y persistir.
     *     3. Si disponible = false: TODO: Notificar a ms-carrito para invalidar
     *        los carritos que contengan este ítem.
     *   Output: MenuItemResponseDTO con el nuevo valor de disponible.
     *
     * USO OPERATIVO:
     *   El cocinero o admin puede deshabilitar un ítem temporalmente si se acaba
     *   un ingrediente, sin necesidad de actualizar todo el ítem con PUT.
     *
     * @param id         ID del ítem.
     * @param disponible Nuevo valor del flag de disponibilidad.
     * @return MenuItemResponseDTO actualizado.
     */
    MenuItemResponseDTO cambiarDisponibilidad(Long id, Boolean disponible);

    /**
     * OPERACIÓN: Eliminar un ítem del menú por ID.
     *
     * FLUJO:
     *   Input:  id (Long).
     *   Process:
     *     1. Buscar el ítem. Si no existe → MenuItemNotFoundException.
     *     2. Verificar que el ítem no tenga pedidos activos asociados.
     *        TODO: Llamar a ms-pedidos para verificar (PedidoClient.tieneItemActivo(id)).
     *     3. Eliminar (o aplicar soft delete: disponible = false, nombre += "_ELIMINADO").
     *   Output: void.
     *
     * ACCESO: Solo ROLE_SA (Super Admin). La eliminación es una operación de alto riesgo.
     *
     * RECOMENDACIÓN DE DISEÑO:
     *   Implementar SOFT DELETE en lugar de eliminación física.
     *   La eliminación física de un ítem rompe la FK lógica en pedidos históricos.
     *   Con soft delete (campo `eliminado = true`) el ítem queda inaccesible para el cliente
     *   pero preserva la referencia histórica.
     *   TODO: Agregar campo `eliminado` a la entidad MenuItem y refactorizar todas las queries.
     *
     * @param id ID del ítem a eliminar.
     */
    void eliminar(Long id);
}
