package cl.triskeledu.inventario.controller;

import cl.triskeledu.inventario.dto.request.InsumoRequestDTO;
import cl.triskeledu.inventario.dto.request.MovimientoRequestDTO;
import cl.triskeledu.inventario.dto.response.InsumoResponseDTO;
import cl.triskeledu.inventario.dto.response.MovimientoResponseDTO;
import cl.triskeledu.inventario.service.InventarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
@RequiredArgsConstructor
@Slf4j
public class InventarioController {

    private final InventarioService inventarioService;

    @PostMapping("/insumos")
    public ResponseEntity<InsumoResponseDTO> crearInsumo(@RequestHeader(value = "X-Credencial-Id", defaultValue = "1") Long credencialId,
                                                         @Valid @RequestBody InsumoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inventarioService.crearInsumo(credencialId, dto));
    }

    @PutMapping("/insumos/{id}")
    public ResponseEntity<InsumoResponseDTO> actualizarInsumo(@RequestHeader(value = "X-Credencial-Id", defaultValue = "1") Long credencialId,
                                                              @PathVariable Long id, @Valid @RequestBody InsumoRequestDTO dto) {
        return ResponseEntity.ok(inventarioService.actualizarInsumo(credencialId, id, dto));
    }

    @GetMapping
    public ResponseEntity<List<InsumoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(inventarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsumoResponseDTO> getInsumoById(@PathVariable Long id) {
        return ResponseEntity.ok(inventarioService.getInsumoById(id));
    }

    @GetMapping("/insumos/sucursal/{sucursalId}")
    public ResponseEntity<List<InsumoResponseDTO>> listarPorSucursal(@PathVariable Long sucursalId) {
        return ResponseEntity.ok(inventarioService.listarPorSucursal(sucursalId));
    }

    @PostMapping("/movimientos")
    public ResponseEntity<MovimientoResponseDTO> registrarMovimiento(@RequestHeader(value = "X-Credencial-Id", defaultValue = "1") Long credencialId,
                                                                     @Valid @RequestBody MovimientoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inventarioService.registrarMovimiento(credencialId, dto));
    }

    @PatchMapping("/{id}/stock")
    public ResponseEntity<MovimientoResponseDTO> ajustarStock(
            @RequestHeader(value = "X-Credencial-Id", defaultValue = "1") Long credencialId,
            @PathVariable Long id,
            @Valid @RequestBody MovimientoRequestDTO dto) {
        dto.setInsumoId(id);
        return ResponseEntity.ok(inventarioService.registrarMovimiento(credencialId, dto));
    }

    @GetMapping("/insumos/{insumoId}/kardex")
    public ResponseEntity<List<MovimientoResponseDTO>> historialKardex(@PathVariable Long insumoId) {
        return ResponseEntity.ok(inventarioService.historialKardex(insumoId));
    }
}
