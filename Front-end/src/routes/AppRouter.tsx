import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { useAuth } from '../contexts/AuthContext';

// Layouts
import MainLayout from '../layouts/MainLayout';
import AuthLayout from '../layouts/AuthLayout';

// Pages
import LoginPage from '../pages/LoginPage';
import DashboardPage from '../pages/DashboardPage';
import ProjectsPage from '../pages/ProjectsPage';
import BacklogPage from '../pages/BacklogPage';
import ProfilePage from '../pages/ProfilePage';
import WaiterDashboard from '../pages/WaiterDashboard';

const ProtectedRoute: React.FC<{ children: React.ReactNode; roles?: string[] }> = ({ 
  children, 
  roles 
}) => {
  const { isAuthenticated, user } = useAuth();

  if (!isAuthenticated) return <Navigate to="/login" />;
  
  if (roles && !roles.some(role => user?.roles.includes(role))) {
    return <Navigate to="/dashboard" />;
  }

  return <>{children}</>;
};

const AppRouter: React.FC = () => {
  return (
    <Router>
      <Routes>
        {/* Rutas Públicas */}
        <Route element={<AuthLayout />}>
          <Route path="/login" element={<LoginPage />} />
        </Route>

        {/* Rutas Privadas */}
        <Route element={<ProtectedRoute><MainLayout /></ProtectedRoute>}>
          <Route path="/dashboard" element={<DashboardPage />} />
          <Route path="/projects" element={<ProjectsPage />} />
          <Route path="/backlog" element={<BacklogPage />} />
          <Route path="/profile" element={<ProfilePage />} />
          
          {/* Ruta de Mesero */}
          <Route 
            path="/waiter" 
            element={
              <ProtectedRoute roles={['ROLE_ME', 'ROLE_AD', 'ROLE_SA']}>
                <WaiterDashboard />
              </ProtectedRoute>
            } 
          />

          <Route path="/" element={<Navigate to="/dashboard" />} />
        </Route>

        {/* 404 Not Found */}
        <Route path="*" element={<Navigate to="/dashboard" />} />
      </Routes>
    </Router>
  );
};

export default AppRouter;
