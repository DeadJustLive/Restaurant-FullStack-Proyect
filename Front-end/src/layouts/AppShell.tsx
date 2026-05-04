import React, { useState, useRef, useEffect } from 'react';
import { Outlet, Link, useLocation } from 'react-router-dom';
import { cn } from '../utils/utils';
import { getNavItemsByRole, Role } from '../config/navigation';
import { useAuth } from '../contexts/AuthContext';
import { useDevTools } from '../contexts/DevToolsContext';
import { Settings, LogOut, ChevronDown, Activity } from 'lucide-react';

/**
 * AppShell — Layout principal de la aplicación.
 *
 * Estructura:
 *   ┌──────────────────────────────────────────┐
 *   │          Floating Navbar (top)           │
 *   ├──────────────────────────────────────────┤
 *   │                                          │
 *   │            Page Content                  │
 *   │           (via <Outlet />)               │
 *   │                                          │
 *   └──────────────────────────────────────────┘
 */
export const AppShell: React.FC = () => {
  const location = useLocation();
  const { user, logout } = useAuth();
  const devtools = useDevTools();
  const [settingsOpen, setSettingsOpen] = useState(false);
  const dropdownRef = useRef<HTMLDivElement>(null);

  // TODO: Reemplazar por roles reales del AuthContext
  const userRoles: Role[] = (user?.roles as Role[]) ?? ['ROLE_AD'];
  const navItems = getNavItemsByRole(userRoles);

  // Cerrar dropdown al hacer click fuera
  useEffect(() => {
    const handleClickOutside = (e: MouseEvent) => {
      if (dropdownRef.current && !dropdownRef.current.contains(e.target as Node)) {
        setSettingsOpen(false);
      }
    };
    document.addEventListener('mousedown', handleClickOutside);
    return () => document.removeEventListener('mousedown', handleClickOutside);
  }, []);

  return (
    <div className="min-h-screen bg-surface-50 flex flex-col">
      {/* ─── Floating Navbar ─── */}
      <div className="sticky top-0 z-50 px-4 pt-3 pb-1">
        <nav className="mx-auto max-w-6xl bg-white/80 backdrop-blur-xl border border-surface-200/60 rounded-2xl shadow-lg shadow-surface-900/5 px-2 py-1.5 flex items-center justify-between gap-2">
          {/* Logo */}
          <Link to="/dashboard" className="flex items-center gap-2 px-3 py-1.5 shrink-0">
            <div className="h-8 w-8 rounded-lg bg-primary-500 flex items-center justify-center">
              <span className="text-white font-bold text-sm">R</span>
            </div>
            <span className="text-sm font-bold text-surface-900 hidden sm:inline">Restaurant</span>
          </Link>

          {/* Nav Items (centro) */}
          <div className="flex items-center gap-1 overflow-x-auto scrollbar-hide">
            {navItems.map((item) => {
              const isActive = location.pathname.startsWith(item.href);
              const Icon = item.icon;
              return (
                <Link
                  key={item.href}
                  to={item.href}
                  className={cn(
                    'flex items-center gap-2 px-3 py-2 rounded-xl text-sm font-medium transition-all duration-200 whitespace-nowrap',
                    isActive
                      ? 'bg-primary-500 text-white shadow-md shadow-primary-500/25'
                      : 'text-surface-600 hover:bg-surface-100 hover:text-surface-900'
                  )}
                >
                  <Icon className="w-4 h-4 shrink-0" />
                  <span className="hidden md:inline">{item.title}</span>
                </Link>
              );
            })}
          </div>

          {/* Acciones (derecha) */}
          <div className="flex items-center gap-1 shrink-0" ref={dropdownRef}>
            {/* Botón DevTools */}
            <button
              onClick={() => devtools.setPanelVisible(!devtools.panelVisible)}
              className={cn(
                'p-2 rounded-xl transition-all duration-200',
                devtools.panelVisible
                  ? 'bg-primary-100 text-primary-600'
                  : 'text-surface-400 hover:bg-surface-100 hover:text-surface-900'
              )}
              title="DevTools (Ctrl+Shift+D)"
            >
              <Activity className="w-4 h-4" />
            </button>

            {/* Botón de Configuración con Dropdown */}
            <div className="relative">
              <button
                onClick={() => setSettingsOpen(!settingsOpen)}
                className={cn(
                  'flex items-center gap-1.5 px-3 py-2 rounded-xl text-sm font-medium transition-all duration-200',
                  settingsOpen
                    ? 'bg-surface-100 text-surface-900'
                    : 'text-surface-500 hover:bg-surface-100 hover:text-surface-900'
                )}
              >
                <div className="h-7 w-7 rounded-full bg-primary-100 flex items-center justify-center text-primary-700 font-bold text-xs">
                  {user?.username?.charAt(0).toUpperCase() ?? 'U'}
                </div>
                <span className="hidden lg:inline">{user?.username ?? 'Usuario'}</span>
                <ChevronDown className={cn('w-3.5 h-3.5 transition-transform', settingsOpen && 'rotate-180')} />
              </button>

              {/* Dropdown Menu */}
              {settingsOpen && (
                <div className="absolute right-0 top-full mt-2 w-56 bg-white rounded-xl border border-surface-200 shadow-xl shadow-surface-900/10 py-1 animate-fade-in">
                  <div className="px-4 py-3 border-b border-surface-100">
                    <p className="text-sm font-medium text-surface-900">{user?.username}</p>
                    <p className="text-xs text-surface-500">{user?.roles.join(', ')}</p>
                  </div>
                  
                  <Link
                    to="/settings"
                    onClick={() => setSettingsOpen(false)}
                    className="flex items-center gap-2 px-4 py-2.5 text-sm text-surface-700 hover:bg-surface-50 transition-colors"
                  >
                    <Settings className="w-4 h-4" />
                    Configuración
                  </Link>

                  <hr className="border-surface-100 my-1" />

                  <button
                    onClick={() => { logout(); setSettingsOpen(false); }}
                    className="flex items-center gap-2 px-4 py-2.5 text-sm text-red-600 hover:bg-red-50 transition-colors w-full text-left"
                  >
                    <LogOut className="w-4 h-4" />
                    Cerrar Sesión
                  </button>
                </div>
              )}
            </div>
          </div>
        </nav>
      </div>

      {/* ─── Page Content ─── */}
      <main className="flex-1 overflow-y-auto">
        <Outlet />
      </main>
    </div>
  );
};
