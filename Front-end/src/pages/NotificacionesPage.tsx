import React, { useState, useEffect } from 'react';
import { PageContainer } from '../layouts/PageContainer';
import { Card, CardContent } from '../components/ui/Card';
import { Button } from '../components/ui/Button';
import { Badge, badgeVariants } from '../components/ui/Badge';
import type { VariantProps } from 'class-variance-authority';
import { apiNotificaciones } from '../api/axios';
import { Bell, BellOff, Mail, MessageSquare, Smartphone, Check, Loader2 } from 'lucide-react';

type BadgeVariant = NonNullable<VariantProps<typeof badgeVariants>['variant']>;

type EstadoNotificacion = 'PENDIENTE' | 'ENVIADO' | 'FALLIDO';
type TipoNotificacion = 'EMAIL' | 'SMS' | 'PUSH';

interface Notificacion {
  id: number;
  destinatario: string;
  tipo: TipoNotificacion;
  asunto: string;
  cuerpo: string;
  estado: EstadoNotificacion;
  creadoEn: string;
}

type FilterType = 'PENDIENTE' | 'ENVIADO' | 'ALL';

const getEstadoBadge = (estado: EstadoNotificacion): BadgeVariant => {
  const map: Record<string, BadgeVariant> = {
    PENDIENTE: 'warning',
    ENVIADO: 'success',
    FALLIDO: 'error',
  };
  return map[estado] ?? 'default';
};

const getTipoIcon = (tipo: TipoNotificacion) => {
  const map: Record<string, React.ReactNode> = {
    EMAIL: <Mail className="w-4 h-4" />,
    SMS: <MessageSquare className="w-4 h-4" />,
    PUSH: <Smartphone className="w-4 h-4" />,
  };
  return map[tipo] ?? <Bell className="w-4 h-4" />;
};

const formatDate = (dateStr: string) => {
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

export const NotificacionesPage: React.FC = () => {
  const [notificaciones, setNotificaciones] = useState<Notificacion[]>([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');
  const [activeFilter, setActiveFilter] = useState<FilterType>('ALL');

  useEffect(() => {
    fetchNotificaciones();
  }, []);

  const fetchNotificaciones = async () => {
    setLoading(true);
    setError('');
    try {
      const res = await apiNotificaciones.get('/estado/PENDIENTE');
      const pendientes: Notificacion[] = Array.isArray(res.data) ? res.data : [];
      try {
        const res2 = await apiNotificaciones.get('/estado/ENVIADO');
        setNotificaciones([...pendientes, ...(Array.isArray(res2.data) ? res2.data : [])]);
      } catch {
        setNotificaciones(pendientes);
      }
    } catch (err: any) {
      console.error('Error fetching notificaciones:', err);
      setError('No se pudieron obtener las notificaciones');
      setNotificaciones([]);
    } finally {
      setLoading(false);
    }
  };

  const fetchByFilter = async (filter: FilterType) => {
    setActiveFilter(filter);
    if (filter === 'ALL') {
      fetchNotificaciones();
      return;
    }
    setLoading(true);
    try {
      const res = await apiNotificaciones.get(`/estado/${filter}`);
      setNotificaciones(Array.isArray(res.data) ? res.data : []);
    } catch (err) {
      console.error('Error filtering notificaciones:', err);
    } finally {
      setLoading(false);
    }
  };

  const handleMarkAsRead = async (id: number) => {
    try {
      await apiNotificaciones.patch(`/${id}/estado`, { estado: 'ENVIADO' });
      setNotificaciones(prev =>
        prev.map(n => n.id === id ? { ...n, estado: 'ENVIADO' as EstadoNotificacion } : n)
      );
    } catch (err) {
      console.error('Error marking as read:', err);
    }
  };

  const filtered = activeFilter === 'ALL'
    ? notificaciones
    : notificaciones.filter(n => n.estado === activeFilter);

  return (
    <PageContainer>
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4">
        <div>
          <h1 className="text-2xl font-bold text-surface-900 flex items-center gap-2">
            <Bell className="w-6 h-6 text-primary-500" />
            Notificaciones
          </h1>
          <p className="text-surface-500">Centro de alertas y mensajes del sistema.</p>
        </div>
        <div className="flex gap-1 bg-surface-100 p-1 rounded-xl">
          {(['ALL', 'PENDIENTE', 'ENVIADO'] as FilterType[]).map(f => (
            <button
              key={f}
              onClick={() => fetchByFilter(f)}
              className={`px-3 py-1.5 rounded-lg text-sm font-medium transition-all ${
                activeFilter === f
                  ? 'bg-white text-surface-900 shadow-sm'
                  : 'text-surface-500 hover:text-surface-700'
              }`}
            >
              {f === 'ALL' ? 'Todas' : f === 'PENDIENTE' ? 'Pendientes' : 'Leídas'}
            </button>
          ))}
        </div>
      </div>

      {error && (
        <div className="bg-red-500/10 border border-red-500/25 text-red-200 text-sm rounded-xl p-4">
          {error}
        </div>
      )}

      <Card className="border border-white/5 bg-surface-900/40 backdrop-blur-md">
        <CardContent className="p-0">
          {loading ? (
            <div className="flex flex-col items-center justify-center py-16 gap-3">
              <Loader2 className="w-8 h-8 text-primary-500 animate-spin" />
              <p className="text-sm text-surface-400">Cargando notificaciones...</p>
            </div>
          ) : filtered.length === 0 ? (
            <div className="text-center py-16">
              <BellOff className="w-12 h-12 text-surface-600 mx-auto mb-3" />
              <p className="text-surface-400">No hay notificaciones para mostrar.</p>
            </div>
          ) : (
            <div className="divide-y divide-white/5">
              {filtered.map(n => (
                <div key={n.id} className="p-4 flex items-start gap-4 hover:bg-white/[0.01] transition-all">
                  <div className={`shrink-0 h-10 w-10 rounded-xl flex items-center justify-center ${
                    n.estado === 'PENDIENTE'
                      ? 'bg-yellow-500/10 text-yellow-400 border border-yellow-500/20'
                      : 'bg-surface-800 text-surface-400 border border-white/5'
                  }`}>
                    {getTipoIcon(n.tipo)}
                  </div>
                  <div className="flex-1 min-w-0">
                    <div className="flex items-center gap-2 mb-1">
                      <p className="text-sm font-semibold text-white truncate">{n.asunto}</p>
                      <Badge variant={getEstadoBadge(n.estado)}>{n.estado}</Badge>
                    </div>
                    <p className="text-xs text-surface-400 line-clamp-2">{n.cuerpo}</p>
                    <div className="flex items-center gap-3 mt-2 text-xs text-surface-500">
                      <span>{n.destinatario}</span>
                      <span>{formatDate(n.creadoEn)}</span>
                    </div>
                  </div>
                  {n.estado === 'PENDIENTE' && (
                    <Button variant="ghost" size="sm" onClick={() => handleMarkAsRead(n.id)} className="shrink-0 text-surface-300 hover:text-white">
                      <Check className="w-4 h-4 mr-1" />
                      Marcar leída
                    </Button>
                  )}
                </div>
              ))}
            </div>
          )}
        </CardContent>
      </Card>
    </PageContainer>
  );
};

export default NotificacionesPage;