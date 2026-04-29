package cl.triskeledu.carrito.service;

import cl.triskeledu.carrito.dto.request.CarritoItemRequestDTO;
import cl.triskeledu.carrito.dto.request.CarritoRequestDTO;
import cl.triskeledu.carrito.dto.response.CarritoResponseDTO;

/**
 * =============================================================================
 * SERVICE INTERFACE: CarritoService
 * =============================================================================
 */
public interface CarritoService {

    CarritoResponseDTO obtenerCarrito(Long usuarioId);

    CarritoResponseDTO crearCarrito(CarritoRequestDTO dto);

    CarritoResponseDTO agregarItem(Long usuarioId, CarritoItemRequestDTO dto);

    CarritoResponseDTO actualizarCantidadItem(Long usuarioId, Long itemId, Integer nuevaCantidad);

    CarritoResponseDTO removerItem(Long usuarioId, Long itemId);

    void vaciarCarrito(Long usuarioId);
}
