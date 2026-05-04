package cl.triskeledu.pedidos.controller;

import cl.triskeledu.pedidos.dto.request.PedidoRequestDTO;
import cl.triskeledu.pedidos.dto.request.PedidoEstadoRequestDTO;
import cl.triskeledu.pedidos.dto.response.PedidoResponseDTO;
import cl.triskeledu.pedidos.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> crear(@Valid @RequestBody PedidoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.crear(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.obtenerPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    @GetMapping("/sucursal/{sucursalId}/activos")
    public ResponseEntity<List<PedidoResponseDTO>> listarActivosPorSucursal(@PathVariable Long sucursalId) {
        return ResponseEntity.ok(pedidoService.obtenerColaSucursal(sucursalId));
    }

    @GetMapping("/cliente/{usuarioId}")
    public ResponseEntity<List<PedidoResponseDTO>> listarHistorialCliente(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(pedidoService.obtenerPorUsuario(usuarioId));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<PedidoResponseDTO> cambiarEstado(
            @PathVariable Long id, 
            @Valid @RequestBody PedidoEstadoRequestDTO dto) {
        return ResponseEntity.ok(pedidoService.cambiarEstado(id, dto.getEstado()));
    }

    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<PedidoResponseDTO> cancelarPedido(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.cancelar(id));
    }
}
