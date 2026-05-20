#!/usr/bin/env bash
# ==============================================================================
# 🧪 Restaurant SaaS — Microservice API Test Suite & Deployment Manager
# ==============================================================================
#
# PROPÓSITO:
#   Script todo-en-uno de automatización de desarrollo:
#   1. Permite iniciar/detener todo el ecosistema (PostgreSQL Docker + 10 Microservicios).
#   2. Redirecciona logs de ejecución a la carpeta local 'logs/'.
#   3. Realiza comprobaciones de salud en tiempo real.
#   4. Ejecuta pruebas de integración API con encadenamiento de JWT dinámico.
#
# USO:
#   - Verificar y probar:  ./test_endpoints.sh
#   - Iniciar y testear:   ./test_endpoints.sh --deploy
#   - Detener servicios:    ./test_endpoints.sh --stop
#
# ==============================================================================

# Directorio base
BASE_DIR="/home/nodead/Escritorio/Restaurant-FullStack-Proyect/Restaurant"
PRUEBAS_DIR="${BASE_DIR}/pruebas-microservicios"
LOGS_DIR="${PRUEBAS_DIR}/logs"

# Colores para salida en consola
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
CYAN='\033[0;36m'
NC='\033[0m' # Sin color

# Puertos definidos — solo servicios de la defensa
EUREKA_PORT=8761
MS_AUTH_PORT=9001
MS_SUCURSALES_PORT=9003
MS_MENU_PORT=9004
MS_CARRITO_PORT=9006
MS_PEDIDOS_PORT=9007

# Lista de módulos — solo los 5 de mi presentación
MODULES=("ms-auth" "ms-sucursales" "ms-menu" "ms-carrito" "ms-pedidos")

# Función auxiliar para comprobar salud/ping HTTP
check_health() {
    local name=$1
    local port=$2
    local path=$3
    local silent=$4
    
    # Intento de conexión HTTP con timeout de 1s
    local response
    response=$(curl -s -o /dev/null -w "%{http_code}" --max-time 1 "http://localhost:${port}${path}")
    
    if [ "$response" -ne 0 ] && [ "$response" -ne 000 ]; then
        if [ "$silent" != "true" ]; then
            echo -e "📡 ${BLUE}${name}${NC}... ${GREEN}[ONLINE]${NC} (HTTP ${response})"
        fi
        return 0
    else
        if [ "$silent" != "true" ]; then
            echo -e "📡 ${BLUE}${name}${NC}... ${RED}[OFFLINE]${NC} (HTTP ${response:-000})"
        fi
        return 1
    fi
}

# Detener todos los servicios Spring Boot y Docker
stop_services() {
    echo -e "${YELLOW}🛑 Deteniendo servicios del ecosistema...${NC}"
    
    # Detener Spring Boots (matar procesos java que usen mvn spring-boot:run)
    local pids
    pids=$(pgrep -f "spring-boot")
    if [ -n "$pids" ]; then
        echo -e "👉 Finalizando procesos Java de Spring Boot..."
        kill -9 $pids 2>/dev/null
        echo -e "${GREEN}✅ Procesos Java finalizados.${NC}"
    else
        echo -e "ℹ️  No hay procesos activos de Spring Boot."
    fi
    
    # Apagar PostgreSQL con Docker Compose si está activo
    if command -v docker &> /dev/null; then
        echo -e "👉 Bajando contenedor PostgreSQL de Docker..."
        docker compose -f "${BASE_DIR}/docker-compose.yml" down
        echo -e "${GREEN}✅ Base de datos detenida.${NC}"
    fi
    
    echo -e "${GREEN}🎉 Ecosistema apagado de forma segura.${NC}"
    exit 0
}

# Capturar señal Ctrl+C (SIGINT) y SIGTERM para apagar todo el ecosistema de forma limpia
trap stop_services SIGINT SIGTERM

