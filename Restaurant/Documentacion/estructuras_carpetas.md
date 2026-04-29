# 📁 Estructura de Carpetas y Arquitectura Limpia

Todos los microservicios generados en el ecosistema `Restaurant` obedecen a un mismo estándar arquitectónico basado en una estructura de **Capas (Layered Architecture)** con toques de **Domain-Driven Design (DDD) ligero**. 

Esta estandarización permite que un desarrollador que entienda un microservicio, entienda los 12 inmediatamente.

## 🌳 Árbol de Carpetas Base Estándar

A continuación se muestra el esqueleto de un microservicio "tipo" (`ms-generico`):

```text
ms-generico/
├── README.md                      <-- Documentación viva (límites del dominio, dependencias)
├── pom.xml                        <-- Dependencias de Spring Boot, Cloud, Feign, PostgreSQL, MapStruct
└── src/main/java/cl/triskeledu/generico/
    ├── RestaurantGenericoApplication.java <-- Clase Main
    │
    ├── controller/                <-- Capa de Presentación (REST)
    │   └── GenericoController.java
    │
    ├── dto/                       <-- Capa de Transferencia de Datos
    │   ├── request/
    │   │   └── EntidadRequestDTO.java
    │   └── response/
    │       └── EntidadResponseDTO.java
    │
    ├── entity/                    <-- Capa de Dominio (Modelos de Base de Datos)
    │   ├── Entidad.java
    │   └── enums/                 <-- Máquinas de estado o dominios finitos
    │       └── EstadoEnum.java
    │
    ├── exception/                 <-- Manejo de Errores
    │   ├── EntidadNotFoundException.java
    │   └── GlobalExceptionHandler.java <-- @RestControllerAdvice
    │
    ├── mapper/                    <-- Capa de Transformación (MapStruct)
    │   └── EntidadMapper.java
    │
    ├── repository/                <-- Capa de Acceso a Datos (Spring Data JPA)
    │   └── EntidadRepository.java
    │
    ├── service/                   <-- Capa de Lógica de Negocio (Interfaces)
    │   ├── EntidadService.java
    │   └── impl/                  <-- Capa de Implementación
    │       └── EntidadServiceImpl.java
    │
    └── client/                    <-- (Opcional) Contratos Feign para hablar con otros MS
        └── OtroServiceClient.java
```

---

## 🛠️ Explicación de Cada Capa

### 1. `controller` (Presentación REST)
Solo se encarga de recibir la petición HTTP, validar el input mediante anotaciones (`@Valid`, `@RequestBody`), delegar toda la lógica al `Service` correspondiente y devolver una respuesta en formato JSON envuelta en un `ResponseEntity`. **NUNCA debe contener lógica de negocio ni acceso a BD.**

### 2. `dto` (Data Transfer Object)
Objetos planos diseñados para viajar por la red. Se dividen estrictamente en:
- **`request`**: Lo que envía el cliente (Suele llevar anotaciones de validación como `@NotBlank`, `@NotNull`).
- **`response`**: Lo que el microservicio devuelve al cliente. Filtra campos sensibles (ej. omite contraseñas) o pre-formatea datos (ej. unir nombre y apellido).

### 3. `entity` (Dominio JPA)
Las clases que mapean exactamente las tablas en la base de datos PostgreSQL mediante Hibernate. Aquí se definen claves primarias, foráneas (lógicas, ya que las físicas entre microservicios no existen), restricciones y tipos de datos.

### 4. `exception` (Manejo Global)
Implementa el patrón `@RestControllerAdvice` (`GlobalExceptionHandler`). Su función es atrapar cualquier excepción de runtime (ej. `NotFoundException`, `ValidationException`) lanzada en capas inferiores y transformarla en un JSON estándar de error (Status, Mensaje, Timestamp) para no quebrar las aplicaciones cliente.

### 5. `mapper` (Transformación)
Utiliza **MapStruct** para crear código de mapeo en tiempo de compilación. Su rol es transformar:
- `Entity` ➔ `ResponseDTO`
- `RequestDTO` ➔ `Entity`
Aislando esta lógica repetitiva de los `Services`.

### 6. `repository` (Acceso a Datos)
Interfaces que extienden `JpaRepository`. Encapsulan la lógica de acceso a la base de datos (PostgreSQL). Proporcionan métodos CRUD por defecto y soporte para *Query Methods* (ej. `findBySucursalId`).

### 7. `service` e `impl` (Lógica de Negocio)
Es el "cerebro" del microservicio.
- **`service`**: La interface expone el contrato de operaciones que se pueden realizar.
- **`impl`**: Implementa las reglas de negocio, valida dependencias, orquesta llamadas a bases de datos (`Repository`) y a otros microservicios (`Feign Clients`). En la fase actual de scaffolding, contiene comentarios estructurados (`INTENCIÓN`, `FLUJO ESPERADO`) y lanza `UnsupportedOperationException`.

---

## ⚠️ Variaciones Específicas por Microservicio

Aunque el esqueleto es idéntico, algunos servicios tienen sub-paquetes únicos acordes a su naturaleza:

*   **`ms-auth`**: Posee una carpeta `/security` que contiene configuraciones de Spring Security y los filtros (ej. `JwtAuthFilter`) encargados de validar tokens y proteger las rutas, además de la clase generadora de tokens (`JwtService`).
*   **`ms-pedidos`**: Contiene la carpeta `/client` con interfaces de OpenFeign para invocar sincrónicamente a `ms-usuarios`, `ms-sucursales`, `ms-menu`, etc.
*   **`ms-carrito` y `ms-reportes`**: Aunque usan PostgreSQL actualmente, sus diseños están pensados (conceptualmente en el `README.md`) para almacenar datos de rápida mutación o de solo lectura (como JSON o Key-Value), actuando casi como cachés o fachadas.
