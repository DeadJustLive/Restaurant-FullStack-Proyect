package cl.triskeledu.auth.dto.response;

import cl.triskeledu.auth.entity.enums.RolUsuario;
import lombok.*;

/**
 * =============================================================================
 * DTO RESPONSE: AuthResponseDTO
 * =============================================================================
 *
 * PROPÓSITO:
 *   Representa la respuesta de los endpoints de autenticación:
 *   POST /login, POST /register y POST /refresh.
 *   Contiene el JWT que el cliente debe incluir en cada request subsiguiente.
 *
 * FLUJO DE DATOS:
 *   AuthServiceImpl genera JWT → construye AuthResponseDTO → Controller → JSON → Cliente
 *   El cliente almacena el `token` en localStorage/sessionStorage o en memoria segura.
 *   En cada request posterior: Authorization: Bearer <token>
 *
 * USO EN EL FRONTEND:
 *   1. Al recibir este DTO, el frontend decodifica el JWT (sin verificar firma — solo lectura).
 *   2. Extrae el claim `roles` para determinar qué vistas mostrar.
 *   3. Almacena `token` y `refreshToken` de forma segura.
 *   4. Usa `expiresIn` para programar la renovación automática del token (refresh).
 *
 * SEGURIDAD DEL ALMACENAMIENTO EN FRONTEND:
 *   - localStorage: persistente pero vulnerable a XSS.
 *   - sessionStorage: solo dura la sesión, menos persistente.
 *   - httpOnly cookie: más seguro contra XSS pero requiere configuración CORS + CSRF.
 *   TODO: Definir estrategia de almacenamiento de token con el equipo de frontend.
 *
 * CAMPOS OMITIDOS INTENCIONALMENTE:
 *   - `password`: NUNCA incluir en ningún response.
 *   - `id` de UserCredential: ya está dentro del JWT como claim `sub`.
 *
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDTO {

    /**
     * CAMPO: token
     * Tipo: String
     * Rol: JWT de acceso. El cliente lo incluye en cada request como:
     *      Authorization: Bearer <token>
     *      Contiene claims: sub (userId), username, roles, iat, exp.
     * Expiración: configurable en application.yml (recomendado: 1 hora en producción).
     */
    private String token;

    /**
     * CAMPO: refreshToken
     * Tipo: String
     * Rol: Token de renovación. De mayor duración que el JWT de acceso (ej: 7 días).
     *      Permite obtener un nuevo JWT sin re-login cuando el `token` expira.
     *      Se envía a POST /api/v1/auth/refresh para obtener un nuevo `token`.
     * Seguridad: Debe almacenarse con mayor cuidado que el token de acceso.
     *            TODO: Almacenar en httpOnly cookie en lugar de JSON body para mayor seguridad.
     */
    private String refreshToken;

    /**
     * CAMPO: expiresIn
     * Tipo: Long
     * Rol: Duración del token en segundos desde su emisión.
     *      Ejemplo: 3600 = el token expira en 1 hora.
     *      El frontend usa este valor para programar el refresh automático
     *      (ej: renovar 5 minutos antes de la expiración).
     */
    private Long expiresIn;

    /**
     * CAMPO: rol
     * Tipo: RolUsuario
     * Rol: Rol del usuario autenticado.
     *      El frontend usa este campo para redirigir a la vista correcta inmediatamente
     *      tras el login sin necesidad de decodificar el JWT.
     *      Ejemplo: ROLE_CO → redirigir a /cocina/kds, ROLE_CL → redirigir a /menu.
     * Nota: Este campo es redundante con el claim `roles` del JWT.
     *       Se incluye por conveniencia para el frontend.
     */
    private RolUsuario rol;

    /**
     * CAMPO: username
     * Tipo: String
     * Rol: Username (email) del usuario autenticado.
     *      Mostrado en la interfaz (ej: "Bienvenido, juan@email.com").
     *      También redundante con el claim del JWT, incluido por conveniencia.
     */
    private String username;
}
