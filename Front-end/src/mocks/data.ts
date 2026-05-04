/**
 * ═══════════════════════════════════════════════════════════════════
 * @MOCK — ARCHIVO DE DATOS SIMULADOS
 * ═══════════════════════════════════════════════════════════════════
 * 
 * PROPÓSITO: Proveer datos mock tipados para desarrollo frontend
 * cuando los microservicios (ms-pedidos, ms-menu, ms-inventario)
 * no están disponibles.
 * 
 * ⚠️  ELIMINAR ESTE ARCHIVO cuando la integración con el backend
 *     esté completa. Reemplazar las importaciones por llamadas
 *     reales via useFetch() + apiPedidos/apiMenu.
 * ═══════════════════════════════════════════════════════════════════
 */

// ─── Tipos compartidos ───────────────────────────────────────────

export type EstadoPedido = 
  | 'PENDIENTE' 
  | 'CONFIRMADO' 
  | 'EN_PREPARACION' 
  | 'LISTO' 
  | 'EN_CAMINO' 
  | 'ENTREGADO' 
  | 'CANCELADO';

export type TipoPedido = 'EN_LOCAL' | 'DELIVERY';

export interface PedidoItemMock {
  id: number;
  menuItemId: number;
  nombreSnapshot: string;
  precioUnitario: number;
  cantidad: number;
  subtotal: number;
  notas?: string;
}

export interface PedidoMock {
  id: number;
  numeroPedido: string;
  usuarioId: number;
  sucursalId: number;
  mesaId?: number;
  estado: EstadoPedido;
  tipo: TipoPedido;
  total: number;
  notas?: string;
  items: PedidoItemMock[];
  creadoEn: string;
  actualizadoEn: string;
}

export interface MenuItemMock {
  id: number;
  nombre: string;
  descripcion: string;
  precio: number;
  imagenUrl?: string;
  disponible: boolean;
  categoriaId: number;
  categoriaNombre: string;
}

export interface MesaMock {
  id: number;
  nombre: string;
  capacidad: number;
  ocupada: boolean;
  pedidoActivo?: PedidoMock;
}

// ─── Datos Mock ──────────────────────────────────────────────────

/** @MOCK — Menú de ejemplo */
export const MOCK_MENU_ITEMS: MenuItemMock[] = [
  { id: 1, nombre: 'Hamburguesa Clásica', descripcion: 'Carne 200g, queso cheddar, lechuga, tomate', precio: 8500, disponible: true, categoriaId: 1, categoriaNombre: 'Hamburguesas' },
  { id: 2, nombre: 'Hamburguesa Doble', descripcion: 'Doble carne 400g, doble queso, bacon', precio: 12000, disponible: true, categoriaId: 1, categoriaNombre: 'Hamburguesas' },
  { id: 3, nombre: 'Pizza Margarita', descripcion: 'Salsa de tomate, mozzarella, albahaca', precio: 9800, disponible: true, categoriaId: 2, categoriaNombre: 'Pizzas' },
  { id: 4, nombre: 'Pizza Pepperoni', descripcion: 'Salsa de tomate, mozzarella, pepperoni', precio: 11500, disponible: true, categoriaId: 2, categoriaNombre: 'Pizzas' },
  { id: 5, nombre: 'Papas Fritas', descripcion: 'Porción grande con sal y kétchup', precio: 3500, disponible: true, categoriaId: 3, categoriaNombre: 'Acompañamientos' },
  { id: 6, nombre: 'Ensalada César', descripcion: 'Lechuga romana, parmesano, crutones, aderezo', precio: 6200, disponible: true, categoriaId: 3, categoriaNombre: 'Acompañamientos' },
  { id: 7, nombre: 'Coca-Cola 500ml', descripcion: 'Bebida gaseosa', precio: 2000, disponible: true, categoriaId: 4, categoriaNombre: 'Bebidas' },
  { id: 8, nombre: 'Agua Mineral', descripcion: '500ml sin gas', precio: 1200, disponible: true, categoriaId: 4, categoriaNombre: 'Bebidas' },
  { id: 9, nombre: 'Limonada Natural', descripcion: 'Limón fresco, menta, miel', precio: 3000, disponible: false, categoriaId: 4, categoriaNombre: 'Bebidas' },
];

