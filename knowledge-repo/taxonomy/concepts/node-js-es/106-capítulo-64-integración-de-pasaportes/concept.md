# Capítulo 64:: Integración de pasaportes

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 106)

## Contenido
# Capítulo 64:: Integración de pasaportes

Observaciones
La contraseña siempre debe estar oculta. Una forma sencilla de proteger contraseñas con
NodeJS sería usar el módulo bcrypt-nodejs .
Examples
Empezando
El pasaporte se debe inicializar con el middleware passport.initialize() . Para utilizar las
sesiones de inicio de sesión, se requiere el middleware passport.session() .
Tenga en cuenta que los métodos passport.serialize() y passport.deserializeUser() deben estar
definidos. Passport serializará y deserializará las instancias de usuario hacia y desde la sesión
const express = require('express');
const session = require('express-session');
const passport = require('passport');
const cookieParser = require('cookie-parser');
const app = express();
// Required to read cookies
app.use(cookieParser());
passport.serializeUser(function(user, next) {
// Serialize the user in the session
next(null, user);
});
passport.deserializeUser(function(user, next) {
// Use the previously serialized user
next(null, user);
});
// Configuring express-session middleware
app.use(session({
secret: 'The cake is a lie',
resave: true,
saveUninitialized: true
}));
// Initializing passport
app.use(passport.initialize());
app.use(passport.session());
// Starting express server on port 3000
app.listen(3000);
Autenticación local
https://riptutorial.com/es/home 221

-- 249 of 423 --

El módulo local de pasaporte se utiliza para implementar una autenticación local.
Este módulo le permite autenticar con un nombre de usuario y contraseña en sus
aplicaciones Node.js.
Registro del usuario:
const passport = require('passport');
const LocalStrategy = require('passport-local').Strategy;
// A named strategy is used since two local strategy are used :
// one for the registration and the other to sign-in
passport.use('localSignup', new LocalStrategy({
// Overriding defaults expected parameters,
// which are 'username' and 'password'
usernameField: 'email',
passwordField: 'password',
passReqToCallback: true // allows us to pass back the entire request to the callback .
},
function(req, email, password, next) {
// Check in database if user is already registered
findUserByEmail(email, function(user) {
// If email already exists, abort registration process and
// pass 'false' to the callback
if (user) return next(null, false);
// Else, we create the user
else {
// Password must be hashed !
let newUser = createUser(email, password);
newUser.save(function() {
// Pass the user to the callback
return next(null, newUser);
});
}
});
});
Iniciar sesión en el usuario:
const passport = require('passport');
const LocalStrategy = require('passport-local').Strategy;
passport.use('localSignin', new LocalStrategy({
usernameField : 'email',
passwordField : 'password',
},
function(email, password, next) {
// Find the user
findUserByEmail(email, function(user) {
// If user is not found, abort signing in process
// Custom messages can be provided in the verify callback
// to give the user more details concerning the failed authentication
if (!user)
return next(null, false, {message: 'This e-mail address is not associated with any
account.'});
// Else, we check if password is valid
else {
https://riptutorial.com/es/home 222

-- 250 of 423 --

// If password is not correct, abort signing in process
if (!isPasswordValid(password)) return next(null, false);
// Else, pass the user to callback
else return next(null, user);
}
});
});
Creando rutas:
// ...
app.use(passport.initialize());
app.use(passport.session());
// Sign-in route
// Passport strategies are middlewares
app.post('/login', passport.authenticate('localSignin', {
successRedirect: '/me',
failureRedirect: '/login'
});
// Sign-up route
app.post('/register', passport.authenticate('localSignup', {
successRedirect: '/',
failureRedirect: '/signup'
});
// Call req.logout() to log out
app.get('/logout', function(req, res) {
req.logout();
res.redirect('/');
});
app.listen(3000);
Autenticación de Facebook
El módulo pasaporte-facebook se utiliza para implementar una autenticación de Facebook . En
este ejemplo, si el usuario no existe en el inicio de sesión, se crea.
Implementando la estrategia:
const passport = require('passport');
const FacebookStrategy = require('passport-facebook').Strategy;
// Strategy is named 'facebook' by default
passport.use({
clientID: 'yourclientid',
clientSecret: 'yourclientsecret',
callbackURL: '/auth/facebook/callback'
},
// Facebook will send a token and user's profile
function(token, refreshToken, profile, next) {
// Check in database if user is already registered
findUserByFacebookId(profile.id, function(user) {
// If user exists, returns his data to callback
if (user) return next(null, user);
https://riptutorial.com/es/home 223

-- 251 of 423 --

// Else, we create the user
else {
let newUser = createUserFromFacebook(profile, token);
newUser.save(function() {
// Pass the user to the callback
return next(null, newUser);
});
}
});
});
Creando rutas:
// ...
app.use(passport.initialize());
app.us
