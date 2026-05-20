# Plan de Pruebas — Microservicios Restaurant

> **Colección Postman recomendada:**
> El archivo `Documentacion/Restaurant-API.postman_collection.json` no está incluido en el repositorio.
> Como alternativa, usa los scripts automáticos:
> - **Linux:** `Restaurant/pruebas-microservicios/test_endpoints.sh`
> - **Windows:** `Restaurant/pruebas-microservicios/test_endpoints.bat`
>
> O genera la colección Postman desde los controladores usando Postman's "Import from code" con los endpoints listados abajo.

---

## 1. Prerrequisitos

### 1.1 Servicios necesarios

| Servicio | Comando / Verificación |
|---|---|
| **PostgreSQL** | `docker-compose up -d postgres` (puerto 5433, user=postgres, pass=123) |
| **Kafka** | `docker-compose up -d kafka` (puerto 9092) |
| **Eureka** | `cd eureka && mvn spring-boot:run` (puerto 8761) |
| **Todos los MS** | `./launch.sh` o `./launch.bat` |

### 1.2 Orden de inicio

```
PostgreSQL (5433) → Kafka (9092) → Eureka (8761) → ms-auth (9001) → resto de MS (9003-9012)
```

### 1.3 Verificar Eureka

Abrir `http://localhost:8761` — deben aparecer 10 servicios registrados.

---

## 2. Configuración de Variables Postman

Crear un **Environment** en Postman con estas variables:

| Variable | Valor inicial | Se auto-asigna |
|---|---|---|
| `BASE_AUTH` | `http://localhost:9001` | No |
| `BASE_SUCURSALES` | `http://localhost:9003` | No |
| `BASE_MENU` | `http://localhost:9004` | No |
| `BASE_CARRITO` | `http://localhost:9006` | No |
| `BASE_PEDIDOS` | `http://localhost:9007` | No |
| `BASE_PAGOS` | `http://localhost:9008` | No |
| `BASE_DELIVERY` | `http://localhost:9009` | No |
| `BASE_INVENTARIO` | `http://localhost:9010` | No |
| `BASE_NOTIFICACIONES` | `http://localhost:9011` | No |
| `BASE_REPORTES` | `http://localhost:9012` | No |
| `TOKEN` | *(vacío)* | Login |
| `REFRESH_TOKEN` | *(vacío)* | Login |
| `CREDENCIAL_ID` | `1` | Login |
| `ROL` | *(vacío)* | Login |
| `SUCURSAL_ID` | *(vacío)* | Crear sucursal |
| `CATEGORIA_ID` | *(vacío)* | Crear categoría |
| `MENU_ITEM_ID` | *(vacío)* | Crear menú |
| `INSUMO_ID` | *(vacío)* | Crear insumo |
| `PEDIDO_ID` | *(vacío)* | Crear pedido |
| `PAGO_ID` | *(vacío)* | Crear pago |
| `DELIVERY_ID` | *(vacío)* | Crear delivery |

---

## 3. Health Checks

Todos deben devolver `200 OK` con `{"status":"UP"}` (o `"UP"`).

| # | Método | URL | Puerto |
|---|---|---|---|
| 1 | GET | `{{BASE_AUTH}}/api/v1/auth/health` | 9001 |
| 2 | GET | `{{BASE_SUCURSALES}}/actuator/health` | 9003 |
| 3 | GET | `{{BASE_MENU}}/actuator/health` | 9004 |
| 4 | GET | `{{BASE_CARRITO}}/api/v1/carrito/health` | 9006 |
| 5 | GET | `{{BASE_PEDIDOS}}/actuator/health` | 9007 |
| 6 | GET | `{{BASE_PAGOS}}/actuator/health` | 9008 |
| 7 | GET | `{{BASE_DELIVERY}}/actuator/health` | 9009 |
| 8 | GET | `{{BASE_INVENTARIO}}/actuator/health` | 9010 |
| 9 | GET | `{{BASE_NOTIFICACIONES}}/actuator/health` | 9011 |
| 10 | GET | `{{BASE_REPORTES}}/actuator/health` | 9012 |

