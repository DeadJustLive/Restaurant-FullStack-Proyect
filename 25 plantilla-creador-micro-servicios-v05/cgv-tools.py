#!/usr/bin/env python3
"""
CGV-TOOLS Manager v1.0 por Cristián Gómez Vega
Parsea el archivo CGV-TOOLS.md y gestiona microservicios Spring Boot.
"""

import os
import re
import sys
import platform
import subprocess
from pathlib import Path


# ══════════════════════════════════════════════════════════════════════════════
#  PLANTILLAS XML / YAML  (editables directamente en este script)
# ══════════════════════════════════════════════════════════════════════════════

# ── pom.xml del PADRE ────────────────────────────────────────────────────────
PLANTILLA_POM_PADRE = '''<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <!-- Modelo base de Maven -->
    <modelVersion>4.0.0</modelVersion>

    <!--
        *******************************************
        CGV INICIO: PERSONALIZAR PARA CADA PROYECTO
        *******************************************
    -->

    <!--
    Modulos hijos del proyecto.
    Cada uno es un subproyecto independiente (microservicio o libreria comun).
    -->
    <modules>
[MODULES]
        <!-- CGV: Agrega aqui mas modulos segun sea necesario -->
    </modules>

    <!-- Coordenadas GAV (GroupId, ArtifactId, Version) de mi proyecto padre -->
    <groupId>[groupId]</groupId>
    <artifactId>[parentName]</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>pom</packaging>
    <name>Proyecto Padre</name>
    <description>Proyecto padre para la gestion de versiones de todos los microservicios</description>

    <!--
        *******************************************
        CGV FIN: PERSONALIZAR PARA CADA PROYECTO
        *******************************************
    -->

    <!--
    Propiedades comunes a todos los modulos.
    Se reutilizan en todo el proyecto para evitar duplicacion.
    -->
    <properties>
        <java.version>[javaVersion]</java.version>                                            <!-- Version de Java a utilizar -->
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <spring-boot.version>[springBootVersion]</spring-boot.version>                        <!-- Version de Spring Boot base para microservicios -->
        <spring-cloud.version>2025.0.0</spring-cloud.version>                                 <!-- Version de Spring Cloud -->
        <mapstruct.version>1.5.5.Final</mapstruct.version>
        <lombok.version>1.18.44</lombok.version>
        <lombok-mapstruct-binding.version>0.2.0</lombok-mapstruct-binding.version>
        <jakarta.validation-api.version>3.0.2</jakarta.validation-api.version>
        <postgresql-connector-j.version>42.7.3</postgresql-connector-j.version>
        <com-h2database.version>2.3.232</com-h2database.version>
        <hibernate-validator.version>8.0.1.Final</hibernate-validator.version>
        <jakarta.el.version>4.0.2</jakarta.el.version>
        <maven.compiler.source>${java.version}</maven.compiler.source>
        <maven.compiler.target>${java.version}</maven.compiler.target>
        <maven-compiler-plugin.version>3.11.0</maven-compiler-plugin.version>
        <maven-clean-plugin.version>3.3.1</maven-clean-plugin.version>
    </properties>

    <dependencyManagement>
        <dependencies>

            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <dependency>
                <groupId>org.postgresql</groupId>
                <artifactId>postgresql</artifactId>
                <version>${postgresql-connector-j.version}</version>
            </dependency>

            <dependency>
                <groupId>com.h2database</groupId>
                <artifactId>h2</artifactId>
                <version>${com-h2database.version}</version>
            </dependency>

            <dependency>
                <groupId>org.mapstruct</groupId>
                <artifactId>mapstruct</artifactId>
                <version>${mapstruct.version}</version>
            </dependency>

            <dependency>
                <groupId>org.mapstruct</groupId>
                <artifactId>mapstruct-processor</artifactId>
                <version>${mapstruct.version}</version>
            </dependency>

            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>${lombok.version}</version>
            </dependency>

            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-validation</artifactId>
                <version>${spring-boot.version}</version>
            </dependency>

            <dependency>
                <groupId>org.hibernate.validator</groupId>
                <artifactId>hibernate-validator</artifactId>
                <version>${hibernate-validator.version}</version>
            </dependency>

            <dependency>
                <groupId>org.glassfish</groupId>
                <artifactId>jakarta.el</artifactId>
                <version>${jakarta.el.version}</version>
            </dependency>

        </dependencies>
    </dependencyManagement>

    <build>
        <plugins>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>${maven-compiler-plugin.version}</version>
                <configuration>
                    <source>${java.version}</source>
                    <target>${java.version}</target>
                    <release>${java.version}</release>
                    <compilerId>javac</compilerId>
                    <compilerArgs>
                        <arg>-parameters</arg>
                    </compilerArgs>
                    <generatedSourcesDirectory>${project.build.directory}/generated-sources/annotations</generatedSourcesDirectory>
                    <annotationProcessorPaths>
                        <path>
                            <groupId>org.mapstruct</groupId>
                            <artifactId>mapstruct-processor</artifactId>
                            <version>${mapstruct.version}</version>
                        </path>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                            <version>${lombok.version}</version>
                        </path>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok-mapstruct-binding</artifactId>
                            <version>${lombok-mapstruct-binding.version}</version>
                        </path>
                    </annotationProcessorPaths>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-clean-plugin</artifactId>
                <version>${maven-clean-plugin.version}</version>
                <configuration>
                    <filesets>
                        <fileset>
                            <directory>${project.build.directory}/generated-sources</directory>
                            <includes>
                                <include>**/*</include>
                            </includes>
                        </fileset>
                    </filesets>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>${spring-boot.version}</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>

        </plugins>
    </build>

</project>
'''

