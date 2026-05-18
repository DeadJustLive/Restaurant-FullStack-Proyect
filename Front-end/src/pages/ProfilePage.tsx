import React, { useState } from 'react';
import { useAuth } from '../contexts/AuthContext';
import { apiUsuarios } from '../api/axios';
import { PageContainer } from '../layouts/PageContainer';
import { Card, CardHeader, CardTitle, CardContent } from '../components/ui/Card';
import { Badge } from '../components/ui/Badge';
import { Button } from '../components/ui/Button';
import { Input } from '../components/ui/Input';
import { 
  UserCircle, ShieldCheck, MapPin, 
  Terminal, Calendar, Smartphone, Globe, Lock, Save 
} from 'lucide-react';

export const ProfilePage: React.FC = () => {
  const { user, logout } = useAuth();
  const [editing, setEditing] = useState(false);
  const [successMsg, setSuccessMsg] = useState('');
  
  // Formulario Datos
  const [phone, setPhone] = useState('+56 9 8765 4321');
  const [cargo, setCargo] = useState('Administrador General SaaS');
  const [sucursal] = useState('Sucursal Providencia');

  // Formulario Password
  const [currentPass, setCurrentPass] = useState('');
  const [newPass, setNewPass] = useState('');
  const [confirmPass, setConfirmPass] = useState('');
  const [passError, setPassError] = useState('');
  const [saving, setSaving] = useState(false);

  const handleUpdateProfile = async (e: React.FormEvent) => {
    e.preventDefault();
    setSaving(true);
    setSuccessMsg('');
    try {
      const userId = user?.id;
      if (userId) {
        await apiUsuarios.put(`/${userId}`, {
          telefono: phone,
          cargo,
        });
      }
      setSuccessMsg('Perfil actualizado con éxito');
      setEditing(false);
    } catch (error) {
      console.error('Error updating profile:', error);
      setSuccessMsg('');
    } finally {
      setSaving(false);
      setTimeout(() => setSuccessMsg(''), 4000);
    }
  };

  const handleChangePassword = async (e: React.FormEvent) => {
    e.preventDefault();
    setPassError('');
    if (newPass !== confirmPass) {
      setPassError('La nueva contraseña y la confirmación no coinciden.');
      return;
    }
    setSaving(true);
    try {
      const userId = user?.id;
      if (userId) {
        await apiUsuarios.patch(`/${userId}/password`, {
          currentPassword: currentPass,
          newPassword: newPass,
        });
      }
      setSuccessMsg('Contraseña cambiada exitosamente');
      setCurrentPass('');
      setNewPass('');
      setConfirmPass('');
    } catch (error) {
      console.error('Error changing password:', error);
      setPassError('Error al cambiar la contraseña. Verifique su contraseña actual.');
    } finally {
      setSaving(false);
      setTimeout(() => setSuccessMsg(''), 4000);
    }
  };

  // Logs de Auditoría Simulado para el Senior
  const activityLogs = [
    { id: 1, action: 'Inicio de Sesión Exitoso', ip: '192.168.1.15', device: 'Linux (Chrome)', time: 'Hace 5 minutos' },
    { id: 2, action: 'Actualización de Inventario', ip: '192.168.1.15', device: 'Linux (Chrome)', time: 'Hace 45 minutos' },
    { id: 3, action: 'Creación de Categoría Postres', ip: '192.168.1.15', device: 'Linux (Chrome)', time: 'Hace 2 horas' },
    { id: 4, action: 'Modificación de Sucursal Costanera', ip: '200.12.89.4', device: 'Mac OS (Safari)', time: 'Ayer, 18:32' },
  ];

  return (
    <PageContainer>
      <div className="mb-6">
        <h1 className="text-2xl font-bold tracking-tight text-surface-900 flex items-center gap-2">
          <UserCircle className="w-6 h-6 text-primary-500" />
          Mi Perfil de Usuario
        </h1>
        <p className="text-surface-500">Visualiza tu nivel de privilegios y administra la seguridad de tu credencial.</p>
      </div>

      {successMsg && (
        <div className="bg-green-500/10 border border-green-500/25 text-green-200 text-sm rounded-xl p-4 mb-6 animate-in fade-in duration-300">
          {successMsg}
        </div>
      )}

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        {/* Columna Izquierda: Ficha del Colaborador */}
        <div className="lg:col-span-1 space-y-6">
          <Card className="border border-white/5 bg-surface-900/40 backdrop-blur-md overflow-hidden relative">
            {/* Header decorativo de fondo */}
            <div className="h-28 w-full bg-gradient-to-r from-primary-600 to-indigo-600 absolute top-0 left-0 z-0 opacity-80" />
            
            <CardContent className="pt-16 pb-6 relative z-10 flex flex-col items-center">
              {/* Avatar circular premium */}
              <div className="h-24 w-24 rounded-full bg-surface-800 border-4 border-surface-900 shadow-xl flex items-center justify-center text-primary-400 font-extrabold text-3xl mb-3 select-none relative">
                {user?.username?.charAt(0).toUpperCase() ?? 'U'}
                <span className="absolute bottom-1 right-1 h-3.5 w-3.5 rounded-full bg-green-500 border-2 border-surface-900" title="En línea" />
              </div>
              
              <h2 className="text-lg font-bold text-white mt-1">{user?.username}</h2>
              <p className="text-xs text-surface-400 font-mono mt-0.5">{user?.username || 'roberto.admin@restaurant.cl'}</p>
              
              <div className="flex flex-wrap justify-center gap-1.5 mt-3">
                {user?.roles.map((role) => (
                  <Badge key={role} className="bg-primary-500/10 text-primary-400 border border-primary-500/20 text-[10px] font-mono py-0.5 px-2">
                    {role}
                  </Badge>
                ))}
              </div>

              <hr className="w-full border-white/5 my-5" />

              {/* Parámetros de asignación */}
              <div className="w-full space-y-3.5 text-sm text-surface-300">
                <div className="flex items-center gap-2.5">
                  <ShieldCheck className="w-4 h-4 text-primary-400 shrink-0" />
                  <div>
                    <p className="text-[10px] text-surface-500 leading-none">Cargo Asignado</p>
                    <p className="font-semibold mt-0.5">{cargo}</p>
                  </div>
                </div>

                <div className="flex items-center gap-2.5">
                  <MapPin className="w-4 h-4 text-primary-400 shrink-0" />
                  <div>
                    <p className="text-[10px] text-surface-500 leading-none">Sucursal Principal</p>
                    <p className="font-semibold mt-0.5">{sucursal}</p>
                  </div>
                </div>

                <div className="flex items-center gap-2.5">
                  <Calendar className="w-4 h-4 text-primary-400 shrink-0" />
                  <div>
                    <p className="text-[10px] text-surface-500 leading-none">Cuenta Creada</p>
                    <p className="font-semibold mt-0.5">May 17, 2026</p>
                  </div>
                </div>
              </div>
              
              <Button variant="destructive" onClick={logout} className="w-full mt-6 text-xs font-bold bg-red-600 hover:bg-red-700 text-white">
                Cerrar Sesión
              </Button>
            </CardContent>
          </Card>
        </div>

        {/* Columna Derecha: Configuración y Seguridad */}
        <div className="lg:col-span-2 space-y-6">
          {/* Ficha Mis Datos */}
          <Card className="border border-white/5 bg-surface-900/40 backdrop-blur-md">
            <CardHeader className="border-b border-white/5 pb-4">
              <CardTitle className="text-base font-bold text-white flex items-center gap-2">
                <UserCircle className="w-5 h-5 text-primary-400" />
                Ficha del Colaborador
              </CardTitle>
            </CardHeader>
            <CardContent className="pt-6">
              <form onSubmit={handleUpdateProfile} className="space-y-4">
                <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                  <div className="space-y-2">
                    <label className="text-sm font-semibold text-surface-200">Usuario Principal</label>
                    <Input 
                      value={user?.username ?? ''} 
                      disabled 
                      className="bg-white/5 border-white/10 text-surface-400"
                    />
                  </div>
                  
                  <div className="space-y-2">
                    <label className="text-sm font-semibold text-surface-200">Email Corporativo</label>
                    <Input 
                      value={user?.username ?? 'roberto.admin@restaurant.cl'} 
                      disabled 
                      className="bg-white/5 border-white/10 text-surface-400"
                    />
                  </div>

                  <div className="space-y-2">
                    <label htmlFor="prof-phone" className="text-sm font-semibold text-surface-200">Teléfono Móvil</label>
                    <Input 
                      id="prof-phone"
                      value={phone} 
                      onChange={(e) => setPhone(e.target.value)} 
                      disabled={!editing}
                      className={`bg-white/5 border-white/10 text-white ${!editing && 'text-surface-400'}`}
                    />
                  </div>

                  <div className="space-y-2">
                    <label htmlFor="prof-cargo" className="text-sm font-semibold text-surface-200">Cargo Organizacional</label>
                    <Input 
                      id="prof-cargo"
                      value={cargo} 
                      onChange={(e) => setCargo(e.target.value)} 
                      disabled={!editing}
                      className={`bg-white/5 border-white/10 text-white ${!editing && 'text-surface-400'}`}
                    />
                  </div>
                </div>

                <div className="flex justify-end gap-3 mt-6 pt-4 border-t border-white/5">
                  {editing ? (
                    <>
                      <Button variant="outline" type="button" onClick={() => setEditing(false)}>
                        Cancelar
                      </Button>
                      <Button type="submit" disabled={saving} className="shadow-lg shadow-primary-500/10 gap-1.5">
                        {saving ? 'Guardando...' : (<><Save className="w-4 h-4" /> Guardar Cambios</>)}
                      </Button>
                    </>
                  ) : (
                    <Button variant="outline" type="button" onClick={() => setEditing(true)}>
                      Editar Ficha
                    </Button>
                  )}
                </div>
              </form>
            </CardContent>
          </Card>

          {/* Ficha Seguridad */}
          <Card className="border border-white/5 bg-surface-900/40 backdrop-blur-md">
            <CardHeader className="border-b border-white/5 pb-4">
              <CardTitle className="text-base font-bold text-white flex items-center gap-2">
                <Lock className="w-5 h-5 text-primary-400" />
                Seguridad de la Credencial
              </CardTitle>
            </CardHeader>
            <CardContent className="pt-6">
              {passError && (
                <div className="bg-red-500/10 border border-red-500/20 text-red-200 text-xs rounded-lg p-3 mb-4">
                  {passError}
                </div>
              )}
              
              <form onSubmit={handleChangePassword} className="space-y-4">
                <div className="space-y-2">
                  <label htmlFor="sec-curr" className="text-sm font-semibold text-surface-200">Contraseña Actual</label>
                  <Input 
                    id="sec-curr"
                    type="password" 
                    value={currentPass} 
                    onChange={(e) => setCurrentPass(e.target.value)} 
                    placeholder="Ingrese su contraseña actual" 
                    required 
                    className="bg-white/5 border-white/10 text-white focus-visible:ring-primary-500"
                  />
                </div>

                <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                  <div className="space-y-2">
                    <label htmlFor="sec-new" className="text-sm font-semibold text-surface-200">Nueva Contraseña</label>
                    <Input 
                      id="sec-new"
                      type="password" 
                      value={newPass} 
                      onChange={(e) => setNewPass(e.target.value)} 
                      placeholder="Mínimo 6 caracteres" 
                      required 
                      className="bg-white/5 border-white/10 text-white focus-visible:ring-primary-500"
                    />
                  </div>
                  <div className="space-y-2">
                    <label htmlFor="sec-conf" className="text-sm font-semibold text-surface-200">Confirmar Nueva Contraseña</label>
                    <Input 
                      id="sec-conf"
                      type="password" 
                      value={confirmPass} 
                      onChange={(e) => setConfirmPass(e.target.value)} 
                      placeholder="Repita la nueva contraseña" 
                      required 
                      className="bg-white/5 border-white/10 text-white focus-visible:ring-primary-500"
                    />
                  </div>
                </div>

                <div className="flex justify-end mt-6 pt-4 border-t border-white/5">
                  <Button type="submit" className="shadow-lg shadow-primary-500/10">
                    Cambiar Contraseña
                  </Button>
                </div>
              </form>
            </CardContent>
          </Card>

          {/* Historial de Auditoría de Acceso */}
          <Card className="border border-white/5 bg-surface-900/40 backdrop-blur-md">
            <CardHeader className="border-b border-white/5 pb-4">
              <CardTitle className="text-base font-bold text-white flex items-center gap-2">
                <Terminal className="w-5 h-5 text-primary-400" />
                Bitácora de Auditoría y Acceso
              </CardTitle>
            </CardHeader>
            <CardContent className="pt-4 p-0">
              <div className="divide-y divide-white/5">
                {activityLogs.map((log) => (
                  <div key={log.id} className="p-4 flex items-center justify-between hover:bg-white/[0.01] transition-all">
                    <div className="flex items-center gap-3">
                      <div className="h-8 w-8 rounded-lg bg-surface-800 border border-white/5 flex items-center justify-center text-surface-400">
                        {log.device.includes('Chrome') ? <Globe className="w-4 h-4" /> : <Smartphone className="w-4 h-4" />}
                      </div>
                      <div>
                        <p className="text-sm font-semibold text-white">{log.action}</p>
                        <p className="text-xs text-surface-500">{log.device} • IP: {log.ip}</p>
                      </div>
                    </div>
                    <span className="text-xs text-surface-400">{log.time}</span>
                  </div>
                ))}
              </div>
            </CardContent>
          </Card>
        </div>
      </div>
    </PageContainer>
  );
};

export default ProfilePage;
