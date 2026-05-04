import React from 'react';
import { Link } from 'react-router-dom';
import { NavItem } from '../../config/navigation';
import { cn } from '../../utils/utils';

interface NavModuleItemProps {
  item: NavItem;
  onClick?: () => void;
}

/**
 * NavModuleItem — Representación visual tipo "Card" de un módulo.
 * Ideal para ser usado dentro de un grid en el Launcher.
 */
export const NavModuleItem: React.FC<NavModuleItemProps> = ({ item, onClick }) => {
  const Icon = item.icon;
  
  return (
    <Link
      to={item.href}
      onClick={onClick}
      className={cn(
        "group flex flex-col items-center justify-center p-6 rounded-2xl border border-surface-100 bg-white",
        "hover:border-primary-200 hover:shadow-xl hover:shadow-primary-500/10 transition-all duration-300",
        "active:scale-95"
      )}
    >
      <div className={cn(
        "mb-4 p-4 rounded-2xl bg-surface-50 text-surface-600",
        "group-hover:bg-primary-50 group-hover:text-primary-600 transition-colors"
      )}>
        <Icon className="w-8 h-8" />
      </div>
      <span className="text-sm font-bold text-surface-900 group-hover:text-primary-700 text-center">
        {item.title}
      </span>
    </Link>
  );
};
