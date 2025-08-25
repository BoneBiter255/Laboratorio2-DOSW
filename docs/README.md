# Laboratorio 02 - SOLID, Patrones de Diseño y UML

**Integrantes:**
- Laura Venegas
- Daniel Hueso
- Isaac Palomo

**Nombre de la rama: feature/VenegasLaura_PalomoIsaac_HuesoDaniel_2025-2**

PREGUNTAS INICIALES
1.	¿Qué ventaja ofrece el polimorfismo en el diseño de clases frente al uso de múltiples condicionales para determinar el comportamiento de un objeto?

El polimorfismo ofrece varias ventajas, ya que evita tener un código con muchos if/else lo  que hace que no tenga estucturas condicionales muy conmplejas, esto nos hace tener un código más limpio y fácil de entender. 

2.	¿Por qué una clase inmutable puede mejorar la seguridad?

Como sabemos una clase inmutable es aquella que no permite cambios en su estado luego que se haya creado. Es por esto que la clase inmutable puede mejorar la seguridad pues asegura que nadie pueda modificar el estado de un objeto de forma inesperada.

3.	¿Qué problema podría aparecer en un sistema si los atributos de las clases se mantienen públicos en lugar de privados con getters y setters controlados?

En este caso no se estaría cumpliendo el principio Single responsability de SOLID, especificamente el encapsulamiento.
Al tener atributos públicos cualquiera podría modificarlos sin restricciones y eso nos llevaría a tener inconsistencias por asignar valores inválidos.

4.	¿Según el principio de Abierto/Cerrado, como deberíamos modificar el sistema si queremos añadir una nueva funcionalidad sin alterar el código existente?

Este principio nos dice que el sofware debe estar abierto para extensión pero cerrado para su modificación. Es por esto que si queremos añadr una nueva funcionadlidad sin alterar el código existente, debemos extender la clases, ya sea con polimorfismo, herencias, interfaces, etc.

5.	¿Por qué es importante que una clase cumpla con el Principio de única responsabilidad y que ejemplo sencillo podrías dar donde se vulnere?

Es importante ya que si una clse hace muchas cosas algún cambio puede afectar otras funcionalidades.
Un ejemplo que pudimos observar el semestre pasado fue al hacer un juego. Se tiene una clase juego que iniciaJuego, GuardaJuego, muestraJUego. Lo corrcto seria dividirse en varios.

6.	¿Qué es y porque usamos el pom.xml?

pom significa poject object model, es un archivo XML que se encuentra en corazón de los proyectos maven, es decir es el archivo de configuración de Maven donde esta la información del pryecto, dependencias, etc. 

7.	¿Qué diferencia hay entre mvn compile, mvn package y mvn install?
- mvn compile: compila el código fuente .class
- mvn package: Compila, ejecuta tests y empaqueta el código compilado en un .jar o .war.
- mvn install: hace todo la anterior e instala en el repositorio local de maven para que pueda ser usado como dependencia en otros proyectos. 


8.	¿Qué diferencia existe entre una interfaz y una clase abstracta?

Una clase abstacta no se puede instanciar directamente, sino que sirve de base para otras clases, en esta se pueden definir métodos abstactos o concretos, mientras que una interfaz es un conjunto de métodos abstractos (todos) que una clse debe implementar.

NOTA: Para completar las respuestas de las preguntas indagamos en los siguientes sitios y nos ayudamos de la presentación de la clase de semana 2:
https://keepcoding.io/blog/diferencia-entre-clase-abstracta-e-interfaz/

https://profile.es/blog/principios-solid-desarrollo-software-calidad/


---

## Retos Completados

## Reto 6
**Categoria:** Comportamiento
**Patrón utilizado:** Cadena de responsabilidad
**Justificación:** Este patrón permite que varios objetos puedan manejar una solicitud. En este reto, los tickets peueden ser resueltos por distintos tecnicos según su nivel y prioridad.

**¿Como lo aplicamos?:** 
1. Se creo la clase ticket con atributos: nivel, prioridad y descripción.
2. Se implementó una interfaz Handler, que contiene un metodo para procesar la solicitud, y otro para asociar al siguiente tecnico.
3. Cada clase concreta de Tecnico basico, intermedio, avanzado, implementa la interfaz.
4. Cada técnico tiene referencia al siguiente.
5. Si ninguno puede resolver, se marca como "pendiente de escalamiento".
6. Se usan streams para contar tickets por nivel y prioridad.

## Reto 7
**Categoria:** Comportamiento
**Patrón Utilizado:** Comando
**Justificación:** Este patrón permite encapsukar una solicitud como un objeto, lo que nos permite ejecutar una secuencia de acciones sobre diferentes objetos, en este caso, puertas, luces y reproductor de musica.

**¿Como lo aplicamos?:** 
1. Ya que usamos el patrón comando, cada acción disponible (encender luz, abrir puerta, reproducir musica...) es una clase con métodos para ejecutar y dehacer. El control remoto actúa como invocador, ejecutando los comandos sin conocer su lógica interna. 
2. Un historial guarda todas las acciones y quién las realizó, permitiendo deshacer y mostrar un resumen final.