# Plan de Fase 5: Integración de Apache Kafka (Arquitectura Event-Driven)

## Objetivo
Desacoplar la comunicación síncrona (HTTP/Feign) en procesos que no requieren respuesta inmediata, transitando hacia una arquitectura asíncrona y orientada a eventos mediante Apache Kafka. Esto mejorará la resiliencia, evitará cascadas de fallos y reducirá los tiempos de respuesta del cliente.

## 1. Actualización de Infraestructura (Docker)
* **Acción:** Añadir un broker de Apache Kafka (y Zookeeper o KRaft) al `docker-compose.yml` principal.
* **Puertos:** Se expondrá el broker típicamente en el puerto `9092`.

## 2. Dependencias y Configuración (POM y YAML)
* **POM Padre / Microservicios:** Añadir la dependencia `spring-kafka` en los servicios que actuarán como productores o consumidores.
* **YAML:** Configurar las propiedades `spring.kafka.bootstrap-servers`, serializadores (`StringSerializer`, `JsonSerializer`) y los `group-id` correspondientes a cada microservicio consumidor.

## 3. Definición de Tópicos (Topics)
Se proponen los siguientes tópicos iniciales basados en los flujos core del restaurante:
1. `pedidos.eventos`: Eventos como `PEDIDO_CREADO`, `PEDIDO_PAGADO`, `PEDIDO_LISTO`.
2. `auth.eventos`: Eventos como `USUARIO_REGISTRADO`, `CREDENCIAL_DESACTIVADA`.
3. `delivery.eventos`: Eventos como `REPARTIDOR_ASIGNADO`, `PEDIDO_ENTREGADO`.

## 4. Implementación de Productores (Producers)
* **`ms-auth`:** Emitirá un evento al registrar un usuario.
* **`ms-pedidos`:** Emitirá eventos cada vez que cambie el estado de una orden.
* **`ms-pagos`:** Emitirá un evento al confirmar un pago exitoso mediante el Webhook.
* **`ms-delivery`:** Emitirá eventos al actualizar la ubicación o el estado de entrega.

## 5. Implementación de Consumidores (Consumers)
* **`ms-notificaciones`:** Escuchará tópicos de Pedidos, Auth y Delivery para enviar correos/SMS sin bloquear la respuesta de la API original.
* **`ms-reportes`:** Escuchará eventos de Pagos e Inventario para actualizar métricas analíticas en tiempo real (Materialized Views o contadores).
* **`ms-inventario`:** Podría escuchar el evento `PEDIDO_PAGADO` para descontar el stock de ingredientes de forma asíncrona.

## 6. Manejo de Errores y Transaccionalidad
* Configurar un sistema de reconexión y *Dead Letter Queue* (DLQ) para los eventos que no puedan ser procesados tras varios reintentos.
* Sustituir las interfaces de los *FeingClients* por los *Producers* donde la respuesta síncrona ya no sea requerida.
