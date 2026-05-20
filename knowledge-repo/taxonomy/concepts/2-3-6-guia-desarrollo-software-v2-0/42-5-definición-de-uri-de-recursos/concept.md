# 5. Definición de URI de recursos

## Fuente
2.3.6 Guia Desarrollo Software v2.0 (Cap. 42)

## Contenido
# 5. Definición de URI de recursos

La definición de URI de recursos debe
propender a seguir las prácticas
expresadas a continuación como
ejemplo:
● Usar sustantivos para describir los
recursos:
➢ GET /usuarios/ lista todos los usuarios
➢ GET /usuarios/12 muestra detalle del
usuario con id 12
➢ POST /usuarios crear usuario
➢ PUT /usuarios/12 actualiza usuario con
id 12
➢ PATCH /usuarios/12 actualiza
parcialmente usuario con id 12
➢ DELETE /usuarios/12 borra usuario con
id 12
● Usar “/” para indicar la relación de
jerarquía:
➢ GET/ usuarios/12/mensajes muestra
mensajes del usuario con id 12
➢ GET/usuarios/12/mensajes/93 obtiene
mensaje con id 93 del usuario con id 12
➢ POST /usuarios/12/mensajes crear
mensaje para usuario con id 12
➢ DELETE /usuarios/12/mensajes/3
elimina mensaje 3 de usuario con id 12
● Usar parámetros de consulta (query
strings) para realizar operaciones de
filtro, ordenamiento, paginación y/o
búsqueda:
División de Gobierno Digital | Lineamientos para desarrollo de software 	22

-- 22 of 33 --

➢ GET /instituciones/
buscar?nombre=ministerio* busca
organizaciones cuyo nombre comienza
con “ministerio”
➢ GET /instituciones/2/
usuarios?estado=inactivo lista todos los
usuarios de la institución 2 con estado
inactivo
● Formato de las URIs:
➢ No usar “/” al final de la URI.
➢ No usar mayúsculas.
/instituciones/2/usuarios
/Instituciones/2/Usuarios/
● Usar guión “-” (y no guión bajo “_”),
más conocido como kebab-case,
para facilitar la comprensión de la
URI en los casos en que sea más de
una palabra para el servicio.
/oficinas/134/como-llegar
/oficinas/134/como_llegar
● Usar sólo letras en minúscula dentro
de la URI. No utilizar caracteres
especiales ni acentos.
● Versionamiento de los servicios. Se
sugiere contar con un número de
versión en la URI, el cual deberá ser
incrementado en la medida en que
el servicio se vea modificado en su
naturaleza o los datos que entrega.
URI Versión 1 antigua:
GET /v1/oficinas/134/como-llegar
URI Version 2 actual:
GET /v2/oficinas/134/como-llegar
● No usar extensiones de archivos.
/instituciones/2/descripcion
/instituciones/2/descripcion.txt
/instituciones/2/descripcion.json
Para la descripción de servicios se
recomienda utilizar el estándar OpenAPI
Specification (OAS) v3.0+, siendo este
punto un requisito fundamental en la
documentación entregable de un
proyecto.
