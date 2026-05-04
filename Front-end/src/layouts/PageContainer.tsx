import React from 'react';
import { cn } from '../utils/utils';

interface PageContainerProps extends React.HTMLAttributes<HTMLDivElement> {
  children: React.ReactNode;
}

/**
 * PageContainer estandariza los márgenes y anchos del contenido de las páginas.
 * Garantiza que todas las vistas mantengan una estructura visual uniforme.
 */
export const PageContainer = React.forwardRef<HTMLDivElement, PageContainerProps>(
  ({ className, children, ...props }, ref) => {
    return (
      <div
        ref={ref}
        className={cn("container mx-auto max-w-7xl px-4 sm:px-6 lg:px-8 py-8 space-y-6", className)}
        {...props}
      >
        {children}
      </div>
    );
  }
);
PageContainer.displayName = 'PageContainer';
