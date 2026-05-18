# Flow Merchant.postman collection.json

## Fuente
Flow API — Documentación de Integración de Pagos (Cap. 4)

## Contenido
# Flow Merchant.postman collection.json

## Código

```typescript
{
	"info": {
		"_postman_id": "d1f8285b-172f-49aa-8ed3-1e9f3f20dbde",
		"name": "Flow Merchant",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "merchant/create",
			"request": {
				"auth": {
					"type": "noauth"
				},
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/x-www-form-urlencoded"
					}
				],
				"body": {
					"mode": "urlencoded",
					"urlencoded": [
						{
							"key": "apiKey",
							"value": "{{apiKey}}",
							"description": "apiKey del comercio"
						},
						{
							"key": "id",
							"value": "",
							"description": "Id de comercio asociado"
						},
						{
							"key": "name",
							"value": "",
							"description": "Nombre de comercio asociado"
						},
						{
							"key": "url",
							"value": "",
							"description": "Url del comercio asociado",
							"type": "text"
						},
						{
							"key": "s",
							"value": "{{Signature}}",
							"description": "la firma de los parámetros efectuada con su secretKey"
						}
					]
				},
				"url": {
					"raw": "https://{{Hosting}}/api/merchant/create",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"merchant",
						"create"
					]
				},
				"description": "Este método permite crear un nuevo comercio asociado en **Flow**"
			},
			"response": [
				{
					"name": "Objeto con información de la orden generada en Flow",
					"originalRequest": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "urlencoded",
							"urlencoded": [
								{
									"key": "apiKey",
									"value": "<string>",
									"description": {
										"content": "apiKey del comercio",
										"type": "text/plain"
									}
								},
								{
									"key": "id",
									"value": "<string>",
									"description": {
										"content": "Id de comercio asociado",
										"type": "text/plain"
									}
								},
								{
									"key": "name",
									"value": "<string>",
									"description": {
										"content": "Nombre de comercio asociado",
										"type": "text/plain"
									}
								},
								{
									"key": "s",
									"value": "<string>",
									"description": {
										"content": "la firma de los parámetros efectuada con su secretKey",
										"type": "text/plain"
									}
								}
							]
						},
						"url": {
							"raw": "{{baseUrl}}/merchant/create",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"merchant",
								"create"
							]
						}
					},
					"status": "OK",
					"code": 200,
					"_postman_previewlanguage": "json",
					"header": [
						{
							"key": "Content-Type",
							"value": "application/json"
						}
					],
					"cookie": [],
					"body": "{\n \"id\": \"NEG-A\",\n \"name\": \"Negocio A\"\n}"
				},
				{
					"name": "Error de negocio",
					"originalRequest": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "urlencoded",
							"urlencoded": [
								{
									"key": "apiKey",
									"value": "<string>",
									"description": {
										"content": "apiKey del comercio",
										"type": "text/plain"
									}
								},
								{
									"key": "id",
									"value": "<string>",
									"description": {
										"content": "Id de comercio asociado",
										"type": "text/plain"
									}
								},
								{
									"key": "name",
									"value": "<string>",
									"description": {
										"content": "Nombre de comercio asociado",
										"type": "text/plain"
									}
								},
								{
									"key": "s",
									"value": "<string>",
									"description": {
										"content": "la firma de los parámetros efectuada con su secretKey",
										"type": "text/plain"
									}
								}
							]
						},
						"url": {
							"raw": "{{baseUrl}}/merchant/create",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"merchant",
								"create"
							]
						}
					},
					"status": "Unauthorized",
					"code": 401,
					"_postman_previewlanguage": "json",
					"header": [
						{
							"key": "Content-Type",
							"value": "application/json"
						}
					],
					"cookie": [],
					"body": "{\n \"code\": 401,\n \"message\": \"Bad Request\"\n}"
				},
				{
					"name": "Error del Api",
					"originalRequest": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "urlencoded",
							"urlencoded": [
								{
									"key": "apiKey",
									"value": "<string>",
									"description": {
										"content": "apiKey del comercio",
										"type": "text/plain"
									}
								},
								{
									"key": "id",
									"value": "<string>",
									"description": {
										"content": "Id de comercio asociado",
										"type": "text/plain"
									}
								},

