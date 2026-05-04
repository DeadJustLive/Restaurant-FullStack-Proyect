import React from 'react';
import { PageContainer } from '../layouts/PageContainer';
import { StatCard } from '../components/features/StatCard';
import { Card, CardHeader, CardTitle, CardContent } from '../components/ui/Card';
import { Badge } from '../components/ui/Badge';
import { Button } from '../components/ui/Button';
import { TrendingUp, ShoppingCart, Users, Timer } from 'lucide-react';

/**
 * @MOCK — Imports de datos simulados.
 * Reemplazar por hooks reales cuando los microservicios estén disponibles.
 */
import { MOCK_PEDIDOS, formatPrecio, tiempoTranscurrido } from '../mocks/data';

/** @MOCK — KPIs simulados */
const mockStats = [
  { id: 1, title: 'Ventas del Día', value: '$1.245.000', trend: { value: 12.5, isPositive: true }, description: 'vs ayer', icon: <TrendingUp className="w-5 h-5" /> },
  { id: 2, title: 'Pedidos Activos', value: String(MOCK_PEDIDOS.filter(p => !['ENTREGADO', 'CANCELADO'].includes(p.estado)).length), trend: { value: 2.1, isPositive: false }, description: 'vs ayer', icon: <ShoppingCart className="w-5 h-5" /> },
  { id: 3, title: 'Mesas Ocupadas', value: '3/8', description: '37.5% de capacidad', icon: <Users className="w-5 h-5" /> },
  { id: 4, title: 'Tiempo Promedio', value: '18 min', trend: { value: 5, isPositive: true }, description: 'de preparación', icon: <Timer className="w-5 h-5" /> },
];

const getStatusBadgeVariant = (status: string) => {
  switch (status) {
    case 'PENDIENTE': return 'warning';
    case 'CONFIRMADO': return 'warning';
    case 'EN_PREPARACION': return 'primary';
    case 'LISTO': return 'success';
    case 'CANCELADO': return 'error';
    default: return 'default';
  }
};

/**
 * DashboardPage — Página orquestadora del panel Admin.
 */
export const DashboardPage: React.FC = () => {
  return (
    <PageContainer>
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4">
        <div>
          <h2 className="text-2xl font-bold tracking-tight text-surface-900">Dashboard General</h2>
          <p className="text-surface-500">Bienvenido de vuelta. Aquí está el resumen de hoy.</p>
        </div>
      </div>

      {/* KPIs */}
      <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-4">
        {mockStats.map((stat) => (
          <StatCard
            key={stat.id}
            title={stat.title}
            value={stat.value}
            trend={stat.trend}
            description={stat.description}
            icon={stat.icon}
          />
        ))}
      </div>

      <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-7">
        {/* Gráfico placeholder */}
        <Card className="col-span-4">
          <CardHeader>
            <CardTitle>Ventas Recientes</CardTitle>
          </CardHeader>
          <CardContent className="pl-2">
            <div className="h-[300px] flex items-center justify-center border-2 border-dashed border-surface-200 rounded-lg bg-surface-50">
              <p className="text-surface-500 text-sm">Gráfico de Ventas (integrar Recharts)</p>
            </div>
          </CardContent>
        </Card>

        {/* @MOCK — Lista de pedidos recientes */}
        <Card className="col-span-3">
          <CardHeader>
            <CardTitle>Pedidos Activos</CardTitle>
          </CardHeader>
          <CardContent>
            <div className="space-y-4">
              {MOCK_PEDIDOS.filter(p => !['ENTREGADO', 'CANCELADO'].includes(p.estado)).map((order) => (
                <div key={order.id} className="flex items-center justify-between border-b border-surface-100 pb-4 last:border-0 last:pb-0">
                  <div className="space-y-1">
                    <p className="text-sm font-medium leading-none">{order.numeroPedido}</p>
                    <p className="text-xs text-surface-500">
                      {tiempoTranscurrido(order.creadoEn)} • {formatPrecio(order.total)}
                    </p>
                  </div>
                  <Badge variant={getStatusBadgeVariant(order.estado) as any}>
                    {order.estado.replace('_', ' ')}
                  </Badge>
                </div>
              ))}
            </div>
          </CardContent>
        </Card>
      </div>
    </PageContainer>
  );
};

export default DashboardPage;
