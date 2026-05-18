package cl.triskeledu.delivery.service;

import cl.triskeledu.delivery.dto.request.AsignarRepartidorDTO;
import cl.triskeledu.delivery.dto.request.DeliveryRequestDTO;
import cl.triskeledu.delivery.dto.response.DeliveryResponseDTO;
import cl.triskeledu.delivery.entity.enums.EstadoDelivery;

/**
 * =============================================================================
 * SERVICE INTERFACE: DeliveryService
 * =============================================================================
 */
public interface DeliveryService {

    DeliveryResponseDTO crearDelivery(Long credencialId, DeliveryRequestDTO dto);

    DeliveryResponseDTO getByPedidoId(Long pedidoId);

    DeliveryResponseDTO asignarRepartidor(Long credencialId, Long id, AsignarRepartidorDTO dto);

    DeliveryResponseDTO actualizarEstado(Long credencialId, Long id, EstadoDelivery nuevoEstado, String observaciones);

    DeliveryResponseDTO getById(Long id);

    java.util.List<DeliveryResponseDTO> listarTodos();
}
