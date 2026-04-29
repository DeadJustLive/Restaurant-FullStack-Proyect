package cl.triskeledu.pedidos.service.impl;

import cl.triskeledu.pedidos.dto.request.PedidoRequestDTO;
import cl.triskeledu.pedidos.dto.response.PedidoResponseDTO;
import cl.triskeledu.pedidos.entity.enums.EstadoPedido;
import cl.triskeledu.pedidos.service.PedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * =============================================================================
 * SERVICE IMPL: PedidoServiceImpl
 * =============================================================================
 */
@Service
@Slf4j
public class PedidoServiceImpl implements PedidoService {

    @Override
    public PedidoResponseDTO crear(PedidoRequestDTO dto) {
        /*
         * INTENCIÓN: Orquestar la creación de un pedido.
         *
         * FLUJO ESPERADO:
         *   1. Validar usuario (ms-usuarios).
         *   2. Validar sucursal (ms-sucursales).
         *   3. Por cada ítem: Validar precio y existencia (ms-menu).
         *   4. Guardar pedido e ítems.
         *   5. Vaciar carrito (ms-carrito).
         *   6. Notificar creación (ms-notificaciones).
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public PedidoResponseDTO getById(Long id) {
        /*
         * INTENCIÓN: Consultar pedido.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public List<PedidoResponseDTO> listarActivosPorSucursal(Long sucursalId) {
        /*
         * INTENCIÓN: Listar para pantalla de cocina.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public List<PedidoResponseDTO> listarPorCliente(Long usuarioId) {
        /*
         * INTENCIÓN: Listar historial en app cliente.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public PedidoResponseDTO cambiarEstado(Long id, EstadoPedido nuevoEstado, String motivo) {
        /*
         * INTENCIÓN: Mover el pedido por el workflow.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public PedidoResponseDTO cancelarPedido(Long id) {
        /*
         * INTENCIÓN: Abortar pedido antes de ser preparado.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }
}
