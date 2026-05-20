# Flow Refund.postman collection.json

## Fuente
Flow API — Documentación de Integración de Pagos (Cap. 7)

## Contenido
## Código

```typescript
{
	"info": {
		"_postman_id": "adddd929-4939-4f02-9ddf-64ff7dad540d",
		"name": "Flow Refund",
		"description": "Reembolsos de Flow",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "refund/create",
			"event": [
				{
					"listen": "test",
					"script": {
						"id": "ce8e3f52-a8fe-4cff-955f-cdb46377b12a",
						"exec": [
							"var jsonData = pm.response.json();\r",
							"pm.environment.set(\"RefundToken\", jsonData.token);"
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
							"key": "refundCommerceOrder",
							"value": "{{RefundCommerceOrder}}",
							"type": "text"
						},
						{
							"key": "receiverEmail",
							"value": "csepulveda@tuxpan.com",
							"type": "text"
						},
						{
							"key": "amount",
							"value": "1000",
							"type": "text"
						},
						{
							"key": "urlCallBack",
							"value": "http://flowosccomerce.tuxpan.com/csepulveda/api2/refund/confirmRefund.php",
							"type": "text"
						},
						{
							"key": "commerceTrxId",
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
					"raw": "https://{{Hosting}}/api/refund/create",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"refund",
						"create"
					]
				},
				"description": "Refund create"
			},
			"response": []
		},
		{
			"name": "refund/getStatus",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://{{Hosting}}/api/refund/getStatus?apiKey={{apiKey}}&token={{RefundToken}}&s={{Signature}}",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"refund",
						"getStatus"
					],
					"query": [
						{
							"key": "apiKey",
							"value": "{{apiKey}}"
						},
						{
							"key": "token",
							"value": "{{RefundToken}}"
						},
						{
							"key": "s",
							"value": "{{Signature}}"
						}
					]
				},
				"description": "Obtiene el estado de un reembolso"
			},
			"response": []
		}
	],
	"event": [
		{
			"listen": "prerequest",
			"script": {
				"id": "4f1a4d8b-a638-4225-bb29-7029f3b38d4f",
				"type": "text/javascript",
				"exec": [
					"pm.environment.set(\"RefundCommerceOrder\", Math.round(Math.random() * 1000000));",
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
				"id": "b46e0263-3d8b-4436-a221-e0764ce49286",
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
