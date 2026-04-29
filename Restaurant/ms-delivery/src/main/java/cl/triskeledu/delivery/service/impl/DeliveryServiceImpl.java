package cl.triskeledu.delivery.service.impl;

import cl.triskeledu.delivery.dto.request.AsignarRepartidorDTO;
import cl.triskeledu.delivery.dto.request.DeliveryRequestDTO;
import cl.triskeledu.delivery.dto.response.DeliveryResponseDTO;
import cl.triskeledu.delivery.entity.enums.EstadoDelivery;
import cl.triskeledu.delivery.service.DeliveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * =============================================================================
 * SERVICE IMPL: DeliveryServiceImpl
 * =============================================================================
 */
@Service
@Slf4j
public class DeliveryServiceImpl implements DeliveryService {

    @Override
    public DeliveryResponseDTO crearDelivery(DeliveryRequestDTO dto) {
        /*
         * INTENCIÓN: Inicializar la logística para un pedido listo.
         *
         * FLUJO ESPERADO:
         *   1. Recibir solicitud desde ms-pedidos (cuando el pedido está LISTO).
         *   2. Crear entidad Delivery en estado BUSCANDO_REPARTIDOR.
         *   3. Guardar en BD.
         *   Output: DeliveryResponseDTO.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public DeliveryResponseDTO getByPedidoId(Long pedidoId) {
        /*
         * INTENCIÓN: Consultar dónde está el pedido.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public DeliveryResponseDTO asignarRepartidor(Long id, AsignarRepartidorDTO dto) {
        /*
         * INTENCIÓN: Asignar un repartidor físico a la entrega.
         *
         * FLUJO ESPERADO:
         *   1. Buscar delivery. Si estado != BUSCANDO_REPARTIDOR -> Exception.
         *   2. Validar que repartidorId existe y es ROLE_RP (Feign a ms-usuarios).
         *   3. Cambiar estado a ASIGNADO.
         *   4. Guardar en BD.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public DeliveryResponseDTO actualizarEstado(Long id, EstadoDelivery nuevoEstado, String observaciones) {
        /*
         * INTENCIÓN: El repartidor actualiza su progreso.
         *
         * FLUJO ESPERADO:
         *   1. Buscar delivery.
         *   2. Validar transición de estado lógica (ASIGNADO -> EN_CAMINO -> ENTREGADO).
         *   3. Si es ENTREGADO -> Notificar a ms-pedidos vía Feign para que cierre el ciclo.
         *   4. Guardar en BD.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }
}
