import React, { useState, useMemo } from 'react';
import { Button } from '../ui/Button';
import { Input } from '../ui/Input';
import { Badge } from '../ui/Badge';
import { X, CreditCard, Banknote, Landmark, ArrowRightLeft, Receipt, CheckCircle2 } from 'lucide-react';
import { cn } from '../../utils/utils';
import { apiPagos, apiPedidos } from '../../api/axios';
import { formatPrecio, type PedidoMock } from '../../mocks/data';

// ─── Tipos que reflejan el contrato del backend (ms-pagos) ───────

/** Espejo del enum MetodoPago de ms-pagos */
export type MetodoPago = 'EFECTIVO' | 'TARJETA_CREDITO' | 'TARJETA_DEBITO' | 'TRANSFERENCIA';

interface MetodoPagoOption {
  value: MetodoPago;
  label: string;
  icon: React.ComponentType<{ className?: string }>;
}

const METODOS_PAGO: MetodoPagoOption[] = [
  { value: 'EFECTIVO', label: 'Efectivo', icon: Banknote },
  { value: 'TARJETA_CREDITO', label: 'Crédito', icon: CreditCard },
  { value: 'TARJETA_DEBITO', label: 'Débito', icon: CreditCard },
  { value: 'TRANSFERENCIA', label: 'Transferencia', icon: Landmark },
];

const PROPINAS_SUGERIDAS = [
  { label: '10%', value: 0.10 },
  { label: '20%', value: 0.20 },
  { label: '30%', value: 0.30 },
];

interface CobrarPedidoModalProps {
  isOpen: boolean;
  onClose: () => void;
  pedido: PedidoMock;
  /**
   * Callback tras pago exitoso.
   * Permite al componente padre actualizar la UI (ej. liberar mesa).
   */
  onPagoExitoso: (pedidoId: number) => void;
}

/**
 * CobrarPedidoModal — Modal de cobro con selección de propina y método de pago.
 *
 * ENDPOINTS BACKEND:
 *   POST /api/v1/pagos                → Iniciar pago (PagoRequestDTO)
 *   PATCH /api/v1/pedidos/{id}/estado  → Cambiar estado a ENTREGADO (PedidoEstadoRequestDTO)
 *
 * @MOCK — Cuando los microservicios no están disponibles, simula las operaciones
 *         localmente con un console.log y llama onPagoExitoso igualmente.
 */