# ── pom.xml de modulos HIJOS (no-eureka) ─────────────────────────────────────
PLANTILLA_POM_HIJO = '''<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <!-- Modelo base de Maven -->
    <modelVersion>4.0.0</modelVersion>

    <!--
        *******************************************
        CGV INICIO: PERSONALIZAR PARA CADA PROYECTO
        *******************************************
    -->

    <!-- Herencia del proyecto padre que centraliza configuracion, BOM y versiones -->
    <parent>
        <groupId>[groupId]</groupId>
        <artifactId>[parentName]</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>

    <!-- Coordenadas GAV (GroupId, ArtifactId, Version) de este modulo -->
    <groupId>[groupId]</groupId>
    <artifactId>[msArtifactId]</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <!-- Nombre y descripcion del modulo -->
    <name>Modulo de [moduleNameCap]</name>
    <description>Servicio de [moduleNameCap].</description>

    <!--
        *******************************************
        CGV FIN: PERSONALIZAR PARA CADA PROYECTO
        *******************************************
    -->

    <!-- Forma de empaquetado es .jar -->
    <packaging>jar</packaging>

    <!-- Dependencias necesarias para este microservicio -->
    <dependencies>

        <!-- Spring Web: Controladores REST -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Spring JPA: acceso a base de datos con Hibernate -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <!-- PostgreSQL JDBC: driver JDBC para PostgreSQL -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- H2 Database: base de datos en memoria para pruebas y desarrollo local -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>${com-h2database.version}</version>
        </dependency>

        <!-- Validacion con anotaciones como @Valid, @NotNull, etc. -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- Lombok para reducir boilerplate con anotaciones como @Getter, @Builder -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>

        <!-- MapStruct: generador de codigo para mapeo entre entidades y DTOs -->
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct</artifactId>
        </dependency>

        <!-- Procesador de anotaciones de MapStruct -->
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct-processor</artifactId>
        </dependency>

        <!-- Dependencias de testing con JUnit, MockMvc, etc. -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- Cliente Eureka: registro y descubrimiento de este microservicio -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>

        <!-- OpenFeign: cliente HTTP declarativo para comunicacion entre microservicios -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>

        <!-- Spring Boot DevTools: recarga automatica en desarrollo -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>

    </dependencies>

    <!-- Empaquetado ejecutable con Spring Boot -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <mainClass>[groupId].[moduleName].[projectNameCap][moduleNameCap]Application</mainClass>
                </configuration>
            </plugin>

            <!-- Plugin de compilacion para procesadores de anotaciones (MapStruct + Lombok) -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <parameters>true</parameters>
                    <annotationProcessorPaths>
                        <path>
                            <groupId>org.mapstruct</groupId>
                            <artifactId>mapstruct-processor</artifactId>
                        </path>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </path>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok-mapstruct-binding</artifactId>
                        </path>
                    </annotationProcessorPaths>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
'''

# ── pom.xml de EUREKA ────────────────────────────────────────────────────────
PLANTILLA_POM_EUREKA = '''<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <!-- Modelo base de Maven -->
    <modelVersion>4.0.0</modelVersion>

    <!--
        *******************************************
        CGV INICIO: PERSONALIZAR PARA CADA PROYECTO
        *******************************************
    -->

    <!-- Herencia del proyecto padre que centraliza configuracion, BOM y versiones -->
    <parent>
        <groupId>[groupId]</groupId>
        <artifactId>[parentName]</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <!-- Coordenadas GAV (GroupId, ArtifactId, Version) de este modulo -->
    <groupId>[groupId]</groupId>
    <artifactId>[msArtifactId]-eureka</artifactId>
    <version>1.0-SNAPSHOT</version>

    <!-- Nombre y descripcion del modulo Eureka Server -->
    <name>[projectNameCap] - Eureka Module</name>
    <description>Netflix Eureka: Dynamic microservice discovery, registration, and lookup.</description>

    <!--
        *******************************************
        CGV FIN: PERSONALIZAR PARA CADA PROYECTO
        *******************************************
    -->

    <!-- Forma de empaquetado es .jar -->
    <packaging>jar</packaging>

    <!-- Dependencias necesarias para este microservicio -->
    <dependencies>

        <!-- Eureka server -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>

        <!-- Testing con JUnit, MockMvc, etc. -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.hibernate.validator</groupId>
            <artifactId>hibernate-validator</artifactId>
        </dependency>

        <dependency>
            <groupId>com.github.ben-manes.caffeine</groupId>
            <artifactId>caffeine</artifactId>
        </dependency>

    </dependencies>

    <!-- Empaquetado ejecutable con Spring Boot -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <mainClass>[groupId].eureka.[projectNameCap]EurekaApplication</mainClass>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.2.5</version>
            </plugin>
        </plugins>
    </build>

</project>
'''

