# Status

# Obtener factura

### Firma de parámetros​

Para obtener una factura se debe llamar al recurso/invoice/getmediante un método GET.

Identificador del Invoice

La firma de los parámetros efectuada con su secretKey.

El servicio retorna el objeto invoice.

Identificador del importe

Identificador de la suscripción

Identificador del cliente

Fecha de creación del importe

Descripción del importe

Fecha de inicio del período del importe

Fecha de término del período del importe

Número de intentos de cobro del importe

Si este importe se cobrará:

Fecha del siguiente intento de cobro

Fecha en que este importe será considerado moroso

Si se produjo un error al intentar cobrar el invoice:

Fecha en que se produjo el error o null si no hay error

Descripción de error o null si no hay error

Objeto que representa un cobro y si está pagado su correspondiente pago

Objeto que muestra los datos de un pago por fuera

Link de pago. Cuando el invoice no esta pagado

Intentos de cargo fallidos

## Código

```
/invoice/get
```

```typescript
{"apiKey":"string","invoiceId":0,"s":"string"}
```

```
$secretKey = 'my secret'$params = array('apiKey' => '1F90971E-8276-4715-97FF-2BLG5030EE3B','token' => 'AJ089FF5467367');$keys = array_keys($params);sort($keys);$toSign = '';foreach($keys as $key) {$toSign .= $key . $params[$key];};$signature = hash_hmac('sha256', $toSign , $secretKey);
```

```
$secretKey = 'my secret'$params = array('apiKey' => '1F90971E-8276-4715-97FF-2BLG5030EE3B','token' => 'AJ089FF5467367');$keys = array_keys($params);sort($keys);$toSign = '';foreach($keys as $key) {$toSign .= $key . $params[$key];};$signature = hash_hmac('sha256', $toSign , $secretKey);
```

```
const{createHmac}=require("node:crypto")constsecretKey="my secret";constparams={apiKey:"1F90971E-8276-4715-97FF-2BLG5030EE3B",token:"AJ089FF5467367",};constkeys=Object.keys(params);keys.sort();lettoSign="";for(leti=0;i<keys.length;i++){letkey=keys[i];toSign+=key+params[key];}constsignature=createHmac("sha256",secretKey).update(toSign).digest("hex")
```

```
const{createHmac}=require("node:crypto")constsecretKey="my secret";constparams={apiKey:"1F90971E-8276-4715-97FF-2BLG5030EE3B",token:"AJ089FF5467367",};constkeys=Object.keys(params);keys.sort();lettoSign="";for(leti=0;i<keys.length;i++){letkey=keys[i];toSign+=key+params[key];}constsignature=createHmac("sha256",secretKey).update(toSign).digest("hex")
```

```
importhmacimporthashlibsecret_keyparams={'apiKey':'1F90971E-8276-4715-97FF-2BLG5030EE3B','token':'AJ089FF5467367'}keys=list(params.keys())keys.sort()to_sign=''forkeyinkeys:to_sign+=key+params[key]signature=hmac.new(secret_key.encode(),to_sign.encode(),hashlib.sha256).hexdigest()
```

```
importhmacimporthashlibsecret_keyparams={'apiKey':'1F90971E-8276-4715-97FF-2BLG5030EE3B','token':'AJ089FF5467367'}keys=list(params.keys())keys.sort()to_sign=''forkeyinkeys:to_sign+=key+params[key]signature=hmac.new(secret_key.encode(),to_sign.encode(),hashlib.sha256).hexdigest()
```

```typescript
{"id":1034,"subscriptionId":"sus_azcyjj9ycd","customerId":"cus_eblcbsua2g","created":"2018-06-26 17:29:06","subject":"PlanPesos - período 2018-06-27 / 2018-06-27","currency":"CLP","amount":20000,"period_start":"2018-06-27 00:00:00","period_end":"2018-07-26 00:00:00","attemp_count":0,"attemped":1,"next_attemp_date":"2018-07-27 00:00:00","due_date":"2018-06-30 00:00:00","status":0,"error":0,"errorDate":"2018-06-30 00:00:00","errorDescription":"The minimum amount is 350 CLP","items":[{"id":567,"subject":"PlanPesos - período 2018-06-27 / 2018-06-27","type":1,"currency":"CLP","amount":20000}],"payment":{"flowOrder":3567899,"commerceOrder":"sf12377","requestDate":"2017-07-21 12:32:11","status":1,"subject":"game console","currency":"CLP","amount":12000,"payer":"pperez@gamil.com","optional":{"RUT":"7025521-9","ID":"899564778"},"pending_info":{"media":"Multicaja","date":"2017-07-21 10:30:12"},"paymentData":{"date":"2017-07-21 12:32:11","media":"webpay","conversionDate":"2017-07-21","conversionRate":1.1,"amount":12000,"currency":"CLP","fee":551,"balance":11499,"transferDate":"2017-07-24"},"merchantId":"string"},"outsidePayment":{"date":"2021-03-08 00:00:00","comment":"Pago por caja"},"paymentLink":"https://www.flow.cl/app/web/pay.php?token=7C18C35358FEF0E33C056C719E94956D4FC9BBEL","chargeAttemps":[{"id":901,"date":"2018-12-06 15:03:33","customerId":"cus_1uqfm95dch","invoiceId":1234,"commerceOrder":"1883","currency":"CLP","amount":90000,"errorCode":1605,"errorDescription":"This commerceOrder 1883 has been previously paid"}]}
```

