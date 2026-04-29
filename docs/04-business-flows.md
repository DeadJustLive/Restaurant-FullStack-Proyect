# 🔁 Flujos y Reglas de Negocio Transversales

## 1. Flujo de Compra (End-to-End)
Este es el proceso principal del sistema, involucrando múltiples microservicios:

```mermaid
sequenceDiagram
    participant C as Cliente (Frontend)
    participant CR as ms-carrito
    participant P as ms-pedidos
    participant M as ms-menu
    participant I as ms-inventario
    participant PG as ms-pagos

    C->>CR: Agrega ítems al carrito
    C->>P: Ejecuta Checkout
    P->>M: Consulta precios vigentes
    P->>I: Valida y descuenta Stock
    P->>P: Crea Pedido (Estado: PENDIENTE)
    P->>PG: Inicia proceso de pago
    PG-->>P: Pago Exitoso
    P->>P: Cambia Estado (PAGADO)
    P->>C: Notifica Confirmación
```

## 2. Reglas de Negocio Críticas
*   **Validación de Stock:** No se puede confirmar un pedido si alguno de los ítems en `ms-inventario` tiene stock < cantidad solicitada.
*   **Inmutabilidad de Precios:** Una vez creado el pedido, el precio de los ítems se congela. Cambios posteriores en `ms-menu` no afectan pedidos existentes.
*   **Restricción de Rol:** Solo un usuario con `ROLE_RP` (Repartidor) puede cambiar el estado de un pedido a `EN_CAMINO` o `ENTREGADO`.

## 3. Estados del Pedido
1.  `PENDIENTE`: Creado pero sin pago confirmado.
2.  `PAGADO`: Confirmación recibida de `ms-pagos`.
3.  `EN_PREPARACION`: El `COCINERO` aceptó la orden.
4.  `LISTO`: Preparación finalizada.
5.  `EN_CAMINO`: El `REPARTIDOR` retiró el pedido.
6.  `ENTREGADO`: Cliente recibió el producto.
