package cl.triskeledu.auth.service.impl;

import cl.triskeledu.auth.dto.request.LoginRequestDTO;
import cl.triskeledu.auth.dto.request.RegisterRequestDTO;
import cl.triskeledu.auth.dto.response.AuthResponseDTO;
import cl.triskeledu.auth.repository.UserCredentialRepository;
import cl.triskeledu.auth.service.AuthService;
import cl.triskeledu.auth.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * =============================================================================
 * SERVICE IMPL: AuthServiceImpl
 * =============================================================================
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserCredentialRepository userCredentialRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public AuthResponseDTO registrar(RegisterRequestDTO dto) {
        /*
         * INTENCIÓN:
         * Registrar nuevas credenciales de usuario.
         *
         * FLUJO ESPERADO:
         * Input: RegisterRequestDTO (username, password, rol)
         * Process:
         * 1. Verificar si username existe (UsuarioYaExisteException si es así).
         * 2. Normalizar username a minúsculas.
         * 3. Hashear password usando PasswordEncoder.
         * 4. Asignar ROLE_CL si rol viene null.
         * 5. Guardar en UserCredentialRepository con activo=true.
         * 6. Invocar ms-usuarios (Feign) para crear el perfil público (SAGA
         * simplificado).
         * 7. Generar tokens via JwtService.
         * Output: AuthResponseDTO (JWT).
         *
         * DEPENDENCIAS:
         * - ms-usuarios (para crear perfil vinculado al credencialId generado).
         */
        log.info("Registrando usuario mockeado (Happy Path): {}", dto.getUsername());
        return AuthResponseDTO.builder()
                .token("mock-jwt-token-for-" + dto.getUsername())
                .refreshToken("mock-refresh-token")
                .expiresIn(3600L)
                .build();
    }

    @Override
    public AuthResponseDTO login(LoginRequestDTO dto) {
        /*
         * INTENCIÓN:
         * Autenticar credenciales y emitir JWT.
         *
         * FLUJO ESPERADO:
         * Input: LoginRequestDTO (username, password)
         * Process:
         * 1. Normalizar username.
         * 2. Buscar en repository. Si no existe -> lanzar
         * CredencialesInvalidasException.
         * (Importante: ejecutar comparación dummy con BCrypt para prevenir timing
         * attacks).
         * 3. Verificar password con PasswordEncoder.matches(). Si falla ->
         * CredencialesInvalidasException.
         * 4. Verificar si activo==true. Si no -> CuentaDesactivadaException.
         * 5. Generar JWT y Refresh Token con JwtService.
         * Output: AuthResponseDTO.
         */
        log.info("Login mockeado (Happy Path) para usuario: {}", dto.getUsername());
        return AuthResponseDTO.builder()
                .token("mock-jwt-token-for-" + dto.getUsername())
                .refreshToken("mock-refresh-token")
                .expiresIn(3600L)
                .build();
    }

    @Override
    public AuthResponseDTO refresh(String refreshToken) {
        /*
         * INTENCIÓN:
         * Renovar JWT usando un refresh token válido.
         *
         * FLUJO ESPERADO:
         * Input: refreshToken
         * Process:
         * 1. Buscar token en BD (Refresh Token Repository futuro).
         * 2. Verificar expiración y revocación.
         * 3. Cargar credencial y verificar si sigue activa.
         * 4. Generar nuevo JWT.
         * Output: AuthResponseDTO.
         */
        log.info("Refresh token mockeado (Happy Path)");
        return AuthResponseDTO.builder()
                .token("mock-new-jwt-token")
                .refreshToken("mock-new-refresh-token")
                .expiresIn(3600L)
                .build();
    }

    @Override
    public void logout(String refreshToken) {
        /*
         * INTENCIÓN:
         * Revocar el refresh token.
         *
         * FLUJO ESPERADO:
         * Input: refreshToken
         * Process:
         * 1. Marcar el token en BD como revocado = true.
         * Output: void (Logout idempotente).
         */
        log.info("Logout mockeado (Happy Path) con token: {}", refreshToken);
        // Do nothing in mock
    }
}
