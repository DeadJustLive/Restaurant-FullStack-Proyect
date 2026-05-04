import React from 'react';
import { Outlet } from 'react-router-dom';

/**
 * AuthLayout — Layout minimalista para las vistas de autenticación (Login, Register).
 * No incluye Sidebar ni Header. Centra el formulario vertical y horizontalmente.
 */
const AuthLayout: React.FC = () => {
  return (
    <div className="min-h-screen bg-gradient-to-br from-surface-900 via-surface-800 to-primary-900 flex items-center justify-center p-4">
      <div className="w-full max-w-md space-y-8">
        {/* Logo / Branding */}
        <div className="text-center">
          <h1 className="text-3xl font-bold text-white tracking-tight">
            Restaurant <span className="text-primary-400">SaaS</span>
          </h1>
          <p className="mt-2 text-sm text-surface-400">
            Sistema de Gestión Integral
          </p>
        </div>

        {/* Formulario (Outlet renderiza LoginPage, RegisterPage, etc.) */}
        <div className="bg-white/10 backdrop-blur-lg rounded-2xl border border-white/20 shadow-2xl p-8">
          <Outlet />
        </div>

        {/* Footer */}
        <p className="text-center text-xs text-surface-500">
          &copy; 2026 Restaurant Management System
        </p>
      </div>
    </div>
  );
};

export default AuthLayout;
