// @use(carrito)
// @kind(controller)
// @contract(in: CarritoRequestDTO, CarritoItemRequestDTO -> out: CarritoResponseDTO)
// @limit(lines: 400)
package cl.triskeledu.carrito.controller;

import cl.triskeledu.carrito.dto.request.CarritoItemRequestDTO;
import cl.triskeledu.carrito.dto.request.CarritoRequestDTO;
import cl.triskeledu.carrito.dto.response.CarritoResponseDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cl.triskeledu.carrito.service.CarritoService;
import lombok.RequiredArgsConstructor;
import java.util.Map;

/**
 * =============================================================================
 * CONTROLLER: CarritoController
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/carrito")
@RequiredArgsConstructor
@Slf4j
public class CarritoController {

    private final CarritoService carritoService;

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        log.info("[CarritoController] GET /health");
        return ResponseEntity.ok(Map.of("status", "UP", "service", "ms-carrito"));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<CarritoResponseDTO> obtenerCarrito(@PathVariable Long usuarioId) {
        log.info("REST request to get Carrito for usuarioId: {}", usuarioId);
        return ResponseEntity.ok(carritoService.obtenerCarrito(usuarioId));
    }

    @PostMapping
    public ResponseEntity<CarritoResponseDTO> crearCarrito(@Valid @RequestBody CarritoRequestDTO dto) {
        log.info("REST request to create Carrito");
        return ResponseEntity.status(201).body(carritoService.crearCarrito(dto));
    }

    @PostMapping("/usuario/{usuarioId}/items")
    public ResponseEntity<CarritoResponseDTO> agregarItem(@PathVariable Long usuarioId, @Valid @RequestBody CarritoItemRequestDTO dto) {
        log.info("REST request to add item to Carrito for usuarioId: {}", usuarioId);
        return ResponseEntity.status(201).body(carritoService.agregarItem(usuarioId, dto));
    }

    @PatchMapping("/usuario/{usuarioId}/items/{itemId}")
    public ResponseEntity<CarritoResponseDTO> actualizarCantidadItem(
            @PathVariable Long usuarioId,
            @PathVariable Long itemId,
            @RequestBody Map<String, Integer> payload) {
        Integer cantidad = payload.get("cantidad");
        log.info("REST request to update item {} quantity to {} for usuarioId: {}", itemId, cantidad, usuarioId);
        return ResponseEntity.ok(carritoService.actualizarCantidadItem(usuarioId, itemId, cantidad));
    }

    @DeleteMapping("/usuario/{usuarioId}/items/{itemId}")
    public ResponseEntity<CarritoResponseDTO> removerItem(@PathVariable Long usuarioId, @PathVariable Long itemId) {
        log.info("REST request to remove item {} from Carrito for usuarioId: {}", itemId, usuarioId);
        return ResponseEntity.ok(carritoService.removerItem(usuarioId, itemId));
    }

    @DeleteMapping("/usuario/{usuarioId}")
    public ResponseEntity<Void> vaciarCarrito(@PathVariable Long usuarioId) {
        log.info("REST request to empty Carrito for usuarioId: {}", usuarioId);
        carritoService.vaciarCarrito(usuarioId);
        return ResponseEntity.noContent().build();
    }
}