**Test de post-response:**
```javascript
pm.test("Status 200", () => pm.response.to.have.status(200));
pm.test("Service UP", () => {
    const body = pm.response.json();
    pm.expect(body.status || body).to.include("UP");
});
```

---

## 4. Autenticación (ms-auth:9001)

### 4.1 Credenciales Seed

| # | Rol | Email | Password | Credencial ID |
|---|---|---|---|---|
| 1 | ROLE_SA | roberto.admin@restaurant.cl | 123456 | 1 |
| 2 | ROLE_AD | carla.mendez@restaurant.cl | 123456 | 2 |
| 3 | ROLE_CO | pedro.pinto@restaurant.cl | 123456 | 3 |
| 4 | ROLE_ME | sofia.soto@restaurant.cl | 123456 | 4 |
| 5 | ROLE_RP | diego.tapia@restaurant.cl | 123456 | 5 |
| 6 | ROLE_CL | valentina.vargas@gmail.com | 123456 | 6 |

### 4.2 Login (seleccionar un rol)

```
POST {{BASE_AUTH}}/api/v1/auth/login
Content-Type: application/json

{
    "username": "roberto.admin@restaurant.cl",
    "password": "123456"
}
```

**Response esperada (200):**
```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9...",
    "expiresIn": 86400,
    "rol": "ROLE_SA",
    "username": "roberto.admin@restaurant.cl"
}
```

> ⚠️ **Nota:** `refreshToken` no está implementado en la versión actual. El endpoint `POST /api/v1/auth/refresh` lanza `UnsupportedOperationException`. Solo se usa el `token` JWT estándar con expiración de 24h.

**Test post-response:**
```javascript
pm.test("Status 200", () => pm.response.to.have.status(200));
const body = pm.response.json();
pm.test("Has token", () => pm.expect(body.token).to.exist);
pm.test("Has rol", () => pm.expect(body.rol).to.exist);

// Auto-guardar en environment
pm.environment.set("TOKEN", body.token);
pm.environment.set("ROL", body.rol);

if (body.rol === "ROLE_SA") pm.environment.set("CREDENCIAL_ID", "1");
else if (body.rol === "ROLE_AD") pm.environment.set("CREDENCIAL_ID", "2");
else if (body.rol === "ROLE_CO") pm.environment.set("CREDENCIAL_ID", "3");
else if (body.rol === "ROLE_ME") pm.environment.set("CREDENCIAL_ID", "4");
else if (body.rol === "ROLE_RP") pm.environment.set("CREDENCIAL_ID", "5");
else if (body.rol === "ROLE_CL") pm.environment.set("CREDENCIAL_ID", "6");
```

### 4.3 Refresh Token (No Implementado)

> ⚠️ **No implementado.** El endpoint `POST /api/v1/auth/refresh` lanza `UnsupportedOperationException`.

```
POST {{BASE_AUTH}}/api/v1/auth/refresh?refreshToken={{REFRESH_TOKEN}}
```

### 4.4 Logout

```
POST {{BASE_AUTH}}/api/v1/auth/logout
```

**Respuesta:** 204 No Content (idempotente).

---

## 5. Datos Base (setup para flujo de negocio)

Ejecutar en orden. Cada request guarda su ID en variables de environment.

### 5.1 Crear Sucursal

```
POST {{BASE_SUCURSALES}}/api/v1/sucursales
Content-Type: application/json
X-Credencial-Id: {{CREDENCIAL_ID}}

{
    "nombre": "Sucursal Test Postman",
    "direccion": "Av. Test 123, Santiago",
    "telefono": "+56211112222"
}
```

**Test:** `pm.environment.set("SUCURSAL_ID", body.id);`

### 5.2 Crear Categoría

```
POST {{BASE_MENU}}/api/v1/categorias
Content-Type: application/json

{
    "nombre": "Categoría Test Postman",
    "descripcion": "Categoría para pruebas"
}
```

**Test:** `pm.environment.set("CATEGORIA_ID", body.id);`

