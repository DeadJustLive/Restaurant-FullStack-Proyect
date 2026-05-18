# Ch17 02 concurrency with async.html

# El Lenguaje de Programación Rust

## Aplicando Concurrencia con Async

### Crear una nueva tarea conspawn_task

### Paso de Mensajes

En esta sección, aplicaremos async a algunos de los mismos desafíos
de concurrencia que abordamos con threads en el capítulo 16. Hemos explorado muchas de
las ideas claves en esa sección, aquí se profundizara en las diferencias
entre threads and futures.

En muchos casos, las APIs para trabajar con concurrencia usando async son muy
similares a las que se usan con threads. En otros casos, terminan teniendo formas
bastante diferentes. Incluso cuando las APIs parecen similares entre threads y async,
a menudo presentan comportamientos distintos y casi siempre tienen diferentes
características de rendimiento.

La primera tarea que abordamos enCrear un nuevo hilo con Spawnfue contar en dos threads separados. Hagamos lo mismo usando async. El
cratetrplproporciona una funciónspawn_task, que se comporta de forma muy 
similar a la API dethread::spawn, y una funciónsleep,
que es una versión async dethread::sleep. Podemos usarlas juntas para implementar
el mismo ejemplo de conteo que con threads, como se muestra en el Listado 17-6.

Como punto de partida, configuramos nuestra funciónmaincontrpl::run, de
de modo que nuestra función de nivel superior pueda ser async.

Nota: A partir de este punto en el capítulo, cada ejemplo incluirá
este mismo código de envoltura contrpl::runenmain, así que a menudo lo omitiremos,
igual que hacemos conmain. ¡No olvides incluirlo en tu código!

Luego, dentro de ese bloque, escribimos dos bucles, cada uno con una llamada atrpl::sleep,
que espera medio segundo (500 milisegundos) antes de enviar el siguiente
mensaje. Uno de los bucles va dentro detrpl::spawn_task, mientras que el otro se ejecuta
en un bucleforde nivel superior. También añadimos unawaitdespués de cada llamada asleep.

El resultado es similar a la versión basada en threads, incluyendo el detalle
de que los mensajes podrían aparecer en un orden distinto cada vez
que lo ejecutes en tu terminal.

Esta versión se detiene tan pronto como el bucle for dentro del bloque async principal
termina, porque la tarea creada conspawn_taskse cierra cuando finaliza la función
main. Si quieres que el programa siga ejecutándose hasta que la tarea termine por completo,
necesitas usar un join handle para esperar a que la primera tarea finalice. Con
threads, utilizamos el métodojoinpara “bloquear”, la ejecución hasta que el hilo terminara.
En el Listado 17-7, podemos hacer lo mismo conawait, ya que el handle de la tarea
en sí es un future. Su tipo deOutputes unResult, por lo que también usamos unwrap
después de esperarlo con await.

Esta versión actualizada se ejecuta hasta queambosbucles terminan.

Hasta ahora, parece que async y threads nos dan los mismos resultados básicos, solo
que con una sintaxis diferente: usamosawaiten lugar de llamar ajoinen el join
handle, y también esperamos las llamadas asleep.

La mayor diferencia aquí es que no necesitamos crear otro hilo del sistema operativo
para lograrlo. De hecho, ni siquiera es necesario generar una tarea separada. Pues
los bloques async se compilan en futures anónimos, podemos colocar cada bucle dentro de un
bloque async y dejar que el runtime los ejecute hasta su finalización usando la
funcióntrpl::join.

En la secciónEsperando a que todos los hilos terminen usandojoinhandles, 
mostramos cómo usar el métodojoinen el tipoJoinHandleque se obtiene al llamarstd::thread::spawn. La funcióntrpl::joines
similar, pero para futures. Cuando le pasas dos futures, genera un nuevo
future cuyo resultado es una tupla con los valores de salida de los futures originales,
pero solo cuandoamboshan finalizado. Es decir, en Listado 17-8, usamostrpl::joinpara esperar a
que tantofut1comofut2finalicen. En lugar de hacer await sobrefut1yfut2por separado, esperamos
el nuevo futuro producido portrpl::join. Ignoramos su salida, debido a que
solo contiene una tupla con dos valores unitarios.

Cuando ejecutamos esto, vemos que ambos futuros se ejecutan hasta completarse:

Aquí verás exactamente el mismo orden en cada ejecución, lo cual es muy diferente
de lo que ocurría con threads. Esto se debe a que la funcióntrpl::joinesjusta,
lo que significa que revisa cada future con la misma frecuencia, alternando entre ellos y evitando
que uno avance más rápido que el otro si ambos están listos. Con threads, el sistema operativo
decide qué hilo revisar y cuánto tiempo permitirle ejecutarse. Con async Rust, es
el runtime el que decide que tarea revisar. (En la práctica, esto se vuelve más complejo
porque un runtime async puede usar threads del sistema operativo en segundo
plano para gestionar la concurrencia, lo que hace que garantizar la equidad requiera más trabajo
—¡pero sigue siendo posible!). Los runtimes no están obligados
a garantizar equidad en todas las operaciones, y muchas veces ofrecen diferentes APIs
para que elijas si quieres equidad o no.

Prueba algunas variaciones en la forma de esperar los futures y observa qué
sucede:

Para un desafío extra, intenta predecir la salida en
cada casoantesde ejecutar el código.

