package cl.triskeledu.auth.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

/**
 * =============================================================================
 * SECURITY FILTER: JwtAuthFilter (en ms-auth)
 * =============================================================================
 *
 * PROPÓSITO:
 *   Filtro HTTP que intercepta cada request y valida el JWT del header Authorization.
 *   Extiende OncePerRequestFilter para garantizar ejecución exactamente una vez por request.
 *
 * POSICIÓN EN LA CADENA DE FILTROS:
 *   Se registra ANTES del UsernamePasswordAuthenticationFilter de Spring Security.
 *   Configurado en SecurityConfig.java:
 *   http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
 *
 * FLUJO DE VALIDACIÓN:
 *   Request llega al filtro
 *       │
 *       ▼
 *   ¿Tiene header "Authorization: Bearer <token>"?
 *       │ NO → pasar la request sin autenticar (Spring Security decidirá si el endpoint requiere auth)
 *       │ SÍ →
 *       ▼
 *   JwtService.esValido(token)
 *       │ NO → 401 Unauthorized — limpiar SecurityContext y continuar
 *       │ SÍ →
 *       ▼
 *   Extraer userId, username, rol del token
 *       │
 *       ▼
 *   Construir UsernamePasswordAuthenticationToken con authorities=[SimpleGrantedAuthority(rol)]
 *       │
 *       ▼
 *   SecurityContextHolder.getContext().setAuthentication(auth)
 *       │
 *       ▼
 *   Continuar filterChain → Spring Security autoriza el endpoint con @PreAuthorize
 *
 * ENDPOINTS EXCLUIDOS (configurados en SecurityConfig):
 *   - POST /api/v1/auth/login
 *   - POST /api/v1/auth/register
 *   - POST /api/v1/auth/refresh
 *   - GET  /api/v1/menu/** (catálogo público)
 *
 * NOTA SOBRE OTROS MICROSERVICIOS:
 *   Cada microservicio (ms-pedidos, ms-menu, etc.) tiene su PROPIA copia de este filtro
 *   o una versión equivalente. La validación del JWT es LOCAL — no llama a ms-auth.
 *   Todos comparten la misma secretKey (o public key en RS256).
 *   TODO: Extraer JwtAuthFilter y JwtService a una librería común compartida entre todos los MS.
 *         Opciones: git submodule, librería Maven interna, Spring Cloud Config.
 *
 * =============================================================================
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {

    /*
     * TODO: Descomentar cuando JwtService esté implementado:
     * private final JwtService jwtService;
     */

    /**
     * MÉTODO PRINCIPAL DEL FILTRO: doFilterInternal
     *
     * LÓGICA:
     *   1. Extraer el header Authorization.
     *   2. Si no existe o no comienza con "Bearer ": continuar sin autenticar.
     *   3. Extraer el token (quitar "Bearer ").
     *   4. Validar el token con JwtService.esValido().
     *   5. Si válido: extraer claims y poblar SecurityContext.
     *   6. Si inválido: limpiar SecurityContext y continuar (el endpoint decidirá si es protegido).
     *
     * NOTA SOBRE EXTRACCIÓN DEL TOKEN:
     *   Authorization: Bearer eyJhbGci...
     *   token = header.substring(7) — quitar los 7 chars de "Bearer "
     *
     * @param request     Request HTTP entrante.
     * @param response    Response HTTP.
     * @param filterChain Cadena de filtros — llamar siempre al final.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // PASO 1: Extraer header Authorization
        String authHeader = request.getHeader("Authorization");

        // PASO 2: Si no hay Bearer token, continuar sin autenticar
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // PASO 3: Extraer token (quitar "Bearer ")
        String token = authHeader.substring(7);

        /*
         * PASO 4 & 5: Validar y poblar SecurityContext.
         * TODO: Descomentar y completar cuando JwtService esté implementado:
         *
         * try {
         *     if (jwtService.esValido(token) && SecurityContextHolder.getContext().getAuthentication() == null) {
         *         Long userId   = jwtService.extraerUserId(token);
         *         String username = jwtService.extraerUsername(token);
         *         String rol    = jwtService.extraerRol(token);
         *
         *         List<SimpleGrantedAuthority> authorities =
         *             List.of(new SimpleGrantedAuthority(rol));
         *
         *         UsernamePasswordAuthenticationToken authToken =
         *             new UsernamePasswordAuthenticationToken(username, null, authorities);
         *
         *         authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
         *         SecurityContextHolder.getContext().setAuthentication(authToken);
         *
         *         log.debug("[JwtFilter] Token válido — userId={}, rol={}", userId, rol);
         *     }
         * } catch (JwtException ex) {
         *     log.warn("[JwtFilter] Token inválido: {}", ex.getMessage());
         *     SecurityContextHolder.clearContext();
         *     // No lanzar excepción aquí — el endpoint protegido devolverá 401
         * }
         */

        // PASO 6: Continuar la cadena de filtros
        filterChain.doFilter(request, response);
    }
}
