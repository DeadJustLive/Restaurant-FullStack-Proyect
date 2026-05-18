package cl.triskeledu.reportes.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @use(reportes)
 * @kind(type)
 * @limit(lines: 30)
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEventDTO {
    private Long pedidoId;
    private Long usuarioId;
    private Double total;
    private String estado;
    private String tipo;
}