Compartir datos entre futures también te resultará familiar: volveremos a usar el paso de
mensajes, pero esta vez con versiones async de los tipos y funciones. Seguiremos un
enfoque ligeramente diferente al del hecho enUsando el Pasaje de Mensajes para Transferir Datos entre Hilospara destacar algunas diferencias clave entre la concurrencia basada en threads 
y la basada en futures. En el Listado 17-9, comenzaremos con un solo bloque 
async, sin generar una tarea separada como lo hicimos al crear un thread 
independiente.

Aquí usamostrpl::channel, una version de async de la API multiple-producer y
single-consumer que usamos con threads en el capítulo 16. La version async
de esta API es solo un poco diferente de la versión basada en threads: en lugar
de un receptor inmutable, usa un receptorrxmutable, y su métodorecvproduce
un future debemos esperar conawaiten lugar de devolver el valor directamente. Ahora
podemos enviar mensajes desde el sender al receiver. Fíjate en que no necesitamos crear un
thread separado ni siquiera una tarea; simplemente esperamos la
llamadarx.recv.

El método síncronoReceiver::recvenstd::mpsc::channelbloquea la ejecución hasta
recibir un mensaje.  En cambio, el métodotrpl::Receiver::recvno, porque
es async. En lugar de bloquear, devuelve el control al runtime hasta que se recibe
un mensaje o se cierra el lado del envío del canal. Por otro lado, no
esperamos en la llamada asend,  porque esta no bloquea. No es necesario,
ya que el canal al que estamos enviando los mensajes es ilimitado.

Nota: Todo este código async se ejecuta dentro de un bloque async dentro de una llamada atrpl::run,
lo que permite evitar bloqueos dentro de él. Sin embargo, el códigofuerade
este bloque sí se bloqueará hasta queruntermine. Esa es precisamente la función detrpl::run: te permiteelegiren qué parte del código async quieres bloquear la ejecución,
definiendo así la transición entre código síncrono y asíncrono. En la mayoría de
runtimes async, la funciónrunsuele llamarseblock_onpor esta misma razón.

Hay dos cosas a notar en este ejemplo: Primero, ¡El mensaje llegará de inmediato!
Segundo, aunque estamos usando un future, todavía no hay concurrencia.
Todo sucede en secuencia, igual que si no hubiera futures
involucrados.

Para abordar esto, enviaremos una serie de mensajes con pausas entre ellos, como se
muestra en el Listado 17-10:

Además de enviar los mensajes, también necesitamos recibirlos. En este caso, 
podríamos hacerlo manualmente llamando arx.recv().awaitcuatro veces, ya que 
sabemos cuántos mensajes llegarán. Sin embargo, en la práctica, normalmente 
estaremos esperando una cantidaddesconocidade mensajes, por lo que
necesitamos seguir esperando hasta asegurarnos de que no quedan más.

En el Listado 16-10, usamos un bucleforpara procesar todos los elementos 
recibidos de un canal síncrono. Sin embargo, en Rust  aún no tiene una forma de 
escribir un bucleforsobre una serie de elementosasíncronos. En su lugar, 
debemos usar un tipo de bucle que aún no hemos visto: el bucle condicionalwhile let. Estewhile letes la versión en bucle de la construcciónif letque vimos en la secciónFlujo de Control Conciso conif letylet else. El bucle 
continuará ejecutándose mientras el patrón que especifica coincida con el valor 
recibido.

La llamadarx.recvproduce unFuture, que debemos esperar conawait. El 
runtime pausará la ejecución delFuturehasta que esté listo. Cuando llegue un
mensaje, el future se resolverá enSome(message), tantas veces como lleguen 
mensajes. Cuando el canal se cierre, sin importar si llegaron mensajes o no, el 
future se resolverá en enNone, lo que indica que no hay más valores y debemos 
dejar de esperar (es decir, dejar de hacer await).

El buclewhile letcombina todo esto. Si el resultado derx.recv().awaitesSome(message), obtenemos acceso al mensaje y podemos usarlo dentro
del cuerpo del bucle, igual que conif let. Si el resultado esNone, el bucle termina. Cada vez que el bucle se completa, vuelve a alcanzar un punto de espera
(await), por lo que el runtime lo pausa nuevamente hasta que llegue otro mensaje.

Con esto, el código ahora envía y recibe todos los mensajes correctamente. Sin embargo,
todavía hay un par de problemas. Por un lado, los mensajes no llegan en intervalos
de medio segundo. En su lugar, todos llegan de golpe, dos segundos (2,000 milisegundos)
después de que el programa inicia. Además, el programa nunca finaliza: en lugar de cerrarse
cuando termina la recepción de mensajes, sigue esperando indefinidamente. Tendrás que cerrarlo manualmente conctrl-c.

Comencemos por entender por qué los mensajes llegan todos juntos después del retraso
total en lugar de llegar con pausas entre ellos. Dentro de un bloque async, el orden en el
que aparecen las palabras claveawaiten el código es el
mismo en el que ocurren cuando el programa se ejecuta.

En el Listado 17-10, solo hay un bloque async, por lo que todo se ejecuta de manera
lineal. Todavía no hay concurrencia. Primero se ejecutan todas las llamadas atx.send,
intercaladas con las llamadas atrpl::sleepy sus correspondientes awaits.
Solo después de eso, el buclewhile letpuede comenzar a procesar losawaiten las llamadas arecv.

Para obtener el comportamiento deseado, donde hay un retraso entre la recepción de cada
mensaje, necesitamos colocar las operaciones detxyrxen bloques async separados.
Así, el runtime puede ejecutarlas de forma independiente usandotrpl::join,
igual que en el ejemplo de conteo. Una vez más, esperamos el resultado detrpl::join,  no los futures individuales. Si esperáramos los futures uno
tras otro, volveríamos a un flujo secuencial —exactamente
lo que queremos evitar.

