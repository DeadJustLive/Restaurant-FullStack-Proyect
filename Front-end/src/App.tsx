/**
 * @use(*)
 * @kind(component)
 * @props({})
 * @limit(lines: 120)
 */

import React, { useEffect, useState } from 'react';
import { AuthProvider } from './contexts/AuthContext';
import { DevToolsProvider, useDevTools } from './contexts/DevToolsContext';
import { setupAxiosInterceptors } from './api/axios';
import { DevPanel } from './components/features/DevPanel';
import { AppRouter } from './routes/AppRouter';
import { ShieldAlert, X } from 'lucide-react';
import { Button } from './components/ui/Button';

export function AxiosSetup({ children }: { children: React.ReactNode }): JSX.Element {
  const { addLog } = useDevTools();
  const [forbiddenError, setForbiddenError] = useState<string | null>(null);

  useEffect(() => {
    setupAxiosInterceptors(addLog);

    const handleForbidden = (e: Event) => {
      const customEvent = e as CustomEvent<string>;
      setForbiddenError(customEvent.detail);
    };

    window.addEventListener('auth-403-forbidden', handleForbidden);
    return () => {
      window.removeEventListener('auth-403-forbidden', handleForbidden);
    };
  }, [addLog]);

  return (
    <>
      {children}

      {/* Modal de Acceso Denegado (Zero-Trust HTTP 403 / ERR_AUTH_003) */}
      {forbiddenError && (
        <div className="fixed inset-0 z-[200] flex items-center justify-center p-4 bg-black/60 backdrop-blur-sm animate-fade-in">
          <div className="relative w-full max-w-md bg-surface-900 border border-red-500/30 text-white rounded-2xl p-6 shadow-2xl animate-zoom-in">
            {/* Botón de cierre superior */}
            <button
              onClick={() => setForbiddenError(null)}
              className="absolute top-4 right-4 text-surface-400 hover:text-white p-1 rounded-lg hover:bg-surface-800 transition-colors"
            >
              <X className="w-5 h-5" />
            </button>

            {/* Contenido */}
            <div className="text-center">
              <div className="mx-auto flex h-14 w-14 items-center justify-center rounded-full bg-red-500/10 text-red-500 mb-4 animate-bounce">
                <ShieldAlert className="w-8 h-8" />
              </div>
              
              <h3 className="text-lg font-bold text-red-400 mb-2">
                Acceso Denegado
              </h3>
              
              <p className="text-sm text-surface-300 mb-6 leading-relaxed">
                {forbiddenError}
              </p>

              <Button
                variant="destructive"
                className="w-full bg-red-600 hover:bg-red-700 text-white font-medium py-2 rounded-xl transition-all"
                onClick={() => setForbiddenError(null)}
              >
                Entendido
              </Button>
            </div>
          </div>
        </div>
      )}
    </>
  );
}

export function App(): JSX.Element {
  return (
    <DevToolsProvider>
      <AuthProvider>
        <AxiosSetup>
          <AppRouter />
          <DevPanel />
        </AxiosSetup>
      </AuthProvider>
    </DevToolsProvider>
  );
}

