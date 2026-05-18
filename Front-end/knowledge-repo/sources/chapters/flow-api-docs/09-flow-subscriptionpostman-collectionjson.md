# Flow Subscription.postman collection.json

## Código

```typescript
{
	"info": {
		"_postman_id": "78976c70-a7fb-4319-b832-be498cd3e878",
		"name": "Flow Subscription",
		"description": "Suscripciones de Flow",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "subscription/create",
			"event": [
				{
					"listen": "test",
					"script": {
						"id": "96db3d88-246a-4eb2-bef6-a40fe72ade5b",
						"exec": [
							"var jsonData = pm.response.json();\r",
							"pm.environment.set(\"SubscriptionId\", jsonData.subscriptionId);"
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
							"value": "{{PlanId}}",
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
					"raw": "https://{{Hosting}}/api/subscription/create",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"subscription",
						"create"
					]
				},
				"description": "Crea una nueva suscripción"
			},
			"response": []
		},
		{
			"name": "subscription/get",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://{{Hosting}}/api/subscription/get?apiKey={{apiKey}}&subscriptionId={{SubscriptionId}}&s={{Signature}}",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"subscription",
						"get"
					],
					"query": [
						{
							"key": "apiKey",
							"value": "{{apiKey}}"
						},
						{
							"key": "subscriptionId",
							"value": "{{SubscriptionId}}"
						},
						{
							"key": "s",
							"value": "{{Signature}}"
						}
					]
				},
				"description": "Obtiene una Suscripción en base al subscriptionId"
			},
			"response": []
		},
		{
			"name": "subscription/list",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://{{Hosting}}/api/subscription/list?apiKey={{apiKey}}&planId={{PlanId}}&s={{Signature}}",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"subscription",
						"list"
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
				"description": "Obtiene la lista de suscritos a un Plan"
			},
			"response": []
		},
		{
			"name": "subscription/changeTrial",
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
							"key": "subscriptionId",
							"value": "{{SubscriptionId}}",
							"type": "text"
						},
						{
							"key": "trial_period_days",
							"value": "3",
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
					"raw": "https://{{Hosting}}/api/subscription/changeTrial",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"subscription",
						"changeTrial"
					]
				},
				"description": "Modifica los días de Trial de una Suscripción"
			},
			"response": []
		},
		{
			"name": "subscription/addCoupon",
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
							"key": "subscriptionId",
							"value": "{{SubscriptionId}}",
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
					"raw": "https://{{Hosting}}/api/subscription/addCoupon",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"subscription",
						"addCoupon"
					]
				},
				"description": "Agrega un Cupón de descuento a una suscripción"
			},
			"response": []
		},
		{
			"name": "subscription/deleteCoupon",
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
							"key": "subscriptionId",
							"value": "{{SubscriptionId}}",
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
					"raw": "https://{{Hosting}}/api/subscription/deleteCoupon",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"subscription",
						"deleteCoupon"
					]
				},
				"description": "Elimina un descuento a una suscripción"
			},
			"response": []
		},
		{
			"name": "subscription/cancel",
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
							"key": "subscriptionId",
							"value": "{{SubscriptionId}}",
							"type": "text"
						},
						{
							"key": "at_period_end",
							"value": "0",
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
					"raw": "https://{{Hosting}}/api/subscription/cancel",
					"protocol": "https",
					"host": [
						"{{Hosting}}"
					],
					"path": [
						"api",
						"subscription",
						"cancel"
					]
				},
				"description": "Cancela uns Suscripcion"
			},
			"response": []
		}
	],
	"event": [
		{
			"listen": "prerequest",
			"script": {
				"id": "590b4426-db9a-46f6-9ddc-fdb8a8bfe9fb",
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
				"id": "934966c1-3fa9-401b-b97a-27803c7147a9",
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