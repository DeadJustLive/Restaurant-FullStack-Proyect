#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
LOG_DIR="$SCRIPT_DIR/logs"

RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
CYAN='\033[0;36m'
BOLD='\033[1m'
NC='\033[0m'

SKIP_DOCKER=false
SKIP_COMPILE=false
SKIP_FRONTEND=false
ONLY_SERVICES=()

declare -A SERVICE_PORT
SERVICE_PORT=(
  [eureka]=8761
  [ms-auth]=9001
  [ms-sucursales]=9003
  [ms-menu]=9004
  [ms-carrito]=9006
  [ms-pedidos]=9007
  [ms-pagos]=9008
  [ms-delivery]=9009
  [ms-inventario]=9010
  [ms-notificaciones]=9011
  [ms-reportes]=9012
)

SERVICE_ORDER=(eureka ms-auth ms-sucursales ms-menu ms-carrito ms-pedidos ms-pagos ms-delivery ms-inventario ms-notificaciones ms-reportes)

PIDS=()

log()  { echo -e "${BLUE}[INFO]${NC} $*"; }
ok()   { echo -e "${GREEN}[OK]${NC} $*"; }
warn() { echo -e "${YELLOW}[WARN]${NC} $*"; }
err()  { echo -e "${RED}[ERROR]${NC} $*"; }

usage() {
  cat <<EOF
${BOLD}Usage:${NC} $(basename "$0") [OPTIONS]

${BOLD}Options:${NC}
  --no-docker      Skip docker-compose step
  --no-compile     Skip Maven compilation step
  --no-frontend    Skip frontend startup
  --only <svc>     Start only specified service(s) (comma-separated)
                   Available: ${SERVICE_ORDER[*]}, frontend
  -h, --help       Show this help message

${BOLD}Examples:${NC}
  $(basename "$0")                         # Start everything
  $(basename "$0") --no-docker              # Skip Docker infrastructure
  $(basename "$0") --only eureka,ms-auth    # Start only Eureka and ms-auth
  $(basename "$0") --no-frontend            # Skip frontend
EOF
  exit 0
}

parse_args() {
  while [[ $# -gt 0 ]]; do
    case "$1" in
      --no-docker)    SKIP_DOCKER=true; shift ;;
      --no-compile)   SKIP_COMPILE=true; shift ;;
      --no-frontend)  SKIP_FRONTEND=true; shift ;;
      --only)
        if [[ -z "${2:-}" ]]; then
          err "--only requires a service name"
          exit 1
        fi
        IFS=',' read -ra ONLY_SERVICES <<< "$2"
        shift 2
        ;;
      -h|--help) usage ;;
      *) err "Unknown option: $1"; exit 1 ;;
    esac
  done
}

