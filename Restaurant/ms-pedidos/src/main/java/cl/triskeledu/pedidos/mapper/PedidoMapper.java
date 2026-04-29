package cl.triskeledu.pedidos.mapper;

import cl.triskeledu.pedidos.dto.response.PedidoItemResponseDTO;
import cl.triskeledu.pedidos.dto.response.PedidoResponseDTO;
import cl.triskeledu.pedidos.entity.Pedido;
import cl.triskeledu.pedidos.entity.PedidoItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * =============================================================================
 * MAPPER: PedidoMapper
 * =============================================================================
 *
 * PROPÓSITO:
 *   Convierte objetos entre la capa de entidades JPA y la capa de DTOs,
 *   utilizando MapStruct como generador de código en tiempo de compilación.
 *
 * FUNCIONAMIENTO DE MAPSTRUCT:
 *   MapStruct genera la implementación de este interface automáticamente
 *   durante la compilación (mediante el procesador de anotaciones).
 *   El bean generado es inyectado por Spring vía componentModel = "spring".
 *
 * CONVENCIÓN DE NOMBRES DE CAMPOS:
 *   Si los campos tienen el mismo nombre en entidad y DTO, MapStruct los mapea
 *   automáticamente. Si difieren, se usa @Mapping(source=..., target=...).
 *
 * CAMPOS IGNORADOS:
 *   Por defecto, campos sin correspondencia directa se pasan como null.
 *   Usar @Mapping(target = "campo", ignore = true) para excluir explícitamente.
 *
 * DEPENDENCIAS:
 *   - Pedido (entity) → PedidoResponseDTO
 *   - PedidoItem (entity) → PedidoItemResponseDTO
 *
 * REGLAS DE SEGURIDAD:
 *   Este mapper NUNCA debe mapear campos sensibles de la entidad al DTO
 *   si esos campos no deben ser expuestos públicamente.
 *
 * =============================================================================
 */
@Mapper(componentModel = "spring")
public interface PedidoMapper {

    /**
     * MAPEO: Pedido (entity) → PedidoResponseDTO
     *
     * COMPORTAMIENTO AUTOMÁTICO:
     *   MapStruct mapea todos los campos con el mismo nombre automáticamente:
     *   id, numeroPedido, usuarioId, sucursalId, estado, tipo, total, notas, creadoEn, actualizadoEn.
     *
     * MAPEO ESPECIAL: items
     *   La lista items de tipo List<PedidoItem> → List<PedidoItemResponseDTO>
     *   se convierte usando el método toItemResponseDTO() definido más abajo.
     *   MapStruct detecta este método automáticamente porque los tipos coinciden.
     *
     * ADVERTENCIA:
     *   Si la relación items es FetchType.LAZY, asegurarse de que este mapper
     *   se invoque DENTRO de una transacción activa, o usar findByIdWithItems()
     *   del Repository para pre-cargar los ítems antes de mapear.
     *
     * @param pedido Entidad JPA a convertir.
     * @return DTO de respuesta listo para serializar a JSON.
     */
    PedidoResponseDTO toResponseDTO(Pedido pedido);

    /**
     * MAPEO: PedidoItem (entity) → PedidoItemResponseDTO
     *
     * COMPORTAMIENTO AUTOMÁTICO:
     *   id, menuItemId, nombreSnapshot, precioUnitario, cantidad, subtotal
     *   se mapean automáticamente por nombre.
     *
     * CAMPO EXCLUIDO: pedido
     *   El campo `pedido` (referencia al padre) no existe en PedidoItemResponseDTO,
     *   por lo que MapStruct lo ignora automáticamente.
     *   Si se agregara al DTO, causaría recursión infinita. NO agregar.
     *
     * @param item Entidad JPA del ítem a convertir.
     * @return DTO de respuesta del ítem.
     */
    PedidoItemResponseDTO toItemResponseDTO(PedidoItem item);

    /*
     * -----------------------------------------------------------------------
     * NOTA SOBRE MAPEOS INVERSOS (DTO → Entity):
     * -----------------------------------------------------------------------
     * No se define toEntity(PedidoRequestDTO dto) → Pedido aquí intencionalmente.
     *
     * MOTIVO:
     *   La construcción de la entidad Pedido desde el DTO de request NO es
     *   un mapeo directo. Requiere:
     *   1. Consultar ms-menu para obtener precio y nombre de cada ítem.
     *   2. Calcular subtotal y total.
     *   3. Generar numeroPedido.
     *   4. Asignar estado = PENDIENTE.
     *
     *   Esta lógica pertenece a PedidoServiceImpl, no a un mapper automático.
     *   Usar MapStruct para mapear desde el request induciría errores de negocio.
     * -----------------------------------------------------------------------
     */
}
