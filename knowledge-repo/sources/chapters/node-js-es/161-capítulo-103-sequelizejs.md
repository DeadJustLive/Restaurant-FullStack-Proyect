# Capítulo 103:: Sequelize.js

Examples
Instalación
Asegúrese de tener primero Node.js y npm instalados. Luego instale sequelize.js con npm
npm install --save sequelize
También deberá instalar los módulos de base de datos Node.js compatibles. Solo necesitas
instalar el que estás utilizando.
Para MYSQL y Mariadb
npm install --save mysql
Para PostgreSQL
npm install --save pg pg-hstore
Para SQLite
npm install --save sqlite
Para MSSQL
npm install --save tedious
Una vez que haya configurado la instalación, puede incluir y crear una nueva instancia de
Sequalize como tal.
Sintaxis ES5
var Sequelize = require('sequelize');
var sequelize = new Sequelize('database', 'username', 'password');
ES6 etapa-0 sintaxis de Babel
import Sequelize from 'sequelize';
const sequelize = new Sequelize('database', 'username', 'password');
Ahora tienes una instancia de secuela disponible. Podría, si así lo desea, llamarlo por un nombre
diferente, como
https://riptutorial.com/es/home 353

-- 381 of 423 --

var db = new Sequelize('database', 'username', 'password');
o
var database = new Sequelize('database', 'username', 'password');
Esa parte es tu prerrogativa. Una vez que haya instalado esto, puede usarlo dentro de su
aplicación según la documentación de la API http://docs.sequelizejs.com/en/v3/api/sequelize/
Su siguiente paso después de la instalación sería configurar su propio modelo
Definiendo modelos
Hay dos maneras de definir modelos en secuela; con sequelize.define(...) , o
sequelize.import(...) . Ambas funciones devuelven un objeto de modelo secuencial.
1. sequelize.define (nombre del modelo,
atributos, [opciones])
Este es el camino a seguir si desea definir todos sus modelos en un archivo, o si desea tener un
control adicional de la definición de su modelo.
/* Initialize Sequelize */
const config = {
username: "database username",
password: "database password",
database: "database name",
host: "database's host URL",
dialect: "mysql" // Other options are postgres, sqlite, mariadb and mssql.
}
var Sequelize = require("sequelize");
var sequelize = new Sequelize(config);
/* Define Models */
sequelize.define("MyModel", {
name: Sequelize.STRING,
comment: Sequelize.TEXT,
date: {
type: Sequelize.DATE,
allowNull: false
}
});
Para obtener la documentación y más ejemplos, consulte la documentación de doclets o la
documentación de sequelize.com .
2. sequelize.import (ruta)
https://riptutorial.com/es/home 354

-- 382 of 423 --

Si las definiciones de su modelo se dividen en un archivo para cada una, entonces import es su
amigo. En el archivo en el que inicializa Sequelize, debe llamar a importar así:
/* Initialize Sequelize */
// Check previous code snippet for initialization
/* Define Models */
sequelize.import("./models/my_model.js"); // The path could be relative or absolute
Luego, en los archivos de definición de su modelo, su código tendrá un aspecto similar al
siguiente:
module.exports = function(sequelize, DataTypes) {
return sequelize.define("MyModel", {
name: DataTypes.STRING,
comment: DataTypes.TEXT,
date: {
type: DataTypes.DATE,
allowNull: false
}
});
};
Para obtener más información sobre cómo usar la import , consulte el ejemplo express de
sequelize en GitHub .
Lea Sequelize.js en línea: https://riptutorial.com/es/node-js/topic/7705/sequelize-js
https://riptutorial.com/es/home 355

-- 383 of 423 --