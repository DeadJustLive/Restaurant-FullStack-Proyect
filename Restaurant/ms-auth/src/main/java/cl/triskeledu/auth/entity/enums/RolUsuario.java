package cl.triskeledu.auth.entity.enums;

/**
 * =============================================================================
 * ENUM: RolUsuario
 * =============================================================================
 *
 * PROPÓSITO:
 * Define los roles posibles en el sistema de restaurante.
 * El valor de este enum se persiste como STRING en la BD (columna `rol`)
 * y se incluye en el claim "roles" del JWT al hacer login.
 *
 * CONVENCIÓN DE NOMBRES CON SPRING SECURITY:
 * Spring Security espera que los roles comiencen con el prefijo "ROLE_".
 * En @PreAuthorize se usa: hasRole('ROLE_AD') o
 * hasAnyRole('ROLE_AD','ROLE_SA').
 * El JwtAuthFilter debe poblar el SecurityContext con el prefijo "ROLE_".
 *
 * DESCRIPCIÓN DE ROLES:
 * Ver tabla completa en /Restaurant/README.md — Sección "Roles del Sistema".
 *
 * RIESGO DE MODIFICACIÓN:
 * CRÍTICO. Renombrar un valor sin migración de datos deja registros en la BD
 * con el valor anterior, rompiendo la autenticación de todos los usuarios de
 * ese rol.
 * Si se renombra: 1) ejecutar UPDATE en BD, 2) actualizar JwtAuthFilter, 3)
 * actualizar @PreAuthorize en todos los MS.
 * NUNCA eliminar un valor mientras existan usuarios con ese rol en la BD.
 *
 * PERSISTENCIA:
 * 
 * @Enumerated(EnumType.STRING) en UserCredential.rol.
 *                              Almacenado tal cual: "ROLE_SA", "ROLE_AD", etc.
 *
 *                              =============================================================================
 */
public enum RolUsuario {

    /**
     * SUPER ADMIN — Control total del sistema y de todas las sucursales.
     * Puede gestionar usuarios, roles, sucursales, menú, reportes y configuración
     * global.
     * Acceso a todos los endpoints sin restricción.
     * Solo debe existir un número muy limitado de cuentas con este rol.
     */
    ROLE_SA,

    /**
     * ADMIN — Administrador de su sucursal asignada.
     * Puede gestionar el menú de su sucursal, ver pedidos, reportes básicos e
     * inventario.
     * NO puede crear otros administradores ni acceder a otras sucursales.
     */
    ROLE_AD,

    /**
     * COCINERO — Personal de cocina que gestiona la preparación de pedidos.
     * Acceso exclusivo a la vista KDS (Kitchen Display System).
     * Solo puede ver y cambiar estado de pedidos en su sucursal.
     * NO puede ver historial de otros usuarios ni acceder a datos financieros.
     */
    ROLE_CO,

    /**
     * REPARTIDOR — Personal de entrega a domicilio.
     * Solo ve los pedidos de delivery que le fueron asignados.
     * Puede actualizar el estado del pedido (EN_CAMINO → ENTREGADO).
     * NO puede crear pedidos ni acceder al menú.
     */
    ROLE_RP,

    /**
     * MESERO — Atiende mesas, toma pedidos presenciales y cobra la cuenta.
     * Puede crear pedidos para clientes en el local.
     * Puede procesar cobros (marcar como pagado).
     */
    ROLE_ME,

    /**
     * CLIENTE — Usuario final de la plataforma.
     * Puede ver el menú, gestionar su carrito, realizar y ver sus propios pedidos.
     * Solo accede a sus propios datos (pedidos, perfil).
     * NO puede ver datos de otros usuarios ni acceder al panel de administración.
     */
    ROLE_CL
}
