# REST

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 36)

## Contenido
# REST

Examples
API REST para CRUD en Express 3+
var express = require("express"),
bodyParser = require("body-parser"),
server = express();
//body parser for parsing request body
server.use(bodyParser.json());
server.use(bodyParser.urlencoded({ extended: true }));
//temperary store for `item` in memory
var itemStore = [];
//GET all items
server.get('/item', function (req, res) {
res.json(itemStore);
});
//GET the item with specified id
server.get('/item/:id', function (req, res) {
res.json(itemStore[req.params.id]);
});
//POST new item
server.post('/item', function (req, res) {
itemStore.push(req.body);
res.json(req.body);
});
//PUT edited item in-place of item with specified id
server.put('/item/:id', function (req, res) {
itemStore[req.params.id] = req.body
res.json(req.body);
});
//DELETE item with specified id
server.delete('/item/:id', function (req, res) {
itemStore.splice(req.params.id, 1)
res.json(req.body);
});
