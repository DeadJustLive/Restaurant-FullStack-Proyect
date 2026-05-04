# Arquitectura Frontend: Evitando Código Espagueti y God Components

Para mantener el código mantenible, predecible y con alta capacidad de reutilización (>75%), este proyecto Frontend sigue estrictas pautas de arquitectura basadas en Atomic Design modificado y una estricta separación de responsabilidades.

## 1. Estructura de Directorios

La estructura de `src` está pensada para separar la lógica, la interfaz visual pura y las páginas de negocio:

- `components/ui/` (Componentes Atómicos): Son "tontos" (dumb components). Reciben propiedades (`props`) y emiten eventos (`onChange`, `onClick`). **NUNCA** hacen llamadas a la API ni contienen lógica de negocio. (Ej: `Button.tsx`, `Card.tsx`, `Input.tsx`).
- `components/features/` (Componentes Moleculares): Agrupan componentes UI para formar bloques lógicos del negocio, pero idealmente reciben sus datos por props. (Ej: `MenuCard`, `OrderSummary`).
- `pages/` (Contenedores): Son "inteligentes" (smart components). Aquí es donde se llama a los Hooks (`useFetch`) para obtener datos de la API y luego se pasan esos datos hacia abajo a los `features` o `ui`. **NUNCA** pongas estilos complejos directamente en una página.
- `hooks/`: Contiene la lógica compleja, el manejo del estado global o peticiones de red. (Ej: `useFetch`, `useAuth`, `useCart`). Si un componente empieza a tener muchos `useEffect` o estados, ¡es momento de extraerlos a un Custom Hook!
- `api/`: Centraliza todas las configuraciones de Axios. Cada microservicio tiene su propia instancia (ej. `apiMenu`, `apiInventario`) para soportar diferentes URLs o *timeouts* en el futuro.

## 2. Tailwind CSS y la Utilidad `cn`

Para evitar llenar el HTML de un código espagueti de clases, utilizamos `class-variance-authority` (cva) y `tailwind-merge` a través de la función `cn` (en `src/utils/utils.ts`).

### ❌ Lo que NO debes hacer (Spaghetti Classes):
```tsx
// Mal: Difícil de leer, mantener variantes requiere múltiples operadores ternarios.
<button className={`px-4 py-2 rounded-md ${isPrimary ? 'bg-blue-500 text-white' : 'bg-gray-200'} ${isDisabled ? 'opacity-50 cursor-not-allowed' : ''}`}>
  Click
</button>
```

### ✅ Lo que SÍ debes hacer (Componentes Reutilizables con CVA):
Usa el componente `Button` que ya define estas variantes de forma estructurada.
```tsx
// Bien: Limpio, tipado y fácil de mantener.
import { Button } from '@/components/ui/Button'

<Button variant="primary" size="lg" disabled={isDisabled}>
  Click
</Button>
```

## 3. Prevención de "God Components"

Un *God Component* es un archivo masivo (+300 líneas) que hace *fetch*, maneja el estado local, renderiza modales y listas, y tiene CSS en línea.

**Reglas de Oro:**
1. **Si un componente tiene más de 200 líneas**, probablemente hace demasiadas cosas. Córtalo.
2. **Separación Vista / Controlador:** Si notas que tienes muchos `useState` o lógica de transformación de datos (ej. filtrar una lista), saca esa lógica a un *Custom Hook*. El componente debe limitarse a renderizar lo que el Hook le entrega.
3. **Composición sobre Configuración:** En lugar de crear un `<Modal>` que reciba 50 props para configurar cada detalle, usa componentes compuestos (ver `Card` en `components/ui/Card.tsx`):
   ```tsx
   <Card>
     <CardHeader>
       <CardTitle>Título</CardTitle>
     </CardHeader>
     <CardContent>...</CardContent>
     <CardFooter>...</CardFooter>
   </Card>
   ```
   Esto permite flexibilidad sin enredar el componente padre con infinitas condiciones.

## 4. Consumo de Microservicios

Nunca uses `fetch` o `axios.get` directamente dentro de un `useEffect` en un componente. Utiliza el hook genérico `useFetch`.

```tsx
import { useFetch } from '@/hooks/useFetch';
import { apiMenu } from '@/api/axios';

export function CatalogoPage() {
  const { data, isLoading, error } = useFetch(apiMenu, '/items');

  if (isLoading) return <LoadingSpinner />;
  if (error) return <ErrorMessage error={error} />;

  return <CatalogoList items={data} />;
}
```