# ── application.yml de EUREKA ────────────────────────────────────────────────
PLANTILLA_YML_EUREKA = '''server:
  port: [port]

spring:
  application:
    name: eureka-server

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
'''

# ── application.yml de modulos HIJOS ─────────────────────────────────────────
PLANTILLA_YML_HIJO = '''server:
  port: [port]
  error:
    include-stacktrace: never

spring:
  application:
    name: ms-[moduleName]
  datasource:
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5433/[moduleName]
    username: postgres
    password: 123
  jpa:
    hibernate:
      ddl-auto: update
    database: postgresql
    database-platform: org.hibernate.dialect.PostgreSQLDialect

eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:8761/eureka
  instance:
    prefer-ip-address: true
    instance-id: "${spring.application.name}:${random.value}"
    lease-renewal-interval-in-seconds: 15
    lease-expiration-duration-in-seconds: 60
'''


# ── launch.bat ───────────────────────────────────────────────────────────────
PLANTILLA_LAUNCH_BAT = r'''@echo off
setlocal

:MENU
cls
echo.
echo ============================================
echo   [PROJECT_NAME] - MENU PRINCIPAL
echo ============================================
echo.
echo   [1] Iniciar todos los servicios (dev)
echo   [2] Iniciar todos los servicios (test)
echo   [3] Compilar microservicios
echo   [4] Reinstalar dependencias Maven
echo.
echo   --- Servicios individuales ---
echo   [5] Iniciar Eureka
[MENU_MS_ITEMS]
echo.
echo   [0] Salir
echo.
echo ============================================
set /p opcion="  Selecciona una opcion: "

if "%opcion%"=="1" goto RUN_ALL
if "%opcion%"=="2" goto RUN_TEST
if "%opcion%"=="3" goto COMPILE
if "%opcion%"=="4" goto INSTALL
if "%opcion%"=="5" goto RUN_EUREKA
[MENU_IF_LINES]
if "%opcion%"=="0" goto SALIR

echo.
echo   Opcion invalida. Intenta de nuevo.
timeout /t 2 /nobreak > nul
goto MENU

REM ============================================

:RUN_ALL
cls
echo.
echo ===== Iniciando Eureka Server =====
start "EUREKA" mvn -f eureka spring-boot:run
timeout /t 5 /nobreak > nul
echo ===== Iniciando Microservicios =====
[RUN_ALL_LINES]
echo Todos los servicios han sido lanzados.
pause
goto MENU

:RUN_TEST
cls
echo.
echo ===== Iniciando Eureka Server (test) =====
start "EUREKA" java -jar eureka\target\[EUREKA_JAR] --spring.profiles.active=test
timeout /t 5 /nobreak > nul
echo ===== Iniciando Microservicios (test) =====
[RUN_TEST_LINES]
echo Todos los servicios han sido lanzados en modo test.
pause
goto MENU

:COMPILE
cls
echo.
echo ===== Compilando microservicios =====
[COMPILE_LINES]
echo Compilacion completada.
pause
goto MENU

:INSTALL
cls
echo.
echo === REINSTALACION DE DEPENDENCIAS MAVEN ===
echo.
echo Eliminando carpeta .m2 ...
rmdir /s /q %USERPROFILE%\.m2
echo Eliminando carpetas target ...
[RMDIR_LINES]
echo Descargando dependencias nuevamente con Maven ...
mvn clean install -U -DskipTests
echo.
echo === PROCESO COMPLETADO ===
pause
goto MENU

:RUN_EUREKA
cls
echo.
echo ===== Iniciando Eureka =====
start "EUREKA" mvn -f eureka spring-boot:run
echo Eureka iniciado.
pause
goto MENU

[RUN_MS_SECTIONS]

:SALIR
cls
echo.
echo   Hasta luego.
echo.
endlocal
exit /b
'''





# ── .vscode/launch.json ───────────────────────────────────────────────────────
PLANTILLA_LAUNCH_JSON = '''{
  "version": "0.2.0",
  "configurations": [
[CONFIGURATIONS]
  ],
  "compounds": [
    {
      "name": "Debug All Services",
      "configurations": [
[COMPOUND_NAMES]
      ]
    }
  ]
}
'''

# ── .vscode/settings.json ─────────────────────────────────────────────────────
PLANTILLA_SETTINGS_JSON = '''{
  "java.compile.nullAnalysis.mode": "automatic",
  "java.configuration.updateBuildConfiguration": "interactive",
  "files.autoSave": "afterDelay",
  "editor.minimap.enabled": false,
  "terminal.integrated.defaultProfile.windows": "Command Prompt"
}
'''

# ══════════════════════════════════════════════════════════════════════════════
#  HELPERS
# ══════════════════════════════════════════════════════════════════════════════

def limpiar_pantalla():
    os.system("cls" if platform.system() == "Windows" else "clear")


def pausar():
    input("\nPresione <ENTER> para volver al menú...")


def es_eureka(name: str) -> bool:
    return "eureka" in name.lower()


def base_dir_name(name: str) -> str:
    """Nombre de carpeta del microservicio: eureka sin prefijo, resto con ms-."""
    return name if es_eureka(name) else f"ms-{name}"