# Desplegar bases de datos e infraestructura
deploy_services() {
    echo -e "${YELLOW}🚀 Iniciando despliegue de infraestructura...${NC}"
    
    mkdir -p "${LOGS_DIR}"
    
    # 1. Base de datos
    if command -v docker &> /dev/null; then
        echo -e "🐳 Iniciando PostgreSQL mediante Docker Compose..."
        docker compose -f "${BASE_DIR}/docker-compose.yml" up -d
        sleep 2
    else
        echo -e "⚠️  Docker CLI no detectado localmente. Asegúrate de iniciar tu contenedor PostgreSQL manualmente en el puerto 5433."
    fi
    
    # 2. Iniciar Eureka
    echo -e "🌐 Iniciando Eureka Discovery Server..."
    nohup mvn -f "${BASE_DIR}/eureka" spring-boot:run > "${LOGS_DIR}/eureka.log" 2>&1 &
    
    echo -ne "⏳ Esperando que Eureka Server responda..."
    for i in {1..20}; do
        if check_health "Eureka" ${EUREKA_PORT} "" "true"; then
            echo -e " ${GREEN}[EUREKA EN LÍNEA]${NC}"
            break
        fi
        echo -n "."
        sleep 2
    done
    
    # 3. Iniciar Microservicios (solo los 5 de la defensa)
    echo -e "\n🔥 Desplegando 5 Microservicios en background..."
    for mod in "${MODULES[@]}"; do
        echo -e "👉 Lanzando ${BLUE}${mod}${NC} (Logs en logs/${mod}.log)..."
        nohup mvn -f "${BASE_DIR}/${mod}" spring-boot:run > "${LOGS_DIR}/${mod}.log" 2>&1 &
        sleep 1.5
    done

    # 4. Esperar registro en Eureka
    echo -e "\n${YELLOW}⏳ Esperando a que los 5 microservicios se registren e inicien...${NC}"
    echo -e "   (Este proceso suele tomar alrededor de 20-30 segundos)"

    local all_online=false
    for attempt in {1..30}; do
        local offline_count=0

        check_health "ms-auth" ${MS_AUTH_PORT} "/api/v1/auth/health" "true" || ((offline_count++))
        check_health "ms-sucursales" ${MS_SUCURSALES_PORT} "/api/v1/sucursales" "true" || ((offline_count++))
        check_health "ms-menu" ${MS_MENU_PORT} "/api/v1/menu" "true" || ((offline_count++))
        check_health "ms-carrito" ${MS_CARRITO_PORT} "/api/v1/carrito/usuario/1" "true" || ((offline_count++))
        check_health "ms-pedidos" ${MS_PEDIDOS_PORT} "/api/v1/pedidos" "true" || ((offline_count++))

        if [ "$offline_count" -eq 0 ]; then
            all_online=true
            echo -e "${GREEN}🎉 ¡Los 5 microservicios están en línea y respondiendo!${NC}"
            break
        fi

        echo -e "   [Intento $attempt/30] Aún inicializando... (${offline_count} microservicios fuera de línea)"
        sleep 4
    done

    if [ "$all_online" != "true" ]; then
        echo -e "${RED}⚠️  Atención: Algunos servicios tardaron demasiado en responder. Procediendo a testear los activos...${NC}"
    fi
}

# Evaluar parámetros
if [ "$1" == "--stop" ]; then
    stop_services
elif [ "$1" == "--deploy" ] || [ "$1" == "--start" ]; then
    deploy_services
fi

# Limpieza inicial de pantalla
clear
echo -e "${CYAN}==============================================================================${NC}"
echo -e "${YELLOW}🚀 INICIANDO AUDITORÍA Y VERIFICACIÓN DE ENDPOINTS DE MICROSERVICIOS${NC}"
echo -e "${CYAN}==============================================================================${NC}"

# Verificar si están caídos para sugerir despliegue automático
check_health "ms-auth" ${MS_AUTH_PORT} "/api/v1/auth/health" "true"
AUTH_HEALTH=$?

if [ "$AUTH_HEALTH" -ne 0 ] && [ "$1" != "--deploy" ]; then
    echo -e "${YELLOW}⚠️  Se detectó que el ecosistema de microservicios está OFFLINE.${NC}"
    read -p "🤔 ¿Deseas iniciar el despliegue de base de datos y microservicios automáticamente? [s/N]: " confirm
    if [[ "$confirm" =~ ^[sS]$ ]]; then
        deploy_services
    fi
fi

# 1. Comprobación de salud final
echo -e "\n${YELLOW}🔍 PASO 1: Comprobación de Salud de Endpoints (5 microservicios)...${NC}"
check_health "Eureka Discovery Server" ${EUREKA_PORT} ""
check_health "ms-auth" ${MS_AUTH_PORT} "/api/v1/auth/health"
check_health "ms-sucursales" ${MS_SUCURSALES_PORT} "/api/v1/sucursales"
check_health "ms-menu" ${MS_MENU_PORT} "/api/v1/menu"
check_health "ms-carrito" ${MS_CARRITO_PORT} "/api/v1/carrito/usuario/1"
check_health "ms-pedidos" ${MS_PEDIDOS_PORT} "/api/v1/pedidos"

# 2. Flujo de Autenticación Dinámica
echo -e "\n${YELLOW}🔑 PASO 2: Intentando registro e inicio de sesión dinámico (ms-auth)...${NC}"

TEST_USER="test_mesero_$(date +%s)"
TEST_EMAIL="mesero_$(date +%s)@restaurant.com"
TEST_PASS="Password123!"

