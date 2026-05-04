import React from 'react';
import { useAuth } from '../contexts/AuthContext';
import { PageContainer } from '../layouts/PageContainer';
import { Card, CardHeader, CardTitle, CardContent } from '../components/ui/Card';
import { Badge } from '../components/ui/Badge';
import { Button } from '../components/ui/Button';

const ProfilePage: React.FC = () => {
  const { user, logout } = useAuth();

  return (
    <PageContainer>
      <div>
        <h2 className="text-2xl font-bold tracking-tight text-surface-900">Mi Perfil</h2>
        <p className="text-surface-500">Información de tu cuenta</p>
      </div>

      <Card className="max-w-lg">
        <CardHeader>
          <CardTitle>Datos del Usuario</CardTitle>
        </CardHeader>
        <CardContent className="space-y-4">
          <div className="flex items-center gap-4">
            <div className="h-16 w-16 rounded-full bg-primary-100 flex items-center justify-center text-primary-700 font-bold text-2xl">
              {user?.username?.charAt(0).toUpperCase() ?? 'U'}
            </div>
            <div>
              <p className="font-semibold text-surface-900">{user?.username}</p>
              <div className="flex gap-1 mt-1">
                {user?.roles.map((role) => (
                  <Badge key={role} variant="primary">{role}</Badge>
                ))}
              </div>
            </div>
          </div>

          <hr className="border-surface-200" />

          <div className="flex gap-2">
            <Button variant="outline">Editar Perfil</Button>
            <Button variant="destructive" onClick={logout}>Cerrar Sesión</Button>
          </div>
        </CardContent>
      </Card>
    </PageContainer>
  );
};

export default ProfilePage;
