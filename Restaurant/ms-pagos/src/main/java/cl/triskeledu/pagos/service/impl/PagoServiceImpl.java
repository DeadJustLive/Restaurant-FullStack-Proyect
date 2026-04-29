package cl.triskeledu.pagos.service.impl;

import cl.triskeledu.pagos.dto.request.PagoRequestDTO;
import cl.triskeledu.pagos.dto.response.PagoResponseDTO;
import cl.triskeledu.pagos.entity.enums.EstadoPago;
import cl.triskeledu.pagos.service.PagoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * =============================================================================
 * SERVICE IMPL: PagoServiceImpl
 * =============================================================================
 */
@Service
@Slf4j
public class PagoServiceImpl implements PagoService {

    @Override
    public PagoResponseDTO iniciarPago(PagoRequestDTO dto) {
        /*
         * INTENCIÓN: Registrar la intención de pago antes de comunicarse con la pasarela.
         *
         * FLUJO ESPERADO:
         *   1. Validar pedidoId (Feign a ms-pedidos, verificar monto y estado).
         *   2. Crear entidad Pago con estado PENDIENTE.
         *   3. Guardar en BD.
         *   4. (Opcional) Llamar a API externa para obtener link de pago.
         *   Output: PagoResponseDTO.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public PagoResponseDTO confirmarPago(Long id, String transaccionId, EstadoPago estadoFinal) {
        /*
         * INTENCIÓN: Webhook / Confirmación manual de pago.
         *
         * FLUJO ESPERADO:
         *   1. Buscar pago por ID (PagoNotFoundException si no existe).
         *   2. Actualizar estado a APROBADO o RECHAZADO, asignar transaccionId.
         *   3. Guardar en BD.
         *   4. Si es APROBADO -> Notificar a ms-pedidos (vía Feign o Kafka) para que pase a PREPARACION.
         *   Output: PagoResponseDTO actualizado.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public PagoResponseDTO getById(Long id) {
        /*
         * INTENCIÓN: Consultar detalle de un pago.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public List<PagoResponseDTO> listarPorPedido(Long pedidoId) {
        /*
         * INTENCIÓN: Ver historial de intentos de pago de un pedido.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }
}
