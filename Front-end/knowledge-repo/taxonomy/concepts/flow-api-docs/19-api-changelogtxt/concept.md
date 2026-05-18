# Api changelog.txt

## Fuente
Flow API — Documentación de Integración de Pagos (Cap. 19)

## Contenido
# Api changelog.txt

## Código

```
2020-05-25:
- [minor] Se modifica el objeto paymentStatus: Se aÃ±ade nuevo atributo en la secciÃ³n paymentData llamado currency, que indica la moneda con la cual se efectuÃ³ el pago.
- [minor] Se agrega un nuevo parÃ¡metro llamado payment_currency a los servicios payment/create y payment/createEmail: Este parÃ¡metro permite indicar la moneda con la que el comercio espera que se pague una orden de cobro. 

2021-03-18:
- [minor] Se crea nuevo mÃ©todo invoice/outsidePayment, cuyo principal objetivo es permitir que un comercio pueda dar por pagado un importe (invoice asociado a una suscripciÃ³n) por fuera.
- [medium] Se aÃ±aden los siguientes campos al objeto invoice: error, errorDate, errorDescription, outsidePayment y paymentLink.

2021-06-07:
- [minor] Se crea nuevo mÃ©todo settlement/search, cuyo principal objetivo es permitir buscar liquidaciones en un rango de fecha.
- [minor] Se crea nuevo mÃ©todo settlement/getByIdv2, el cual obtiene la liquidaciÃ³n efectuada, a partir de un NÂ° de liquidaciÃ³n. Se utiliza el nuevo formato de liquidaciÃ³n utilizado por Flow desde el 01 de Junio de 2021.
- [minor] Se marcan como deprecados los servicios settlement/getByDate y settlement/getById.

2021-08-03:
- [minor] Se crea nuevo mÃ©todo customer/getSubscriptions, que obtiene la lista de las suscripciones de un customer
- [minor] Se aÃ±ade el atributo public al objeto Plan

2021-10-14
- [minor] Se aÃ±ade el campo planExternalId a la respuesta del servicio customer/getSubscriptions, que corresponde al identificador asignado por el comercio al plan

2022-06-06
- [minor] Se crea nuevo mÃ©todo payment/getStatusExtended, cuyo objetivo es entregar mÃ¡s informaciÃ³n del estado de una orden a partir del token.
- [minor] Se crea nuevo mÃ©todo payment/getStatusByFlowOrderExtended, cuyo objetivo es entregar mÃ¡s informaciÃ³n del estado de una orden a partir del nÃºmero de orden de FLOW.
- [minor] Se aÃ±ade secciÃ³n de cÃ³digos de error.

2023-09-08
- [minor] Se modifica el objeto de respuesta del servicio payment/getStatusExtended, se aÃ±aden los campos installments y authorizationCode a la secciÃ³n paymentData.
- [minor] Se modifica el objeto de respuesta del servicio payment/getStatusByFlowOrderExtended, se aÃ±aden los campos installments y authorizationCode a la secciÃ³n paymentData.
- [minor] Se aÃ±ade secciÃ³n de cÃ³digos de error.

2023-09-25
- [minor] Se crea nuevo mÃ©todo payment/getTransactions, cuyo objetivo es poder listar las transacciones realizadas en un dÃ­a.
```
