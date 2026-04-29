package cl.triskeledu.usuarios.service;

import cl.triskeledu.usuarios.dto.request.UsuarioRequestDTO;
import cl.triskeledu.usuarios.dto.response.UsuarioResponseDTO;

import java.util.List;

/**
 * =============================================================================
 * SERVICE INTERFACE: UsuarioService
 * =============================================================================
 *
 * PROPÓSITO:
 *   Contrato de negocio del dominio de perfiles de usuario.
 *   Desacopla el Controller de la implementación concreta.
 *
 * MÉTODO CRÍTICO PARA FEIGN: getByCredencialId()
 *   Invocado por ms-pedidos, ms-notificaciones y ms-delivery.
 *   No cambiar la firma ni el formato del response sin actualizar los clientes Feign.
 *
 * EXCEPCIONES ESPERADAS:
 *   - UsuarioNotFoundException: perfil no encontrado por ID o credencialId.
 *   - CredencialYaVinculadaException: ya existe perfil para ese credencialId.
 *
 * =============================================================================
 */
public interface UsuarioService {

    /**
     * OPERACIÓN: Crear perfil de usuario (invocado por ms-auth vía Feign al registrar).
     *
     * FLUJO:
     *   Input:  UsuarioRequestDTO con credencialId, nombre, apellido.
     *   Process:
     *     1. Verificar que no existe perfil para credencialId → CredencialYaVinculadaException.
     *     2. Si sucursalId != null: validar en ms-sucursales (SucursalClient).
     *     3. Asignar activo = true por defecto.
     *     4. Mapear DTO → Entity y persistir.
     *   Output: UsuarioResponseDTO del perfil creado.
     *
     * @param dto Datos del nuevo perfil.
     * @return UsuarioResponseDTO del perfil creado con su ID asignado.
     */
    UsuarioResponseDTO crear(UsuarioRequestDTO dto);

    /**
     * OPERACIÓN: Obtener perfil por ID de perfil (interno ms-usuarios).
     *
     * @param id ID del perfil en ms-usuarios.
     * @return UsuarioResponseDTO del perfil encontrado.
     * @throws cl.triskeledu.usuarios.exception.UsuarioNotFoundException si no existe.
     */
    UsuarioResponseDTO getById(Long id);

    /**
     * OPERACIÓN: Obtener perfil por ID de credencial. MÉTODO CRÍTICO PARA FEIGN.
     *
     * FLUJO:
     *   Input:  credencialId (Long) — el claim `sub` del JWT.
     *   Process: findByCredencialId(credencialId) → si empty → UsuarioNotFoundException.
     *   Output: UsuarioResponseDTO con nombre, apellido, telefono, direccion.
     *
     * CONTRATO FEIGN:
     *   ms-pedidos, ms-notificaciones y ms-delivery consumen este método.
     *   El endpoint es GET /api/v1/usuarios/credencial/{credencialId}.
     *   No cambiar path ni response sin versionar el endpoint.
     *
     * @param credencialId ID de la credencial en ms-auth (claim `sub` del JWT).
     * @return UsuarioResponseDTO del perfil vinculado a esa credencial.
     */
    UsuarioResponseDTO getByCredencialId(Long credencialId);

    /**
     * OPERACIÓN: Listar empleados activos de una sucursal.
     *
     * FLUJO:
     *   Input:  sucursalId (Long).
     *   Process: findBySucursalIdAndActivoTrue(sucursalId) → mapear lista.
     *   Output: List<UsuarioResponseDTO> de empleados activos en esa sucursal.
     *
     * @param sucursalId ID de la sucursal.
     * @return Lista de perfiles activos de esa sucursal.
     */
    List<UsuarioResponseDTO> listarPorSucursal(Long sucursalId);

    /**
     * OPERACIÓN: Actualizar perfil de usuario (PUT — actualización completa).
     *
     * REGLA DE SEGURIDAD CRÍTICA:
     *   El Service debe verificar que el credencialId del JWT coincide con el
     *   credencialId del perfil que se intenta actualizar.
     *   Un ROLE_CL solo puede editar su propio perfil.
     *   Un ROLE_AD o ROLE_SA puede editar cualquier perfil.
     *   TODO: Implementar validación de propiedad del recurso en el Service.
     *
     * CAMPO INMUTABLE:
     *   El campo `credencialId` del Entity NUNCA debe ser modificado.
     *   El Mapper usa @Mapping(target = "credencialId", ignore = true).
     *
     * @param id  ID del perfil a actualizar.
     * @param dto Nuevos datos del perfil.
     * @return UsuarioResponseDTO actualizado.
     */
    UsuarioResponseDTO actualizar(Long id, UsuarioRequestDTO dto);

    /**
     * OPERACIÓN: Reasignar empleado a una sucursal (PATCH).
     *
     * FLUJO:
     *   Input:  id (Long), sucursalId (Long).
     *   Process:
     *     1. Verificar que el perfil existe.
     *     2. Validar la nueva sucursal en ms-sucursales (SucursalClient).
     *     3. reasignarSucursal(id, sucursalId).
     *   Output: UsuarioResponseDTO con la nueva sucursal.
     *
     * TODO: Verificar que no hay pedidos activos asignados al empleado antes de reasignar.
     *
     * @param id         ID del perfil del empleado.
     * @param sucursalId ID de la nueva sucursal.
     * @return UsuarioResponseDTO actualizado.
     */
    UsuarioResponseDTO reasignarSucursal(Long id, Long sucursalId);

    /**
     * OPERACIÓN: Eliminar perfil de usuario.
     *
     * RECOMENDACIÓN: Soft delete (activo = false) en lugar de eliminación física.
     * Eliminar físicamente un perfil rompe la referencia en pedidos históricos que
     * muestran el nombre del usuario.
     *
     * TODO: Notificar a ms-auth para desactivar la credencial en paralelo.
     *
     * @param id ID del perfil a eliminar.
     */
    void eliminar(Long id);
}
