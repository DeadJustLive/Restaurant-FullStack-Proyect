# 🚀 Restaurant Frontend — Guía de Arquitectura

Este proyecto frontend está construido con **React** y **TypeScript**, utilizando una arquitectura modular basada en **Features/Domains**. Esta estructura asegura que el código sea escalable, fácil de testear y mantenible a largo plazo.

## 📁 Estructura de Carpetas

```text
src/
├── api/              # Configuración de Axios y clientes de microservicios.
├── assets/           # Recursos estáticos (imágenes, iconos globales).
├── components/       # UI Library compartida (botones, inputs, tablas).
├── config/           # Variables de entorno y constantes de la aplicación.
├── contexts/         # Estado global (Auth, Notificaciones, Temas).
├── features/         # Lógica de negocio dividida por dominios (CORE).
│   ├── auth/         # Login, registro, recuperación.
│   ├── orders/       # Listado de pedidos, detalles, estados.
│   └── ...           # Cada feature tiene sus propias sub-carpetas (api, components, hooks).
├── hooks/            # Hooks de utilidad global (useLocalStorage, useDebounce).
├── layouts/          # Envoltorios de página (MainLayout, SimpleLayout).
├── pages/            # Componentes de ruta que orquestan las features.
├── routes/           # Definición del Router y guardas de seguridad.
├── styles/           # Tokens de diseño, variables CSS y estilos globales.
├── types/            # Interfaces y tipos TypeScript transversales.
└── utils/            # Funciones puras de utilidad (formateadores, validadores).
```

## 🛠️ Reglas de Desarrollo

### 1. Organización por Features
Cada carpeta en `src/features` debe ser autosuficiente. Si un componente solo se usa en "Pedidos", debe vivir en `features/orders/components`. Si se usa en más de una feature, se mueve a `src/components`.

### 2. Conexión con Microservicios
- Los servicios de API deben residir dentro de su respectiva feature (`features/name/api/`).
- Usar el cliente base de `src/api/` que ya maneja la inyección de tokens JWT.
- **Responsabilidad**: La feature pide los datos, la `page` los recibe y los pasa a los componentes.

### 3. Convención de Nombres
- **Componentes**: PascalCase (`ProjectCard.tsx`).
- **Hooks**: camelCase con prefijo use (`useProjectData.ts`).
- **Servicios**: camelCase (`projectService.ts`).
- **Tipos**: PascalCase con prefijo I o sufijo Type si es necesario (`IProject.ts`).

### 4. Seguridad y Roles
- El acceso se gestiona en `src/routes/` mediante componentes de orden superior (HOC) o wrappers.
- Ejemplo: `<ProtectedRoute roles={['ROLE_ADMIN']}>`.

## 🚀 Cómo Crecer sin Desorden
1. **No crees archivos gigantes**: Si un componente pasa de las 200 líneas, sepáralo en sub-componentes.
2. **Separa la lógica**: Usa hooks dentro de las features para manejar el estado y las llamadas a la API.
3. **Tipado estricto**: Evita el uso de `any`. Define interfaces para todas las respuestas de los microservicios.

---
*Este documento es la fuente de verdad para la organización del código.*
