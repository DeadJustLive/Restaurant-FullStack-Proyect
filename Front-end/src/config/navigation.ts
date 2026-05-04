import { 
  LayoutDashboard, 
  ChefHat, 
  UtensilsCrossed,
  Truck, 
  BookOpen,
  Settings,
  UserCircle
} from 'lucide-react';

export type Role = 'ROLE_SA' | 'ROLE_AD' | 'ROLE_CO' | 'ROLE_RP' | 'ROLE_ME' | 'ROLE_CL';

export interface NavItem {
  title: string;
  href: string;
  icon: React.ComponentType<{ className?: string }>;
  roles: Role[];
}

/**
 * Configuración centralizada de la navegación.
 * Cada ítem define su icono de Lucide y los roles que lo pueden ver.
 */
export const navigationConfig: NavItem[] = [
  {
    title: 'Dashboard',
    href: '/dashboard',
    icon: LayoutDashboard,
    roles: ['ROLE_SA', 'ROLE_AD'],
  },
  {
    title: 'Cocina',
    href: '/cocina',
    icon: ChefHat,
    roles: ['ROLE_SA', 'ROLE_AD', 'ROLE_CO'],
  },
  {
    title: 'Mesas',
    href: '/mesas',
    icon: UtensilsCrossed,
    roles: ['ROLE_SA', 'ROLE_AD', 'ROLE_ME'],
  },
  {
    title: 'Entregas',
    href: '/delivery',
    icon: Truck,
    roles: ['ROLE_SA', 'ROLE_AD', 'ROLE_RP'],
  },
  {
    title: 'Menú',
    href: '/menu',
    icon: BookOpen,
    roles: ['ROLE_CL'],
  },
];

/** Ítems de utilidad (derecha de la navbar) */
export const utilityNavItems = [
  { title: 'Perfil', href: '/profile', icon: UserCircle },
  { title: 'Configuración', href: '/settings', icon: Settings },
];

/**
 * Filtra los ítems de navegación según el rol actual del usuario.
 */
export const getNavItemsByRole = (userRoles: Role[]): NavItem[] => {
  return navigationConfig.filter(item =>
    item.roles.some(role => userRoles.includes(role))
  );
};
