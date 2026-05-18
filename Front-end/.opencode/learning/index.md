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
