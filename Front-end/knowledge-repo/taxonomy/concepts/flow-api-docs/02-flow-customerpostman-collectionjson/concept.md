# Flow Customer.postman collection.json

## Fuente
Flow API — Documentación de Integración de Pagos (Cap. 2)

## Contenido
# Flow Customer.postman collection.json

## Código

```typescript
{
	"info": {
		"_postman_id": "c5011ab3-ba9b-4fcb-a680-a38286830f1a",
		"name": "Flow Customer",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "customer/create",
			"event": [
				{
					"listen": "prerequest",
					"script": {
						"id": "bbd7c58a-11f6-4030-be94-679e5227125b",
						"exec": [
							""
						],
						"type": "text/javascript"
					}
				},
				{
					"listen": "test",
					"script": {
						"id": "f8dc3e22-fc44-48cd-b9d0-86d13672d4d3",
						"exec": [
							"var jsonData = pm.response.json();\r",
							"pm.environment.set(\"CustomerId\", jsonData.customerId);\r",
							""
						],
						"type": "text/javascript"
					}
				}
			],
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
							"key": "name",
							"value": "Carlos Sepulveda",
							"type": "text"
						},
						{
							"key": "email",
							"value": "csepulveda@tuxpan.com",
							"type": "text"
						},
						{
							"key": "externalId",
							"value": "{{External_Id}}",
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
					"raw": "https://{{Hosting}}/api/plans/create",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"plans",
						"create"
					]
				},
				"description": "Crea una transaccion"
			},
			"response": []
		},
		{
			"name": "customer/get",
			"event": [
				{
					"listen": "test",
					"script": {
						"id": "930141df-21ba-48a8-8d08-46d032ca2010",
						"exec": [
							""
						],
						"type": "text/javascript"
					}
				},
				{
					"listen": "prerequest",
					"script": {
						"id": "78142219-e4ac-4c89-b1c1-89b66a06a41d",
						"exec": [
							""
						],
						"type": "text/javascript"
					}
				}
			],
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://{{Hosting}}/api/customer/get?apiKey={{apiKey}}&customerId={{CustomerId}}&s={{Signature}}",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"customer",
						"get"
					],
					"query": [
						{
							"key": "apiKey",
							"value": "{{apiKey}}"
						},
						{
							"key": "customerId",
							"value": "{{CustomerId}}"
						},
						{
							"key": "s",
							"value": "{{Signature}}"
						}
					]
				},
				"description": "Obtiene los datos de un cliente"
			},
			"response": []
		},
		{
			"name": "customer/edit",
			"event": [
				{
					"listen": "prerequest",
					"script": {
						"id": "362c9991-7ff8-45dc-8cb3-72c22209a3fa",
						"exec": [
							""
						],
						"type": "text/javascript"
					}
				},
				{
					"listen": "test",
					"script": {
						"id": "dd01645b-e401-491f-98d2-83bddfae806c",
						"exec": [
							""
						],
						"type": "text/javascript"
					}
				}
			],
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
							"key": "customerId",
							"value": "{{CustomerId}}",
							"type": "text"
						},
						{
							"key": "externalId",
							"value": "7777",
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
					"raw": "https://{{Hosting}}/api/customer/edit",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"customer",
						"edit"
					]
				},
				"description": "Edita el registro de un cliente"
			},
			"response": []
		},
		{
			"name": "customer/list",
			"event": [
				{
					"listen": "prerequest",
					"script": {
						"id": "6f924fa9-7c23-40a4-b3a1-a77c5f76e62c",
						"exec": [
							""
						],
						"type": "text/javascript"
					}
				},
				{
					"listen": "test",
					"script": {
						"id": "be936f2f-bb2a-49fa-a913-b33ae1084fef",
						"exec": [
							""
						],
						"type": "text/javascript"
					}
				}
			],
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://{{Hosting}}/api/customer/list?apiKey={{apiKey}}&s={{Signature}}",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"customer",
						"list"
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
				"description": "Lista mis clientes"
			},
			"response": []
		},
		{
			"name": "customer/register",
			"event": [
				{
					"listen": "test",
					"script": {
						"id": "1
