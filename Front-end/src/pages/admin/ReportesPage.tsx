import React, { useState } from 'react';
import { PageContainer } from '../../layouts/PageContainer';
import { Card, CardHeader, CardTitle, CardContent } from '../../components/ui/Card';
import { Button } from '../../components/ui/Button';
import { Badge } from '../../components/ui/Badge';
import { apiReportes } from '../../api/axios';
import { BarChart3, FileText, Loader2, Eye } from 'lucide-react';

type TipoReporte = 'VENTAS_DIARIAS' | 'TOP_PLATOS' | 'KARDEX_MENSUAL' | 'RENDIMIENTO_REPARTIDORES';

interface ReporteSnapshot {
  id: number;
  sucursalId: number | null;
  tipo: TipoReporte;
  dataJson: any;
  creadoEn: string;
}

const TIPO_LABELS: Record<TipoReporte, string> = {
  VENTAS_DIARIAS: 'Ventas Diarias',
  TOP_PLATOS: 'Top Platos',
  KARDEX_MENSUAL: 'Kardex Mensual',
  RENDIMIENTO_REPARTIDORES: 'Rendimiento Repartidores',
};

const formatFecha = (dateStr: string) => {
  try {
    return new Date(dateStr).toLocaleString('es-CL', {
      day: '2-digit',
      month: 'short',
      year: 'numeric',
      hour: '2-digit',
      minute: '2-digit',
    });
  } catch {
    return dateStr;
  }
};

