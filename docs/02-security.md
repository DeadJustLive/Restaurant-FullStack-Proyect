# 🛡️ Seguridad y Autenticación (Estado Actual vs Objetivo)

Este documento detalla la infraestructura de seguridad del sistema.

## 1. Estado Actual de Implementación (Auditado 2026-05-04)

### Acceso y Autenticación
- **Mecanismo:** Stateless via JWT (JSON Web Token).
- **Almacenamiento:** El token se almacena en `localStorage` en el cliente.
- **Hash de Contraseñas:** Implementado con **BCryptPasswordEncoder** (Strength 10) en `ms-auth`.
- **Excepciones Reales:** Manejo de `UsuarioYaExisteException`, `CredencialesInvalidasException` y `TokenInvalidoException`.

### Estructura Real del JWT (Claims)
Contrario a versiones preliminares de la documentación, el token actual contiene **únicamente** los siguientes claims (ver `JwtServiceImpl.java`):
- `sub`: Nombre de usuario.
- `userId`: Identificador único de la credencial.
- `roles`: Arreglo de strings (ej: `["ROLE_SA"]`).

> [!IMPORTANT]
> **Módulos Habilitados (enabledModules):** NO es un claim del JWT actualmente. Su gestión es una capa de **UX en el Frontend** basada en la respuesta del login. No debe considerarse una medida de seguridad de backend en esta fase.

### Autorización Backend
- **Estado:** Configurada pero **permisiva**. 
- Aunque los microservicios tienen la capacidad de usar `@PreAuthorize`, la mayoría de los endpoints están abiertos para facilitar la demo académica. La validación estricta de roles está implementada solo en el flujo de `ms-auth`.

---

## 2. Arquitectura Objetivo (Siguiente Etapa)

### Refresh Tokens
- **Plan:** Implementar rotación de tokens con persistencia en BD para permitir la revocación real de sesiones. Actualmente, el "Logout" es solo la eliminación del token en el cliente.

### Claims Extendidos
- **Plan:** Mover `enabledModules` al JWT para que el backend pueda denegar peticiones si el usuario intenta acceder a un microservicio que no tiene contratado/habilitado.

### API Gateway Seguridad
- **Plan:** Centralizar la validación del JWT en un Spring Cloud Gateway para evitar que peticiones no autenticadas toquen los microservicios internos.
