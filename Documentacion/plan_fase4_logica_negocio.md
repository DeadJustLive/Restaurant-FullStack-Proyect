# Plan de Fase 4: Desarrollo de Lógica de Negocio (Post-Integración)

## Objetivo
Implementar la lógica real de negocio en los controladores y servicios que fueron trasladados durante las Fases 1 y 2, reemplazando el scaffolding y los errores temporales (`UnsupportedOperationException`) por operaciones directas de JPA, asegurando así la completa operatividad del sistema de perfiles y categorías integrados.

## 1. Módulo de Usuarios (`ms-auth`)

### 1.1 `UsuarioServiceImpl.java`
* [x] **`crear()`**: Implementado. Revisa si existe la credencial, mapea el DTO y vincula directamente a `UserCredential` mediante `@OneToOne` antes de hacer `save()`.
* [x] **`getById()` / `getByCredencialId()`**: Implementados. Busca en BD y devuelve la entidad formateada. Lanza excepción de negocio (404) si no existe.
* [x] **`listarPorSucursal()`**: Implementado. Retorna usuarios filtrando por `sucursalId` y `activo = true`.
* [x] **`actualizar()` / `reasignarSucursal()`**: Implementado. Mapea la información nueva sobre la entidad existente. La reasignación se realiza de manera eficiente utilizando una query custom `@Modifying` de JPQL.
* [x] **`eliminar()`**: Implementado como Soft Delete (cambia flag `activo = false`).

### 1.2 `UsuarioRepository.java` y `UsuarioMapper.java`
* [x] **Repositorio JPQL**: Actualizado. Las queries (como `UPDATE Usuario u SET u.activo = :activo WHERE u.credencial.id = :credencialId`) ahora navegan por el objeto `credencial` en lugar del antiguo campo numérico, respetando el mapeo `@OneToOne`.
* [x] **Mapper**: Configurado para ignorar la sobreescritura de `credencial` durante el PUT (inmutabilidad de credenciales desde el perfil) y obtener `credencialId` mediante `source = "credencial.id"`.

### 1.3 `UsuarioController.java`
* [x] **Endpoints REST**: Se inyectó `UsuarioService` y se expusieron formalmente todas las rutas `/api/v1/usuarios`. Se removieron todos los fallbacks que arrojaban errores no implementados.

## 2. Módulo de Categorías (`ms-menu`)
* [x] **Lógica de Menú/Categoría**: Verificado exitosamente. Tanto `CategoriaServiceImpl` como los controladores de Items ya cuentan con toda su lógica transaccional integrada de forma local. No quedan `UnsupportedOperationException` presentes.

## Conclusión
Todos los métodos CRUD correspondientes a los perfiles de usuario y menú están 100% operativos a nivel de código de dominio, conectándose directamente con la base de datos central de cada MS integrado y estandarizando los retornos al Frontend.
