package cl.triskeledu.carrito.controller;

import cl.triskeledu.carrito.dto.request.CarritoItemRequestDTO;
import cl.triskeledu.carrito.dto.request.CarritoRequestDTO;
import cl.triskeledu.carrito.dto.response.CarritoResponseDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * =============================================================================
 * CONTROLLER: CarritoController
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/carrito")
@Slf4j
public class CarritoController {

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<CarritoResponseDTO> obtenerCarrito(@PathVariable Long usuarioId) {
        /*
         * INTENCIÓN: Consultar estado actual del carrito de un usuario.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @PostMapping
    public ResponseEntity<CarritoResponseDTO> crearCarrito(@Valid @RequestBody CarritoRequestDTO dto) {
        /*
         * INTENCIÓN: Inicializar carrito al seleccionar una sucursal.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @PostMapping("/usuario/{usuarioId}/items")
    public ResponseEntity<CarritoResponseDTO> agregarItem(@PathVariable Long usuarioId, @Valid @RequestBody CarritoItemRequestDTO dto) {
        /*
         * INTENCIÓN: Agregar un plato al carrito.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @PatchMapping("/usuario/{usuarioId}/items/{itemId}")
    public ResponseEntity<CarritoResponseDTO> actualizarCantidadItem(
            @PathVariable Long usuarioId,
            @PathVariable Long itemId,
            @RequestParam Integer cantidad) {
        /*
         * INTENCIÓN: Aumentar o disminuir la cantidad de un plato.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @DeleteMapping("/usuario/{usuarioId}/items/{itemId}")
    public ResponseEntity<CarritoResponseDTO> removerItem(@PathVariable Long usuarioId, @PathVariable Long itemId) {
        /*
         * INTENCIÓN: Quitar un plato del carrito.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @DeleteMapping("/usuario/{usuarioId}")
    public ResponseEntity<Void> vaciarCarrito(@PathVariable Long usuarioId) {
        /*
         * INTENCIÓN: Vaciar todo el carrito. Invocado post-pago o cancelación manual.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }
}
