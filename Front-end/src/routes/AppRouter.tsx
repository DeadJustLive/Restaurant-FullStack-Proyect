import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { AppShell } from '../layouts/AppShell';
import { AuthLayout } from '../layouts/AuthLayout';
import { useAuth } from '../contexts/AuthContext';

// Páginas existentes
import LoginPage from '../pages/LoginPage';
import DashboardPage from '../pages/DashboardPage';
import ProfilePage from '../pages/ProfilePage';
import SettingsPage from '../pages/SettingsPage';
import CocinaPage from '../pages/CocinaPage';
import WaiterDashboard from '../pages/WaiterDashboard';
import EntregasPage from '../pages/EntregasPage';

// Nuevas Páginas Administrativas
import UsersPage from '../pages/admin/UsersPage';
// Placeholder para futuras implementaciones reales (comparten estructura CRUD)
const PlaceholderPage = ({ title }: { title: string }) => (
  <div className="p-8">
    <h1 className="text-2xl font-bold">{title}</h1>
    <p className="text-surface-500 mt-2">Módulo en proceso de conexión con microservicio real...</p>
  </div>
);

// Componente para proteger rutas según roles
interface ProtectedRouteProps {
  children: React.ReactNode;
  roles?: string[];
}

const ProtectedRoute: React.FC<ProtectedRouteProps> = ({ 
  children, 
  roles 
}) => {
  const { isAuthenticated, user } = useAuth();

  if (!isAuthenticated) return <Navigate to="/login" replace />;
  
  if (roles && !roles.some(role => user?.roles.includes(role))) {
    return <Navigate to="/dashboard" replace />;
  }

  return <>{children}</>;
};

const AppRouter: React.FC = () => {
  return (
    <Router>
      <Routes>
        {/* ─── Rutas Públicas ─── */}
        <Route element={<AuthLayout />}>
          <Route path="/login" element={<LoginPage />} />
        </Route>

        {/* ─── Rutas Privadas ─── */}
        <Route element={<ProtectedRoute><AppShell /></ProtectedRoute>}>
          <Route path="/dashboard" element={<DashboardPage />} />
          <Route path="/profile" element={<ProfilePage />} />
          <Route path="/settings" element={<SettingsPage />} />

          {/* ─── GESTIÓN ADMINISTRATIVA ─── */}
          <Route
            path="/admin/usuarios"
            element={
              <ProtectedRoute roles={['ROLE_SA', 'ROLE_AD']}>
                <UsersPage />
              </ProtectedRoute>
            }
          />
          <Route
            path="/admin/sucursales"
            element={
              <ProtectedRoute roles={['ROLE_SA', 'ROLE_AD']}>
                <PlaceholderPage title="Gestión de Sucursales" />
              </ProtectedRoute>
            }
          />
          <Route
            path="/admin/categorias"
            element={
              <ProtectedRoute roles={['ROLE_SA', 'ROLE_AD']}>
                <PlaceholderPage title="Gestión de Categorías" />
              </ProtectedRoute>
            }
          />
          <Route
            path="/admin/inventario"
            element={
              <ProtectedRoute roles={['ROLE_SA', 'ROLE_AD', 'ROLE_CO']}>
                <PlaceholderPage title="Gestión de Inventario" />
              </ProtectedRoute>
            }
          />

          {/* ─── VISTAS OPERATIVAS ─── */}
          <Route
            path="/cocina"
            element={
              <ProtectedRoute roles={['ROLE_CO', 'ROLE_AD', 'ROLE_SA']}>
                <CocinaPage />
              </ProtectedRoute>
            }
          />
          <Route 
            path="/mesas" 
            element={
              <ProtectedRoute roles={['ROLE_ME', 'ROLE_AD', 'ROLE_SA']}>
                <WaiterDashboard />
              </ProtectedRoute>
            } 
          />
          <Route
            path="/delivery"
            element={
              <ProtectedRoute roles={['ROLE_RP', 'ROLE_AD', 'ROLE_SA']}>
                <EntregasPage />
              </ProtectedRoute>
            }
          />

          <Route path="/" element={<Navigate to="/dashboard" replace />} />
        </Route>

        {/* ─── Fallback ─── */}
        <Route path="*" element={<Navigate to="/dashboard" replace />} />
      </Routes>
    </Router>
  );
};

export default AppRouter;