Con el código actualizado en el Listado 17-11, los mensajes ahora se imprimen a intervalos
de 500 milisegundos en lugar de llegar todos de golpe después de dos segundos.

Sin embargo, el programa aún no finaliza debido a la forma en que el buclewhile letinteractúa contrpl::join:

Podríamos cerrar manualmenterxllamando arx.closeen algún punto, pero eso no tendría
mucho sentido. Detenernos después de manejar un número arbitrario de mensajes
haría que el programa se cerrara, pero podríamos perder mensajes. Necesitamos otra forma de
asegurarnos de quetxse elimine (drop)antesdel final de la función.

En este momento, el bloque async donde enviamos los mensajes solo toma prestadotxporque enviar un mensaje no requiere propiedad, pero si pudiéramos movertxdentro de ese bloque async, se eliminaría cuando el bloque terminara. En el 
capítulo 13 secciónCapturando referencias o moviendo el ownership,
aprendimos a usar la palabra clavemovecon closures, y en el capítulo 16 
secciónUsandomoveClosures con Threads, vimos
que a menudo necesitamos mover datos dentro de closures cuando trabajamos con 
hilos. La misma lógica se aplica a los bloques async, por lo quemovefunciona con ellos de la misma manera que con las closures.

En el Listado 17-12, cambiamos el bloque async que envía los mensajes de un 
simple bloqueasynca un bloqueasync move. Cuando ejecutamosestaversión 
del código, el programa se cierra correctamente después de que se envían y 
reciben todos los mensajes.

Este canal asíncrono también admite multiple-producer, por lo que podemos llamar 
acloneentxsi queremos enviar mensajes desde varios futures. En el 
Listado 17-13, clonamostx, creandotx1fuera del primer bloque async. Luego 
movemostx1dentro de ese bloque, tal como hicimos antes contx. Más 
adelante, movemos eltxoriginal a unnuevobloque async, donde enviamos más 
mensajes con un pequeño retraso adicional. Colocamos este nuevo bloque async 
después del bloque de recepción de mensajes, pero podría ir antes sin problema. 
Lo importante no es el orden en que los futures se crean, sino el orden en que 
los esperamos (await).

Ambos bloques async para enviar mensajes deben serasync move,
de modo que tantotxytx1se eliminen (drop) cuando esos bloques terminen. 
De lo contrario,
volveríamos al mismo bucle infinito del principio. Finalmente, cambiamos detrpl::joinatrpl::join3para manejar el future adicional.

Ahora vemos todos los mensajes de ambos futures de envío. Como cada uno
usa un retraso ligeramente diferente después de enviar, los mensajes
también se reciben en esos intervalos distintos.

Este es un buen comienzo, pero nos limita a solo unos pocos futures: dos conjoino tres conjoin3. Veamos cómo podemos manejar una cantidad mayor de futures.

## Código

```
spawn_task
```

```
spawn_task
```

```
thread::spawn
```

```
thread::sleep
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {
    trpl::run(async{
        trpl::spawn_task(async{foriin1..10{println!("hi number {i} from the first task!");
                trpl::sleep(Duration::from_millis(500)).await;
            }
        });foriin1..5{println!("hi number {i} from the second task!");
            trpl::sleep(Duration::from_millis(500)).await;
        }
    });
}
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {
    trpl::run(async{
        trpl::spawn_task(async{foriin1..10{println!("hi number {i} from the first task!");
                trpl::sleep(Duration::from_millis(500)).await;
            }
        });foriin1..5{println!("hi number {i} from the second task!");
            trpl::sleep(Duration::from_millis(500)).await;
        }
    });
}
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {
    trpl::run(async{
        trpl::spawn_task(async{foriin1..10{println!("hi number {i} from the first task!");
                trpl::sleep(Duration::from_millis(500)).await;
            }
        });foriin1..5{println!("hi number {i} from the second task!");
            trpl::sleep(Duration::from_millis(500)).await;
        }
    });
}
```

```
trpl::run
```

```
trpl::run
```

```
trpl::sleep
```

```
trpl::spawn_task
```

```
hi number 1 from the second task!
hi number 1 from the first task!
hi number 2 from the first task!
hi number 2 from the second task!
hi number 3 from the first task!
hi number 3 from the second task!
hi number 4 from the first task!
hi number 4 from the second task!
hi number 5 from the first task!
```

```
hi number 1 from the second task!
hi number 1 from the first task!
hi number 2 from the first task!
hi number 2 from the second task!
hi number 3 from the first task!
hi number 3 from the second task!
hi number 4 from the first task!
hi number 4 from the second task!
hi number 5 from the first task!
```

```
spawn_task
```

```
Output
```

```
Result
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {trpl::run(async{lethandle = trpl::spawn_task(async{foriin1..10{println!("hi number {i} from the first task!");
                trpl::sleep(Duration::from_millis(500)).await;
            }
        });foriin1..5{println!("hi number {i} from the second task!");
            trpl::sleep(Duration::from_millis(500)).await;
        }

        handle.await.unwrap();});}
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {trpl::run(async{lethandle = trpl::spawn_task(async{foriin1..10{println!("hi number {i} from the first task!");
                trpl::sleep(Duration::from_millis(500)).await;
            }
        });foriin1..5{println!("hi number {i} from the second task!");
            trpl::sleep(Duration::from_millis(500)).await;
        }

        handle.await.unwrap();});}
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {trpl::run(async{lethandle = trpl::spawn_task(async{foriin1..10{println!("hi number {i} from the first task!");
                trpl::sleep(Duration::from_millis(500)).await;
            }
        });foriin1..5{println!("hi number {i} from the second task!");
            trpl::sleep(Duration::from_millis(500)).await;
        }

        handle.await.unwrap();});}
```

