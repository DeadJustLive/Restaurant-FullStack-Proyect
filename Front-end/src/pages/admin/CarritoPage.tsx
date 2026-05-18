import React, { useState, useEffect } from 'react';
import { PageContainer } from '../../layouts/PageContainer';
import { Card, CardContent } from '../../components/ui/Card';
import { Button } from '../../components/ui/Button';
import { apiCarrito } from '../../api/axios';
import { useAuth } from '../../contexts/AuthContext';
import { ShoppingCart, Plus, Minus, Trash2, CreditCard, Loader2, ShoppingBag } from 'lucide-react';

interface CarritoItem {
  id: number;
  menuItemId: number;
  precioUnitario: number;
  cantidad: number;
  subtotal: number;
  nombre?: string;
}

interface Carrito {
  id: number;
  usuarioId: number;
  sucursalId: number;
  total: number;
  items: CarritoItem[];
  creadoEn?: string;
  actualizadoEn?: string;
}

const formatPrecio = (val: number) =>
  new Intl.NumberFormat('es-CL', { style: 'currency', currency: 'CLP' }).format(val);

export const CarritoPage: React.FC = () => {
  const { user } = useAuth();
  const [carrito, setCarrito] = useState<Carrito | null>(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  const usuarioId = user?.id ? Number(user.id) : 1;

  const fetchCarrito = async () => {
    setLoading(true);
    setError('');
    try {
      const res = await apiCarrito.get(`/usuario/${usuarioId}`);
      const data = res.data;
      setCarrito(data && typeof data === 'object' && Array.isArray(data.items) ? data : null);
    } catch (err: any) {
      console.error('Error fetching carrito:', err);
      if (err.response?.status !== 404) {
        setError('No se pudo obtener el carrito');
      }
      setCarrito(null);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchCarrito();
  }, []);

  const handleAddItem = async () => {
    const menuItemIdStr = prompt('Ingrese el ID del ítem del menú:');
    const cantidadStr = prompt('Cantidad:', '1');
    if (!menuItemIdStr || !cantidadStr) return;

    const menuItemId = Number(menuItemIdStr);
    const cantidad = Number(cantidadStr);
    if (isNaN(menuItemId) || isNaN(cantidad) || cantidad < 1) return;

    try {
      const res = await apiCarrito.post(`/usuario/${usuarioId}/items`, {
        menuItemId,
        cantidad,
      });
      const data = res.data;
      setCarrito(data && typeof data === 'object' && Array.isArray(data.items) ? data : carrito);
    } catch (err) {
      console.error('Error adding item:', err);
    }
  };

  const handleUpdateQty = async (itemId: number, delta: number) => {
    if (!carrito) return;
    const item = carrito.items.find(i => i.id === itemId);
    if (!item) return;

    const newQty = item.cantidad + delta;
    if (newQty < 1) {
      await handleRemoveItem(itemId);
      return;
    }

    try {
      const res = await apiCarrito.patch(
        `/usuario/${usuarioId}/items/${itemId}?cantidad=${newQty}`
      );
      const data = res.data;
      setCarrito(data && typeof data === 'object' && Array.isArray(data.items) ? data : carrito);
    } catch (err) {
      console.error('Error updating quantity:', err);
    }
  };

  const handleRemoveItem = async (itemId: number) => {
    try {
      const res = await apiCarrito.delete(`/usuario/${usuarioId}/items/${itemId}`);
      const data = res.data;
      setCarrito(data && typeof data === 'object' && Array.isArray(data.items) ? data : carrito);
    } catch (err) {
      console.error('Error removing item:', err);
    }
  };

  const handleClear = async () => {
    if (!window.confirm('¿Vaciar el carrito completo?')) return;
    try {
      await apiCarrito.delete(`/usuario/${usuarioId}`);
      setCarrito(null);
    } catch (err) {
      console.error('Error clearing cart:', err);
    }
  };

  const handleCheckout = async () => {
    alert('Checkout: se integrará con ms-pedidos para crear el pedido desde el carrito.');
  };

  return (
    <PageContainer>
      <div className="flex items-center justify-between mb-6">
        <div>
          <h1 className="text-2xl font-bold text-surface-900 flex items-center gap-2">
            <ShoppingCart className="w-6 h-6 text-primary-500" />
            Carrito de Compras
          </h1>
          <p className="text-surface-500">Gestiona los ítems del carrito antes de generar el pedido.</p>
        </div>
        <Button onClick={handleAddItem} className="shadow-lg shadow-primary-500/10 hover:shadow-primary-500/20 transition-all duration-200">
          <Plus className="w-4 h-4 mr-2" />
          Agregar Ítem
        </Button>
      </div>

      {error && (
        <div className="bg-red-500/10 border border-red-500/25 text-red-200 text-sm rounded-xl p-4 mb-6">
          {error}
        </div>
      )}

      <Card className="border border-white/5 bg-surface-900/40 backdrop-blur-md">
        <CardContent className="p-0">
          {loading ? (
            <div className="flex flex-col items-center justify-center py-16 gap-3">
              <Loader2 className="w-8 h-8 text-primary-500 animate-spin" />
              <p className="text-sm text-surface-400">Cargando carrito...</p>
            </div>
          ) : !carrito || carrito.items.length === 0 ? (
            <div className="text-center py-16">
              <ShoppingBag className="w-12 h-12 text-surface-600 mx-auto mb-3" />
              <p className="text-surface-400">El carrito está vacío.</p>
              <p className="text-xs text-surface-500 mt-1">Agregue ítems desde el menú para comenzar.</p>
            </div>
          ) : (
            <div className="overflow-x-auto">
              <table className="w-full text-left border-collapse">
                <thead>
                  <tr className="border-b border-white/5 bg-white/[0.02]">
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Ítem</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider text-center">Cantidad</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider text-right">Precio Unit.</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider text-right">Subtotal</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider text-right">Acciones</th>
                  </tr>
                </thead>
                <tbody className="divide-y divide-white/5">
                  {carrito.items.map((item) => (
                    <tr key={item.id} className="hover:bg-white/[0.01] transition-all duration-150">
                      <td className="px-6 py-4">
                        <div className="flex items-center gap-3">
                          <div className="h-10 w-10 rounded-xl bg-primary-500/10 border border-primary-500/20 flex items-center justify-center text-primary-400 font-bold">
                            <ShoppingBag className="w-5 h-5" />
                          </div>
                          <div>
                            <p className="text-sm font-semibold text-white">Ítem #{item.menuItemId}</p>
                            {item.nombre && <p className="text-xs text-surface-500">{item.nombre}</p>}
                          </div>
                        </div>
                      </td>
                      <td className="px-6 py-4">
                        <div className="flex items-center justify-center gap-2">
                          <button onClick={() => handleUpdateQty(item.id, -1)} className="p-1 rounded-md hover:bg-white/5 text-surface-300 hover:text-white transition-all">
                            <Minus className="w-3.5 h-3.5" />
                          </button>
                          <span className="text-sm font-bold text-white min-w-[24px] text-center">{item.cantidad}</span>
                          <button onClick={() => handleUpdateQty(item.id, 1)} className="p-1 rounded-md hover:bg-white/5 text-surface-300 hover:text-white transition-all">
                            <Plus className="w-3.5 h-3.5" />
                          </button>
                        </div>
                      </td>
                      <td className="px-6 py-4 text-sm text-surface-200 text-right">
                        {formatPrecio(item.precioUnitario)}
                      </td>
                      <td className="px-6 py-4 text-sm font-bold text-white text-right">
                        {formatPrecio(item.subtotal)}
                      </td>
                      <td className="px-6 py-4 text-right">
                        <Button variant="ghost" size="sm" onClick={() => handleRemoveItem(item.id)} className="h-9 w-9 p-0 hover:bg-red-500/10 text-red-400 hover:text-red-300">
                          <Trash2 className="w-4 h-4" />
                        </Button>
                      </td>
                    </tr>
                  ))}
                </tbody>
                <tfoot>
                  <tr className="border-t-2 border-primary-500/20 bg-white/[0.02]">
                    <td colSpan={3} className="px-6 py-4 text-sm font-bold text-white text-right">Total</td>
                    <td className="px-6 py-4 text-lg font-bold text-primary-400 text-right">{formatPrecio(carrito.total)}</td>
                    <td />
                  </tr>
                </tfoot>
              </table>
            </div>
          )}
        </CardContent>
      </Card>

      {carrito && carrito.items.length > 0 && (
        <div className="flex justify-end gap-3 mt-4">
          <Button variant="outline" onClick={handleClear} className="text-red-400 border-red-500/20 hover:bg-red-500/10 hover:text-red-300">
            <Trash2 className="w-4 h-4 mr-2" />
            Vaciar Carrito
          </Button>
          <Button onClick={handleCheckout} className="shadow-lg shadow-primary-500/10">
            <CreditCard className="w-4 h-4 mr-2" />
            Generar Pedido
          </Button>
        </div>
      )}
    </PageContainer>
  );
};

export default CarritoPage;