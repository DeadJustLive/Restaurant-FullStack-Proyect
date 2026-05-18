import React, { useState, useEffect } from 'react';
import { PageContainer } from '../../layouts/PageContainer';
import { Card, CardHeader, CardTitle, CardContent } from '../../components/ui/Card';
import { Button } from '../../components/ui/Button';
import { Input } from '../../components/ui/Input';
import { apiSucursales } from '../../api/axios';
import { Store, MapPin, Phone, Plus, Edit3, CheckCircle2, XCircle, Loader2 } from 'lucide-react';

interface Sucursal {
  id: number;
  nombre: string;
  direccion: string;
  telefono: string;
  activa: boolean;
  creadoEn?: string;
  actualizadoEn?: string;
}

export const SucursalesPage: React.FC = () => {
  const [sucursales, setSucursales] = useState<Sucursal[]>([]);
  const [loading, setLoading] = useState(false);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [error, setError] = useState('');
  
  // Estado del formulario
  const [selectedId, setSelectedId] = useState<number | null>(null);
  const [nombre, setNombre] = useState('');
  const [direccion, setDireccion] = useState('');
  const [telefono, setTelefono] = useState('');
  const [submitting, setSubmitting] = useState(false);

  useEffect(() => {
    fetchSucursales();
  }, []);

  const fetchSucursales = async () => {
    setLoading(true);
    setError('');
    try {
      // Listamos todas las sucursales (activas e inactivas) para el panel de administración
      const response = await apiSucursales.get('/todas');
      setSucursales(Array.isArray(response.data) ? response.data : []);
    } catch (err: any) {
      console.error('Error fetching sucursales:', err);
      setError(err.message || 'Error al conectar con el microservicio ms-sucursales');
      
      // Fallback estático de resguardo si hay fallas de red
      setSucursales([
        { 
          id: 1, 
          nombre: 'Sucursal Providencia', 
          direccion: 'Av. Providencia 1234, Santiago', 
          telefono: '+56 2 2345 6789', 
          activa: true 
        },
        { 
          id: 2, 
          nombre: 'Sucursal Costanera', 
          direccion: 'Av. Andrés Bello 2425, Providencia', 
          telefono: '+56 2 2345 6790', 
          activa: true 
        }
      ]);
    } finally {
      setLoading(false);
    }
  };

  const handleOpenCreateModal = () => {
    setSelectedId(null);
    setNombre('');
    setDireccion('');
    setTelefono('');
    setError('');
    setIsModalOpen(true);
  };

  const handleOpenEditModal = (suc: Sucursal) => {
    setSelectedId(suc.id);
    setNombre(suc.nombre);
    setDireccion(suc.direccion);
    setTelefono(suc.telefono);
    setError('');
    setIsModalOpen(true);
  };

  const handleToggleEstado = async (id: number, currentEstado: boolean) => {
    try {
      const nuevoEstado = !currentEstado;
      const response = await apiSucursales.patch(`/${id}/estado`, null, {
        params: { activa: nuevoEstado }
      });
      
      // Actualizamos la lista local con la respuesta del microservicio
      setSucursales(prev => prev.map(s => s.id === id ? response.data : s));
    } catch (err: any) {
      console.error('Error toggling sucursal status:', err);
      // Fallback local instantáneo si falla
      setSucursales(prev => prev.map(s => s.id === id ? { ...s, activa: !currentEstado } : s));
    }
  };

  const handleSave = async (e: React.FormEvent) => {
    e.preventDefault();
    setSubmitting(true);
    setError('');

    const payload = { nombre, direccion, telefono };

    try {
      let response: any;
      if (selectedId) {
        // Actualización
        response = await apiSucursales.put(`/${selectedId}`, payload);
        setSucursales(prev => prev.map(s => s.id === selectedId ? response.data : s));
      } else {
        // Creación
        response = await apiSucursales.post('/', payload);
        setSucursales(prev => [...prev, response.data]);
      }
      setIsModalOpen(false);
    } catch (err: any) {
      console.error('Error saving sucursal:', err);
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
            <Store className="w-6 h-6 text-primary-500" />
            Gestión de Sucursales
          </h1>
          <p className="text-surface-500">Administra los locales del SaaS, direcciones de atención y estados de operación.</p>
        </div>
        <Button onClick={handleOpenCreateModal} className="shadow-lg shadow-primary-500/10 hover:shadow-primary-500/20 transition-all duration-200">
          <Plus className="w-4 h-4 mr-2" />
          Nueva Sucursal
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
              <p className="text-sm text-surface-400">Consultando ms-sucursales...</p>
            </div>
          ) : sucursales.length === 0 ? (
            <div className="text-center py-16">
              <Store className="w-12 h-12 text-surface-600 mx-auto mb-3" />
              <p className="text-surface-400">No hay sucursales registradas en el sistema.</p>
            </div>
          ) : (
            <div className="overflow-x-auto">
              <table className="w-full text-left border-collapse">
                <thead>
                  <tr className="border-b border-white/5 bg-white/[0.02]">
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Local</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Dirección</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Teléfono</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Estado</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider text-right">Acciones</th>
                  </tr>
                </thead>
                <tbody className="divide-y divide-white/5">
                  {sucursales.map((suc) => (
                    <tr key={suc.id} className="hover:bg-white/[0.01] transition-all duration-150">
                      <td className="px-6 py-4">
                        <div className="flex items-center gap-3">
                          <div className={`h-10 w-10 rounded-xl flex items-center justify-center font-bold transition-all duration-200 ${
                            suc.activa ? 'bg-primary-500/10 text-primary-400 border border-primary-500/20' : 'bg-surface-800 text-surface-400 border border-white/5'
                          }`}>
                            <Store className="w-5 h-5" />
                          </div>
                          <div>
                            <p className="text-sm font-semibold text-white">{suc.nombre}</p>
                            <p className="text-xs text-surface-500">ID: {suc.id}</p>
                          </div>
                        </div>
                      </td>
                      <td className="px-6 py-4 text-sm text-surface-200">
                        <div className="flex items-center gap-2">
                          <MapPin className="w-4 h-4 text-surface-500 shrink-0" />
                          <span>{suc.direccion}</span>
                        </div>
                      </td>
                      <td className="px-6 py-4 text-sm text-surface-200">
                        {suc.telefono ? (
                          <div className="flex items-center gap-2">
                            <Phone className="w-4 h-4 text-surface-500 shrink-0" />
                            <span>{suc.telefono}</span>
                          </div>
                        ) : (
                          <span className="text-surface-600">—</span>
                        )}
                      </td>
                      <td className="px-6 py-4">
                        <button
                          onClick={() => handleToggleEstado(suc.id, suc.activa)}
                          className="focus:outline-none group"
                          title={suc.activa ? 'Desactivar Sucursal' : 'Activar Sucursal'}
                        >
                          {suc.activa ? (
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
                          onClick={() => handleOpenEditModal(suc)}
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

      {/* Modal CRUD de Sucursal */}
      {isModalOpen && (
        <div className="fixed inset-0 z-[100] flex items-center justify-center p-4 bg-surface-950/60 backdrop-blur-sm animate-in fade-in duration-200">
          <Card className="w-full max-w-md shadow-2xl border border-white/10 bg-surface-900/90 backdrop-blur-xl animate-in zoom-in-95 duration-200">
            <CardHeader className="border-b border-white/5 pb-4">
              <CardTitle className="text-lg font-bold text-white flex items-center gap-2">
                <Store className="w-5 h-5 text-primary-400" />
                {selectedId ? 'Editar Sucursal' : 'Nueva Sucursal'}
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
                  <label htmlFor="sucursal-nombre" className="text-sm font-semibold text-surface-200">
                    Nombre del Local
                  </label>
                  <Input 
                    id="sucursal-nombre"
                    value={nombre} 
                    onChange={(e) => setNombre(e.target.value)} 
                    placeholder="ej: Sucursal Costanera" 
                    required 
                    minLength={3}
                    maxLength={100}
                    disabled={submitting}
                    className="bg-white/5 border-white/10 text-white placeholder:text-surface-500 focus-visible:ring-primary-500"
                  />
                </div>

                <div className="space-y-2">
                  <label htmlFor="sucursal-direccion" className="text-sm font-semibold text-surface-200">
                    Dirección Completa
                  </label>
                  <Input 
                    id="sucursal-direccion"
                    value={direccion} 
                    onChange={(e) => setDireccion(e.target.value)} 
                    placeholder="ej: Av. Andrés Bello 2425, Las Condes" 
                    required 
                    minLength={5}
                    maxLength={255}
                    disabled={submitting}
                    className="bg-white/5 border-white/10 text-white placeholder:text-surface-500 focus-visible:ring-primary-500"
                  />
                </div>

                <div className="space-y-2">
                  <label htmlFor="sucursal-telefono" className="text-sm font-semibold text-surface-200">
                    Teléfono de Contacto
                  </label>
                  <Input 
                    id="sucursal-telefono"
                    value={telefono} 
                    onChange={(e) => setTelefono(e.target.value)} 
                    placeholder="ej: +56 2 2345 6789" 
                    maxLength={20}
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
                      'Guardar Sucursal'
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

export default SucursalesPage;
