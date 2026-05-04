import React, { useState } from 'react';
import { Modal } from '../Modal';
import { NavModuleItem } from './NavModuleItem';
import { NavItem } from '../../config/navigation';
import { Input } from '../ui/Input';
import { Search } from 'lucide-react';

interface ModulesLauncherModalProps {
  isOpen: boolean;
  onClose: () => void;
  items: NavItem[];
}

/**
 * ModulesLauncherModal — Panel de exploración de módulos.
 * Incluye búsqueda integrada para escalabilidad cuando existan muchos módulos.
 */
export const ModulesLauncherModal: React.FC<ModulesLauncherModalProps> = ({ 
  isOpen, 
  onClose, 
  items 
}) => {
  const [search, setSearch] = useState('');

  const filteredItems = items.filter(item => 
    item.title.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <Modal 
      isOpen={isOpen} 
      onClose={() => {
        onClose();
        setSearch(''); // Limpiar búsqueda al cerrar
      }} 
      title="Explorar Módulos"
    >
      <div className="space-y-6">
        {/* Barra de Búsqueda (Escalabilidad) */}
        <div className="relative">
          <Search className="absolute left-3 top-1/2 -translate-y-1/2 w-4 h-4 text-surface-400" />
          <Input
            placeholder="Buscar módulo..."
            className="pl-10"
            value={search}
            onChange={(e) => setSearch(e.target.value)}
          />
        </div>

        {/* Grid de Módulos */}
        <div className="grid grid-cols-2 sm:grid-cols-3 gap-4 max-h-[60vh] overflow-y-auto p-1 scrollbar-hide">
          {filteredItems.length > 0 ? (
            filteredItems.map((item) => (
              <NavModuleItem key={item.id} item={item} onClick={onClose} />
            ))
          ) : (
            <div className="col-span-full py-12 text-center text-surface-500">
              No se encontraron módulos con "{search}"
            </div>
          )}
        </div>
      </div>
    </Modal>
  );
};
