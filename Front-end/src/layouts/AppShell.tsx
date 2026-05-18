import React, { useState, useRef, useEffect } from 'react';
import { Outlet, Link, useLocation } from 'react-router-dom';
import { cn } from '../utils/utils';
import { getNavItemsByRole, Role } from '../config/navigation';
import { useAuth } from '../contexts/AuthContext';
import { useDevTools } from '../contexts/DevToolsContext';
import { ChevronDown, Activity, LayoutGrid } from 'lucide-react';
import { ModulesLauncherModal } from '../components/navigation/ModulesLauncherModal';

export const AppShell: React.FC = () => {
  const location = useLocation();
  const { user, logout } = useAuth();
  const devtools = useDevTools();
  const [settingsOpen, setSettingsOpen] = useState(false);
  const [isLauncherOpen, setIsLauncherOpen] = useState(false);
  const dropdownRef = useRef<HTMLDivElement>(null);

  const userRoles: Role[] = (user?.roles as Role[]) ?? ['ROLE_AD'];
  const enabledModules = user?.enabledModules || [];
  
  // Obtenemos todos los ítems permitidos
  const allNavItems = getNavItemsByRole(userRoles, enabledModules);
  
  // ESTRATEGIA DE NAV: 
  // Mostramos los primeros 3 directamente, el resto van al Launcher.
  const mainNavItems = allNavItems.slice(0, 3);
  const secondaryNavItems = allNavItems.slice(3);

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
      {/* ─── Navbar ─── */}
      <div className="sticky top-0 z-50 px-4 pt-3 pb-1">
        <nav className="mx-auto max-w-7xl bg-white/80 backdrop-blur-xl border border-surface-200/60 rounded-2xl shadow-lg shadow-surface-900/5 px-2 py-1.5 flex items-center justify-between gap-2">
          {/* Logo */}
          <Link to="/dashboard" className="flex items-center gap-2 px-3 py-1.5 shrink-0">
            <div className="h-8 w-8 rounded-lg bg-primary-500 flex items-center justify-center">
              <span className="text-white font-bold text-sm">R</span>
            </div>
            <span className="text-sm font-bold text-surface-900 hidden sm:inline">Restaurant Platform</span>
          </Link>

          {/* Nav Items (Principales + Launcher) */}
          <div className="flex items-center gap-1 overflow-x-auto scrollbar-hide py-1">
            {/* Items Directos */}
            {mainNavItems.map((item) => {
              const isActive = location.pathname.startsWith(item.href);
              const Icon = item.icon;
              return (
                <Link
                  key={item.id}
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

            {/* Launcher de Módulos (Secundarios) */}
            {secondaryNavItems.length > 0 && (
              <button
                onClick={() => setIsLauncherOpen(true)}
                className={cn(
                  "flex items-center gap-2 px-3 py-2 rounded-xl text-sm font-medium transition-all duration-200 whitespace-nowrap",
                  "text-surface-600 hover:bg-surface-100 hover:text-surface-900"
                )}
              >
                <LayoutGrid className="w-4 h-4 shrink-0" />
                <span className="hidden md:inline">Más Módulos</span>
              </button>
            )}
          </div>

          {/* Acciones de Usuario */}
          <div className="flex items-center gap-1 shrink-0" ref={dropdownRef}>
            <button
              onClick={() => devtools.setPanelVisible(!devtools.panelVisible)}
              className={cn(
                'p-2 rounded-xl transition-all duration-200',
                devtools.panelVisible
                  ? 'bg-primary-100 text-primary-600'
                  : 'text-surface-400 hover:bg-surface-100 hover:text-surface-900'
              )}
            >
              <Activity className="w-4 h-4" />
            </button>

            <div className="relative">
              <button
                onClick={() => setSettingsOpen(!settingsOpen)}
                className={cn(
                  'flex items-center gap-1.5 px-3 py-2 rounded-xl text-sm font-medium transition-all duration-200',
                  settingsOpen ? 'bg-surface-100 text-surface-900' : 'text-surface-500'
                )}
              >
                <div className="h-7 w-7 rounded-full bg-primary-500 text-white flex items-center justify-center font-bold text-xs">
                  {user?.username?.charAt(0).toUpperCase() ?? 'U'}
                </div>
                <ChevronDown className={cn('w-3.5 h-3.5 transition-transform', settingsOpen && 'rotate-180')} />
              </button>

              {settingsOpen && (
                <div className="absolute right-0 top-full mt-2 w-56 bg-white rounded-xl border border-surface-200 shadow-xl py-1">
                  <div className="px-4 py-3 border-b border-surface-100">
                    <p className="text-sm font-medium text-surface-900">{user?.username}</p>
                    <p className="text-[10px] text-surface-500 uppercase tracking-wider">{user?.roles.join(' • ')}</p>
                  </div>
                  <Link to="/profile" className="block px-4 py-2 text-sm hover:bg-surface-50">Perfil</Link>
                  <Link to="/settings" className="block px-4 py-2 text-sm hover:bg-surface-50">Configuración</Link>
                  <hr className="my-1 border-surface-100" />
                  <button onClick={logout} className="w-full text-left px-4 py-2 text-sm text-red-600 hover:bg-red-50">
                    Cerrar Sesión
                  </button>
                </div>
              )}
            </div>
          </div>
        </nav>
      </div>

      {/* ─── Modules Launcher Modal ─── */}
      <ModulesLauncherModal 
        isOpen={isLauncherOpen} 
        onClose={() => setIsLauncherOpen(false)} 
        items={secondaryNavItems} 
      />

      {/* ─── Content ─── */}
      <main className="flex-1">
        <Outlet />
      </main>
    </div>
  );
};
