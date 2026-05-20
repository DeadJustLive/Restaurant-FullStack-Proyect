package cl.triskeledu.auth.mapper;

import cl.triskeledu.auth.dto.request.UsuarioRequestDTO;
import cl.triskeledu.auth.dto.response.UsuarioResponseDTO;
import cl.triskeledu.auth.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * =============================================================================
 * MAPPER: UsuarioMapper
 * =============================================================================
 *
 * PROPÓSITO:
 *   Convierte entre entidad Usuario y sus DTOs usando MapStruct.
 *
 * CAMPO ESPECIAL: nombreCompleto
 *   El DTO response incluye `nombreCompleto` (nombre + " " + apellido) que no
 *   existe como columna en la BD. MapStruct no puede generarlo automáticamente.
 *   Se requiere una expresión o un @AfterMapping:
 *   @Mapping(target = "nombreCompleto", expression = "java(u.getNombre() + \" \" + u.getApellido())")
 *
 * CAMPO INMUTABLE: credencialId en updates
 *   En updateEntityFromDto(), el campo credencialId NO debe actualizarse.
 *   @Mapping(target = "credencialId", ignore = true) garantiza inmutabilidad.
 *
 * =============================================================================
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface UsuarioMapper {

    /**
     * MAPEO: Usuario (entity) → UsuarioResponseDTO
     *
     * CAMPO CALCULADO: nombreCompleto
     *   Se calcula concatenando nombre + " " + apellido.
     *   Usa expression de MapStruct para campos derivados no presentes en la entidad.
     *
     * CAMPOS AUTOMÁTICOS (mismo nombre):
     *   id, credencialId, nombre, apellido, telefono, direccion,
     *   imagenUrl, sucursalId, activo, creadoEn, actualizadoEn.
     *
     * @param usuario Entidad a convertir.
     * @return DTO de respuesta.
     */
    @Mapping(target = "nombreCompleto",
             expression = "java(usuario.getNombre() + \" \" + usuario.getApellido())")
    @Mapping(target = "credencialId", source = "credencial.id")
    UsuarioResponseDTO toResponseDTO(Usuario usuario);

    /**
     * MAPEO: UsuarioRequestDTO → Usuario (entity nueva para creación)
     *
     * CAMPOS NO MAPEADOS (quedan null — gestionados por BD/Hibernate):
     *   - id:             generado por la BD.
     *   - activo:         @Builder.Default = true.
     *   - creadoEn:       @CreationTimestamp.
     *   - actualizadoEn:  @UpdateTimestamp.
     *
     * @param dto DTO de request validado.
     * @return Entidad nueva sin persistir.
     */
    @Mapping(target = "credencial", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "creadoEn", ignore = true)
    @Mapping(target = "actualizadoEn", ignore = true)
    Usuario toEntity(UsuarioRequestDTO dto);

    /**
     * MAPEO: UsuarioRequestDTO → Usuario existente (actualización in-place para PUT)
     *
     * CAMPOS IGNORADOS EN ACTUALIZACIÓN:
     *   - credencialId: INMUTABLE. Nunca modificar después de la creación.
     *     Si se mapease, cualquier PUT podría reasignar el vínculo con ms-auth.
     *
     * USO EN UsuarioServiceImpl.actualizar():
     *   usuarioMapper.updateEntityFromDto(dto, existente);
     *   usuarioRepository.save(existente);
     *
     * @param dto    DTO con los nuevos valores.
     * @param target Entidad existente a actualizar in-place.
     */
    @Mapping(target = "credencial", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "creadoEn", ignore = true)
    @Mapping(target = "actualizadoEn", ignore = true)
    void updateEntityFromDto(UsuarioRequestDTO dto, @MappingTarget Usuario target);
}