export const CobrarPedidoModal: React.FC<CobrarPedidoModalProps> = ({
  isOpen,
  onClose,
  pedido,
  onPagoExitoso,
}) => {
  const [metodoPago, setMetodoPago] = useState<MetodoPago>('EFECTIVO');
  const [propinaPercent, setPropinaPercent] = useState<number | null>(0.10);
  const [propinaCustom, setPropinaCustom] = useState<string>('');
  const [isCustomTip, setIsCustomTip] = useState(false);
  const [isProcessing, setIsProcessing] = useState(false);
  const [pagoExitoso, setPagoExitoso] = useState(false);

  const propina = useMemo(() => {
    if (isCustomTip) {
      const parsed = parseInt(propinaCustom, 10);
      return isNaN(parsed) ? 0 : parsed;
    }
    return propinaPercent !== null ? Math.round(pedido.total * propinaPercent) : 0;
  }, [isCustomTip, propinaCustom, propinaPercent, pedido.total]);

  const totalConPropina = pedido.total + propina;

  const handleCobrar = async () => {
    setIsProcessing(true);

    try {
      /**
       * ENDPOINT: POST /api/v1/pagos
       * Body (PagoRequestDTO):
       *   { pedidoId: number, monto: number, metodo: MetodoPago }
       *
       * El monto incluye la propina como parte del total cobrado.
       */
      await apiPagos.post('/', {
        pedidoId: pedido.id,
        monto: totalConPropina,
        metodo: metodoPago,
      });

      /**
       * ENDPOINT: PATCH /api/v1/pedidos/{id}/estado
       * Body (PedidoEstadoRequestDTO):
       *   { estado: "ENTREGADO" }
       *
       * Tras el pago exitoso, marcamos el pedido como entregado.
       */
      await apiPedidos.patch(`/${pedido.id}/estado`, {
        estado: 'ENTREGADO',
      });

      setPagoExitoso(true);
      onPagoExitoso(pedido.id);
    } catch (error) {
      /**
       * @MOCK — Si el backend no está disponible, simulamos éxito local.
       * Eliminar este bloque cuando ms-pagos y ms-pedidos estén activos.
       */
      console.warn('[MOCK] Backend no disponible. Simulando pago exitoso:', {
        pedidoId: pedido.id,
        monto: totalConPropina,
        metodo: metodoPago,
        propina,
      });
      setPagoExitoso(true);
      onPagoExitoso(pedido.id);
    } finally {
      setIsProcessing(false);
    }
  };

  const handleClose = () => {
    setPagoExitoso(false);
    setPropinaPercent(0.10);
    setIsCustomTip(false);
    setPropinaCustom('');
    setMetodoPago('EFECTIVO');
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
            <Receipt className="w-5 h-5 text-primary-500" />
            <div>
              <h2 className="text-lg font-bold text-surface-900">Cobrar Pedido</h2>
              <p className="text-xs text-surface-500">{pedido.numeroPedido} • {pedido.mesaId ? `Mesa ${pedido.mesaId}` : 'Delivery'}</p>
            </div>
          </div>
          <button onClick={handleClose} className="p-2 rounded-lg text-surface-400 hover:text-surface-900 hover:bg-surface-100 transition-colors">
            <X className="w-5 h-5" />
          </button>
        </div>

        {/* Body */}
        {pagoExitoso ? (
          /* ─── Vista de éxito ─── */
          <div className="p-8 flex flex-col items-center text-center space-y-4">
            <div className="h-16 w-16 rounded-full bg-green-100 flex items-center justify-center">
              <CheckCircle2 className="w-8 h-8 text-green-600" />
            </div>
            <h3 className="text-xl font-bold text-surface-900">¡Pago Registrado!</h3>
            <p className="text-sm text-surface-500">
              Total cobrado: <span className="font-semibold text-surface-900">{formatPrecio(totalConPropina)}</span>
            </p>
            <p className="text-xs text-surface-400">
              {METODOS_PAGO.find(m => m.value === metodoPago)?.label} • Propina: {formatPrecio(propina)}
            </p>
            <Button variant="default" onClick={handleClose} className="mt-4">
              Cerrar
            </Button>
          </div>
        ) : (
          /* ─── Formulario de cobro ─── */
          <div className="p-6 space-y-6">
            {/* Resumen del pedido */}
            <div className="bg-surface-50 rounded-xl p-4 space-y-2">
              <p className="text-xs font-medium text-surface-500 uppercase tracking-wider">Resumen</p>
              {pedido.items.map(item => (
                <div key={item.id} className="flex justify-between text-sm">
                  <span className="text-surface-700">{item.cantidad}x {item.nombreSnapshot}</span>
                  <span className="text-surface-900 font-medium">{formatPrecio(item.subtotal)}</span>
                </div>
              ))}
              <hr className="border-surface-200" />
              <div className="flex justify-between text-sm font-semibold">
                <span>Subtotal</span>
                <span>{formatPrecio(pedido.total)}</span>
              </div>
            </div>

            {/* Propina */}
            <div className="space-y-3">
              <p className="text-sm font-medium text-surface-900">Propina</p>
              <div className="grid grid-cols-4 gap-2">
                {PROPINAS_SUGERIDAS.map(tip => (
                  <button
                    key={tip.label}
                    onClick={() => { setPropinaPercent(tip.value); setIsCustomTip(false); }}
                    className={cn(
                      'py-2 rounded-xl text-sm font-medium transition-all border',
                      !isCustomTip && propinaPercent === tip.value
                        ? 'border-primary-500 bg-primary-50 text-primary-700'
                        : 'border-surface-200 text-surface-600 hover:border-surface-300'
                    )}
                  >
                    <span className="block text-base font-bold">{tip.label}</span>
                    <span className="block text-xs text-surface-400">{formatPrecio(Math.round(pedido.total * tip.value))}</span>
                  </button>
                ))}
                <button
                  onClick={() => { setIsCustomTip(true); setPropinaPercent(null); }}
                  className={cn(
                    'py-2 rounded-xl text-sm font-medium transition-all border',
                    isCustomTip
                      ? 'border-primary-500 bg-primary-50 text-primary-700'
                      : 'border-surface-200 text-surface-600 hover:border-surface-300'
                  )}
                >
                  <ArrowRightLeft className="w-4 h-4 mx-auto" />
                  <span className="block text-xs">Otro</span>
                </button>
              </div>
              {isCustomTip && (
                <Input
                  type="number"
                  placeholder="Monto de propina..."
                  value={propinaCustom}
                  onChange={e => setPropinaCustom(e.target.value)}
                  min={0}
                />
              )}
            </div>

            {/* Método de pago */}
            <div className="space-y-3">
              <p className="text-sm font-medium text-surface-900">Método de Pago</p>
              <div className="grid grid-cols-2 gap-2">
                {METODOS_PAGO.map(metodo => {
                  const Icon = metodo.icon;
                  return (
                    <button
                      key={metodo.value}
                      onClick={() => setMetodoPago(metodo.value)}
                      className={cn(
                        'flex items-center gap-2 px-4 py-3 rounded-xl text-sm font-medium transition-all border',
                        metodoPago === metodo.value
                          ? 'border-primary-500 bg-primary-50 text-primary-700'
                          : 'border-surface-200 text-surface-600 hover:border-surface-300'
                      )}
                    >
                      <Icon className="w-4 h-4" />
                      {metodo.label}
                    </button>
                  );
                })}
              </div>
            </div>

            {/* Total */}
            <div className="bg-surface-900 rounded-xl p-4 flex items-center justify-between text-white">
              <div>
                <p className="text-xs text-surface-400">Total a Cobrar</p>
                <p className="text-2xl font-bold">{formatPrecio(totalConPropina)}</p>
              </div>
              {propina > 0 && (
                <Badge variant="success">+{formatPrecio(propina)} propina</Badge>
              )}
            </div>

            {/* Acción */}
            <Button
              variant="default"
              size="lg"
              className="w-full"
              onClick={handleCobrar}
              disabled={isProcessing}
            >
              {isProcessing ? 'Procesando...' : `Cobrar ${formatPrecio(totalConPropina)}`}
            </Button>
          </div>
        )}
      </div>
    </div>
  );
};