### 5.3 Crear Ítem de Menú

```
POST {{BASE_MENU}}/api/v1/menu
Content-Type: application/json
X-Credencial-Id: {{CREDENCIAL_ID}}

{
    "nombre": "Pizza Test Postman",
    "descripcion": "Pizza de prueba",
    "precio": 12990,
    "disponible": true,
    "categoriaId": {{CATEGORIA_ID}},
    "sucursalId": {{SUCURSAL_ID}}
}
```

**Test:** `pm.environment.set("MENU_ITEM_ID", body.id);`

### 5.4 Crear Insumo

```
POST {{BASE_INVENTARIO}}/api/v1/inventario/insumos
Content-Type: application/json
X-Credencial-Id: {{CREDENCIAL_ID}}

{
    "sucursalId": {{SUCURSAL_ID}},
    "nombre": "Harina Test Postman",
    "unidadMedida": "KG",
    "stockMinimo": 10.0
}
```

**Test:** `pm.environment.set("INSUMO_ID", body.id);`

### 5.5 Registrar Movimiento de Inventario (ENTRADA)

```
POST {{BASE_INVENTARIO}}/api/v1/inventario/movimientos
Content-Type: application/json
X-Credencial-Id: {{CREDENCIAL_ID}}

{
    "insumoId": {{INSUMO_ID}},
    "tipo": "ENTRADA",
    "cantidad": 50.0,
    "referencia": "Compra inicial Postman"
}
```

---

## 6. Flujo de Negocio Completo

### 6.1 Crear Carrito

```
POST {{BASE_CARRITO}}/api/v1/carrito
Content-Type: application/json

{
    "usuarioId": 6,
    "sucursalId": {{SUCURSAL_ID}}
}
```

### 6.2 Agregar Item al Carrito

```
POST {{BASE_CARRITO}}/api/v1/carrito/usuario/6/items
Content-Type: application/json

{
    "menuItemId": {{MENU_ITEM_ID}},
    "cantidad": 2
}
```

### 6.3 Ver Carrito

```
GET {{BASE_CARRITO}}/api/v1/carrito/usuario/6
```

### 6.4 Crear Pedido

```
POST {{BASE_PEDIDOS}}/api/v1/pedidos
Content-Type: application/json

{
    "usuarioId": 6,
    "sucursalId": {{SUCURSAL_ID}},
    "tipo": "DELIVERY",
    "items": [
        {"menuItemId": {{MENU_ITEM_ID}}, "cantidad": 2}
    ],
    "notas": "Sin cebolla por favor"
}
```

**Test:** `pm.environment.set("PEDIDO_ID", body.id);`

> **Verificación Kafka:** Revisar logs de consola de ms-pagos, ms-delivery, ms-inventario, ms-notificaciones, ms-reportes. Deberían mostrar: "Proyección guardada..."

### 6.5 Ver Pedidos

```
GET {{BASE_PEDIDOS}}/api/v1/pedidos/{{PEDIDO_ID}}
```

### 6.6 Cambiar Estado del Pedido

```
PATCH {{BASE_PEDIDOS}}/api/v1/pedidos/{{PEDIDO_ID}}/estado
Content-Type: application/json

{
    "estado": "CONFIRMADO"
}
```

### 6.7 Iniciar Pago

```
POST {{BASE_PAGOS}}/api/v1/pagos
Content-Type: application/json
X-Credencial-Id: {{CREDENCIAL_ID}}

{
    "pedidoId": {{PEDIDO_ID}},
    "monto": 25980,
    "metodo": "TARJETA_DEBITO"
}
```

**Test:** `pm.environment.set("PAGO_ID", body.id);`

### 6.8 Confirmar Pago

```
PATCH {{BASE_PAGOS}}/api/v1/pagos/{{PAGO_ID}}/estado?transaccionId=TX-TEST-001&estadoFinal=APROBADO
X-Credencial-Id: {{CREDENCIAL_ID}}
```

### 6.9 Crear Delivery

