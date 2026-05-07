# Justificación Arquitectónica: Validación de Permisos vía Feign

## 1. El Problema de la Seguridad Distribuida
En una arquitectura de microservicios, el control de acceso suele depender de un JSON Web Token (JWT). Cuando un usuario inicia sesión, recibe un token firmado que contiene sus roles (ej. `ROLE_ADMIN`) y una fecha de expiración (típicamente de 1 a 24 horas). 

**El riesgo operativo:** Si utilizamos **únicamente** la validación estática del JWT, corremos un riesgo crítico de seguridad. 
**Ejemplo de Negocio:** Si se despide a un empleado con rol de administrador (o se le revoca el acceso a modificar el menú) a las 14:00 hrs, pero su token JWT no caduca hasta las 18:00 hrs, este empleado tendría una "ventana de vulnerabilidad" de 4 horas en la que, teóricamente, podría seguir consumiendo el microservicio `ms-menu` y borrar productos de la base de datos sin que el sistema lo impida, ya que su token sigue siendo criptográficamente válido.

## 2. La Solución: Comunicación Síncrona con Feign
Para erradicar esta vulnerabilidad, hemos diseñado un patrón de **Delegación de Autorización en Tiempo Real** utilizando **Spring Cloud OpenFeign**.

En lugar de que cada microservicio confíe ciegamente en el token JWT, los microservicios actúan como clientes de validación.

### El Flujo Justificado:
1. Cuando un cajero intenta guardar un nuevo platillo en `ms-menu`, este microservicio "congela" la transacción.
2. `ms-menu` utiliza su `AuthFeignClient` para hacer una llamada HTTP síncrona a la fuente de la verdad: `ms-auth`.
3. Le pregunta a `ms-auth`: *"El usuario con ID 42 está intentando modificar el módulo MENU. ¿Aún tiene los permisos vigentes en la base de datos?"*.
4. `ms-auth` consulta la base de datos central en tiempo real. Al notar que el empleado fue despedido o inhabilitado hace 2 minutos, `ms-auth` responde con `false`.
5. `ms-menu` recibe la respuesta y lanza un error `403 Forbidden` (Acceso Denegado), abortando la modificación del menú y cerrando cualquier brecha de seguridad inmediatamente.

## 3. Beneficios Académicos y Técnicos de la Decisión
* **Zero Trust Architecture (Confianza Cero):** Ningún microservicio confía en un token estático para operaciones críticas de escritura sin validar con la fuente central.
* **Cohesión vs Acoplamiento:** Aunque introduce un ligero acoplamiento en tiempo de ejecución (síncrono), es un acoplamiento estrictamente necesario por seguridad. Se compensa al mantener la lógica de validación (cohesión) 100% aislada en `ms-auth`.
* **Revocación Inmediata:** Soluciona el problema clásico de la invalidez de los JWT, permitiendo desactivar usuarios en tiempo real sin requerir listas negras complejas en Redis.
