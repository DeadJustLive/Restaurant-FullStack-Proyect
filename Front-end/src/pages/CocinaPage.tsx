import React, { useState, useEffect } from 'react';
import { PageContainer } from '../layouts/PageContainer';
import { Card, CardHeader, CardTitle, CardContent, CardFooter } from '../components/ui/Card';
import { Badge } from '../components/ui/Badge';
import { Button } from '../components/ui/Button';
import { CobrarPedidoModal } from '../components/features/CobrarPedidoModal';
import { EntregarDeliveryModal } from '../components/features/EntregarDeliveryModal';
import { Clock, ChefHat, CheckCircle, AlertTriangle, Receipt, Truck } from 'lucide-react';
import { apiPedidos } from '../api/axios';
import { useFetch } from '../hooks/useFetch';

/**
 * @MOCK — Imports de datos simulados.
 * Reemplazar por: const { data: pedidos } = useFetch(apiPedidos, '/sucursal/1/activos')
 */
import {
  MOCK_PEDIDOS,
  TRANSICIONES_VALIDAS,
  formatPrecio,
  tiempoTranscurrido,
  type PedidoMock,
  type EstadoPedido,
} from '../mocks/data';

type TabFilter = 'TODOS' | 'CONFIRMADO' | 'EN_PREPARACION' | 'LISTO';

const TABS: { label: string; value: TabFilter; icon: React.ComponentType<{className?:string}> }[] = [
  { label: 'Todos', value: 'TODOS', icon: ChefHat },
  { label: 'Pendientes', value: 'CONFIRMADO', icon: Clock },
  { label: 'En Preparación', value: 'EN_PREPARACION', icon: AlertTriangle },
  { label: 'Listos', value: 'LISTO', icon: CheckCircle },
];

import type { VariantProps } from 'class-variance-authority';

type BadgeVariant = NonNullable<VariantProps<typeof badgeVariants>['variant']>;
import { badgeVariants } from '../components/ui/Badge';

const getEstadoBadgeVariant = (estado: EstadoPedido): BadgeVariant => {
  const map: Record<string, BadgeVariant> = {
    PENDIENTE: 'warning',
    CONFIRMADO: 'warning',
    EN_PREPARACION: 'primary',
    LISTO: 'success',
    ENTREGADO: 'default',
    CANCELADO: 'error',
  };
  return map[estado] ?? 'default';
};

/**
 * CocinaPage — Vista KDS (Kitchen Display System)
 */
