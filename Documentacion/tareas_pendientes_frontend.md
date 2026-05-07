# 📋 Tareas Pendientes: Integración y Adaptación del Frontend

Con la reciente consolidación de la arquitectura backend (de 12 a 10 microservicios) y la implementación de la nueva capa de seguridad (Validación por Módulos vía Feign), el Frontend (React) necesita una serie de adaptaciones para alinearse con estos cambios y consumir las nuevas APIs de manera correcta.

A continuación, se detalla la lista de tareas pendientes para el equipo de Frontend:

## 1. Adaptación a la Fusión de Microservicios

### A. Módulo de Usuarios y Autenticación
- **Problema:** El frontend probablemente estaba haciendo llamadas HTTP hacia el puerto `:9002` (ms-usuarios) para la gestión de perfiles de usuario.
- **Acción Requerida:** 
  - Eliminar todas las referencias a `ms-usuarios` (`localhost:9002`).
  - Redirigir las peticiones de CRUD de usuarios, asignación de roles y actualización de perfiles hacia **`ms-auth` (`localhost:9001/api/v1/usuarios`)**.
  - Adaptar las interfaces TypeScript (Models) para que coincidan con la estructura unificada de `UsuarioResponseDTO` que ahora contiene el estado de la credencial integrado.

### B. Módulo de Menú y Categorías
- **Problema:** El frontend utilizaba un servicio separado para las categorías (`localhost:9005`).
- **Acción Requerida:**
  - Redirigir todas las peticiones de Categorías hacia **`ms-menu` (`localhost:9004/api/v1/categorias`)**.
  - Asegurarse de que el formulario de creación de Platos (Menu Items) consuma la lista de categorías activas desde el nuevo endpoint integrado.

## 2. Manejo de Errores y Nueva Capa de Seguridad (HTTP 403)

- **Contexto:** Se ha implementado un sistema "Zero-Trust" en el backend utilizando Feign. Si un cajero intenta guardar algo en un módulo al que no tiene acceso, el backend ya no devolverá un simple error genérico, sino un **HTTP 403 Forbidden** (código interno `ERR_AUTH_003`).
- **Acción Requerida:**
  - Actualizar el interceptor de Axios (o la capa de fetching de datos) para atrapar específicamente los errores `403`.
  - Crear un componente visual (Toast o Modal) amigable para el usuario que diga: *"Acceso Denegado: No tienes permisos vigentes para modificar este módulo. Contacta a un administrador."*
  - Opcional: Deshabilitar visualmente los botones de "Guardar" o "Crear" si, al decodificar el JWT en el cliente, se detecta que el usuario no tiene permisos para ese módulo.

## 3. Sustitución de Mocks por Consumo Real

- **Contexto:** Actualmente, varias vistas (como el Dashboard operativo) utilizan el decorador `@MOCK` para simular datos en memoria. Como ya estructuramos los endpoints (HTTP 200/201) de los microservicios restantes:
- **Acción Requerida:**
  - Conectar las vistas de *Pedidos*, *Inventario* y *Delivery* a sus respectivos microservicios.
  - Aunque los microservicios actualmente no tengan la lógica completa (solo scaffolding), el Frontend debe ser capaz de enviar los JSON correctamente a los controladores del backend sin que la UI se rompa.
  - Eliminar gradualmente los archivos de "Mock Data" a medida que el equipo backend va llenando la lógica de los `ServiceImpl`.

## 4. Estructuración del JWT

- **Contexto:** `ms-auth` es ahora responsable absoluto del token de acceso.
- **Acción Requerida:**
  - Verificar que al decodificar el JWT en el cliente (`jwt-decode`), el Payload contenga correctamente la lista de **Módulos Permitidos** y el **ID de la Credencial**, ya que estos se usarán para el renderizado condicional de la barra de navegación lateral (Sidebar).
