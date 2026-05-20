# 2. Fases del diseño de una base de datos.......................................... 10

## Fuente
Jordi Casas Roma (Cap. 1)

## Contenido
# 2. Fases del diseño de una base de datos.......................................... 10

2.1. Fase 1. Recogida y análisis de requisitos ..................................... 10
2.1.1. Recogida de requisitos ................................................... 10
2.1.2. Estructuración y refinamiento de los requisitos ............ 11
2.1.3. Formalización de los requisitos ..................................... 11
2.2. Fase 2. Diseño conceptual .......................................................... 12
2.2.1. El modelo ER ................................................................. 12
2.2.2. El lenguaje unificado de modelización ......................... 13
2.3. Fase 3. Diseño lógico .................................................................. 13
2.3.1. Reconsideraciones del modelo conceptual .................... 14
2.3.2. Transformación del modelo conceptual en el
modelo lógico ................................................................ 14
2.3.3. Normalización ................................................................ 14
2.4. Fase 4. Diseño físico .................................................................... 15
2.4.1. El nivel físico y el nivel virtual ..................................... 15
2.4.2. Transformación del modelo lógico en el modelo
físico ............................................................................... 16
2.5. Fase 5. Implementación y optimización ..................................... 16
2.5.1. Procesamiento y optimización de consultas ................. 17
2.5.2. Procesamiento de vistas ................................................. 18
2.5.3. Administración de la seguridad ..................................... 19
Resumen....................................................................................................... 20
Glosario........................................................................................................ 21
Bibliografía................................................................................................. 22

-- 3 of 22 --



-- 4 of 22 --

CC-BY-NC-ND • PID_00213710 5 Introducción al diseño de bases de datos
Introducción
El diseño de bases de datos es un proceso complejo que permite obtener una
implementación de una base de datos a partir de los requisitos iniciales de los
usuarios del sistema de información. Este proceso guía al diseñador de bases
de datos por varias etapas con el objetivo de segmentar un problema de una
complejidad considerable en diferentes subproblemas de menor complejidad.
Cada uno de los subproblemas identificados corresponde a una de las etapas
del proceso de diseño de bases de datos. En estos materiales didácticos se des-
cribe el proceso global de diseño de bases de datos y las diferentes etapas que lo
forman. Este módulo es solo un texto introductorio al diseño de bases de datos
y será necesario profundizar en el estudio de cada una de sus etapas mediante
los distintos módulos de la asignatura que corresponden a las diferentes etapas
del proceso. Así pues, en este módulo se presenta una visión general de todo
el proceso de diseño de bases de datos.

-- 5 of 22 --

CC-BY-NC-ND • PID_00213710 6 Introducción al diseño de bases de datos
Objetivos
En estos materiales encontraréis las herramientas indispensables para lograr
los objetivos siguientes:
