package cl.triskeledu.usuarios.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * =============================================================================
 * ENTIDAD: Usuario
 * =============================================================================
 *
 * PROPÓSITO:
 *   Almacena el perfil público de un usuario del sistema: datos personales,
 *   de contacto y de asignación a sucursal.
 *   Es el complemento de UserCredential (ms-auth) en el modelo de identidad distribuida.
 *
 * TABLA EN BD: `usuarios` (PostgreSQL — base de datos exclusiva `usuarios`)
 *
 * RELACIÓN CON ms-auth:
 *   El campo `credencialId` es el puente con ms-auth.
 *   credencialId == UserCredential.id (en ms-auth)
 *   No existe FK física: son bases de datos separadas.
 *   La unicidad de credencialId se garantiza con un UNIQUE constraint en la BD.
 *
 * CICLO DE VIDA:
 *   1. ms-auth registra UserCredential → genera ID (ej: 42).
 *   2. ms-auth llama a ms-usuarios via Feign: POST /api/v1/usuarios con credencialId=42.
 *   3. ms-usuarios crea Usuario con credencialId=42.
 *   4. En el frontend, al hacer login, el JWT incluye `sub=42`.
 *      El frontend puede consultar GET /api/v1/usuarios/credencial/42 para el perfil.
 *
 * INVARIANTES:
 *   1. `credencialId` es único por usuario — no puede haber dos perfiles para la misma credencial.
 *   2. `sucursalId` solo debe tener valor para empleados (COCINERO, REPARTIDOR, ADMIN).
 *      Para clientes (ROLE_CL) debe ser null.
 *   3. Los campos de auditoría (`creadoEn`, `actualizadoEn`) son inmutables desde la API.
 *
 * =============================================================================
 */
