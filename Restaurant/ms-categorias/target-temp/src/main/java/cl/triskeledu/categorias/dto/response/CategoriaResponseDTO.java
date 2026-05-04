package cl.triskeledu.categorias.dto.response;

import lombok.*;

import java.time.LocalDateTime;

/**
 * =============================================================================
 * DTO RESPONSE: CategoriaResponseDTO
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaResponseDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean activa;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;
}