export const ReportesPage: React.FC = () => {
  const [reportes, setReportes] = useState<ReporteSnapshot[]>([]);
  const [loading, setLoading] = useState(false);
  const [generating, setGenerating] = useState(false);
  const [error, setError] = useState('');
  const [selectedTipo, setSelectedTipo] = useState<TipoReporte>('VENTAS_DIARIAS');
  const [fechaInicio, setFechaInicio] = useState(() => {
    const d = new Date();
    d.setDate(d.getDate() - 7);
    return d.toISOString().split('T')[0];
  });
  const [fechaFin, setFechaFin] = useState(() => new Date().toISOString().split('T')[0]);
  const [viewingData, setViewingData] = useState<{ tipo: string; data: any } | null>(null);

  const fetchReportes = async (tipo: TipoReporte) => {
    setLoading(true);
    setError('');
    try {
      const res = await apiReportes.get(`/tipo/${tipo}`);
      setReportes(Array.isArray(res.data) ? res.data : []);
    } catch (err: any) {
      console.error('Error fetching reportes:', err);
      setError('No se pudieron obtener los reportes');
      setReportes([]);
    } finally {
      setLoading(false);
    }
  };

  const handleGenerar = async () => {
    setGenerating(true);
    setError('');
    try {
      await apiReportes.post('/generar', {
        tipo: selectedTipo,
        sucursalId: null,
        fechaInicio,
        fechaFin,
      });
      await fetchReportes(selectedTipo);
    } catch (err: any) {
      console.error('Error generating report:', err);
      setError('Error al generar el reporte');
    } finally {
      setGenerating(false);
    }
  };

  const handleFilterChange = (tipo: TipoReporte) => {
    setSelectedTipo(tipo);
    fetchReportes(tipo);
  };

  return (
    <PageContainer>
      <div className="flex items-center justify-between mb-6">
        <div>
          <h1 className="text-2xl font-bold text-surface-900 flex items-center gap-2">
            <BarChart3 className="w-6 h-6 text-primary-500" />
            Reportes y Analíticas
          </h1>
          <p className="text-surface-500">Genera y consulta reportes operativos del restaurante.</p>
        </div>
      </div>

      {/* Generator Panel */}
      <Card className="border border-white/5 bg-surface-900/40 backdrop-blur-md mb-6">
        <CardHeader className="border-b border-white/5 pb-4">
          <CardTitle className="text-base font-bold text-white flex items-center gap-2">
            <FileText className="w-5 h-5 text-primary-400" />
            Generar Nuevo Reporte
          </CardTitle>
        </CardHeader>
        <CardContent className="pt-6">
          <div className="grid grid-cols-1 md:grid-cols-4 gap-4 items-end">
            <div className="space-y-2">
              <label className="text-sm font-semibold text-surface-200">Tipo de Reporte</label>
              <select
                value={selectedTipo}
                onChange={e => setSelectedTipo(e.target.value as TipoReporte)}
                className="w-full h-10 px-3 rounded-lg bg-surface-800 border border-white/10 text-white focus:ring-2 focus:ring-primary-500 outline-none transition-all"
              >
                {Object.entries(TIPO_LABELS).map(([key, label]) => (
                  <option key={key} value={key}>{label}</option>
                ))}
              </select>
            </div>
            <div className="space-y-2">
              <label className="text-sm font-semibold text-surface-200">Fecha Inicio</label>
              <input
                type="date"
                value={fechaInicio}
                onChange={e => setFechaInicio(e.target.value)}
                className="w-full h-10 px-3 rounded-lg bg-surface-800 border border-white/10 text-white focus:ring-2 focus:ring-primary-500 outline-none transition-all"
              />
            </div>
            <div className="space-y-2">
              <label className="text-sm font-semibold text-surface-200">Fecha Fin</label>
              <input
                type="date"
                value={fechaFin}
                onChange={e => setFechaFin(e.target.value)}
                className="w-full h-10 px-3 rounded-lg bg-surface-800 border border-white/10 text-white focus:ring-2 focus:ring-primary-500 outline-none transition-all"
              />
            </div>
            <Button onClick={handleGenerar} disabled={generating} className="shadow-lg shadow-primary-500/10">
              {generating ? <><Loader2 className="w-4 h-4 mr-2 animate-spin" />Generando...</> : 'Generar Reporte'}
            </Button>
          </div>
        </CardContent>
      </Card>

      {error && (
        <div className="bg-red-500/10 border border-red-500/25 text-red-200 text-sm rounded-xl p-4 mb-6">
          {error}
        </div>
      )}

      {/* Filter Tabs */}
      <div className="flex gap-1 bg-surface-100 p-1 rounded-xl w-fit mb-4">
        {Object.entries(TIPO_LABELS).map(([key, label]) => (
          <button
            key={key}
            onClick={() => handleFilterChange(key as TipoReporte)}
            className={`px-3 py-1.5 rounded-lg text-sm font-medium transition-all ${
              selectedTipo === key
                ? 'bg-white text-surface-900 shadow-sm'
                : 'text-surface-500 hover:text-surface-700'
            }`}
          >
            {label}
          </button>
        ))}
      </div>

      {/* Reportes Table */}
      <Card className="border border-white/5 bg-surface-900/40 backdrop-blur-md">
        <CardContent className="p-0">
          {loading ? (
            <div className="flex flex-col items-center justify-center py-16 gap-3">
              <Loader2 className="w-8 h-8 text-primary-500 animate-spin" />
              <p className="text-sm text-surface-400">Consultando ms-reportes...</p>
            </div>
          ) : reportes.length === 0 ? (
            <div className="text-center py-16">
              <BarChart3 className="w-12 h-12 text-surface-600 mx-auto mb-3" />
              <p className="text-surface-400">No hay reportes de este tipo.</p>
              <p className="text-xs text-surface-500 mt-1">Genere un nuevo reporte usando el panel superior.</p>
            </div>
          ) : (
            <div className="overflow-x-auto">
              <table className="w-full text-left border-collapse">
                <thead>
                  <tr className="border-b border-white/5 bg-white/[0.02]">
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">ID</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Tipo</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Sucursal</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider">Fecha</th>
                    <th className="px-6 py-4 text-xs font-semibold text-surface-400 uppercase tracking-wider text-right">Acciones</th>
                  </tr>
                </thead>
                <tbody className="divide-y divide-white/5">
                  {reportes.map(r => (
                    <tr key={r.id} className="hover:bg-white/[0.01] transition-all duration-150">
                      <td className="px-6 py-4 text-sm font-mono text-surface-300">#{r.id}</td>
                      <td className="px-6 py-4">
                        <Badge className="bg-primary-500/10 text-primary-400 border border-primary-500/20 text-xs">
                          {TIPO_LABELS[r.tipo] || r.tipo}
                        </Badge>
                      </td>
                      <td className="px-6 py-4 text-sm text-surface-300">
                        {r.sucursalId ? `Sucursal #${r.sucursalId}` : 'Global'}
                      </td>
                      <td className="px-6 py-4 text-xs text-surface-400">
                        {formatFecha(r.creadoEn)}
                      </td>
                      <td className="px-6 py-4 text-right">
                        <Button variant="ghost" size="sm" onClick={() => setViewingData({ tipo: r.tipo, data: r.dataJson })} className="h-9 w-9 p-0 hover:bg-white/5 text-surface-300 hover:text-white">
                          <Eye className="w-4 h-4" />
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

      {/* JSON Viewer Modal */}
      {viewingData && (
        <div className="fixed inset-0 z-[100] flex items-center justify-center p-4 bg-surface-950/60 backdrop-blur-sm" onClick={() => setViewingData(null)}>
          <div className="w-full max-w-3xl max-h-[80vh] overflow-auto rounded-2xl bg-surface-900 border border-white/10 shadow-2xl" onClick={e => e.stopPropagation()}>
            <div className="flex items-center justify-between p-4 border-b border-white/5">
              <h3 className="text-lg font-bold text-white">{TIPO_LABELS[viewingData.tipo as TipoReporte] || viewingData.tipo} — Datos JSON</h3>
              <button onClick={() => setViewingData(null)} className="text-surface-400 hover:text-white text-xl">&times;</button>
            </div>
            <pre className="p-4 text-xs text-surface-200 overflow-auto">
              {JSON.stringify(viewingData.data, null, 2)}
            </pre>
          </div>
        </div>
      )}
    </PageContainer>
  );
};

export default ReportesPage;