```
POST {{BASE_DELIVERY}}/api/v1/delivery
Content-Type: application/json
X-Credencial-Id: {{CREDENCIAL_ID}}

{
    "pedidoId": {{PEDIDO_ID}},
    "direccionEntrega": "Av. Providencia 123, Depto 4B"
}
```

**Test:** `pm.environment.set("DELIVERY_ID", body.id);`

### 6.10 Asignar Repartidor

```
PATCH {{BASE_DELIVERY}}/api/v1/delivery/{{DELIVERY_ID}}/asignar
Content-Type: application/json
X-Credencial-Id: {{CREDENCIAL_ID}}

{
    "repartidorId": 5
}
```

### 6.11 Actualizar Estado Delivery

```
// EN_CAMINO
PATCH {{BASE_DELIVERY}}/api/v1/delivery/{{DELIVERY_ID}}/estado?estado=EN_CAMINO
X-Credencial-Id: {{CREDENCIAL_ID}}

// ENTREGADO
PATCH {{BASE_DELIVERY}}/api/v1/delivery/{{DELIVERY_ID}}/estado?estado=ENTREGADO
X-Credencial-Id: {{CREDENCIAL_ID}}
```

### 6.12 Ver Notificaciones Generadas

```
GET {{BASE_NOTIFICACIONES}}/api/v1/notificaciones/estado/ENVIADO
GET {{BASE_NOTIFICACIONES}}/api/v1/notificaciones/estado/PENDIENTE
```

### 6.13 Generar Reporte

```
POST {{BASE_REPORTES}}/api/v1/reportes/generar
Content-Type: application/json

{
    "credencialId": {{CREDENCIAL_ID}},
    "tipo": "VENTAS_DIARIAS",
    "sucursalId": {{SUCURSAL_ID}},
    "fechaInicio": "2026-01-01",
    "fechaFin": "2026-12-31"
}
```

---

## 7. CRUD por Microservicio

### 7.1 ms-sucursales (9003)

| Método | URL | Headers | Body |
|---|---|---|---|
| GET | `/api/v1/sucursales` | — | — |
| GET | `/api/v1/sucursales/todas` | — | — |
| GET | `/api/v1/sucursales/{{SUCURSAL_ID}}` | — | — |
| POST | `/api/v1/sucursales` | `X-Credencial-Id` | `{nombre, direccion, telefono}` |
| PUT | `/api/v1/sucursales/{{SUCURSAL_ID}}` | `X-Credencial-Id` | `{nombre, direccion, telefono}` |
| PATCH | `/api/v1/sucursales/{{SUCURSAL_ID}}/estado?activa=false` | `X-Credencial-Id` | — |

### 7.2 ms-menu (9004)

| Método | URL | Headers | Body |
|---|---|---|---|
| GET | `/api/v1/menu` | — | — |
| GET | `/api/v1/menu/{{MENU_ITEM_ID}}` | — | — |
| POST | `/api/v1/menu` | `X-Credencial-Id` | `{nombre, precio, categoriaId, sucursalId?}` |
| PUT | `/api/v1/menu/{{MENU_ITEM_ID}}` | `X-Credencial-Id` | `{nombre, precio, categoriaId}` |
| PATCH | `/api/v1/menu/{{MENU_ITEM_ID}}/disponibilidad?disponible=false` | `X-Credencial-Id` | — |
| DELETE | `/api/v1/menu/{{MENU_ITEM_ID}}` | `X-Credencial-Id` | — |
| GET | `/api/v1/categorias` | — | — |
| POST | `/api/v1/categorias` | — | `{nombre, descripcion}` |

### 7.3 ms-inventario (9010)

| Método | URL | Headers | Body |
|---|---|---|---|
| GET | `/api/v1/inventario` | — | — |
| GET | `/api/v1/inventario/{{INSUMO_ID}}` | — | — |
| GET | `/api/v1/inventario/insumos/sucursal/{{SUCURSAL_ID}}` | — | — |
| POST | `/api/v1/inventario/insumos` | `X-Credencial-Id` | `{sucursalId, nombre, unidadMedida, stockMinimo}` |
| PUT | `/api/v1/inventario/insumos/{{INSUMO_ID}}` | `X-Credencial-Id` | `{sucursalId, nombre, unidadMedida, stockMinimo}` |
| POST | `/api/v1/inventario/movimientos` | `X-Credencial-Id` | `{insumoId, tipo, cantidad, referencia?}` |
| GET | `/api/v1/inventario/insumos/{{INSUMO_ID}}/kardex` | — | — |

