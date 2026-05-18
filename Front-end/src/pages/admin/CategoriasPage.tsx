import React, { useState, useEffect } from 'react';
import { PageContainer } from '../../layouts/PageContainer';
import { Card, CardHeader, CardTitle, CardContent } from '../../components/ui/Card';
import { Button } from '../../components/ui/Button';
import { Input } from '../../components/ui/Input';
import { apiCategorias } from '../../api/axios';
import { Layers, Tag, Plus, Edit3, CheckCircle2, XCircle, Loader2 } from 'lucide-react';

interface Categoria {
  id: number;
  nombre: string;
  descripcion: string;
  activa: boolean;
  creadoEn?: string;
  actualizadoEn?: string;
}

export const CategoriasPage: React.FC = () => {
  const [categorias, setCategorias] = useState<Categoria[]>([]);
  const [loading, setLoading] = useState(false);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [error, setError] = useState('');
  
  // Estado del formulario
  const [selectedId, setSelectedId] = useState<number | null>(null);
  const [nombre, setNombre] = useState('');
  const [descripcion, setDescripcion] = useState('');
  const [submitting, setSubmitting] = useState(false);

  useEffect(() => {
    fetchCategorias();
  }, []);

  const fetchCategorias = async () => {
    setLoading(true);
    setError('');
    try {
      // Listamos todas las categorías (activas e inactivas) para el panel de administración
      const response = await apiCategorias.get('/todas');
      setCategorias(response.data);
    } catch (err: any) {
      console.error('Error fetching categorias:', err);
      setError(err.message || 'Error al conectar con el microservicio ms-menu');
      
      // Fallback estático de resguardo si hay fallas de red
      setCategorias([
        { id: 1, nombre: 'Hamburguesas', descripcion: 'Hamburguesas de vacuno y pollo', activa: true },
        { id: 2, nombre: 'Pizzas', descripcion: 'Pizzas a la piedra', activa: true },
        { id: 3, nombre: 'Acompañamientos', descripcion: 'Papas fritas y ensaladas', activa: true },
        { id: 4, nombre: 'Bebidas', descripcion: 'Gaseosas, jugos y aguas', activa: false }
      ]);
    } finally {
      setLoading(false);
    }
  };

  const handleOpenCreateModal = () => {
    setSelectedId(null);
    setNombre('');
    setDescripcion('');
    setError('');
    setIsModalOpen(true);
  };

  const handleOpenEditModal = (cat: Categoria) => {
    setSelectedId(cat.id);
    setNombre(cat.nombre);
    setDescripcion(cat.descripcion);
    setError('');
    setIsModalOpen(true);
  };

  const handleToggleEstado = async (id: number, currentEstado: boolean) => {
    try {
      const nuevoEstado = !currentEstado;
      const response = await apiCategorias.patch(`/${id}/estado`, null, {
        params: { activa: nuevoEstado }
      });
      
      // Actualizamos la lista local con la respuesta del microservicio
      setCategorias(prev => prev.map(c => c.id === id ? response.data : c));
    } catch (err: any) {
      console.error('Error toggling categoria status:', err);
      // Fallback local instantáneo si falla
      setCategorias(prev => prev.map(c => c.id === id ? { ...c, activa: !currentEstado } : c));
    }
  };

  const handleSave = async (e: React.FormEvent) => {
    e.preventDefault();
    setSubmitting(true);
    setError('');

    const payload = { nombre, descripcion };

    try {
      let response: any;
      if (selectedId) {
        // Actualización
        response = await apiCategorias.put(`/${selectedId}`, payload);
        setCategorias(prev => prev.map(c => c.id === selectedId ? response.data : c));
      } else {
        // Creación
        response = await apiCategorias.post('/', payload);
        setCategorias(prev => [...prev, response.data]);
      }
      setIsModalOpen(false);
    } catch (err: any) {
      console.error('Error saving categoria:', err);
      setError(err.response?.data?.mensaje || err.response?.data?.message || err.message || 'Error al guardar los datos');
    } finally {
      setSubmitting(false);
    }
  };

  return (
    <PageContainer>
      <div className="flex items-center justify-between mb-6">
        <div>
          <h1 className="text-2xl font-bold text-surface-900 flex items-center gap-2">
            <Layers className="w-6 h-6 text-primary-500" />
            Gestión de Categorías
          </h1>
          <p className="text-surface-500">Organiza tus platos y bebidas en categorías del menú principal.</p>
        </div>
        <Button onClick={handleOpenCreateModal} className="shadow-lg shadow-primary-500/10 hover:shadow-primary-500/20 transition-all duration-200">
          <Plus className="w-4 h-4 mr-2" />
          Nueva Categoría
        </Button>
      </div>

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
          ) : categorias.length === 0 ? (
            <div className="text-center py-16">
              <Layers className="w-12 h-12 text-surface-600 mx-auto mb-3" />
              <p className="text-surface-400">No hay categorías registradas en el sistema.</p>
            </div>
          ) : (
            <div className="overflow-x-auto">
              <table className="w-full text-left border-collapse">
                <thead>
                  <tr className="border-b border-white/5 bg-white/[0.02]">
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Categoría</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Descripción</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Estado</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider text-right">Acciones</th>
                  </tr>
                </thead>
                <tbody className="divide-y divide-white/5">
                  {categorias.map((cat) => (
                    <tr key={cat.id} className="hover:bg-white/[0.01] transition-all duration-150">
                      <td className="px-6 py-4">
                        <div className="flex items-center gap-3">
                          <div className={`h-10 w-10 rounded-xl flex items-center justify-center font-bold transition-all duration-200 ${
                            cat.activa ? 'bg-primary-500/10 text-primary-400 border border-primary-500/20' : 'bg-surface-800 text-surface-400 border border-white/5'
                          }`}>
                            <Tag className="w-5 h-5" />
                          </div>
                          <div>
                            <p className="text-sm font-semibold text-white">{cat.nombre}</p>
                            <p className="text-xs text-surface-500">ID: {cat.id}</p>
                          </div>
                        </div>
                      </td>
                      <td className="px-6 py-4 text-sm text-surface-200">
                        {cat.descripcion ? (
                          <span>{cat.descripcion}</span>
                        ) : (
                          <span className="text-surface-600 italic">Sin descripción</span>
                        )}
                      </td>
                      <td className="px-6 py-4">
                        <button
                          onClick={() => handleToggleEstado(cat.id, cat.activa)}
                          className="focus:outline-none group"
                          title={cat.activa ? 'Desactivar Categoría' : 'Activar Categoría'}
                        >
                          {cat.activa ? (
                            <div className="flex items-center gap-1.5 text-green-400 bg-green-500/10 px-2.5 py-1 rounded-full border border-green-500/20 text-xs font-semibold hover:bg-green-500/25 transition-all duration-200">
                              <CheckCircle2 className="w-3.5 h-3.5" />
                              <span>Activa</span>
                            </div>
                          ) : (
                            <div className="flex items-center gap-1.5 text-surface-400 bg-surface-800 px-2.5 py-1 rounded-full border border-white/5 text-xs font-semibold hover:bg-surface-700 transition-all duration-200">
                              <XCircle className="w-3.5 h-3.5" />
                              <span>Inactiva</span>
                            </div>
                          )}
                        </button>
                      </td>
                      <td className="px-6 py-4 text-right">
                        <Button 
                          variant="ghost" 
                          size="sm" 
                          onClick={() => handleOpenEditModal(cat)}
                          className="h-9 w-9 p-0 hover:bg-white/5 text-surface-300 hover:text-white"
                        >
                          <Edit3 className="w-4 h-4" />
                        </Button>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          )}
        </CardContent>
      </Card>

      {/* Modal CRUD de Categoría */}
      {isModalOpen && (
        <div className="fixed inset-0 z-[100] flex items-center justify-center p-4 bg-surface-950/60 backdrop-blur-sm animate-in fade-in duration-200">
          <Card className="w-full max-w-md shadow-2xl border border-white/10 bg-surface-900/90 backdrop-blur-xl animate-in zoom-in-95 duration-200">
            <CardHeader className="border-b border-white/5 pb-4">
              <CardTitle className="text-lg font-bold text-white flex items-center gap-2">
                <Tag className="w-5 h-5 text-primary-400" />
                {selectedId ? 'Editar Categoría' : 'Nueva Categoría'}
              </CardTitle>
            </CardHeader>
            <CardContent className="pt-6">
              {error && (
                <div className="bg-red-500/10 border border-red-500/20 text-red-200 text-xs rounded-lg p-3 mb-4">
                  {error}
                </div>
              )}
              <form onSubmit={handleSave} className="space-y-4">
                <div className="space-y-2">
                  <label htmlFor="categoria-nombre" className="text-sm font-semibold text-surface-200">
                    Nombre de la Categoría
                  </label>
                  <Input 
                    id="categoria-nombre"
                    value={nombre} 
                    onChange={(e) => setNombre(e.target.value)} 
                    placeholder="ej: Hamburguesas" 
                    required 
                    minLength={3}
                    maxLength={100}
                    disabled={submitting}
                    className="bg-white/5 border-white/10 text-white placeholder:text-surface-500 focus-visible:ring-primary-500"
                  />
                </div>

                <div className="space-y-2">
                  <label htmlFor="categoria-descripcion" className="text-sm font-semibold text-surface-200">
                    Descripción
                  </label>
                  <Input 
                    id="categoria-descripcion"
                    value={descripcion} 
                    onChange={(e) => setDescripcion(e.target.value)} 
                    placeholder="ej: Platos elaborados con carne de res de primera" 
                    maxLength={255}
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
                      'Guardar Categoría'
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

export default CategoriasPage;
