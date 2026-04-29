package cl.triskeledu.sucursales.dto.response;

import lombok.*;

import java.time.LocalDateTime;

/**
 * =============================================================================
 * DTO RESPONSE: SucursalResponseDTO
 * =============================================================================
 *
 * PROPÓSITO:
 *   Respuesta pública de la sucursal.
 *   Consumido por ms-usuarios, ms-menu y frontend.
 *
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SucursalResponseDTO {

    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private Boolean activa;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;
}
