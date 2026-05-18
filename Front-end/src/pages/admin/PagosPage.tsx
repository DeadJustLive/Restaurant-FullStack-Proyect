import React, { useState, useEffect } from 'react';
import { PageContainer } from '../../layouts/PageContainer';
import { Card, CardHeader, CardTitle, CardContent } from '../../components/ui/Card';
import { Button } from '../../components/ui/Button';
import { Input } from '../../components/ui/Input';
import { apiPagos } from '../../api/axios';
import { 
  CreditCard, CheckCircle2, XCircle, AlertCircle, 
  TrendingUp, Plus, Search, ArrowLeftRight, Loader2 
} from 'lucide-react';

interface Pago {
  id: number;
  pedidoId: number;
  monto: number;
  metodo: 'EFECTIVO' | 'TARJETA_CREDITO' | 'TARJETA_DEBITO' | 'TRANSFERENCIA';
  estado: 'PENDIENTE' | 'APROBADO' | 'RECHAZADO' | 'REEMBOLSADO';
  transaccionId: string;
  creadoEn: string;
}

export const PagosPage: React.FC = () => {
  const [pagos, setPagos] = useState<Pago[]>([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');
  
  // Filtros
  const [searchQuery, setSearchQuery] = useState('');
  const [statusFilter, setStatusFilter] = useState<string>('TODOS');

  // Modales
  const [isNewPagoModalOpen, setIsNewPagoModalOpen] = useState(false);
  const [isConfirmModalOpen, setIsConfirmModalOpen] = useState(false);
  
  // Formulario Nuevo Pago
  const [pedidoId, setPedidoId] = useState('');
  const [monto, setMonto] = useState('');
  const [metodo, setMetodo] = useState<'EFECTIVO' | 'TARJETA_CREDITO' | 'TARJETA_DEBITO' | 'TRANSFERENCIA'>('EFECTIVO');
  const [submitting, setSubmitting] = useState(false);

  // Formulario Confirmar/Resolver Pago
  const [selectedPago, setSelectedPago] = useState<Pago | null>(null);
  const [transaccionId, setTransaccionId] = useState('');
  const [estadoFinal, setEstadoFinal] = useState<'APROBADO' | 'RECHAZADO'>('APROBADO');
  const [resolving, setResolving] = useState(false);

  useEffect(() => {
    fetchPagos();
  }, []);

  const fetchPagos = async () => {
    setLoading(true);
    setError('');
    try {
      const response = await apiPagos.get('');
      setPagos(Array.isArray(response.data) ? response.data : []);
    } catch (err: any) {
      console.error('Error fetching payments:', err);
      setError(err.message || 'Error al conectar con el microservicio ms-pagos');
      // Fallback
      setPagos([
        { id: 1, pedidoId: 101, monto: 20500.0, metodo: 'TARJETA_CREDITO', estado: 'APROBADO', transaccionId: 'TX-892401', creadoEn: new Date(Date.now() - 3600000 * 2).toISOString() },
        { id: 2, pedidoId: 102, monto: 12400.0, metodo: 'EFECTIVO', estado: 'APROBADO', transaccionId: 'TX-CASH-991', creadoEn: new Date(Date.now() - 3600000).toISOString() },
        { id: 3, pedidoId: 103, monto: 8500.0, metodo: 'TARJETA_DEBITO', estado: 'PENDIENTE', transaccionId: '', creadoEn: new Date().toISOString() }
      ]);
    } finally {
      setLoading(false);
    }
  };

  const handleOpenNewPagoModal = () => {
    setPedidoId('');
    setMonto('');
    setMetodo('EFECTIVO');
    setError('');
    setIsNewPagoModalOpen(true);
  };

  const handleOpenConfirmModal = (pago: Pago) => {
    setSelectedPago(pago);
    setTransaccionId(`TX-${Math.floor(100000 + Math.random() * 900000)}`);
    setEstadoFinal('APROBADO');
    setError('');
    setIsConfirmModalOpen(true);
  };

  const handleCreatePago = async (e: React.FormEvent) => {
    e.preventDefault();
    setSubmitting(true);
    setError('');

    const payload = {
      pedidoId: parseInt(pedidoId, 10),
      monto: parseFloat(monto),
      metodo
    };

    try {
      const response = await apiPagos.post('', payload);
      setPagos(prev => [response.data, ...prev]);
      setIsNewPagoModalOpen(false);
    } catch (err: any) {
      console.error('Error initiating payment:', err);
      setError(err.response?.data?.mensaje || err.message || 'Error al iniciar la transacción');
    } finally {
      setSubmitting(false);
    }
  };

  const handleConfirmPago = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!selectedPago) return;
    setResolving(true);
    setError('');

    try {
      const response = await apiPagos.patch(`/${selectedPago.id}/estado`, null, {
        params: {
          transaccionId,
          estadoFinal
        }
      });
      setPagos(prev => prev.map(p => p.id === selectedPago.id ? response.data : p));
      setIsConfirmModalOpen(false);
    } catch (err: any) {
      console.error('Error confirming payment:', err);
      setError(err.response?.data?.mensaje || err.message || 'Error al resolver la transacción');
    } finally {
      setResolving(false);
    }
  };

  const handleRefundPago = async (pago: Pago) => {
    if (!window.confirm(`¿Estás seguro de solicitar el reembolso total de $${pago.monto.toLocaleString('es-CL')} para la transacción ${pago.transaccionId}?`)) {
      return;
    }
    try {
      const response = await apiPagos.patch(`/${pago.id}/estado`, null, {
        params: {
          transaccionId: `REF-${pago.transaccionId}`,
          estadoFinal: 'REEMBOLSADO'
        }
      });
      setPagos(prev => prev.map(p => p.id === pago.id ? response.data : p));
    } catch (err: any) {
      console.error('Error refunding payment:', err);
      alert(err.response?.data?.mensaje || err.message || 'Error al reembolsar la transacción');
    }
  };

  // Cálculos de Resumen
  const totalAprobado = pagos
    .filter(p => p.estado === 'APROBADO')
    .reduce((sum, p) => sum + p.monto, 0);

  const totalPendiente = pagos
    .filter(p => p.estado === 'PENDIENTE')
    .reduce((sum, p) => sum + p.monto, 0);

  const transaccionesExitosas = pagos.filter(p => p.estado === 'APROBADO').length;
  const tasaExito = pagos.length > 0 
    ? Math.round((transaccionesExitosas / pagos.length) * 100) 
    : 100;

  // Filtrado de Datos
  const filteredPagos = pagos.filter(p => {
    const matchesSearch = 
      p.pedidoId.toString().includes(searchQuery) ||
      p.transaccionId.toLowerCase().includes(searchQuery.toLowerCase());
    
    const matchesStatus = statusFilter === 'TODOS' || p.estado === statusFilter;
    
    return matchesSearch && matchesStatus;
  });

  return (
    <PageContainer>
      <div className="flex flex-col md:flex-row md:items-center md:justify-between gap-4 mb-6">
        <div>
          <h1 className="text-2xl font-bold text-surface-900 flex items-center gap-2">
            <CreditCard className="w-6 h-6 text-primary-500" />
            Control de Caja y Pagos
          </h1>
          <p className="text-surface-500">Monitorea conciliaciones, aprueba transacciones manuales y gestiona reembolsos.</p>
        </div>
        
        <Button onClick={handleOpenNewPagoModal} className="shadow-lg shadow-primary-500/10 self-start md:self-auto">
          <Plus className="w-4 h-4 mr-2" />
          Registrar Solicitud
        </Button>
      </div>

      {/* Tarjetas de Resumen Financiero */}
      <div className="grid grid-cols-1 md:grid-cols-3 gap-6 mb-6">
        <Card className="border border-white/5 bg-gradient-to-br from-green-500/5 to-transparent">
          <CardContent className="p-6 flex items-center justify-between">
            <div>
              <p className="text-sm font-semibold text-surface-400">Total Recaudado (Caja)</p>
              <h3 className="text-3xl font-extrabold text-green-400 mt-1">
                ${totalAprobado.toLocaleString('es-CL')} <span className="text-xs font-normal text-surface-400">CLP</span>
              </h3>
            </div>
            <div className="h-12 w-12 rounded-xl bg-green-500/10 flex items-center justify-center text-green-400">
              <TrendingUp className="w-6 h-6" />
            </div>
          </CardContent>
        </Card>

        <Card className="border border-white/5 bg-gradient-to-br from-yellow-500/5 to-transparent">
          <CardContent className="p-6 flex items-center justify-between">
            <div>
              <p className="text-sm font-semibold text-surface-400">Pendiente de Conciliación</p>
              <h3 className="text-3xl font-extrabold text-yellow-400 mt-1">
                ${totalPendiente.toLocaleString('es-CL')} <span className="text-xs font-normal text-surface-400">CLP</span>
              </h3>
            </div>
            <div className="h-12 w-12 rounded-xl bg-yellow-500/10 flex items-center justify-center text-yellow-400">
              <AlertCircle className="w-6 h-6" />
            </div>
          </CardContent>
        </Card>

        <Card className="border border-white/5 bg-gradient-to-br from-primary-500/5 to-transparent">
          <CardContent className="p-6 flex items-center justify-between">
            <div>
              <p className="text-sm font-semibold text-surface-400">Tasa de Aprobación</p>
              <h3 className="text-3xl font-extrabold text-primary-400 mt-1">
                {tasaExito}% <span className="text-xs font-normal text-surface-400">efectividad</span>
              </h3>
            </div>
            <div className="h-12 w-12 rounded-xl bg-primary-500/10 flex items-center justify-center text-primary-400">
              <CheckCircle2 className="w-6 h-6" />
            </div>
          </CardContent>
        </Card>
      </div>

      {/* Filtros */}
      <div className="flex flex-col md:flex-row gap-4 mb-6">
        <div className="relative flex-1">
          <Search className="absolute left-3 top-3 w-4 h-4 text-surface-500" />
          <Input
            value={searchQuery}
            onChange={(e) => setSearchQuery(e.target.value)}
            placeholder="Buscar por ID de Pedido o Código de Transacción..."
            className="pl-10 bg-white/5 border-white/10 text-white placeholder:text-surface-500 focus-visible:ring-primary-500"
          />
        </div>
        <select
          value={statusFilter}
          onChange={(e) => setStatusFilter(e.target.value)}
          className="h-10 px-3 rounded-lg bg-surface-800 border border-white/10 text-white focus:ring-2 focus:ring-primary-500 outline-none transition-all"
        >
          <option value="TODOS">Todos los Estados</option>
          <option value="PENDIENTE">Pendientes</option>
          <option value="APROBADO">Aprobados</option>
          <option value="RECHAZADO">Rechazados</option>
          <option value="REEMBOLSADO">Reembolsados</option>
        </select>
      </div>

      {error && !isNewPagoModalOpen && !isConfirmModalOpen && (
        <div className="bg-red-500/10 border border-red-500/25 text-red-200 text-sm rounded-xl p-4 mb-6">
          {error}
        </div>
      )}

      {/* Listado de Transacciones */}
      <Card className="overflow-hidden border border-white/5 bg-surface-900/40 backdrop-blur-md">
        <CardContent className="p-0">
          {loading ? (
            <div className="flex flex-col items-center justify-center py-16 gap-3">
              <Loader2 className="w-8 h-8 text-primary-500 animate-spin" />
              <p className="text-sm text-surface-400">Consultando ms-pagos...</p>
            </div>
          ) : filteredPagos.length === 0 ? (
            <div className="text-center py-16">
              <CreditCard className="w-12 h-12 text-surface-600 mx-auto mb-3" />
              <p className="text-surface-400">No se encontraron transacciones registradas.</p>
            </div>
          ) : (
            <div className="overflow-x-auto">
              <table className="w-full text-left border-collapse">
                <thead>
                  <tr className="border-b border-white/5 bg-white/[0.02]">
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">ID / Pedido</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Fecha de Creación</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Monto</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Método</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Estado</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider text-right">Acciones</th>
                  </tr>
                </thead>
                <tbody className="divide-y divide-white/5">
                  {filteredPagos.map((p) => {
                    let badgeColor = '';
                    switch (p.estado) {
                      case 'PENDIENTE': badgeColor = 'text-yellow-400 bg-yellow-500/10 border-yellow-500/20'; break;
                      case 'APROBADO': badgeColor = 'text-green-400 bg-green-500/10 border-green-500/20'; break;
                      case 'RECHAZADO': badgeColor = 'text-red-400 bg-red-500/10 border-red-500/20'; break;
                      case 'REEMBOLSADO': badgeColor = 'text-blue-400 bg-blue-500/10 border-blue-500/20'; break;
                    }
                    return (
                      <tr key={p.id} className="hover:bg-white/[0.01] transition-all duration-150">
                        <td className="px-6 py-4">
                          <div>
                            <p className="text-sm font-semibold text-white">Transacción #{p.id}</p>
                            <p className="text-xs text-surface-500">Pedido Relacionado: #{p.pedidoId}</p>
                            {p.transaccionId && (
                              <p className="text-[10px] text-primary-400 font-mono mt-0.5">{p.transaccionId}</p>
                            )}
                          </div>
                        </td>
                        <td className="px-6 py-4 text-sm text-surface-300">
                          {new Date(p.creadoEn).toLocaleString()}
                        </td>
                        <td className="px-6 py-4 text-sm font-bold text-white">
                          ${p.monto.toLocaleString('es-CL')}
                        </td>
                        <td className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase">
                          {p.metodo.replace('_', ' ')}
                        </td>
                        <td className="px-6 py-4">
                          <span className={`px-2.5 py-1 rounded-full border text-xs font-semibold ${badgeColor}`}>
                            {p.estado}
                          </span>
                        </td>
                        <td className="px-6 py-4 text-right">
                          <div className="flex items-center justify-end gap-2">
                            {p.estado === 'PENDIENTE' && (
                              <Button 
                                size="sm" 
                                onClick={() => handleOpenConfirmModal(p)}
                                className="h-8 text-xs font-bold shadow-lg shadow-primary-500/10"
                              >
                                Conciliar
                              </Button>
                            )}
                            {p.estado === 'APROBADO' && (
                              <Button 
                                variant="ghost" 
                                size="sm" 
                                onClick={() => handleRefundPago(p)}
                                className="h-8 text-xs text-red-400 hover:bg-white/5 gap-1.5 font-semibold"
                              >
                                <ArrowLeftRight className="w-3.5 h-3.5" />
                                Reembolso
                              </Button>
                            )}
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

      {/* MODAL NUEVA SOLICITUD DE PAGO */}
      {isNewPagoModalOpen && (
        <div className="fixed inset-0 z-[100] flex items-center justify-center p-4 bg-surface-950/60 backdrop-blur-sm animate-in fade-in duration-200">
          <Card className="w-full max-w-md shadow-2xl border border-white/10 bg-surface-900/90 backdrop-blur-xl animate-in zoom-in-95 duration-200">
            <CardHeader className="border-b border-white/5 pb-4">
              <CardTitle className="text-lg font-bold text-white flex items-center gap-2">
                <CreditCard className="w-5 h-5 text-primary-400" />
                Registrar Solicitud de Pago
              </CardTitle>
            </CardHeader>
            <CardContent className="pt-6">
              {error && (
                <div className="bg-red-500/10 border border-red-500/20 text-red-200 text-xs rounded-lg p-3 mb-4">
                  {error}
                </div>
              )}
              <form onSubmit={handleCreatePago} className="space-y-4">
                <div className="space-y-2">
                  <label htmlFor="pago-pedido" className="text-sm font-semibold text-surface-200">
                    ID del Pedido
                  </label>
                  <Input 
                    id="pago-pedido"
                    type="number"
                    value={pedidoId} 
                    onChange={(e) => setPedidoId(e.target.value)} 
                    placeholder="ej: 104" 
                    required 
                    disabled={submitting}
                    className="bg-white/5 border-white/10 text-white placeholder:text-surface-500 focus-visible:ring-primary-500"
                  />
                </div>

                <div className="grid grid-cols-2 gap-4">
                  <div className="space-y-2">
                    <label htmlFor="pago-monto" className="text-sm font-semibold text-surface-200">
                      Monto a Cobrar ($)
                    </label>
                    <Input 
                      id="pago-monto"
                      type="number"
                      value={monto} 
                      onChange={(e) => setMonto(e.target.value)} 
                      placeholder="ej: 15000" 
                      required 
                      disabled={submitting}
                      className="bg-white/5 border-white/10 text-white placeholder:text-surface-500 focus-visible:ring-primary-500"
                    />
                  </div>

                  <div className="space-y-2">
                    <label htmlFor="pago-metodo" className="text-sm font-semibold text-surface-200">
                      Método
                    </label>
                    <select 
                      id="pago-metodo"
                      value={metodo}
                      onChange={(e) => setMetodo(e.target.value as any)}
                      disabled={submitting}
                      className="w-full h-10 px-3 rounded-lg bg-surface-800 border border-white/10 text-white focus:ring-2 focus:ring-primary-500 outline-none transition-all"
                    >
                      <option value="EFECTIVO">Efectivo</option>
                      <option value="TARJETA_CREDITO">Tarjeta de Crédito</option>
                      <option value="TARJETA_DEBITO">Tarjeta de Débito</option>
                      <option value="TRANSFERENCIA">Transferencia</option>
                    </select>
                  </div>
                </div>

                <div className="flex justify-end gap-3 mt-6 pt-4 border-t border-white/5">
                  <Button variant="outline" type="button" onClick={() => setIsNewPagoModalOpen(false)} disabled={submitting}>
                    Cancelar
                  </Button>
                  <Button type="submit" disabled={submitting} className="shadow-lg shadow-primary-500/10">
                    {submitting ? (
                      <>
                        <Loader2 className="w-4 h-4 mr-2 animate-spin" />
                        Iniciando...
                      </>
                    ) : (
                      'Lanzar Transacción'
                    )}
                  </Button>
                </div>
              </form>
            </CardContent>
          </Card>
        </div>
      )}

      {/* MODAL CONCILIAR/RESOLVER PAGO */}
      {isConfirmModalOpen && selectedPago && (
        <div className="fixed inset-0 z-[100] flex items-center justify-center p-4 bg-surface-950/60 backdrop-blur-sm animate-in fade-in duration-200">
          <Card className="w-full max-w-md shadow-2xl border border-white/10 bg-surface-900/90 backdrop-blur-xl animate-in zoom-in-95 duration-200">
            <CardHeader className="border-b border-white/5 pb-4">
              <CardTitle className="text-lg font-bold text-white flex items-center gap-2">
                <CheckCircle2 className="w-5 h-5 text-primary-400" />
                Conciliación Bancaria Manual
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
                  <p className="text-xs text-surface-400">Pedido Relacionado</p>
                  <p className="text-sm font-semibold text-white">Pedido #{selectedPago.pedidoId}</p>
                </div>
                <div className="text-right">
                  <p className="text-xs text-surface-400">Total a Cobrar</p>
                  <p className="text-sm font-bold text-green-400">${selectedPago.monto.toLocaleString('es-CL')}</p>
                </div>
              </div>

              <form onSubmit={handleConfirmPago} className="space-y-4">
                <div className="space-y-2">
                  <span className="text-sm font-semibold text-surface-200 block">Resolución de Pago</span>
                  <div className="grid grid-cols-2 gap-3">
                    <button
                      type="button"
                      onClick={() => setEstadoFinal('APROBADO')}
                      className={`h-11 rounded-lg border font-bold flex items-center justify-center gap-2 transition-all ${
                        estadoFinal === 'APROBADO' 
                          ? 'bg-green-500/10 border-green-500 text-green-400 shadow-md shadow-green-500/5' 
                          : 'bg-white/5 border-white/10 text-surface-300 hover:bg-white/[0.08]'
                      }`}
                    >
                      <CheckCircle2 className="w-4 h-4" />
                      <span>Aprobar Pago</span>
                    </button>
                    <button
                      type="button"
                      onClick={() => setEstadoFinal('RECHAZADO')}
                      className={`h-11 rounded-lg border font-bold flex items-center justify-center gap-2 transition-all ${
                        estadoFinal === 'RECHAZADO' 
                          ? 'bg-red-500/10 border-red-500 text-red-400 shadow-md shadow-red-500/5' 
                          : 'bg-white/5 border-white/10 text-surface-300 hover:bg-white/[0.08]'
                      }`}
                    >
                      <XCircle className="w-4 h-4" />
                      <span>Rechazar Pago</span>
                    </button>
                  </div>
                </div>

                <div className="space-y-2">
                  <label htmlFor="confirm-tx" className="text-sm font-semibold text-surface-200">
                    ID Transacción / Código Autorización (Transbank/Caja)
                  </label>
                  <Input 
                    id="confirm-tx"
                    value={transaccionId} 
                    onChange={(e) => setTransaccionId(e.target.value)} 
                    placeholder="ej: TX-908124" 
                    required 
                    disabled={resolving}
                    className="bg-white/5 border-white/10 text-white placeholder:text-surface-500 font-mono focus-visible:ring-primary-500"
                  />
                </div>

                <div className="flex justify-end gap-3 mt-6 pt-4 border-t border-white/5">
                  <Button variant="outline" type="button" onClick={() => setIsConfirmModalOpen(false)} disabled={resolving}>
                    Cancelar
                  </Button>
                  <Button type="submit" disabled={resolving} className={estadoFinal === 'APROBADO' ? 'bg-green-600 hover:bg-green-700 text-white font-bold' : 'bg-red-600 hover:bg-red-700 text-white font-bold'}>
                    {resolving ? (
                      <>
                        <Loader2 className="w-4 h-4 mr-2 animate-spin" />
                        Procesando...
                      </>
                    ) : (
                      'Conciliar Transacción'
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

export default PagosPage;
