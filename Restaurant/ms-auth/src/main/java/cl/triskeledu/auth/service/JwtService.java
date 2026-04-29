package cl.triskeledu.auth.service;

import cl.triskeledu.auth.entity.UserCredential;

/**
 * =============================================================================
 * SERVICE: JwtService
 * =============================================================================
 *
 * PROPÓSITO:
 *   Encapsula toda la lógica de creación, validación y extracción de claims
 *   de JSON Web Tokens (JWT). Es un servicio de infraestructura, no de negocio.
 *
 * DEPENDENCIAS EXTERNAS REQUERIDAS:
 *   - io.jsonwebtoken:jjwt-api:0.12.6
 *   - io.jsonwebtoken:jjwt-impl:0.12.6 (runtime)
 *   - io.jsonwebtoken:jjwt-jackson:0.12.6 (runtime)
 *   TODO: Agregar estas dependencias al pom.xml de ms-auth.
 *
 * CONFIGURACIÓN EN application.yml:
 *   jwt:
 *     secret: "${JWT_SECRET}"           # Variable de entorno — NUNCA en texto plano
 *     expiration-ms: 3600000            # 1 hora en millisegundos
 *     refresh-expiration-ms: 604800000  # 7 días en millisegundos
 *
 * ALGORITMO DE FIRMA:
 *   HS256 (HMAC-SHA256) — simétrico: misma clave para firmar y verificar.
 *   Ventaja: simple. Desventaja: todos los servicios que validan deben tener la misma clave.
 *   TODO: Migrar a RS256 (RSA) en producción:
 *         ms-auth firma con private key.
 *         Todos los demás MS verifican con public key (puede distribuirse libremente).
 *
 * REUTILIZACIÓN EN OTROS MICROSERVICIOS:
 *   Los demás microservicios NO importan este servicio directamente.
 *   Cada MS tiene su propio JwtAuthFilter que usa la misma secretKey (HS256)
 *   o la public key (RS256) para validar el token localmente sin llamar a ms-auth.
 *   Esto evita que ms-auth sea un punto único de fallo en la validación de requests.
 *
 * =============================================================================
 */
public interface JwtService {

    /**
     * OPERACIÓN: Generar un JWT de acceso para las credenciales dadas.
     *
     * FLUJO:
     *   Input:  UserCredential con id, username y rol.
     *   Process:
     *     1. Crear claims: sub=id, username=username, roles=[rol.name()], iat=now, exp=now+expiration.
     *     2. Firmar con secretKey usando algoritmo HS256.
     *     3. Serializar como string compacto: header.payload.signature
     *   Output: String JWT compacto listo para incluir en AuthResponseDTO.
     *
     * CLAIMS GENERADOS:
     *   - sub:      credential.id (String)     — subject, identifica al usuario
     *   - username: credential.username         — para conveniencia del frontend
     *   - roles:    [credential.rol.name()]     — lista de roles para @PreAuthorize
     *   - iat:      Instant.now()               — issued at
     *   - exp:      Instant.now() + expirationMs — expiration
     *
     * @param credential Entidad con los datos del usuario autenticado.
     * @return Token JWT firmado como String compacto.
     */
    String generarToken(UserCredential credential);

    /**
     * OPERACIÓN: Generar un refresh token para el usuario dado.
     *
     * FLUJO:
     *   Input:  userId (Long).
     *   Process:
     *     1. Generar UUID aleatorio o JWT de larga duración.
     *     2. Persistir en tabla `refresh_tokens` con fecha de expiración.
     *   Output: String con el valor del refresh token.
     *
     * TODO: Implementar cuando se cree RefreshTokenRepository.
     *
     * @param userId ID del usuario para el que se genera el refresh token.
     * @return String con el valor del refresh token.
     */
    String generarRefreshToken(Long userId);

    /**
     * OPERACIÓN: Extraer el ID del usuario (claim `sub`) del JWT.
     *
     * CASO DE USO:
     *   JwtAuthFilter llama a este método para identificar al usuario del token
     *   y construir el objeto Authentication para el SecurityContext.
     *
     * @param token JWT compacto.
     * @return ID del usuario como Long (extraído del claim `sub`).
     * @throws io.jsonwebtoken.JwtException si el token es inválido o está expirado.
     */
    Long extraerUserId(String token);

    /**
     * OPERACIÓN: Extraer el username del JWT (claim `username`).
     *
     * @param token JWT compacto.
     * @return Username del usuario.
     */
    String extraerUsername(String token);

    /**
     * OPERACIÓN: Extraer el rol del JWT (claim `roles`).
     *
     * NOTA: El claim `roles` es una lista en el JWT, pero en este sistema
     *       cada usuario tiene exactamente UN rol.
     *       Se retorna el primer elemento de la lista.
     *
     * @param token JWT compacto.
     * @return Nombre del rol (ej: "ROLE_CL").
     */
    String extraerRol(String token);

    /**
     * OPERACIÓN: Verificar si un JWT es válido (firma correcta y no expirado).
     *
     * CASO DE USO:
     *   JwtAuthFilter en cada microservicio llama a este método para cada request.
     *   Si retorna false: responder 401 Unauthorized sin procesar la request.
     *
     * VALIDACIONES INTERNAS:
     *   1. Firma: HMAC-SHA256 con la secretKey configurada.
     *   2. Expiración: exp > Instant.now().
     *   3. Estructura: header.payload.signature con Base64URL válido.
     *
     * @param token JWT compacto a validar.
     * @return true si el token es válido y no ha expirado.
     */
    boolean esValido(String token);
}
