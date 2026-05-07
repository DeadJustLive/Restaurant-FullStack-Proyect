package cl.triskeledu.auth.service.impl;

import cl.triskeledu.auth.dto.request.LoginRequestDTO;
import cl.triskeledu.auth.dto.request.RegisterRequestDTO;
import cl.triskeledu.auth.dto.response.AuthResponseDTO;
import cl.triskeledu.auth.entity.UserCredential;
import cl.triskeledu.auth.entity.enums.RolUsuario;
import cl.triskeledu.auth.exception.CredencialesInvalidasException;
import cl.triskeledu.auth.exception.CuentaDesactivadaException;
import cl.triskeledu.auth.exception.TokenInvalidoException;
import cl.triskeledu.auth.exception.UsuarioYaExisteException;
import cl.triskeledu.auth.repository.UserCredentialRepository;
import cl.triskeledu.auth.repository.UsuarioRepository;
import cl.triskeledu.auth.entity.Usuario;
import cl.triskeledu.auth.service.AuthService;
import cl.triskeledu.auth.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * =============================================================================
 * SERVICE IMPL: AuthServiceImpl — Implementación REAL (no mock)
 * =============================================================================
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserCredentialRepository userCredentialRepository;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    @Transactional
    public AuthResponseDTO registrar(RegisterRequestDTO dto) {
        log.info("Registrando usuario: {}", dto.getUsername());

        String usernameNormalizado = dto.getUsername().trim().toLowerCase();

        // 1. Verificar que el username no exista
        if (userCredentialRepository.findByUsername(usernameNormalizado).isPresent()) {
            throw new UsuarioYaExisteException("El usuario '" + usernameNormalizado + "' ya está registrado");
        }

        // 2. Determinar rol (ROLE_CL por defecto si no se especifica)
        RolUsuario rol = dto.getRol() != null ? dto.getRol() : RolUsuario.ROLE_CL;

        // 3. Crear entidad con password hasheado
        UserCredential credential = UserCredential.builder()
                .username(usernameNormalizado)
                .password(passwordEncoder.encode(dto.getPassword()))
                .rol(rol)
                .activo(true)
                .build();

        UserCredential saved = userCredentialRepository.save(credential);
        log.info("Usuario registrado exitosamente: id={}, rol={}", saved.getId(), saved.getRol());

        // 4. Crear perfil de Usuario inicial asociado a la credencial
        Usuario perfilUsuario = Usuario.builder()
                .credencial(saved)
                .nombre(usernameNormalizado.split("@")[0]) // Nombre por defecto basado en email
                .apellido("")
                .activo(true)
                .build();
        usuarioRepository.save(perfilUsuario);

        // 5. Generar tokens
        String token = jwtService.generarToken(saved);
        String refreshToken = jwtService.generarRefreshToken(saved.getId());

        return AuthResponseDTO.builder()
                .token(token)
                .refreshToken(refreshToken)
                .expiresIn(86400L) // 24 horas en segundos
                .rol(saved.getRol())
                .username(saved.getUsername())
                .build();
    }

    @Override
    public AuthResponseDTO login(LoginRequestDTO dto) {
        log.info("Intento de login para usuario: {}", dto.getUsername());

        String usernameNormalizado = dto.getUsername().trim().toLowerCase();

        // 1. Buscar credencial por username
        UserCredential credential = userCredentialRepository.findByUsername(usernameNormalizado)
                .orElseThrow(() -> {
                    // Anti-timing attack: ejecutar BCrypt con hash dummy para igualar tiempos
                    passwordEncoder.matches(dto.getPassword(), "$2a$10$dummyhashfortimingattak000000000000000000000000000000");
                    return new CredencialesInvalidasException("Credenciales inválidas");
                });

        // 2. Verificar password
        if (!passwordEncoder.matches(dto.getPassword(), credential.getPassword())) {
            throw new CredencialesInvalidasException("Credenciales inválidas");
        }

        // 3. Verificar cuenta activa
        if (!credential.getActivo()) {
            throw new CuentaDesactivadaException("La cuenta está desactivada. Contacte al administrador.");
        }

        log.info("Login exitoso para usuario: id={}, rol={}", credential.getId(), credential.getRol());

        // 4. Generar tokens
        String token = jwtService.generarToken(credential);
        String refreshToken = jwtService.generarRefreshToken(credential.getId());

        return AuthResponseDTO.builder()
                .token(token)
                .refreshToken(refreshToken)
                .expiresIn(86400L)
                .rol(credential.getRol())
                .username(credential.getUsername())
                .build();
    }

    @Override
    public AuthResponseDTO refresh(String refreshToken) {
        log.info("Solicitud de refresh token");

        // 1. Validar que el refresh token sea un JWT válido
        if (!jwtService.esValido(refreshToken)) {
            throw new TokenInvalidoException("El refresh token es inválido o ha expirado");
        }

        // 2. Extraer userId del refresh token
        Long userId = jwtService.extraerUserId(refreshToken);

        // 3. Cargar la credencial y verificar que sigue activa
        UserCredential credential = userCredentialRepository.findById(userId)
                .orElseThrow(() -> new TokenInvalidoException("Usuario del token no encontrado"));

        if (!credential.getActivo()) {
            throw new CuentaDesactivadaException("La cuenta está desactivada");
        }

        // 4. Generar nuevo access token (el refresh token se reutiliza si sigue vigente)
        String newToken = jwtService.generarToken(credential);

        log.info("Refresh exitoso para userId={}", userId);

        return AuthResponseDTO.builder()
                .token(newToken)
                .refreshToken(refreshToken) // se reutiliza el mismo refresh token
                .expiresIn(86400L)
                .rol(credential.getRol())
                .username(credential.getUsername())
                .build();
    }

    @Override
    public void logout(String refreshToken) {
        /*
         * Logout idempotente.
         * En un escenario completo con RefreshTokenRepository se revocaría
         * el token en la BD. Por ahora, el cliente descarta el token localmente
         * y el JWT de acceso expira naturalmente.
         *
         * TODO: Implementar persistencia de refresh tokens y blacklist.
         */
        log.info("Logout ejecutado — el cliente debe descartar los tokens localmente");
    }
}
