import React, { createContext, useContext, useState, useCallback, useRef } from 'react';

// ─── Tipos ───────────────────────────────────────────────────────

export type ApiLogStatus = 'pending' | 'success' | 'error' | 'mock-fallback';

export interface ApiLogEntry {
  id: string;
  timestamp: Date;
  method: string;
  url: string;
  status: ApiLogStatus;
  httpCode?: number;
  duration?: number;
  requestBody?: any;
  responseData?: any;
  errorMessage?: string;
}

export interface ServiceHealth {
  name: string;
  baseUrl: string;
  status: 'online' | 'offline' | 'checking';
  lastCheck?: Date;
}

interface DevToolsContextType {
  /** Si es true, los componentes usan datos @MOCK en lugar de llamar a la API */
  mockMode: boolean;
  setMockMode: (value: boolean) => void;

  /** Si es true, se muestra el panel flotante de logs */
  panelVisible: boolean;
  setPanelVisible: (value: boolean) => void;

  /** Historial de llamadas a la API */
  apiLogs: ApiLogEntry[];
  addLog: (log: ApiLogEntry) => void;
  clearLogs: () => void;

  /** Estado de salud de cada microservicio */
  serviceHealth: ServiceHealth[];
  checkServiceHealth: () => Promise<void>;
}

const DevToolsContext = createContext<DevToolsContextType | undefined>(undefined);

// ─── Microservicios a monitorear ─────────────────────────────────

const SERVICES_CONFIG: Omit<ServiceHealth, 'status'>[] = [
  { name: 'ms-auth',           baseUrl: import.meta.env.VITE_API_AUTH_URL || 'http://localhost:9001' },
  { name: 'ms-menu',           baseUrl: import.meta.env.VITE_API_MENU_URL || 'http://localhost:9004' },
  { name: 'ms-pedidos',        baseUrl: import.meta.env.VITE_API_PEDIDOS_URL || 'http://localhost:9007' },
  { name: 'ms-pagos',          baseUrl: import.meta.env.VITE_API_PAGOS_URL || 'http://localhost:9008' },
  { name: 'ms-delivery',       baseUrl: import.meta.env.VITE_API_DELIVERY_URL || 'http://localhost:9009' },
  { name: 'ms-inventario',     baseUrl: import.meta.env.VITE_API_INVENTARIO_URL || 'http://localhost:9010' },
];

// ─── Provider ────────────────────────────────────────────────────

export const DevToolsProvider: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  const [mockMode, setMockModeState] = useState<boolean>(() => {
    const saved = localStorage.getItem('devtools_mockMode');
    return saved !== null ? JSON.parse(saved) : true; // Mock activado por defecto
  });

  const [panelVisible, setPanelVisible] = useState(false);
  const [apiLogs, setApiLogs] = useState<ApiLogEntry[]>([]);
  const [serviceHealth, setServiceHealth] = useState<ServiceHealth[]>(
    SERVICES_CONFIG.map(s => ({ ...s, status: 'offline' as const }))
  );

  const logCounter = useRef(0);



  const setMockMode = useCallback((value: boolean) => {
    setMockModeState(value);
    localStorage.setItem('devtools_mockMode', JSON.stringify(value));
  }, []);

  const addLog = useCallback((log: ApiLogEntry) => {
    setApiLogs(prev => [log, ...prev].slice(0, 100)); // Máximo 100 logs
  }, []);

  const clearLogs = useCallback(() => {
    setApiLogs([]);
  }, []);

  const checkServiceHealth = useCallback(async () => {
    setServiceHealth(prev => prev.map(s => ({ ...s, status: 'checking' as const })));

    const results = await Promise.all(
      SERVICES_CONFIG.map(async (service) => {
        return new Promise<ServiceHealth>((resolve) => {
          const xhr = new XMLHttpRequest();
          const timer = setTimeout(() => {
            xhr.abort();
            resolve({ ...service, status: 'offline' as const, lastCheck: new Date() });
          }, 3000);

          xhr.open('GET', `${service.baseUrl}/actuator/health`, true);
          xhr.onload = () => {
            clearTimeout(timer);
            // 200 = healthy, 503 = unhealthy but reachable, any response = service exists
            resolve({ ...service, status: xhr.status < 500 ? 'online' as const : 'online' as const, lastCheck: new Date() });
          };
          xhr.onerror = () => {
            clearTimeout(timer);
            resolve({ ...service, status: 'offline' as const, lastCheck: new Date() });
          };
          try {
            xhr.send();
          } catch {
            clearTimeout(timer);
            resolve({ ...service, status: 'offline' as const, lastCheck: new Date() });
          }
        });
      })
    );

    setServiceHealth(results);
  }, []);

  return (
    <DevToolsContext.Provider value={{
      mockMode, setMockMode,
      panelVisible, setPanelVisible,
      apiLogs, addLog, clearLogs,
      serviceHealth, checkServiceHealth,
    }}>
      {children}
    </DevToolsContext.Provider>
  );
};

// ─── Hook ────────────────────────────────────────────────────────

export const useDevTools = () => {
  const context = useContext(DevToolsContext);
  if (!context) {
    throw new Error('useDevTools must be used within a DevToolsProvider');
  }
  return context;
};

/**
 * Genera un ID único para los logs usando un counter global.
 */
let _logIdCounter = 0;
export const generateLogId = (): string => {
  _logIdCounter++;
  return `log-${_logIdCounter}-${Date.now()}`;
};
