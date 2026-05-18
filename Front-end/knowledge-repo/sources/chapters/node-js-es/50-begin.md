# BEGIN

*/
var commands = {
https://riptutorial.com/es/home 86

-- 114 of 423 --

eval: function(arg) { // Try typing in console: eval 2 * 10 ^ 3 + 2 ^ 4
arg = arg.join(' ');
try { console.log(eval(arg)); }
catch (e) { console.log(e); }
},
exit: function(arg) {
process.exit();
}
};
rl.on('line', (str) => {
rl.pause();
var arg = str.trim().match(/([^"]+)|("(?:[^"\\]|\\.)+")/g); // Applying regular expression
for removing all spaces except for what between double quotes:
http://stackoverflow.com/a/14540319/2396907
if (arg) {
for (let n in arg) {
arg[n] = arg[n].replace(/^\"|\"$/g, '');
}
var commandName = arg[0];
var command = commands[commandName];
if (command) {
arg.shift();
command(arg);
}
else console.log('Command "'+ commandName +'" doesn\'t exist');
}
rl.prompt();
});
/*