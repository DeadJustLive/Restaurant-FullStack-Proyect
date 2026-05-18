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
public class PagoEventDTO {
    private Long pagoId;
    private Long pedidoId;
    private String estado;
    private Double monto;
    private String metodo;
}