```
hi number 1 from the second task!
hi number 1 from the first task!
hi number 2 from the first task!
hi number 2 from the second task!
hi number 3 from the first task!
hi number 3 from the second task!
hi number 4 from the first task!
hi number 4 from the second task!
hi number 5 from the first task!
hi number 6 from the first task!
hi number 7 from the first task!
hi number 8 from the first task!
hi number 9 from the first task!
```

```
hi number 1 from the second task!
hi number 1 from the first task!
hi number 2 from the first task!
hi number 2 from the second task!
hi number 3 from the first task!
hi number 3 from the second task!
hi number 4 from the first task!
hi number 4 from the second task!
hi number 5 from the first task!
hi number 6 from the first task!
hi number 7 from the first task!
hi number 8 from the first task!
hi number 9 from the first task!
```

```
trpl::join
```

```
JoinHandle
```

```
std::thread::spawn
```

```
trpl::join
```

```
trpl::join
```

```
trpl::join
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {trpl::run(async{letfut1 =async{foriin1..10{println!("hi number {i} from the first task!");
                trpl::sleep(Duration::from_millis(500)).await;
            }
        };letfut2 =async{foriin1..5{println!("hi number {i} from the second task!");
                trpl::sleep(Duration::from_millis(500)).await;
            }
        };

        trpl::join(fut1, fut2).await;});}
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {trpl::run(async{letfut1 =async{foriin1..10{println!("hi number {i} from the first task!");
                trpl::sleep(Duration::from_millis(500)).await;
            }
        };letfut2 =async{foriin1..5{println!("hi number {i} from the second task!");
                trpl::sleep(Duration::from_millis(500)).await;
            }
        };

        trpl::join(fut1, fut2).await;});}
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {trpl::run(async{letfut1 =async{foriin1..10{println!("hi number {i} from the first task!");
                trpl::sleep(Duration::from_millis(500)).await;
            }
        };letfut2 =async{foriin1..5{println!("hi number {i} from the second task!");
                trpl::sleep(Duration::from_millis(500)).await;
            }
        };

        trpl::join(fut1, fut2).await;});}
```

```
hi number 1 from the first task!
hi number 1 from the second task!
hi number 2 from the first task!
hi number 2 from the second task!
hi number 3 from the first task!
hi number 3 from the second task!
hi number 4 from the first task!
hi number 4 from the second task!
hi number 5 from the first task!
hi number 6 from the first task!
hi number 7 from the first task!
hi number 8 from the first task!
hi number 9 from the first task!
```

```
hi number 1 from the first task!
hi number 1 from the second task!
hi number 2 from the first task!
hi number 2 from the second task!
hi number 3 from the first task!
hi number 3 from the second task!
hi number 4 from the first task!
hi number 4 from the second task!
hi number 5 from the first task!
hi number 6 from the first task!
hi number 7 from the first task!
hi number 8 from the first task!
hi number 9 from the first task!
```

```
trpl::join
```

```
externcratetrpl;// required for mdbook testfnmain() {trpl::run(async{let(tx,mutrx) = trpl::channel();letval =String::from("hi");
        tx.send(val).unwrap();letreceived = rx.recv().await.unwrap();println!("Got: {received}");});}
```

```
externcratetrpl;// required for mdbook testfnmain() {trpl::run(async{let(tx,mutrx) = trpl::channel();letval =String::from("hi");
        tx.send(val).unwrap();letreceived = rx.recv().await.unwrap();println!("Got: {received}");});}
```

```
externcratetrpl;// required for mdbook testfnmain() {trpl::run(async{let(tx,mutrx) = trpl::channel();letval =String::from("hi");
        tx.send(val).unwrap();letreceived = rx.recv().await.unwrap();println!("Got: {received}");});}
```

```
trpl::channel
```

```
rx.recv
```

```
Receiver::recv
```

```
std::mpsc::channel
```

```
trpl::Receiver::recv
```

```
trpl::run
```

```
trpl::run
```

```
block_on
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {trpl::run(async{let(tx,mutrx) = trpl::channel();letvals =vec![String::from("hi"),String::from("from"),String::from("the"),String::from("future"),
        ];forvalinvals {
            tx.send(val).unwrap();
            trpl::sleep(Duration::from_millis(500)).await;
        }whileletSome(value) = rx.recv().await{println!("received '{value}'");
        }});}
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {trpl::run(async{let(tx,mutrx) = trpl::channel();letvals =vec![String::from("hi"),String::from("from"),String::from("the"),String::from("future"),
        ];forvalinvals {
            tx.send(val).unwrap();
            trpl::sleep(Duration::from_millis(500)).await;
        }whileletSome(value) = rx.recv().await{println!("received '{value}'");
        }});}
```

```
rx.recv().await
```

```
while let
```

```
while let
```

```
if let
```

```
if let
```

```typescript
let else
```

```
rx.recv
```

```
Future
```

```
Future
```

```
Some(message)
```

```
while let
```

```
rx.recv().await
```

```
Some(message)
```

```
if let
```

```
tx.send
```

```
trpl::sleep
```

