import React, { useState } from 'react';
import { PageContainer } from '../layouts/PageContainer';
import { Card } from '../components/ui/Card';
import { Badge } from '../components/ui/Badge';
import { Button } from '../components/ui/Button';
import { EntregarDeliveryModal } from '../components/features/EntregarDeliveryModal';
import { CobrarPedidoModal } from '../components/features/CobrarPedidoModal';
import { Truck, Clock, MapPin, Package, CheckCircle, Phone } from 'lucide-react';
import { apiPedidos } from '../api/axios';

/**
 * @MOCK — Imports de datos simulados.
 * Reemplazar por: const { data } = useFetch(apiDelivery, '/activos')
 */
import {
  MOCK_PEDIDOS,
  formatPrecio,
  tiempoTranscurrido,
  type PedidoMock,
  type EstadoPedido,
} from '../mocks/data';

type DeliveryTab = 'TODOS' | 'CONFIRMADO' | 'EN_PREPARACION' | 'LISTO' | 'EN_CAMINO';

const TABS: { label: string; value: DeliveryTab }[] = [
  { label: 'Todos', value: 'TODOS' },
  { label: 'En Cocina', value: 'CONFIRMADO' },
  { label: 'Preparando', value: 'EN_PREPARACION' },
  { label: 'Listos', value: 'LISTO' },
  { label: 'En Camino', value: 'EN_CAMINO' },
];

const getEstadoBadgeVariant = (estado: EstadoPedido) => {
  const map: Record<string, string> = {
    PENDIENTE: 'warning', CONFIRMADO: 'warning', EN_PREPARACION: 'primary',
    LISTO: 'success', EN_CAMINO: 'primary', ENTREGADO: 'default', CANCELADO: 'error',
  };
  return (map[estado] ?? 'default') as any;
};

/** @MOCK — Pedidos filtrados solo DELIVERY */
const getDeliveryPedidos = (pedidos: PedidoMock[]) =>
  pedidos.filter(p => p.tipo === 'DELIVERY' && !['ENTREGADO', 'CANCELADO'].includes(p.estado));

/**
 * EntregasPage — Panel de gestión de entregas (Delivery).
 *
 * Muestra los pedidos tipo DELIVERY activos con sus estados,
 * permite despachar (LISTO → EN_CAMINO) y confirmar entrega.
 */
