package cl.triskeledu.delivery.service.impl;

import cl.triskeledu.delivery.dto.request.AsignarRepartidorDTO;
import cl.triskeledu.delivery.dto.request.DeliveryRequestDTO;
import cl.triskeledu.delivery.dto.response.DeliveryResponseDTO;
import cl.triskeledu.delivery.entity.enums.EstadoDelivery;
import cl.triskeledu.delivery.service.DeliveryService;
import cl.triskeledu.delivery.entity.Delivery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.triskeledu.delivery.client.AuthFeignClient;
import cl.triskeledu.delivery.dto.response.PermisoResponseDTO;
import cl.triskeledu.delivery.exception.AccesoDenegadoException;
import lombok.RequiredArgsConstructor;

/**
 * =============================================================================
 * SERVICE IMPL: DeliveryServiceImpl
 * =============================================================================
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryServiceImpl implements DeliveryService {

    private final AuthFeignClient authFeignClient;


    @Autowired
    private cl.triskeledu.delivery.repository.DeliveryRepository deliveryRepository;

    @Override
    public DeliveryResponseDTO crearDelivery(DeliveryRequestDTO dto) {
        log.info("Creando delivery para pedido {}", dto.getPedidoId());
        Delivery delivery = Delivery.builder()
                .pedidoId(dto.getPedidoId())
                .direccionEntrega(dto.getDireccionEntrega())
                .estado(EstadoDelivery.BUSCANDO_REPARTIDOR)
                .build();
        return mapToDTO(deliveryRepository.save(delivery));
    }

    @Override
    public DeliveryResponseDTO getByPedidoId(Long pedidoId) {
        log.info("Consultando delivery para pedido {}", pedidoId);
        Delivery delivery = deliveryRepository.findByPedidoId(pedidoId)
                .orElseThrow(() -> new cl.triskeledu.delivery.exception.DeliveryNotFoundException("Delivery no encontrado"));
        return mapToDTO(delivery);
    }
    
    public DeliveryResponseDTO getById(Long id) {
        log.info("Consultando delivery ID {}", id);
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new cl.triskeledu.delivery.exception.DeliveryNotFoundException("Delivery no encontrado"));
        return mapToDTO(delivery);
    }
    
    public java.util.List<DeliveryResponseDTO> listarTodos() {
        log.info("Listando todos los deliveries");
        return deliveryRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public DeliveryResponseDTO asignarRepartidor(Long id, AsignarRepartidorDTO dto) {
        log.info("Asignando repartidor {} a delivery {}", dto.getRepartidorId(), id);
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new cl.triskeledu.delivery.exception.DeliveryNotFoundException("Delivery no encontrado"));
        delivery.setRepartidorId(dto.getRepartidorId());
        delivery.setEstado(EstadoDelivery.ASIGNADO);
        return mapToDTO(deliveryRepository.save(delivery));
    }

    @Override
    public DeliveryResponseDTO actualizarEstado(Long id, EstadoDelivery nuevoEstado, String observaciones) {
        log.info("Actualizando estado de delivery {} a {}", id, nuevoEstado);
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new cl.triskeledu.delivery.exception.DeliveryNotFoundException("Delivery no encontrado"));
        delivery.setEstado(nuevoEstado);
        if (observaciones != null) {
            delivery.setObservaciones(observaciones);
        }
        return mapToDTO(deliveryRepository.save(delivery));
    }
    
    private DeliveryResponseDTO mapToDTO(Delivery entity) {
        return DeliveryResponseDTO.builder()
                .id(entity.getId())
                .pedidoId(entity.getPedidoId())
                .repartidorId(entity.getRepartidorId())
                .direccionEntrega(entity.getDireccionEntrega())
                .estado(entity.getEstado())
                .observaciones(entity.getObservaciones())
                .creadoEn(entity.getCreadoEn())
                .actualizadoEn(entity.getActualizadoEn())
                .build();
    }
}
