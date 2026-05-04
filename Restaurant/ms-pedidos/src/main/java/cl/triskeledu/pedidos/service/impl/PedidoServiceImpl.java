package cl.triskeledu.pedidos.service.impl;

import cl.triskeledu.pedidos.dto.request.PedidoRequestDTO;
import cl.triskeledu.pedidos.dto.response.PedidoItemResponseDTO;
import cl.triskeledu.pedidos.dto.response.PedidoResponseDTO;
import cl.triskeledu.pedidos.entity.Pedido;
import cl.triskeledu.pedidos.entity.PedidoItem;
import cl.triskeledu.pedidos.entity.enums.EstadoPedido;
import cl.triskeledu.pedidos.exception.PedidoNotFoundException;
import cl.triskeledu.pedidos.repository.PedidoRepository;
import cl.triskeledu.pedidos.service.PedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * =============================================================================
 * SERVICE IMPL: PedidoServiceImpl
 * =============================================================================
 */
@Service
@Slf4j
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    @Transactional
    public PedidoResponseDTO crear(PedidoRequestDTO dto) {
        /*
         * INTENCIÓN: Orquestar la creación de un pedido.
         *
         * FLUJO IMPLEMENTADO:
         *   1. Validar usuario (ms-usuarios) - TODO: Feign
         *   2. Validar sucursal (ms-sucursales) - TODO: Feign
         *   3. Por cada ítem: Validar precio y existencia (ms-menu) - TODO: Simulado
         *   4. Guardar pedido e ítems.
         *   5. Vaciar carrito (ms-carrito) - TODO: Feign
         *   6. Notificar creación (ms-notificaciones) - TODO: Feign o Kafka
         */
        log.info("Creando pedido para usuario {} en sucursal {}", dto.getUsuarioId(), dto.getSucursalId());
        
        Pedido pedido = Pedido.builder()
                .numeroPedido("PED-" + System.currentTimeMillis())
                .usuarioId(dto.getUsuarioId())
                .sucursalId(dto.getSucursalId())
                .estado(EstadoPedido.PENDIENTE) // Asignar estado inicial
                .tipo(dto.getTipo())
                .notas(dto.getNotas())
                .build();
                
        List<PedidoItem> items = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;
        
        for (var itemDto : dto.getItems()) {
            // TODO: Consultar ms-menu via Feign para obtener nombre y precio
            // Simulación de respuesta de ms-menu
            String nombreSnapshot = "Producto " + itemDto.getMenuItemId(); 
            BigDecimal precioSnapshot = new BigDecimal("5000.00"); // Dummy price
            
            BigDecimal subtotal = precioSnapshot.multiply(new BigDecimal(itemDto.getCantidad()));
            total = total.add(subtotal);
            
            PedidoItem item = PedidoItem.builder()
                    .pedido(pedido)
                    .menuItemId(itemDto.getMenuItemId())
                    .nombreSnapshot(nombreSnapshot)
                    .precioUnitario(precioSnapshot)
                    .cantidad(itemDto.getCantidad())
                    .subtotal(subtotal)
                    .build();
                    
            items.add(item);
        }
        
        pedido.setItems(items);
        pedido.setTotal(total);
        
        Pedido saved = pedidoRepository.save(pedido);
        return mapToDTO(saved);
    }

    @Override
    public PedidoResponseDTO obtenerPorId(Long id) {
        log.info("Consultando pedido ID {}", id);
        Pedido pedido = pedidoRepository.findByIdWithItems(id)
                .orElseThrow(() -> new PedidoNotFoundException("Pedido no encontrado con ID: " + id));
        return mapToDTO(pedido);
    }

    @Override
    public List<PedidoResponseDTO> obtenerColaSucursal(Long sucursalId) {
        log.info("Listando pedidos activos para sucursal {}", sucursalId);
        List<EstadoPedido> estadosFinales = List.of(EstadoPedido.ENTREGADO, EstadoPedido.CANCELADO);
        return pedidoRepository.findBySucursalIdAndEstadoNotIn(sucursalId, estadosFinales).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PedidoResponseDTO> obtenerPorUsuario(Long usuarioId) {
        log.info("Listando pedidos para usuario {}", usuarioId);
        return pedidoRepository.findByUsuarioIdOrderByCreadoEnDesc(usuarioId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PedidoResponseDTO cambiarEstado(Long id, EstadoPedido nuevoEstado) {
        log.info("Cambiando estado de pedido {} a {}", id, nuevoEstado);
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNotFoundException("Pedido no encontrado con ID: " + id));
                
        // Lógica simple de máquina de estados podría agregarse aquí
        pedido.setEstado(nuevoEstado);
        
        // TODO: Agregar lógica si el estado es LISTO o CANCELADO notificar.
        
        Pedido updated = pedidoRepository.save(pedido);
        return mapToDTO(updated);
    }

    @Override
    @Transactional
    public PedidoResponseDTO cancelar(Long id) {
        log.info("Cancelando pedido {}", id);
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNotFoundException("Pedido no encontrado con ID: " + id));
                
        if (pedido.getEstado() != EstadoPedido.PENDIENTE && pedido.getEstado() != EstadoPedido.CONFIRMADO) {
            throw new RuntimeException("El pedido no puede ser cancelado en este estado");
        }
        
        pedido.setEstado(EstadoPedido.CANCELADO);
        Pedido updated = pedidoRepository.save(pedido);
        return mapToDTO(updated);
    }

    @Override
    public List<PedidoResponseDTO> listarTodos() {
        log.info("Listando todos los pedidos");
        return pedidoRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    
    private PedidoResponseDTO mapToDTO(Pedido entity) {
        List<PedidoItemResponseDTO> itemDTOs = new ArrayList<>();
        if (entity.getItems() != null) {
            itemDTOs = entity.getItems().stream().map(item -> PedidoItemResponseDTO.builder()
                    .id(item.getId())
                    .menuItemId(item.getMenuItemId())
                    .nombreSnapshot(item.getNombreSnapshot())
                    .precioUnitario(item.getPrecioUnitario())
                    .cantidad(item.getCantidad())
                    .subtotal(item.getSubtotal())
                    .build()).collect(Collectors.toList());
        }
        
        return PedidoResponseDTO.builder()
                .id(entity.getId())
                .numeroPedido(entity.getNumeroPedido())
                .usuarioId(entity.getUsuarioId())
                .sucursalId(entity.getSucursalId())
                .estado(entity.getEstado())
                .tipo(entity.getTipo())
                .total(entity.getTotal())
                .notas(entity.getNotas())
                .items(itemDTOs)
                .creadoEn(entity.getCreadoEn())
                .actualizadoEn(entity.getActualizadoEn())
                .build();
    }
}