@Entity
@Table(
    name = "usuarios",
    uniqueConstraints = @UniqueConstraint(name = "uk_credencial_id", columnNames = "credencial_id")
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    /**
     * ATRIBUTO: id
     * Tipo: Long (BIGSERIAL)
     * Rol: PK del perfil en ms-usuarios. Es DISTINTO al credencialId.
     *      El id de este MS se usa para operaciones internas (actualizar perfil, etc.).
     *      El credencialId se usa para vínculo con ms-auth y para que otros MS encuentren el perfil.
     * Riesgo: CRÍTICO. No reasignar. No confundir con credencialId — son distintos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ATRIBUTO: credencialId
     * Tipo: Long (BIGINT)
     * Rol: ID de la credencial en ms-auth. Es el vínculo entre identidad y perfil.
     *      Unique constraint garantiza 1-a-1 con ms-auth.
     *      Incluido en el JWT como claim `sub`. El frontend lo usa para consultar el perfil.
     * Riesgo: CRÍTICO. No modificar. Si se cambia, el usuario pierde acceso a su perfil.
     *         Una vez creado, este campo es INMUTABLE.
     */
    @Column(name = "credencial_id", nullable = false, updatable = false)
    private Long credencialId;

    /**
     * ATRIBUTO: nombre
     * Tipo: String (VARCHAR 100)
     * Rol: Nombre de pila. Mostrado en UI, notificaciones ("Hola, Juan!") y tickets.
     *      Enviado a ms-notificaciones para personalizar mensajes.
     * Riesgo: BAJO. Cambiar no afecta transacciones ni pedidos activos.
     */
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    /**
     * ATRIBUTO: apellido
     * Tipo: String (VARCHAR 100)
     * Rol: Apellido del usuario. Complementa el nombre para identificación completa.
     *      Usado en reportes de empleados y en facturas.
     * Riesgo: BAJO. Campo informativo. Cambiar no afecta el sistema operacionalmente.
     */
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    /**
     * ATRIBUTO: telefono
     * Tipo: String (VARCHAR 20)
     * Rol: Número de contacto. Usado por ms-delivery para coordinar la entrega.
     *      Almacenado como String para soportar formatos internacionales (+56 9 1234 5678).
     * Riesgo: MEDIO. Cambiar afecta futuras entregas pero no las activas (la dirección
     *         se captura en el momento del pedido). Validar formato en DTO.
     */
    @Column(name = "telefono", length = 20)
    private String telefono;

    /**
     * ATRIBUTO: direccion
     * Tipo: String (VARCHAR 300)
     * Rol: Dirección principal del usuario. Pre-rellena el formulario de delivery al hacer pedido.
     *      El usuario puede sobrescribirla por pedido en el carrito.
     *      Esta dirección es un default — no es la dirección de entrega definitiva de un pedido activo.
     * Riesgo: BAJO. Cambiar solo afecta futuros pedidos (el pre-relleno del carrito).
     *         Los pedidos activos ya tienen su propia dirección capturada en el momento del checkout.
     */
    @Column(name = "direccion", length = 300)
    private String direccion;

    /**
     * ATRIBUTO: imagenUrl
     * Tipo: String (VARCHAR 500)
     * Rol: URL de la foto de perfil del usuario. Servida desde CDN externo.
     *      Mostrada en la app, en el perfil del cocinero en el KDS, y en el perfil del repartidor.
     *      No almacenar el binario de la imagen en la BD.
     * Riesgo: BAJO. Si la URL falla, mostrar avatar genérico en el frontend.
     *         TODO: Integrar con servicio de CDN para gestión de imágenes de perfil.
     */
    @Column(name = "imagen_url", length = 500)
    private String imagenUrl;

    /**
     * ATRIBUTO: sucursalId
     * Tipo: Long (BIGINT) — nullable
     * Rol: FK lógica a la sucursal asignada (ms-sucursales). Solo para empleados.
     *      NULL para clientes (ROLE_CL): no tienen sucursal asignada.
     *      Determina qué KDS ve el cocinero, qué pedidos ve el repartidor, qué mesas atiende el MESERO y qué menú administra el ADMIN.
     * Riesgo: ALTO. Reasignar el sucursalId de un empleado activo:
     *         - El cocinero pierde acceso al KDS de su sucursal original.
     *         - El repartidor pierde los pedidos en curso de su sucursal.
     *         Realizar cambios de sucursal en horarios de baja actividad.
     *         TODO: Validar que no hay pedidos activos asignados al empleado antes de reasignar.
     */
    @Column(name = "sucursal_id")
    private Long sucursalId;

    /**
     * ATRIBUTO: activo
     * Tipo: Boolean
     * Rol: Flag de perfil activo. Sincronizado idealmente con ms-auth.
     *      Si ms-auth desactiva la credencial, ms-usuarios debería reflejar activo=false.
     *      Permite filtrar empleados activos en listados de sucursal.
     * Riesgo: ALTO. Desactivar en ms-usuarios no revoca el JWT del usuario.
     *         Debe coordinarse con ms-auth para desactivación completa.
     *         TODO: Crear endpoint en ms-auth que desactive credencial Y notifique a ms-usuarios.
     */
    @Column(name = "activo", nullable = false)
    @Builder.Default
    private Boolean activo = true;

    /**
     * ATRIBUTO: creadoEn
     * Tipo: LocalDateTime (TIMESTAMP)
     * Rol: Fecha de alta del perfil. Inmutable. Auditoría de creación de usuarios.
     * Riesgo: CRÍTICO. updatable=false garantiza inmutabilidad. No exponer en DTOs de actualización.
     */
    @CreationTimestamp
    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    /**
     * ATRIBUTO: actualizadoEn
     * Tipo: LocalDateTime (TIMESTAMP)
     * Rol: Última actualización del perfil. Útil para detectar cambios recientes.
     * Riesgo: BAJO. Gestionado automáticamente por Hibernate.
     */
    @UpdateTimestamp
    @Column(name = "actualizado_en", nullable = false)
    private LocalDateTime actualizadoEn;
}
