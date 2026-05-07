# Estructura de Seguridad Inter-Servicios: Validación de Permisos vía Feign

## 🎯 Objetivo de la Integración (Requisito del Profesor)
Garantizar que ningún usuario pueda realizar acciones en un módulo si no tiene los permisos específicos asignados. Para lograrlo, los microservicios de negocio delegarán la decisión de autorización al microservicio central (`ms-auth`) haciendo una consulta síncrona mediante **Spring Cloud OpenFeign** en tiempo real. 

Esto permite que, si a un empleado se le revoca el acceso a "Inventario", el bloqueo aplique de inmediato sin tener que esperar a que su token JWT caduque.

---

## 🏗️ 1. Modificaciones en el Microservicio Central (`ms-auth`)

Como `ms-auth` es ahora el "Guardián de la Verdad" (al integrar Usuarios y Credenciales), se encargará de exponer el endpoint de validación.

*   **Endpoint Propuesto:** `GET /api/v1/auth/validar-acceso`
*   **Parámetros Esperados:** 
    *   `credencialId` (Extraído del token del usuario que hace la petición).
    *   `modulo` (Ej: `MENU`, `INVENTARIO`, `REPORTES`).
    *   `accion` (Ej: `LECTURA`, `ESCRITURA`).
*   **Respuesta de ms-auth:**
    *   `HTTP 200 OK` (Cuerpo `{ "permitido": true }`) si el usuario tiene el rol y los módulos correctos.
    *   `HTTP 403 Forbidden` si el usuario está inhabilitado o no tiene acceso al módulo.

---

## 🔌 2. Modificaciones en los Microservicios Clientes (Ej: `ms-menu`, `ms-pedidos`)

Los demás microservicios actuarán como "Clientes" que pedirán permiso a `ms-auth` antes de ejecutar su lógica.

### A. Dependencia Feign
Asegurarnos de que el archivo `pom.xml` de los servicios clientes contenga:
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

### B. Creación de la Interfaz FeignClient
Crear una interfaz en el microservicio cliente (`ms-menu`, etc.) que apunte a `ms-auth`:
```java
@FeignClient(name = "ms-auth", path = "/api/v1/auth")
public interface AuthFeignClient {
    
    @GetMapping("/validar-acceso")
    ResponseEntity<PermisoResponseDTO> validarAcceso(
        @RequestParam("credencialId") Long credencialId, 
        @RequestParam("modulo") String modulo, 
        @RequestParam("accion") String accion
    );
}
```

### C. Inyección en la Lógica de Negocio (Service)
Antes de ejecutar cualquier cambio en la base de datos (por ejemplo, al crear una categoría en `CategoriaServiceImpl`), el servicio llamará a Feign:

```java
public CategoriaResponseDTO crear(CategoriaRequestDTO dto, Long credencialId) {
    // 1. Validar seguridad vía Feign
    PermisoResponseDTO permiso = authFeignClient.validarAcceso(credencialId, "MENU", "ESCRITURA").getBody();
    if (!permiso.isPermitido()) {
        throw new AccesoDenegadoException("No tienes permisos para modificar el menú.");
    }

    // 2. Ejecutar la lógica normal (si pasó la validación)
    Categoria categoria = categoriaMapper.toEntity(dto);
    return categoriaMapper.toResponseDTO(categoriaRepository.save(categoria));
}
```

*(Otra alternativa más limpia a nivel de código es usar **AOP - Aspect Oriented Programming** con una anotación custom como `@RequierePermiso("MENU_ESCRITURA")` en el controlador, la cual internamente llama al Feign, limpiando el código del servicio).*

---

## 🔄 Flujo de Ejecución (Secuencia)

1.  **Actor** (Cajero/Admin) hace un request `POST /api/v1/menu/items`.
2.  **`ms-menu`** (Controlador) recibe la petición y el JWT. Extrae el ID del usuario del JWT.
3.  **`ms-menu`** detiene la ejecución y utiliza `AuthFeignClient` para enviar la pregunta a `ms-auth`.
4.  **`ms-auth`** recibe la pregunta, consulta la base de datos (`auth_db`), verifica que la credencial esté activa y tenga el módulo `MENU` asignado. Retorna `true`.
5.  **`ms-menu`** recibe el `true` y continúa con el guardado en su base de datos.
6.  **Actor** recibe respuesta exitosa (201 Created).

---

## ✅ Puntos Clave para el Profesor
Al implementar este diseño, estarás cumpliendo con tres requisitos técnicos avanzados:
1. **Comunicación Síncrona Inter-Servicios:** Demostrarás un uso real y justificado de FeignClient.
2. **Seguridad Centralizada:** Un único punto de fallo y verdad para las políticas de seguridad (`ms-auth`).
3. **Revocación en Tiempo Real:** Justifica que usar Feign aquí es mejor que depender solo del JWT, ya que si despides a un empleado, su acceso se revoca al instante en la BD, y Feign lo detectará en la siguiente petición.
