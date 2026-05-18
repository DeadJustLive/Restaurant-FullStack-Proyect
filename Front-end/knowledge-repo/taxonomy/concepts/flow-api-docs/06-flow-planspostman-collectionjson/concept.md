# Flow Plans.postman collection.json

## Fuente
Flow API — Documentación de Integración de Pagos (Cap. 6)

## Contenido
# Flow Plans.postman collection.json

## Código

```typescript
{
	"info": {
		"_postman_id": "b89714e3-e744-4509-b0c4-08e8cb49c7b1",
		"name": "Flow Plans",
		"description": "Planes de Suscripción",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "plans/create",
			"event": [
				{
					"listen": "test",
					"script": {
						"id": "1b1fb356-f377-4601-89ee-9acc43a6183c",
						"exec": [
							"var jsonData = pm.response.json();\r",
							"pm.environment.set(\"PlanId\", jsonData.planId);"
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
							"key": "planId",
							"value": "NuevosParam",
							"type": "text"
						},
						{
							"key": "name",
							"value": "Mi Plan de nuevos params",
							"type": "text"
						},
						{
							"key": "currency",
							"value": "UF",
							"type": "text"
						},
						{
							"key": "amount",
							"value": "0.32",
							"type": "text"
						},
						{
							"key": "interval",
							"value": "3",
							"type": "text"
						},
						{
							"key": "trial_period_days",
							"value": "7",
							"type": "text"
						},
						{
							"key": "periods_number",
							"value": "6",
							"type": "text"
						},
						{
							"key": "charges_retries_number",
							"value": "3",
							"type": "text"
						},
						{
							"key": "currency_convert_option",
							"value": "1",
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
				"description": "Crear un Plan"
			},
			"response": []
		},
		{
			"name": "plans/get",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://{{Hosting}}/api/plans/get?apiKey={{apiKey}}&planId={{PlanId}}&s={{Signature}}",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"plans",
						"get"
					],
					"query": [
						{
							"key": "apiKey",
							"value": "{{apiKey}}"
						},
						{
							"key": "planId",
							"value": "{{PlanId}}"
						},
						{
							"key": "s",
							"value": "{{Signature}}"
						}
					]
				},
				"description": "Obtiene los datos de un Plan"
			},
			"response": []
		},
		{
			"name": "plans/edit",
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
							"key": "planId",
							"value": "{{PlanId}}",
							"type": "text"
						},
						{
							"key": "name",
							"value": "Mi Plan de Test 11",
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
					"raw": "https://{{Hosting}}/api/plans/edit",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"plans",
						"edit"
					]
				},
				"description": "Edita un Plan"
			},
			"response": []
		},
		{
			"name": "plans/list",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://{{Hosting}}/api/plans/list?apiKey={{apiKey}}&s={{Signature}}",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"plans",
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
				"description": "Lista Planes"
			},
			"response": []
		},
		{
			"name": "plans/delete",
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
							"key": "planId",
							"value": "{{PlanId}}",
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
					"raw": "https://{{Hosting}}/api/plans/delete",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"plans",
						"delete"
					]
				},
				"description": "Elimina un Plan"
			},
			"response": []
		}
	],
	"event": [
		{
			"listen": "prerequest",
			"script": {
				"id": "68a63b31-cd1b-4c61-827c-dfc6be3a34ad",
				"type": "text/javascript",
				"exec": [
					"var toSign = getToSign();",
					"console.log(toSign);",
					"var hash = CryptoJS.HmacSHA256(t