```
while let
```

```
trpl::join
```

```
trpl::join
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {trpl::run(async{let(tx,mutrx) = trpl::channel();lettx_fut =async{letvals =vec![String::from("hi"),String::from("from"),String::from("the"),String::from("future"),
            ];forvalinvals {
                tx.send(val).unwrap();
                trpl::sleep(Duration::from_millis(500)).await;
            }
        };letrx_fut =async{whileletSome(value) = rx.recv().await{println!("received '{value}'");
            }
        };

        trpl::join(tx_fut, rx_fut).await;});}
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {trpl::run(async{let(tx,mutrx) = trpl::channel();lettx_fut =async{letvals =vec![String::from("hi"),String::from("from"),String::from("the"),String::from("future"),
            ];forvalinvals {
                tx.send(val).unwrap();
                trpl::sleep(Duration::from_millis(500)).await;
            }
        };letrx_fut =async{whileletSome(value) = rx.recv().await{println!("received '{value}'");
            }
        };

        trpl::join(tx_fut, rx_fut).await;});}
```

```
while let
```

```
trpl::join
```

```
trpl::join
```

```
while let
```

```
while let
```

```
rx.recv
```

```
rx.recv().await
```

```
rx.close
```

```
rx.close
```

```
trpl::run
```

```
trpl::join
```

```
rx.close
```

```
async move
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {trpl::run(async{let(tx,mutrx) = trpl::channel();lettx_fut =asyncmove{letvals =vec![String::from("hi"),String::from("from"),String::from("the"),String::from("future"),
            ];forvalinvals {
                tx.send(val).unwrap();
                trpl::sleep(Duration::from_millis(500)).await;
            }
        };letrx_fut =async{whileletSome(value) = rx.recv().await{println!("received '{value}'");
            }
        };

        trpl::join(tx_fut, rx_fut).await;});}
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {trpl::run(async{let(tx,mutrx) = trpl::channel();lettx_fut =asyncmove{letvals =vec![String::from("hi"),String::from("from"),String::from("the"),String::from("future"),
            ];forvalinvals {
                tx.send(val).unwrap();
                trpl::sleep(Duration::from_millis(500)).await;
            }
        };letrx_fut =async{whileletSome(value) = rx.recv().await{println!("received '{value}'");
            }
        };

        trpl::join(tx_fut, rx_fut).await;});}
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {trpl::run(async{let(tx,mutrx) = trpl::channel();lettx_fut =asyncmove{letvals =vec![String::from("hi"),String::from("from"),String::from("the"),String::from("future"),
            ];forvalinvals {
                tx.send(val).unwrap();
                trpl::sleep(Duration::from_millis(500)).await;
            }
        };letrx_fut =async{whileletSome(value) = rx.recv().await{println!("received '{value}'");
            }
        };

        trpl::join(tx_fut, rx_fut).await;});}
```

```
async move
```

```
trpl::join
```

```
trpl::join3
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {trpl::run(async{let(tx,mutrx) = trpl::channel();lettx1 = tx.clone();lettx1_fut =asyncmove{letvals =vec![String::from("hi"),String::from("from"),String::from("the"),String::from("future"),
            ];forvalinvals {
                tx1.send(val).unwrap();
                trpl::sleep(Duration::from_millis(500)).await;
            }
        };letrx_fut =async{whileletSome(value) = rx.recv().await{println!("received '{value}'");
            }
        };lettx_fut =asyncmove{letvals =vec![String::from("more"),String::from("messages"),String::from("for"),String::from("you"),
            ];forvalinvals {
                tx.send(val).unwrap();
                trpl::sleep(Duration::from_millis(1500)).await;
            }
        };

        trpl::join3(tx1_fut, tx_fut, rx_fut).await;});}
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {trpl::run(async{let(tx,mutrx) = trpl::channel();lettx1 = tx.clone();lettx1_fut =asyncmove{letvals =vec![String::from("hi"),String::from("from"),String::from("the"),String::from("future"),
            ];forvalinvals {
                tx1.send(val).unwrap();
                trpl::sleep(Duration::from_millis(500)).await;
            }
        };letrx_fut =async{whileletSome(value) = rx.recv().await{println!("received '{value}'");
            }
        };lettx_fut =asyncmove{letvals =vec![String::from("more"),String::from("messages"),String::from("for"),String::from("you"),
            ];forvalinvals {
                tx.send(val).unwrap();
                trpl::sleep(Duration::from_millis(1500)).await;
            }
        };

        trpl::join3(tx1_fut, tx_fut, rx_fut).await;});}
```

```
externcratetrpl;// required for mdbook testusestd::time::Duration;fnmain() {trpl::run(async{let(tx,mutrx) = trpl::channel();lettx1 = tx.clone();lettx1_fut =asyncmove{letvals =vec![String::from("hi"),String::from("from"),String::from("the"),String::from("future"),
            ];forvalinvals {
                tx1.send(val).unwrap();
                trpl::sleep(Duration::from_millis(500)).await;
            }
        };letrx_fut =async{whileletSome(value) = rx.recv().await{println!("received '{value}'");
            }
        };lettx_fut =asyncmove{letvals =vec![String::from("more"),String::from("messages"),String::from("for"),String::from("you"),
            ];forvalinvals {
                tx.send(val).unwrap();
                trpl::sleep(Duration::from_millis(1500)).await;
            }
        };

        trpl::join3(tx1_fut, tx_fut, rx_fut).await;});}
```

