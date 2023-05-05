# Laboratorio `06`


## To do

- ¿Qué ventajas tiene el utilizar LiveData?

        - Garantiza que la IU de la app esté actualizada.
        - No provoca pérdidas de memoria.
        - No provoca errores de estado.
        - No necesita métodos de ciclo de vida, como onResume().
        - Siempre está actualizada con los últimos datos.
        - Garantiza que solo haya una única instancia de los datos de la app.
        - Proporciona actualizaciones si la app se encuentra en primer plano
          o en segundo plano.

- ¿Qué patrón de diseño utiliza LiveData?

        El patrón de diseño Observer es un patrón de diseño de comportamiento
        que define una dependencia de uno a muchos entre objetos, de manera
        que cuando uno de los objetos cambia su estado, notifica este cambio
        a todos los dependientes.

- Menciona que se debe agregar al Gradle para poder implementar
DataBinding

        dataBinding {
            enabled = true
        }

- ¿Qué es DataBinding? Menciona sus ventajas frente a findViewById

        Data Binding es un enlace de datos que conecta los componentes de la
        IU de la app (la vista) con los componentes de la arquitectura de
        la app (el modelo). De esta manera, crea un vínculo en tiempo de
        compilación entre el componente de la IU y el componente de la
        arquitectura, de modo que los cambios en el componente de la
        arquitectura se reflejan automáticamente en el componente de la
        IU. Los enlaces de datos son observables, lo que significa que
        crean una relación de observador-observable entre el componente
        de la IU y el componente de la arquitectura.

        Ventajas:

        - Reduce la complejidad del código, ya que no es necesario
          llamar a findViewById().
        - Hace que el código sea más fácil de leer y de mantener,
          ya que no hay que buscar elementos de la IU.
        - Mejora la eficiencia, ya que no es necesario llamar a
          findViewById() para cada vista que se necesita actualizar.