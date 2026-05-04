import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../contexts/AuthContext';
import { Button } from '../components/ui/Button';
import { Input } from '../components/ui/Input';

const LoginPage: React.FC = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const { login } = useAuth();
  const navigate = useNavigate();

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    // TODO: Conectar con ms-auth via apiAuth.post('/login', { username, password })
    // Simulación de login exitoso con rol Admin
    login('fake-jwt-token', { id: '1', username, roles: ['ROLE_AD'] });
    navigate('/dashboard');
  };

  return (
    <form onSubmit={handleSubmit} className="space-y-6">
      <div className="space-y-2">
        <h2 className="text-xl font-semibold text-white">Iniciar Sesión</h2>
        <p className="text-sm text-surface-400">Ingresa tus credenciales para acceder</p>
      </div>

      <div className="space-y-4">
        <div className="space-y-2">
          <label htmlFor="login-username" className="text-sm font-medium text-surface-200">
            Usuario
          </label>
          <Input
            id="login-username"
            type="text"
            placeholder="tu.usuario"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
            className="bg-white/10 border-white/20 text-white placeholder:text-surface-400 focus-visible:ring-primary-400"
          />
        </div>
        <div className="space-y-2">
          <label htmlFor="login-password" className="text-sm font-medium text-surface-200">
            Contraseña
          </label>
          <Input
            id="login-password"
            type="password"
            placeholder="••••••••"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
            className="bg-white/10 border-white/20 text-white placeholder:text-surface-400 focus-visible:ring-primary-400"
          />
        </div>
      </div>

      <Button type="submit" className="w-full" variant="default" size="lg">
        Entrar
      </Button>
    </form>
  );
};

export default LoginPage;
