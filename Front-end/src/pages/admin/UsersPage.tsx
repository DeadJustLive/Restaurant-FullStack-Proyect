import React, { useState, useEffect } from 'react';
import { PageContainer } from '../../layouts/PageContainer';
import { Card, CardHeader, CardTitle, CardContent } from '../../components/ui/Card';
import { Button } from '../../components/ui/Button';
import { Input } from '../../components/ui/Input';
import { Badge } from '../../components/ui/Badge';
import { apiUsuarios } from '../../api/axios';
import { UserPlus, Edit2, Eye, Trash2, CheckCircle2, XCircle } from 'lucide-react';
import { navigationConfig, Role } from '../../config/navigation';

interface User {
  id: number;
  username: string;
  email: string;
  roles: Role[];
  enabledModules: string[];
  active: boolean;
}

const ROLES: Role[] = ['ROLE_SA', 'ROLE_AD', 'ROLE_CO', 'ROLE_ME', 'ROLE_RP', 'ROLE_CL'];

export const UsersPage: React.FC = () => {
  const [users, setUsers] = useState<User[]>([]);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [selectedUser, setSelectedUser] = useState<Partial<User> | null>(null);

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    try {
      const response = await apiUsuarios.get('/');
      setUsers(response.data);
    } catch (error) {
      console.error('Error fetching users:', error);
      // Fallback para demo si el MS no está arriba
      setUsers([
        { 
          id: 1, 
          username: 'admin', 
          email: 'admin@triskel.edu', 
          roles: ['ROLE_SA'], 
          enabledModules: navigationConfig.map(i => i.id),
          active: true 
        }
      ]);
    }
  };

  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: '',
    roles: ['ROLE_CL'] as Role[],
    enabledModules: navigationConfig.map(i => i.id),
    active: true,
  });

  const handleOpenCreateModal = () => {
    setFormData({
      username: '',
      email: '',
      password: '',
      roles: ['ROLE_CL'],
      enabledModules: navigationConfig.map(i => i.id),
      active: true,
    });
    setSelectedUser({});
    setIsModalOpen(true);
  };

  const handleOpenEditModal = (user: User) => {
    setFormData({
      username: user.username,
      email: user.email,
      password: '',
      roles: user.roles,
      enabledModules: user.enabledModules,
      active: user.active,
    });
    setSelectedUser(user);
    setIsModalOpen(true);
  };

  const handleSave = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      if (selectedUser?.id) {
        await apiUsuarios.put(`/${selectedUser.id}`, {
          username: formData.username,
          email: formData.email,
          roles: formData.roles,
          enabledModules: formData.enabledModules,
          active: formData.active,
        });
      } else {
        await apiUsuarios.post('/', {
          username: formData.username,
          email: formData.email,
          password: formData.password,
          roles: formData.roles,
          enabledModules: formData.enabledModules,
          active: formData.active,
        });
      }
      fetchUsers();
      setIsModalOpen(false);
    } catch (error) {
      console.error('Error saving user:', error);
    }
  };

  return (
    <PageContainer>
      <div className="flex items-center justify-between mb-6">
        <div>
          <h1 className="text-2xl font-bold text-surface-900">Gestión de Usuarios</h1>
          <p className="text-surface-500">Administra accesos, roles y visibilidad de módulos.</p>
        </div>
        <Button onClick={handleOpenCreateModal}>
          <UserPlus className="w-4 h-4 mr-2" />
          Nuevo Usuario
        </Button>
      </div>

      <Card>
        <CardContent className="p-0">
          <div className="overflow-x-auto">
            <table className="w-full text-left border-collapse">
              <thead>
                <tr className="border-b border-surface-100 bg-surface-50/50">
                  <th className="px-6 py-4 text-xs font-semibold text-surface-500 uppercase">Usuario</th>
                  <th className="px-6 py-4 text-xs font-semibold text-surface-500 uppercase">Roles</th>
                  <th className="px-6 py-4 text-xs font-semibold text-surface-500 uppercase">Módulos</th>
                  <th className="px-6 py-4 text-xs font-semibold text-surface-500 uppercase">Estado</th>
                  <th className="px-6 py-4 text-xs font-semibold text-surface-500 uppercase text-right">Acciones</th>
                </tr>
              </thead>
              <tbody className="divide-y divide-surface-100">
                {users.map((user) => (
                  <tr key={user.id} className="hover:bg-surface-50/50 transition-colors">
                    <td className="px-6 py-4">
                      <div className="flex items-center gap-3">
                        <div className="h-9 w-9 rounded-full bg-primary-100 flex items-center justify-center text-primary-700 font-bold">
                          {user.username.charAt(0).toUpperCase()}
                        </div>
                        <div>
                          <p className="text-sm font-medium text-surface-900">{user.username}</p>
                          <p className="text-xs text-surface-500">{user.email}</p>
                        </div>
                      </div>
                    </td>
                    <td className="px-6 py-4">
                      <div className="flex flex-wrap gap-1">
                        {user.roles.map(role => (
                          <Badge key={role} variant="outline" className="text-[10px]">
                            {role.replace('ROLE_', '')}
                          </Badge>
                        ))}
                      </div>
                    </td>
                    <td className="px-6 py-4">
                      <div className="flex items-center gap-1 text-surface-400">
                        <Eye className="w-3.5 h-3.5" />
                        <span className="text-xs">{user.enabledModules?.length || 0} habilitados</span>
                      </div>
                    </td>
                    <td className="px-6 py-4">
                      {user.active ? (
                        <div className="flex items-center gap-1.5 text-green-600">
                          <CheckCircle2 className="w-4 h-4" />
                          <span className="text-xs font-medium">Activo</span>
                        </div>
                      ) : (
                        <div className="flex items-center gap-1.5 text-surface-400">
                          <XCircle className="w-4 h-4" />
                          <span className="text-xs font-medium">Inactivo</span>
                        </div>
                      )}
                    </td>
                    <td className="px-6 py-4 text-right">
                      <div className="flex items-center justify-end gap-2">
                        <Button variant="ghost" size="sm" className="h-8 w-8 p-0" onClick={() => handleOpenEditModal(user)}>
                          <Edit2 className="w-3.5 h-3.5" />
                        </Button>
                        <Button variant="ghost" size="sm" className="h-8 w-8 p-0 text-red-500 hover:text-red-600 hover:bg-red-50">
                          <Trash2 className="w-3.5 h-3.5" />
                        </Button>
                      </div>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </CardContent>
      </Card>

      {/* Modal Simplificado para la Demo */}
      {isModalOpen && (
        <div className="fixed inset-0 z-[100] flex items-center justify-center p-4 bg-surface-900/50 backdrop-blur-sm">
          <Card className="w-full max-w-lg shadow-2xl animate-in zoom-in-95 duration-200">
            <CardHeader>
              <CardTitle>{selectedUser?.id ? 'Editar Usuario' : 'Nuevo Usuario'}</CardTitle>
            </CardHeader>
            <CardContent>
              <form onSubmit={handleSave} className="space-y-4">
                {!selectedUser?.id && (
                  <div className="grid grid-cols-2 gap-4">
                    <div className="space-y-2">
                      <label className="text-sm font-medium">Username</label>
                      <Input value={formData.username} onChange={e => setFormData(prev => ({ ...prev, username: e.target.value }))} placeholder="ej: jdoe" required />
                    </div>
                    <div className="space-y-2">
                      <label className="text-sm font-medium">Email</label>
                      <Input type="email" value={formData.email} onChange={e => setFormData(prev => ({ ...prev, email: e.target.value }))} placeholder="ej: juan@mail.com" required />
                    </div>
                  </div>
                )}

                {!selectedUser?.id && (
                  <div className="space-y-2">
                    <label className="text-sm font-medium">Contraseña</label>
                    <Input type="password" value={formData.password} onChange={e => setFormData(prev => ({ ...prev, password: e.target.value }))} placeholder="Mínimo 6 caracteres" required />
                  </div>
                )}

                <div className="space-y-2">
                  <label className="text-sm font-medium">Rol Principal</label>
                  <select
                    value={formData.roles[0]}
                    onChange={e => setFormData(prev => ({ ...prev, roles: [e.target.value as Role] }))}
                    className="w-full h-10 px-3 rounded-lg border border-surface-200 focus:ring-2 focus:ring-primary-500 outline-none transition-all"
                  >
                    {ROLES.map(role => (
                      <option key={role} value={role}>{role}</option>
                    ))}
                  </select>
                </div>

                <div className="space-y-3">
                  <label className="text-sm font-medium">Módulos Visibles (UX)</label>
                  <div className="grid grid-cols-2 gap-2 max-h-40 overflow-y-auto p-2 border border-surface-100 rounded-lg">
                    {navigationConfig.map(item => (
                      <label key={item.id} className="flex items-center gap-2 text-xs p-1.5 hover:bg-surface-50 rounded cursor-pointer">
                        <input
                          type="checkbox"
                          checked={formData.enabledModules.includes(item.id)}
                          onChange={e => {
                            const mods = e.target.checked
                              ? [...formData.enabledModules, item.id]
                              : formData.enabledModules.filter(m => m !== item.id);
                            setFormData(prev => ({ ...prev, enabledModules: mods }));
                          }}
                          className="rounded text-primary-500 focus:ring-primary-500"
                        />
                        {item.title}
                      </label>
                    ))}
                  </div>
                </div>

                <div className="flex justify-end gap-3 mt-6 pt-4 border-t border-surface-100">
                  <Button variant="outline" type="button" onClick={() => setIsModalOpen(false)}>
                    Cancelar
                  </Button>
                  <Button type="submit">
                    Guardar Usuario
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

export default UsersPage;
