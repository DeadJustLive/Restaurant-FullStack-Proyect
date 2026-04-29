import React from 'react';

const BacklogPage: React.FC = () => {
  return (
    <div className="backlog-page">
      <h1>Backlog de Tareas</h1>
      <div className="backlog-container">
        <section className="backlog-section">
          <h3>Prioridad Alta</h3>
          <div className="task-item">Corregir error en ms-pagos</div>
          <div className="task-item">Actualizar precios menú</div>
        </section>
        <section className="backlog-section">
          <h3>En Progreso</h3>
          <div className="task-item">Diseño de reportes mensuales</div>
        </section>
      </div>
    </div>
  );
};

export default BacklogPage;
