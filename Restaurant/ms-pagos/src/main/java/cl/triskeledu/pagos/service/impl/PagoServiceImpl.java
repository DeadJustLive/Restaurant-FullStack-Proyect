package cl.triskeledu.pagos.service.impl;

import cl.triskeledu.pagos.dto.request.PagoRequestDTO;
import cl.triskeledu.pagos.dto.response.PagoResponseDTO;
import cl.triskeledu.pagos.entity.enums.EstadoPago;
import cl.triskeledu.pagos.service.PagoService;
import cl.triskeledu.pagos.entity.Pago;
import cl.triskeledu.pagos.repository.PagoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.triskeledu.pagos.client.AuthFeignClient;
import cl.triskeledu.pagos.dto.response.PermisoResponseDTO;
import cl.triskeledu.pagos.exception.AccesoDenegadoException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * =============================================================================
 * SERVICE IMPL: PagoServiceImpl
 * =============================================================================
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PagoServiceImpl implements PagoService {

    private final AuthFeignClient authFeignClient;


    @Autowired
    private PagoRepository pagoRepository;

    @Override
    @Transactional
    public PagoResponseDTO iniciarPago(PagoRequestDTO dto) {
        /*
         * INTENCIÓN: Registrar la intención de pago antes de comunicarse con la pasarela.
         *
         * FLUJO ESPERADO:
         *   1. Validar pedidoId (Feign a ms-pedidos, verificar monto y estado).
         *   2. Crear entidad Pago con estado PENDIENTE.
         *   3. Guardar en BD.
         *   4. (Opcional) Llamar a API externa para obtener link de pago.
         */
        log.info("Iniciando pago mockeado (Happy Path) para pedido {}", dto.getPedidoId());
        Pago pago = Pago.builder()
                .pedidoId(dto.getPedidoId())
                .monto(dto.getMonto())
                .metodo(dto.getMetodo())
                .estado(EstadoPago.APROBADO) // Lo marcamos como completado de inmediato para el happy path
                .build();
        
        return mapToDTO(pagoRepository.save(pago));
    }

    @Override
    @Transactional
    public PagoResponseDTO confirmarPago(Long id, String transaccionId, EstadoPago estadoFinal) {
        log.info("Confirmando pago {} con transaccion {} y estado {}", id, transaccionId, estadoFinal);
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new cl.triskeledu.pagos.exception.PagoNotFoundException("Pago no encontrado con ID: " + id));
        pago.setEstado(estadoFinal);
        pago.setTransaccionId(transaccionId);
        return mapToDTO(pagoRepository.save(pago));
    }

    @Override
    public PagoResponseDTO getById(Long id) {
        log.info("Consultando pago ID {}", id);
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new cl.triskeledu.pagos.exception.PagoNotFoundException("Pago no encontrado con ID: " + id));
        return mapToDTO(pago);
    }

    @Override
    public List<PagoResponseDTO> listarPorPedido(Long pedidoId) {
        log.info("Listando pagos por pedido {}", pedidoId);
        return pagoRepository.findByPedidoId(pedidoId).stream()
                .map(this::mapToDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    public List<PagoResponseDTO> listarTodos() {
        log.info("Listando todos los pagos");
        return pagoRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(java.util.stream.Collectors.toList());
    }
    
    private PagoResponseDTO mapToDTO(Pago entity) {
        return PagoResponseDTO.builder()
                .id(entity.getId())
                .pedidoId(entity.getPedidoId())
                .monto(entity.getMonto())
                .metodo(entity.getMetodo())
                .estado(entity.getEstado())
                .transaccionId(entity.getTransaccionId())
                .creadoEn(entity.getCreadoEn())
                .actualizadoEn(entity.getActualizadoEn())
                .build();
    }
}
