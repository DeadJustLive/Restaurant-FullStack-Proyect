# OBSERVACIONES:

* auxiliar para randomEntre0YConSemilla(maximo, semilla)
* Mark Jones lo atribuye a "Random Number Generators: Good
Ones are Hard to Find" de S.K.Park y K.W.Miller, publicado
en la revista "Communications of the ACM", 31(10):1192-1201,
en octubre de 1988.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 306 of 312 --

307
* este art´ıculo en realidad lo toma de una propuesta de 1969
por Lewis, Goodman and Miller y lo propone como est´andar
m´ınimo de generaci´on de n´umeros seudoaleatorios
* el comentario sobre su funcionamiento fue agregado por m´ı,
en base a alguna lectura que encontr´e alguna vez que lo
explicaba, y de la que no recuerdo la cita:
x_{i+1} = a*x_i mod m
donde
a = 7^5 = 16807
m = 2^31 - 1 = 2147483647
q = m div a = 127773
r = m mod a = 2836
y entonces
x_{i+1} = a*(x_i mod q) - r*(x_i div q) + delta*m
siendo
delta = 1 si (a*(x_i mod q) - r*(x_i div q) > 0)
delta = 0 si no
*/
{
hi := semilla div 12773 -- semilla div (2^31 mod 7^5)
lo := semilla mod 12773 -- semilla mod (2^31 mod 7^5)
preresultado := 16807 * lo - 2836 * hi
-- 7^5 * lo - (2^31 mod 7^5) * hi
if (preresultado > 0) { delta := 0 }
else { delta := 1 }
return (preresultado + delta * 2147483647)
-- delta * 2^31
}
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 307 of 312 --

308
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 308 of 312 --

309
Bibliograf´ıa
[Dijkstra and others, 1989] E.W. Dijkstra et al. On the cruelty of really teaching computing
science. Communications of the ACM, 32(12):1398–1404, 1989.
[Hutton, 1999] G. Hutton. A tutorial on the universality and expressiveness of fold. Journal
of Functional Programming, 9(4):355–372, 1999.
[Jones, 1996] Mark P. Jones. Overloading and higher order polymorphism. In Erik Meijer
and John Jeuring, editors, Advanced Functional Programming, volume 925 of Lectures
Notes in Computer Science, pages 97–136. Springer-Verlag, May 1996.
[Kernighan and Pike, 1999] Brian W. Kernighan and Rob Pike. The Practice of Program-
ming. Professional Computing Series. Addison-Wesley, 1999. ISBN 0-201-61586-X.
[Mannila, 2010] L. Mannila. Invariant based programming in education–an analysis of
student difficulties. Informatics in Education, 9(1):115–132, 2010.
[Mart´ınez L ´opez and Sawady O’Connor, 2013] Pablo E. Mart´ınez L ´opez and Federico A.
Sawady O’Connor. Introducci ´on a la programaci ´on para la carrera de Licenciatura en
Artes y Tecnolog´ıas. Universidad Nacional de Quilmes, marzo 2013. ISBN 978-987-
1856-39-8.
[Mart´ınez L ´opez et al., 2012] Pablo E. Mart´ınez L ´opez, Eduardo A. Bonelli, and Federi-
co A. Sawady O’Connor. El nombre verdadero de la programaci ´on. una concepci ´on
de la ense ˜nanza de la programaci ´on para la sociedad de la informaci ´on. In Anales del
10mo Simposio de la Sociedad de la Informaci ´on (SSI’12), dentro de las 41ras Jornadas
Argentinas de Inform ´atica (JAIIO ’12), pages 1–23, setiembre 2012. ISSN 1850-2830.
[Meijer et al., 1991] E. Meijer, M. Fokkinga, and R. Paterson. Functional programming with
bananas, lenses, envelopes and barbed wire. In Functional Programming Languages
and Computer Architecture, pages 124–144. Springer, 1991.
[Park and Miller, 1988] S. K. Park and K. W. Miller. Random number generators: Good
ones are hard to find. Communications of the ACM, 31(10):1192–1201, October 1988.
[Scholl and Peyrin, 1988] P.C. Scholl and J.P. Peyrin. Sch ´emas algorithmiques fondamen-
taux: s ´equences et it ´eration. Universit ´e Joseph Fourier Institut Grenoblois d’ ´etudes in-
formatiques, 1988.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 309 of 312 --

310
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 310 of 312 --



-- 311 of 312 --



-- 312 of 312 --