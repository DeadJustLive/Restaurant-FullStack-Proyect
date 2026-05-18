# javascript-asincronismo

## Resumen
Documento procesado con openPrompt-Lang Knowledge.

**Páginas:** 40
**Método:** native
**Procesado:** 2026-05-17

## Capítulos
- **1. Se apila console.log("Op. sync #1")**
- **2. Se imprime "Op. sync #1"**
- **3. Se desapila console.log("Op. sync #1")**
- **4. Se apila setTimeout(function callback() {...}**
- **5. Se ejecuta setTimeout. El browser delega el control de tiempo al**
- **6. Se desapila setTimeout(function callback() {...})**
- **7. Se apila console.log("Op. sync #3")**
- **8. Se imprime "Op. sync #3"**
- **9. Se desapila console.log("Op. sync #3")**
- **10. Tras dos segundos, el timer finaliza y pone el callback() en cola.**
- **11. El Event Loop toma el primer elemento de la cola y lo apila.**
- **12. Se ejecuta callback(), por ende, se apila**
- **13. Se imprime "Op. async #2“**
- **14. Se desapila console.log("Op. async #2")**
- **15. Se desapila callback()**
- **FIN DE LA PRESENTACIÓN**
