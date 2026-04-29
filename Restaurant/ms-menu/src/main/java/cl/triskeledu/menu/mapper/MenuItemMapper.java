package cl.triskeledu.menu.mapper;

import cl.triskeledu.menu.dto.request.MenuItemRequestDTO;
import cl.triskeledu.menu.dto.response.MenuItemResponseDTO;
import cl.triskeledu.menu.entity.MenuItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * =============================================================================
 * MAPPER: MenuItemMapper
 * =============================================================================
 *
 * PROPÓSITO:
 *   Convierte objetos entre la capa de entidades (MenuItem) y la capa de DTOs
 *   (MenuItemRequestDTO, MenuItemResponseDTO) usando MapStruct.
 *
 * MÉTODOS DEFINIDOS:
 *   1. toResponseDTO(entity)        → Entity → Response DTO (lectura)
 *   2. toEntity(requestDTO)         → Request DTO → Entity nueva (creación)
 *   3. updateEntityFromDto(dto, target) → Request DTO → Entity existente (actualización)
 *
 * MÉTODO updateEntityFromDto:
 *   Usa @MappingTarget para modificar la entidad existente en lugar de crear una nueva.
 *   Crítico para el flujo de actualización (PUT): evita perder campos como `creadoEn`
 *   que no vienen en el DTO de request.
 *   MapStruct ignora automáticamente los campos que no están en el DTO source.
 *
 * CAMPOS IGNORADOS EN toEntity():
 *   - `id`: no viene en el request, se genera en la BD.
 *   - `creadoEn`, `actualizadoEn`: gestionados por Hibernate.
 *   MapStruct los mapea a null por defecto; Hibernate los llena al persistir.
 *
 * CONTRATO DE FEIGN:
 *   toResponseDTO() genera el DTO que los clientes Feign de ms-pedidos y ms-carrito
 *   deserializan. No cambiar los nombres de los campos del DTO de response sin
 *   actualizar los clientes Feign.
 *
 * =============================================================================
 */
@Mapper(componentModel = "spring")
public interface MenuItemMapper {

    /**
     * MAPEO: MenuItem (entity) → MenuItemResponseDTO
     *
     * CAMPOS MAPEADOS AUTOMÁTICAMENTE (mismo nombre en entity y DTO):
     *   id, nombre, descripcion, precio, imagenUrl, disponible,
     *   categoriaId, sucursalId, creadoEn, actualizadoEn.
     *
     * RESULTADO: DTO listo para serializar a JSON en la respuesta HTTP
     *            y para ser deserializado por los clientes Feign.
     *
     * @param menuItem Entidad a convertir.
     * @return DTO de respuesta.
     */
    MenuItemResponseDTO toResponseDTO(MenuItem menuItem);

    /**
     * MAPEO: MenuItemRequestDTO → MenuItem (entity nueva para creación)
     *
     * CAMPOS MAPEADOS:
     *   nombre, descripcion, precio, imagenUrl, disponible, categoriaId, sucursalId.
     *
     * CAMPOS NO MAPEADOS (ausentes en el DTO — quedan como null):
     *   - id: generado por la BD (@GeneratedValue).
     *   - creadoEn: gestionado por @CreationTimestamp.
     *   - actualizadoEn: gestionado por @UpdateTimestamp.
     *
     * NOTA: Si disponible es null en el DTO, el Service debe asignar true por defecto
     *       DESPUÉS de llamar a este método (ver MenuItemServiceImpl.crear()).
     *
     * @param dto DTO de request validado.
     * @return Entidad nueva (sin persistir).
     */
    MenuItem toEntity(MenuItemRequestDTO dto);

    /**
     * MAPEO: MenuItemRequestDTO → MenuItem existente (actualización in-place)
     *
     * COMPORTAMIENTO:
     *   Modifica la entidad `target` con los valores del `dto` sin crear un objeto nuevo.
     *   Los campos que no están en el DTO (id, creadoEn, actualizadoEn) se preservan
     *   en la entidad target sin modificación.
     *
     * USO:
     *   menuItemMapper.updateEntityFromDto(dto, existente);
     *   menuItemRepository.save(existente); // Persiste los cambios
     *
     * VENTAJA:
     *   Evita perder el ID y los timestamps de la entidad al actualizar.
     *   Más eficiente que crear una entity nueva y copiar el ID manualmente.
     *
     * @param dto    DTO con los nuevos valores.
     * @param target Entidad existente a actualizar (modificada in-place).
     */
    void updateEntityFromDto(MenuItemRequestDTO dto, @MappingTarget MenuItem target);
}
