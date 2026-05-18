# CORS Configuration Symmetry in Multi-Microservice Projects

## Problem
When a project has 10+ microservices, CORS configuration can become asymmetrical:
- ms-auth had `SecurityConfig` with `setAllowedOriginPatterns("http://localhost:*")` (wildcard)
- The other 9 microservices had `CorsConfig` (WebMvcConfigurer) with hardcoded `allowedOrigins("http://localhost:3000", "http://localhost:3002", "http://localhost:5173")`

Result: When the frontend ran on port 3001 (Vite auto-selected next available), health checks via `XMLHttpRequest` from the browser succeeded only for ms-auth. All 9 other services rejected CORS preflight silently, returning 0 in the health panel.

## Root Cause
- **Asymmetric CORS mechanism**: `SecurityConfig.upersetAllowedOriginPatterns` vs `CorsConfig.addCorsMappings`
- **Hardcoded port list**: Adding/removing ports requires editing multiple files
- **No shared configuration module**: Each microservice duplicated the CORS logic

## Solution
1. All CorsConfig files use `allowedOriginPatterns("http://localhost:*", "http://127.0.0.1:*")` consistently
2. This allows ANY localhost port, covering Vite's auto port selection
3. Uses `allowedOriginPatterns` (Spring 5.3+) instead of `allowedOrigins` for wildcard support

## Prevention Rule
- When adding a new microservice, COPY the CorsConfig from an existing service and verify it uses `allowedOriginPatterns`
- NEVER use hardcoded port lists in CORS config
- Consider a shared library module for CORS configuration

## Detection Signs
- DevTools health panel shows only SOME services as UP
- Browser console shows CORS errors only for certain services
- The service that does work is the only one using a different CORS mechanism

## References
- Spring Security: `setAllowedOriginPatterns(List<String>)`
- Spring WebMvcConfigurer: `CorsRegistration.allowedOriginPatterns(String...)`
- openPrompt-Lang pattern: `api-gateway` (CORS at gateway level when available)

## Tags
cors, microservices, spring-boot, webmvcconfigurer, security-config

## Status
confirmed

## @kind(learning)
## @goodPractice: Usar allowedOriginPatterns con wildcard en vez de allowedOrigins con lista fija
## @badPractice: Duplicar CORS config con listas hardcoded en cada microservicio
