import React from 'react';
import { Outlet } from 'react-router-dom';

const AuthLayout: React.FC = () => {
  return (
    <div className="auth-layout">
      <div className="auth-container">
        <header className="auth-header">
          <h1>Restaurant Admin</h1>
        </header>
        <main className="auth-content">
          <Outlet />
        </main>
        <footer className="auth-footer">
          <p>&copy; 2026 Restaurant Management System</p>
        </footer>
      </div>
    </div>
  );
};

export default AuthLayout;
