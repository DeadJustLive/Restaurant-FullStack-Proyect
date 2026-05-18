import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { AppShell } from '../layouts/AppShell';
import { AuthLayout } from '../layouts/AuthLayout';
import { useAuth } from '../contexts/AuthContext';

// Páginas existentes
import LoginPage from '../pages/LoginPage';
import { DashboardPage } from '../pages/DashboardPage';
import ProfilePage from '../pages/ProfilePage';
import SettingsPage from '../pages/SettingsPage';
import CocinaPage from '../pages/CocinaPage';
import WaiterDashboard from '../pages/WaiterDashboard';
import EntregasPage from '../pages/EntregasPage';

// Nuevas Páginas Administrativas
import UsersPage from '../pages/admin/UsersPage';
import SucursalesPage from '../pages/admin/SucursalesPage';
import CategoriasPage from '../pages/admin/CategoriasPage';
import MenuPage from '../pages/admin/MenuPage';
import InventarioPage from '../pages/admin/InventarioPage';
import PagosPage from '../pages/admin/PagosPage';

import CarritoPage from '../pages/admin/CarritoPage';
import NotificacionesPage from '../pages/NotificacionesPage';
import ReportesPage from '../pages/admin/ReportesPage';


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

export const AppRouter: React.FC = () => {
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
                <SucursalesPage />
              </ProtectedRoute>
            }
          />
          <Route
            path="/admin/categorias"
            element={
              <ProtectedRoute roles={['ROLE_SA', 'ROLE_AD']}>
                <CategoriasPage />
              </ProtectedRoute>
            }
          />
          <Route
            path="/admin/menu"
            element={
              <ProtectedRoute roles={['ROLE_SA', 'ROLE_AD']}>
                <MenuPage />
              </ProtectedRoute>
            }
          />
          <Route
            path="/admin/inventario"
            element={
              <ProtectedRoute roles={['ROLE_SA', 'ROLE_AD', 'ROLE_CO']}>
                <InventarioPage />
              </ProtectedRoute>
            }
          />
          <Route
            path="/admin/pagos"
            element={
              <ProtectedRoute roles={['ROLE_SA', 'ROLE_AD']}>
                <PagosPage />
              </ProtectedRoute>
            }
          />

          <Route
            path="/carrito"
            element={
              <ProtectedRoute roles={['ROLE_CL', 'ROLE_ME', 'ROLE_AD', 'ROLE_SA']}>
                <CarritoPage />
              </ProtectedRoute>
            }
          />
          <Route
            path="/notificaciones"
            element={
              <ProtectedRoute roles={['ROLE_SA', 'ROLE_AD', 'ROLE_CO', 'ROLE_ME', 'ROLE_RP', 'ROLE_CL']}>
                <NotificacionesPage />
              </ProtectedRoute>
            }
          />
          <Route
            path="/admin/reportes"
            element={
              <ProtectedRoute roles={['ROLE_SA', 'ROLE_AD']}>
                <ReportesPage />
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

