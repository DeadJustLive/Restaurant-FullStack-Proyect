import React, { useState } from 'react';
import { Button } from '../ui/Button';
import { Input } from '../ui/Input';
import { X, Truck, CheckCircle2, MapPin } from 'lucide-react';
import { apiDelivery, apiPedidos } from '../../api/axios';
import { formatPrecio, type PedidoMock } from '../../mocks/data';

interface EntregarDeliveryModalProps {
  isOpen: boolean;
  onClose: () => void;
  pedido: PedidoMock;
  /**
   * Callback tras entrega confirmada.
   * Permite al componente padre actualizar la UI.
   */
  onEntregaExitosa: (pedidoId: number) => void;
}

/**
 * EntregarDeliveryModal — Modal para confirmar entrega de un pedido delivery.
 *
 * ENDPOINTS BACKEND:
 *   PATCH /api/v1/delivery/{id}/estado  → Actualizar estado del delivery
 *     Params: estado=ENTREGADO, observaciones (opcional)
 *   PATCH /api/v1/pedidos/{id}/estado   → Cambiar pedido a ENTREGADO
 *     Body: { estado: "ENTREGADO" }
 *
 * @MOCK — Si el backend no está disponible, simula éxito local.
 */
export const EntregarDeliveryModal: React.FC<EntregarDeliveryModalProps> = ({
  isOpen,
  onClose,
  pedido,
  onEntregaExitosa,
}) => {
  const [observaciones, setObservaciones] = useState('');
  const [isProcessing, setIsProcessing] = useState(false);
  const [entregaExitosa, setEntregaExitosa] = useState(false);

  const handleConfirmarEntrega = async () => {
    setIsProcessing(true);

    try {
      /**
       * ENDPOINT: PATCH /api/v1/delivery/{pedidoId}/estado
       * Params:
       *   estado: EstadoDelivery = ENTREGADO
       *   observaciones?: string
       *
       * Confirma que el repartidor ha completado la entrega.
       */
      await apiDelivery.patch(`/${pedido.id}/estado`, null, {
        params: {
          estado: 'ENTREGADO',
          observaciones: observaciones || undefined,
        },
      });

      /**
       * ENDPOINT: PATCH /api/v1/pedidos/{id}/estado
       * Body: { estado: "ENTREGADO" }
       *
       * Sincroniza el estado del pedido principal.
       */
      await apiPedidos.patch(`/${pedido.id}/estado`, {
        estado: 'ENTREGADO',
      });

      setEntregaExitosa(true);
      onEntregaExitosa(pedido.id);
    } catch (error) {
      /**
       * @MOCK — Fallback cuando ms-delivery y ms-pedidos no están activos.
       * Eliminar cuando el backend esté completamente implementado.
       */
      console.warn('[MOCK] Backend no disponible. Simulando entrega exitosa:', {
        pedidoId: pedido.id,
        observaciones,
      });
      setEntregaExitosa(true);
      onEntregaExitosa(pedido.id);
    } finally {
      setIsProcessing(false);
    }
  };

  const handleClose = () => {
    setEntregaExitosa(false);
    setObservaciones('');
    onClose();
  };

  if (!isOpen) return null;

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center">
      <div className="absolute inset-0 bg-black/40 backdrop-blur-sm" onClick={handleClose} />

      <div className="relative bg-white rounded-2xl shadow-2xl w-full max-w-md mx-4 animate-slide-up">
        {/* Header */}
        <div className="flex items-center justify-between p-6 border-b border-surface-200">
          <div className="flex items-center gap-2">
            <Truck className="w-5 h-5 text-primary-500" />
            <div>
              <h2 className="text-lg font-bold text-surface-900">Confirmar Entrega</h2>
              <p className="text-xs text-surface-500">{pedido.numeroPedido} • Delivery</p>
            </div>
          </div>
          <button onClick={handleClose} className="p-2 rounded-lg text-surface-400 hover:text-surface-900 hover:bg-surface-100 transition-colors">
            <X className="w-5 h-5" />
          </button>
        </div>

        {/* Body */}
        {entregaExitosa ? (
          <div className="p-8 flex flex-col items-center text-center space-y-4">
            <div className="h-16 w-16 rounded-full bg-green-100 flex items-center justify-center">
              <CheckCircle2 className="w-8 h-8 text-green-600" />
            </div>
            <h3 className="text-xl font-bold text-surface-900">¡Entrega Confirmada!</h3>
            <p className="text-sm text-surface-500">
              El pedido {pedido.numeroPedido} ha sido entregado exitosamente.
            </p>
            <Button variant="default" onClick={handleClose} className="mt-4">
              Cerrar
            </Button>
          </div>
        ) : (
          <div className="p-6 space-y-5">
            {/* Resumen del pedido */}
            <div className="bg-surface-50 rounded-xl p-4 space-y-2">
              <div className="flex items-center gap-2 text-xs font-medium text-surface-500 uppercase tracking-wider">
                <MapPin className="w-3 h-3" />
                Detalles de entrega
              </div>
              {pedido.items.map(item => (
                <div key={item.id} className="flex justify-between text-sm">
                  <span className="text-surface-700">{item.cantidad}x {item.nombreSnapshot}</span>
                  <span className="text-surface-900 font-medium">{formatPrecio(item.subtotal)}</span>
                </div>
              ))}
              <hr className="border-surface-200" />
              <div className="flex justify-between text-sm font-bold">
                <span>Total</span>
                <span>{formatPrecio(pedido.total)}</span>
              </div>
              {pedido.notas && (
                <div className="mt-2 p-2 bg-yellow-50 border border-yellow-200 rounded-lg text-xs text-yellow-800">
                  📝 Cliente: {pedido.notas}
                </div>
              )}
            </div>

            {/* Observaciones del repartidor */}
            <div className="space-y-2">
              <label className="text-sm font-medium text-surface-900">
                Observaciones (opcional)
              </label>
              <Input
                placeholder="Ej: Entregado a portería, recibió X persona..."
                value={observaciones}
                onChange={e => setObservaciones(e.target.value)}
              />
            </div>

            {/* Acción */}
            <Button
              variant="default"
              size="lg"
              className="w-full"
              onClick={handleConfirmarEntrega}
              disabled={isProcessing}
            >
              <CheckCircle2 className="w-4 h-4 mr-2" />
              {isProcessing ? 'Confirmando...' : 'Confirmar Entrega'}
            </Button>
          </div>
        )}
      </div>
    </div>
  );
};
