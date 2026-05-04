import React, { useEffect } from 'react';
import { AuthProvider } from './contexts/AuthContext';
import { DevToolsProvider, useDevTools } from './contexts/DevToolsContext';
import { setupAxiosInterceptors } from './api/axios';
import { DevPanel } from './components/features/DevPanel';
import AppRouter from './routes/AppRouter';

/**
 * Componente interno que configura los interceptores de Axios
 * una vez que el DevToolsContext está disponible.
 */
const AxiosSetup: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  const { addLog } = useDevTools();

  useEffect(() => {
    setupAxiosInterceptors(addLog);
  }, []); // Solo una vez al montar

  return <>{children}</>;
};

const App: React.FC = () => {
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
};

export default App;
