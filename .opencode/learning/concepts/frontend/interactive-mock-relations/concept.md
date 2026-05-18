# frontend-interactive-mock-relations

## Resumen
Los mocks tradicionales devuelven datos estáticos de solo lectura, lo que rompe la ilusión del prototipo en flujos CRUD de dominio cruzado (como vincular un Plato a una Categoría o una Sucursal). Al utilizar variables locales mutables e interconexiones dinámicas en interceptores de red simulados, se pueden modelar cambios de estado en vivo, borrados lógicos/físicos y resolución de llaves foráneas lógicas sin levantar servidores locales ni motores de base de datos.

## Tipo
frontend

## Estado
aprobado

## Variantes disponibles
| Variante | Archivo | Descripción breve |
|----------|---------|-------------------|
| state-sharing | `state-sharing.md` | Implementación de estado mutable compartido y relaciones de FK lógicas cruzadas en interceptores de red. |

## Relaciones
- Similar a: `frontend-high-fidelity-prototyping`
- Contraste con: `static-json-mocking`
- Compatible con: `axios-mock-interceptors`

## Reglas generales
- **NUNCA usar mocks estáticos de solo lectura** para demostraciones de nivel administrativo (CRUD).
- **Resolver FKs lógicas dinámicamente:** Al crear o modificar un ítem hijo (ej: Plato), buscar su padre (ej: Categoría) en la memoria local para rellenar campos agregados (ej: `categoriaNombre`), previniendo desincronizaciones de UI.
- **Mantener pureza de importación:** Evitar mutar directamente variables exportadas como constantes; en su lugar, clonar los datos mock iniciales a una variable de estado reasignable (`let`) dentro del archivo interceptor.