```
received 'hi'
received 'more'
received 'from'
received 'the'
received 'messages'
received 'future'
received 'for'
received 'you'
```

```
received 'hi'
received 'more'
received 'from'
received 'the'
received 'messages'
received 'future'
received 'for'
received 'you'
```

- El Lenguaje de Programación Rust
- Prefacio
- Introducción
- 1.Empezando
- 1.1.Instalación1.2.¡Hola, Mundo!1.3.¡Hola, Cargo!
- 1.1.Instalación
- 1.2.¡Hola, Mundo!
- 1.3.¡Hola, Cargo!
- 2.Programando un juego de adivinanzas
- 3.Conceptos Comunes de Programación
- 3.1.Variables y Mutabilidad3.2.Tipos de Datos3.3.Funciones3.4.Comentarios3.5.Flujo de Control
- 3.1.Variables y Mutabilidad
- 3.2.Tipos de Datos
- 3.3.Funciones
- 3.4.Comentarios
- 3.5.Flujo de Control
- 4.Entendiendo el Ownership
- 4.1.¿Qué es el Ownership?4.2.Referencias y Prestamos4.3.El Tipo Slice
- 4.1.¿Qué es el Ownership?
- 4.2.Referencias y Prestamos
- 4.3.El Tipo Slice
- 5.Usando Structs para Estructurar Datos Relacionados
- 5.1.Definiendo e Instanciando Structs5.2.Un Programa de Ejemplo Usando Structs5.3.Sintaxis de Métodos
- 5.1.Definiendo e Instanciando Structs
- 5.2.Un Programa de Ejemplo Usando Structs
- 5.3.Sintaxis de Métodos
- 6.Enums y Pattern Matching
- 6.1.Definiendo un Enum6.2.El operador de control de flujo match6.3.Flujo de Control Conciso con if let y let else
- 6.1.Definiendo un Enum
- 6.2.El operador de control de flujo match
- 6.3.Flujo de Control Conciso con if let y let else
- 7.Administrando Proyectos en Crecimiento con Paquetes, Crates y Módulos
- 7.1.Paquetes y Crates7.2.Definiendo módulos para controlar el scope y la privacidad7.3.Paths para referirse a un item en el árbol de módulos7.4.Incluyendo rutas al Scope con la palabra clave use7.5.Separando Módulos en Diferentes Archivos
- 7.1.Paquetes y Crates
- 7.2.Definiendo módulos para controlar el scope y la privacidad
- 7.3.Paths para referirse a un item en el árbol de módulos
- 7.4.Incluyendo rutas al Scope con la palabra clave use
- 7.5.Separando Módulos en Diferentes Archivos
- 8.Colecciones comunes
- 8.1.Almacenando listas de valores con vectores8.2.Almacenando texto codificado en UTF-8 con Strings8.3.Almacenar Claves con Valores Asociados en HashMaps
- 8.1.Almacenando listas de valores con vectores
- 8.2.Almacenando texto codificado en UTF-8 con Strings
- 8.3.Almacenar Claves con Valores Asociados en HashMaps
- 9.Manejo de Errores
- 9.1.Errores irrecuperables con panic!9.2.Errores recuperables con Result9.3.panic! o no panic!
- 9.1.Errores irrecuperables con panic!
- 9.2.Errores recuperables con Result
- 9.3.panic! o no panic!
- 10.Tipos Genéricos, Traits y Lifetimes
- 10.1.Tipos de Datos Genéricos10.2.Traits: Definiendo Comportamiento Compartido10.3.Validando Referencias con Lifetimes
- 10.1.Tipos de Datos Genéricos
- 10.2.Traits: Definiendo Comportamiento Compartido
- 10.3.Validando Referencias con Lifetimes
- 11.Escribiendo Tests Automatizados
- 11.1.Cómo Escribir Tests11.2.Controlando Cómo Los Tests Son Ejecutados11.3.Organización De Los Tests
- 11.1.Cómo Escribir Tests
- 11.2.Controlando Cómo Los Tests Son Ejecutados
- 11.3.Organización De Los Tests
- 12.Un proyecto de I/O: Construyendo un programa de línea de comandos
- 12.1.Aceptando argumentos de línea de comandos12.2.Leyendo un archivo12.3.Refactorizando para mejorar la modularidad y el manejo de errores12.4.Desarrollando la funcionalidad de la biblioteca con T.D.D.12.5.Trabajando con Variables de Entorno12.6.Escribiendo mensajes de error estándar en lugar del output estándar
- 12.1.Aceptando argumentos de línea de comandos
- 12.2.Leyendo un archivo
- 12.3.Refactorizando para mejorar la modularidad y el manejo de errores
- 12.4.Desarrollando la funcionalidad de la biblioteca con T.D.D.
- 12.5.Trabajando con Variables de Entorno
- 12.6.Escribiendo mensajes de error estándar en lugar del output estándar
- 13.Características De Lenguajes Funcionales: Iteradores y Closures
- 13.1.Closures: Funciones anónimas que capturan su entorno13.2.Procesando una serie de elementos con Iteradores13.3.Mejorando nuestro proyecto I/O13.4.Comparando Performance: Bucles vs. Iteradores
- 13.1.Closures: Funciones anónimas que capturan su entorno
- 13.2.Procesando una serie de elementos con Iteradores
- 13.3.Mejorando nuestro proyecto I/O
- 13.4.Comparando Performance: Bucles vs. Iteradores
- 14.Más sobre Cargo y Crates.io
- 14.1.Personalizando Compilaciones con Perfiles de Lanzamiento14.2.Publicando un Crate a Crates.io14.3.Cargo Workspaces14.4.Instalando Binarios con cargo install14.5.Extendiendo Cargo con Comandos Personalizados
- 14.1.Personalizando Compilaciones con Perfiles de Lanzamiento
- 14.2.Publicando un Crate a Crates.io
- 14.3.Cargo Workspaces
- 14.4.Instalando Binarios con cargo install
- 14.5.Extendiendo Cargo con Comandos Personalizados
- 15.Smart Pointers
- 15.1.Usando Box<T> para Apuntar a Datos en el Heap15.2.Tratando los Smart Pointers como Referencias Regulares con el Trait Deref15.3.Ejecutando Código al Limpiar con el Trait Drop15.4.Rc<T>, el Smart Pointer de Conteo de Referencias15.5.RefCell<T> y el Patrón de Mutabilidad Interior15.6.Referencias Circulares Pueden Fugar Memoria
- 15.1.Usando Box<T> para Apuntar a Datos en el Heap
- 15.2.Tratando los Smart Pointers como Referencias Regulares con el Trait Deref
- 15.3.Ejecutando Código al Limpiar con el Trait Drop
- 15.4.Rc<T>, el Smart Pointer de Conteo de Referencias
- 15.5.RefCell<T> y el Patrón de Mutabilidad Interior
- 15.6.Referencias Circulares Pueden Fugar Memoria
- 16.Concurrencia sin miedo
- 16.1.Usando Threads para Ejecutar Código Simultáneamente16.2.Usando el Pasaje de Mensajes para Transferir Datos entre Hilos16.3.Concurrencia con Estado Compartido16.4.Concurrencia extensible con los traits Sync y Send
- 16.1.Usando Threads para Ejecutar Código Simultáneamente
- 16.2.Usando el Pasaje de Mensajes para Transferir Datos entre Hilos
- 16.3.Concurrencia con Estado Compartido
- 16.4.Concurrencia extensible con los traits Sync y Send
- 17.Fundamentos de la Programación Asíncrona: Async, Await, Futures y Streams
- 17.1.Futures y la sintaxis Async17.2.Aplicando Concurrencia Con Async17.3.Trabajar con cualquier número de futuros17.4.Streams17.5.Profundizando en los Traits para Async17.6.Futuros, tareas e hilos
- 17.1.Futures y la sintaxis Async
- 17.2.Aplicando Concurrencia Con Async
- 17.3.Trabajar con cualquier número de futuros
- 17.4.Streams
- 17.5.Profundizando en los Traits para Async
- 17.6.Futuros, tareas e hilos
- 18.Rust como un Lenguaje de Programación Orientado a Objetos
- 18.1.Características de Lenguajes Orientados a Objetos18.2.Usando Trait Objects que Permiten Valores de Diferentes Tipos18.3.Implementando un Patrón de Diseño Orientado a Objetos
- 18.1.Características de Lenguajes Orientados a Objetos
- 18.2.Usando Trait Objects que Permiten Valores de Diferentes Tipos
- 18.3.Implementando un Patrón de Diseño Orientado a Objetos
- 19.Patterns and Matching
- 19.1.Todos los lugares donde se pueden usar Patterns19.2.Refutabilidad: Si un Pattern Puede Fallar al Hacer Match19.3.Sintaxis de los Patterns
- 19.1.Todos los lugares donde se pueden usar Patterns
- 19.2.Refutabilidad: Si un Pattern Puede Fallar al Hacer Match
- 19.3.Sintaxis de los Patterns
- 20.Características Avanzadas
- 20.1.Rust Inseguro20.2.Traits Avanzados20.3.Tipos Avanzados20.4.Funciones y Closures Avanzados20.5.Macros
- 20.1.Rust Inseguro
- 20.2.Traits Avanzados
- 20.3.Tipos Avanzados
- 20.4.Funciones y Closures Avanzados
- 20.5.Macros
- 21.Proyecto Final: Construyendo un Servidor Web Multithread
- 21.1.Construyendo un Servidor Web de un Solo Hilo21.2.Convirtiendo Nuestro Servidor de un solo Hilo en un Servidor Multihilo21.3.Apagado y limpieza eficientes
- 21.1.Construyendo un Servidor Web de un Solo Hilo
- 21.2.Convirtiendo Nuestro Servidor de un solo Hilo en un Servidor Multihilo
- 21.3.Apagado y limpieza eficientes
- 22.Apéndice
- 22.1.A - Palabras claves22.2.B - Operadores y Símbolos22.3.C - Traits derivables22.4.D - Herramientas de desarrollo útiles22.5.E - Ediciones22.6.F - Traducciones del libro22.7.G - Cómo se hace Rust y “Rust Nightly”
- 22.1.A - Palabras claves
- 22.2.B - Operadores y Símbolos
- 22.3.C - Traits derivables
- 22.4.D - Herramientas de desarrollo útiles
- 22.5.E - Ediciones
- 22.6.F - Traducciones del libro
- 22.7.G - Cómo se hace Rust y “Rust Nightly”

