import React, { useState, useEffect } from 'react';
import { useDevTools, type ApiLogEntry } from '../../contexts/DevToolsContext';

import { Badge } from '../ui/Badge';
import {
  Activity, X, Trash2, ChevronDown, ChevronUp,
  Wifi, WifiOff, RefreshCw, ToggleLeft, ToggleRight,
} from 'lucide-react';
import { cn } from '../../utils/utils';



const METHOD_COLOR: Record<string, string> = {
  GET: 'bg-blue-100 text-blue-700',
  POST: 'bg-green-100 text-green-700',
  PATCH: 'bg-yellow-100 text-yellow-700',
  PUT: 'bg-purple-100 text-purple-700',
  DELETE: 'bg-red-100 text-red-700',
};

/**
 * DevPanel — Panel flotante de monitoreo de conexiones API.
 *
 * Muestra en tiempo real:
 *  - Todas las llamadas HTTP (método, URL, status, duración)
 *  - Estado de salud de cada microservicio
 *  - Toggle de modo mock
 *
 * Se activa/desactiva con el botón de Activity en la navbar o con Ctrl+Shift+D.
 */
export const DevPanel: React.FC = () => {
  const {
    panelVisible, setPanelVisible,
    mockMode, setMockMode,
    apiLogs, clearLogs,
    serviceHealth, checkServiceHealth,
  } = useDevTools();

  const [activeTab, setActiveTab] = useState<'logs' | 'health'>('logs');
  const [expandedLog, setExpandedLog] = useState<string | null>(null);
  const [minimized, setMinimized] = useState(false);

  // Hotkey: Ctrl+Shift+D
  useEffect(() => {
    const handler = (e: KeyboardEvent) => {
      if (e.ctrlKey && e.shiftKey && e.key === 'D') {
        e.preventDefault();
        setPanelVisible(!panelVisible);
      }
    };
    window.addEventListener('keydown', handler);
    return () => window.removeEventListener('keydown', handler);
  }, [panelVisible, setPanelVisible]);

  // Health check al abrir el tab
  useEffect(() => {
    if (panelVisible && activeTab === 'health') {
      checkServiceHealth();
    }
  }, [panelVisible, activeTab]);

  if (!panelVisible) return null;

  const successCount = apiLogs.filter(l => l.status === 'success').length;
  const errorCount = apiLogs.filter(l => l.status === 'error').length;
  const onlineServices = serviceHealth.filter(s => s.status === 'online').length;

  return (
    <div className={cn(
      'fixed bottom-4 right-4 z-[60] w-[420px] bg-surface-900 text-white rounded-2xl shadow-2xl border border-surface-700 overflow-hidden transition-all duration-300',
      minimized ? 'h-12' : 'max-h-[70vh]'
    )}>
      {/* Header */}
      <div
        className="flex items-center justify-between px-4 py-2.5 bg-surface-800 cursor-pointer select-none"
        onClick={() => setMinimized(!minimized)}
      >
        <div className="flex items-center gap-2">
          <Activity className="w-4 h-4 text-primary-400" />
          <span className="text-sm font-semibold">DevTools</span>
          <span className="text-xs text-surface-400">
            {successCount}✓ {errorCount}✗
          </span>
          {mockMode && (
            <Badge variant="warning" className="text-[10px] px-1.5 py-0">MOCK</Badge>
          )}
        </div>
        <div className="flex items-center gap-1">
          {minimized ? <ChevronUp className="w-4 h-4" /> : <ChevronDown className="w-4 h-4" />}
          <button
            onClick={(e) => { e.stopPropagation(); setPanelVisible(false); }}
            className="p-1 rounded hover:bg-surface-700 transition-colors"
          >
            <X className="w-3.5 h-3.5" />
          </button>
        </div>
      </div>

      {!minimized && (
        <>
          {/* Mock Mode Toggle */}
          <div className="px-4 py-2 border-b border-surface-700 flex items-center justify-between">
            <span className="text-xs text-surface-400">Modo Mock (datos simulados)</span>
            <button
              onClick={() => setMockMode(!mockMode)}
              className={cn(
                'flex items-center gap-1 px-2 py-1 rounded-lg text-xs font-medium transition-all',
                mockMode
                  ? 'bg-orange-500/20 text-orange-400'
                  : 'bg-green-500/20 text-green-400'
              )}
            >
              {mockMode ? <ToggleRight className="w-4 h-4" /> : <ToggleLeft className="w-4 h-4" />}
              {mockMode ? 'Activado' : 'Desactivado'}
            </button>
          </div>

          {/* Tabs */}
          <div className="flex border-b border-surface-700">
            <button
              onClick={() => setActiveTab('logs')}
              className={cn(
                'flex-1 px-4 py-2 text-xs font-medium transition-colors',
                activeTab === 'logs' ? 'text-white border-b-2 border-primary-500' : 'text-surface-400 hover:text-surface-200'
              )}
            >
              Logs API ({apiLogs.length})
            </button>
            <button
              onClick={() => setActiveTab('health')}
              className={cn(
                'flex-1 px-4 py-2 text-xs font-medium transition-colors',
                activeTab === 'health' ? 'text-white border-b-2 border-primary-500' : 'text-surface-400 hover:text-surface-200'
              )}
            >
              Servicios ({onlineServices}/{serviceHealth.length})
            </button>
          </div>

          {/* Content */}
          <div className="overflow-y-auto max-h-[50vh]">
            {activeTab === 'logs' ? (
              <div>
                {/* Log actions */}
                {apiLogs.length > 0 && (
                  <div className="px-4 py-2 border-b border-surface-800">
                    <button onClick={clearLogs} className="flex items-center gap-1 text-xs text-surface-400 hover:text-red-400 transition-colors">
                      <Trash2 className="w-3 h-3" />
                      Limpiar
                    </button>
                  </div>
                )}

                {apiLogs.length === 0 ? (
                  <div className="px-4 py-8 text-center text-surface-500">
                    <Activity className="w-8 h-8 mx-auto mb-2 opacity-50" />
                    <p className="text-xs">No hay llamadas registradas aún</p>
                    <p className="text-[10px] text-surface-600 mt-1">Las llamadas a la API aparecerán aquí</p>
                  </div>
                ) : (
                  apiLogs.map((log) => (
                    <LogEntry
                      key={log.id}
                      log={log}
                      expanded={expandedLog === log.id}
                      onToggle={() => setExpandedLog(expandedLog === log.id ? null : log.id)}
                    />
                  ))
                )}
              </div>
            ) : (
              <div className="p-4 space-y-2">
                <div className="flex justify-between items-center mb-3">
                  <span className="text-xs text-surface-400">Estado de microservicios</span>
                  <button
                    onClick={checkServiceHealth}
                    className="flex items-center gap-1 text-xs text-surface-400 hover:text-primary-400 transition-colors"
                  >
                    <RefreshCw className="w-3 h-3" />
                    Verificar
                  </button>
                </div>
                {serviceHealth.map((service) => (
                  <div key={service.name} className="flex items-center justify-between py-2 px-3 rounded-lg bg-surface-800">
                    <div className="flex items-center gap-2">
                      {service.status === 'online'
                        ? <Wifi className="w-3.5 h-3.5 text-green-400" />
                        : service.status === 'checking'
                          ? <RefreshCw className="w-3.5 h-3.5 text-yellow-400 animate-spin" />
                          : <WifiOff className="w-3.5 h-3.5 text-red-400" />
                      }
                      <div>
                        <p className="text-xs font-medium">{service.name}</p>
                        <p className="text-[10px] text-surface-500">{service.baseUrl}</p>
                      </div>
                    </div>
                    <Badge variant={
                      service.status === 'online' ? 'success' :
                      service.status === 'checking' ? 'warning' : 'error'
                    } className="text-[10px]">
                      {service.status === 'online' ? 'Online' :
                       service.status === 'checking' ? '...' : 'Offline'}
                    </Badge>
                  </div>
                ))}
              </div>
            )}
          </div>
        </>
      )}
    </div>
  );
};

