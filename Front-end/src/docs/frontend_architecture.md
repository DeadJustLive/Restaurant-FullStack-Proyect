# Arquitectura Frontend: Restaurant Platform

Este documento describe la estructura y decisiones técnicas del cliente React.

## 1. Principios de Diseño
- **Modularidad por Features:** Cada dominio (auth, admin, cocina) se agrupa por funcionalidad.
- **TypeScript Estricto:** Tipado completo de DTOs para coincidir con el backend.
- **Atomic Design Lite:** Componentes UI base (`/components/ui`) y componentes de negocio (`/components/features`).

## 2. Gestión de Accesos (Doble Capa)

### Capa A: Autorización (Roles)
Se utiliza el componente `ProtectedRoute` para interceptar cambios de ruta.
```tsx
<ProtectedRoute roles={['ROLE_SA', 'ROLE_AD']}>
  <UsersPage />
</ProtectedRoute>
```
Si el usuario no tiene el rol, es redirigido al dashboard.

### Capa B: Visibilidad (Módulos)
La navegación lateral (`Sidebar`) se genera dinámicamente filtrando el `navigationConfig` por los roles del usuario y, opcionalmente, por la lista `enabledModules` configurada para ese usuario específico.

## 3. Estado de las Vistas

| Ruta | Estado | Backend Real | Notas |
| :--- | :--- | :--- | :--- |
| `/login` | ✅ | `ms-auth` | Flujo JWT completo. |
| `/admin/usuarios` | ✅ | `apiUsuarios` | CRUD operativo. |
| `/admin/sucursales`| 🟡 | `apiSucursales` | UI Placeholder / API Real conectada. |
| `/admin/categorias`| 🟡 | `apiCategorias` | UI Placeholder / API Real conectada. |
| `/dashboard` | 🔴 | N/A | Datos Mock (`MOCK_DATA`). |
| `/cocina` | 🟡 | `apiPedidos` | Funcional con datos Mock. |

## 4. Comunicación con Backend (`axios.ts`)
Se utilizan instancias dedicadas de Axios por microservicio para manejar diferentes puertos y endpoints base:
- `apiAuth`: 9001
- `apiUsuarios`: 9002
- `apiSucursales`: 9003
- `apiMenu`: 9004
- `apiCategorias`: 9005
- `apiInventario`: 9010

---
**Nota:** Los interceptores de Axios están configurados para inyectar automáticamente el token de portador y registrar logs en el panel de DevTools interno.
