#!/bin/bash
# ============================================================
# init.sh — Inicialización de bases de datos para Restaurant
# 
# Este script reemplaza el mecanismo automático de 
# /docker-entrypoint-initdb.d/ para manejar múltiples 
# bases de datos correctamente.
#
# Se ejecuta automáticamente por PostgreSQL al arrancar
# el contenedor cuando se monta en /docker-entrypoint-initdb.d/
# ============================================================

set -e

# Función para crear base de datos si no existe
create_db_if_not_exists() {
  local dbname="$1"
  psql -U "$POSTGRES_USER" -d postgres -tc \
    "SELECT 1 FROM pg_database WHERE datname = '$dbname'" | grep -q 1 || \
    psql -U "$POSTGRES_USER" -d postgres -c "CREATE DATABASE $dbname"
  echo "✅ Base de datos '$dbname' lista"
}

# Función para ejecutar SQL en una base de datos específica
run_sql() {
  local dbname="$1"
  local sqlfile="$2"
  if [ -f "$sqlfile" ]; then
    psql -U "$POSTGRES_USER" -d "$dbname" -f "$sqlfile"
    echo "✅ Ejecutado $sqlfile en $dbname"
  fi
}

echo "═══════════════════════════════════════════════"
echo "  Inicializando bases de datos Restaurant"
echo "═══════════════════════════════════════════════"

# Crear todas las bases de datos
create_db_if_not_exists "auth"
create_db_if_not_exists "sucursales"
create_db_if_not_exists "menu"
create_db_if_not_exists "carrito"
create_db_if_not_exists "pedidos"
create_db_if_not_exists "pagos"
create_db_if_not_exists "delivery"
create_db_if_not_exists "inventario"
create_db_if_not_exists "notificaciones"
create_db_if_not_exists "reportes"

echo ""
echo "───────────────────────────────────────────────"
echo "  Ejecutando scripts de esquema y datos..."
echo "───────────────────────────────────────────────"

# Directorio donde están los scripts SQL
SCRIPT_DIR="$(dirname "$0")/sql"

# Ejecutar cada script contra su base de datos
run_sql "auth"        "$SCRIPT_DIR/01-auth.sql"
run_sql "sucursales"  "$SCRIPT_DIR/02-sucursales.sql"
run_sql "inventario"  "$SCRIPT_DIR/03-inventario.sql"
run_sql "menu"        "$SCRIPT_DIR/04-menu.sql"
run_sql "carrito"     "$SCRIPT_DIR/05-carrito.sql"
run_sql "pagos"       "$SCRIPT_DIR/06-pagos.sql"
run_sql "pedidos"     "$SCRIPT_DIR/07-pedidos.sql"
run_sql "delivery"    "$SCRIPT_DIR/08-delivery.sql"
run_sql "notificaciones" "$SCRIPT_DIR/09-notificaciones.sql"
run_sql "reportes"    "$SCRIPT_DIR/10-reportes.sql"

# Fix de contraseñas (si existe el archivo)
run_sql "auth"        "$SCRIPT_DIR/fix-passwords.sql"

echo ""
echo "═══════════════════════════════════════════════"
echo "  ✅ Inicialización completada exitosamente"
echo "═══════════════════════════════════════════════"
