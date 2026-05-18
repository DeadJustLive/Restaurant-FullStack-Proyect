import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../contexts/AuthContext';
import { apiAuth } from '../api/axios';
import { Button } from '../components/ui/Button';
import { Input } from '../components/ui/Input';

const LoginPage: React.FC = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);
  const { login } = useAuth();
  const navigate = useNavigate();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError('');

    if (password.length < 6) {
      setError('La contraseña debe tener al menos 6 caracteres');
      return;
    }

    setLoading(true);

    try {
      const response = await apiAuth.post('/login', { username, password });
      const { token, rol, username: user, id } = response.data;
      const credencialId = String(id || 1);
      const userData = {
        id: credencialId,
        username: user || username,
        roles: [rol],
      };
      login(token, userData, credencialId);
      navigate('/dashboard');
    } catch (err: any) {
      const data = err.response?.data;
      let msg = 'Credenciales inválidas';
      if (data) {
        if (data.errores && typeof data.errores === 'object') {
          msg = Object.values(data.errores).join('. ');
        } else if (data.mensaje) {
          msg = data.mensaje;
        } else if (data.message) {
          msg = data.message;
        } else if (data.error) {
          msg = data.error;
        }
      }
      setError(msg);
    } finally {
      setLoading(false);
    }
  };

  return (
    <form onSubmit={handleSubmit} className="space-y-6">
      <div className="space-y-2">
        <h2 className="text-xl font-semibold text-white">Iniciar Sesión</h2>
        <p className="text-sm text-surface-400">Ingresa tus credenciales para acceder</p>
      </div>

      {error && (
        <div className="bg-red-500/20 border border-red-400/50 text-red-200 text-sm rounded-lg p-3">
          {error}
        </div>
      )}

      <div className="space-y-4">
        <div className="space-y-2">
          <label htmlFor="login-username" className="text-sm font-medium text-surface-200">
            Email
          </label>
          <Input
            id="login-username"
            type="email"
            placeholder="tu@email.com"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
            disabled={loading}
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
            disabled={loading}
            className="bg-white/10 border-white/20 text-white placeholder:text-surface-400 focus-visible:ring-primary-400"
          />
        </div>
      </div>

      <Button type="submit" className="w-full" variant="default" size="lg" disabled={loading}>
        {loading ? 'Ingresando...' : 'Entrar'}
      </Button>
    </form>
  );
};

export default LoginPage;