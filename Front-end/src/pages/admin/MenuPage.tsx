import React, { useState, useEffect } from 'react';
import { PageContainer } from '../../layouts/PageContainer';
import { Card, CardHeader, CardTitle, CardContent } from '../../components/ui/Card';
import { Button } from '../../components/ui/Button';
import { Input } from '../../components/ui/Input';
import { apiMenu, apiCategorias } from '../../api/axios';
import { BookOpen, Plus, Edit3, Trash2, CheckCircle2, XCircle, Loader2, DollarSign, Image } from 'lucide-react';

interface MenuItem {
  id: number;
  nombre: string;
  descripcion: string;
  precio: number;
  imagenUrl: string;
  disponible: boolean;
  categoriaId: number;
  categoriaNombre: string;
  creadoEn?: string;
  actualizadoEn?: string;
}

interface Categoria {
  id: number;
  nombre: string;
  activa: boolean;
}

export const MenuPage: React.FC = () => {
  const [items, setItems] = useState<MenuItem[]>([]);
  const [categorias, setCategorias] = useState<Categoria[]>([]);
  const [loading, setLoading] = useState(false);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [error, setError] = useState('');
  
  // Estado del formulario
  const [selectedId, setSelectedId] = useState<number | null>(null);
  const [nombre, setNombre] = useState('');
  const [descripcion, setDescripcion] = useState('');
  const [precio, setPrecio] = useState('');
  const [imagenUrl, setImagenUrl] = useState('');
  const [categoriaId, setCategoriaId] = useState('');
  const [submitting, setSubmitting] = useState(false);

  useEffect(() => {
    fetchInitialData();
  }, []);

  const fetchInitialData = async () => {
    setLoading(true);
    setError('');
    try {
      // 1. Cargar Categorías activas
      const catRes = await apiCategorias.get('/todas');
      const activeCats = Array.isArray(catRes.data) ? catRes.data.filter((c: Categoria) => c.activa) : [];
      setCategorias(activeCats);
      if (activeCats.length > 0) {
        setCategoriaId(activeCats[0].id.toString());
      }

      // 2. Cargar Ítems del menú
      const menuRes = await apiMenu.get('/');
      setItems(Array.isArray(menuRes.data) ? menuRes.data : []);
    } catch (err: any) {
      console.error('Error fetching initial menu data:', err);
      setError(err.message || 'Error al conectar con los microservicios');
      
      // Fallback estático de resguardo si hay fallas de red
      setCategorias([
        { id: 1, nombre: 'Hamburguesas', activa: true },
        { id: 2, nombre: 'Pizzas', activa: true },
        { id: 3, nombre: 'Acompañamientos', activa: true },
        { id: 4, nombre: 'Bebidas', activa: true }
      ]);
      setCategoriaId('1');
      setItems([
        { id: 1, nombre: 'Hamburguesa Clásica', descripcion: 'Carne 200g, queso cheddar, lechuga, tomate', precio: 8500, disponible: true, categoriaId: 1, categoriaNombre: 'Hamburguesas', imagenUrl: '' },
        { id: 2, nombre: 'Pizza Margarita', descripcion: 'Salsa de tomate, mozzarella, albahaca', precio: 9800, disponible: true, categoriaId: 2, categoriaNombre: 'Pizzas', imagenUrl: '' },
        { id: 3, nombre: 'Coca-Cola 500ml', descripcion: 'Bebida gaseosa', precio: 2000, disponible: false, categoriaId: 4, categoriaNombre: 'Bebidas', imagenUrl: '' }
      ]);
    } finally {
      setLoading(false);
    }
  };

  const handleOpenCreateModal = () => {
    setSelectedId(null);
    setNombre('');
    setDescripcion('');
    setPrecio('');
    setImagenUrl('');
    if (categorias.length > 0) {
      setCategoriaId(categorias[0].id.toString());
    }
    setError('');
    setIsModalOpen(true);
  };

  const handleOpenEditModal = (item: MenuItem) => {
    setSelectedId(item.id);
    setNombre(item.nombre);
    setDescripcion(item.descripcion);
    setPrecio(item.precio.toString());
    setImagenUrl(item.imagenUrl || '');
    setCategoriaId(item.categoriaId.toString());
    setError('');
    setIsModalOpen(true);
  };

  const handleToggleDisponibilidad = async (id: number, currentEstado: boolean) => {
    try {
      const nuevoEstado = !currentEstado;
      const response = await apiMenu.patch(`/${id}/disponibilidad`, null, {
        params: { disponible: nuevoEstado }
      });
      
      // Actualizamos la lista local
      setItems(prev => prev.map(m => m.id === id ? response.data : m));
    } catch (err: any) {
      console.error('Error toggling menu item status:', err);
      // Fallback local instantáneo
      setItems(prev => prev.map(m => m.id === id ? { ...m, disponible: !currentEstado } : m));
    }
  };

  const handleDelete = async (id: number) => {
    if (!window.confirm('¿Está seguro de que desea eliminar este plato del menú? El plato será marcado como eliminado (soft delete).')) return;
    
    try {
      await apiMenu.delete(`/${id}`);
      setItems(prev => prev.filter(m => m.id !== id));
    } catch (err: any) {
      console.error('Error deleting menu item:', err);
      alert(err.response?.data?.mensaje || err.message || 'Error al eliminar el plato del menú');
      // Fallback local instantáneo para demo
      setItems(prev => prev.filter(m => m.id !== id));
    }
  };

  const handleSave = async (e: React.FormEvent) => {
    e.preventDefault();
    setSubmitting(true);
    setError('');

    const payload = {
      nombre,
      descripcion,
      precio: parseFloat(precio),
      imagenUrl,
      categoriaId: parseInt(categoriaId, 10),
      disponible: selectedId ? undefined : true // Por defecto true al crear
    };

    try {
      let response: any;
      if (selectedId) {
        // Actualización
        response = await apiMenu.put(`/${selectedId}`, payload);
        setItems(prev => prev.map(m => m.id === selectedId ? response.data : m));
      } else {
        // Creación
        response = await apiMenu.post('/', payload);
        setItems(prev => [...prev, response.data]);
      }
      setIsModalOpen(false);
    } catch (err: any) {
      console.error('Error saving menu item:', err);
      setError(err.response?.data?.mensaje || err.response?.data?.message || err.message || 'Error al guardar los datos del plato');
    } finally {
      setSubmitting(false);
    }
  };

  const formatPrecio = (val: number) => {
    return new Intl.NumberFormat('es-CL', { style: 'currency', currency: 'CLP' }).format(val);
  };

  return (
    <PageContainer>
      <div className="flex items-center justify-between mb-6">
        <div>
          <h1 className="text-2xl font-bold text-surface-900 flex items-center gap-2">
            <BookOpen className="w-6 h-6 text-primary-500" />
            Catálogo de Platos y Menú
          </h1>
          <p className="text-surface-500">Administra los platos, tragos, precios de venta y disponibilidad por categoría.</p>
        </div>
        <Button onClick={handleOpenCreateModal} className="shadow-lg shadow-primary-500/10 hover:shadow-primary-500/20 transition-all duration-200" disabled={categorias.length === 0}>
          <Plus className="w-4 h-4 mr-2" />
          Nuevo Plato
        </Button>
      </div>

      {categorias.length === 0 && !loading && (
        <div className="bg-yellow-500/10 border border-yellow-500/25 text-yellow-200 text-sm rounded-xl p-4 mb-6">
          ⚠️ Debe crear y activar al menos una **Categoría** antes de registrar platos en el menú.
        </div>
      )}

      {error && !isModalOpen && (
        <div className="bg-red-500/10 border border-red-500/25 text-red-200 text-sm rounded-xl p-4 mb-6 animate-in fade-in duration-200">
          {error}
        </div>
      )}

      <Card className="overflow-hidden border border-white/5 bg-surface-900/40 backdrop-blur-md">
        <CardContent className="p-0">
          {loading ? (
            <div className="flex flex-col items-center justify-center py-16 gap-3">
              <Loader2 className="w-8 h-8 text-primary-500 animate-spin" />
              <p className="text-sm text-surface-400">Consultando ms-menu...</p>
            </div>
          ) : items.length === 0 ? (
            <div className="text-center py-16">
              <BookOpen className="w-12 h-12 text-surface-600 mx-auto mb-3" />
              <p className="text-surface-400">No hay platos registrados en el menú.</p>
            </div>
          ) : (
            <div className="overflow-x-auto">
              <table className="w-full text-left border-collapse">
                <thead>
                  <tr className="border-b border-white/5 bg-white/[0.02]">
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Plato</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Categoría</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Precio</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Disponibilidad</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider text-right">Acciones</th>
                  </tr>
                </thead>
                <tbody className="divide-y divide-white/5">
                  {items.map((item) => (
                    <tr key={item.id} className="hover:bg-white/[0.01] transition-all duration-150">
                      <td className="px-6 py-4">
                        <div className="flex items-center gap-3">
                          {item.imagenUrl ? (
                            <img src={item.imagenUrl} alt={item.nombre} className="h-10 w-10 rounded-xl object-cover border border-white/10 shrink-0" />
                          ) : (
                            <div className="h-10 w-10 rounded-xl bg-surface-800 border border-white/5 flex items-center justify-center text-surface-400 shrink-0">
                              <Image className="w-5 h-5" />
                            </div>
                          )}
                          <div>
                            <p className="text-sm font-semibold text-white">{item.nombre}</p>
                            <p className="text-xs text-surface-500 max-w-xs truncate">{item.descripcion || 'Sin descripción'}</p>
                          </div>
                        </div>
                      </td>
                      <td className="px-6 py-4">
                        <span className="text-xs font-semibold px-2.5 py-1 rounded-lg bg-white/5 text-surface-300 border border-white/10">
                          {item.categoriaNombre}
                        </span>
                      </td>
                      <td className="px-6 py-4 text-sm font-bold text-white">
                        {formatPrecio(item.precio)}
                      </td>
                      <td className="px-6 py-4">
                        <button
                          onClick={() => handleToggleDisponibilidad(item.id, item.disponible)}
                          className="focus:outline-none group"
                          title={item.disponible ? 'Marcar como No Disponible' : 'Marcar como Disponible'}
                        >
                          {item.disponible ? (
                            <div className="flex items-center gap-1.5 text-green-400 bg-green-500/10 px-2.5 py-1 rounded-full border border-green-500/20 text-xs font-semibold hover:bg-green-500/25 transition-all duration-200">
                              <CheckCircle2 className="w-3.5 h-3.5" />
                              <span>Disponible</span>
                            </div>
                          ) : (
                            <div className="flex items-center gap-1.5 text-surface-400 bg-surface-800 px-2.5 py-1 rounded-full border border-white/5 text-xs font-semibold hover:bg-surface-700 transition-all duration-200">
                              <XCircle className="w-3.5 h-3.5" />
                              <span>Agotado</span>
                            </div>
                          )}
                        </button>
                      </td>
                      <td className="px-6 py-4 text-right">
                        <div className="flex items-center justify-end gap-2">
                          <Button 
                            variant="ghost" 
                            size="sm" 
                            onClick={() => handleOpenEditModal(item)}
                            className="h-9 w-9 p-0 hover:bg-white/5 text-surface-300 hover:text-white"
                          >
                            <Edit3 className="w-4 h-4" />
                          </Button>
                          <Button 
                            variant="ghost" 
                            size="sm" 
                            onClick={() => handleDelete(item.id)}
                            className="h-9 w-9 p-0 hover:bg-red-500/10 text-red-400 hover:text-red-300"
                          >
                            <Trash2 className="w-4 h-4" />
                          </Button>
                        </div>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          )}
        </CardContent>
      </Card>

      {/* Modal CRUD de Plato */}
      {isModalOpen && (
        <div className="fixed inset-0 z-[100] flex items-center justify-center p-4 bg-surface-950/60 backdrop-blur-sm animate-in fade-in duration-200">
          <Card className="w-full max-w-md shadow-2xl border border-white/10 bg-surface-900/90 backdrop-blur-xl animate-in zoom-in-95 duration-200">
            <CardHeader className="border-b border-white/5 pb-4">
              <CardTitle className="text-lg font-bold text-white flex items-center gap-2">
                <BookOpen className="w-5 h-5 text-primary-400" />
                {selectedId ? 'Editar Plato del Menú' : 'Nuevo Plato'}
              </CardTitle>
            </CardHeader>
            <CardContent className="pt-6">
              {error && (
                <div className="bg-red-500/10 border border-red-500/20 text-red-200 text-xs rounded-lg p-3 mb-4">
                  {error}
                </div>
              )}
              <form onSubmit={handleSave} className="space-y-4">
                <div className="grid grid-cols-2 gap-4">
                  <div className="space-y-2">
                    <label htmlFor="plato-nombre" className="text-sm font-semibold text-surface-200">
                      Nombre del Plato
                    </label>
                    <Input 
                      id="plato-nombre"
                      value={nombre} 
                      onChange={(e) => setNombre(e.target.value)} 
                      placeholder="ej: Lomo a lo Pobre" 
                      required 
                      minLength={2}
                      maxLength={100}
                      disabled={submitting}
                      className="bg-white/5 border-white/10 text-white placeholder:text-surface-500 focus-visible:ring-primary-500"
                    />
                  </div>

                  <div className="space-y-2">
                    <label htmlFor="plato-precio" className="text-sm font-semibold text-surface-200">
                      Precio de Venta (CLP)
                    </label>
                    <div className="relative">
                      <DollarSign className="absolute left-3 top-3 w-4 h-4 text-surface-500" />
                      <Input 
                        id="plato-precio"
                        type="number"
                        value={precio} 
                        onChange={(e) => setPrecio(e.target.value)} 
                        placeholder="8500" 
                        required 
                        min={1}
                        disabled={submitting}
                        className="pl-9 bg-white/5 border-white/10 text-white placeholder:text-surface-500 focus-visible:ring-primary-500"
                      />
                    </div>
                  </div>
                </div>

                <div className="space-y-2">
                  <label htmlFor="plato-categoria" className="text-sm font-semibold text-surface-200">
                    Categoría
                  </label>
                  <select 
                    id="plato-categoria"
                    value={categoriaId}
                    onChange={(e) => setCategoriaId(e.target.value)}
                    disabled={submitting}
                    className="w-full h-10 px-3 rounded-lg bg-surface-800 border border-white/10 text-white focus:ring-2 focus:ring-primary-500 outline-none transition-all"
                  >
                    {categorias.map(c => (
                      <option key={c.id} value={c.id}>{c.nombre}</option>
                    ))}
                  </select>
                </div>

                <div className="space-y-2">
                  <label htmlFor="plato-descripcion" className="text-sm font-semibold text-surface-200">
                    Descripción del Plato
                  </label>
                  <Input 
                    id="plato-descripcion"
                    value={descripcion} 
                    onChange={(e) => setDescripcion(e.target.value)} 
                    placeholder="ej: Lomo liso con papas fritas, huevo frito y cebolla frita" 
                    maxLength={1000}
                    disabled={submitting}
                    className="bg-white/5 border-white/10 text-white placeholder:text-surface-500 focus-visible:ring-primary-500"
                  />
                </div>

                <div className="space-y-2">
                  <label htmlFor="plato-imagen" className="text-sm font-semibold text-surface-200">
                    URL de la Imagen (CDN)
                  </label>
                  <Input 
                    id="plato-imagen"
                    value={imagenUrl} 
                    onChange={(e) => setImagenUrl(e.target.value)} 
                    placeholder="ej: https://images.unsplash.com/photo-1544025162-d76694265947" 
                    maxLength={500}
                    disabled={submitting}
                    className="bg-white/5 border-white/10 text-white placeholder:text-surface-500 focus-visible:ring-primary-500"
                  />
                </div>

                <div className="flex justify-end gap-3 mt-6 pt-4 border-t border-white/5">
                  <Button variant="outline" type="button" onClick={() => setIsModalOpen(false)} disabled={submitting}>
                    Cancelar
                  </Button>
                  <Button type="submit" disabled={submitting} className="shadow-lg shadow-primary-500/10">
                    {submitting ? (
                      <>
                        <Loader2 className="w-4 h-4 mr-2 animate-spin" />
                        Guardando...
                      </>
                    ) : (
                      'Guardar Plato'
                    )}
                  </Button>
                </div>
              </form>
            </CardContent>
          </Card>
        </div>
      )}
    </PageContainer>
  );
};

export default MenuPage;