- Primeros pasos
- Quickstart
- Métodos de Pago
- Pago EcommerceFlujo de integraciónCreación de ordenEstado de ordenConfirmación de ordenFinalización de ordenReversar orden
- Flujo de integración
- Creación de orden
- Estado de orden
- Confirmación de orden
- Finalización de orden
- Reversar orden
- Planes de SuscripciónFlujo de integraciónCrear un planCrear un clienteRegistrar tarjetaEstado suscripciónCrear una suscripciónCrear cupónObtener factura
- Flujo de integración
- Crear un plan
- Crear un cliente
- Registrar tarjeta
- Estado suscripción
- Crear una suscripción
- Crear cupón
- Obtener factura
- Plugins
- Comercios Asociados
- Liquidaciones
- Credenciales de prueba

- Flujo de integración
- Creación de orden
- Estado de orden
- Confirmación de orden
- Finalización de orden
- Reversar orden

- Flujo de integración
- Crear un plan
- Crear un cliente
- Registrar tarjeta
- Estado suscripción
- Crear una suscripción
- Crear cupón
- Obtener factura

- Planes de Suscripción
- Obtener factura

- "apiKey":"string",
- "invoiceId":0,
- "s":"string"

- PHP
- NodeJS
- Phyton

- 1 Se cobrará
- 0 No se cobrará

- 0 impago
- 1 pagado
- 2 anulado

- 0 Sin error
- 1 Con error

- "id":1034,
- "subscriptionId":"sus_azcyjj9ycd",
- "customerId":"cus_eblcbsua2g",
- "created":"2018-06-26 17:29:06",
- "subject":"PlanPesos - período 2018-06-27 / 2018-06-27",
- "currency":"CLP",
- "amount":20000,
- "period_start":"2018-06-27 00:00:00",
- "period_end":"2018-07-26 00:00:00",
- "attemp_count":0,
- "attemped":1,
- "next_attemp_date":"2018-07-27 00:00:00",
- "due_date":"2018-06-30 00:00:00",
- "status":0,
- "error":0,
- "errorDate":"2018-06-30 00:00:00",
- "errorDescription":"The minimum amount is 350 CLP",
- "items":[{"id":567,"subject":"PlanPesos - período 2018-06-27 / 2018-06-27","type":1,"currency":"CLP","amount":20000}],
- {"id":567,"subject":"PlanPesos - período 2018-06-27 / 2018-06-27","type":1,"currency":"CLP","amount":20000}
- "id":567,
- "subject":"PlanPesos - período 2018-06-27 / 2018-06-27",
- "type":1,
- "currency":"CLP",
- "amount":20000
- "payment":{"flowOrder":3567899,"commerceOrder":"sf12377","requestDate":"2017-07-21 12:32:11","status":1,"subject":"game console","currency":"CLP","amount":12000,"payer":"pperez@gamil.com","optional":{"RUT":"7025521-9","ID":"899564778"},"pending_info":{"media":"Multicaja","date":"2017-07-21 10:30:12"},"paymentData":{"date":"2017-07-21 12:32:11","media":"webpay","conversionDate":"2017-07-21","conversionRate":1.1,"amount":12000,"currency":"CLP","fee":551,"balance":11499,"transferDate":"2017-07-24"},"merchantId":"string"},
- "flowOrder":3567899,
- "commerceOrder":"sf12377",
- "requestDate":"2017-07-21 12:32:11",
- "status":1,
- "subject":"game console",
- "currency":"CLP",
- "amount":12000,
- "payer":"pperez@gamil.com",
- "optional":{"RUT":"7025521-9","ID":"899564778"},
- "RUT":"7025521-9",
- "ID":"899564778"
- "pending_info":{"media":"Multicaja","date":"2017-07-21 10:30:12"},
- "media":"Multicaja",
- "date":"2017-07-21 10:30:12"
- "paymentData":{"date":"2017-07-21 12:32:11","media":"webpay","conversionDate":"2017-07-21","conversionRate":1.1,"amount":12000,"currency":"CLP","fee":551,"balance":11499,"transferDate":"2017-07-24"},
- "date":"2017-07-21 12:32:11",
- "media":"webpay",
- "conversionDate":"2017-07-21",
- "conversionRate":1.1,
- "amount":12000,
- "currency":"CLP",
- "fee":551,
- "balance":11499,
- "transferDate":"2017-07-24"
- "merchantId":"string"
- "outsidePayment":{"date":"2021-03-08 00:00:00","comment":"Pago por caja"},
- "date":"2021-03-08 00:00:00",
- "comment":"Pago por caja"
- "paymentLink":"https://www.flow.cl/app/web/pay.php?token=7C18C35358FEF0E33C056C719E94956D4FC9BBEL",
- "chargeAttemps":[{"id":901,"date":"2018-12-06 15:03:33","customerId":"cus_1uqfm95dch","invoiceId":1234,"commerceOrder":"1883","currency":"CLP","amount":90000,"errorCode":1605,"errorDescription":"This commerceOrder 1883 has been previously paid"}]
- {"id":901,"date":"2018-12-06 15:03:33","customerId":"cus_1uqfm95dch","invoiceId":1234,"commerceOrder":"1883","currency":"CLP","amount":90000,"errorCode":1605,"errorDescription":"This commerceOrder 1883 has been previously paid"}
- "id":901,
- "date":"2018-12-06 15:03:33",
- "customerId":"cus_1uqfm95dch",
- "invoiceId":1234,
- "commerceOrder":"1883",
- "currency":"CLP",
- "amount":90000,
- "errorCode":1605,
- "errorDescription":"This commerceOrder 1883 has been previously paid"

