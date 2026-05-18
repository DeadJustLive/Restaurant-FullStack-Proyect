# Memoria Semántica — openPrompt-Lang

## Propósito
Sistema de conceptos, variantes y relaciones para traducir lenguaje vago en decisiones concretas.

## Reglas obligatorias
1. Término vago → buscar en concepts/ antes de implementar
2. Si existe → mostrar variantes, usuario elige
3. Si no existe → preguntar antes de clasificar
4. Sin proyecto/dominio → NO guardar
5. Referencia externa → separar aprendizaje de copia
6. Concepto duplicado → reutilizar

## Categorías
- **personal**: Vocabulario personal del usuario (bonito, fudoshin, abstracción, etc.)
- **visual**: Conceptos visuales y estéticos (moderno, elegante, femenino, etc.)
- **ui**: Patrones de interfaz (card, hero, sidebar, etc.)
- **backend**: Conceptos de backend (auth, api, storage, etc.)
- **product**: Conceptos de producto (onboarding, checkout, etc.)
- **ai**: Conceptos de IA (generación, validación, etc.)

## Conceptos Registrados

### Backend (5)
| Concepto | Archivo | Estado |
|----------|---------|--------|
| axios-unsafe-json-request-body-parsing | concepts/backend/axios-unsafe-json-request-body-parsing/concept.md | confirmado |
| database-connection-pooling-optimization | concepts/backend/database-connection-pooling-optimization/concept.md | confirmado |
| cors-config-symmetry-microservices | concepts/backend/cors-config-symmetry-microservices/concept.md | confirmado |
| feign-auth-fallback-pattern | concepts/backend/feign-auth-fallback-pattern/concept.md | confirmado |

### Frontend (3)
| Concepto | Archivo | Estado |
|----------|---------|--------|
| interactive-mock-relations | concepts/frontend/interactive-mock-relations/concept.md | confirmado |
| mock-mode-conditional-logic-trap | concepts/frontend/mock-mode-conditional-logic-trap/concept.md | confirmado |
| defensive-api-array-checks | concepts/frontend/defensive-api-array-checks/concept.md | confirmado |