# ══════════════════════════════════════════════════════════════════════════════
#  PARSING
# ══════════════════════════════════════════════════════════════════════════════

def parse_markdown_tables(filepath: str):
    """
    Parsea las dos tablas del archivo CGV-TOOLS.md.
    Retorna (project_data: dict, microservices: list[dict])
    """
    try:
        with open(filepath, "r", encoding="utf-8") as f:
            content = f.read()
    except FileNotFoundError:
        print(f"  ✗ No se encontró el archivo: {filepath}")
        return None, None

    table_blocks = re.findall(r"(\|[^\n]+\|(?:\n\|[^\n]+\|)+)", content)

    if len(table_blocks) < 2:
        print("  ✗ No se encontraron las dos tablas requeridas en el archivo.")
        return None, None

    # ── Tabla 1: datos del proyecto padre ──
    project_data = {}
    for line in table_blocks[0].strip().split("\n"):
        if re.match(r"^\|\s*:?-+:?\s*\|", line):
            continue
        cells = [c.strip() for c in line.strip().strip("|").split("|")]
        if len(cells) >= 2:
            key   = re.sub(r"\*+", "", cells[0]).strip()
            value = cells[1].strip()
            if key:
                project_data[key] = value

    # ── Tabla 2: microservicios ──
    microservices = []
    lines   = table_blocks[1].strip().split("\n")
    headers = []
    for line in lines:
        if re.match(r"^\|\s*:?-+:?\s*\|", line):
            continue
        cells = [c.strip() for c in line.strip().strip("|").split("|")]
        if not headers:
            headers = [h.lower() for h in cells]
        else:
            if len(cells) >= len(headers):
                ms = {headers[j]: cells[j] for j in range(len(headers))}
                microservices.append(ms)

    return project_data, microservices


# ══════════════════════════════════════════════════════════════════════════════
#  CONSTRUCCIÓN DE COMANDOS CURL
# ══════════════════════════════════════════════════════════════════════════════

def build_curl_command(ms: dict, proj: dict) -> tuple:
    """Retorna (zip_name, comando_curl)."""
    name  = ms["microservicio"].strip()
    deps  = ms.get("dependencias", "").replace(" ", "").strip()

    group_id          = proj["Group Id"]
    java_ver          = proj["Java Version"]
    boot_ver          = proj["Spring Boot Version"]
    pkg               = proj["Package"]
    lang              = proj["Language"]
    ptype             = proj["Type"]
    project_name      = proj["Project Name"].split()[0].lower()  # e.g. "tienda"
    group_id_artifact = group_id.replace(".", "-")               # e.g. "cl-triskeledu"

    bdir     = base_dir_name(name)
    zip_name = f"{bdir}.zip"

    params = (
        f"type={ptype}"
        f"&language={lang}"
        f"&bootVersion={boot_ver}"
        f"&baseDir={bdir}"
        f"&groupId={group_id}"
        f"&artifactId={group_id_artifact}-{name}"
        f"&name={project_name}-{name}"
        f"&description=servicio-{name}"
        f"&packageName={group_id}.{name}"
        f"&packaging={pkg}"
        f"&javaVersion={java_ver}"
        f"&dependencies={deps}"
    )

    cmd = f'curl -o {zip_name} "https://start.spring.io/starter.zip?{params}"'
    return zip_name, cmd


# ══════════════════════════════════════════════════════════════════════════════
#  DESCOMPRESIÓN NATIVA DEL SO
# ══════════════════════════════════════════════════════════════════════════════

def unzip_system(zip_path: Path, dest_folder: Path) -> bool:
    """Descomprime usando la herramienta nativa del SO. Retorna True si tuvo éxito."""
    if platform.system() == "Windows":
        cmd = (
            f'powershell -NoProfile -Command '
            f'"Expand-Archive -LiteralPath \'{zip_path}\' '
            f'-DestinationPath \'{dest_folder}\' -Force"'
        )
        result = subprocess.run(cmd, shell=True)
    else:
        result = subprocess.run(["unzip", "-o", str(zip_path), "-d", str(dest_folder)])
    return result.returncode == 0


# ══════════════════════════════════════════════════════════════════════════════
#  OPCIONES DEL MENÚ
# ══════════════════════════════════════════════════════════════════════════════

def opcion_1_ver_microservicios(mss):
    """1. Ver lista de microservicios que serán creados."""
    limpiar_pantalla()
    print("Listado de los microservicios:\n")
    ancho_ms   = max(len(base_dir_name(ms["microservicio"])) for ms in mss)
    ancho_port = max(len(ms.get("puerto", "")) for ms in mss)
    for ms in mss:
        nombre = ms["microservicio"]
        puerto = ms.get("puerto", "")
        deps   = ms.get("dependencias", "")
        bdir   = base_dir_name(nombre)
        print(f"  {bdir:<{ancho_ms + 2}}  puerto: {puerto:<{ancho_port}}  deps: {deps}")
    pausar()


