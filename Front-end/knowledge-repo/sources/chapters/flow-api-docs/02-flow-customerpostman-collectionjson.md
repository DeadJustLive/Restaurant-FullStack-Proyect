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
						"id": "1b7b895f-42d0-496e-a90b-d998c9c79ee8",
						"exec": [
							"var jsonData = pm.response.json();\r",
							"\r",
							"//Registra Register token\r",
							"pm.environment.set(\"RegisterToken\", jsonData.token);\r",
							""
						],
						"type": "text/javascript"
					}
				},
				{
					"listen": "prerequest",
					"script": {
						"id": "7908d0ed-90da-4207-ade2-dfa466b86f11",
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
							"key": "url_return",
							"value": "http://flowosccomerce.tuxpan.com/csepulveda/api2/customer/confirmRegister.php",
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
					"raw": "https://{{Hosting}}/api/customer/register",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"customer",
						"register"
					]
				},
				"description": "Enrolar tarjeta de crédito del cliente para cargos automáticos"
			},
			"response": []
		},
		{
			"name": "customer/getRegisterStatus",
			"event": [
				{
					"listen": "prerequest",
					"script": {
						"id": "a097ade9-40cb-4e93-9930-a860b884804d",
						"exec": [
							""
						],
						"type": "text/javascript"
					}
				},
				{
					"listen": "test",
					"script": {
						"id": "05f5248d-b0d7-4b99-9f95-218cd29184bd",
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
					"raw": "https://{{Hosting}}/api/customer/getRegisterStatus?apiKey={{apiKey}}&token={{RegisterToken}}&s={{Signature}}",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"customer",
						"getRegisterStatus"
					],
					"query": [
						{
							"key": "apiKey",
							"value": "{{apiKey}}"
						},
						{
							"key": "token",
							"value": "{{RegisterToken}}"
						},
						{
							"key": "s",
							"value": "{{Signature}}"
						}
					]
				},
				"description": "Obtiene el estado de enrolamiento de la tarjeta de crédito"
			},
			"response": []
		},
		{
			"name": "customer/unRegister",
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
							"key": "s",
							"value": "{{Signature}}",
							"type": "text"
						}
					]
				},
				"url": {
					"raw": "https://{{Hosting}}/api/customer/unRegister",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"customer",
						"unRegister"
					]
				}
			},
			"response": []
		},
		{
			"name": "customer/collect",
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
							"key": "commerceOrder",
							"value": "{{CommerceOrder}}",
							"type": "text"
						},
						{
							"key": "subject",
							"value": "Test collect",
							"type": "text"
						},
						{
							"key": "currency",
							"value": "CLP",
							"type": "text"
						},
						{
							"key": "amount",
							"value": "2500",
							"type": "text"
						},
						{
							"key": "urlConfirmation",
							"value": "http://flowosccomerce.tuxpan.com/csepulveda/api2/pay/confirmPay.php",
							"type": "text"
						},
						{
							"key": "urlReturn",
							"value": "http://flowosccomerce.tuxpan.com/csepulveda/api2/pay/resultPay.php",
							"type": "text"
						},
						{
							"key": "ignore_auto_charging",
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
					"raw": "https://{{Hosting}}/api/customer/collect",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"customer",
						"collect"
					]
				},
				"description": "Permite generar un cobro al cliente"
			},
			"response": []
		},
		{
			"name": "customer/charge",
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
							"key": "subject",
							"value": "Test cargo automatico",
							"type": "text"
						},
						{
							"key": "currency",
							"value": "CLP",
							"type": "text"
						},
						{
							"key": "amount",
							"value": "3000",
							"type": "text"
						},
						{
							"key": "commerceOrder",
							"value": "{{CommerceOrder}}",
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
					"raw": "https://{{Hosting}}/api/customer/charge",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"customer",
						"charge"
					]
				},
				"description": "Cargo automatico a un cliente"
			},
			"response": []
		},
		{
			"name": "customer/getCharges",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://{{Hosting}}/api/customer/getCharges?apiKey={{apiKey}}&customerId={{CustomerId}}&s={{Signature}}",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"customer",
						"getCharges"
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
				"description": "Lista de cargos efectuados a un cliente"
			},
			"response": []
		},
		{
			"name": "customer/batchCollect",
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
							"key": "urlCallBack",
							"value": "http://flowosccomerce.tuxpan.com/csepulveda/api2/pay/resultPay.php",
							"type": "text"
						},
						{
							"key": "urlConfirmation",
							"value": "http://flowosccomerce.tuxpan.com/csepulveda/api2/pay/confirmPay.php",
							"type": "text"
						},
						{
							"key": "urlReturn",
							"value": "http://flowosccomerce.tuxpan.com/csepulveda/api2/pay/resultPay.php",
							"type": "text"
						},
						{
							"key": "batchRows",
							"value": "[{\"customerId\":\"cus_0greuxgial\",\n    \"commerceOrder\":\"ABC2300\",\n    \"subject\":\"Cobro batchCollect\",\n    \"amount\": 1000 }]",
							"type": "text"
						},
						{
							"key": "timeout",
							"value": "120",
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
					"raw": "https://{{Hosting}}/api/customer/batchCollect",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"customer",
						"batchCollect"
					]
				},
				"description": "Envia un lote de cobros a distintos customers"
			},
			"response": []
		},
		{
			"name": "customer/getBatchCollectStatus",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": ""
				},
				"description": "Obtiene el resultado del envio de un lote de collects"
			},
			"response": []
		}
	],
	"event": [
		{
			"listen": "prerequest",
			"script": {
				"id": "554c0eb7-481d-4f2c-b697-6f0b9897b17b",
				"type": "text/javascript",
				"exec": [
					"pm.environment.set(\"CommerceOrder\", Math.round(Math.random() * 1000000));",
					"pm.environment.set(\"External_Id\",  Math.round(Math.random() * 1000000));",
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
					"            value = pm.environment.get(clearEnvironment(value)); ",
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
				"id": "12ad9fe4-47d0-4213-a640-616007668672",
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