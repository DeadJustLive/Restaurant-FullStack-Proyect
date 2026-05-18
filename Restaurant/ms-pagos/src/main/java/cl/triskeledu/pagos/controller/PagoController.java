package cl.triskeledu.pagos.controller;

import cl.triskeledu.pagos.dto.request.PagoRequestDTO;
import cl.triskeledu.pagos.dto.response.PagoResponseDTO;
import cl.triskeledu.pagos.entity.enums.EstadoPago;
import cl.triskeledu.pagos.service.PagoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =============================================================================
 * CONTROLLER: PagoController
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/pagos")
@Slf4j
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;

    @PostMapping
    public ResponseEntity<PagoResponseDTO> iniciarPago(@RequestHeader(value = "X-Credencial-Id", defaultValue = "1") Long credencialId,
                                                       @Valid @RequestBody PagoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoService.iniciarPago(credencialId, dto));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<PagoResponseDTO> cambiarEstado(
            @RequestHeader(value = "X-Credencial-Id", defaultValue = "1") Long credencialId,
            @PathVariable Long id,
            @RequestParam String transaccionId,
            @RequestParam EstadoPago estadoFinal) {
        return ResponseEntity.ok(pagoService.confirmarPago(credencialId, id, transaccionId, estadoFinal));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PagoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(pagoService.listarTodos());
    }

    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<List<PagoResponseDTO>> listarPorPedido(@PathVariable Long pedidoId) {
        return ResponseEntity.ok(pagoService.listarPorPedido(pedidoId));
    }
}