def _generar_bat(mss, proj, folder: Path) -> list:
    """Genera el contenido del .bat y devuelve la lista de zip_names."""
    zip_names = []
    lines_bat = [
        "@echo off",
        "echo Descargando microservicios Spring Boot...",
        "echo.",
    ]
    for ms in mss:
        zip_name, cmd = build_curl_command(ms, proj)
        zip_names.append(zip_name)
        lines_bat.append(f"echo Descargando {zip_name}...")
        lines_bat.append(cmd)
        lines_bat.append("echo.")
    lines_bat += ["echo Descarga completada.", "pause"]

    bat_path = folder / "download-projects.bat"
    bat_path.write_text("\r\n".join(lines_bat) + "\r\n", encoding="utf-8")
    return zip_names


def opcion_2_crear_bat(mss, proj):
    """2. Sólo crear download-projects.bat para descargar proyectos."""
    limpiar_pantalla()
    folder = Path(proj["Folder"])
    folder.mkdir(parents=True, exist_ok=True)
    _generar_bat(mss, proj, folder)
    print(f"El archivo download-projects.bat fue creado en la carpeta {folder}.")
    pausar()


def opcion_3_descargar_descomprimir(mss, proj):
    """3. Descargar y descomprimir proyectos de microservicios."""
    limpiar_pantalla()
    folder = Path(proj["Folder"])
    folder.mkdir(parents=True, exist_ok=True)

    zip_names = _generar_bat(mss, proj, folder)

    print(f"  Archivo download-projects.bat creado en: {folder}\n")
    print("  Ejecuta el archivo en una terminal de Windows:")
    print(f"\n    cd /d \"{folder}\"")
    print(f"    download-projects.bat\n")
    print("  Cuando termine la descarga, presiona Enter aquí para")
    print("  continuar con la descompresión de los archivos .zip.")
    input("\n  [Presione Enter para continuar con la descompresión...] ")

    print()
    encontrado = False
    for zip_name in zip_names:
        zip_path = folder / zip_name
        if not zip_path.exists():
            print(f"  ✗ No encontrado: {zip_name}  (¿se descargó correctamente?)")
            continue
        encontrado = True
        print(f"  Descomprimiendo {zip_name} ...")
        ok = unzip_system(zip_path, folder)
        if ok:
            zip_path.unlink()
            print(f"  ✓ {zip_name} descomprimido.")
        else:
            print(f"  ✗ Error al descomprimir {zip_name}.")

    print()
    if encontrado:
        print(f"Los microservicios han sido creados en la carpeta {folder},")
        print("no olvide crear los pom.xml y los application.yml.")
    else:
        print("  ✗ No se encontró ningún .zip. Verifica que el .bat se ejecutó correctamente.")
    pausar()


def opcion_4_crear_pom(mss, proj):
    """4. Crear archivos pom.xml."""
    limpiar_pantalla()
    folder = Path(proj["Folder"])
    folder.mkdir(parents=True, exist_ok=True)

    group_id    = proj["Group Id"]
    parent_name = proj["Parent Name"].lower()
    project_cap = proj["Project Name"].capitalize()
    java_ver    = proj["Java Version"]
    boot_ver    = proj["Spring Boot Version"]

    # ── pom-padre.xml ────────────────────────────────────────────────────────
    modules_lines = []
    for ms in mss:
        nombre  = ms["microservicio"].strip()
        bdir    = base_dir_name(nombre)
        comment = "Servidor Eureka" if es_eureka(nombre) else f"Microservicio {nombre}"
        modules_lines.append(f'        <module>{bdir}</module>      <!-- {comment} -->')

    contenido_padre = (
        PLANTILLA_POM_PADRE
        .replace("[groupId]",          group_id)
        .replace("[parentName]",        parent_name)
        .replace("[javaVersion]",       java_ver)
        .replace("[springBootVersion]", boot_ver)
        .replace("[MODULES]",           "\n".join(modules_lines))
    )
    pom_padre_path = folder / "pom-padre.xml"
    pom_padre_path.write_text(contenido_padre, encoding="utf-8")
    print(f"  ✓ Creado: {pom_padre_path}")

    # ── pom-<modulo>.xml ─────────────────────────────────────────────────────
    for ms in mss:
        nombre     = ms["microservicio"].strip()
        nombre_cap = nombre.capitalize()

        if es_eureka(nombre):
            contenido = (
                PLANTILLA_POM_EUREKA
                .replace("[groupId]",       group_id)
                .replace("[parentName]",     parent_name)
                .replace("[projectNameCap]", project_cap)
                .replace("[msArtifactId]", group_id.replace(".", "-"))
            )
            fname = "pom-eureka.xml"
        else:
            contenido = (
                PLANTILLA_POM_HIJO
                .replace("[groupId]",       group_id)
                .replace("[parentName]",     parent_name)
                .replace("[moduleName]",     nombre)
                .replace("[moduleNameCap]",  nombre_cap)
                .replace("[projectNameCap]", project_cap)
                .replace("[msArtifactId]", group_id.replace(".", "-") + "-" + nombre)
            )
            fname = f"pom-{nombre}.xml"

        pom_path = folder / fname
        pom_path.write_text(contenido, encoding="utf-8")
        print(f"  ✓ Creado: {pom_path}")

    print()
    print(f"1) Los archivos pom.xml han sido creados en la carpeta {folder},")
    print("no olvide copiarlos dentro de la raíz del proyecto correspondiente")
    print("y renombrar el archivo por el nombre pom.xml")
    print()
    print("""
2) NO OLVIDAR PONER ESTAS ANOTACIONES EN EL MAIN DEL PROYECTO EUREKA, ARRIBA DE LA CLASE:

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(exclude = {ValidationAutoConfiguration.class})
@EnableEurekaServer
        

""")
    pausar()


