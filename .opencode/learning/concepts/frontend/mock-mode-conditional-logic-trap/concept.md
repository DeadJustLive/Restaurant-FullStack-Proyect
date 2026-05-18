# Mock Mode Conditional Logic Trap

## Problem
Using `localStorage.getItem('key') !== 'false'` to check if mock mode is OFF creates a logic trap:

```typescript
// TRAP: When key doesn't exist in localStorage, getItem returns null
// null !== 'false' evaluates to TRUE → mock mode is ON by default
const isMock = localStorage.getItem('devtools_mockMode') !== 'false';
```

This means:
1. New users/clean sessions always have mock mode active
2. No real API calls are made (all intercepted by mockRouter)
3. If mockRouter lacks handlers for new services, the catch-all handler returns `{ message: '...', success: true }` which is an OBJECT not an ARRAY
4. Frontend pages call `.map()` on this object → `Uncaught TypeError: xxx.map is not a function`

## Root Cause
- **Negated boolean with inverted logic**: `!== 'false'` instead of `=== 'true'`
- **No explicit default initialization**: localStorage key not pre-set on first load
- **Missing mock handlers for new services**: When adding new pages, mockRouter.ts wasn't updated
- **No defensive checks**: Pages assumed API responses were arrays

## Solution
### 1. Fix default to OFF
```typescript
const isMock = localStorage.getItem('devtools_mockMode') === 'true';
// null === 'true' → false → mock OFF by default ✓
```

### 2. Add mock handlers for ALL services
When creating a new frontend page/API client, also add corresponding mock handlers in `mockRouter.ts`

### 3. Add defensive Array.isArray() guards
```typescript
setData(Array.isArray(res.data) ? res.data : []);
```

## Prevention Rule
- **Boolean flags in localStorage**: Use `=== 'true'` (opt-in) pattern, NOT `!== 'false'` (opt-out trap)
- **New service checklist**: When adding a new microservice/API client, MUST update mockRouter.ts with handlers
- **API response assumption**: NEVER assume `.data` is an array. Always guard with `Array.isArray()`
- **Mock mode**: Default OFF, explicitly ON only during development/testing

## Detection Signs
- `Uncaught TypeError: xxx.map is not a function` on pages that were working before
- Mock mode active unexpectedly (check DevTools → Settings)
- New pages crash immediately on load with `.map()` error
- Browser console shows mock data responses (never reaching real backend)

## References
- openPrompt-Lang pattern: `@badPractice` — no error handling, hardcoded data
- openPrompt-Lang pattern: `@goodPractice` — defensive coding, explicit defaults

## Tags
mock, localStorage, boolean-trap, frontend, defensive-coding, array-guard

## Status
confirmed

## @kind(learning)
## @goodPractice: Usar `=== 'true'` para flags booleanas en localStorage (opt-in explícito)
## @badPractice: Usar `!== 'false'` para detectar modo mock (default ON cuando la key no existe)
