import { 
  LayoutDashboard, 
  ChefHat, 
  UtensilsCrossed,
  Truck, 
  BookOpen,
  Settings,
  UserCircle,
  Users,
  Store,
  Tags,
  ClipboardList,
  CreditCard
} from 'lucide-react';

export type Role = 'ROLE_SA' | 'ROLE_AD' | 'ROLE_CO' | 'ROLE_RP' | 'ROLE_ME' | 'ROLE_CL';

export interface NavItem {
  id: string; // Identificador único para filtrar por módulos habilitados
  title: string;
  href: string;
  icon: React.ComponentType<{ className?: string }>;
  roles: Role[];
  adminOnly?: boolean;
}

/**
 * Configuración centralizada de la navegación.
 * Estructura organizada por responsabilidades.
 */
export const navigationConfig: NavItem[] = [
  {
    id: 'dashboard',
    title: 'Dashboard',
    href: '/dashboard',
    icon: LayoutDashboard,
    roles: ['ROLE_SA', 'ROLE_AD', 'ROLE_CO', 'ROLE_ME', 'ROLE_RP'],
  },
  // ─── ADMINISTRACIÓN ───
  {
    id: 'usuarios',
    title: 'Usuarios',
    href: '/admin/usuarios',
    icon: Users,
    roles: ['ROLE_SA', 'ROLE_AD'],
    adminOnly: true,
  },
  {
    id: 'sucursales',
    title: 'Sucursales',
    href: '/admin/sucursales',
    icon: Store,
    roles: ['ROLE_SA', 'ROLE_AD'],
    adminOnly: true,
  },
  {
    id: 'categorias',
    title: 'Categorías',
    href: '/admin/categorias',
    icon: Tags,
    roles: ['ROLE_SA', 'ROLE_AD'],
    adminOnly: true,
  },
  {
    id: 'inventario',
    title: 'Inventario',
    href: '/admin/inventario',
    icon: ClipboardList,
    roles: ['ROLE_SA', 'ROLE_AD', 'ROLE_CO'],
  },
  // ─── OPERACIONES ───
  {
    id: 'cocina',
    title: 'Cocina',
    href: '/cocina',
    icon: ChefHat,
    roles: ['ROLE_SA', 'ROLE_AD', 'ROLE_CO'],
  },
  {
    id: 'mesas',
    title: 'Mesas',
    href: '/mesas',
    icon: UtensilsCrossed,
    roles: ['ROLE_SA', 'ROLE_AD', 'ROLE_ME'],
  },
  {
    id: 'delivery',
    title: 'Entregas',
    href: '/delivery',
    icon: Truck,
    roles: ['ROLE_SA', 'ROLE_AD', 'ROLE_RP'],
  },
  {
    id: 'pagos',
    title: 'Pagos',
    href: '/admin/pagos',
    icon: CreditCard,
    roles: ['ROLE_SA', 'ROLE_AD'],
  },
];

/** Ítems de utilidad (derecha de la navbar) */
export const utilityNavItems = [
  { title: 'Perfil', href: '/profile', icon: UserCircle },
  { title: 'Configuración', href: '/settings', icon: Settings },
];

/**
 * Filtra los ítems de navegación según:
 * 1. El rol del usuario (Autorización real).
 * 2. Módulos habilitados específicamente para el usuario (Configuración UX).
 */
export const getNavItemsByRole = (userRoles: Role[], enabledModules?: string[]): NavItem[] => {
  return navigationConfig.filter(item => {
    // 1. Verificar Rol
    const hasRole = item.roles.some(role => userRoles.includes(role));
    if (!hasRole) return false;

    // 2. Verificar Módulos habilitados (si se proveen)
    if (enabledModules && enabledModules.length > 0) {
      return enabledModules.includes(item.id);
    }

    return true;
  });
};
