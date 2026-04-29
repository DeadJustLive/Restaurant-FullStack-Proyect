package cl.triskeledu.pagos.service;

import cl.triskeledu.pagos.dto.request.PagoRequestDTO;
import cl.triskeledu.pagos.dto.response.PagoResponseDTO;
import cl.triskeledu.pagos.entity.enums.EstadoPago;

import java.util.List;

/**
 * =============================================================================
 * SERVICE INTERFACE: PagoService
 * =============================================================================
 */
public interface PagoService {

    PagoResponseDTO iniciarPago(PagoRequestDTO dto);

    PagoResponseDTO confirmarPago(Long id, String transaccionId, EstadoPago estadoFinal);

    PagoResponseDTO getById(Long id);

    List<PagoResponseDTO> listarPorPedido(Long pedidoId);
}
