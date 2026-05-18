/**
 * @use(*)
 * @kind(util)
 * @limit(lines: 100)
 */

import { AxiosRequestConfig } from 'axios';
import {
  MOCK_MENU_ITEMS as ORIGINAL_MOCK_MENU_ITEMS,
  MOCK_PEDIDOS,
  MOCK_MESAS,
} from '../mocks/data';

interface MockUser {
  id: number;
  username: string;
  email: string;
  roles: string[];
  enabledModules: string[];
  active: boolean;
}

const MOCK_USERS: MockUser[] = [
  {
    id: 1,
    username: 'admin',
    email: 'admin@triskel.edu',
    roles: ['ROLE_SA'],
    enabledModules: ['dashboard', 'mesas', 'cocina', 'entregas', 'menu', 'inventario', 'usuarios'],
    active: true,
  },
  {
    id: 2,
    username: 'cajero1',
    email: 'cajero1@triskel.edu',
    roles: ['ROLE_CO'],
    enabledModules: ['dashboard', 'mesas', 'cocina'],
    active: true,
  },
];

let MOCK_CATEGORIES = [
  { id: 1, nombre: 'Hamburguesas', descripcion: 'Hamburguesas de vacuno y pollo', activa: true, creadoEn: new Date().toISOString(), actualizadoEn: new Date().toISOString() },
  { id: 2, nombre: 'Pizzas', descripcion: 'Pizzas a la piedra', activa: true, creadoEn: new Date().toISOString(), actualizadoEn: new Date().toISOString() },
  { id: 3, nombre: 'Acompañamientos', descripcion: 'Papas fritas y ensaladas', activa: true, creadoEn: new Date().toISOString(), actualizadoEn: new Date().toISOString() },
  { id: 4, nombre: 'Bebidas', descripcion: 'Gaseosas, jugos y aguas', activa: false, creadoEn: new Date().toISOString(), actualizadoEn: new Date().toISOString() },
];

let MOCK_MENU_ITEMS = [...ORIGINAL_MOCK_MENU_ITEMS];

let MOCK_SUCURSALES = [
  { id: 1, nombre: 'Sucursal Providencia', direccion: 'Av. Providencia 1234, Santiago', telefono: '+56 2 2345 6789', activa: true, creadoEn: new Date().toISOString(), actualizadoEn: new Date().toISOString() },
  { id: 2, nombre: 'Sucursal Costanera', direccion: 'Av. Andrés Bello 2425, Providencia', telefono: '+56 2 2345 6790', activa: true, creadoEn: new Date().toISOString(), actualizadoEn: new Date().toISOString() },
  { id: 3, nombre: 'Sucursal Viña del Mar', direccion: 'Av. Libertad 450, Viña del Mar', telefono: '+56 32 2345 6791', activa: false, creadoEn: new Date().toISOString(), actualizadoEn: new Date().toISOString() },
];

let MOCK_INSUMOS = [
  { id: 1, sucursalId: 1, nombre: 'Pan de Hamburguesa', unidadMedida: 'Unidades', stockActual: 120.0, stockMinimo: 20.0, creadoEn: new Date().toISOString(), actualizadoEn: new Date().toISOString() },
  { id: 2, sucursalId: 1, nombre: 'Carne de Vacuno 200g', unidadMedida: 'Unidades', stockActual: 45.0, stockMinimo: 15.0, creadoEn: new Date().toISOString(), actualizadoEn: new Date().toISOString() },
  { id: 3, sucursalId: 1, nombre: 'Queso Cheddar', unidadMedida: 'Kg', stockActual: 15.0, stockMinimo: 5.0, creadoEn: new Date().toISOString(), actualizadoEn: new Date().toISOString() },
  { id: 4, sucursalId: 2, nombre: 'Papas Prefritas', unidadMedida: 'Kg', stockActual: 60.0, stockMinimo: 10.0, creadoEn: new Date().toISOString(), actualizadoEn: new Date().toISOString() },
];

let MOCK_KARDEX = [
  { id: 1, insumoId: 1, tipo: 'ENTRADA', cantidad: 100.0, referencia: 'Compra inicial Proveedor', creadoEn: new Date().toISOString() },
  { id: 2, insumoId: 1, tipo: 'ENTRADA', cantidad: 20.0, referencia: 'Ajuste inventario físico', creadoEn: new Date().toISOString() },
  { id: 3, insumoId: 2, tipo: 'ENTRADA', cantidad: 45.0, referencia: 'Compra inicial', creadoEn: new Date().toISOString() },
  { id: 4, insumoId: 3, tipo: 'ENTRADA', cantidad: 15.0, referencia: 'Compra inicial', creadoEn: new Date().toISOString() },
  { id: 5, insumoId: 4, tipo: 'ENTRADA', cantidad: 60.0, referencia: 'Carga inicial sucursal', creadoEn: new Date().toISOString() },
];

