import React from 'react';
import { NavLink } from 'react-router-dom';

const Sidebar: React.FC = () => {
  return (
    <aside className="sidebar">
      <div className="sidebar-logo">
        <h2>RESTAURANT</h2>
      </div>
      <nav className="sidebar-nav">
        <ul>
          <li>
            <NavLink to="/dashboard">Dashboard</NavLink>
          </li>
          <li>
            <NavLink to="/projects">Proyectos</NavLink>
          </li>
          <li>
            <NavLink to="/backlog">Backlog</NavLink>
          </li>
          <li>
            <NavLink to="/profile">Perfil</NavLink>
          </li>
        </ul>
      </nav>
    </aside>
  );
};

export default Sidebar;
