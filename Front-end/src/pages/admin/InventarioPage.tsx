import React, { useState, useEffect } from 'react';
import { PageContainer } from '../../layouts/PageContainer';
import { Card, CardHeader, CardTitle, CardContent } from '../../components/ui/Card';
import { Button } from '../../components/ui/Button';
import { Input } from '../../components/ui/Input';
import { apiInventario, apiSucursales } from '../../api/axios';
import { 
  ClipboardList, Plus, Edit3, TrendingUp, TrendingDown, 
  History, AlertTriangle, Loader2, RefreshCw 
} from 'lucide-react';

interface Insumo {
  id: number;
  sucursalId: number;
  nombre: string;
  unidadMedida: string;
  stockActual: number;
  stockMinimo: number;
  creadoEn?: string;
  actualizadoEn?: string;
}

interface Sucursal {
  id: number;
  nombre: string;
  activa: boolean;
}

interface Movimiento {
  id: number;
  insumoId: number;
  tipo: 'ENTRADA' | 'SALIDA';
  cantidad: number;
  referencia: string;
  creadoEn: string;
}

export const InventarioPage: React.FC = () => {
  const [insumos, setInsumos] = useState<Insumo[]>([]);
  const [sucursales, setSucursales] = useState<Sucursal[]>([]);
  const [activeSucursalId, setActiveSucursalId] = useState<number>(1);
  const [loading, setLoading] = useState(false);
  const [loadingKardex, setLoadingKardex] = useState(false);
  const [error, setError] = useState('');
  
  // Modales
  const [isCRUDModalOpen, setIsCRUDModalOpen] = useState(false);
  const [isAjustarModalOpen, setIsAjustarModalOpen] = useState(false);
  const [isKardexModalOpen, setIsKardexModalOpen] = useState(false);
  
  // Formulario CRUD
  const [selectedId, setSelectedId] = useState<number | null>(null);
  const [nombre, setNombre] = useState('');
  const [unidadMedida, setUnidadMedida] = useState('Unidades');
  const [stockMinimo, setStockMinimo] = useState('');
  const [submitting, setSubmitting] = useState(false);

  // Formulario Ajuste Stock (Movimiento)
  const [selectedInsumo, setSelectedInsumo] = useState<Insumo | null>(null);
  const [tipoMovimiento, setTipoMovimiento] = useState<'ENTRADA' | 'SALIDA'>('ENTRADA');
  const [cantidadAjuste, setCantidadAjuste] = useState('');
  const [referenciaAjuste, setReferenciaAjuste] = useState('');
  const [adjusting, setAdjusting] = useState(false);

  // Historial Kardex
  const [kardexList, setKardexList] = useState<Movimiento[]>([]);

  useEffect(() => {
    fetchInitialData();
  }, []);

  useEffect(() => {
    if (activeSucursalId) {
      fetchInsumos(activeSucursalId);
    }
  }, [activeSucursalId]);

  const fetchInitialData = async () => {
    setError('');
    try {
      // 1. Cargar Sucursales activas
      const sucRes = await apiSucursales.get('/todas');
      const activeSucs = Array.isArray(sucRes.data) ? sucRes.data.filter((s: Sucursal) => s.activa) : [];
      setSucursales(activeSucs);
      if (activeSucs.length > 0) {
        setActiveSucursalId(activeSucs[0].id);
      }
    } catch (err: any) {
      console.error('Error fetching sucursales:', err);
      // Fallback
      setSucursales([
        { id: 1, nombre: 'Sucursal Providencia', activa: true },
        { id: 2, nombre: 'Sucursal Costanera', activa: true }
      ]);
      setActiveSucursalId(1);
    }
  };

  const fetchInsumos = async (sucId: number) => {
    setLoading(true);
    setError('');
    try {
      const response = await apiInventario.get(`/insumos/sucursal/${sucId}`);
      setInsumos(Array.isArray(response.data) ? response.data : []);
    } catch (err: any) {
      console.error('Error fetching insumos:', err);
      setError(err.message || 'Error al conectar con el microservicio ms-inventario');
      
      // Fallback estático
      setInsumos([
        { id: 1, sucursalId: 1, nombre: 'Pan de Hamburguesa', unidadMedida: 'Unidades', stockActual: 120, stockMinimo: 20 },
        { id: 2, sucursalId: 1, nombre: 'Carne de Vacuno 200g', unidadMedida: 'Unidades', stockActual: 45, stockMinimo: 15 },
        { id: 3, sucursalId: 1, nombre: 'Queso Cheddar', unidadMedida: 'Kg', stockActual: 4.5, stockMinimo: 5.0 }, // Stock bajo
        { id: 4, sucursalId: 2, nombre: 'Papas Prefritas', unidadMedida: 'Kg', stockActual: 60, stockMinimo: 10 }
      ].filter(i => i.sucursalId === sucId));
    } finally {
      setLoading(false);
    }
  };

  const handleOpenCreateModal = () => {
    setSelectedId(null);
    setNombre('');
    setUnidadMedida('Unidades');
    setStockMinimo('');
    setError('');
    setIsCRUDModalOpen(true);
  };

  const handleOpenEditModal = (ins: Insumo) => {
    setSelectedId(ins.id);
    setNombre(ins.nombre);
    setUnidadMedida(ins.unidadMedida);
    setStockMinimo(ins.stockMinimo.toString());
    setError('');
    setIsCRUDModalOpen(true);
  };

  const handleOpenAjustarModal = (ins: Insumo) => {
    setSelectedInsumo(ins);
    setTipoMovimiento('ENTRADA');
    setCantidadAjuste('');
    setReferenciaAjuste('');
    setError('');
    setIsAjustarModalOpen(true);
  };

  const handleOpenKardexModal = async (ins: Insumo) => {
    setSelectedInsumo(ins);
    setKardexList([]);
    setLoadingKardex(true);
    setIsKardexModalOpen(true);
    setError('');
    try {
      const response = await apiInventario.get(`/insumos/${ins.id}/kardex`);
      setKardexList(response.data);
    } catch (err: any) {
      console.error('Error fetching kardex history:', err);
      // Fallback
      setKardexList([
        { id: 1, insumoId: ins.id, tipo: 'ENTRADA', cantidad: 50, referencia: 'Carga inicial', creadoEn: new Date().toISOString() },
        { id: 2, insumoId: ins.id, tipo: 'SALIDA', cantidad: 12, referencia: 'Consumo por menú', creadoEn: new Date().toISOString() }
      ]);
    } finally {
      setLoadingKardex(false);
    }
  };

  const handleSaveInsumo = async (e: React.FormEvent) => {
    e.preventDefault();
    setSubmitting(true);
    setError('');

    const payload = {
      sucursalId: activeSucursalId,
      nombre,
      unidadMedida,
      stockMinimo: parseFloat(stockMinimo)
    };

    try {
      let response: any;
      if (selectedId) {
        response = await apiInventario.put(`/insumos/${selectedId}`, payload);
        setInsumos(prev => prev.map(i => i.id === selectedId ? response.data : i));
      } else {
        response = await apiInventario.post('/insumos', payload);
        setInsumos(prev => [...prev, response.data]);
      }
      setIsCRUDModalOpen(false);
    } catch (err: any) {
      console.error('Error saving insumo:', err);
      setError(err.response?.data?.mensaje || err.message || 'Error al guardar el insumo');
    } finally {
      setSubmitting(false);
    }
  };

  const handleSaveAjuste = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!selectedInsumo) return;
    setAdjusting(true);
    setError('');

    const payload = {
      insumoId: selectedInsumo.id,
      tipo: tipoMovimiento,
      cantidad: parseFloat(cantidadAjuste),
      referencia: referenciaAjuste
    };

    try {
      // Ajustamos stock usando el endpoint PATCH de Spring Boot
      await apiInventario.patch(`/${selectedInsumo.id}/stock`, payload);
      
      // Actualizamos localmente el stock
      const cantidadVal = parseFloat(cantidadAjuste);
      setInsumos(prev => prev.map(ins => {
        if (ins.id === selectedInsumo.id) {
          const nuevoStock = tipoMovimiento === 'ENTRADA' 
            ? ins.stockActual + cantidadVal 
            : Math.max(0, ins.stockActual - cantidadVal);
          return { ...ins, stockActual: nuevoStock };
        }
        return ins;
      }));
      setIsAjustarModalOpen(false);
    } catch (err: any) {
      console.error('Error adjusting stock:', err);
      setError(err.response?.data?.mensaje || err.message || 'Error al registrar el movimiento');
    } finally {
      setAdjusting(false);
    }
  };

  return (
    <PageContainer>
      <div className="flex flex-col md:flex-row md:items-center md:justify-between gap-4 mb-6">
        <div>
          <h1 className="text-2xl font-bold text-surface-900 flex items-center gap-2">
            <ClipboardList className="w-6 h-6 text-primary-500" />
            Control de Inventario e Insumos
          </h1>
          <p className="text-surface-500">Supervisa las existencias de materias primas y registra entradas y mermas.</p>
        </div>
        
        {/* Selector de Sucursal */}
        <div className="flex items-center gap-3">
          <label htmlFor="sucursal-select" className="text-sm text-surface-400 font-semibold shrink-0">Sucursal:</label>
          <select 
            id="sucursal-select"
            value={activeSucursalId}
            onChange={(e) => setActiveSucursalId(parseInt(e.target.value, 10))}
            className="h-10 px-3 rounded-lg bg-surface-800 border border-white/10 text-white focus:ring-2 focus:ring-primary-500 outline-none transition-all"
          >
            {sucursales.map(s => (
              <option key={s.id} value={s.id}>{s.nombre}</option>
            ))}
          </select>
          <Button onClick={handleOpenCreateModal} className="shadow-lg shadow-primary-500/10">
            <Plus className="w-4 h-4 mr-2" />
            Registrar Insumo
          </Button>
        </div>
      </div>

      {error && !isCRUDModalOpen && !isAjustarModalOpen && !isKardexModalOpen && (
        <div className="bg-red-500/10 border border-red-500/25 text-red-200 text-sm rounded-xl p-4 mb-6">
          {error}
        </div>
      )}

      <Card className="overflow-hidden border border-white/5 bg-surface-900/40 backdrop-blur-md">
        <CardContent className="p-0">
          {loading ? (
            <div className="flex flex-col items-center justify-center py-16 gap-3">
              <Loader2 className="w-8 h-8 text-primary-500 animate-spin" />
              <p className="text-sm text-surface-400">Consultando ms-inventario...</p>
            </div>
          ) : insumos.length === 0 ? (
            <div className="text-center py-16">
              <ClipboardList className="w-12 h-12 text-surface-600 mx-auto mb-3" />
              <p className="text-surface-400">No hay insumos registrados para esta sucursal.</p>
            </div>
          ) : (
            <div className="overflow-x-auto">
              <table className="w-full text-left border-collapse">
                <thead>
                  <tr className="border-b border-white/5 bg-white/[0.02]">
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Insumo</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Existencia Actual</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Stock Mínimo Alerta</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Alerta de Crítica</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider text-right">Acciones</th>
                  </tr>
                </thead>
                <tbody className="divide-y divide-white/5">
                  {insumos.map((ins) => {
                    const esStockBajo = ins.stockActual <= ins.stockMinimo;
                    return (
                      <tr key={ins.id} className="hover:bg-white/[0.01] transition-all duration-150">
                        <td className="px-6 py-4">
                          <div>
                            <p className="text-sm font-semibold text-white">{ins.nombre}</p>
                            <p className="text-xs text-surface-500">ID: {ins.id} • Sucursal ID: {ins.sucursalId}</p>
                          </div>
                        </td>
                        <td className="px-6 py-4">
                          <span className={`text-sm font-bold ${esStockBajo ? 'text-yellow-400' : 'text-white'}`}>
                            {ins.stockActual} <span className="text-xs font-normal text-surface-400">{ins.unidadMedida}</span>
                          </span>
                        </td>
                        <td className="px-6 py-4 text-sm text-surface-300">
                          {ins.stockMinimo} <span className="text-xs text-surface-500">{ins.unidadMedida}</span>
                        </td>
                        <td className="px-6 py-4">
                          {esStockBajo ? (
                            <div className="flex items-center gap-1.5 text-yellow-400 bg-yellow-500/10 px-2.5 py-1 rounded-full border border-yellow-500/20 text-xs font-semibold w-fit">
                              <AlertTriangle className="w-3.5 h-3.5" />
                              <span>Reabastecer</span>
                            </div>
                          ) : (
                            <div className="flex items-center gap-1.5 text-green-400 bg-green-500/10 px-2.5 py-1 rounded-full border border-green-500/20 text-xs font-semibold w-fit">
                              <span>Óptimo</span>
                            </div>
                          )}
                        </td>
                        <td className="px-6 py-4 text-right">
                          <div className="flex items-center justify-end gap-2">
                            <Button 
                              variant="ghost" 
                              size="sm" 
                              onClick={() => handleOpenAjustarModal(ins)}
                              title="Ingresos o Mermas"
                              className="h-9 px-3 hover:bg-white/5 text-primary-400 hover:text-primary-300 gap-1.5 text-xs font-semibold"
                            >
                              <RefreshCw className="w-3.5 h-3.5" />
                              Ajustar
                            </Button>
                            <Button 
                              variant="ghost" 
                              size="sm" 
                              onClick={() => handleOpenKardexModal(ins)}
                              title="Historial Kardex"
                              className="h-9 w-9 p-0 hover:bg-white/5 text-surface-300 hover:text-white"
                            >
                              <History className="w-4 h-4" />
                            </Button>
                            <Button 
                              variant="ghost" 
                              size="sm" 
                              onClick={() => handleOpenEditModal(ins)}
                              className="h-9 w-9 p-0 hover:bg-white/5 text-surface-300 hover:text-white"
                            >
                              <Edit3 className="w-4 h-4" />
                            </Button>
                          </div>
                        </td>
                      </tr>
                    );
                  })}
                </tbody>
              </table>
            </div>
          )}
        </CardContent>
      </Card>

      {/* MODAL CRUD INSUMO */}
      {isCRUDModalOpen && (
        <div className="fixed inset-0 z-[100] flex items-center justify-center p-4 bg-surface-950/60 backdrop-blur-sm animate-in fade-in duration-200">
          <Card className="w-full max-w-md shadow-2xl border border-white/10 bg-surface-900/90 backdrop-blur-xl animate-in zoom-in-95 duration-200">
            <CardHeader className="border-b border-white/5 pb-4">
              <CardTitle className="text-lg font-bold text-white flex items-center gap-2">
                <ClipboardList className="w-5 h-5 text-primary-400" />
                {selectedId ? 'Editar Insumo de Cocina' : 'Nuevo Insumo de Cocina'}
              </CardTitle>
            </CardHeader>
            <CardContent className="pt-6">
              {error && (
                <div className="bg-red-500/10 border border-red-500/20 text-red-200 text-xs rounded-lg p-3 mb-4">
                  {error}
                </div>
              )}
              <form onSubmit={handleSaveInsumo} className="space-y-4">
                <div className="space-y-2">
                  <label htmlFor="insumo-nombre" className="text-sm font-semibold text-surface-200">
                    Nombre del Insumo
                  </label>
                  <Input 
                    id="insumo-nombre"
                    value={nombre} 
                    onChange={(e) => setNombre(e.target.value)} 
                    placeholder="ej: Papas Prefritas" 
                    required 
                    disabled={submitting}
                    className="bg-white/5 border-white/10 text-white placeholder:text-surface-500 focus-visible:ring-primary-500"
                  />
                </div>

                <div className="grid grid-cols-2 gap-4">
                  <div className="space-y-2">
                    <label htmlFor="insumo-unidad" className="text-sm font-semibold text-surface-200">
                      Unidad de Medida
                    </label>
                    <select 
                      id="insumo-unidad"
                      value={unidadMedida}
                      onChange={(e) => setUnidadMedida(e.target.value)}
                      disabled={submitting}
                      className="w-full h-10 px-3 rounded-lg bg-surface-800 border border-white/10 text-white focus:ring-2 focus:ring-primary-500 outline-none transition-all"
                    >
                      <option value="Unidades">Unidades</option>
                      <option value="Kg">Kilogramos (Kg)</option>
                      <option value="Litros">Litros (Ltr)</option>
                      <option value="Gramos">Gramos (g)</option>
                    </select>
                  </div>

                  <div className="space-y-2">
                    <label htmlFor="insumo-minimo" className="text-sm font-semibold text-surface-200">
                      Stock Mínimo
                    </label>
                    <Input 
                      id="insumo-minimo"
                      type="number"
                      step="any"
                      value={stockMinimo} 
                      onChange={(e) => setStockMinimo(e.target.value)} 
                      placeholder="ej: 10" 
                      required 
                      disabled={submitting}
                      className="bg-white/5 border-white/10 text-white placeholder:text-surface-500 focus-visible:ring-primary-500"
                    />
                  </div>
                </div>

                <div className="flex justify-end gap-3 mt-6 pt-4 border-t border-white/5">
                  <Button variant="outline" type="button" onClick={() => setIsCRUDModalOpen(false)} disabled={submitting}>
                    Cancelar
                  </Button>
                  <Button type="submit" disabled={submitting} className="shadow-lg shadow-primary-500/10">
                    {submitting ? (
                      <>
                        <Loader2 className="w-4 h-4 mr-2 animate-spin" />
                        Guardando...
                      </>
                    ) : (
                      'Guardar Insumo'
                    )}
                  </Button>
                </div>
              </form>
            </CardContent>
          </Card>
        </div>
      )}

      {/* MODAL AJUSTAR STOCK (MOVIMIENTO) */}
      {isAjustarModalOpen && selectedInsumo && (
        <div className="fixed inset-0 z-[100] flex items-center justify-center p-4 bg-surface-950/60 backdrop-blur-sm animate-in fade-in duration-200">
          <Card className="w-full max-w-md shadow-2xl border border-white/10 bg-surface-900/90 backdrop-blur-xl animate-in zoom-in-95 duration-200">
            <CardHeader className="border-b border-white/5 pb-4">
              <CardTitle className="text-lg font-bold text-white flex items-center gap-2">
                <RefreshCw className="w-5 h-5 text-primary-400" />
                Registrar Movimiento de Stock
              </CardTitle>
            </CardHeader>
            <CardContent className="pt-6">
              {error && (
                <div className="bg-red-500/10 border border-red-500/20 text-red-200 text-xs rounded-lg p-3 mb-4">
                  {error}
                </div>
              )}
              <div className="bg-white/5 border border-white/5 rounded-xl p-3 mb-4 flex items-center justify-between">
                <div>
                  <p className="text-xs text-surface-400">Insumo Seleccionado</p>
                  <p className="text-sm font-semibold text-white">{selectedInsumo.nombre}</p>
                </div>
                <div className="text-right">
                  <p className="text-xs text-surface-400">Stock Actual</p>
                  <p className="text-sm font-bold text-white">{selectedInsumo.stockActual} {selectedInsumo.unidadMedida}</p>
                </div>
              </div>

              <form onSubmit={handleSaveAjuste} className="space-y-4">
                <div className="space-y-2">
                  <span className="text-sm font-semibold text-surface-200 block">Tipo de Ajuste</span>
                  <div className="grid grid-cols-2 gap-3">
                    <button
                      type="button"
                      onClick={() => setTipoMovimiento('ENTRADA')}
                      className={`h-11 rounded-lg border font-bold flex items-center justify-center gap-2 transition-all ${
                        tipoMovimiento === 'ENTRADA' 
                          ? 'bg-green-500/10 border-green-500 text-green-400 shadow-md shadow-green-500/5' 
                          : 'bg-white/5 border-white/10 text-surface-300 hover:bg-white/[0.08]'
                      }`}
                    >
                      <TrendingUp className="w-4 h-4" />
                      <span>Ingreso (Compra)</span>
                    </button>
                    <button
                      type="button"
                      onClick={() => setTipoMovimiento('SALIDA')}
                      className={`h-11 rounded-lg border font-bold flex items-center justify-center gap-2 transition-all ${
                        tipoMovimiento === 'SALIDA' 
                          ? 'bg-red-500/10 border-red-500 text-red-400 shadow-md shadow-red-500/5' 
                          : 'bg-white/5 border-white/10 text-surface-300 hover:bg-white/[0.08]'
                      }`}
                    >
                      <TrendingDown className="w-4 h-4" />
                      <span>Merma / Salida</span>
                    </button>
                  </div>
                </div>

                <div className="space-y-2">
                  <label htmlFor="ajuste-cantidad" className="text-sm font-semibold text-surface-200">
                    Cantidad a ajustar ({selectedInsumo.unidadMedida})
                  </label>
                  <Input 
                    id="ajuste-cantidad"
                    type="number"
                    step="0.001"
                    min="0.001"
                    value={cantidadAjuste} 
                    onChange={(e) => setCantidadAjuste(e.target.value)} 
                    placeholder="ej: 15" 
                    required 
                    disabled={adjusting}
                    className="bg-white/5 border-white/10 text-white placeholder:text-surface-500 focus-visible:ring-primary-500"
                  />
                </div>

                <div className="space-y-2">
                  <label htmlFor="ajuste-referencia" className="text-sm font-semibold text-surface-200">
                    Referencia / Motivo del Movimiento
                  </label>
                  <Input 
                    id="ajuste-referencia"
                    value={referenciaAjuste} 
                    onChange={(e) => setReferenciaAjuste(e.target.value)} 
                    placeholder="ej: Llegada de proveedor / Vencimiento de lote" 
                    required 
                    disabled={adjusting}
                    className="bg-white/5 border-white/10 text-white placeholder:text-surface-500 focus-visible:ring-primary-500"
                  />
                </div>

                <div className="flex justify-end gap-3 mt-6 pt-4 border-t border-white/5">
                  <Button variant="outline" type="button" onClick={() => setIsAjustarModalOpen(false)} disabled={adjusting}>
                    Cancelar
                  </Button>
                  <Button type="submit" disabled={adjusting} className={tipoMovimiento === 'ENTRADA' ? 'bg-green-600 hover:bg-green-700 text-white' : 'bg-red-600 hover:bg-red-700 text-white'}>
                    {adjusting ? (
                      <>
                        <Loader2 className="w-4 h-4 mr-2 animate-spin" />
                        Registrando...
                      </>
                    ) : (
                      'Registrar Ajuste'
                    )}
                  </Button>
                </div>
              </form>
            </CardContent>
          </Card>
        </div>
      )}

      {/* MODAL HISTORIAL KARDEX */}
      {isKardexModalOpen && selectedInsumo && (
        <div className="fixed inset-0 z-[100] flex items-center justify-center p-4 bg-surface-950/60 backdrop-blur-sm animate-in fade-in duration-200">
          <Card className="w-full max-w-lg shadow-2xl border border-white/10 bg-surface-900/90 backdrop-blur-xl animate-in zoom-in-95 duration-200">
            <CardHeader className="border-b border-white/5 pb-4">
              <CardTitle className="text-lg font-bold text-white flex items-center gap-2">
                <History className="w-5 h-5 text-primary-400" />
                Historial Kardex: {selectedInsumo.nombre}
              </CardTitle>
            </CardHeader>
            <CardContent className="pt-6">
              {loadingKardex ? (
                <div className="flex flex-col items-center justify-center py-12 gap-3">
                  <Loader2 className="w-6 h-6 text-primary-500 animate-spin" />
                  <p className="text-xs text-surface-400">Consultando movimientos...</p>
                </div>
              ) : kardexList.length === 0 ? (
                <p className="text-center text-surface-500 py-12">No hay movimientos registrados para este insumo.</p>
              ) : (
                <div className="max-h-80 overflow-y-auto space-y-3 pr-2 scrollbar-thin scrollbar-thumb-white/10">
                  {kardexList.map((mov) => {
                    const esEntrada = mov.tipo === 'ENTRADA';
                    return (
                      <div key={mov.id} className="bg-white/[0.02] border border-white/5 rounded-xl p-3.5 flex items-center justify-between">
                        <div className="flex items-center gap-3">
                          <div className={`h-8 w-8 rounded-lg flex items-center justify-center ${
                            esEntrada ? 'bg-green-500/10 text-green-400' : 'bg-red-500/10 text-red-400'
                          }`}>
                            {esEntrada ? <TrendingUp className="w-4 h-4" /> : <TrendingDown className="w-4 h-4" />}
                          </div>
                          <div>
                            <p className="text-sm font-semibold text-white">{mov.referencia}</p>
                            <p className="text-xs text-surface-500">{new Date(mov.creadoEn).toLocaleString()}</p>
                          </div>
                        </div>
                        <div className="text-right">
                          <p className={`text-sm font-bold ${esEntrada ? 'text-green-400' : 'text-red-400'}`}>
                            {esEntrada ? '+' : '-'}{mov.cantidad}
                          </p>
                          <p className="text-xs text-surface-500">{selectedInsumo.unidadMedida}</p>
                        </div>
                      </div>
                    );
                  })}
                </div>
              )}

              <div className="flex justify-end mt-6 pt-4 border-t border-white/5">
                <Button variant="outline" type="button" onClick={() => setIsKardexModalOpen(false)}>
                  Cerrar
                </Button>
              </div>
            </CardContent>
          </Card>
        </div>
      )}
    </PageContainer>
  );
};

export default InventarioPage;
