import React, { useState, useMemo } from 'react';
import { Button } from '../ui/Button';
import { Input } from '../ui/Input';
import { Badge } from '../ui/Badge';
import { X, Plus, Minus, Search, ShoppingCart } from 'lucide-react';
import { cn } from '../../utils/utils';

/**
 * @MOCK — Imports de datos simulados.
 * Reemplazar por llamadas reales a ms-menu via useFetch.
 */
import { MOCK_MENU_ITEMS, formatPrecio, type MenuItemMock } from '../../mocks/data';

interface CartItem {
  menuItem: MenuItemMock;
  cantidad: number;
  notas: string;
}

interface NuevoPedidoModalProps {
  isOpen: boolean;
  onClose: () => void;
  mesaId?: number;
  mesaNombre?: string;
  onConfirm: (items: CartItem[], notas: string) => void;
}

/**
 * NuevoPedidoModal — Modal para crear un nuevo pedido.
 *
 * Permite buscar ítems del menú, agregar cantidades, notas por ítem
 * y confirmar el pedido.
 *
 * @MOCK — Los datos del menú vienen del archivo de mocks.
 * En producción: const { data: menuItems } = useFetch(apiMenu, '/items/disponibles')
 */
export const NuevoPedidoModal: React.FC<NuevoPedidoModalProps> = ({
  isOpen,
  onClose,
  mesaId,
  mesaNombre,
  onConfirm,
}) => {
  const [searchTerm, setSearchTerm] = useState('');
  const [cart, setCart] = useState<CartItem[]>([]);
  const [notasGenerales, setNotasGenerales] = useState('');
  const [activeCategory, setActiveCategory] = useState<string>('Todos');

  /** @MOCK — Menú disponible filtrado */
  const menuDisponible = MOCK_MENU_ITEMS.filter(item => item.disponible);

  const categorias = useMemo(() => {
    const cats = [...new Set(menuDisponible.map(i => i.categoriaNombre))];
    return ['Todos', ...cats];
  }, []);

  const filteredItems = menuDisponible.filter(item => {
    const matchSearch = item.nombre.toLowerCase().includes(searchTerm.toLowerCase());
    const matchCat = activeCategory === 'Todos' || item.categoriaNombre === activeCategory;
    return matchSearch && matchCat;
  });

  const total = cart.reduce((sum, ci) => sum + ci.menuItem.precio * ci.cantidad, 0);

  const addToCart = (item: MenuItemMock) => {
    setCart(prev => {
      const existing = prev.find(ci => ci.menuItem.id === item.id);
      if (existing) {
        return prev.map(ci =>
          ci.menuItem.id === item.id ? { ...ci, cantidad: ci.cantidad + 1 } : ci
        );
      }
      return [...prev, { menuItem: item, cantidad: 1, notas: '' }];
    });
  };

  const updateQty = (itemId: number, delta: number) => {
    setCart(prev =>
      prev
        .map(ci =>
          ci.menuItem.id === itemId ? { ...ci, cantidad: Math.max(0, ci.cantidad + delta) } : ci
        )
        .filter(ci => ci.cantidad > 0)
    );
  };

  if (!isOpen) return null;

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center">
      {/* Overlay */}
      <div className="absolute inset-0 bg-black/40 backdrop-blur-sm" onClick={onClose} />

      {/* Modal */}
      <div className="relative bg-white rounded-2xl shadow-2xl w-full max-w-4xl max-h-[90vh] flex flex-col mx-4 animate-slide-up">
        {/* Header */}
        <div className="flex items-center justify-between p-6 border-b border-surface-200">
          <div>
            <h2 className="text-xl font-bold text-surface-900">Nuevo Pedido</h2>
            {mesaNombre && (
              <p className="text-sm text-surface-500 mt-0.5">
                {mesaNombre} {mesaId && `(#${mesaId})`}
              </p>
            )}
          </div>
          <button
            onClick={onClose}
            className="p-2 rounded-lg text-surface-400 hover:text-surface-900 hover:bg-surface-100 transition-colors"
          >
            <X className="w-5 h-5" />
          </button>
        </div>

        {/* Body — Two columns */}
        <div className="flex-1 flex overflow-hidden">
          {/* Left: Menu */}
          <div className="flex-1 flex flex-col border-r border-surface-200 overflow-hidden">
            {/* Search + Categorías */}
            <div className="p-4 space-y-3 border-b border-surface-100">
              <div className="relative">
                <Search className="absolute left-3 top-1/2 -translate-y-1/2 w-4 h-4 text-surface-400" />
                <Input
                  placeholder="Buscar en el menú..."
                  value={searchTerm}
                  onChange={e => setSearchTerm(e.target.value)}
                  className="pl-10"
                />
              </div>
              <div className="flex gap-1 overflow-x-auto">
                {categorias.map(cat => (
                  <button
                    key={cat}
                    onClick={() => setActiveCategory(cat)}
                    className={cn(
                      'px-3 py-1 rounded-full text-xs font-medium whitespace-nowrap transition-colors',
                      activeCategory === cat
                        ? 'bg-primary-500 text-white'
                        : 'bg-surface-100 text-surface-600 hover:bg-surface-200'
                    )}
                  >
                    {cat}
                  </button>
                ))}
              </div>
            </div>

            {/* Items list */}
            <div className="flex-1 overflow-y-auto p-4 space-y-2">
              {filteredItems.map(item => {
                const inCart = cart.find(ci => ci.menuItem.id === item.id);
                return (
                  <div
                    key={item.id}
                    className={cn(
                      'flex items-center justify-between p-3 rounded-xl border transition-all cursor-pointer',
                      inCart
                        ? 'border-primary-300 bg-primary-50'
                        : 'border-surface-200 hover:border-surface-300 hover:bg-surface-50'
                    )}
                    onClick={() => addToCart(item)}
                  >
                    <div className="flex-1 min-w-0">
                      <p className="text-sm font-medium text-surface-900 truncate">{item.nombre}</p>
                      <p className="text-xs text-surface-400 truncate">{item.descripcion}</p>
                    </div>
                    <div className="flex items-center gap-2 ml-3">
                      <span className="text-sm font-semibold text-surface-800">{formatPrecio(item.precio)}</span>
                      {inCart ? (
                        <Badge variant="primary">{inCart.cantidad}</Badge>
                      ) : (
                        <Plus className="w-4 h-4 text-surface-400" />
                      )}
                    </div>
                  </div>
                );
              })}
            </div>
          </div>

          {/* Right: Cart */}
          <div className="w-80 flex flex-col bg-surface-50">
            <div className="p-4 border-b border-surface-200">
              <div className="flex items-center gap-2 text-sm font-semibold text-surface-900">
                <ShoppingCart className="w-4 h-4" />
                Pedido ({cart.length} {cart.length === 1 ? 'ítem' : 'ítems'})
              </div>
            </div>

            <div className="flex-1 overflow-y-auto p-4 space-y-3">
              {cart.length === 0 ? (
                <p className="text-sm text-surface-400 text-center py-8">
                  Agrega ítems del menú
                </p>
              ) : (
                cart.map(ci => (
                  <div key={ci.menuItem.id} className="bg-white rounded-xl p-3 border border-surface-200 space-y-2">
                    <div className="flex items-start justify-between">
                      <p className="text-sm font-medium text-surface-900">{ci.menuItem.nombre}</p>
                      <span className="text-sm font-semibold text-surface-700">{formatPrecio(ci.menuItem.precio * ci.cantidad)}</span>
                    </div>
                    <div className="flex items-center gap-2">
                      <button onClick={() => updateQty(ci.menuItem.id, -1)} className="p-1 rounded-md hover:bg-surface-100">
                        <Minus className="w-3.5 h-3.5" />
                      </button>
                      <span className="text-sm font-semibold min-w-[20px] text-center">{ci.cantidad}</span>
                      <button onClick={() => updateQty(ci.menuItem.id, 1)} className="p-1 rounded-md hover:bg-surface-100">
                        <Plus className="w-3.5 h-3.5" />
                      </button>
                    </div>
                  </div>
                ))
              )}
            </div>

            {/* Notas + Total */}
            <div className="p-4 border-t border-surface-200 space-y-3">
              <Input
                placeholder="Notas generales del pedido..."
                value={notasGenerales}
                onChange={e => setNotasGenerales(e.target.value)}
              />
              <div className="flex items-center justify-between text-lg font-bold text-surface-900">
                <span>Total</span>
                <span>{formatPrecio(total)}</span>
              </div>
              <Button
                variant="default"
                size="lg"
                className="w-full"
                disabled={cart.length === 0}
                onClick={() => {
                  onConfirm(cart, notasGenerales);
                  setCart([]);
                  setNotasGenerales('');
                  onClose();
                }}
              >
                Confirmar Pedido
              </Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
