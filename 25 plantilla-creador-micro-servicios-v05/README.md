# CGV-TOOLS Manager v1.0

**por Cristián Gómez Vega**

---

## ¿Qué es CGV-TOOLS?

`cgv-tools.py` es una herramienta de línea de comandos escrita en Python que automatiza la creación completa de un proyecto **Spring Boot multi-módulo con microservicios**. A partir de un único archivo de configuración en Markdown (`CGV-TOOLS.md`), genera y organiza todos los archivos necesarios para poner en marcha un ecosistema de microservicios: proyectos descargados desde Spring Initializr, archivos `pom.xml` para Maven, archivos `application.yml` de configuración y scripts `.bat` para compilar y ejecutar los servicios en Windows.

---

## Requisitos

| Requisito  | Detalle                                            |
|---         |---                                                 |
| Python     | 3.10 o superior                                    |
| curl       | Disponible en el PATH del sistema                  |
| Maven      | Disponible en el PATH del sistema (`mvn`)          |
| Java       | JDK instalado (versión definida en `CGV-TOOLS.md`) |
| PowerShell | Para descompresión en Windows (`Expand-Archive`)   |
| unzip      | Para descompresión en macOS/Linux                  |

---

## Archivo de configuración: `CGV-TOOLS.md`

El script lee dos tablas Markdown del archivo `CGV-TOOLS.md` ubicado en el mismo directorio que el script (o en la ruta indicada como argumento).

### Tabla 1 — Datos del proyecto padre

Define los parámetros globales del proyecto Spring Boot:

```
| Campo                   | Valor                                    |
| :---                    | :---                                     |
| **Type**                | maven-project                            |
| **Language**            | java                                     |
| **Package**             | jar                                      |
| **Group Id**            | cl.triskeledu                            |
| **Parent Name**         | biblioteca                               |
| **Folder**              | C:\biblioteca-test                       |
| **Spring Boot Version** | 3.5.13                                   |
| **Java Version**        | 21                                       |
| **Project Name**        | Biblioteca                               |
| **Project Description** | Software de Administración de Biblioteca |
```

### Tabla 2 — Microservicios

Define la lista de microservicios a crear, con su puerto y dependencias de Spring Initializr, permitiendo la creación de más microservicios agregándolos al final de la tabla:

```
| Microservicio  | Puerto | Dependencias                                   |
| :---           | :---   | :---                                           |
| eureka         | 8761   | cloud-eureka-server, devtools                  |
| catalogo       | 9001   | web, data-jpa, lombok, postgresql, cloud-feign |
| recursos       | 9002   | web, data-jpa, lombok, postgresql, cloud-feign |
| usuarios       | 9003   | web, data-jpa, lombok, postgresql, cloud-feign |
```

> **Nota:** El microservicio `eureka` recibe tratamiento especial en todo el script: no lleva el prefijo `ms-` en su carpeta, su `pom.xml` tiene estructura diferente a los módulos hijos, y su `application.yml` no incluye configuración de base de datos.

---

## Uso

```bash
# Ejecutar con CGV-TOOLS.md en el mismo directorio
python cgv-tools.py

# O indicar la ruta del archivo explícitamente
python cgv-tools.py C:\mi-proyecto\CGV-TOOLS.md
```

Al iniciarse, el script carga y parsea el archivo `CGV-TOOLS.md` automáticamente y muestra el menú principal.

---

## Menú de opciones

```
╔══════════════════════════════════════════════════════════╗
║    CGV-TOOLS Manager v1.0 por Cristián Gómez Vega        ║
╠══════════════════════════════════════════════════════════╣
║  1. Ver lista de microservicios que serán creados        ║
║  2. Sólo crear download-projects.bat                     ║
║  3. Descargar y descomprimir proyectos de microservicios ║
║  4. Crear archivos pom.xml                               ║
║  5. Crear archivos application.yml                       ║
║  6. Crear archivos auxiliares .bat                       ║
║  7. Instalar pom.xml y application.yml en sus proyectos  ║
║  8. Salir                                                ║
╚══════════════════════════════════════════════════════════╝
```

---

### Opción 1 — Ver lista de microservicios que serán creados

Muestra en pantalla la lista de microservicios leída desde `CGV-TOOLS.md`, con el nombre de carpeta que se usará, el puerto asignado y las dependencias de cada uno. Útil para verificar que el archivo `.md` fue parseado correctamente antes de ejecutar cualquier otra opción.

**Ejemplo de salida:**
```
Listado de los microservicios:

  eureka       puerto: 8761  deps: cloud-eureka-server,devtools
  ms-catalogo  puerto: 9001  deps: web,data-jpa,lombok,postgresql,cloud-feign
  ms-recursos  puerto: 9002  deps: web,data-jpa,lombok,postgresql,cloud-feign
  ms-usuarios  puerto: 9003  deps: web,data-jpa,lombok,postgresql,cloud-feign
```