const CocinaPage: React.FC = () => {
  const [activeTab, setActiveTab] = useState<TabFilter>('TODOS');
  
  const { data: fetchedPedidos } = useFetch<PedidoMock[]>(apiPedidos, '/sucursal/1/activos');
  /** @MOCK — Estado local que simula la lista de pedidos */
  const [pedidos, setPedidos] = useState<PedidoMock[]>(MOCK_PEDIDOS);

  useEffect(() => {
    if (fetchedPedidos) {
      setPedidos(Array.isArray(fetchedPedidos) ? fetchedPedidos : MOCK_PEDIDOS);
    }
  }, [fetchedPedidos]);

  // Modal: Cobrar
  const [cobrarModalOpen, setCobrarModalOpen] = useState(false);
  const [pedidoACobrar, setPedidoACobrar] = useState<PedidoMock | null>(null);

  // Modal: Entregar Delivery
  const [entregarModalOpen, setEntregarModalOpen] = useState(false);
  const [pedidoAEntregar, setPedidoAEntregar] = useState<PedidoMock | null>(null);

  const filteredPedidos = pedidos.filter(p => {
    if (activeTab === 'TODOS') return ['CONFIRMADO', 'EN_PREPARACION', 'LISTO'].includes(p.estado);
    return p.estado === activeTab;
  });

  /**
   * Cambia el estado de un pedido.
   * Intenta llamar al endpoint real y si falla, lo hace localmente.
   *
   * ENDPOINT: PATCH /api/v1/pedidos/{id}/estado
   * Body: { estado: string }
   */
  const handleCambiarEstado = async (pedidoId: number, nuevoEstado: EstadoPedido) => {
    try {
      await apiPedidos.patch(`/${pedidoId}/estado`, { estado: nuevoEstado });
    } catch {
      /** @MOCK — Fallback local cuando ms-pedidos no está activo */
      console.warn(`[MOCK] Cambiando estado de pedido ${pedidoId} a ${nuevoEstado}`);
    }

    // Actualizar estado local en ambos casos (éxito real o mock)
    setPedidos(prev =>
      prev.map(p =>
        p.id === pedidoId
          ? { ...p, estado: nuevoEstado, actualizadoEn: new Date().toISOString() }
          : p
      )
    );
  };

  const handleAccionPrincipal = (pedido: PedidoMock) => {
    switch (pedido.estado) {
      case 'CONFIRMADO':
        handleCambiarEstado(pedido.id, 'EN_PREPARACION');
        break;
      case 'EN_PREPARACION':
        handleCambiarEstado(pedido.id, 'LISTO');
        break;
      case 'LISTO':
        // Si es EN_LOCAL → abrir modal de cobro
        // Si es DELIVERY → abrir modal de entrega
        if (pedido.tipo === 'EN_LOCAL') {
          setPedidoACobrar(pedido);
          setCobrarModalOpen(true);
        } else {
          setPedidoAEntregar(pedido);
          setEntregarModalOpen(true);
        }
        break;
    }
  };

  const getBotonAccionLabel = (pedido: PedidoMock): string => {
    switch (pedido.estado) {
      case 'CONFIRMADO': return 'Empezar a Preparar';
      case 'EN_PREPARACION': return 'Marcar como Listo';
      case 'LISTO': return pedido.tipo === 'EN_LOCAL' ? 'Cobrar Cuenta' : 'Confirmar Entrega';
      default: return '';
    }
  };

  const getBotonAccionIcon = (pedido: PedidoMock) => {
    if (pedido.estado === 'LISTO') {
      return pedido.tipo === 'EN_LOCAL'
        ? <Receipt className="w-3.5 h-3.5 mr-1" />
        : <Truck className="w-3.5 h-3.5 mr-1" />;
    }
    return null;
  };

  const handlePedidoFinalizado = (pedidoId: number) => {
    setPedidos(prev =>
      prev.map(p =>
        p.id === pedidoId
          ? { ...p, estado: 'ENTREGADO' as EstadoPedido, actualizadoEn: new Date().toISOString() }
          : p
      )
    );
  };

  return (
    <PageContainer>
      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4">
        <div>
          <h2 className="text-2xl font-bold tracking-tight text-white">Cocina (KDS)</h2>
          <p className="text-surface-400">Gestiona los pedidos en tiempo real</p>
        </div>
        <div className="flex items-center gap-2 text-sm text-surface-400">
          <div className="h-2 w-2 rounded-full bg-green-500 animate-pulse" />
          <span>{filteredPedidos.length} pedidos activos</span>
        </div>
      </div>

      {/* Tabs */}
      <div className="flex gap-1 bg-surface-800 p-1 rounded-xl w-fit">
        {TABS.map(tab => {
          const Icon = tab.icon;
          const count = pedidos.filter(p =>
            tab.value === 'TODOS'
              ? ['CONFIRMADO', 'EN_PREPARACION', 'LISTO'].includes(p.estado)
              : p.estado === tab.value
          ).length;

          return (
            <button
              key={tab.value}
              onClick={() => setActiveTab(tab.value)}
              className={`flex items-center gap-2 px-4 py-2 rounded-lg text-sm font-medium transition-all ${
                activeTab === tab.value
                  ? 'bg-surface-800 text-white'
                  : 'text-surface-400 hover:text-surface-300'
              }`}
            >
              <Icon className="w-4 h-4" />
              <span className="hidden sm:inline">{tab.label}</span>
              <span className="bg-surface-700 text-surface-300 text-xs font-semibold px-1.5 py-0.5 rounded-full">
                {count}
              </span>
            </button>
          );
        })}
      </div>

      {/* Grid de Pedidos */}
      {filteredPedidos.length === 0 ? (
        <div className="flex flex-col items-center justify-center py-20 text-surface-400">
          <CheckCircle className="w-16 h-16 mb-4" />
          <h3 className="text-lg font-medium">¡Todo al día!</h3>
          <p className="text-sm">No hay pedidos en esta categoría</p>
        </div>
      ) : (
        <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-3">
          {filteredPedidos.map(pedido => (
            <Card key={pedido.id} className={`bg-surface-900/40 backdrop-blur-md border-white/5 text-white transition-all hover:shadow-md ${
              pedido.estado === 'LISTO' ? 'ring-2 ring-green-400 ring-offset-2' : ''
            }`}>
              <CardHeader className="pb-3">
                <div className="flex items-center justify-between">
                  <CardTitle className="text-base font-bold">{pedido.numeroPedido}</CardTitle>
                  <Badge variant={getEstadoBadgeVariant(pedido.estado)}>{pedido.estado.replace('_', ' ')}</Badge>
                </div>
                <div className="flex items-center gap-3 text-xs text-surface-400 mt-1">
                  <span className="flex items-center gap-1">
                    <Clock className="w-3 h-3" />
                    {tiempoTranscurrido(pedido.creadoEn)}
                  </span>
                  <span>{pedido.tipo === 'EN_LOCAL' ? `Mesa ${pedido.mesaId ?? '?'}` : '🚚 Delivery'}</span>
                  <span className="font-medium text-surface-300">{formatPrecio(pedido.total)}</span>
                </div>
              </CardHeader>

              <CardContent className="pt-0 pb-3">
                <div className="space-y-2">
                  {pedido.items.map(item => (
                    <div key={item.id} className="flex items-start justify-between text-sm">
                      <div className="flex gap-2">
                        <span className="font-semibold text-primary-600 min-w-[20px]">{item.cantidad}x</span>
                        <div>
                          <span className="text-surface-300">{item.nombreSnapshot}</span>
                          {item.notas && <p className="text-xs text-surface-400 italic">→ {item.notas}</p>}
                        </div>
                      </div>
                      <span className="text-surface-400 text-xs">{formatPrecio(item.subtotal)}</span>
                    </div>
                  ))}
                </div>
                {pedido.notas && (
                  <div className="mt-3 p-2 bg-yellow-500/10 border border-yellow-500/20 rounded-lg text-xs text-yellow-300">
                    📝 {pedido.notas}
                  </div>
                )}
              </CardContent>

              <CardFooter className="pt-0 gap-2">
                <Button
                  variant="default"
                  size="sm"
                  className="flex-1"
                  onClick={() => handleAccionPrincipal(pedido)}
                >
                  {getBotonAccionIcon(pedido)}
                  {getBotonAccionLabel(pedido)}
                </Button>
                {TRANSICIONES_VALIDAS[pedido.estado].includes('CANCELADO') && (
                  <Button
                    variant="destructive"
                    size="sm"
                    onClick={() => handleCambiarEstado(pedido.id, 'CANCELADO')}
                  >
                    Cancelar
                  </Button>
                )}
              </CardFooter>
            </Card>
          ))}
        </div>
      )}

      {/* Modal: Cobrar Pedido (EN_LOCAL cuando está LISTO) */}
      {pedidoACobrar && (
        <CobrarPedidoModal
          isOpen={cobrarModalOpen}
          onClose={() => setCobrarModalOpen(false)}
          pedido={pedidoACobrar}
          onPagoExitoso={handlePedidoFinalizado}
        />
      )}

      {/* Modal: Entregar Delivery (DELIVERY cuando está LISTO) */}
      {pedidoAEntregar && (
        <EntregarDeliveryModal
          isOpen={entregarModalOpen}
          onClose={() => setEntregarModalOpen(false)}
          pedido={pedidoAEntregar}
          onEntregaExitosa={handlePedidoFinalizado}
        />
      )}
    </PageContainer>
  );
};

export default CocinaPage;
