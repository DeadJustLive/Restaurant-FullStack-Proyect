package cl.triskeledu.pedidos.controller;

import cl.triskeledu.pedidos.dto.request.PedidoRequestDTO;
import cl.triskeledu.pedidos.dto.request.PedidoEstadoRequestDTO;
import cl.triskeledu.pedidos.dto.response.PedidoResponseDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =============================================================================
 * CONTROLLER: PedidoController
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/pedidos")
@Slf4j
public class PedidoController {

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> crear(@Valid @RequestBody PedidoRequestDTO dto) {
        /*
         * INTENCIÓN: Crear un nuevo pedido a partir del carrito.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> getById(@PathVariable Long id) {
        /*
         * INTENCIÓN: Obtener detalle del pedido.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/sucursal/{sucursalId}/activos")
    public ResponseEntity<List<PedidoResponseDTO>> listarActivosPorSucursal(@PathVariable Long sucursalId) {
        /*
         * INTENCIÓN: Mostrar pedidos pendientes en cocina/preparación.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/cliente/{usuarioId}")
    public ResponseEntity<List<PedidoResponseDTO>> listarHistorialCliente(@PathVariable Long usuarioId) {
        /*
         * INTENCIÓN: Historial de pedidos para un cliente específico.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<PedidoResponseDTO> cambiarEstado(
            @PathVariable Long id, 
            @Valid @RequestBody PedidoEstadoRequestDTO dto) {
        /*
         * INTENCIÓN: Avanzar pedido (PENDIENTE -> PREPARACION -> LISTO).
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<PedidoResponseDTO> cancelarPedido(@PathVariable Long id) {
        /*
         * INTENCIÓN: Cancelar pedido (solo si está PENDIENTE).
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }
}