def opcion_5_crear_yml(mss, proj):
    """5. Crear archivos application.yml."""
    limpiar_pantalla()
    folder = Path(proj["Folder"])
    folder.mkdir(parents=True, exist_ok=True)

    for ms in mss:
        nombre = ms["microservicio"].strip()
        puerto = ms.get("puerto", "").strip()

        if es_eureka(nombre):
            contenido = PLANTILLA_YML_EUREKA.replace("[port]", puerto)
            fname     = "application-eureka.yml"
        else:
            contenido = (
                PLANTILLA_YML_HIJO
                .replace("[port]",       puerto)
                .replace("[moduleName]", nombre)
            )
            fname = f"application-{nombre}.yml"

        yml_path = folder / fname
        yml_path.write_text(contenido, encoding="utf-8")
        print(f"  ✓ Creado: {yml_path}")

    print()
    print(f"1) Los archivos application.yml han sido creados en la carpeta {folder},")
    print("no olvide copiarlos en las carpetas")
    print(f"  '{folder}\\<carpeta del microservicio>\\src\\main\\resources\\application.yml'")
    print("correspondientes a cada proyecto.")
    print()
    print("""
2) NO OLVIDAR PONER ESTAS ANOTACIONES EN EL MAIN DEL PROYECTO EUREKA:

@SpringBootApplication(exclude = {ValidationAutoConfiguration.class})
@EnableEurekaServer
public class ProyectoEurekaApplication {
""")
    pausar()




def opcion_6_crear_launch_bat(mss, proj):
    """6. Crear launch.bat para instalar y correr microservicios."""
    limpiar_pantalla()
    folder       = Path(proj["Folder"])
    group_id     = proj["Group Id"]
    project_name = proj["Project Name"].split()[0].capitalize()
    folder.mkdir(parents=True, exist_ok=True)

    no_eureka = [ms for ms in mss if not es_eureka(ms["microservicio"].strip())]

    def jar_name(nombre, version="0.0.1-SNAPSHOT"):
        gid = group_id.replace(".", "-")
        return f"{gid}-{nombre}-{version}.jar"

    eureka_jar  = jar_name("eureka", "1.0-SNAPSHOT")
    num_inicio  = 6   # opciones 5=eureka, 6..N=microservicios hijos
    sep         = "\r\n"

    # ── [MENU_MS_ITEMS] ───────────────────────────────────────────────────────
    menu_ms_items = []
    for i, ms in enumerate(no_eureka):
        bdir = base_dir_name(ms["microservicio"].strip())
        menu_ms_items.append("echo   [" + str(num_inicio + i) + "] Iniciar " + bdir)

    # ── [MENU_IF_LINES] ───────────────────────────────────────────────────────
    menu_if_lines = []
    for i, ms in enumerate(no_eureka):
        nombre = ms["microservicio"].strip()
        label  = nombre.upper().replace("-", "_")
        menu_if_lines.append('if "%opcion%"=="' + str(num_inicio + i) + '" goto RUN_' + label)

    # ── [RUN_ALL_LINES] ───────────────────────────────────────────────────────
    run_all_lines = []
    for ms in no_eureka:
        nombre = ms["microservicio"].strip()
        bdir   = base_dir_name(nombre)
        run_all_lines.append('start "' + bdir.upper() + '" mvn -f ' + bdir + ' spring-boot:run')

    # ── [RUN_TEST_LINES] ──────────────────────────────────────────────────────
    run_test_lines = []
    for ms in no_eureka:
        nombre = ms["microservicio"].strip()
        bdir   = base_dir_name(nombre)
        jname  = jar_name(nombre)
        run_test_lines.append(
            'start "' + bdir.upper() + '" java -jar ' + bdir + '\\\\target\\\\' + jname + ' --spring.profiles.active=test'
        )

    # ── [COMPILE_LINES] ───────────────────────────────────────────────────────
    compile_lines = []
    for ms in no_eureka:
        nombre = ms["microservicio"].strip()
        bdir   = base_dir_name(nombre)
        compile_lines.append("cd /d " + str(folder) + "\\" + bdir)
        compile_lines.append("call mvn clean install -U")

    # ── [RMDIR_LINES] ─────────────────────────────────────────────────────────
    rmdir_lines = []
    for ms in mss:
        nombre = ms["microservicio"].strip()
        bdir   = base_dir_name(nombre)
        rmdir_lines.append("rmdir /s /q " + str(folder) + "\\" + bdir + "\\target")

    # ── [RUN_MS_SECTIONS] ─────────────────────────────────────────────────────
    run_ms_sections = []
    for ms in no_eureka:
        nombre = ms["microservicio"].strip()
        bdir   = base_dir_name(nombre)
        label  = nombre.upper().replace("-", "_")
        seccion_lines = [
            ":RUN_" + label,
            "cls",
            "echo.",
            "echo ===== Iniciando " + bdir + " =====",
            'start "' + bdir.upper() + '" mvn -f ' + bdir + ' spring-boot:run',
            "echo " + bdir + " iniciado.",
            "pause",
            "goto MENU",
        ]
        run_ms_sections.append(sep.join(seccion_lines))

    contenido = (
        PLANTILLA_LAUNCH_BAT
        .replace("[PROJECT_NAME]",    project_name)
        .replace("[EUREKA_JAR]",      eureka_jar)
        .replace("[MENU_MS_ITEMS]",   sep.join(menu_ms_items))
        .replace("[MENU_IF_LINES]",   sep.join(menu_if_lines))
        .replace("[RUN_ALL_LINES]",   sep.join(run_all_lines))
        .replace("[RUN_TEST_LINES]",  sep.join(run_test_lines))
        .replace("[COMPILE_LINES]",   sep.join(compile_lines))
        .replace("[RMDIR_LINES]",     sep.join(rmdir_lines))
        .replace("[RUN_MS_SECTIONS]", (sep + sep).join(run_ms_sections))
    )

    p = folder / "launch.bat"
    p.write_text(contenido, encoding="utf-8")
    print(f"  ✓ Creado: {p}")
    print()
    print(f"El archivo launch.bat fue creado en la carpeta {folder}.")
    print()
    print("  Menú interactivo con las opciones:")
    print("  [1] Iniciar todos los servicios en modo dev")
    print("  [2] Iniciar todos los servicios en modo test (desde JARs compilados)")
    print("  [3] Compilar microservicios (mvn clean install)")
    print("  [4] Reinstalar dependencias Maven (limpia .m2 y targets)")
    print("  [5] Iniciar Eureka individualmente")
    for i, ms in enumerate(no_eureka):
        bdir = base_dir_name(ms["microservicio"].strip())
        print("  [" + str(num_inicio + i) + "] Iniciar " + bdir + " individualmente")
    print("  [0] Salir")
    pausar()


