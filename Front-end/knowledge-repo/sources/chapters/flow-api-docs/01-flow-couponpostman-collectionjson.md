# Flow Coupon.postman collection.json

## Código

```typescript
{
	"info": {
		"_postman_id": "83f0195a-21a0-413f-8c2b-6adbe54b2232",
		"name": "Flow Coupon",
		"description": "Permite administrar cupones de descuento",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "coupon/create",
			"event": [
				{
					"listen": "test",
					"script": {
						"id": "b9d982aa-54be-44ca-97ed-8407fe2e8c27",
						"exec": [
							"var jsonData = pm.response.json();\r",
							"console.log(jsonData);\r",
							"pm.environment.set(\"CouponId\", jsonData.id);"
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
							"value": "Descuento 20%",
							"type": "text"
						},
						{
							"key": "percent_off",
							"value": "20",
							"type": "text"
						},
						{
							"key": "duration",
							"value": "1",
							"type": "text"
						},
						{
							"key": "times",
							"value": "1",
							"type": "text"
						},
						{
							"key": "max_redemptions",
							"value": "20",
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
					"raw": "https://{{Hosting}}/api/coupon/create",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"coupon",
						"create"
					]
				},
				"description": "Crea un Cupón de descuento"
			},
			"response": []
		},
		{
			"name": "coupon/get",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://{{Hosting}}/api/coupon/get?apiKey={{apiKey}}&couponId={{CouponId}}&s={{Signature}}",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"coupon",
						"get"
					],
					"query": [
						{
							"key": "apiKey",
							"value": "{{apiKey}}"
						},
						{
							"key": "couponId",
							"value": "{{CouponId}}"
						},
						{
							"key": "s",
							"value": "{{Signature}}"
						}
					]
				},
				"description": "Obtiene un cupón"
			},
			"response": []
		},
		{
			"name": "coupon/list",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://{{Hosting}}/api/coupon/list?apiKey={{apiKey}}&s={{Signature}}",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"coupon",
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
				"description": "Lista los cupones de descuento"
			},
			"response": []
		},
		{
			"name": "coupon/edit",
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
							"key": "couponId",
							"value": "{{CouponId}}",
							"type": "text"
						},
						{
							"key": "name",
							"value": "Descuento 20 porciento",
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
					"raw": "https://{{Hosting}}/api/coupon/edit",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"coupon",
						"edit"
					]
				},
				"description": "Edita el nombre de un cupón de descuento"
			},
			"response": []
		},
		{
			"name": "coupon/delete",
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
							"key": "couponId",
							"value": "{{CouponId}}",
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
					"raw": "https://{{Hosting}}/api/coupon/delete",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"coupon",
						"delete"
					]
				},
				"description": "Elimina un cupón de descuento"
			},
			"response": []
		}
	],
	"event": [
		{
			"listen": "prerequest",
			"script": {
				"id": "4f20fa73-b344-4569-bd29-2f8ad5b54697",
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
				"id": "6739f944-739c-4d6b-8460-9530110e6cab",
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