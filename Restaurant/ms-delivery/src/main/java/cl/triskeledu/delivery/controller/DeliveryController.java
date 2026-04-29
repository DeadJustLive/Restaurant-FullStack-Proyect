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

    @PostMapping
    public ResponseEntity<DeliveryResponseDTO> crearDelivery(@Valid @RequestBody DeliveryRequestDTO dto) {
        /*
         * INTENCIÓN: Iniciado por ms-pedidos.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<DeliveryResponseDTO> getByPedidoId(@PathVariable Long pedidoId) {
        /*
         * INTENCIÓN: Tracker público para el cliente.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @PatchMapping("/{id}/asignar")
    public ResponseEntity<DeliveryResponseDTO> asignarRepartidor(@PathVariable Long id, @Valid @RequestBody AsignarRepartidorDTO dto) {
        /*
         * INTENCIÓN: Repartidor acepta la entrega.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<DeliveryResponseDTO> actualizarEstado(
            @PathVariable Long id, 
            @RequestParam EstadoDelivery estado, 
            @RequestParam(required = false) String observaciones) {
        /*
         * INTENCIÓN: Progreso de la ruta.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }
}
