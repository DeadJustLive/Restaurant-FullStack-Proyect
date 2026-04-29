import React from 'react';
import { useAuth } from '../contexts/AuthContext';

const Navbar: React.FC = () => {
  const { user, logout } = useAuth();

  return (
    <header className="navbar">
      <div className="navbar-search">
        <input type="text" placeholder="Buscar..." />
      </div>
      <div className="navbar-user">
        <span>Hola, {user?.username}</span>
        <button onClick={logout} className="btn-logout">Cerrar Sesión</button>
      </div>
    </header>
  );
};

export default Navbar;
