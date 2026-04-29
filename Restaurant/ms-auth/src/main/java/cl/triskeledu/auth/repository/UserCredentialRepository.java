package cl.triskeledu.auth.repository;

import cl.triskeledu.auth.entity.UserCredential;
import cl.triskeledu.auth.entity.enums.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * =============================================================================
 * REPOSITORY: UserCredentialRepository
 * =============================================================================
 *
 * PROPÓSITO:
 *   Capa de acceso a datos para la entidad UserCredential.
 *   Provee acceso a las credenciales de autenticación almacenadas en la BD `auth`.
 *
 * BASE DE DATOS:
 *   PostgreSQL — base de datos `auth` — tabla `user_credentials`
 *
 * MÉTODO MÁS CRÍTICO: findByUsername()
 *   Es invocado en CADA intento de login. Debe ser extremadamente eficiente.
 *   La columna `username` debe tener un ÍNDICE en la BD para búsquedas O(log n).
 *   Spring Data crea el índice si se declara en la constraint UNIQUE de la entidad.
 *
 * SEGURIDAD:
 *   NUNCA ejecutar queries que retornen el campo `password` a capas superiores
 *   sin necesidad. En proyecciones de lectura que no requieran autenticación,
 *   excluir el campo password con una proyección o DTO de consulta.
 *
 * REGLAS DE AUDITORÍA:
 *   Cualquier operación de escritura (cambio de contraseña, cambio de rol, desactivación)
 *   debe registrarse en una tabla de auditoría.
 *   TODO: Implementar @EntityListener en UserCredential para auditoría automática.
 *
 * =============================================================================
 */
@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential, Long> {

    /**
     * CONSULTA CRÍTICA: Buscar credencial por username para el flujo de login.
     *
     * CASO DE USO:
     *   AuthServiceImpl.login() → userRepo.findByUsername(dto.getUsername())
     *   El Service toma el Optional y, si está vacío, lanza CredencialesInvalidasException.
     *   NOTA: No distinguir entre "username no existe" y "contraseña incorrecta" en el
     *         mensaje de error al cliente (ambos = 401) para evitar user enumeration attacks.
     *
     * INPUT:  username (String) — email del usuario que intenta autenticarse.
     * OUTPUT: Optional<UserCredential> — empty si el username no existe.
     *
     * PERFORMANCE:
     *   La columna `username` tiene índice UNIQUE en la BD (declarado en la entidad).
     *   Esta query es O(log n) — adecuado para alta concurrencia.
     *
     * SQL GENERADO:
     *   SELECT * FROM user_credentials WHERE username = ? LIMIT 1
     *
     * @param username Email/username del usuario.
     * @return Optional con la credencial encontrada, o empty si no existe.
     */
    Optional<UserCredential> findByUsername(String username);

    /**
     * CONSULTA: Verificar existencia de username sin cargar toda la entidad.
     *
     * CASO DE USO:
     *   AuthServiceImpl.registrar() verifica si el username ya está tomado ANTES de persistir.
     *   Más eficiente que findByUsername().isPresent() porque Spring Data genera
     *   SELECT 1 FROM ... LIMIT 1 en lugar de SELECT * FROM ...
     *
     * INPUT:  username (String).
     * OUTPUT: boolean — true si el username ya existe en la BD.
     *
     * NOTA: La comparación es case-sensitive por defecto en PostgreSQL.
     *       TODO: Normalizar username a minúsculas en el Service para evitar duplicados
     *             con distinto case (Juan@email.com vs juan@email.com).
     */
    boolean existsByUsername(String username);

    /**
     * QUERY MODIFYING: Cambiar el estado activo de un usuario.
     *
     * CASO DE USO:
     *   Admin desactiva o reactiva una cuenta: PATCH /api/v1/auth/usuarios/{id}/estado
     *   Más eficiente que cargar el objeto completo con findById() + setActivo() + save().
     *
     * INPUT:
     *   - id (Long): ID de la credencial a modificar.
     *   - activo (Boolean): nuevo estado.
     * OUTPUT: int — número de filas afectadas (0 si ID no existe, 1 si OK).
     *
     * NOTA: @Modifying requiere @Transactional en el Service que invoque este método.
     *
     * RIESGO:
     *   Al desactivar (activo=false), los JWT ya emitidos siguen siendo válidos.
     *   TODO: Al desactivar, agregar el token activo del usuario a una blacklist en Redis.
     *
     * JPQL:
     *   UPDATE UserCredential u SET u.activo = :activo WHERE u.id = :id
     */
    @Modifying
    @Query("UPDATE UserCredential u SET u.activo = :activo WHERE u.id = :id")
    int actualizarEstado(@Param("id") Long id, @Param("activo") Boolean activo);

    /**
     * QUERY MODIFYING: Cambiar contraseña de un usuario.
     *
     * CASO DE USO:
     *   Flujo de cambio de contraseña: el Service llama a este método DESPUÉS de:
     *   1. Verificar la contraseña actual con BCrypt.matches().
     *   2. Validar la nueva contraseña (mínimo 8 chars, no igual a la anterior).
     *   3. Hashear la nueva contraseña con BCrypt.encode().
     *   Solo entonces persiste el hash con este método.
     *
     * INPUT:
     *   - id (Long): ID de la credencial.
     *   - passwordHash (String): Hash BCrypt de la nueva contraseña.
     * OUTPUT: int — filas afectadas.
     *
     * SEGURIDAD CRÍTICA:
     *   El parámetro `passwordHash` DEBE ser siempre el resultado de BCrypt.encode().
     *   NUNCA pasar la contraseña en texto plano.
     *   TODO: Al cambiar contraseña, invalidar todos los refresh tokens del usuario.
     *
     * JPQL:
     *   UPDATE UserCredential u SET u.password = :passwordHash WHERE u.id = :id
     */
    @Modifying
    @Query("UPDATE UserCredential u SET u.password = :passwordHash WHERE u.id = :id")
    int actualizarPassword(@Param("id") Long id, @Param("passwordHash") String passwordHash);

    /**
     * CONSULTA: Contar usuarios activos por rol.
     *
     * CASO DE USO:
     *   ms-reportes o panel de SUPER_ADMIN para ver métricas de usuarios por tipo.
     *   Ej: cuántos clientes activos hay, cuántos cocineros, etc.
     *
     * INPUT:  rol (RolUsuario) — rol a contar.
     * OUTPUT: long — número de usuarios activos con ese rol.
     *
     * JPQL:
     *   SELECT COUNT(u) FROM UserCredential u WHERE u.rol = :rol AND u.activo = true
     */
    @Query("SELECT COUNT(u) FROM UserCredential u WHERE u.rol = :rol AND u.activo = true")
    long contarActivosPorRol(@Param("rol") RolUsuario rol);
}
