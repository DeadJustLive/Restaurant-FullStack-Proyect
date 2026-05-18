import React, { useState, useEffect } from 'react';
import { PageContainer } from '../layouts/PageContainer';
import { Card, CardHeader, CardTitle, CardContent } from '../components/ui/Card';
import { Badge } from '../components/ui/Badge';
import { Button } from '../components/ui/Button';
import { NuevoPedidoModal } from '../components/features/NuevoPedidoModal';
import { CobrarPedidoModal } from '../components/features/CobrarPedidoModal';
import { Plus, Users, Clock, Receipt } from 'lucide-react';
import { useFetch } from '../hooks/useFetch';
import { apiPedidos } from '../api/axios';
import { useAuth } from '../contexts/AuthContext';

/**
 * @MOCK — Imports de datos simulados.
 * Reemplazar por: const { data: mesas } = useFetch(apiPedidos, '/mesas')
 */
import { MOCK_MESAS, formatPrecio, tiempoTranscurrido, type MesaMock, type PedidoMock } from '../mocks/data';

const WaiterDashboard: React.FC = () => {
  const { user } = useAuth();
  const { data: fetchedMesas } = useFetch<MesaMock[]>(apiPedidos, '/mesas');
  /** @MOCK — Estado local simulando las mesas */
  const [mesas, setMesas] = useState<MesaMock[]>(MOCK_MESAS);

  useEffect(() => {
    if (fetchedMesas) {
      setMesas(Array.isArray(fetchedMesas) ? fetchedMesas : MOCK_MESAS);
    }
  }, [fetchedMesas]);

  // Modal: Nuevo Pedido
  const [modalOpen, setModalOpen] = useState(false);
  const [selectedMesa, setSelectedMesa] = useState<MesaMock | null>(null);

  // Modal: Cobrar Pedido
  const [cobrarModalOpen, setCobrarModalOpen] = useState(false);
  const [pedidoACobrar, setPedidoACobrar] = useState<PedidoMock | null>(null);

  const mesasOcupadas = mesas.filter(m => m.ocupada).length;
  const totalMesas = mesas.length;

  const handleNuevoPedido = (mesa: MesaMock) => {
    setSelectedMesa(mesa);
    setModalOpen(true);
  };

  const handleCobrar = (mesa: MesaMock) => {
    if (mesa.pedidoActivo) {
      setPedidoACobrar(mesa.pedidoActivo);
      setCobrarModalOpen(true);
    }
  };

  /**
   * @MOCK — Al cobrar exitosamente, libera la mesa localmente.
   * En producción la mesa se actualizará al refetchar el estado real del servidor.
   */
  const handlePagoExitoso = (pedidoId: number) => {
    setMesas(prev =>
      prev.map(m =>
        m.pedidoActivo?.id === pedidoId
          ? { ...m, ocupada: false, pedidoActivo: undefined }
          : m
      )
    );
  };

  return (
    <PageContainer>
      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4">
        <div>
          <h2 className="text-2xl font-bold tracking-tight text-white">Mesas y Pedidos</h2>
          <p className="text-surface-400">
            Sucursal Central — {mesasOcupadas}/{totalMesas} mesas ocupadas
          </p>
        </div>
        <Button variant="default" onClick={() => { setSelectedMesa(null); setModalOpen(true); }}>
          <Plus className="w-4 h-4 mr-2" />
          Nuevo Pedido
        </Button>
      </div>

      {/* Grid de Mesas */}
      <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
        {mesas.map((mesa) => (
          <Card
            key={mesa.id}
            className={`bg-surface-900/40 backdrop-blur-md border-white/5 text-white transition-all duration-200 hover:-translate-y-1 hover:shadow-md cursor-pointer border-l-4 ${
              mesa.ocupada ? 'border-l-red-500' : 'border-l-green-500'
            }`}
          >
            <CardHeader className="pb-2">
              <div className="flex items-center justify-between">
                <CardTitle className="text-base">{mesa.nombre}</CardTitle>
                <Badge variant={mesa.ocupada ? 'error' : 'success'}>
                  {mesa.ocupada ? 'Ocupada' : 'Libre'}
                </Badge>
              </div>
              <div className="flex items-center gap-1 text-xs text-surface-400 mt-1">
                <Users className="w-3 h-3" />
                <span>Cap. {mesa.capacidad}</span>
              </div>
            </CardHeader>
            <CardContent>
              {mesa.ocupada && mesa.pedidoActivo ? (
                <div className="space-y-3">
                  <div className="text-xs text-surface-400 flex items-center gap-1">
                    <Clock className="w-3 h-3" />
                    {tiempoTranscurrido(mesa.pedidoActivo.creadoEn)}
                  </div>
                  <div className="space-y-1">
                    {mesa.pedidoActivo.items.slice(0, 3).map(item => (
                      <p key={item.id} className="text-xs text-surface-400 truncate">
                        {item.cantidad}x {item.nombreSnapshot}
                      </p>
                    ))}
                    {mesa.pedidoActivo.items.length > 3 && (
                      <p className="text-xs text-surface-400">+{mesa.pedidoActivo.items.length - 3} más...</p>
                    )}
                  </div>
                  <div className="flex items-center justify-between pt-2 border-t border-white/5">
                    <span className="text-sm font-bold text-white">
                      {formatPrecio(mesa.pedidoActivo.total)}
                    </span>
                    <Button variant="default" size="sm" onClick={() => handleCobrar(mesa)}>
                      <Receipt className="w-3.5 h-3.5 mr-1" />
                      Cobrar
                    </Button>
                  </div>
                </div>
              ) : (
                <div className="py-2">
                  <Button variant="outline" size="sm" className="w-full" onClick={() => handleNuevoPedido(mesa)}>
                    <Plus className="w-3.5 h-3.5 mr-1" />
                    Asignar Pedido
                  </Button>
                </div>
              )}
            </CardContent>
          </Card>
        ))}
      </div>

      {/* Modal: Nuevo Pedido */}
      <NuevoPedidoModal
        isOpen={modalOpen}
        onClose={() => setModalOpen(false)}
        mesaId={selectedMesa?.id}
        mesaNombre={selectedMesa?.nombre}
        onConfirm={async (items, notas) => {
          try {
            const payload = {
              usuarioId: user?.id ? Number(user.id) : 1,
              sucursalId: 1,
              tipo: 'EN_LOCAL',
              notas,
              items: items.map(ci => ({
                menuItemId: ci.menuItem.id,
                cantidad: ci.cantidad,
              })),
            };
            await apiPedidos.post('/', payload);
            setMesas(prev =>
              prev.map(m =>
                m.id === selectedMesa?.id
                  ? { ...m, ocupada: true }
                  : m
              )
            );
          } catch (error) {
            console.error('Error creating order:', error);
          }
        }}
      />

      {/* Modal: Cobrar Pedido */}
      {pedidoACobrar && (
        <CobrarPedidoModal
          isOpen={cobrarModalOpen}
          onClose={() => setCobrarModalOpen(false)}
          pedido={pedidoACobrar}
          onPagoExitoso={handlePagoExitoso}
        />
      )}
    </PageContainer>
  );
};

export default WaiterDashboard;
