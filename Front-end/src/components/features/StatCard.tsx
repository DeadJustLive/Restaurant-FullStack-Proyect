import React from 'react';
import { Card, CardContent, CardHeader, CardTitle } from '../ui/Card';
import { cn } from '../../utils/utils';

interface StatCardProps {
  title: string;
  value: string | number;
  description?: string;
  trend?: {
    value: number; // e.g., 12.5 para 12.5%
    isPositive: boolean;
  };
  icon?: React.ReactNode;
  className?: string;
}

/**
 * Componente Molecular (Feature): StatCard
 * Construido componiendo componentes atómicos (Card).
 * Ideal para KPIs en dashboards.
 */
export const StatCard: React.FC<StatCardProps> = ({
  title,
  value,
  description,
  trend,
  icon,
  className
}) => {
  return (
    <Card className={cn("bg-surface-900/40 backdrop-blur-md border-white/5 text-white hover:shadow-md transition-shadow", className)}>
      <CardHeader className="flex flex-row items-center justify-between pb-2">
        <CardTitle className="text-sm font-medium text-surface-400">
          {title}
        </CardTitle>
        {icon && <div className="text-surface-400">{icon}</div>}
      </CardHeader>
      <CardContent>
        <div className="text-2xl font-bold text-white">{value}</div>
        
        {(description || trend) && (
          <p className="text-xs text-surface-400 mt-1 flex items-center gap-1">
            {trend && (
              <span className={cn(
                "font-medium",
                trend.isPositive ? "text-green-400" : "text-red-400"
              )}>
                {trend.isPositive ? '+' : '-'}{Math.abs(trend.value)}%
              </span>
            )}
            {description && <span>{description}</span>}
          </p>
        )}
      </CardContent>
    </Card>
  );
};
