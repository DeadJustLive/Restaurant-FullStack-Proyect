package cl.triskeledu.pagos.controller;

import cl.triskeledu.pagos.dto.request.PagoRequestDTO;
import cl.triskeledu.pagos.dto.response.PagoResponseDTO;
import cl.triskeledu.pagos.entity.enums.EstadoPago;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
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
public class PagoController {

    @PostMapping
    public ResponseEntity<PagoResponseDTO> iniciarPago(@Valid @RequestBody PagoRequestDTO dto) {
        /*
         * INTENCIÓN: Iniciar transacción para un pedido.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @PatchMapping("/{id}/confirmar")
    public ResponseEntity<PagoResponseDTO> confirmarPago(
            @PathVariable Long id,
            @RequestParam String transaccionId,
            @RequestParam EstadoPago estadoFinal) {
        /*
         * INTENCIÓN: Confirmar resultado (webhook de pasarela externa o cajero manual).
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoResponseDTO> getById(@PathVariable Long id) {
        /*
         * INTENCIÓN: Detalle del pago.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<List<PagoResponseDTO>> listarPorPedido(@PathVariable Long pedidoId) {
        /*
         * INTENCIÓN: Todos los intentos (ej. si uno falló y se intentó de nuevo).
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }
}
