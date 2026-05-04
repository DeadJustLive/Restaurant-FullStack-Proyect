import axios from 'axios';

// Base instance configuration
const axiosInstance = axios.create({
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json',
  },
});

// Interceptor for Authentication
axiosInstance.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('token');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);

// ─── Instancias por microservicio (puertos reales del backend) ───

export const apiAuth = axios.create({
  ...axiosInstance.defaults,
  baseURL: import.meta.env.VITE_API_AUTH_URL || 'http://localhost:9001/api/v1/auth',
});

export const apiUsuarios = axios.create({
  ...axiosInstance.defaults,
  baseURL: import.meta.env.VITE_API_USUARIOS_URL || 'http://localhost:9002/api/v1/usuarios',
});

export const apiSucursales = axios.create({
  ...axiosInstance.defaults,
  baseURL: import.meta.env.VITE_API_SUCURSALES_URL || 'http://localhost:9003/api/v1/sucursales',
});

export const apiCategorias = axios.create({
  ...axiosInstance.defaults,
  baseURL: import.meta.env.VITE_API_CATEGORIAS_URL || 'http://localhost:9005/api/v1/categorias',
});

export const apiMenu = axios.create({
  ...axiosInstance.defaults,
  baseURL: import.meta.env.VITE_API_MENU_URL || 'http://localhost:9004/api/v1/menu',
});

export const apiInventario = axios.create({
  ...axiosInstance.defaults,
  baseURL: import.meta.env.VITE_API_INVENTARIO_URL || 'http://localhost:9010/api/v1/inventario',
});

export const apiPedidos = axios.create({
  ...axiosInstance.defaults,
  baseURL: import.meta.env.VITE_API_PEDIDOS_URL || 'http://localhost:9007/api/v1/pedidos',
});

export const apiPagos = axios.create({
  ...axiosInstance.defaults,
  baseURL: import.meta.env.VITE_API_PAGOS_URL || 'http://localhost:9008/api/v1/pagos',
});

export const apiDelivery = axios.create({
  ...axiosInstance.defaults,
  baseURL: import.meta.env.VITE_API_DELIVERY_URL || 'http://localhost:9009/api/v1/delivery',
});

// ─── Hook para inyectar interceptores de logging ─────────────────

import type { ApiLogEntry } from '../contexts/DevToolsContext';
import { generateLogId } from '../contexts/DevToolsContext';

export function setupAxiosInterceptors(addLog: (log: ApiLogEntry) => void) {
  const instances = [
    apiAuth, apiUsuarios, apiSucursales, apiCategorias, 
    apiMenu, apiInventario, apiPedidos, apiPagos, apiDelivery
  ];

  instances.forEach((instance) => {
    instance.interceptors.request.use((config) => {
      const token = localStorage.getItem('token');
      if (token) {
        config.headers.Authorization = `Bearer ${token}`;
      }
      (config as any).__startTime = Date.now();
      (config as any).__logId = generateLogId();
      return config;
    });

    instance.interceptors.response.use(
      (response) => {
        const duration = Date.now() - ((response.config as any).__startTime || Date.now());
        addLog({
          id: (response.config as any).__logId || generateLogId(),
          timestamp: new Date(),
          method: (response.config.method || 'GET').toUpperCase(),
          url: `${response.config.baseURL || ''}${response.config.url || ''}`,
          status: 'success',
          httpCode: response.status,
          duration,
          requestBody: response.config.data ? JSON.parse(response.config.data) : undefined,
          responseData: response.data,
        });
        return response;
      },
      (error) => {
        const config = error.config || {};
        const duration = Date.now() - ((config as any).__startTime || Date.now());

        addLog({
          id: (config as any).__logId || generateLogId(),
          timestamp: new Date(),
          method: (config.method || 'GET').toUpperCase(),
          url: `${config.baseURL || ''}${config.url || ''}`,
          status: 'error',
          httpCode: error.response?.status,
          duration,
          requestBody: config.data ? (() => { try { return JSON.parse(config.data); } catch { return config.data; } })() : undefined,
          errorMessage: error.response?.data?.message || error.message || 'Network Error',
        });

        return Promise.reject(error);
      }
    );
  });
}

export default axiosInstance;
