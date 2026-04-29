import React from 'react';

const ProjectsPage: React.FC = () => {
  return (
    <div className="projects-page">
      <header className="page-header">
        <h1>Proyectos Colaborativos</h1>
        <button className="btn-primary">Nuevo Proyecto</button>
      </header>
      <table className="data-table">
        <thead>
          <tr>
            <th>Nombre</th>
            <th>Líder</th>
            <th>Estado</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Mejora de Carta Verano</td>
            <td>Juan Pérez</td>
            <td><span className="badge badge-active">Activo</span></td>
            <td><button className="btn-text">Ver detalle</button></td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default ProjectsPage;
