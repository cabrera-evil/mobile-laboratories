# Laboratorio `09`


## To do

- ¿Qué es una coroutine en Kotlin y cómo se diferencia de un hilo
tradicional?

        Una coroutine es una tarea que se ejecuta de manera asíncrona, es
        decir, que no se ejecuta en el hilo principal de la aplicación.
        La diferencia con un hilo tradicional es que una coroutine no
        bloquea el hilo principal de la aplicación, por lo que se puede
        seguir utilizando la aplicación mientras se ejecuta la coroutine.

- ¿Cuál es la importancia de la suspensión en las coroutines y cómo se
implementa?

        La suspensión en las coroutines es importante porque permite
        pausar la ejecución de una coroutine sin bloquear el hilo
        principal de la aplicación. Se implementa utilizando la palabra
        reservada suspend en la función que se quiere ejecutar de manera
        asíncrona.

- ¿Cuál es el propósito del Dispatcher en las coroutines y cómo se elige
uno adecuado para cada tarea?

        El propósito del Dispatcher es indicar en qué hilo se va a
        ejecutar la coroutine. Se elige uno adecuado para cada tarea
        dependiendo de si se quiere ejecutar en el hilo principal de la
        aplicación o en un hilo secundario.

- ¿Cuál es el propósito y el uso de la función async en las coroutines?

        El propósito de la función async es ejecutar una coroutine de
        manera asíncrona y devolver un valor cuando la coroutine haya
        terminado de ejecutarse.