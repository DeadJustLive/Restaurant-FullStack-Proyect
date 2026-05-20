package cl.triskeledu.auth.mapper;

import cl.triskeledu.auth.dto.request.UsuarioRequestDTO;
import cl.triskeledu.auth.dto.response.UsuarioResponseDTO;
import cl.triskeledu.auth.entity.UserCredential;
import cl.triskeledu.auth.entity.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-19T19:17:34-0400",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioResponseDTO.UsuarioResponseDTOBuilder usuarioResponseDTO = UsuarioResponseDTO.builder();

        usuarioResponseDTO.credencialId( usuarioCredencialId( usuario ) );
        usuarioResponseDTO.activo( usuario.getActivo() );
        usuarioResponseDTO.actualizadoEn( usuario.getActualizadoEn() );
        usuarioResponseDTO.apellido( usuario.getApellido() );
        usuarioResponseDTO.creadoEn( usuario.getCreadoEn() );
        usuarioResponseDTO.direccion( usuario.getDireccion() );
        usuarioResponseDTO.id( usuario.getId() );
        usuarioResponseDTO.imagenUrl( usuario.getImagenUrl() );
        usuarioResponseDTO.nombre( usuario.getNombre() );
        usuarioResponseDTO.sucursalId( usuario.getSucursalId() );
        usuarioResponseDTO.telefono( usuario.getTelefono() );

        usuarioResponseDTO.nombreCompleto( usuario.getNombre() + " " + usuario.getApellido() );

        return usuarioResponseDTO.build();
    }

    @Override
    public Usuario toEntity(UsuarioRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.apellido( dto.getApellido() );
        usuario.direccion( dto.getDireccion() );
        usuario.imagenUrl( dto.getImagenUrl() );
        usuario.nombre( dto.getNombre() );
        usuario.sucursalId( dto.getSucursalId() );
        usuario.telefono( dto.getTelefono() );

        return usuario.build();
    }

    @Override
    public void updateEntityFromDto(UsuarioRequestDTO dto, Usuario target) {
        if ( dto == null ) {
            return;
        }

        target.setApellido( dto.getApellido() );
        target.setDireccion( dto.getDireccion() );
        target.setImagenUrl( dto.getImagenUrl() );
        target.setNombre( dto.getNombre() );
        target.setSucursalId( dto.getSucursalId() );
        target.setTelefono( dto.getTelefono() );
    }

    private Long usuarioCredencialId(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }
        UserCredential credencial = usuario.getCredencial();
        if ( credencial == null ) {
            return null;
        }
        Long id = credencial.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
