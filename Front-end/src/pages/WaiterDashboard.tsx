import React from 'react';

const WaiterDashboard: React.FC = () => {
  return (
    <div className="waiter-dashboard">
      <header className="page-header">
        <h1>Panel de Mesero</h1>
        <p>Sucursal: Central - Gestión de Mesas</p>
      </header>

      <div className="waiter-actions">
        <button className="btn btn-primary">Nuevo Pedido (Mesa)</button>
        <button className="btn btn-secondary">Ver Comandas</button>
      </div>

      <section className="tables-grid">
        <h2>Estado del Salón</h2>
        <div className="grid">
          {/* Mock tables */}
          {[1, 2, 3, 4, 5, 6].map(table => (
            <div key={table} className={`table-card ${table % 3 === 0 ? 'occupied' : 'free'}`}>
              <h3>Mesa {table}</h3>
              <p>Estado: {table % 3 === 0 ? 'Ocupada' : 'Libre'}</p>
              {table % 3 === 0 && (
                <>
                  <p>Total: $15.500</p>
                  <button className="btn btn-sm btn-success">Cobrar Cuenta</button>
                </>
              )}
            </div>
          ))}
        </div>
      </section>

      <style dangerouslySetInnerHTML={{ __html: `
        .waiter-dashboard { padding: 20px; }
        .page-header { margin-bottom: 30px; }
        .waiter-actions { margin-bottom: 30px; display: flex; gap: 15px; }
        .tables-grid .grid { 
          display: grid; 
          grid-template-columns: repeat(auto-fill, minmax(200px, 1fr)); 
          gap: 20px; 
        }
        .table-card { 
          border: 1px solid #ddd; 
          border-radius: 8px; 
          padding: 15px; 
          text-align: center;
          transition: transform 0.2s;
        }
        .table-card:hover { transform: translateY(-5px); }
        .table-card.occupied { border-left: 5px solid #e74c3c; background: #fff5f5; }
        .table-card.free { border-left: 5px solid #2ecc71; background: #f5fff9; }
        .btn-sm { padding: 5px 10px; font-size: 0.8rem; }
      `}} />
    </div>
  );
};

export default WaiterDashboard;
