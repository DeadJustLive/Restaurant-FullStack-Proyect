# Flow Settlements.postman collection.json

## Fuente
Flow API — Documentación de Integración de Pagos (Cap. 8)

## Contenido
# Flow Settlements.postman collection.json

## Código

```typescript
{
	"info": {
		"_postman_id": "11c42636-4096-48fc-8be0-2887c2fdf2d9",
		"name": "Flow Settlements",
		"description": "Liquidaciones de Flow",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "settlement/getByDate",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://{{Hosting}}/api/settlement/getByDate?apiKey={{apiKey}}&date=2019-10-03&s={{Signature}}",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"settlement",
						"getByDate"
					],
					"query": [
						{
							"key": "apiKey",
							"value": "{{apiKey}}"
						},
						{
							"key": "date",
							"value": "2019-10-03"
						},
						{
							"key": "s",
							"value": "{{Signature}}"
						}
					]
				},
				"description": "Obtiene una liquidación por la fecha"
			},
			"response": []
		},
		{
			"name": "settlement/getById",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://{{Hosting}}/api/settlement/getById?apiKey={{apiKey}}&id=100&s={{Signature}}",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"settlement",
						"getById"
					],
					"query": [
						{
							"key": "apiKey",
							"value": "{{apiKey}}"
						},
						{
							"key": "id",
							"value": "100"
						},
						{
							"key": "s",
							"value": "{{Signature}}"
						}
					]
				},
				"description": "Obtiene una liquidación por su identificador"
			},
			"response": []
		}
	],
	"event": [
		{
			"listen": "prerequest",
			"script": {
				"id": "9d638718-8a49-4b07-8729-ce4ca31585cd",
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
				"id": "8a7083c8-d115-418c-8b9b-904f8aadf187",
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
