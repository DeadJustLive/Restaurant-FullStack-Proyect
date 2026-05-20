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
    /* @learn-error 2026-05-20: MapStruct "erroneous element java.util.ArrayList"
     *   SÍNTOMA: "No implementation was created for UsuarioMapper due to having
     *   a problem in the erroneous element java.util.ArrayList" al compilar.
     *   CAUSA RAÍZ: UsuarioResponseDTO tenía @Builder de Lombok. MapStruct
     *   detectaba el builder e intentaba usarlo para construir el DTO, pero
     *   el builder generado por Lombok chocaba con el annotation processing
     *   de MapStruct (conflicto de orden Lombok → MapStruct).
     *   SOLUCIÓN: Eliminar @Builder de UsuarioResponseDTO (no se usaba en
     *   ningún lado). MapStruct usa new + setters automáticamente con
     *   @NoArgsConstructor + setters (@Data).
     *   VALIDACIÓN: mvn clean compile genera UsuarioMapperImpl correctamente.
     *   mvn clean install -DskipTests compila 11/11 módulos sin errores.
     *   REFERENCIA: https://mapstruct.org/documentation/stable/reference/html/#lombok
     */

    @Mapping(target = "nombreCompleto",
             expression = "java(usuario.getNombre() + \" \" + usuario.getApellido())")
    @Mapping(target = "credencialId", source = "credencialId")
    UsuarioResponseDTO toResponseDTO(Usuario usuario);

    @Mapping(target = "credencial", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "creadoEn", ignore = true)
    @Mapping(target = "actualizadoEn", ignore = true)
    Usuario toEntity(UsuarioRequestDTO dto);

    @Mapping(target = "credencial", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "creadoEn", ignore = true)
    @Mapping(target = "actualizadoEn", ignore = true)
    void updateEntityFromDto(UsuarioRequestDTO dto, @MappingTarget Usuario target);
}
