import React, { useEffect } from 'react';
import { PageContainer } from '../layouts/PageContainer';
import { Card, CardHeader, CardTitle, CardContent, CardDescription } from '../components/ui/Card';
import { Badge } from '../components/ui/Badge';
import { Button } from '../components/ui/Button';
import { useDevTools } from '../contexts/DevToolsContext';
import { useAuth } from '../contexts/AuthContext';
import {
  Wifi, WifiOff,
  RefreshCw, Activity, Shield, LogOut, Trash2,
} from 'lucide-react';
import { cn } from '../utils/utils';

/**
 * SettingsPage — Panel de configuración del sistema.
 *
 * Permite:
 *  - Activar/desactivar el modo mock (datos simulados)
 *  - Ver el estado de conexión de cada microservicio
 *  - Gestionar la sesión (cerrar sesión, ver roles)
 */
const SettingsPage: React.FC = () => {
  const {
    mockMode, setMockMode,
    serviceHealth, checkServiceHealth,
    apiLogs, clearLogs,
    setPanelVisible,
  } = useDevTools();

  const { user, logout } = useAuth();

  // Check health al montar
  useEffect(() => {
    checkServiceHealth();
  }, []);

  const onlineCount = serviceHealth.filter(s => s.status === 'online').length;

  return (
    <PageContainer>
      <div>
        <h2 className="text-2xl font-bold tracking-tight text-surface-900">Configuración</h2>
        <p className="text-surface-500">Ajustes del sistema y herramientas de desarrollo</p>
      </div>

      <div className="grid gap-6 md:grid-cols-2">
        {/* ─── Modo de Datos ─── */}
        <Card>
          <CardHeader>
            <CardTitle className="flex items-center gap-2">
              <Activity className="w-5 h-5 text-primary-500" />
              Modo de Datos
            </CardTitle>
            <CardDescription>
              Controla si la aplicación usa datos simulados (Mock) o llama a los microservicios reales
            </CardDescription>
          </CardHeader>
          <CardContent className="space-y-4">
            <div className="flex items-center justify-between p-4 rounded-xl border border-surface-200 bg-surface-50">
              <div>
                <p className="text-sm font-medium text-surface-900">
                  {mockMode ? 'Modo Mock (Simulado)' : 'Modo Real (API)'}
                </p>
                <p className="text-xs text-surface-500 mt-0.5">
                  {mockMode
                    ? 'Los datos son locales y simulados. Los errores de conexión se ignoran.'
                    : 'Las operaciones llaman directamente a los microservicios.'
                  }
                </p>
              </div>
              <button
                onClick={() => setMockMode(!mockMode)}
                className={cn(
                  'relative inline-flex h-7 w-12 items-center rounded-full transition-colors',
                  mockMode ? 'bg-orange-500' : 'bg-green-500'
                )}
              >
                <span className={cn(
                  'inline-block h-5 w-5 transform rounded-full bg-white shadow-md transition-transform',
                  mockMode ? 'translate-x-6' : 'translate-x-1'
                )} />
              </button>
            </div>

            <div className="flex items-center gap-2">
              <Badge variant={mockMode ? 'warning' : 'success'}>
                {mockMode ? 'MOCK ACTIVO' : 'API REAL'}
              </Badge>
              <span className="text-xs text-surface-400">
                {mockMode
                  ? 'Busca @MOCK en el código para ver qué datos son simulados'
                  : 'Las llamadas fallidas mostrarán errores reales'
                }
              </span>
            </div>
          </CardContent>
        </Card>

        {/* ─── Estado de Microservicios ─── */}
        <Card>
          <CardHeader>
            <div className="flex items-center justify-between">
              <CardTitle className="flex items-center gap-2">
                <Wifi className="w-5 h-5 text-primary-500" />
                Microservicios
              </CardTitle>
              <Button variant="ghost" size="sm" onClick={checkServiceHealth}>
                <RefreshCw className="w-3.5 h-3.5 mr-1" />
                Verificar
              </Button>
            </div>
            <CardDescription>
              {onlineCount}/{serviceHealth.length} servicios detectados
            </CardDescription>
          </CardHeader>
          <CardContent>
            <div className="space-y-2">
              {serviceHealth.map(service => (
                <div key={service.name} className="flex items-center justify-between py-2 px-3 rounded-lg bg-surface-50 border border-surface-100">
                  <div className="flex items-center gap-2">
                    {service.status === 'online'
                      ? <Wifi className="w-4 h-4 text-green-500" />
                      : service.status === 'checking'
                        ? <RefreshCw className="w-4 h-4 text-yellow-500 animate-spin" />
                        : <WifiOff className="w-4 h-4 text-red-400" />
                    }
                    <div>
                      <p className="text-sm font-medium text-surface-900">{service.name}</p>
                      <p className="text-xs text-surface-400">{service.baseUrl}</p>
                    </div>
                  </div>
                  <Badge variant={
                    service.status === 'online' ? 'success' :
                    service.status === 'checking' ? 'warning' : 'error'
                  }>
                    {service.status === 'online' ? 'Online' :
                     service.status === 'checking' ? 'Verificando...' : 'Offline'}
                  </Badge>
                </div>
              ))}
            </div>
          </CardContent>
        </Card>

        {/* ─── DevTools ─── */}
        <Card>
          <CardHeader>
            <CardTitle className="flex items-center gap-2">
              <Activity className="w-5 h-5 text-primary-500" />
              Panel de Desarrollo
            </CardTitle>
            <CardDescription>
              Herramientas de debugging para monitorear llamadas API
            </CardDescription>
          </CardHeader>
          <CardContent className="space-y-3">
            <div className="flex items-center justify-between">
              <span className="text-sm text-surface-700">Logs registrados</span>
              <Badge variant="default">{apiLogs.length}</Badge>
            </div>
            <div className="flex gap-2">
              <Button variant="outline" size="sm" onClick={() => setPanelVisible(true)}>
                <Activity className="w-3.5 h-3.5 mr-1" />
                Abrir Panel
              </Button>
              <Button variant="ghost" size="sm" onClick={clearLogs}>
                <Trash2 className="w-3.5 h-3.5 mr-1" />
                Limpiar Logs
              </Button>
            </div>
            <p className="text-xs text-surface-400">
              Atajo de teclado: <kbd className="px-1.5 py-0.5 bg-surface-100 rounded text-[10px] font-mono">Ctrl+Shift+D</kbd>
            </p>
          </CardContent>
        </Card>

        {/* ─── Sesión ─── */}
        <Card>
          <CardHeader>
            <CardTitle className="flex items-center gap-2">
              <Shield className="w-5 h-5 text-primary-500" />
              Sesión Actual
            </CardTitle>
          </CardHeader>
          <CardContent className="space-y-4">
            <div className="flex items-center gap-4">
              <div className="h-12 w-12 rounded-full bg-primary-100 flex items-center justify-center text-primary-700 font-bold text-lg">
                {user?.username?.charAt(0).toUpperCase() ?? 'U'}
              </div>
              <div>
                <p className="font-semibold text-surface-900">{user?.username ?? 'Usuario'}</p>
                <div className="flex gap-1 mt-1">
                  {user?.roles.map(role => (
                    <Badge key={role} variant="primary" className="text-[10px]">{role}</Badge>
                  ))}
                </div>
              </div>
            </div>
            <Button variant="destructive" size="sm" onClick={logout} className="w-full">
              <LogOut className="w-3.5 h-3.5 mr-1" />
              Cerrar Sesión
            </Button>
          </CardContent>
        </Card>
      </div>
    </PageContainer>
  );
};

export default SettingsPage;