should_start_service() {
  local svc="$1"
  if [[ ${#ONLY_SERVICES[@]} -eq 0 ]]; then
    return 0
  fi
  local s
  for s in "${ONLY_SERVICES[@]}"; do
    if [[ "$s" == "$svc" ]]; then
      return 0
    fi
  done
  return 1
}

wait_for_port() {
  local port="$1"
  local name="$2"
  local max_retries="${3:-60}"
  local retry=0
  printf "  Waiting for ${CYAN}%s${NC} on port ${CYAN}%s${NC} ..." "$name" "$port"
  while ! curl -sf -o /dev/null "http://localhost:${port}" 2>/dev/null; do
    retry=$((retry + 1))
    if [[ $retry -ge $max_retries ]]; then
      echo -e " ${RED}TIMEOUT${NC}"
      err "${name} did not start after ${max_retries}s"
      return 1
    fi
    sleep 1
    printf "."
  done
  echo -e " ${GREEN}UP${NC}"
  return 0
}

check_status() {
  local port="$1"
  if curl -sf -o /dev/null "http://localhost:${port}" 2>/dev/null; then
    echo -e "${GREEN}UP${NC}"
    return 0
  else
    echo -e "${RED}DOWN${NC}"
    return 1
  fi
}

start_docker() {
  log "Starting Docker infrastructure..."
  if ! command -v docker-compose &>/dev/null && ! docker compose version &>/dev/null 2>&1; then
    err "docker-compose not found. Install it or use --no-docker"
    exit 1
  fi

  if docker compose version &>/dev/null 2>&1; then
    docker compose -f "$SCRIPT_DIR/docker-compose.yml" up -d
  else
    docker-compose -f "$SCRIPT_DIR/docker-compose.yml" up -d
  fi

  log "Waiting for PostgreSQL..."
  local retries=0
  while ! docker exec restaurant-postgres pg_isready -U postgres &>/dev/null; do
    retries=$((retries + 1))
    if [[ $retries -ge 30 ]]; then
      err "PostgreSQL did not become ready in time"
      exit 1
    fi
    sleep 2
  done
  ok "PostgreSQL is ready"

  log "Waiting for Kafka..."
  retries=0
  while ! curl -sf -o /dev/null "http://localhost:9092" 2>/dev/null; do
    retries=$((retries + 1))
    if [[ $retries -ge 60 ]]; then
      err "Kafka did not become ready in time (this may be normal — Kafka uses binary protocol)"
      warn "Continuing anyway..."
      break
    fi
    sleep 1
  done
  ok "Kafka is ready"
}

compile_project() {
  log "Compiling project..."
  if !command -v mvn &>/dev/null; then
    err "Maven (mvn) not found in PATH"
    exit 1
  fi
  (cd "$SCRIPT_DIR" && mvn clean install -DskipTests -q)
  ok "Project compiled successfully"
}

start_eureka() {
  log "Starting Eureka Server..."
  mkdir -p "$LOG_DIR"
  local jar
  jar=$(find "$SCRIPT_DIR/eureka/target" -name "*.jar" ! -name "*-sources.jar" ! -name "*-javadoc.jar" | head -1)
  if [[ -z "$jar" ]]; then
    err "Eureka JAR not found. Did you compile?"
    exit 1
  fi
  java -jar "$jar" > "$LOG_DIR/eureka.log" 2>&1 &
  PIDS+=("$!")
  wait_for_port 8761 "Eureka" 90
  ok "Eureka started (PID: ${PIDS[-1]})"
}

start_microservice() {
  local svc="$1"
  local port="${SERVICE_PORT[$svc]}"
  mkdir -p "$LOG_DIR"
  local jar
  jar=$(find "$SCRIPT_DIR/$svc/target" -name "*.jar" ! -name "*-sources.jar" ! -name "*-javadoc.jar" | head -1)
  if [[ -z "$jar" ]]; then
    err "$svc JAR not found. Did you compile?"
    return 1
  fi
  java -jar "$jar" > "$LOG_DIR/${svc}.log" 2>&1 &
  PIDS+=("$!")
  printf "  %-22s port %-5s PID %-6s" "$svc" "$port" "${PIDS[-1]}"
  wait_for_port "$port" "$svc" 120
}

start_frontend() {
  local frontend_dir="$PROJECT_ROOT/Front-end"
  if [[ ! -d "$frontend_dir" ]]; then
    warn "Front-end directory not found at $frontend_dir"
    return 1
  fi
  log "Starting Frontend..."
  mkdir -p "$LOG_DIR"
  (
    cd "$frontend_dir"
    npm install >> "$LOG_DIR/frontend.log" 2>&1
    npx vite --port 5173 >> "$LOG_DIR/frontend.log" 2>&1 &
    echo $! >> "$SCRIPT_DIR/.frontend.pid"
  )
  sleep 3
  wait_for_port 5173 "Frontend" 30
  ok "Frontend started"
}

cleanup() {
  echo ""
  log "Caught interrupt — shutting down all services..."
  for pid in "${PIDS[@]}"; do
    if kill -0 "$pid" 2>/dev/null; then
      kill "$pid" 2>/dev/null || true
      printf "  Killed PID %s\n" "$pid"
    fi
  done
  local frontend_pidfile="$SCRIPT_DIR/.frontend.pid"
  if [[ -f "$frontend_pidfile" ]]; then
    while IFS= read -r fpid; do
      if kill -0 "$fpid" 2>/dev/null; then
        kill "$fpid" 2>/dev/null || true
        printf "  Killed frontend PID %s\n" "$fpid"
      fi
    done < "$frontend_pidfile"
    rm -f "$frontend_pidfile"
  fi
  ok "All services stopped."
  exit 0
}

display_status() {
  echo ""
  echo -e "${BOLD}╔══════════════════════════════════════════════════╗${NC}"
  echo -e "${BOLD}║        Restaurant Microservices Status           ║${NC}"
  echo -e "${BOLD}╠══════════════════════════════════════════════════╣${NC}"
  printf "${BOLD}║ %-22s %-6s %-10s %-8s ║${NC}\n" "Service" "Port" "PID" "Status"
  echo -e "${BOLD}╠══════════════════════════════════════════════════╣${NC}"

  local idx=0
  for svc in "${SERVICE_ORDER[@]}"; do
    if should_start_service "$svc"; then
      local port="${SERVICE_PORT[$svc]}"
      local pid="${PIDS[$idx]:-N/A}"
      local status
      status=$(check_status "$port")
      printf "║ %-22s %-6s %-10s " "$svc" "$port" "$pid"
      echo -e "$status║"
      idx=$((idx + 1))
    fi
  done

  if ! $SKIP_FRONTEND && should_start_service "frontend"; then
    local fpid="N/A"
    local frontend_pidfile="$SCRIPT_DIR/.frontend.pid"
    if [[ -f "$frontend_pidfile" ]]; then
      fpid=$(tail -1 "$frontend_pidfile")
    fi
    local fstatus
    fstatus=$(check_status 5173)
    printf "║ %-22s %-6s %-10s " "frontend" "5173" "$fpid"
    echo -e "$fstatus║"
  fi

  echo -e "${BOLD}╚══════════════════════════════════════════════════╝${NC}"
  echo ""
  log "Logs directory: ${CYAN}$LOG_DIR/${NC}"
  log "Press Ctrl+C to stop all services"
}

main() {
  trap cleanup SIGINT SIGTERM

  echo -e "${BOLD}"
  echo "  ╔═══════════════════════════════════════╗"
  echo "  ║   Restaurant Microservices Launcher   ║"
  echo "  ╚═══════════════════════════════════════╝"
  echo -e "${NC}"

  parse_args "$@"

  if ! $SKIP_DOCKER; then
    start_docker
  else
    warn "Skipping Docker (--no-docker)"
  fi

  if ! $SKIP_COMPILE; then
    compile_project
  else
    warn "Skipping compilation (--no-compile)"
  fi

  if should_start_service "eureka"; then
    start_eureka
  fi

  local eureka_idx=-1
  for svc in "${SERVICE_ORDER[@]}"; do
    if [[ "$svc" == "eureka" ]]; then
      continue
    fi
    if should_start_service "$svc"; then
      start_microservice "$svc" &
    fi
  done
  wait

  if ! $SKIP_FRONTEND && should_start_service "frontend"; then
    start_frontend
  else
    if $SKIP_FRONTEND; then
      warn "Skipping frontend (--no-frontend)"
    fi
  fi

  display_status

  log "All services launched. Waiting for them to become healthy..."
  echo ""
  tail -f /dev/null
}

main "$@"