echo -e "✍️ Registrando usuario de prueba '${TEST_USER}'..."
REGISTER_RES=$(curl -s -X POST "http://localhost:${MS_AUTH_PORT}/api/v1/auth/register" \
  -H "Content-Type: application/json" \
  -d "{
    \"username\": \"${TEST_EMAIL}\",
    \"password\": \"${TEST_PASS}\",
    \"rol\": \"ROLE_SA\"
  }")

echo -e "🔑 Obteniendo token JWT por inicio de sesión..."
LOGIN_RES=$(curl -s -X POST "http://localhost:${MS_AUTH_PORT}/api/v1/auth/login" \
  -H "Content-Type: application/json" \
  -d "{
    \"username\": \"${TEST_EMAIL}\",
    \"password\": \"${TEST_PASS}\"
  }")

# Extraer el JWT Token
JWT_TOKEN=$(echo "$LOGIN_RES" | grep -oP '"token":"\K[^"]+')

if [ -n "$JWT_TOKEN" ]; then
    echo -e "${GREEN}[PASS] Token JWT obtenido con éxito!${NC}"
    echo -e "📝 Token abreviado: ${BLUE}${JWT_TOKEN:0:30}... [EXPIRACIÓN: 24h]${NC}"
else
    echo -e "${RED}[FAIL] No se pudo obtener el token JWT.${NC}"
    echo -e "⚠️  Detalle de respuesta: $LOGIN_RES"
    echo -e "💡 Usando token simulado fallback para pruebas subsecuentes..."
    JWT_TOKEN="mock-token-secret-development-key-pass"
fi

# 3. Pruebas de integración cruzada
echo -e "\n${YELLOW}🧪 PASO 3: Pruebas funcionales de Endpoints (Verificación de Carga)${NC}"

run_api_test() {
    local method=$1
    local name=$2
    local url=$3
    local data=$4
    
    echo -ne "👉 Probando ${method} ${name}... "
    
    local http_code
    if [ "$method" == "GET" ]; then
        http_code=$(curl -s -o /dev/null -w "%{http_code}" -X GET "${url}" \
          -H "Authorization: Bearer ${JWT_TOKEN}" \
          -H "Content-Type: application/json")
    else
        http_code=$(curl -s -o /dev/null -w "%{http_code}" -X "${method}" "${url}" \
          -H "Authorization: Bearer ${JWT_TOKEN}" \
          -H "Content-Type: application/json" \
          -d "${data}")
    fi
    
    if [ "$http_code" -eq 200 ] || [ "$http_code" -eq 201 ] || [ "$http_code" -eq 204 ]; then
        echo -e "${GREEN}[OK]${NC} (Código ${http_code})"
    else
        echo -e "${RED}[ERROR]${NC} (Código ${http_code})"
    fi
}

# Ejecutar batería de pruebas
run_api_test "GET" "Sucursales [Listar Activas]" "http://localhost:${MS_SUCURSALES_PORT}/api/v1/sucursales"
run_api_test "POST" "Sucursales [Crear Sucursal]" "http://localhost:${MS_SUCURSALES_PORT}/api/v1/sucursales" '{"nombre":"Sucursal Central Test","direccion":"Av. Providencia 1234, Santiago","telefono":"+56911112222"}'
run_api_test "GET" "Menú [Listar Categorías]" "http://localhost:${MS_MENU_PORT}/api/v1/categorias"
run_api_test "GET" "Pedidos [Listar Cola]" "http://localhost:${MS_PEDIDOS_PORT}/api/v1/pedidos"
run_api_test "GET" "Pagos [Historial]" "http://localhost:${MS_PAGOS_PORT}/api/v1/pagos"
run_api_test "GET" "Delivery [Activos]" "http://localhost:${MS_DELIVERY_PORT}/api/v1/delivery"
run_api_test "GET" "Inventario [Stock]" "http://localhost:${MS_INVENTARIO_PORT}/api/v1/inventario"
run_api_test "GET" "Notificaciones [Fallidas]" "http://localhost:${MS_NOTIFICACIONES_PORT}/api/v1/notificaciones/estado/FALLIDO"
run_api_test "GET" "Reportes [Historial Ventas]" "http://localhost:${MS_REPORTES_PORT}/api/v1/reportes/tipo/VENTAS_DIARIAS"

echo -e "${CYAN}==============================================================================${NC}"
echo -e "${GREEN}🎉 FIN DE LA VERIFICACIÓN DE MICROSERVICIOS REST${NC}"
echo -e "${CYAN}==============================================================================${NC}"


# Detener los servicios backend al finalizar o si se interrumpe
stop_services
