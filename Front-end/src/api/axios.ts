/**
 * @use(*)
 * @kind(service)
 * @contract(in: InternalAxiosRequestConfig -> out: Promise<AxiosResponse> @error: AxiosError)
 * @limit(lines: 150)
 */

import axios, { AxiosInstance, InternalAxiosRequestConfig } from 'axios';
import type { ApiLogEntry } from '../contexts/DevToolsContext';
import { generateLogId } from '../contexts/DevToolsContext';
import { getMockDataForRequest } from './mockRouter';

export interface CustomRequestConfig extends InternalAxiosRequestConfig {
  __startTime?: number;
  __logId?: string;
  __isMock?: boolean;
  __mockData?: unknown;
}

function createApiClient(baseURL: string): AxiosInstance {
  const instance = axios.create({
    timeout: 10000,
    headers: { 'Content-Type': 'application/json' },
    baseURL,
  });

  instance.interceptors.request.use((config) => {
    const token = localStorage.getItem('token');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    
    const customConfig = config as CustomRequestConfig;
    customConfig.__startTime = Date.now();
    customConfig.__logId = generateLogId();

    // Interceptar si el modo Mock está activo
    const isMock = localStorage.getItem('devtools_mockMode') === 'true';
    if (isMock) {
      customConfig.__isMock = true;
      customConfig.__mockData = getMockDataForRequest(config);
      
      // Cancelamos la petición real lanzando un axios.Cancel
      throw new axios.Cancel(JSON.stringify({
        isMock: true,
        mockData: customConfig.__mockData,
        config: customConfig
      }));
    }

    return config;
  });

  return instance;
}

export const apiAuth = createApiClient(
  import.meta.env.VITE_API_AUTH_URL || 'http://localhost:9001/api/v1/auth'
);

export const apiUsuarios = createApiClient(
  import.meta.env.VITE_API_USUARIOS_URL || 'http://localhost:9001/api/v1/usuarios'
);

export const apiSucursales = createApiClient(
  import.meta.env.VITE_API_SUCURSALES_URL || 'http://localhost:9003/api/v1/sucursales'
);

export const apiCategorias = createApiClient(
  import.meta.env.VITE_API_CATEGORIAS_URL || 'http://localhost:9004/api/v1/categorias'
);

export const apiMenu = createApiClient(
  import.meta.env.VITE_API_MENU_URL || 'http://localhost:9004/api/v1/menu'
);

export const apiInventario = createApiClient(
  import.meta.env.VITE_API_INVENTARIO_URL || 'http://localhost:9010/api/v1/inventario'
);

export const apiPedidos = createApiClient(
  import.meta.env.VITE_API_PEDIDOS_URL || 'http://localhost:9007/api/v1/pedidos'
);

export const apiPagos = createApiClient(
  import.meta.env.VITE_API_PAGOS_URL || 'http://localhost:9008/api/v1/pagos'
);

export const apiDelivery = createApiClient(
  import.meta.env.VITE_API_DELIVERY_URL || 'http://localhost:9009/api/v1/delivery'
);

export const apiCarrito = createApiClient(
  import.meta.env.VITE_API_CARRITO_URL || 'http://localhost:9006/api/v1/carrito'
);

export const apiNotificaciones = createApiClient(
  import.meta.env.VITE_API_NOTIFICACIONES_URL || 'http://localhost:9011/api/v1/notificaciones'
);

export const apiReportes = createApiClient(
  import.meta.env.VITE_API_REPORTES_URL || 'http://localhost:9012/api/v1/reportes'
);

export function setupAxiosInterceptors(addLog: (log: ApiLogEntry) => void): void {
  const instances = [
    apiAuth, apiUsuarios, apiSucursales, apiCategorias,
    apiMenu, apiInventario, apiPedidos, apiPagos, apiDelivery,
    apiCarrito, apiNotificaciones, apiReportes
  ];

  instances.forEach((instance) => {
    instance.interceptors.response.use(
      (response) => {
        const customConfig = response.config as CustomRequestConfig;
        const duration = Date.now() - (customConfig.__startTime || Date.now());
        
        addLog({
          id: customConfig.__logId || generateLogId(),
          timestamp: new Date(),
          method: (customConfig.method || 'GET').toUpperCase(),
          url: `${customConfig.baseURL || ''}${customConfig.url || ''}`,
          status: 'success',
          httpCode: response.status,
          duration,
          requestBody: customConfig.data ? (() => { try { return JSON.parse(customConfig.data); } catch { return customConfig.data; } })() : undefined,
          responseData: response.data,
        });
        return response;
      },
      (error) => {
        // 1. Manejo del Mock Interceptado
        if (axios.isCancel(error) && error.message) {
          try {
            const cancelData = JSON.parse(error.message);
            if (cancelData.isMock) {
              const cfg = cancelData.config as CustomRequestConfig;
              const duration = Date.now() - (cfg.__startTime || Date.now());

              addLog({
                id: cfg.__logId || generateLogId(),
                timestamp: new Date(),
                method: (cfg.method || 'GET').toUpperCase(),
                url: `${cfg.baseURL || ''}${cfg.url || ''}`,
                status: 'mock-fallback',
                httpCode: 200,
                duration,
                requestBody: cfg.data ? (() => { try { return JSON.parse(cfg.data); } catch { return cfg.data; } })() : undefined,
                responseData: cancelData.mockData,
              });

              // Retorna la respuesta Mock como exitosa para el cliente
              return Promise.resolve({
                data: cancelData.mockData,
                status: 200,
                statusText: 'OK',
                headers: {},
                config: cfg,
              });
            }
          } catch {
            // Error al parsear JSON, sigue el flujo de error
          }
        }

        // 2. Manejo de errores reales
        const config = (error.config || {}) as CustomRequestConfig;
        const duration = Date.now() - (config.__startTime || Date.now());
        const httpStatus = error.response?.status;

        if (httpStatus === 401) {
          const isLoginRequest = config.url?.includes('/login') || 
                                 config.url?.includes('/register');
          if (!isLoginRequest) {
            localStorage.removeItem('token');
            localStorage.removeItem('user');
            window.dispatchEvent(new CustomEvent('auth-401-unauthorized'));
            window.location.href = '/login';
          }
        }

        if (httpStatus === 403) {
          const detailMsg = error.response?.data?.mensaje || 'Acceso Denegado: No tienes permisos vigentes para este módulo.';
          window.dispatchEvent(new CustomEvent('auth-403-forbidden', { detail: detailMsg }));
        }

        addLog({
          id: config.__logId || generateLogId(),
          timestamp: new Date(),
          method: (config.method || 'GET').toUpperCase(),
          url: `${config.baseURL || ''}${config.url || ''}`,
          status: 'error',
          httpCode: httpStatus,
          duration,
          requestBody: config.data ? (() => { try { return JSON.parse(config.data); } catch { return config.data; } })() : undefined,
          errorMessage: error.response?.data?.mensaje || error.response?.data?.message || error.message || 'Network Error',
        });

        return Promise.reject(error);
      }
    );
  });
}

export default apiAuth;