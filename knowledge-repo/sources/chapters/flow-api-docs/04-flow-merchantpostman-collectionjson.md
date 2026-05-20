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
					"status": "Bad Request",
					"code": 400,
					"_postman_previewlanguage": "json",
					"header": [
						{
							"key": "Content-Type",
							"value": "application/json"
						}
					],
					"cookie": [],
					"body": "{\n \"code\": 401,\n \"message\": \"Bad Request\"\n}"
				}
			]
		},
		{
			"name": "merchant/edit",
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
					"raw": "https://{{Hosting}}/api/merchant/edit",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"merchant",
						"edit"
					]
				},
				"description": "Este método permite modificar un comercio asociado previamente creado en **Flow**"
			},
			"response": [
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
							"raw": "{{baseUrl}}/merchant/edit",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"merchant",
								"edit"
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
							"raw": "{{baseUrl}}/merchant/edit",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"merchant",
								"edit"
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
							"raw": "{{baseUrl}}/merchant/edit",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"merchant",
								"edit"
							]
						}
					},
					"status": "Bad Request",
					"code": 400,
					"_postman_previewlanguage": "json",
					"header": [
						{
							"key": "Content-Type",
							"value": "application/json"
						}
					],
					"cookie": [],
					"body": "{\n \"code\": 401,\n \"message\": \"Bad Request\"\n}"
				}
			]
		},
		{
			"name": "merchant/delete",
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
							"key": "s",
							"value": "{{Signature}}",
							"description": "la firma de los parámetros efectuada con su secretKey"
						}
					]
				},
				"url": {
					"raw": "https://{{Hosting}}/api/merchant/delete",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"merchant",
						"delete"
					]
				},
				"description": "Este método permite eliminar un comercio asociado previamente creado en **Flow**"
			},
			"response": [
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
							"raw": "{{baseUrl}}/merchant/delete",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"merchant",
								"delete"
							]
						}
					},
					"status": "Bad Request",
					"code": 400,
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
							"raw": "{{baseUrl}}/merchant/delete",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"merchant",
								"delete"
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
							"raw": "{{baseUrl}}/merchant/delete",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"merchant",
								"delete"
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
					"body": "{\n \"status\": \"ok\",\n \"message\": \"Merchant X deleted\"\n}"
				}
			]
		},
		{
			"name": "merchant/get",
			"request": {
				"auth": {
					"type": "noauth"
				},
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://{{Hosting}}/api/merchant/get?apiKey={{apiKey}}&id=&s={{Signature}}",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"merchant",
						"get"
					],
					"query": [
						{
							"key": "apiKey",
							"value": "{{apiKey}}",
							"description": "(Required) apiKey del comercio"
						},
						{
							"key": "id",
							"value": "",
							"description": "Id de comercio asociado"
						},
						{
							"key": "s",
							"value": "{{Signature}}",
							"description": "(Required) la firma de los parámetros efectuada con su secretKey"
						}
					]
				},
				"description": "Este método permite obtener la información de un comercio asociado previamente creado en **Flow**"
			},
			"response": [
				{
					"name": "Objeto con información del comercio asocioado en Flow",
					"originalRequest": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "{{baseUrl}}/merchant/get?apiKey=<string>&id=<string>&s=<string>",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"merchant",
								"get"
							],
							"query": [
								{
									"key": "apiKey",
									"value": "<string>"
								},
								{
									"key": "id",
									"value": "<string>"
								},
								{
									"key": "s",
									"value": "<string>"
								}
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
					"body": "{\n \"id\": \"NEG-A\",\n \"name\": \"Negocio A\",\n \"url\": \"https://flow.cl\",\n \"createdate\": \"02-04-2020 11:52\",\n \"status\": \"0\",\n \"verifydate\": \"02-04-2020 11:52\"\n}"
				},
				{
					"name": "Error de negocio",
					"originalRequest": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "{{baseUrl}}/merchant/get?apiKey=<string>&id=<string>&s=<string>",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"merchant",
								"get"
							],
							"query": [
								{
									"key": "apiKey",
									"value": "<string>"
								},
								{
									"key": "id",
									"value": "<string>"
								},
								{
									"key": "s",
									"value": "<string>"
								}
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
						"method": "GET",
						"header": [],
						"url": {
							"raw": "{{baseUrl}}/merchant/get?apiKey=<string>&id=<string>&s=<string>",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"merchant",
								"get"
							],
							"query": [
								{
									"key": "apiKey",
									"value": "<string>"
								},
								{
									"key": "id",
									"value": "<string>"
								},
								{
									"key": "s",
									"value": "<string>"
								}
							]
						}
					},
					"status": "Bad Request",
					"code": 400,
					"_postman_previewlanguage": "json",
					"header": [
						{
							"key": "Content-Type",
							"value": "application/json"
						}
					],
					"cookie": [],
					"body": "{\n \"code\": 401,\n \"message\": \"Bad Request\"\n}"
				}
			]
		},
		{
			"name": "merchant/list",
			"request": {
				"auth": {
					"type": "noauth"
				},
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://{{Hosting}}/api/merchant/list?apiKey={{apiKey}}&start=&limit=&filter=&status=&s={{Signature}}",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"merchant",
						"list"
					],
					"query": [
						{
							"key": "apiKey",
							"value": "{{apiKey}}",
							"description": "(Required) apiKey del comercio"
						},
						{
							"key": "start",
							"value": "",
							"description": "Número de registro de inicio de la página. Si se omite el valor por omisión es 0."
						},
						{
							"key": "limit",
							"value": "",
							"description": "Número de registros por página. Si se omite el valor por omisón es 10. El valor máximo es de 100 registros por página."
						},
						{
							"key": "filter",
							"value": "",
							"description": "Filtro por nombre del comercio asociado"
						},
						{
							"key": "status",
							"value": "",
							"description": "Filtro por estado del comercio asociado. Valores posibles:\n\n0: Pendiente de aprobación\n\n1: Aprobado\n\n2: Rechazado"
						},
						{
							"key": "s",
							"value": "{{Signature}}",
							"description": "(Required) la firma de los parámetros efectuada con su secretKey"
						}
					]
				},
				"description": "Permite obtener la lista de comercios paginada de acuerdo a los parámetros de paginación. Además, se puede definir los siguientes filtros:\n\n * filter: filtro por nombre del comercio asociado\n * status: filtro por estado del comercio asociado"
			},
			"response": [
				{
					"name": "Objeto con información del comercio asocioado en Flow",
					"originalRequest": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "{{baseUrl}}/merchant/list?apiKey=<string>&start=<integer>&limit=<integer>&filter=<string>&status=<integer>&s=<string>",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"merchant",
								"list"
							],
							"query": [
								{
									"key": "apiKey",
									"value": "<string>"
								},
								{
									"key": "start",
									"value": "<integer>"
								},
								{
									"key": "limit",
									"value": "<integer>"
								},
								{
									"key": "filter",
									"value": "<string>"
								},
								{
									"key": "status",
									"value": "<integer>"
								},
								{
									"key": "s",
									"value": "<string>"
								}
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
					"body": "{\n \"total\": 200,\n \"hasMore\": 1,\n \"data\": \"[{item list 1}{item list 2}{item list n..}\"\n}"
				},
				{
					"name": "Error de negocio",
					"originalRequest": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "{{baseUrl}}/merchant/list?apiKey=<string>&start=<integer>&limit=<integer>&filter=<string>&status=<integer>&s=<string>",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"merchant",
								"list"
							],
							"query": [
								{
									"key": "apiKey",
									"value": "<string>"
								},
								{
									"key": "start",
									"value": "<integer>"
								},
								{
									"key": "limit",
									"value": "<integer>"
								},
								{
									"key": "filter",
									"value": "<string>"
								},
								{
									"key": "status",
									"value": "<integer>"
								},
								{
									"key": "s",
									"value": "<string>"
								}
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
						"method": "GET",
						"header": [],
						"url": {
							"raw": "{{baseUrl}}/merchant/list?apiKey=<string>&start=<integer>&limit=<integer>&filter=<string>&status=<integer>&s=<string>",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"merchant",
								"list"
							],
							"query": [
								{
									"key": "apiKey",
									"value": "<string>"
								},
								{
									"key": "start",
									"value": "<integer>"
								},
								{
									"key": "limit",
									"value": "<integer>"
								},
								{
									"key": "filter",
									"value": "<string>"
								},
								{
									"key": "status",
									"value": "<integer>"
								},
								{
									"key": "s",
									"value": "<string>"
								}
							]
						}
					},
					"status": "Bad Request",
					"code": 400,
					"_postman_previewlanguage": "json",
					"header": [
						{
							"key": "Content-Type",
							"value": "application/json"
						}
					],
					"cookie": [],
					"body": "{\n \"code\": 401,\n \"message\": \"Bad Request\"\n}"
				}
			]
		}
	],
	"event": [
		{
			"listen": "prerequest",
			"script": {
				"id": "0e9902ef-8995-47c4-bad8-0b27c8c5af75",
				"type": "text/javascript",
				"exec": [
					"pm.environment.set(\"CommerceOrder\", Math.round(Math.random() * 1000000));",
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
					"    for (var param of sortedKeys) {",
					"        console.log(param);",
					"        textToSign += param + params.get(param);",
					"    }",
					"    return textToSign;",
					"}",
					"",
					"function getUrlVars(url) {",
					"    var vars = {};",
					"    var parts = url.replace(/[?&]+([^=&]+)=([^&]*)/gi,    ",
					"    function(m,key,value) {",
					"      vars[key] = value;",
					"    });",
					"    return vars;",
					"  }",
					"",
					"function clearEnvironment(key) {",
					"    return key.replace('{{','').replace('}}','')",
					"}"
				]
			}
		},
		{
			"listen": "test",
			"script": {
				"id": "f02978a4-c4c2-4a3b-919e-34ded4afd0a9",
				"type": "text/javascript",
				"exec": [
					"//Check response code",
					"pm.test(\"Status code is 200\", function () {",
					"    pm.response.to.have.status(200);",
					"});"
				]
			}
		}
	],
	"protocolProfileBehavior": {}
}
```