let MOCK_PAGOS = [
  { id: 1, pedidoId: 101, monto: 20500.0, metodo: 'TARJETA_CREDITO', estado: 'APROBADO', transaccionId: 'TX-892401', creadoEn: new Date(Date.now() - 3600000 * 2).toISOString() },
  { id: 2, pedidoId: 102, monto: 12400.0, metodo: 'EFECTIVO', estado: 'APROBADO', transaccionId: 'TX-CASH-991', creadoEn: new Date(Date.now() - 3600000).toISOString() },
  { id: 3, pedidoId: 103, monto: 8500.0, metodo: 'TARJETA_DEBITO', estado: 'PENDIENTE', transaccionId: '', creadoEn: new Date().toISOString() },
];

/**
 * Enruta una petición HTTP simulada a sus correspondientes datos mock.
 * 
 * @param config Configuración de Axios para la petición
 * @returns Datos mock tipados correspondientes
 */
export function getMockDataForRequest(config: AxiosRequestConfig): unknown {
  const url = config.url || '';
  const method = (config.method || 'GET').toUpperCase();
  const baseURL = config.baseURL || '';

  // 0. Sucursales
  if (baseURL.includes('sucursales')) {
    if (method === 'GET') {
      const matchId = url.match(/\/(\d+)$/);
      if (matchId) {
        const id = parseInt(matchId[1], 10);
        return MOCK_SUCURSALES.find(s => s.id === id) || null;
      }
      return MOCK_SUCURSALES;
    }
    if (method === 'POST') {
      const data = config.data ? JSON.parse(config.data) : {};
      const newSuc: any = {
        id: MOCK_SUCURSALES.length > 0 ? Math.max(...MOCK_SUCURSALES.map(s => s.id)) + 1 : 1,
        nombre: data.nombre || 'Nueva Sucursal Mock',
        direccion: data.direccion || 'Dirección Mock',
        telefono: data.telefono || '',
        activa: true,
        creadoEn: new Date().toISOString(),
        actualizadoEn: new Date().toISOString(),
      };
      MOCK_SUCURSALES.push(newSuc);
      return newSuc;
    }
    if (method === 'PUT') {
      const matchId = url.match(/\/(\d+)$/);
      if (matchId) {
        const id = parseInt(matchId[1], 10);
        const data = config.data ? JSON.parse(config.data) : {};
        const idx = MOCK_SUCURSALES.findIndex(s => s.id === id);
        if (idx !== -1) {
          MOCK_SUCURSALES[idx] = {
            ...MOCK_SUCURSALES[idx],
            nombre: data.nombre || MOCK_SUCURSALES[idx].nombre,
            direccion: data.direccion || MOCK_SUCURSALES[idx].direccion,
            telefono: data.telefono || MOCK_SUCURSALES[idx].telefono,
            actualizadoEn: new Date().toISOString(),
          };
          return MOCK_SUCURSALES[idx];
        }
      }
      return null;
    }
    if (method === 'PATCH' && url.includes('/estado')) {
      const matchId = url.match(/\/(\d+)\/estado/);
      if (matchId) {
        const id = parseInt(matchId[1], 10);
        const params = new URLSearchParams(url.split('?')[1] || '');
        const activa = params.get('activa') === 'true';
        const idx = MOCK_SUCURSALES.findIndex(s => s.id === id);
        if (idx !== -1) {
          MOCK_SUCURSALES[idx] = {
            ...MOCK_SUCURSALES[idx],
            activa,
            actualizadoEn: new Date().toISOString(),
          };
          return MOCK_SUCURSALES[idx];
        }
      }
      return null;
    }
    return MOCK_SUCURSALES;
  }

  // 1. Usuarios / Auth
  if (baseURL.includes('auth') || baseURL.includes('usuarios')) {
    if (url.includes('/login') && method === 'POST') {
      return {
        id: 1,
        username: 'admin',
        rol: 'ROLE_SA',
        token: 'mock-jwt-token-xyz-123',
        refreshToken: 'mock-refresh-token-xyz-456',
        expiresIn: 86400,
      };
    }
    return MOCK_USERS;
  }

  // 2. Menú / Categorías
  if (baseURL.includes('categorias')) {
    if (method === 'GET') {
      const matchId = url.match(/\/(\d+)$/);
      if (matchId) {
        const id = parseInt(matchId[1], 10);
        return MOCK_CATEGORIES.find(c => c.id === id) || null;
      }
      return MOCK_CATEGORIES;
    }
    if (method === 'POST') {
      const data = config.data ? JSON.parse(config.data) : {};
      const newCat: any = {
        id: MOCK_CATEGORIES.length > 0 ? Math.max(...MOCK_CATEGORIES.map(c => c.id)) + 1 : 1,
        nombre: data.nombre || 'Nueva Categoría Mock',
        descripcion: data.descripcion || '',
        activa: true,
        creadoEn: new Date().toISOString(),
        actualizadoEn: new Date().toISOString(),
      };
      MOCK_CATEGORIES.push(newCat);
      return newCat;
    }
    if (method === 'PUT') {
      const matchId = url.match(/\/(\d+)$/);
      if (matchId) {
        const id = parseInt(matchId[1], 10);
        const data = config.data ? JSON.parse(config.data) : {};
        const idx = MOCK_CATEGORIES.findIndex(c => c.id === id);
        if (idx !== -1) {
          MOCK_CATEGORIES[idx] = {
            ...MOCK_CATEGORIES[idx],
            nombre: data.nombre || MOCK_CATEGORIES[idx].nombre,
            descripcion: data.descripcion !== undefined ? data.descripcion : MOCK_CATEGORIES[idx].descripcion,
            actualizadoEn: new Date().toISOString(),
          };
          return MOCK_CATEGORIES[idx];
        }
      }
      return null;
    }
    if (method === 'PATCH' && url.includes('/estado')) {
      const matchId = url.match(/\/(\d+)\/estado/);
      if (matchId) {
        const id = parseInt(matchId[1], 10);
        const params = new URLSearchParams(url.split('?')[1] || '');
        const activa = params.get('activa') === 'true';
        const idx = MOCK_CATEGORIES.findIndex(c => c.id === id);
        if (idx !== -1) {
          MOCK_CATEGORIES[idx] = {
            ...MOCK_CATEGORIES[idx],
            activa,
            actualizadoEn: new Date().toISOString(),
          };
          return MOCK_CATEGORIES[idx];
        }
      }
      return null;
    }
    return MOCK_CATEGORIES;
  }
  if (baseURL.includes('menu')) {
    if (method === 'GET') {
      const matchId = url.match(/\/(\d+)$/);
      if (matchId) {
        const id = parseInt(matchId[1], 10);
        return MOCK_MENU_ITEMS.find(m => m.id === id) || null;
      }
      return MOCK_MENU_ITEMS;
    }
    if (method === 'POST') {
      const data = config.data ? JSON.parse(config.data) : {};
      const cat = MOCK_CATEGORIES.find(c => c.id === parseInt(data.categoriaId, 10));
      const newItem: any = {
        id: MOCK_MENU_ITEMS.length > 0 ? Math.max(...MOCK_MENU_ITEMS.map(m => m.id)) + 1 : 1,
        nombre: data.nombre || 'Nuevo Plato Mock',
        descripcion: data.descripcion || '',
        precio: parseFloat(data.precio) || 0.0,
        imagenUrl: data.imagenUrl || '',
        disponible: data.disponible !== undefined ? data.disponible : true,
        categoriaId: parseInt(data.categoriaId, 10) || 1,
        categoriaNombre: cat ? cat.nombre : 'Hamburguesas',
        creadoEn: new Date().toISOString(),
        actualizadoEn: new Date().toISOString(),
      };
      MOCK_MENU_ITEMS.push(newItem);
      return newItem;
    }
    if (method === 'PUT') {
      const matchId = url.match(/\/(\d+)$/);
      if (matchId) {
        const id = parseInt(matchId[1], 10);
        const data = config.data ? JSON.parse(config.data) : {};
        const cat = MOCK_CATEGORIES.find(c => c.id === parseInt(data.categoriaId, 10));
        const idx = MOCK_MENU_ITEMS.findIndex(m => m.id === id);
        if (idx !== -1) {
          MOCK_MENU_ITEMS[idx] = {
            ...MOCK_MENU_ITEMS[idx],
            nombre: data.nombre || MOCK_MENU_ITEMS[idx].nombre,
            descripcion: data.descripcion !== undefined ? data.descripcion : MOCK_MENU_ITEMS[idx].descripcion,
            precio: data.precio !== undefined ? parseFloat(data.precio) : MOCK_MENU_ITEMS[idx].precio,
            imagenUrl: data.imagenUrl !== undefined ? data.imagenUrl : MOCK_MENU_ITEMS[idx].imagenUrl,
            categoriaId: data.categoriaId !== undefined ? parseInt(data.categoriaId, 10) : MOCK_MENU_ITEMS[idx].categoriaId,
            categoriaNombre: cat ? cat.nombre : MOCK_MENU_ITEMS[idx].categoriaNombre,
          };
          return MOCK_MENU_ITEMS[idx];
        }
      }
      return null;
    }
    if (method === 'PATCH' && url.includes('/disponibilidad')) {
      const matchId = url.match(/\/(\d+)\/disponibilidad/);
      if (matchId) {
        const id = parseInt(matchId[1], 10);
        const params = new URLSearchParams(url.split('?')[1] || '');
        const disponible = params.get('disponible') === 'true';
        const idx = MOCK_MENU_ITEMS.findIndex(m => m.id === id);
        if (idx !== -1) {
          MOCK_MENU_ITEMS[idx] = {
            ...MOCK_MENU_ITEMS[idx],
            disponible,
          };
          return MOCK_MENU_ITEMS[idx];
        }
      }
      return null;
    }
    if (method === 'DELETE') {
      const matchId = url.match(/\/(\d+)$/);
      if (matchId) {
        const id = parseInt(matchId[1], 10);
        MOCK_MENU_ITEMS = MOCK_MENU_ITEMS.filter(m => m.id !== id);
        return { message: 'Menu item deleted physically (Mock)', success: true };
      }
      return null;
    }
    return MOCK_MENU_ITEMS;
  }

  // 3. Pedidos / Mesas
  if (baseURL.includes('pedidos')) {
    if (url.includes('/estado') && method === 'PATCH') {
      return { mensaje: 'Estado del pedido actualizado (Mock)', success: true };
    }
    if (url.includes('/mesas')) {
      return MOCK_MESAS;
    }
    return MOCK_PEDIDOS;
  }

  // 4. Delivery
  if (baseURL.includes('delivery')) {
    if (url.includes('/estado') && method === 'PATCH') {
      return { mensaje: 'Estado de entrega actualizado (Mock)', success: true };
    }
    return MOCK_PEDIDOS.filter(p => p.tipo === 'DELIVERY' && p.estado !== 'ENTREGADO' && p.estado !== 'CANCELADO');
  }

  // 5. Pagos
  if (baseURL.includes('pagos')) {
    if (method === 'GET') {
      if (url.includes('/pedido/')) {
        const matchId = url.match(/\/pedido\/(\d+)$/);
        if (matchId) {
          const pedidoId = parseInt(matchId[1], 10);
          return MOCK_PAGOS.filter(p => p.pedidoId === pedidoId);
        }
      }
      const matchId = url.match(/\/(\d+)$/);
      if (matchId) {
        const id = parseInt(matchId[1], 10);
        return MOCK_PAGOS.find(p => p.id === id) || null;
      }
      return MOCK_PAGOS;
    }
    if (method === 'POST') {
      const data = config.data ? JSON.parse(config.data) : {};
      const newPago = {
        id: MOCK_PAGOS.length > 0 ? Math.max(...MOCK_PAGOS.map(p => p.id)) + 1 : 1,
        pedidoId: parseInt(data.pedidoId, 10) || 100 + MOCK_PAGOS.length,
        monto: parseFloat(data.monto) || 0.0,
        metodo: data.metodo || 'EFECTIVO',
        estado: 'PENDIENTE',
        transaccionId: '',
        creadoEn: new Date().toISOString(),
      };
      MOCK_PAGOS.push(newPago);
      return newPago;
    }
    if (method === 'PATCH' && url.includes('/estado')) {
      const matchId = url.match(/\/(\d+)\/estado/);
      if (matchId) {
        const id = parseInt(matchId[1], 10);
        const params = new URLSearchParams(url.split('?')[1] || '');
        const transaccionId = params.get('transaccionId') || `TX-${Date.now()}`;
        const estadoFinal = params.get('estadoFinal') || 'APROBADO';
        const idx = MOCK_PAGOS.findIndex(p => p.id === id);
        if (idx !== -1) {
          MOCK_PAGOS[idx] = {
            ...MOCK_PAGOS[idx],
            estado: estadoFinal,
            transaccionId,
          };
          return MOCK_PAGOS[idx];
        }
      }
      return null;
    }
    return MOCK_PAGOS;
  }

  // 6. Inventario
  if (baseURL.includes('inventario')) {
    if (url.includes('/insumos') && method === 'POST') {
      const data = config.data ? JSON.parse(config.data) : {};
      const newInsumo: any = {
        id: MOCK_INSUMOS.length > 0 ? Math.max(...MOCK_INSUMOS.map(i => i.id)) + 1 : 1,
        sucursalId: parseInt(data.sucursalId, 10) || 1,
        nombre: data.nombre || 'Nuevo Insumo Mock',
        unidadMedida: data.unidadMedida || 'Unidades',
        stockActual: 0.0,
        stockMinimo: parseFloat(data.stockMinimo) || 0.0,
        creadoEn: new Date().toISOString(),
        actualizadoEn: new Date().toISOString(),
      };
      MOCK_INSUMOS.push(newInsumo);
      MOCK_KARDEX.push({
        id: MOCK_KARDEX.length > 0 ? Math.max(...MOCK_KARDEX.map(k => k.id)) + 1 : 1,
        insumoId: newInsumo.id,
        tipo: 'ENTRADA',
        cantidad: 0.0,
        referencia: 'Registro inicial de insumo',
        creadoEn: new Date().toISOString(),
      });
      return newInsumo;
    }
    if (url.includes('/insumos/') && method === 'PUT') {
      const matchId = url.match(/\/insumos\/(\d+)$/);
      if (matchId) {
        const id = parseInt(matchId[1], 10);
        const data = config.data ? JSON.parse(config.data) : {};
        const idx = MOCK_INSUMOS.findIndex(i => i.id === id);
        if (idx !== -1) {
          MOCK_INSUMOS[idx] = {
            ...MOCK_INSUMOS[idx],
            nombre: data.nombre || MOCK_INSUMOS[idx].nombre,
            unidadMedida: data.unidadMedida || MOCK_INSUMOS[idx].unidadMedida,
            stockMinimo: data.stockMinimo !== undefined ? parseFloat(data.stockMinimo) : MOCK_INSUMOS[idx].stockMinimo,
            actualizadoEn: new Date().toISOString(),
          };
          return MOCK_INSUMOS[idx];
        }
      }
      return null;
    }
    if (url.includes('/kardex') && method === 'GET') {
      const matchId = url.match(/\/insumos\/(\d+)\/kardex/);
      if (matchId) {
        const insumoId = parseInt(matchId[1], 10);
        return MOCK_KARDEX.filter(k => k.insumoId === insumoId).sort((a, b) => new Date(b.creadoEn).getTime() - new Date(a.creadoEn).getTime());
      }
      return MOCK_KARDEX;
    }
    if ((url.includes('/movimientos') || url.includes('/stock')) && (method === 'POST' || method === 'PATCH')) {
      const data = config.data ? JSON.parse(config.data) : {};
      let insumoId = data.insumoId;
      if (method === 'PATCH') {
        const matchId = url.match(/\/(\d+)\/stock/);
        if (matchId) {
          insumoId = parseInt(matchId[1], 10);
        }
      }
      const idx = MOCK_INSUMOS.findIndex(i => i.id === parseInt(insumoId, 10));
      if (idx !== -1) {
        const cantidad = parseFloat(data.cantidad) || 0.0;
        const tipo = data.tipo || 'ENTRADA';
        
        if (tipo === 'ENTRADA') {
          MOCK_INSUMOS[idx].stockActual += cantidad;
        } else {
          MOCK_INSUMOS[idx].stockActual = Math.max(0, MOCK_INSUMOS[idx].stockActual - cantidad);
        }
        MOCK_INSUMOS[idx].actualizadoEn = new Date().toISOString();
        
        const newMov = {
          id: MOCK_KARDEX.length > 0 ? Math.max(...MOCK_KARDEX.map(k => k.id)) + 1 : 1,
          insumoId: MOCK_INSUMOS[idx].id,
          tipo,
          cantidad,
          referencia: data.referencia || 'Ajuste manual de stock',
          creadoEn: new Date().toISOString(),
        };
        MOCK_KARDEX.push(newMov);
        return newMov;
      }
      return null;
    }
    if (url.includes('/insumos/sucursal/')) {
      const matchId = url.match(/\/insumos\/sucursal\/(\d+)$/);
      if (matchId) {
        const sucursalId = parseInt(matchId[1], 10);
        return MOCK_INSUMOS.filter(i => i.sucursalId === sucursalId);
      }
    }
    const matchId = url.match(/\/(\d+)$/);
    if (matchId) {
      const id = parseInt(matchId[1], 10);
      return MOCK_INSUMOS.find(i => i.id === id) || null;
    }
    return MOCK_INSUMOS;
  }

  // 7. Carrito, Notificaciones, Reportes (new services)
  if (baseURL.includes('carrito') || baseURL.includes('notificaciones') || baseURL.includes('reportes')) {
    if (baseURL.includes('carrito')) {
      if (method === 'GET') {
        if (url.includes('usuario/') && !url.includes('items')) {
          const matchId = url.match(/\/usuario\/(\d+)/);
          const uid = matchId ? parseInt(matchId[1], 10) : 1;
          return {
            id: 1, usuarioId: uid, sucursalId: 1,
            total: 25000, items: [
              { id: 1, menuItemId: 1, precioUnitario: 8000, cantidad: 2, subtotal: 16000 },
              { id: 2, menuItemId: 2, precioUnitario: 9000, cantidad: 1, subtotal: 9000 }
            ]
          };
        }
        if (url.includes('health')) {
          return { status: 'UP', service: 'ms-carrito' };
        }
      }
      if (method === 'POST') {
        return { id: Date.now(), usuarioId: 1, sucursalId: 1, total: 0, items: [] };
      }
      if (method === 'DELETE' || method === 'PATCH') {
        return { id: 1, usuarioId: 1, sucursalId: 1, total: 0, items: [] };
      }
    }

    if (baseURL.includes('notificaciones')) {
      if (method === 'GET') {
        if (url.includes('estado/')) {
          return [
            { id: 1, usuarioId: 1, destinatario: 'admin@test.cl', asunto: 'Pedido confirmado', cuerpo: 'Su pedido #42 está confirmado', tipo: 'PUSH', estado: 'PENDIENTE', creadoEn: new Date().toISOString() },
            { id: 2, usuarioId: 1, destinatario: 'admin@test.cl', asunto: 'Delivery asignado', cuerpo: 'Repartidor asignado al pedido #42', tipo: 'EMAIL', estado: 'LEIDO', creadoEn: new Date().toISOString() }
          ];
        }
        if (url.match(/notificaciones\/\d+$/)) {
          return { id: 1, usuarioId: 1, destinatario: 'admin@test.cl', asunto: 'Pedido confirmado', cuerpo: 'Su pedido #42 está confirmado', tipo: 'PUSH', estado: 'PENDIENTE', creadoEn: new Date().toISOString() };
        }
      }
      if (method === 'POST') {
        return { id: Date.now(), usuarioId: 1, destinatario: 'admin@test.cl', asunto: 'Nueva notificación', cuerpo: 'Contenido de prueba', tipo: 'PUSH', estado: 'PENDIENTE', creadoEn: new Date().toISOString() };
      }
      if (method === 'PATCH' && url.includes('estado')) {
        return { id: 1, usuarioId: 1, destinatario: 'admin@test.cl', asunto: 'Pedido confirmado', cuerpo: 'Su pedido #42 está confirmado', tipo: 'PUSH', estado: 'LEIDO', creadoEn: new Date().toISOString() };
      }
      return [];
    }

    if (baseURL.includes('reportes')) {
      if (method === 'GET') {
        return [
          { id: 1, tipo: 'VENTAS_DIARIAS', sucursalId: 1, dataJson: '{"total": 450000, "pedidos": 12}', creadoEn: new Date().toISOString() },
          { id: 2, tipo: 'VENTAS_DIARIAS', sucursalId: 1, dataJson: '{"total": 320000, "pedidos": 8}', creadoEn: new Date().toISOString() },
          { id: 3, tipo: 'TOP_PLATOS', sucursalId: 1, dataJson: '{"platos":[{"nombre":"Pizza","ventas":15}]}', creadoEn: new Date().toISOString() }
        ];
      }
      if (method === 'POST') {
        return { id: Date.now(), tipo: 'VENTAS_DIARIAS', sucursalId: 1, dataJson: '{"total": 450000, "pedidos": 12}', creadoEn: new Date().toISOString() };
      }
      return [];
    }
  }

  return { message: 'Mock data generic response', success: true };
}