### 7.4 ms-auth — Usuarios (9001, requiere JWT)

| Método | URL | Headers | Body |
|---|---|---|---|
| GET | `/api/v1/usuarios/1` | `Authorization: Bearer {{TOKEN}}` | — |
| GET | `/api/v1/usuarios/credencial/{{CREDENCIAL_ID}}` | `Authorization` | — |
| GET | `/api/v1/usuarios/sucursal/{{SUCURSAL_ID}}` | `Authorization` | — |
| POST | `/api/v1/usuarios` | `Authorization` | `{credencialId, nombre, apellido}` |
| PUT | `/api/v1/usuarios/1` | `Authorization` | `{credencialId, nombre, apellido, telefono?, direccion?}` |
| PATCH | `/api/v1/usuarios/1/sucursal?sucursalId={{SUCURSAL_ID}}` | `Authorization` | — |
| DELETE | `/api/v1/usuarios/1` | `Authorization` | — |

### 7.5 ms-carrito (9006)

| Método | URL | Headers |
|---|---|---|
| GET | `/api/v1/carrito/usuario/6` | — |
| POST | `/api/v1/carrito` | — |
| POST | `/api/v1/carrito/usuario/6/items` | — |
| PATCH | `/api/v1/carrito/usuario/6/items/1?cantidad=3` | — |
| DELETE | `/api/v1/carrito/usuario/6/items/1` | — |
| DELETE | `/api/v1/carrito/usuario/6` | — |

### 7.6 ms-pedidos (9007)

| Método | URL | Headers |
|---|---|---|
| GET | `/api/v1/pedidos` | — |
| GET | `/api/v1/pedidos/{{PEDIDO_ID}}` | — |
| GET | `/api/v1/pedidos/sucursal/{{SUCURSAL_ID}}/activos` | — |
| GET | `/api/v1/pedidos/cliente/6` | — |
| POST | `/api/v1/pedidos` | — |
| PATCH | `/api/v1/pedidos/{{PEDIDO_ID}}/estado` | — |
| PATCH | `/api/v1/pedidos/{{PEDIDO_ID}}/cancelar` | — |

### 7.7 ms-pagos (9008)

| Método | URL | Headers |
|---|---|---|
| GET | `/api/v1/pagos` | — |
| GET | `/api/v1/pagos/{{PAGO_ID}}` | — |
| GET | `/api/v1/pagos/pedido/{{PEDIDO_ID}}` | — |
| POST | `/api/v1/pagos` | `X-Credencial-Id` |
| PATCH | `/api/v1/pagos/{{PAGO_ID}}/estado?transaccionId=X&estadoFinal=APROBADO` | `X-Credencial-Id` |

### 7.8 ms-delivery (9009)

| Método | URL | Headers |
|---|---|---|
| GET | `/api/v1/delivery` | — |
| GET | `/api/v1/delivery/{{DELIVERY_ID}}` | — |
| GET | `/api/v1/delivery/pedido/{{PEDIDO_ID}}` | — |
| POST | `/api/v1/delivery` | `X-Credencial-Id` |
| PATCH | `/api/v1/delivery/{{DELIVERY_ID}}/asignar` | `X-Credencial-Id` |
| PATCH | `/api/v1/delivery/{{DELIVERY_ID}}/estado?estado=EN_CAMINO` | `X-Credencial-Id` |

### 7.9 ms-notificaciones (9011)

| Método | URL |
|---|---|
| GET | `/api/v1/notificaciones/estado/ENVIADO` |
| GET | `/api/v1/notificaciones/estado/PENDIENTE` |
| POST | `/api/v1/notificaciones` |

