package cl.triskeledu.delivery.entity.enums;

public enum EstadoDelivery {
    BUSCANDO_REPARTIDOR, // El pedido está listo, esperando que un repartidor lo acepte/asigne
    ASIGNADO,            // Repartidor asignado, yendo a retirar a la sucursal
    EN_CAMINO,           // Repartidor retiró el pedido y va hacia el cliente
    ENTREGADO,           // El cliente recibió el pedido
    CANCELADO            // Problema logístico insalvable
}
