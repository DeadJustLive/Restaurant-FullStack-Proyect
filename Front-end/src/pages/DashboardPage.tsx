import React from 'react';

const DashboardPage: React.FC = () => {
  return (
    <div className="dashboard-page">
      <h1>Dashboard Principal</h1>
      <div className="stats-grid">
        <div className="stat-card">
          <h3>Ventas Hoy</h3>
          <p className="value">$450,000</p>
        </div>
        <div className="stat-card">
          <h3>Pedidos Activos</h3>
          <p className="value">12</p>
        </div>
        <div className="stat-card">
          <h3>Stock Bajo</h3>
          <p className="value">3 items</p>
        </div>
      </div>
    </div>
  );
};

export default DashboardPage;