---

### Opción 2 — Sólo crear download-projects.bat

Crea la carpeta `Folder` si no existe y genera dentro de ella el archivo `download-projects.bat`. Este archivo contiene un comando `curl` por cada microservicio, apuntando a la API de **Spring Initializr** (`start.spring.io`) con todos los parámetros del proyecto configurados.

**El script NO ejecuta las descargas.** Solo genera el `.bat` para que el usuario lo ejecute manualmente cuando lo desee.

**Ejemplo de un comando generado:**
```bat
curl -o eureka.zip "https://start.spring.io/starter.zip?type=maven-project&language=java&bootVersion=3.5.13&baseDir=eureka&groupId=cl.triskeledu&artifactId=cl-triskeledu-eureka&name=biblioteca-eureka&..."
```

> **Nota sobre el `artifactId`:** Los puntos del `groupId` se reemplazan por guiones (`cl.triskeledu` → `cl-triskeledu`) para cumplir con las convenciones de Maven.

---

### Opción 3 — Descargar y descomprimir proyectos de microservicios

Combina la generación del `.bat` con la descompresión automática. El flujo es:

1. Crea la carpeta `Folder` si no existe.
2. Genera `download-projects.bat` con todos los comandos `curl`.
3. **Pausa** y muestra instrucciones para que el usuario ejecute el `.bat` manualmente en una terminal de Windows.
4. Cuando el usuario presiona `Enter`, el script busca los archivos `.zip` descargados y los descomprime usando la herramienta nativa del sistema operativo:
   - **Windows:** `PowerShell Expand-Archive`
   - **macOS / Linux:** `unzip`
5. Elimina cada `.zip` tras descomprimirlo correctamente.

---

### Opción 4 — Crear archivos pom.xml

Genera todos los archivos `pom.xml` del proyecto en la carpeta `Folder`, listos para ser instalados:

| Archivo generado | Destino final | Descripción |
|---|---|---|
| `pom-padre.xml` | `Folder\pom.xml` | POM del proyecto padre multi-módulo |
| `pom-eureka.xml` | `Folder\eureka\pom.xml` | POM del servidor Eureka |
| `pom-catalogo.xml` | `Folder\ms-catalogo\pom.xml` | POM de cada microservicio hijo |
| `pom-<nombre>.xml` | `Folder\ms-<nombre>\pom.xml` | Un archivo por cada microservicio |

**Características del POM padre:** incluye `<dependencyManagement>` con los BOM de Spring Boot y Spring Cloud, versiones centralizadas de todas las librerías (Lombok, MapStruct, PostgreSQL, H2, Hibernate Validator, etc.) y configuración de plugins de compilación.

**Características del POM hijo:** hereda del padre, declara las dependencias necesarias (Web, JPA, PostgreSQL, Lombok, MapStruct, Eureka Client, OpenFeign, DevTools) y configura el `mainClass` con el nombre correcto del proyecto, por ejemplo `BibliotecaCatalogoModuleApplication`.

> **Importante:** Al finalizar, el script recuerda las anotaciones necesarias en la clase main de Eureka:
> ```java
> import org.springframework.boot.SpringApplication;
> import org.springframework.boot.autoconfigure.SpringBootApplication;
> import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
> import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
> 
> @SpringBootApplication(exclude = {ValidationAutoConfiguration.class})
> @EnableEurekaServer
> ```

---

### Opción 5 — Crear archivos application.yml

Genera un archivo `application.yml` por cada microservicio en la carpeta `Folder`:

| Archivo generado | Destino final |
|---|---|
| `application-eureka.yml` | `Folder\eureka\src\main\resources\application.yml` |
| `application-catalogo.yml` | `Folder\ms-catalogo\src\main\resources\application.yml` |
| `application-<nombre>.yml` | `Folder\ms-<nombre>\src\main\resources\application.yml` |

**El `application.yml` de Eureka** configura el servidor en su puerto (`8761` por defecto) y deshabilita el auto-registro (`register-with-eureka: false`).

**El `application.yml` de los módulos hijos** configura:
- Puerto del servidor
- Nombre de la aplicación (`ms-<nombre>`)
- Conexión a PostgreSQL en `localhost:5433/<nombre>`
- Configuración de Hibernate/JPA
- Registro en Eureka (`localhost:8761/eureka`)
- Configuración de instancia con `prefer-ip-address` y renovación de lease

> **Importante:** Al finalizar, el script recuerda que los archivos deben copiarse a `src\main\resources\application.yml` dentro de cada proyecto.

---

### Opción 6 — Crear archivos auxiliares .bat

Genera en la carpeta `Folder` un conjunto de scripts `.bat` para facilitar el trabajo diario con los microservicios:

