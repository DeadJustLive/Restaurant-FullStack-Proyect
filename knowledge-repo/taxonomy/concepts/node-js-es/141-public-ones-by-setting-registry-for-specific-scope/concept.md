# public ones by setting registry for specific scope

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 141)

## Contenido
# public ones by setting registry for specific scope

npm config set @mycompany:registry http://myreg.mycompany.com
npm install @mycompany/<package name>
Generalmente, los módulos se instalarán localmente en una carpeta llamada node_modules , que se
puede encontrar en su directorio de trabajo actual. Este es el directorio que require() utilizará
para cargar módulos para que estén disponibles para usted.
Si ya creó un archivo package.json , puede usar la --save (shorthand -S ) o una de sus variantes
para agregar automáticamente el paquete instalado a su package.json como una dependencia. Si
alguien más instala su paquete, npm leerá automáticamente las dependencias del archivo
package.json e instalará las versiones enumeradas. Tenga en cuenta que aún puede agregar y
administrar sus dependencias editando el archivo más adelante, por lo que generalmente es una
buena idea hacer un seguimiento de las dependencias, por ejemplo, usando:
npm install --save <name> # Install dependencies
