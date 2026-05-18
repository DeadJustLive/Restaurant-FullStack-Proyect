package cl.triskeledu.inventario.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @use(inventario)
 * @kind(type)
 * @limit(lines: 30)
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockEventDTO {
    private Long insumoId;
    private Long sucursalId;
    private String tipoMovimiento;
    private Double cantidad;
    private Double stockActual;
    private boolean stockBajo;
}