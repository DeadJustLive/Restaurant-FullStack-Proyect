# javascript-asincronismo

- **ID**: javascript-asincronismo
- **Método**: native
- **Páginas**: 40
- **Capítulos**: 16
- **Generado**: 2026-05-17T09:15:22.525Z

## Resumen

# 1. Se apila console.log("Op. sync #1")

## Capítulos

### Cap. 1 — 1. Se apila console.log("Op. sync #1")

# 1. Se apila console.log("Op. sync #1")

### Cap. 2 — 2. Se imprime "Op. sync #1"

# 2. Se imprime "Op. sync #1"

### Cap. 3 — 3. Se desapila console.log("Op. sync #1")

# 3. Se desapila console.log("Op. sync #1")

### Cap. 4 — 4. Se apila setTimeout(function callback() {...}

# 4. Se apila setTimeout(function callback() {...}

### Cap. 5 — 5. Se ejecuta setTimeout. El browser delega el control de tiempo al

# 5. Se ejecuta setTimeout. El browser delega el control de tiempo al

timer. No hay nada más que hacer.

### Cap. 6 — 6. Se desapila setTimeout(function callback() {...})

# 6. Se desapila setTimeout(function callback() {...})

### Cap. 7 — 7. Se apila console.log("Op. sync #3")

# 7. Se apila console.log("Op. sync #3")

### Cap. 8 — 8. Se imprime "Op. sync #3"

# 8. Se imprime "Op. sync #3"

### Cap. 9 — 9. Se desapila console.log("Op. sync #3")

# 9. Se desapila console.log("Op. sync #3")

### Cap. 10 — 10. Tras dos segundos, el timer finaliza y pone el callback() en cola.

# 10. Tras dos segundos, el timer finaliza y pone el callback() en cola.

### Cap. 11 — 11. El Event Loop toma el primer elemento de la cola y lo apila.

# 11. El Event Loop toma el primer elemento de la cola y lo apila.

### Cap. 12 — 12. Se ejecuta callback(), por ende, se apila

# 12. Se ejecuta callback(), por ende, se apila

console.log("Op. async #2")

### Cap. 13 — 13. Se imprime "Op. async #2“

# 13. Se imprime "Op. async #2“

### Cap. 14 — 14. Se desapila console.log("Op. async #2")

# 14. Se desapila console.log("Op. async #2")

### Cap. 15 — 15. Se desapila callback()

Es muy común requerir datos de forma externa a nuestra app y tener que esperarlos para procesar algún resultado.

Secciones:
  # 15. Se desapila callback()

Conclusión: Cuál es tu nombre?

### Cap. 16 — FIN DE LA PRESENTACIÓN

# FIN DE LA PRESENTACIÓN

Encontrá más como estas en mi sitio web.

-- 40 of 40 --

