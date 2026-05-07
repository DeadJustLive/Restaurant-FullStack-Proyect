# 🎓 Guía Académica de Arquitectura y Desarrollo en Spring Boot

¡Hola! Si estás leyendo esto, es porque te estás integrando al desarrollo de los microservicios de este proyecto. Esta guía fue creada con un enfoque **pedagógico y práctico** para que entiendas exactamente cómo está construido el sistema, por qué tomamos ciertas decisiones arquitectónicas y cómo puedes empezar a programar tus propios módulos sin sentirte perdido.

---

## 🏗️ 1. Nuestra Arquitectura de Microservicios

En lugar de tener un "monolito" (un solo proyecto gigante), dividimos el sistema en **10 microservicios independientes**. 
¿Por qué? 
- **Aislamiento de fallos:** Si el servicio de *Reportes* se cae por un error de cálculo, los clientes pueden seguir haciendo *Pedidos* y pagando sin darse cuenta del problema.
- **Escalabilidad:** Si en Año Nuevo recibimos miles de pedidos, podemos multiplicar el `ms-pedidos` en varios servidores sin tener que duplicar también el `ms-menu`.

### El Flujo de Comunicación
1. El **Frontend (React)** hace una petición HTTP.
2. Esa petición pasa por el **Eureka Server**, que actúa como una guía telefónica, diciéndole al Frontend en qué puerto (ej. `9004`) vive el microservicio que busca (`ms-menu`).
3. El microservicio procesa la lógica y guarda en **su propia base de datos** (PostgreSQL). ¡Ojo! *Ningún microservicio puede conectarse a la base de datos de otro*.

---

## 🧩 2. Anatomía de un Microservicio (El Patrón de 3 Capas)

Cada microservicio en este proyecto sigue una estructura estricta de 3 capas. Imagina que el microservicio es un Restaurante real:

### Capa 1: El Controlador (`@RestController`) -> "El Mesero"
Es la única clase que habla con el mundo exterior (Internet). Recibe el JSON del cliente, valida que los datos vengan bien y le entrega la orden a la cocina.
**Ejemplo Práctico:**
```java
@RestController
@RequestMapping("/api/v1/menu")
@RequiredArgsConstructor
public class MenuController {
    // Inyectamos el servicio (La cocina)
    private final MenuService menuService;

    @PostMapping
    public ResponseEntity<MenuDTO> crearPlato(@RequestBody MenuDTO plato) {
        // El mesero NO cocina. Solo pasa la orden al Service.
        MenuDTO platoCreado = menuService.crearPlato(plato);
        return ResponseEntity.status(201).body(platoCreado);
    }
}
```

### Capa 2: El Servicio (`@Service`) -> "El Chef"
Aquí vive la **Lógica de Negocio**. Aquí se hacen los cálculos, se validan reglas de negocio (ej. *"¿El platillo ya existe?"*), y se aplican los descuentos. 
**Ejemplo Práctico:**
```java
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    // Inyectamos la BD
    private final MenuRepository repository;
    
    @Override
    public MenuDTO crearPlato(MenuDTO dto) {
        if(repository.existsByNombre(dto.getNombre())) {
            throw new RuntimeException("¡El plato ya existe!"); // Regla de negocio
        }
        // ... guarda en la BD ...
    }
}
```

### Capa 3: El Repositorio (`@Repository`) -> "La Despensa"
Es la interfaz que habla con PostgreSQL. Gracias a **Spring Data JPA**, no necesitamos escribir código SQL (¡adiós `INSERT INTO`!). 

#### ¿Por qué usamos JPA?
JPA (Java Persistence API) convierte nuestras clases de Java en Tablas de SQL automáticamente (`@Entity`). 
En lugar de escribir complejas queries, solo escribimos firmas de métodos en la interfaz:
```java
public interface MenuRepository extends JpaRepository<Menu, Long> {
    // ¡La magia de Spring! Solo con escribir esto, Spring crea el SQL por ti:
    // SELECT * FROM menu WHERE nombre = ? AND precio < ?
    List<Menu> findByNombreAndPrecioLessThan(String nombre, Double precio);
}
```

---

## 🛡️ 3. Comunicación Inter-Servicios (Feign Client)

Como dijimos, los microservicios no pueden leer las bases de datos de otros. Entonces, ¿qué pasa si `ms-pedidos` necesita saber si un usuario tiene permisos (algo que solo sabe `ms-auth`)?
Usamos **OpenFeign**, que permite que un microservicio le haga una llamada HTTP síncrona a otro, como si fuera una simple llamada a una función.

**Ejemplo Práctico de Seguridad (Ya implementado):**
En `ms-pedidos`, antes de guardar un pedido, pausamos la ejecución y le "preguntamos" a `ms-auth`:
```java
// Llamada a través de la red hacia el puerto 9001 (ms-auth)
PermisoResponseDTO permiso = authFeignClient.validarAcceso(usuarioId, "PEDIDOS", "ESCRITURA");

if(!permiso.isPermitido()) {
    throw new AccesoDenegadoException("No tienes permiso");
}
// Si responde true, seguimos con la creación del pedido.
```
**¿Por qué es útil?** Si despedimos a un cajero, su permiso se pone en `false` en la BD de `ms-auth`. Al instante, `ms-pedidos` empezará a rebotar sus intentos, cortando cualquier riesgo de seguridad en tiempo real.

---

## 🛠️ 4. Ejercicio Práctico para Ti (Tu Primera Tarea)

Para que pongas esto en práctica, te hemos dejado el **scaffolding** (el esqueleto) listo en varios microservicios.

**Tu Misión:** Implementar la lógica del Carrito de Compras.
1. Abre `ms-carrito/src/main/java/.../service/impl/CarritoServiceImpl.java`.
2. Busca el método `crearCarrito(CarritoRequestDTO dto)`.
3. Verás que hay comentarios `// TODO` que te guían paso a paso.
4. **Lo que debes hacer:** 
   - Usa el `carritoMapper` para convertir el DTO en una `@Entity`.
   - Usa el `carritoRepository.save()` para guardarlo en la base de datos.
   - Retorna el resultado mapeado de vuelta a DTO.

¡No te preocupes por romper nada! El controlador ya está conectado y la base de datos se crea sola. Solo concéntrate en la lógica del "Chef" (`@Service`).

¡Mucho éxito codificando!
