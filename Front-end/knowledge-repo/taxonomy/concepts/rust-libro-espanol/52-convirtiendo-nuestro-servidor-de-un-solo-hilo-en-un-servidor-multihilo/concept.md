# Convirtiendo nuestro servidor de un solo hilo en un servidor multihilo

## Fuente
El Lenguaje de Programación Rust (Libro Oficial en Español) (Cap. 52)

## Contenido
# Convirtiendo nuestro servidor de un solo hilo en un servidor multihilo

## Convirtiendo nuestro servidor de un solo hilo en un servidor multihilo

### Simulando una solicitud lenta en la implementación actual del servidor

### Mejorando el rendimiento con un pool de hilos

#### Creando un hilo para cada solicitud

#### Creando un número finito de hilos

#### ConstruyendoThreadPoolusando el desarrollo impulsado por el compilador

#### Validando el número de hilos ennew

#### Creando espacio para almacenar los hilos

#### Un structWorkerresponsable de enviar código desde elThreadPoola un hilo

#### Enviando solicitudes a hilos a través de canales

#### Implementando el métodoexecute