def opcion_7_instalar_archivos(mss, proj):
    """7. Mover pom.xml y application.yml a sus proyectos, eliminar archivos viejos."""
    limpiar_pantalla()
    folder = Path(proj["Folder"])

    movidos    = []
    eliminados = []
    errores    = []

    for ms in mss:
        nombre = ms["microservicio"].strip()
        bdir   = base_dir_name(nombre)
        dir_ms = folder / bdir

        if not dir_ms.exists():
            errores.append(f"  ✗ Carpeta no encontrada: {dir_ms}  (¿se descargaron los proyectos?)")
            continue

        # ── 1. Mover pom.xml ─────────────────────────────────────────────────
        fname_pom_src = "pom-eureka.xml" if es_eureka(nombre) else f"pom-{nombre}.xml"
        src_pom = folder / fname_pom_src
        dst_pom = dir_ms / "pom.xml"

        if src_pom.exists():
            if dst_pom.exists():
                dst_pom.unlink()
                eliminados.append(str(dst_pom))
            src_pom.rename(dst_pom)
            movidos.append(f"  ✓ {fname_pom_src}  →  {dst_pom}")
        else:
            errores.append(f"  ✗ No encontrado: {src_pom}  (¿se generó con la opción 4?)")

        # ── 2. Mover application.yml ──────────────────────────────────────────
        fname_yml_src = "application-eureka.yml" if es_eureka(nombre) else f"application-{nombre}.yml"
        src_yml   = folder / fname_yml_src
        dst_yml   = dir_ms / "src" / "main" / "resources" / "application.yml"
        dst_props = dir_ms / "src" / "main" / "resources" / "application.properties"

        if src_yml.exists():
            if dst_props.exists():
                dst_props.unlink()
                eliminados.append(str(dst_props))
            if dst_yml.exists():
                dst_yml.unlink()
                eliminados.append(str(dst_yml))
            src_yml.rename(dst_yml)
            movidos.append(f"  ✓ {fname_yml_src}  →  {dst_yml}")
        else:
            errores.append(f"  ✗ No encontrado: {src_yml}  (¿se generó con la opción 5?)")

    # ── 3. Mover pom-padre.xml a folder/pom.xml ──────────────────────────────
    src_padre = folder / "pom-padre.xml"
    dst_padre = folder / "pom.xml"
    if src_padre.exists():
        if dst_padre.exists():
            dst_padre.unlink()
            eliminados.append(str(dst_padre))
        src_padre.rename(dst_padre)
        movidos.append(f"  ✓ pom-padre.xml  →  {dst_padre}")
    else:
        errores.append(f"  ✗ No encontrado: {src_padre}  (¿se generó con la opción 4?)")

    # ── Resumen ───────────────────────────────────────────────────────────────
    if movidos:
        print("Archivos instalados:\n")
        for m in movidos:
            print(m)

    if eliminados:
        print("\nArchivos eliminados:\n")
        for e in eliminados:
            print(f"  🗑  {e}")

    if errores:
        print("\nAdvertencias:\n")
        for e in errores:
            print(e)

    if not errores:
        print(f"\nTodos los archivos han sido instalados correctamente en {folder}.")
    else:
        print(f"\nProceso completado con advertencias. Revise los errores indicados arriba.")

    pausar()



