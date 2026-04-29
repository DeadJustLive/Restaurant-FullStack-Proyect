import React from 'react';
import { useAuth } from '../contexts/AuthContext';

const ProfilePage: React.FC = () => {
  const { user } = useAuth();

  return (
    <div className="profile-page">
      <h1>Perfil de Usuario</h1>
      <div className="profile-card">
        <p><strong>Username:</strong> {user?.username}</p>
        <p><strong>Roles:</strong> {user?.roles.join(', ')}</p>
        <button className="btn-secondary">Editar Perfil</button>
      </div>
    </div>
  );
};

export default ProfilePage;
