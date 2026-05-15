
/* ============================================================
   ARCHIVO: 00-init.sql
   Propósito: Crear bases de datos independientes por microservicio.
   Ejecutar conectado a la base postgres: psql -U postgres -d postgres -f 00-create_dbs.sql
   ============================================================ */

SELECT 'CREATE DATABASE auth'   WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'auth')   \gexec
SELECT 'CREATE DATABASE sucursales'   WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'sucursales')   \gexec
SELECT 'CREATE DATABASE menu'   WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'menu')   \gexec
SELECT 'CREATE DATABASE carrito'  WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'carrito')  \gexec
SELECT 'CREATE DATABASE pedidos'     WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'pedidos')     \gexec
SELECT 'CREATE DATABASE pagos'   WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'pagos')   \gexec
SELECT 'CREATE DATABASE delivery'   WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'delivery')   \gexec
SELECT 'CREATE DATABASE inventario'      WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'inventario')      \gexec
SELECT 'CREATE DATABASE notificaciones'    WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'notificaciones')    \gexec
SELECT 'CREATE DATABASE reportes' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'reportes') \gexec