/** @MOCK — Pedidos activos en cocina */
export const MOCK_PEDIDOS: PedidoMock[] = [
  {
    id: 1, numeroPedido: 'PED-20260503-001', usuarioId: 10, sucursalId: 1, mesaId: 3,
    estado: 'CONFIRMADO', tipo: 'EN_LOCAL', total: 22000,
    notas: 'Sin cebolla en la hamburguesa',
    items: [
      { id: 1, menuItemId: 1, nombreSnapshot: 'Hamburguesa Clásica', precioUnitario: 8500, cantidad: 2, subtotal: 17000 },
      { id: 2, menuItemId: 5, nombreSnapshot: 'Papas Fritas', precioUnitario: 3500, cantidad: 1, subtotal: 3500 },
      { id: 3, menuItemId: 7, nombreSnapshot: 'Coca-Cola 500ml', precioUnitario: 2000, cantidad: 1, subtotal: 2000, notas: 'Con hielo' },
    ],
    creadoEn: '2026-05-03T18:30:00', actualizadoEn: '2026-05-03T18:32:00',
  },
  {
    id: 2, numeroPedido: 'PED-20260503-002', usuarioId: 11, sucursalId: 1, mesaId: 5,
    estado: 'EN_PREPARACION', tipo: 'EN_LOCAL', total: 23300,
    items: [
      { id: 4, menuItemId: 3, nombreSnapshot: 'Pizza Margarita', precioUnitario: 9800, cantidad: 1, subtotal: 9800 },
      { id: 5, menuItemId: 2, nombreSnapshot: 'Hamburguesa Doble', precioUnitario: 12000, cantidad: 1, subtotal: 12000 },
      { id: 6, menuItemId: 8, nombreSnapshot: 'Agua Mineral', precioUnitario: 1200, cantidad: 1, subtotal: 1200, notas: 'Bien fría' },
    ],
    creadoEn: '2026-05-03T18:15:00', actualizadoEn: '2026-05-03T18:20:00',
  },
  {
    id: 3, numeroPedido: 'PED-20260503-003', usuarioId: 12, sucursalId: 1,
    estado: 'CONFIRMADO', tipo: 'DELIVERY', total: 15500,
    notas: 'Dejar en portería',
    items: [
      { id: 7, menuItemId: 4, nombreSnapshot: 'Pizza Pepperoni', precioUnitario: 11500, cantidad: 1, subtotal: 11500 },
      { id: 8, menuItemId: 7, nombreSnapshot: 'Coca-Cola 500ml', precioUnitario: 2000, cantidad: 2, subtotal: 4000 },
    ],
    creadoEn: '2026-05-03T18:35:00', actualizadoEn: '2026-05-03T18:35:00',
  },
  {
    id: 4, numeroPedido: 'PED-20260503-004', usuarioId: 13, sucursalId: 1, mesaId: 6,
    estado: 'LISTO', tipo: 'EN_LOCAL', total: 11700,
    items: [
      { id: 9, menuItemId: 1, nombreSnapshot: 'Hamburguesa Clásica', precioUnitario: 8500, cantidad: 1, subtotal: 8500 },
      { id: 10, menuItemId: 5, nombreSnapshot: 'Papas Fritas', precioUnitario: 3500, cantidad: 1, subtotal: 3500, notas: 'Extra sal' },
    ],
    creadoEn: '2026-05-03T18:00:00', actualizadoEn: '2026-05-03T18:25:00',
  },
];

/** @MOCK — Mesas del salón */
export const MOCK_MESAS: MesaMock[] = [
  { id: 1, nombre: 'Mesa 1', capacidad: 4, ocupada: false },
  { id: 2, nombre: 'Mesa 2', capacidad: 2, ocupada: false },
  { id: 3, nombre: 'Mesa 3', capacidad: 6, ocupada: true, pedidoActivo: MOCK_PEDIDOS[0] },
  { id: 4, nombre: 'Mesa 4', capacidad: 4, ocupada: false },
  { id: 5, nombre: 'Mesa 5', capacidad: 8, ocupada: true, pedidoActivo: MOCK_PEDIDOS[1] },
  { id: 6, nombre: 'Mesa 6', capacidad: 4, ocupada: true, pedidoActivo: MOCK_PEDIDOS[3] },
  { id: 7, nombre: 'Mesa 7', capacidad: 2, ocupada: false },
  { id: 8, nombre: 'Mesa 8', capacidad: 4, ocupada: false },
];

// ─── Helpers para simular operaciones de escritura ───────────────

/** @MOCK — Mapa de transiciones válidas de estado */
export const TRANSICIONES_VALIDAS: Record<EstadoPedido, EstadoPedido[]> = {
  PENDIENTE: ['CONFIRMADO', 'CANCELADO'],
  CONFIRMADO: ['EN_PREPARACION', 'CANCELADO'],
  EN_PREPARACION: ['LISTO'],
  LISTO: ['EN_CAMINO', 'ENTREGADO'],
  EN_CAMINO: ['ENTREGADO'],
  ENTREGADO: [],
  CANCELADO: [],
};

/** @MOCK — Formateador de precio chileno */
export const formatPrecio = (precio: number): string => {
  return `$${precio.toLocaleString('es-CL')}`;
};

/** @MOCK — Calcular tiempo transcurrido desde creación */
export const tiempoTranscurrido = (fechaISO: string): string => {
  const diff = Date.now() - new Date(fechaISO).getTime();
  const mins = Math.floor(diff / 60000);
  if (mins < 1) return 'ahora';
  if (mins < 60) return `${mins} min`;
  return `${Math.floor(mins / 60)}h ${mins % 60}m`;
};
