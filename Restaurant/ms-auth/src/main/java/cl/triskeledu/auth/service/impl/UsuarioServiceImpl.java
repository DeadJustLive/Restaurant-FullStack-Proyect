package cl.triskeledu.auth.service.impl;

import cl.triskeledu.auth.dto.event.AuthEventDTO;
import cl.triskeledu.auth.dto.request.UsuarioRequestDTO;
import cl.triskeledu.auth.dto.response.UsuarioResponseDTO;
import cl.triskeledu.auth.mapper.UsuarioMapper;
import cl.triskeledu.auth.repository.UsuarioRepository;
import cl.triskeledu.auth.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;
import cl.triskeledu.auth.entity.Usuario;

/**
 * =============================================================================
 * SERVICE IMPL: UsuarioServiceImpl
 * =============================================================================
 *
 * PROPÓSITO:
 *   Implementación concreta del contrato UsuarioService.
 *   Orquesta la lógica de negocio del dominio de perfiles de usuario.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final KafkaTemplate<String, AuthEventDTO> kafkaTemplate;

  @Override
    public UsuarioResponseDTO crear(UsuarioRequestDTO dto) {
        log.info("Creando perfil para credencial: {}", dto.getCredencialId());
        
        if (usuarioRepository.existsByCredencialId(dto.getCredencialId())) {
            throw new cl.triskeledu.auth.exception.CredencialYaVinculadaException("La credencial ya tiene un perfil vinculado.");
        }
        
        Usuario usuario = usuarioMapper.toEntity(dto);
        cl.triskeledu.auth.entity.UserCredential cred = new cl.triskeledu.auth.entity.UserCredential();
        cred.setId(dto.getCredencialId());
        usuario.setCredencial(cred);
        
        Usuario saved = usuarioRepository.save(usuario);
        UsuarioResponseDTO response = usuarioMapper.toResponseDTO(saved);

        this.notificarCambio(saved);

        return response;
    }

    @Override
    public UsuarioResponseDTO getById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new cl.triskeledu.auth.exception.UsuarioNotFoundException("Perfil no encontrado con ID: " + id));
        return usuarioMapper.toResponseDTO(usuario);
    }

    @Override
    public UsuarioResponseDTO getByCredencialId(Long credencialId) {
        Usuario usuario = usuarioRepository.findByCredencialId(credencialId)
                .orElseThrow(() -> new cl.triskeledu.auth.exception.UsuarioNotFoundException("Perfil no encontrado para credencial ID: " + credencialId));
        return usuarioMapper.toResponseDTO(usuario);
    }

    @Override
    public List<UsuarioResponseDTO> listarPorSucursal(Long sucursalId) {
        return usuarioRepository.findBySucursalIdAndActivoTrueOrderByApellidoAscNombreAsc(sucursalId).stream()
                .map(usuarioMapper::toResponseDTO)
                .toList();
    }

   @Override
    public UsuarioResponseDTO actualizar(Long id, UsuarioRequestDTO dto) {
        log.info("Actualizando perfil ID: {}", id);
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new cl.triskeledu.auth.exception.UsuarioNotFoundException("Perfil no encontrado con ID: " + id));
        
        usuarioMapper.updateEntityFromDto(dto, usuario);
        Usuario updated = usuarioRepository.save(usuario);
        UsuarioResponseDTO response = usuarioMapper.toResponseDTO(updated);

        // [KAFKA] AVISAMOS QUE SE MODIFICÓ EL USUARIO
        this.notificarCambio(updated);

        return response;
    }

    @Override
    public UsuarioResponseDTO reasignarSucursal(Long id, Long sucursalId) {
        log.info("Reasignando sucursal de perfil ID: {} a sucursalId: {}", id, sucursalId);
        if (!usuarioRepository.existsById(id)) {
            throw new cl.triskeledu.auth.exception.UsuarioNotFoundException("Perfil no encontrado con ID: " + id);
        }
        usuarioRepository.reasignarSucursal(id, sucursalId);
        
        // Volver a buscar para retornar DTO actualizado
        return getById(id);
    }

   @Override
    public void eliminar(Long id) {
        log.info("Eliminando (soft delete) perfil ID: {}", id);
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new cl.triskeledu.auth.exception.UsuarioNotFoundException("Perfil no encontrado con ID: " + id));
        
        usuario.setActivo(false);
        Usuario usuarioActualizado = usuarioRepository.save(usuario);
        
        // [KAFKA] Avisamos que el usuario fue desactivado
        this.notificarCambio(usuarioActualizado);
        
        // TODO: Notificar a ms-auth (UserCredential) si corresponde...
    }
    private void notificarCambio(Usuario usuario) {
        AuthEventDTO evento = AuthEventDTO.builder()
                .id(usuario.getId()) // Este es el ID que usará la proyección como auth_user_id
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .direccion(usuario.getDireccion())
                .telefono(usuario.getTelefono())
                .build();

        log.info("Enviando evento de actualización para usuario ID: {}", usuario.getId());
        kafkaTemplate.send("topico-usuarios", evento);
    }
}