// ─── Sub-componente: Entrada de log individual ───────────────────

const LogEntry: React.FC<{
  log: ApiLogEntry;
  expanded: boolean;
  onToggle: () => void;
}> = ({ log, expanded, onToggle }) => {
  const time = log.timestamp.toLocaleTimeString('es-CL', { hour: '2-digit', minute: '2-digit', second: '2-digit' });

  return (
    <div className="border-b border-surface-800 last:border-0">
      <button
        onClick={onToggle}
        className="w-full px-4 py-2 flex items-center gap-2 text-left hover:bg-surface-800/50 transition-colors"
      >
        {/* Status dot */}
        <div className={cn('w-2 h-2 rounded-full shrink-0', {
          'bg-green-500': log.status === 'success',
          'bg-red-500': log.status === 'error',
          'bg-yellow-500': log.status === 'pending',
          'bg-orange-400': log.status === 'mock-fallback',
        })} />

        {/* Method badge */}
        <span className={cn('text-[10px] font-bold px-1.5 py-0.5 rounded', METHOD_COLOR[log.method] || 'bg-surface-700 text-surface-300')}>
          {log.method}
        </span>

        {/* URL (truncated) */}
        <span className="text-xs text-surface-300 truncate flex-1 font-mono">
          {log.url.replace(/https?:\/\/localhost:\d+/, '')}
        </span>

        {/* Status code */}
        {log.httpCode && (
          <span className={cn('text-[10px] font-mono font-bold', log.httpCode < 400 ? 'text-green-400' : 'text-red-400')}>
            {log.httpCode}
          </span>
        )}

        {/* Duration */}
        {log.duration !== undefined && (
          <span className="text-[10px] text-surface-500">{log.duration}ms</span>
        )}

        {/* Time */}
        <span className="text-[10px] text-surface-600">{time}</span>
      </button>

      {/* Expanded details */}
      {expanded && (
        <div className="px-4 pb-3 space-y-2">
          {log.errorMessage && (
            <div className="text-xs text-red-400 bg-red-500/10 px-3 py-2 rounded-lg font-mono">
              ✗ {log.errorMessage}
            </div>
          )}
          {log.requestBody && (
            <div>
              <p className="text-[10px] text-surface-500 mb-1">Request Body:</p>
              <pre className="text-[10px] text-surface-300 bg-surface-800 p-2 rounded-lg overflow-x-auto font-mono">
                {JSON.stringify(log.requestBody, null, 2)}
              </pre>
            </div>
          )}
          {log.responseData && (
            <div>
              <p className="text-[10px] text-surface-500 mb-1">Response:</p>
              <pre className="text-[10px] text-surface-300 bg-surface-800 p-2 rounded-lg overflow-x-auto font-mono max-h-32">
                {JSON.stringify(log.responseData, null, 2).slice(0, 500)}
              </pre>
            </div>
          )}
        </div>
      )}
    </div>
  );
};
