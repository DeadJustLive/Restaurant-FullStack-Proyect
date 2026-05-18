# duplicate-java-methods

## Resumen
Errores de compilación en Java causados por firmas de método duplicadas dentro de una misma clase (típicamente causados por conflictos mal resueltos en merges de Git). El compilador `javac` fallará inmediatamente con un error de firma duplicada.

## Tipo
backend

## Estado
confirmado

## Variantes disponibles
| Variante | Archivo | Descripción breve |
|----------|---------|-------------------|
| git-merge-conflict | `merge.md` | Métodos duplicados tras resolver conflictos de ramas |

## Relaciones
- Similar a: `git-merge-conflicts`
- Contraste con: `method-overloading`

## Reglas generales
- Realizar auditorías visuales de código usando compilaciones Maven locales antes de subir cambios a repositorios remotos.
- Remover bloques de código placeholder (`TODO` heredados) cuando se escribe la implementación final para evitar firmas redundantes.