const EntregasPage: React.FC = () => {
  const [activeTab, setActiveTab] = useState<DeliveryTab>('TODOS');
  /** @MOCK — Estado local de pedidos */
  const [pedidos, setPedidos] = useState<PedidoMock[]>(MOCK_PEDIDOS);

  // Modal: Entregar
  const [entregarOpen, setEntregarOpen] = useState(false);
  const [pedidoAEntregar, setPedidoAEntregar] = useState<PedidoMock | null>(null);

  // Modal: Cobrar (para delivery que necesitan cobro contra entrega)
  const [cobrarOpen, setCobrarOpen] = useState(false);
  const [pedidoACobrar] = useState<PedidoMock | null>(null);

  const deliveryPedidos = getDeliveryPedidos(pedidos);

  const filteredPedidos = deliveryPedidos.filter(p => {
    if (activeTab === 'TODOS') return true;
    return p.estado === activeTab;
  });

  /**
   * Cambia estado de un pedido con fallback mock.
   * ENDPOINT: PATCH /api/v1/pedidos/{id}/estado
   */
  const handleCambiarEstado = async (pedidoId: number, nuevoEstado: EstadoPedido) => {
    try {
      await apiPedidos.patch(`/${pedidoId}/estado`, { estado: nuevoEstado });
    } catch {
      /** @MOCK — Fallback local */
      console.warn(`[MOCK] Delivery: estado ${pedidoId} → ${nuevoEstado}`);
    }
    setPedidos(prev =>
      prev.map(p =>
        p.id === pedidoId ? { ...p, estado: nuevoEstado, actualizadoEn: new Date().toISOString() } : p
      )
    );
  };

  const handleAccion = (pedido: PedidoMock) => {
    switch (pedido.estado) {
      case 'LISTO':
        // Despachar → pasa a EN_CAMINO
        handleCambiarEstado(pedido.id, 'EN_CAMINO');
        break;
      case 'EN_CAMINO':
        // Confirmar entrega
        setPedidoAEntregar(pedido);
        setEntregarOpen(true);
        break;
    }
  };

  const handleEntregaExitosa = (pedidoId: number) => {
    setPedidos(prev =>
      prev.map(p =>
        p.id === pedidoId ? { ...p, estado: 'ENTREGADO' as EstadoPedido } : p
      )
    );
  };

  const getAccionLabel = (estado: EstadoPedido): string => {
    switch (estado) {
      case 'CONFIRMADO': return 'En cocina...';
      case 'EN_PREPARACION': return 'Preparando...';
      case 'LISTO': return 'Despachar';
      case 'EN_CAMINO': return 'Confirmar Entrega';
      default: return '';
    }
  };

  return (
    <PageContainer>
      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4">
        <div>
          <h2 className="text-2xl font-bold tracking-tight text-surface-900">Entregas (Delivery)</h2>
          <p className="text-surface-500">
            {deliveryPedidos.length} pedidos delivery activos
          </p>
        </div>
        <div className="flex items-center gap-3">
          <div className="flex items-center gap-2 px-3 py-1.5 bg-green-50 text-green-700 rounded-lg text-sm font-medium">
            <div className="h-2 w-2 rounded-full bg-green-500 animate-pulse" />
            En línea
          </div>
        </div>
      </div>

      {/* Tabs */}
      <div className="flex gap-1 bg-surface-100 p-1 rounded-xl w-fit overflow-x-auto">
        {TABS.map(tab => {
          const count = tab.value === 'TODOS'
            ? deliveryPedidos.length
            : deliveryPedidos.filter(p => p.estado === tab.value).length;

          return (
            <button
              key={tab.value}
              onClick={() => setActiveTab(tab.value)}
              className={`flex items-center gap-2 px-4 py-2 rounded-lg text-sm font-medium transition-all whitespace-nowrap ${
                activeTab === tab.value
                  ? 'bg-white text-surface-900 shadow-sm'
                  : 'text-surface-500 hover:text-surface-700'
              }`}
            >
              {tab.label}
              <span className="bg-surface-200 text-surface-700 text-xs font-semibold px-1.5 py-0.5 rounded-full">
                {count}
              </span>
            </button>
          );
        })}
      </div>

      {/* Lista de entregas */}
      {filteredPedidos.length === 0 ? (
        <div className="flex flex-col items-center justify-center py-20 text-surface-400">
          <Package className="w-16 h-16 mb-4" />
          <h3 className="text-lg font-medium">Sin entregas pendientes</h3>
          <p className="text-sm">Los pedidos delivery aparecerán aquí</p>
        </div>
      ) : (
        <div className="space-y-3">
          {filteredPedidos.map(pedido => (
            <Card key={pedido.id} className={`transition-all hover:shadow-md ${
              pedido.estado === 'EN_CAMINO' ? 'border-l-4 border-l-primary-500' :
              pedido.estado === 'LISTO' ? 'border-l-4 border-l-green-500' : ''
            }`}>
              <div className="p-4 sm:p-6 flex flex-col sm:flex-row sm:items-center gap-4">
                {/* Icono de estado */}
                <div className={`h-12 w-12 rounded-xl flex items-center justify-center shrink-0 ${
                  pedido.estado === 'EN_CAMINO' ? 'bg-primary-100 text-primary-600' :
                  pedido.estado === 'LISTO' ? 'bg-green-100 text-green-600' :
                  'bg-surface-100 text-surface-500'
                }`}>
                  {pedido.estado === 'EN_CAMINO' ? <Truck className="w-6 h-6" /> :
                   pedido.estado === 'LISTO' ? <Package className="w-6 h-6" /> :
                   <Clock className="w-6 h-6" />}
                </div>

                {/* Info principal */}
                <div className="flex-1 min-w-0 space-y-1">
                  <div className="flex items-center gap-2 flex-wrap">
                    <span className="font-bold text-surface-900">{pedido.numeroPedido}</span>
                    <Badge variant={getEstadoBadgeVariant(pedido.estado)}>
                      {pedido.estado.replace('_', ' ')}
                    </Badge>
                  </div>
                  <div className="flex items-center gap-3 text-xs text-surface-500 flex-wrap">
                    <span className="flex items-center gap-1">
                      <Clock className="w-3 h-3" />
                      {tiempoTranscurrido(pedido.creadoEn)}
                    </span>
                    <span className="flex items-center gap-1">
                      <MapPin className="w-3 h-3" />
                      {/* @MOCK — Dirección simulada */}
                      Av. Principal #1234
                    </span>
                    <span className="flex items-center gap-1">
                      <Phone className="w-3 h-3" />
                      {/* @MOCK — Teléfono simulado */}
                      +56 9 1234 5678
                    </span>
                  </div>
                  <p className="text-xs text-surface-500">
                    {pedido.items.map(i => `${i.cantidad}x ${i.nombreSnapshot}`).join(', ')}
                  </p>
                  {pedido.notas && (
                    <p className="text-xs text-yellow-700 bg-yellow-50 px-2 py-1 rounded inline-block">
                      📝 {pedido.notas}
                    </p>
                  )}
                </div>

                {/* Precio + Acción */}
                <div className="flex items-center gap-3 shrink-0">
                  <span className="text-lg font-bold text-surface-900">{formatPrecio(pedido.total)}</span>
                  {(pedido.estado === 'LISTO' || pedido.estado === 'EN_CAMINO') && (
                    <Button
                      variant={pedido.estado === 'EN_CAMINO' ? 'default' : 'outline'}
                      size="sm"
                      onClick={() => handleAccion(pedido)}
                    >
                      {pedido.estado === 'LISTO' && <Truck className="w-3.5 h-3.5 mr-1" />}
                      {pedido.estado === 'EN_CAMINO' && <CheckCircle className="w-3.5 h-3.5 mr-1" />}
                      {getAccionLabel(pedido.estado)}
                    </Button>
                  )}
                </div>
              </div>
            </Card>
          ))}
        </div>
      )}

      {/* Modal: Confirmar Entrega */}
      {pedidoAEntregar && (
        <EntregarDeliveryModal
          isOpen={entregarOpen}
          onClose={() => setEntregarOpen(false)}
          pedido={pedidoAEntregar}
          onEntregaExitosa={handleEntregaExitosa}
        />
      )}

      {/* Modal: Cobrar contra entrega */}
      {pedidoACobrar && (
        <CobrarPedidoModal
          isOpen={cobrarOpen}
          onClose={() => setCobrarOpen(false)}
          pedido={pedidoACobrar}
          onPagoExitoso={(id) => handleEntregaExitosa(id)}
        />
      )}
    </PageContainer>
  );
};

export default EntregasPage;
