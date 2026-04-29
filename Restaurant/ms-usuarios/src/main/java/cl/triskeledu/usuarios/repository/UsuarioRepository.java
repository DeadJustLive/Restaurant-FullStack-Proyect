package cl.triskeledu.usuarios.repository;

import cl.triskeledu.usuarios.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * =============================================================================
 * REPOSITORY: UsuarioRepository
 * =============================================================================
 *
 * PROPÓSITO:
 *   Capa de acceso a datos para la entidad Usuario.
 *   Provee acceso a los perfiles de usuario en la BD `usuarios`.
 *
 * MÉTODO MÁS CRÍTICO: findByCredencialId()
 *   Invocado en cada request autenticada donde se necesita el perfil.
 *   La columna `credencial_id` tiene UNIQUE constraint que actúa como índice.
 *   Performance garantizada: O(log n) por índice único.
 *
 * REGLAS DE QUERIES:
 *   1. Siempre filtrar por activo=true en listados públicos.
 *   2. Admins pueden ver todos (activos e inactivos).
 *   3. Para listados de empleados por sucursal, excluir rol ROLE_CL
 *      (los clientes no tienen sucursal asignada).
 *      NOTA: el rol está en ms-auth — no en esta BD. El Service filtra por sucursalId != null.
 *
 * =============================================================================
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * CONSULTA CRÍTICA: Obtener perfil por ID de credencial (de ms-auth).
     *
     * CASO DE USO:
     *   - ms-auth llama POST /usuarios → necesita verificar que no existe perfil para credencialId.
     *   - Frontend autenticado: GET /usuarios/credencial/{sub} (sub del JWT).
     *   - ms-notificaciones y ms-pedidos: consultan el perfil para personalizar.
     *
     * SQL GENERADO:
     *   SELECT * FROM usuarios WHERE credencial_id = ? LIMIT 1
     *
     * ÍNDICE: La constraint UNIQUE uk_credencial_id garantiza eficiencia.
     *
     * @param credencialId ID de la credencial en ms-auth.
     * @return Optional<Usuario> — empty si no existe perfil para esa credencial.
     */
    Optional<Usuario> findByCredencialId(Long credencialId);

    /**
     * CONSULTA: Verificar si ya existe un perfil para una credencial.
     *
     * CASO DE USO:
     *   UsuarioServiceImpl.crear() verifica antes de persistir:
     *   Si retorna true → CredencialYaVinculadaException (no crear duplicado).
     *
     * EFICIENCIA: SELECT 1 vs SELECT * — más liviano que findByCredencialId().isPresent().
     *
     * @param credencialId ID de la credencial a verificar.
     * @return true si ya existe un perfil vinculado a esa credencial.
     */
    boolean existsByCredencialId(Long credencialId);

    /**
     * CONSULTA: Listar perfiles activos de una sucursal (empleados activos).
     *
     * CASO DE USO:
     *   GET /api/v1/usuarios/sucursal/{sucursalId}
     *   El admin de una sucursal ve la lista de empleados asignados.
     *   Solo activos (activo = true). Los inactivos se muestran en vista admin avanzada.
     *
     * NOTA DE DISEÑO:
     *   Esta query retorna todos los usuarios con ese sucursalId — incluyendo clientes
     *   si por algún error tienen sucursalId asignado. El Service debe validar que
     *   el sucursalId solo se asigna a empleados (rol != ROLE_CL en ms-auth).
     *   Como el rol no está en esta BD, la validación debe ser en el Service al crear/asignar.
     *
     * SQL GENERADO:
     *   SELECT * FROM usuarios WHERE sucursal_id = ? AND activo = true ORDER BY apellido ASC, nombre ASC
     *
     * @param sucursalId ID de la sucursal a filtrar.
     * @return Lista de perfiles activos asignados a esa sucursal.
     */
    List<Usuario> findBySucursalIdAndActivoTrueOrderByApellidoAscNombreAsc(Long sucursalId);

    /**
     * QUERY MODIFYING: Reasignar la sucursal de un empleado.
     *
     * CASO DE USO:
     *   PATCH /api/v1/usuarios/{id}/sucursal
     *   El admin reasigna un empleado a una sucursal diferente.
     *   Más eficiente que cargar el objeto completo.
     *
     * NOTA: @Modifying requiere @Transactional en el Service.
     *       TODO: Validar que la nueva sucursal exista y esté activa (SucursalClient).
     *             Validar que no hay pedidos activos asignados al empleado en la sucursal actual.
     *
     * JPQL:
     *   UPDATE Usuario u SET u.sucursalId = :sucursalId WHERE u.id = :id
     *
     * @param id         ID del perfil a actualizar.
     * @param sucursalId Nueva sucursal asignada (null = sin sucursal).
     * @return int — filas afectadas.
     */
    @Modifying
    @Query("UPDATE Usuario u SET u.sucursalId = :sucursalId WHERE u.id = :id")
    int reasignarSucursal(@Param("id") Long id, @Param("sucursalId") Long sucursalId);

    /**
     * QUERY MODIFYING: Cambiar estado activo de un perfil.
     *
     * CASO DE USO:
     *   Sincronización con ms-auth cuando la credencial es desactivada.
     *   ms-auth puede notificar a ms-usuarios para que desactive el perfil en paralelo.
     *
     * TODO: Crear endpoint interno PATCH /api/v1/usuarios/credencial/{credId}/estado
     *       invocado por ms-auth vía Feign cuando el admin desactiva una cuenta.
     *
     * JPQL:
     *   UPDATE Usuario u SET u.activo = :activo WHERE u.credencialId = :credencialId
     *
     * @param credencialId ID de credencial cuyo perfil se actualizará.
     * @param activo       Nuevo estado.
     * @return int — filas afectadas.
     */
    @Modifying
    @Query("UPDATE Usuario u SET u.activo = :activo WHERE u.credencialId = :credencialId")
    int actualizarEstadoPorCredencial(@Param("credencialId") Long credencialId,
                                      @Param("activo") Boolean activo);
}
