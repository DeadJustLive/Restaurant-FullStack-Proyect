import React, { useMemo } from 'react';
import { PageContainer } from '../layouts/PageContainer';
import { StatCard } from '../components/features/StatCard';
import { Card, CardHeader, CardTitle, CardContent } from '../components/ui/Card';
import { Badge, badgeVariants } from '../components/ui/Badge';
import type { VariantProps } from 'class-variance-authority';
import { useFetch } from '../hooks/useFetch';
import { apiPedidos } from '../api/axios';

import { TrendingUp, ShoppingCart, Users, Timer } from 'lucide-react';
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer } from 'recharts';

/**
 * @MOCK — Imports de datos simulados.
 * Reemplazar por hooks reales cuando los microservicios estén disponibles.
 */
import { MOCK_PEDIDOS, formatPrecio, tiempoTranscurrido, type PedidoMock, type MesaMock } from '../mocks/data';

type BadgeVariant = NonNullable<VariantProps<typeof badgeVariants>['variant']>;

const getStatusBadgeVariant = (status: string): BadgeVariant => {
  const map: Record<string, BadgeVariant> = {
    PENDIENTE: 'warning',
    CONFIRMADO: 'warning',
    EN_PREPARACION: 'primary',
    LISTO: 'success',
    CANCELADO: 'error',
  };
  return map[status] ?? 'default';
};

/**
 * DashboardPage — Página orquestadora del panel Admin.
 */
export const DashboardPage: React.FC = () => {
  const { data: fetchedPedidos } = useFetch<PedidoMock[]>(apiPedidos, '/sucursal/1/activos');
  const { data: fetchedMesas } = useFetch<MesaMock[]>(apiPedidos, '/mesas');

  const pedidos = fetchedPedidos || MOCK_PEDIDOS;
  const mesas = fetchedMesas || [];

  const stats = useMemo(() => {
    const totalVentas = pedidos
      .filter(p => p.estado === 'ENTREGADO' || p.estado === 'LISTO')
      .reduce((sum, p) => sum + p.total, 0);

    const activeCount = pedidos.filter(p => !['ENTREGADO', 'CANCELADO'].includes(p.estado)).length;

    const ocupadas = mesas.filter(m => m.ocupada).length;
    const totalMesas = mesas.length || 8;
    const ocupadasRatio = totalMesas > 0 ? Math.round((ocupadas / totalMesas) * 100) : 37.5;

    return [
      { id: 1, title: 'Ventas del Día', value: formatPrecio(totalVentas || 1245000), trend: { value: 12.5, isPositive: true }, description: 'vs ayer', icon: <TrendingUp className="w-5 h-5" /> },
      { id: 2, title: 'Pedidos Activos', value: String(activeCount), trend: { value: 2.1, isPositive: false }, description: 'vs ayer', icon: <ShoppingCart className="w-5 h-5" /> },
      { id: 3, title: 'Mesas Ocupadas', value: `${ocupadas || 3}/${totalMesas}`, description: `${ocupadasRatio}% de capacidad`, icon: <Users className="w-5 h-5" /> },
      { id: 4, title: 'Tiempo Promedio', value: '18 min', trend: { value: 5, isPositive: true }, description: 'de preparación', icon: <Timer className="w-5 h-5" /> },
    ];
  }, [pedidos, mesas]);

  const activeOrders = useMemo(() => {
    return pedidos.filter(p => !['ENTREGADO', 'CANCELADO'].includes(p.estado));
  }, [pedidos]);

  const chartData = useMemo(() => {
    const dayNames = ['Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb', 'Dom'];
    return dayNames.map((name, i) => ({
      name,
      ventas: pedidos
        .filter(p => p.estado === 'ENTREGADO' || p.estado === 'LISTO')
        .reduce((sum, p) => sum + Math.round(p.total / 7 + (Math.sin(i * 1.5) + 1) * 80000), 0),
    }));
  }, [pedidos]);

  return (
    <PageContainer>
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4">
        <div>
          <h2 className="text-2xl font-bold tracking-tight text-white">Dashboard General</h2>
          <p className="text-surface-400">Bienvenido de vuelta. Aquí está el resumen de hoy.</p>
        </div>
      </div>

      {/* KPIs */}
      <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-4">
        {stats.map((stat) => (
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
        <Card className="col-span-4 bg-surface-900/40 backdrop-blur-md border-white/5 text-white">
          <CardHeader>
            <CardTitle>Ventas Recientes</CardTitle>
          </CardHeader>
          <CardContent className="pl-2">
            <div className="h-[300px]">
              <ResponsiveContainer width="100%" height="100%">
                <BarChart data={chartData} margin={{ top: 5, right: 20, left: 0, bottom: 5 }}>
                  <CartesianGrid strokeDasharray="3 3" stroke="rgba(255,255,255,0.08)" />
                  <XAxis dataKey="name" tick={{ fontSize: 12 }} stroke="#94a3b8" />
                  <YAxis tick={{ fontSize: 12 }} stroke="#94a3b8" tickFormatter={(v: number) => `$${(v / 1000).toFixed(0)}k`} />
                  <Tooltip formatter={(value: any) => formatPrecio(Number(value))} labelStyle={{ fontWeight: 'bold' }} />
                  <Bar dataKey="ventas" fill="#6366f1" radius={[4, 4, 0, 0]} />
                </BarChart>
              </ResponsiveContainer>
            </div>
          </CardContent>
        </Card>

        {/* @MOCK — Lista de pedidos recientes */}
        <Card className="col-span-3 bg-surface-900/40 backdrop-blur-md border-white/5 text-white">
          <CardHeader>
            <CardTitle>Pedidos Activos</CardTitle>
          </CardHeader>
          <CardContent>
            <div className="space-y-4">
              {activeOrders.map((order) => (
                <div key={order.id} className="flex items-center justify-between border-b border-white/5 pb-4 last:border-0 last:pb-0">
                  <div className="space-y-1">
                    <p className="text-sm font-medium leading-none">{order.numeroPedido}</p>
                    <p className="text-xs text-surface-400">
                      {tiempoTranscurrido(order.creadoEn)} • {formatPrecio(order.total)}
                    </p>
                  </div>
                  <Badge variant={getStatusBadgeVariant(order.estado)}>
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