### 7.10 ms-reportes (9012)

| Método | URL |
|---|---|
| GET | `/api/v1/reportes/tipo/VENTAS_DIARIAS` |
| POST | `/api/v1/reportes/generar` |

---

## 8. Verificación Kafka

Después de cada operación de escritura, verificar que los eventos se propagaron.

### 8.1 Verificar logs de consola

Buscar mensajes como:
- `"Kafka event sent to pedido-events: pedido creado id=X"`
- `"Proyección de Pedido guardada en ms-pagos..."`
- `"Proyección guardada. ID: X"`

### 8.2 Verificar proyecciones vía API

| Después de crear... | Verificar en... | Endpoint |
|---|---|---|
| Sucursal | ms-pedidos | `GET /actuator/health` — el servicio debe tener la proyección |
| MenuItem | ms-carrito | `GET /api/v1/carrito/usuario/6` — puede mostrar el ítem |
| Pedido | ms-pagos | `GET /api/v1/pagos/pedido/{{PEDIDO_ID}}` — debe existir proyección |
| Pago | ms-reportes | `GET /api/v1/reportes/tipo/VENTAS_DIARIAS` — snapshot del pago |
| Delivery | ms-notificaciones | `GET /api/v1/notificaciones/estado/ENVIADO` — notificación generada |

---

## 9. Escenarios de Error

### 9.1 Autenticación

| # | Escenario | Request | Esperado |
|---|---|---|---|
| 9.1.1 | Password incorrecto | Login con password `wrong` | 401 `Credenciales inválidas` |
| 9.1.2 | Email inexistente | Login con `noexiste@test.com` | 401 `Credenciales inválidas` |
| 9.1.3 | Token expirado | GET /usuarios con JWT manipulado | 403 |
| 9.1.4 | Sin token | GET /usuarios sin Authorization | 403 |
| 9.1.5 | Refresh token revocado | POST /refresh con token ya usado | 401 |

### 9.2 Validaciones y Negocio

| # | Escenario | Request | Esperado |
|---|---|---|---|
| 9.2.1 | Email duplicado | Register con email existente | 409 |
| 9.2.2 | Campos inválidos | POST sucursal sin nombre | 400 + `data.errores` |
| 9.2.3 | Recurso no encontrado | GET sucursal/9999 | 404 |
| 9.2.4 | Stock insuficiente | Movimiento SALIDA con cantidad > stock | 409 `Stock insuficiente` |
| 9.2.5 | Estado inválido | PATCH pedido/1/estado con estado=CANCELADO desde EN_PREPARACION | 409 `No se puede cambiar` |
| 9.2.6 | Ítem duplicado | POST menú con nombre existente en categoría | 409 |
| 9.2.7 | Servicio caído | Con ms-auth caído, crear sucursal | Operación permitida (modo degradado) |
| 9.2.8 | FeignException | Con ms-auth caído, ver health de otro MS | Log muestra warning de modo degradado |

---

## 10. Flujo Rápido (happy path completo en 10 requests)

```
1. POST /api/v1/auth/login          → Guardar TOKEN + REFRESH_TOKEN
2. POST /api/v1/sucursales          → Guardar SUCURSAL_ID
3. POST /api/v1/categorias          → Guardar CATEGORIA_ID
4. POST /api/v1/menu                → Guardar MENU_ITEM_ID
5. POST /api/v1/carrito
6. POST /api/v1/carrito/usuario/6/items
7. POST /api/v1/pedidos             → Guardar PEDIDO_ID
8. POST /api/v1/pagos               → Guardar PAGO_ID
9. POST /api/v1/delivery            → Guardar DELIVERY_ID
10. PATCH /api/v1/delivery/{{DELIVERY_ID}}/estado?estado=ENTREGADO
```

---

## 11. Colección Postman

El archivo `Documentacion/Restaurant-API.postman_collection.json` contiene todos estos requests organizados en carpetas con pre-request scripts y tests automatizados. Importarlo en Postman: `File → Import → seleccionar el archivo JSON`.
