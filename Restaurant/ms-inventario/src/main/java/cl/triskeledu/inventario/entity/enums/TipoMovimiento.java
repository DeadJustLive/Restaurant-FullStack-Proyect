package cl.triskeledu.inventario.entity.enums;

public enum TipoMovimiento {
    INGRESO, // Compras, ajustes positivos (stock += cantidad)
    EGRESO,  // Consumo por ventas (stock -= cantidad)
    MERMA,   // Pérdida, vencimiento (stock -= cantidad)
    AJUSTE   // Corrección de inventario (stock += cantidad)
}