def opcion_8_crear_vscode(mss, proj):
    """8. Crear archivos .vscode/launch.json y .vscode/settings.json."""
    limpiar_pantalla()
    folder       = Path(proj["Folder"])
    group_id     = proj["Group Id"]
    project_cap  = proj["Project Name"].capitalize()
    vscode_dir   = folder / ".vscode"
    vscode_dir.mkdir(parents=True, exist_ok=True)

    group_id_artifact = group_id.replace(".", "-")  # e.g. "cl-triskeledu"

    # ── Construir bloques de configuraciones ──────────────────────────────────
    configs      = []
    config_names = []

    for ms in mss:
        nombre     = ms["microservicio"].strip()
        nombre_cap = nombre.capitalize()
        bdir       = base_dir_name(nombre)

        if es_eureka(nombre):
            debug_name   = "Debug Eureka"
            main_class   = f"{group_id}.eureka.{project_cap}EurekaApplication"
            project_name = f"{group_id_artifact}-eureka"
        else:
            debug_name   = f"Debug {bdir}"
            main_class   = f"{group_id}.{nombre}.{project_cap}{nombre_cap}Application"
            project_name = f"{group_id_artifact}-{nombre}"

        config_names.append(f'        "{debug_name}"')

        configs.append(
            f'    {{\n'
            f'      "type": "java",\n'
            f'      "name": "{debug_name}",\n'
            f'      "request": "launch",\n'
            f'      "cwd": "${{workspaceFolder}}/{bdir}",\n'
            f'      "mainClass": "{main_class}",\n'
            f'      "projectName": "{project_name}",\n'
            f'      "envFile": "${{workspaceFolder}}/.env"\n'
            f'    }}'
        )

    configurations_block = ",\n".join(configs)
    compound_names_block = ",\n".join(config_names)

    # ── Escribir launch.json ──────────────────────────────────────────────────
    launch_content = (
        PLANTILLA_LAUNCH_JSON
        .replace("[CONFIGURATIONS]", configurations_block)
        .replace("[COMPOUND_NAMES]", compound_names_block)
    )
    launch_path = vscode_dir / "launch.json"
    launch_path.write_text(launch_content, encoding="utf-8")
    print(f"  ✓ Creado: {launch_path}")

    # ── Escribir settings.json ────────────────────────────────────────────────
    settings_path = vscode_dir / "settings.json"
    settings_path.write_text(PLANTILLA_SETTINGS_JSON, encoding="utf-8")
    print(f"  ✓ Creado: {settings_path}")

    print()
    print(f"Los archivos de configuración de VS Code han sido creados en {vscode_dir}.")
    print()
    print("  launch.json  →  Configuraciones de depuración para cada microservicio")
    print("                  + compound 'Debug All Services' para lanzarlos todos juntos.")
    print("  settings.json →  Ajustes del workspace: análisis de nulos, guardado")
    print("                   automático, terminal CMD y minimap desactivado.")
    pausar()

# ══════════════════════════════════════════════════════════════════════════════
#  MENÚ PRINCIPAL
# ══════════════════════════════════════════════════════════════════════════════

CABECERA = """
╔══════════════════════════════════════════════════════════╗
║    CGV-TOOLS Manager v1.0 por Cristián Gómez Vega        ║
╠══════════════════════════════════════════════════════════╣
║  1. Ver lista de microservicios que serán creados        ║
║  2. Sólo crear download-projects.bat                     ║
║  3. Descargar y descomprimir proyectos de microservicios ║
║  4. Crear archivos pom.xml                               ║
║  5. Crear archivos application.yml                       ║
║  6. Crear launch.bat para instalar y correr servicios    ║
║  7. Instalar pom.xml y application.yml en sus proyectos  ║
║  8. Crear archivos .vscode (launch.json y settings.json) ║
║  9. Salir                                                ║
╚══════════════════════════════════════════════════════════╝
  Opción: """


def main():
    filepath = (
        sys.argv[1]
        if len(sys.argv) > 1
        else os.path.join(os.path.dirname(os.path.abspath(__file__)), "CGV-TOOLS.md")
    )

    proj, mss = parse_markdown_tables(filepath)
    if proj is None:
        print("  ✗ No se pudo cargar CGV-TOOLS.md. Verifique la ruta.")
        sys.exit(1)

    OPCIONES = {
        "1": lambda: opcion_1_ver_microservicios(mss),
        "2": lambda: opcion_2_crear_bat(mss, proj),
        "3": lambda: opcion_3_descargar_descomprimir(mss, proj),
        "4": lambda: opcion_4_crear_pom(mss, proj),
        "5": lambda: opcion_5_crear_yml(mss, proj),
        "6": lambda: opcion_6_crear_launch_bat(mss, proj),
        "7": lambda: opcion_7_instalar_archivos(mss, proj),
        "8": lambda: opcion_8_crear_vscode(mss, proj),
    }

    while True:
        limpiar_pantalla()
        opcion = input(CABECERA).strip()

        if opcion == "9":
            limpiar_pantalla()
            print("  ¡Hasta luego!\n")
            break
        elif opcion in OPCIONES:
            OPCIONES[opcion]()
        else:
            limpiar_pantalla()
            print("  ✗ Opción no reconocida. Intente de nuevo.")
            pausar()


if __name__ == "__main__":
    main()