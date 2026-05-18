# Defensive API Array Checks in Frontend

## Problem
When a React frontend page calls a REST API and expects an array response, the code typically does:

```tsx
const response = await apiXxx.get('/endpoint');
setItems(response.data);  // Assumes response.data is an array
// Later: items.map(...) → CRASH if response.data is not an array
```

This crashes when:
1. The backend returns a wrapper object (pagination, error, single item)
2. Mock mode returns `{ message: ..., success: true }` (catch-all object)
3. The backend returns 200 with a different shape (e.g., Spring Page<T>)
4. Network errors result in `response.data` being undefined

## Solution
Always guard array assignment with `Array.isArray()`:

```tsx
const response = await apiXxx.get('/endpoint');
setItems(Array.isArray(response.data) ? response.data : []);
```

For nested array properties (e.g., carrito.items):
```tsx
const data = response.data;
if (data && typeof data === 'object' && Array.isArray(data.items)) {
    setCarrito(data);
} else {
    setCarrito(null);
}
```

## Prevention Rule
- **Every `.map()`, `.filter()`, `.reduce()` call on API response data MUST be preceded by `Array.isArray()` check OR the state must be initialized with a default empty array and only set to arrays**
- **New pages checklist**: Review ALL `.map()` calls against API response data
- **Custom hooks**: `useFetch` hook should include array validation in its return type
- **TypeScript types**: Mark API response types as potentially nullable (`T[] | null` instead of `T[]`)

## Detection Signs
- `Uncaught TypeError: xxx.map is not a function`
- Error boundary catches the error in a page component
- Page works on first load (with valid data) but crashes after data refresh
- Works with real backend but crashes with mock mode

## References
- openPrompt-Lang pattern: `@goodPractice` — defensive coding
- openPrompt-Lang pattern: `@badPractice` — no error handling
- React best practice: Error Boundaries for component tree isolation

## Tags
frontend, defensive-coding, array-guard, api, react, mapping

## Status
confirmed

## @kind(learning)
## @goodPractice: Siempre usar Array.isArray() antes de .map()/.filter() en datos de API
## @badPractice: Asumir que response.data es un array sin verificar