| Archivo | Descripción |
|---|---|
| `compile.bat` | Compila todos los microservicios ejecutando `mvn clean install -U` en cada carpeta |
| `install.bat` | Reinstalación completa: elimina `.m2`, borra carpetas `target` y vuelve a descargar todas las dependencias |
| `run-all.bat` | Levanta Eureka y todos los microservicios en ventanas de consola separadas usando `mvn spring-boot:run` |
| `run-test.bat` | Levanta todos los servicios desde sus JARs compilados con el perfil `test` |
| `run-eureka.bat` | Levanta únicamente el servidor Eureka |
| `run-<nombre>.bat` | Levanta únicamente el microservicio indicado (uno por cada módulo) |

Todos los archivos son **paramétricos**: las rutas, nombres de módulos y nombres de JARs se generan a partir de los datos del `CGV-TOOLS.md`, sin valores hardcodeados.

> **Nota sobre los JARs en `run-test.bat`:** el nombre del JAR sigue el patrón `{groupId sin puntos}-{nombre}-{version}.jar`, tal como lo genera Maven, por ejemplo: `cl-triskeledu-catalogo-0.0.1-SNAPSHOT.jar`.

---

### Opción 7 — Instalar pom.xml y application.yml en sus proyectos

Mueve automáticamente todos los archivos generados por las opciones 4 y 5 a sus ubicaciones definitivas dentro de cada proyecto descargado. Por cada microservicio realiza:

1. **pom.xml:** elimina el `pom.xml` original descargado por Spring Initializr y lo reemplaza con el `pom-<nombre>.xml` generado.
2. **application.yml:** elimina el `application.properties` que genera Spring Initializr por defecto y coloca el `application-<nombre>.yml` generado como `application.yml` en `src\main\resources\`.
3. **pom padre:** mueve `pom-padre.xml` a la raíz de `Folder` como `pom.xml`.

Al finalizar muestra un resumen de los archivos instalados, eliminados y cualquier advertencia si faltara algún archivo.

> **Prerequisitos para esta opción:** haber ejecutado previamente las opciones 3 (proyectos descargados), 4 (pom.xml generados) y 5 (application.yml generados).

---

## Flujo de trabajo recomendado

Seguir las opciones en este orden para configurar un proyecto desde cero:

```
1  →  Verificar lista de microservicios
2  →  Crear download-projects.bat
       (ejecutar el .bat manualmente en una terminal)
3  →  Descomprimir los proyectos descargados
4  →  Crear archivos pom.xml
5  →  Crear archivos application.yml
6  →  Crear archivos auxiliares .bat
7  →  Instalar pom.xml y application.yml en sus proyectos
```

Después de completar estos pasos la estructura del proyecto queda lista para abrir en IntelliJ IDEA, Eclipse o VS Code y comenzar a desarrollar.

---

## Estructura generada en la carpeta Folder

```
Folder/
├── pom.xml                          ← proyecto padre (multi-módulo)
├── download-projects.bat
├── compile.bat
├── install.bat
├── run-all.bat
├── run-test.bat
├── run-eureka.bat
├── run-<nombre>.bat                 ← uno por cada microservicio
├── eureka/
│   ├── pom.xml
│   └── src/main/
│       ├── java/.../<Proyecto>EurekaModuleApplication.java
│       └── resources/
│           └── application.yml
├── ms-catalogo/
│   ├── pom.xml
│   └── src/main/
│       ├── java/.../<Proyecto>CatalogoModuleApplication.java
│       └── resources/
│           └── application.yml
└── ms-<nombre>/                     ← uno por cada microservicio hijo
    ├── pom.xml
    └── src/main/
        ├── java/.../
        └── resources/
            └── application.yml
```

---

## Personalización de plantillas

Las plantillas de `pom.xml` y `application.yml` están definidas directamente en el script como variables de cadena con triple comilla, marcadas con la sección `PLANTILLAS XML / YAML`. Pueden editarse directamente en el archivo `cgv-tools.py` sin necesidad de tocar ningún otro archivo.

Los marcadores de sustitución tienen la forma `[nombreParametro]`, por ejemplo `[groupId]`, `[moduleName]`, `[port]`, `[springBootVersion]`, etc.

---

## Tecnologías incluidas en los proyectos generados

| Tecnología | Versión |
|---|---|
| Spring Boot | Configurable en `CGV-TOOLS.md` |
| Spring Cloud | 2025.0.0 |
| Netflix Eureka | Incluido en Spring Cloud |
| OpenFeign | Incluido en Spring Cloud |
| Spring Data JPA | Incluido en Spring Boot |
| PostgreSQL Driver | 42.7.3 |
| H2 Database | 2.3.232 |
| Lombok | 1.18.44 |
| MapStruct | 1.5.5.Final |
| Hibernate Validator | 8.0.1.Final |

---

## Autor

**Cristián Gómez Vega** — CGV-TOOLS Manager v1.0
