package cl.triskeledu.inventario.controller;

import cl.triskeledu.inventario.dto.request.InsumoRequestDTO;
import cl.triskeledu.inventario.dto.request.MovimientoRequestDTO;
import cl.triskeledu.inventario.dto.response.InsumoResponseDTO;
import cl.triskeledu.inventario.dto.response.MovimientoResponseDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =============================================================================
 * CONTROLLER: InventarioController
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/inventario")
@Slf4j
public class InventarioController {

    @PostMapping("/insumos")
    public ResponseEntity<InsumoResponseDTO> crearInsumo(@Valid @RequestBody InsumoRequestDTO dto) {
        /*
         * INTENCIÓN: Solo ROLE_AD o gerente de sucursal.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @PutMapping("/insumos/{id}")
    public ResponseEntity<InsumoResponseDTO> actualizarInsumo(@PathVariable Long id, @Valid @RequestBody InsumoRequestDTO dto) {
        /*
         * INTENCIÓN: Edición de datos maestros.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/insumos/sucursal/{sucursalId}")
    public ResponseEntity<List<InsumoResponseDTO>> listarPorSucursal(@PathVariable Long sucursalId) {
        /*
         * INTENCIÓN: Vista de stock de la sucursal.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @PostMapping("/movimientos")
    public ResponseEntity<MovimientoResponseDTO> registrarMovimiento(@Valid @RequestBody MovimientoRequestDTO dto) {
        /*
         * INTENCIÓN: Endpoint crítico. Llamado por ms-pedidos (SALIDA) o por admin (ENTRADA/Ajustes).
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/insumos/{insumoId}/kardex")
    public ResponseEntity<List<MovimientoResponseDTO>> historialKardex(@PathVariable Long insumoId) {
        /*
         * INTENCIÓN: Reporte de auditoría.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }
}
