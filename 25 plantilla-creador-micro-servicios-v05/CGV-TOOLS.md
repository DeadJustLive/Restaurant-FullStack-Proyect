# Creador de Proyectos Spring Boot
## Información del desarrollador de esta herramienta

**Desarrollado por:** Profesor Cristián Gómez Vega
**Fecha:** Abril de 2026
**Correo:** cri.gomezv@profesor.duoc.cl

Este documento y el archivo cgv-tools.py actúan en conjunto como una poderosa herramienta para generar y administrar proyectos en Java Spring Boot. El ejecutable cgv-tools.py tomará los valores que se indican en este mismo documento (CGV-TOOLS.md) y permitirá realizar tareas como: descargar proyectos de microservicios en .zip usando la API de Spring Initializr, crear los archivos application.yml usando los puertos indicados más abajo y los archivos pom.xml del proyecto padre y de los módulos hijos, entre otras utilidades.

## Instrucciones

Respeta la estructura de este archivo, no agregues nada nuevo, solo completa la información en caso de ser necesario. Al ejecutar la herramienta cgv-tool.bat se desplegarán un listado de opciones para ayudarte a generar y administrar tu proyecto en Java Spring Boot. El software .bat tomará la información de este mismo archivo para generar el proyecto. Puedes cambiar los valores de las tablas según tu necesidad. Puedes agregar microservicios, indicar sus puertos

## Información General

La siguiente tabla será usada para crear las coordenadas GAV (Group, Artifact, Version) del proyecto padre y los módulos hijos (los proyectos de cada microservicio).

| Campo                   | Valor                                    |
| :---                    | :---                                     |
| **Type**                | maven-project                            |
| **Language**            | java                                     |
| **Package**             | jar                                      |
| **Group Id**            | cl.triskeledu                            |
| **Parent Name**         | Restaurant                               |
| **Folder**              | C:\Restaurant                            |
| **Spring Boot Version** | 3.5.13                                   |
| **Java Version**        | 21                                       |
| **Project Name**        | Restaurant                               |
| **Project Description** | Restaurant                               |

## Configuración de Microservicios
| Microservicio  | Puerto | Dependencias                                             |
| :---           | :---   | :---                                                     |
| eureka         | 8761   | cloud-eureka-server, devtools                            |
| auth           | 9001   | web, data-jpa, lombok, postgresql, cloud-feign, security |
| usuarios       | 9002   | web, data-jpa, lombok, postgresql, cloud-feign           |
| sucursales     | 9003   | web, data-jpa, lombok, postgresql, cloud-feign           |
| menu           | 9004   | web, data-jpa, lombok, postgresql, cloud-feign           |
| categorias     | 9005   | web, data-jpa, lombok, postgresql, cloud-feign           |
| carrito        | 9006   | web, data-jpa, lombok, postgresql, cloud-feign           |
| pedidos        | 9007   | web, data-jpa, lombok, postgresql, cloud-feign, security |
| pagos          | 9008   | web, data-jpa, lombok, postgresql, cloud-feign           |
| delivery       | 9009   | web, data-jpa, lombok, postgresql, cloud-feign           |
| inventario     | 9010   | web, data-jpa, lombok, postgresql, cloud-feign           |
| notificaciones | 9011   | web, lombok, cloud-feign, mail                           |
| reportes       | 9012   | web, data-jpa, lombok, postgresql, cloud-feign           |

Agrega más microservicios según tu necesidad...