- 1.1.Instalación
- 1.2.¡Hola, Mundo!
- 1.3.¡Hola, Cargo!

- 3.1.Variables y Mutabilidad
- 3.2.Tipos de Datos
- 3.3.Funciones
- 3.4.Comentarios
- 3.5.Flujo de Control

- 4.1.¿Qué es el Ownership?
- 4.2.Referencias y Prestamos
- 4.3.El Tipo Slice

- 5.1.Definiendo e Instanciando Structs
- 5.2.Un Programa de Ejemplo Usando Structs
- 5.3.Sintaxis de Métodos

- 6.1.Definiendo un Enum
- 6.2.El operador de control de flujo match
- 6.3.Flujo de Control Conciso con if let y let else

- 7.1.Paquetes y Crates
- 7.2.Definiendo módulos para controlar el scope y la privacidad
- 7.3.Paths para referirse a un item en el árbol de módulos
- 7.4.Incluyendo rutas al Scope con la palabra clave use
- 7.5.Separando Módulos en Diferentes Archivos

- 8.1.Almacenando listas de valores con vectores
- 8.2.Almacenando texto codificado en UTF-8 con Strings
- 8.3.Almacenar Claves con Valores Asociados en HashMaps

- 9.1.Errores irrecuperables con panic!
- 9.2.Errores recuperables con Result
- 9.3.panic! o no panic!

