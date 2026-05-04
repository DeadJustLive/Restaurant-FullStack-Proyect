import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import { Role } from '../config/navigation';

interface ProtectedRouteProps {
  allowedRoles: Role[];
}

/**
 * Componente Wrapper para rutas protegidas.
 * Verifica si el usuario está autenticado y tiene el rol necesario.
 * Si no, redirige al login o a una vista de acceso denegado.
 */
export const ProtectedRoute: React.FC<ProtectedRouteProps> = ({ allowedRoles }) => {
  // TODO: Reemplazar por el hook real `useAuth()`
  // const { isAuthenticated, userRoles } = useAuth();
  
  // Mock para propósitos de demostración:
  const isAuthenticated = true;
  const userRoles: Role[] = ['ROLE_AD']; // Simulamos un usuario Admin

  if (!isAuthenticated) {
    return <Navigate to="/login" replace />;
  }

  // Verificamos si al menos uno de los roles del usuario está en la lista de permitidos
  const hasAccess = allowedRoles.some(role => userRoles.includes(role));

  if (!hasAccess) {
    // Si está autenticado pero no tiene permisos
    return <Navigate to="/unauthorized" replace />;
  }

  // Renderiza los componentes hijos (Rutas anidadas)
  return <Outlet />;
};
