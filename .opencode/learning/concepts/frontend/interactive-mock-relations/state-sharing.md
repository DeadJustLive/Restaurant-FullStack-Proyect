# Variante: state-sharing (Compartición de Estado Mutable y Resolución Cruzada de FKs Lógicas)

Cuando simulamos microservicios con dependencias en el frontend (ej: el catálogo de platos en `ms-menu` requiere IDs de categorías válidos), un interceptor estático devolverá inconsistencias visuales si el usuario crea una categoría e intenta asociarla a un plato de inmediato.

Esta variante enseña cómo estructurar un interceptor con estado de memoria mutable compartido y cruce dinámico de llaves.

## 🛠️ Patrón de Código de Intercepción Compleja (Solución)

### 1. Inicialización Limpia de Estado Mutable
Clonamos los datos estáticos exportados desde archivos `@MOCK` para evitar colisiones de importación y permitir reasignación y mutación:

```typescript
import { MOCK_MENU_ITEMS as ORIGINAL_ITEMS } from '../mocks/data';

// Copia mutable en memoria del interceptor
let MOCK_MENU_ITEMS = [...ORIGINAL_ITEMS];
let MOCK_CATEGORIES = [
  { id: 1, nombre: 'Hamburguesas', activa: true },
  { id: 2, nombre: 'Pizzas', activa: true }
];
```

### 2. Resolución de Relaciones en Operaciones de Escritura (POST/PUT)
Cuando se envía un `POST` para registrar un plato, resolvemos dinámicamente el nombre de la categoría basándonos en el `categoriaId` enviado:

```typescript
if (method === 'POST') {
  const data = config.data ? JSON.parse(config.data) : {};
  
  // Resolución cruzada de FK lógica
  const padre = MOCK_CATEGORIES.find(c => c.id === parseInt(data.categoriaId, 10));
  
  const newItem = {
    id: MOCK_MENU_ITEMS.length > 0 ? Math.max(...MOCK_MENU_ITEMS.map(m => m.id)) + 1 : 1,
    nombre: data.nombre || 'Nuevo Plato',
    precio: parseFloat(data.precio) || 0.0,
    categoriaId: parseInt(data.categoriaId, 10),
    categoriaNombre: padre ? padre.nombre : 'Sin Categoría', // Mantenemos la consistencia denormalizada
    disponible: true
  };
  
  MOCK_MENU_ITEMS.push(newItem);
  return newItem;
}
```

### 3. Operaciones de Modificación e Invalidation Lógica (PUT/PATCH/DELETE)
*   **PUT:** Busca la entidad correspondiente y actualiza sus campos preservando los metadatos.
*   **PATCH:** Modifica un flag específico (ej: disponibilidad o estado de activación).
*   **DELETE:** Filtra y elimina físicamente de la variable mutable en memoria.

```typescript
if (method === 'DELETE') {
  const matchId = url.match(/\/(\d+)$/);
  if (matchId) {
    const id = parseInt(matchId[1], 10);
    MOCK_MENU_ITEMS = MOCK_MENU_ITEMS.filter(m => m.id !== id);
    return { success: true };
  }
}
```