- {"id":567,"subject":"PlanPesos - período 2018-06-27 / 2018-06-27","type":1,"currency":"CLP","amount":20000}
- "id":567,
- "subject":"PlanPesos - período 2018-06-27 / 2018-06-27",
- "type":1,
- "currency":"CLP",
- "amount":20000

- "id":567,
- "subject":"PlanPesos - período 2018-06-27 / 2018-06-27",
- "type":1,
- "currency":"CLP",
- "amount":20000

- "flowOrder":3567899,
- "commerceOrder":"sf12377",
- "requestDate":"2017-07-21 12:32:11",
- "status":1,
- "subject":"game console",
- "currency":"CLP",
- "amount":12000,
- "payer":"pperez@gamil.com",
- "optional":{"RUT":"7025521-9","ID":"899564778"},
- "RUT":"7025521-9",
- "ID":"899564778"
- "pending_info":{"media":"Multicaja","date":"2017-07-21 10:30:12"},
- "media":"Multicaja",
- "date":"2017-07-21 10:30:12"
- "paymentData":{"date":"2017-07-21 12:32:11","media":"webpay","conversionDate":"2017-07-21","conversionRate":1.1,"amount":12000,"currency":"CLP","fee":551,"balance":11499,"transferDate":"2017-07-24"},
- "date":"2017-07-21 12:32:11",
- "media":"webpay",
- "conversionDate":"2017-07-21",
- "conversionRate":1.1,
- "amount":12000,
- "currency":"CLP",
- "fee":551,
- "balance":11499,
- "transferDate":"2017-07-24"
- "merchantId":"string"

- "RUT":"7025521-9",
- "ID":"899564778"

- "media":"Multicaja",
- "date":"2017-07-21 10:30:12"

- "date":"2017-07-21 12:32:11",
- "media":"webpay",
- "conversionDate":"2017-07-21",
- "conversionRate":1.1,
- "amount":12000,
- "currency":"CLP",
- "fee":551,
- "balance":11499,
- "transferDate":"2017-07-24"

- "date":"2021-03-08 00:00:00",
- "comment":"Pago por caja"

- {"id":901,"date":"2018-12-06 15:03:33","customerId":"cus_1uqfm95dch","invoiceId":1234,"commerceOrder":"1883","currency":"CLP","amount":90000,"errorCode":1605,"errorDescription":"This commerceOrder 1883 has been previously paid"}
- "id":901,
- "date":"2018-12-06 15:03:33",
- "customerId":"cus_1uqfm95dch",
- "invoiceId":1234,
- "commerceOrder":"1883",
- "currency":"CLP",
- "amount":90000,
- "errorCode":1605,
- "errorDescription":"This commerceOrder 1883 has been previously paid"

- "id":901,
- "date":"2018-12-06 15:03:33",
- "customerId":"cus_1uqfm95dch",
- "invoiceId":1234,
- "commerceOrder":"1883",
- "currency":"CLP",
- "amount":90000,
- "errorCode":1605,
- "errorDescription":"This commerceOrder 1883 has been previously paid"

- Firma de parámetros

- Documentación
- Referencias API
- Plugins para ecommerce

- Preguntas frecuentes
- Términos y condiciones
- Politicas de privacidad