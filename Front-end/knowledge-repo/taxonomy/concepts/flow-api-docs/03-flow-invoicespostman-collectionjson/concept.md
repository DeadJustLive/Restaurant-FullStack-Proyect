# Flow Invoices.postman collection.json

## Fuente
Flow API — Documentación de Integración de Pagos (Cap. 3)

## Contenido
# Flow Invoices.postman collection.json

## Código

```typescript
{
	"info": {
		"_postman_id": "6da88223-96b0-4ba0-8909-5087b9d83513",
		"name": "Flow Invoices",
		"description": "Importes, cobros de suscripciones",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "invoice/get",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://{{Hosting}}/api/invoice/get?apiKey={{apiKey}}&invoiceId=5413&s={{Signature}}",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"invoice",
						"get"
					],
					"query": [
						{
							"key": "apiKey",
							"value": "{{apiKey}}"
						},
						{
							"key": "invoiceId",
							"value": "5413"
						},
						{
							"key": "s",
							"value": "{{Signature}}"
						}
					]
				},
				"description": "Obtiene un Invoice"
			},
			"response": []
		},
		{
			"name": "invoice/getOverDue",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://{{Hosting}}/api/invoice/getOverDue?apiKey={{apiKey}}&s={{Signature}}",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"invoice",
						"getOverDue"
					],
					"query": [
						{
							"key": "apiKey",
							"value": "{{apiKey}}"
						},
						{
							"key": "s",
							"value": "{{Signature}}"
						}
					]
				},
				"description": "Obtiene los invoices vencidos"
			},
			"response": []
		},
		{
			"name": "invoice/retryToCollect",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "formdata",
					"formdata": [
						{
							"key": "apiKey",
							"value": "{{apiKey}}",
							"type": "text"
						},
						{
							"key": "invoiceId",
							"value": "5413",
							"type": "text"
						},
						{
							"key": "s",
							"value": "{{Signature}}",
							"type": "text"
						}
					]
				},
				"url": {
					"raw": "https://{{Hosting}}/api/invoice/retryToCollect",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"invoice",
						"retryToCollect"
					]
				},
				"description": "Reintenta el cobro de un Invoice vencido"
			},
			"response": []
		},
		{
			"name": "invoice/cancel",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "formdata",
					"formdata": [
						{
							"key": "apiKey",
							"value": "{{apiKey}}",
							"type": "text"
						},
						{
							"key": "invoiceId",
							"value": "5413",
							"type": "text"
						},
						{
							"key": "s",
							"value": "{{Signature}}",
							"type": "text"
						}
					]
				},
				"url": {
					"raw": "https://{{Hosting}}/api/invoice/cancel",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"invoice",
						"cancel"
					]
				},
				"description": "Cancela un invoice pendiente de pago"
			},
			"response": []
		},
		{
			"name": "invoice/outsidePayment",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "formdata",
					"formdata": [
						{
							"key": "apiKey",
							"value": "{{apiKey}}",
							"type": "text"
						},
						{
							"key": "invoiceId",
							"value": "3458",
							"type": "text"
						},
						{
							"key": "date",
							"value": "2021-02-24 20:56:00",
							"type": "text"
						},
						{
							"key": "comment",
							"value": "Pagado con transferencia",
							"type": "text"
						},
						{
							"key": "s",
							"value": "{{Signature}}",
							"type": "text"
						}
					]
				},
				"url": {
					"raw": "https://{{Hosting}}/api/invoice/outsidePayment",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"invoice",
						"outsidePayment"
					]
				}
			},
			"response": []
		}
	],
	"event": [
		{
			"listen": "prerequest",
			"script": {
				"type": "text/javascript",
				"exec": [
					"var toSign = getToSign();",
					"console.log(toSign);",
					"var hash = CryptoJS.HmacSHA256(toSign, pm.variables.get(\"secretKey\"));",
					"pm.environment.set(\"Signature\", hash.toString());",
					"",
					"",
					"function getToSign() {",
					"    var textToSign = \"\";",
					"    var data;",
					"    var params = new Map()",
					"    if(request.method === \"POST\") {",
					"        data = request.data;",
					"    } else if(request.method === \"GET\") {",
					"        data = getUrlVars(request.url);",
					"    }",
					"    for(var name in data) {",
					"        if(name === \"s\" ) {",
					"            continue;",
					"        }",
					"        var value = data[name];",
					"        if (value.startsWith('{{')) {",
					"            value = pm.variables.get(clearEnvironment(value)); ",
					"        }",
					"        params.set(name, value);",
					"    }",
					"    var sortedKeys = Array.from(params.keys()).sort();",
					" 
