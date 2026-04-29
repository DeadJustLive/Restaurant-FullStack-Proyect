package cl.triskeledu.auth.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * =============================================================================
 * CONFIGURATION: SecurityConfig
 * =============================================================================
 *
 * PROPÓSITO:
 *   Configura Spring Security para el microservicio ms-auth.
 *   Define qué endpoints son públicos, cuáles requieren autenticación,
 *   la política de sesiones (STATELESS para JWT) y los beans de seguridad.
 *
 * ANOTACIONES:
 *   @EnableWebSecurity:    Activa el soporte de Spring Security HTTP.
 *   @EnableMethodSecurity: Activa @PreAuthorize y @PostAuthorize en los métodos.
 *
 * POLÍTICA DE SESIONES: STATELESS
 *   JWT es stateless: el servidor NO almacena sesión entre requests.
 *   Cada request debe incluir el JWT en el header Authorization.
 *   SessionCreationPolicy.STATELESS desactiva la creación de HttpSession.
 *
 * CSRF:
 *   CSRF se deshabilita porque la API es consumida por clientes SPA/mobile
 *   que no usan cookies de sesión. JWT como Bearer token no es vulnerable a CSRF.
 *   NOTA: Si se implementa refreshToken en httpOnly cookie, re-habilitar CSRF.
 *
 * BEANS EXPUESTOS:
 *   - PasswordEncoder (BCrypt): usado en AuthServiceImpl para hashear contraseñas.
 *   - AuthenticationManager: usado por Spring Security para autenticación estándar.
 *
 * TODO: Configurar CORS con los orígenes permitidos del frontend:
 *   http.cors(cors -> cors.configurationSource(corsConfigurationSource()))
 *
 * =============================================================================
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    /**
     * BEAN: SecurityFilterChain
     *
     * CONFIGURA:
     *   - Rutas públicas (sin JWT): /api/v1/auth/** (login, register, refresh)
     *   - Rutas protegidas: todo lo demás requiere JWT válido.
     *   - Posición del JwtAuthFilter: antes de UsernamePasswordAuthenticationFilter.
     *   - Política STATELESS: sin HttpSession.
     *   - CSRF desactivado (API REST con Bearer token).
     *
     * RUTAS PÚBLICAS ACTUALES:
     *   /api/v1/auth/login    → login de usuario
     *   /api/v1/auth/register → registro de usuario
     *   /api/v1/auth/refresh  → renovación de JWT
     *   /api/v1/auth/logout   → revocación de refresh token
     *
     * TODO: Agregar /api/v1/menu/** como ruta pública cuando se integre el API Gateway.
     *       El API Gateway podría centralizar las reglas de acceso público.
     *
     * @param http HttpSecurity builder de Spring Security.
     * @return SecurityFilterChain configurada.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            /*
             * Deshabilitar CSRF: API REST con Bearer token no requiere protección CSRF.
             * Ver nota en la clase sobre httpOnly cookies si se cambia la estrategia de token.
             */
            .csrf(csrf -> csrf.disable())

            /*
             * Configuración de autorización por endpoint.
             * Orden importa: las reglas más específicas van PRIMERO.
             */
            .authorizeHttpRequests(auth -> auth
                // Endpoints públicos de autenticación
                .requestMatchers("/api/v1/auth/**").permitAll()
                // TODO: Agregar endpoints públicos adicionales según crezca el sistema
                // .requestMatchers(HttpMethod.GET, "/api/v1/menu/**").permitAll()

                // Todos los demás endpoints requieren autenticación
                .anyRequest().authenticated()
            )

            /*
             * Política STATELESS: sin HttpSession.
             * Cada request es independiente y debe incluir el JWT.
             */
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            /*
             * Registrar el JwtAuthFilter antes del filtro estándar de Spring Security.
             * El JwtAuthFilter valida el token y puebla el SecurityContext.
             */
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /**
     * BEAN: PasswordEncoder (BCryptPasswordEncoder)
     *
     * PROPÓSITO:
     *   Provee el encoder de contraseñas a toda la aplicación.
     *   BCrypt con factor de costo por defecto (10 rondas).
     *
     * FACTOR DE COSTO:
     *   10 rondas = ~100ms por hash en hardware moderno.
     *   Aumentar a 12 en producción para mayor seguridad (~400ms).
     *   new BCryptPasswordEncoder(12) — balancear seguridad vs UX.
     *
     * INYECTADO EN:
     *   AuthServiceImpl → passwordEncoder.encode() y passwordEncoder.matches().
     *
     * @return BCryptPasswordEncoder como PasswordEncoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        /*
         * BCrypt con factor de costo 10 (default).
         * TODO: Cambiar a new BCryptPasswordEncoder(12) en producción.
         */
        return new BCryptPasswordEncoder();
    }

    /**
     * BEAN: AuthenticationManager
     *
     * PROPÓSITO:
     *   Bean estándar de Spring Security para autenticación.
     *   Requerido para flujos de autenticación programáticos si se necesitan
     *   (ej: usar authenticationManager.authenticate() en el service).
     *   En este sistema, la autenticación manual con BCrypt en AuthServiceImpl
     *   hace que este bean sea principalmente declarativo.
     *
     * @param authenticationConfiguration Configuración auto-detectada por Spring.
     * @return AuthenticationManager configurado.
     */
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
