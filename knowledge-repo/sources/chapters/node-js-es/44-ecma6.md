# ECMA6:

User.findOne({
name: 'stack'
}, (err, user) => {
if (err) throw err;
if (!user) {
console.log('No user was found');
} else {
console.log('User was found');
}
https://riptutorial.com/es/home 63

-- 91 of 423 --

});
ECMA5.1:
User.findOne({
name: 'stack'
}, function (err, user) {
if (err) throw err;
if (!user) {
console.log('No user was found');
} else {
console.log('User was found');
}
});
Lea Base de datos (MongoDB con Mangosta) en línea: https://riptutorial.com/es/node-
js/topic/6411/base-de-datos--mongodb-con-mangosta-
https://riptutorial.com/es/home 64

-- 92 of 423 --