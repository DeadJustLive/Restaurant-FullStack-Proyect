package cl.triskeledu.sucursales.controller;

import cl.triskeledu.sucursales.dto.request.SucursalRequestDTO;
import cl.triskeledu.sucursales.dto.response.SucursalResponseDTO;
import cl.triskeledu.sucursales.service.SucursalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =============================================================================
 * CONTROLLER: SucursalController
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/sucursales")
@RequiredArgsConstructor
@Slf4j
public class SucursalController {

    private final SucursalService sucursalService;

    @PostMapping
    public ResponseEntity<SucursalResponseDTO> crear(@Valid @RequestBody SucursalRequestDTO dto) {
        log.info("[SucursalController] POST /sucursales — nombre={}", dto.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(sucursalService.crear(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SucursalResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(sucursalService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SucursalResponseDTO>> listarActivas() {
        return ResponseEntity.ok(sucursalService.listarActivas());
    }

    @GetMapping("/todas")
    public ResponseEntity<List<SucursalResponseDTO>> listarTodas() {
        return ResponseEntity.ok(sucursalService.listarTodas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SucursalResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody SucursalRequestDTO dto) {
        return ResponseEntity.ok(sucursalService.actualizar(id, dto));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<SucursalResponseDTO> cambiarEstado(@PathVariable Long id, @RequestParam Boolean activa) {
        return ResponseEntity.ok(sucursalService.cambiarEstado(id, activa));
    }
}
