# EPEERINVALID

## Fuente
react-aprendiz-maestro (Cap. 150)

## Contenido
# EPEERINVALID

Es probable que veas un mensaje como este:
npm WARN package.json kanban-app@0.0.0 No repository field.
npm WARN package.json kanban-app@0.0.0 No README data
npm WARN peerDependencies The peer dependency eslint@0.21 - 0.23 inc\
luded from eslint-loader will no
npm WARN peerDependencies longer be automatically installed to fulfi\
ll the peerDependency
npm WARN peerDependencies in npm 3+. Your application will need to d\
epend on it explicitly.
...
npm ERR! Darwin 14.3.0
npm ERR! argv "node" "/usr/local/bin/npm" "i"
npm ERR! node v0.10.38
npm ERR! npm v2.11.0
npm ERR! code EPEERINVALID
npm ERR! peerinvalid The package eslint does not satisfy its sibling\
s' peerDependencies requirements!
npm ERR! peerinvalid Peer eslint-plugin-react@2.5.2 wants eslint@>=0\
.8.0
npm ERR! peerinvalid Peer eslint-loader@0.14.0 wants eslint@0.21 - 0\

-- 223 of 226 --

Resolución de Problemas 206
.23
npm ERR! Please include the following file with any support request:
...
En lenguaje de los humanos significa que algún paquete, eslint-loader en este caso,
tiene un requisito peerDependency demasiado estricto. Nuestro paquete ya tiene
instalada una versión más reciente. Dado que la dependencia requerida de forma
transitiva es más antigua que la nuestra, nos aparece este error en particular.
Hay un par de formas de solucionar esta situación:
