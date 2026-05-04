package cl.triskeledu.delivery.controller;

import cl.triskeledu.delivery.dto.request.AsignarRepartidorDTO;
import cl.triskeledu.delivery.dto.request.DeliveryRequestDTO;
import cl.triskeledu.delivery.dto.response.DeliveryResponseDTO;
import cl.triskeledu.delivery.entity.enums.EstadoDelivery;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * =============================================================================
 * CONTROLLER: DeliveryController
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/delivery")
@Slf4j
public class DeliveryController {

    @org.springframework.beans.factory.annotation.Autowired
    private cl.triskeledu.delivery.service.DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<DeliveryResponseDTO> crearDelivery(@Valid @RequestBody DeliveryRequestDTO dto) {
        return ResponseEntity.status(org.springframework.http.HttpStatus.CREATED).body(deliveryService.crearDelivery(dto));
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
    public ResponseEntity<DeliveryResponseDTO> asignarRepartidor(@PathVariable Long id, @Valid @RequestBody AsignarRepartidorDTO dto) {
        return ResponseEntity.ok(deliveryService.asignarRepartidor(id, dto));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<DeliveryResponseDTO> actualizarEstado(
            @PathVariable Long id, 
            @RequestParam EstadoDelivery estado, 
            @RequestParam(required = false) String observaciones) {
        return ResponseEntity.ok(deliveryService.actualizarEstado(id, estado, observaciones));
    }
}
