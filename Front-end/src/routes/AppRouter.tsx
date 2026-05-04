import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { useAuth } from '../contexts/AuthContext';
import type { Role } from '../config/navigation';

// Layouts
import { AppShell } from '../layouts/AppShell';
import AuthLayout from '../layouts/AuthLayout';

// Pages
import LoginPage from '../pages/LoginPage';
import DashboardPage from '../pages/DashboardPage';
import ProfilePage from '../pages/ProfilePage';
import WaiterDashboard from '../pages/WaiterDashboard';
import CocinaPage from '../pages/CocinaPage';
import EntregasPage from '../pages/EntregasPage';
import SettingsPage from '../pages/SettingsPage';

/**
 * ProtectedRoute — Wrapper de autenticación y autorización.
 */
const ProtectedRoute: React.FC<{ children: React.ReactNode; roles?: Role[] }> = ({ 
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

        {/* ─── Rutas Privadas (AppShell con Floating Navbar) ─── */}
        <Route element={<ProtectedRoute><AppShell /></ProtectedRoute>}>
          <Route path="/dashboard" element={<DashboardPage />} />
          <Route path="/profile" element={<ProfilePage />} />
          <Route path="/settings" element={<SettingsPage />} />

          {/* Cocina (KDS) — CO, AD, SA */}
          <Route
            path="/cocina"
            element={
              <ProtectedRoute roles={['ROLE_CO', 'ROLE_AD', 'ROLE_SA']}>
                <CocinaPage />
              </ProtectedRoute>
            }
          />

          {/* Mesas y Pedidos — ME, AD, SA */}
          <Route 
            path="/mesas" 
            element={
              <ProtectedRoute roles={['ROLE_ME', 'ROLE_AD', 'ROLE_SA']}>
                <WaiterDashboard />
              </ProtectedRoute>
            } 
          />

          {/* Entregas (Delivery) — RP, AD, SA */}
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

        {/* ─── 404 Fallback ─── */}
        <Route path="*" element={<Navigate to="/dashboard" replace />} />
      </Routes>
    </Router>
  );
};

export default AppRouter;
