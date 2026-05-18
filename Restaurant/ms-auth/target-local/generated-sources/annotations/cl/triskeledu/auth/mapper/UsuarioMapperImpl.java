package cl.triskeledu.auth.mapper;

import cl.triskeledu.auth.dto.request.UsuarioRequestDTO;
import cl.triskeledu.auth.dto.response.UsuarioResponseDTO;
import cl.triskeledu.auth.entity.UserCredential;
import cl.triskeledu.auth.entity.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-17T21:57:35-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.2 (Red Hat, Inc.)"
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
        usuarioResponseDTO.id( usuario.getId() );
        usuarioResponseDTO.nombre( usuario.getNombre() );
        usuarioResponseDTO.apellido( usuario.getApellido() );
        usuarioResponseDTO.telefono( usuario.getTelefono() );
        usuarioResponseDTO.direccion( usuario.getDireccion() );
        usuarioResponseDTO.imagenUrl( usuario.getImagenUrl() );
        usuarioResponseDTO.sucursalId( usuario.getSucursalId() );
        usuarioResponseDTO.activo( usuario.getActivo() );
        usuarioResponseDTO.creadoEn( usuario.getCreadoEn() );
        usuarioResponseDTO.actualizadoEn( usuario.getActualizadoEn() );

        usuarioResponseDTO.nombreCompleto( usuario.getNombre() + " " + usuario.getApellido() );

        return usuarioResponseDTO.build();
    }

    @Override
    public Usuario toEntity(UsuarioRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.nombre( dto.getNombre() );
        usuario.apellido( dto.getApellido() );
        usuario.telefono( dto.getTelefono() );
        usuario.direccion( dto.getDireccion() );
        usuario.imagenUrl( dto.getImagenUrl() );
        usuario.sucursalId( dto.getSucursalId() );

        return usuario.build();
    }

    @Override
    public void updateEntityFromDto(UsuarioRequestDTO dto, Usuario target) {
        if ( dto == null ) {
            return;
        }

        target.setNombre( dto.getNombre() );
        target.setApellido( dto.getApellido() );
        target.setTelefono( dto.getTelefono() );
        target.setDireccion( dto.getDireccion() );
        target.setImagenUrl( dto.getImagenUrl() );
        target.setSucursalId( dto.getSucursalId() );
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
