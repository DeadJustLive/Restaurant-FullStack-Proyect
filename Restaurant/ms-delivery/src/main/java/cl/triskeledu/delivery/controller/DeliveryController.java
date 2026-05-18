package cl.triskeledu.delivery.controller;

import cl.triskeledu.delivery.dto.request.AsignarRepartidorDTO;
import cl.triskeledu.delivery.dto.request.DeliveryRequestDTO;
import cl.triskeledu.delivery.dto.response.DeliveryResponseDTO;
import cl.triskeledu.delivery.entity.enums.EstadoDelivery;
import cl.triskeledu.delivery.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * =============================================================================
 * CONTROLLER: DeliveryController
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/delivery")
@RequiredArgsConstructor
@Slf4j
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<DeliveryResponseDTO> crearDelivery(@RequestHeader(value = "X-Credencial-Id", defaultValue = "1") Long credencialId,
                                                              @Valid @RequestBody DeliveryRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(deliveryService.crearDelivery(credencialId, dto));
    }

    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<DeliveryResponseDTO> getByPedidoId(@PathVariable Long pedidoId) {
        return ResponseEntity.ok(deliveryService.getByPedidoId(pedidoId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(deliveryService.getById(id));
    }

    @GetMapping
    public ResponseEntity<java.util.List<DeliveryResponseDTO>> listarTodos() {
        return ResponseEntity.ok(deliveryService.listarTodos());
    }

    @PatchMapping("/{id}/asignar")
    public ResponseEntity<DeliveryResponseDTO> asignarRepartidor(@RequestHeader(value = "X-Credencial-Id", defaultValue = "1") Long credencialId,
                                                                  @PathVariable Long id, @Valid @RequestBody AsignarRepartidorDTO dto) {
        return ResponseEntity.ok(deliveryService.asignarRepartidor(credencialId, id, dto));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<DeliveryResponseDTO> actualizarEstado(
            @RequestHeader(value = "X-Credencial-Id", defaultValue = "1") Long credencialId,
            @PathVariable Long id,
            @RequestParam EstadoDelivery estado,
            @RequestParam(required = false) String observaciones) {
        return ResponseEntity.ok(deliveryService.actualizarEstado(credencialId, id, estado, observaciones));
    }
}