- 10.1.Tipos de Datos Genéricos
- 10.2.Traits: Definiendo Comportamiento Compartido
- 10.3.Validando Referencias con Lifetimes

- 11.1.Cómo Escribir Tests
- 11.2.Controlando Cómo Los Tests Son Ejecutados
- 11.3.Organización De Los Tests

- 12.1.Aceptando argumentos de línea de comandos
- 12.2.Leyendo un archivo
- 12.3.Refactorizando para mejorar la modularidad y el manejo de errores
- 12.4.Desarrollando la funcionalidad de la biblioteca con T.D.D.
- 12.5.Trabajando con Variables de Entorno
- 12.6.Escribiendo mensajes de error estándar en lugar del output estándar

- 13.1.Closures: Funciones anónimas que capturan su entorno
- 13.2.Procesando una serie de elementos con Iteradores
- 13.3.Mejorando nuestro proyecto I/O
- 13.4.Comparando Performance: Bucles vs. Iteradores

- 14.1.Personalizando Compilaciones con Perfiles de Lanzamiento
- 14.2.Publicando un Crate a Crates.io
- 14.3.Cargo Workspaces
- 14.4.Instalando Binarios con cargo install
- 14.5.Extendiendo Cargo con Comandos Personalizados

- 15.1.Usando Box<T> para Apuntar a Datos en el Heap
- 15.2.Tratando los Smart Pointers como Referencias Regulares con el Trait Deref
- 15.3.Ejecutando Código al Limpiar con el Trait Drop
- 15.4.Rc<T>, el Smart Pointer de Conteo de Referencias
- 15.5.RefCell<T> y el Patrón de Mutabilidad Interior
- 15.6.Referencias Circulares Pueden Fugar Memoria

- 16.1.Usando Threads para Ejecutar Código Simultáneamente
- 16.2.Usando el Pasaje de Mensajes para Transferir Datos entre Hilos
- 16.3.Concurrencia con Estado Compartido
- 16.4.Concurrencia extensible con los traits Sync y Send

- 17.1.Futures y la sintaxis Async
- 17.2.Aplicando Concurrencia Con Async
- 17.3.Trabajar con cualquier número de futuros
- 17.4.Streams
- 17.5.Profundizando en los Traits para Async
- 17.6.Futuros, tareas e hilos

- 18.1.Características de Lenguajes Orientados a Objetos
- 18.2.Usando Trait Objects que Permiten Valores de Diferentes Tipos
- 18.3.Implementando un Patrón de Diseño Orientado a Objetos

- 19.1.Todos los lugares donde se pueden usar Patterns
- 19.2.Refutabilidad: Si un Pattern Puede Fallar al Hacer Match
- 19.3.Sintaxis de los Patterns

- 20.1.Rust Inseguro
- 20.2.Traits Avanzados
- 20.3.Tipos Avanzados
- 20.4.Funciones y Closures Avanzados
- 20.5.Macros

- 21.1.Construyendo un Servidor Web de un Solo Hilo
- 21.2.Convirtiendo Nuestro Servidor de un solo Hilo en un Servidor Multihilo
- 21.3.Apagado y limpieza eficientes

- 22.1.A - Palabras claves
- 22.2.B - Operadores y Símbolos
- 22.3.C - Traits derivables
- 22.4.D - Herramientas de desarrollo útiles
- 22.5.E - Ediciones
- 22.6.F - Traducciones del libro
- 22.7.G - Cómo se hace Rust y “Rust Nightly”

- Light (default)
- Rust
- Coal
- Navy
- Ayu
- Latte
- Frappé
- Macchiato
- Mocha

- Elimina el bloque async alrededor de uno o ambos bucles.
- Espera (await) cada bloque async inmediatamente después de definirlo.
- Envuelve solo el primer bucle en un bloque async y espera el future resultante
después del cuerpo del segundo bucle.

- El future devuelto portrpl::joinsolo se completa cuandoambosfutures que
recibe han terminado.
- El future detxse completa cuando termina el último sleep después de enviar el
último mensaje envals.
- El future derxno se completará hasta que el buclewhile lettermine.
- El buclewhile letno terminará hasta que esperarrx.recvdevuelvaNone.
- rx.recv().awaitsolo devolveráNonecuando el otro extremo del canal
se cierre.
- El canal solo se cerrará si llamamos arx.closeo cuando se elimine (drop)
el lado del envíotx.
- No llamamos arx.closeen ninguna parte, ytxno se eliminará hasta que finalice el
bloque async externo pasado atrpl::run.
- El bloque no puede terminar porque está esperando quetrpl::joinse complete,
lo que nos devuelve al inicio de esta lista.