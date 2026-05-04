import React from 'react';

interface ModalProps {
  isOpen: boolean;
  onClose: () => void;
  title: string;
  children: React.ReactNode;
}

/**
 * Modal — Componente base para ventanas emergentes.
 * Utiliza named export para consistencia en el proyecto.
 */
export const Modal: React.FC<ModalProps> = ({ isOpen, onClose, title, children }) => {
  if (!isOpen) return null;

  return (
    <div 
      className="fixed inset-0 z-[100] flex items-center justify-center p-4 bg-surface-900/60 backdrop-blur-sm animate-in fade-in duration-200" 
      onClick={onClose}
    >
      <div 
        className="bg-white rounded-2xl shadow-2xl border border-surface-200 w-full max-w-lg overflow-hidden animate-in zoom-in-95 duration-200" 
        onClick={(e) => e.stopPropagation()}
      >
        <div className="flex items-center justify-between px-6 py-4 border-b border-surface-100">
          <h3 className="text-lg font-bold text-surface-900">{title}</h3>
          <button 
            className="p-2 rounded-lg text-surface-400 hover:bg-surface-100 hover:text-surface-900 transition-colors" 
            onClick={onClose}
          >
            <svg className="w-5 h-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M6 18L18 6M6 6l12 12" />
            </svg>
          </button>
        </div>
        <div className="p-6">
          {children}
        </div>
      </div>
    </div>
  );
};
