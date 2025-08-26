## Patrones y evidencias Por reto

## Reto # 1:
Se usó el patrón strategy porque la clase carrito no sabe cómo se calcula el descuento, simplemente recibe una referencia a un objeto de él, esto permite que la lógica de los descuentos sea intercambiable sin modificar el carrito.  Básicamente separa la preocupación del cálculo de los descuentos del carrito y facilita la adición de nuevos tipos de descuento sin modificar el carrito, lo que aumenta la extensibilidad.

## Reto # 2:
creacional
Se usó el patrón Builder. Como la hamburguesa puede tener ingredientes personalizados este necesita ser construido paso a paso.
Se creo la clase ingredient para representar un ingrediente individual, se empleo Burger como producto final luego se usó Burger Builder para ir añadiendo ingredientes de forma fluida. El menú ofrece ingredientes predeterminados y permite agregar ingredientes personalizados.

## Reto # 3:
En este reto se utilizo el patrón Factory ya que tenemos familias de productos relacionados, cada una se gestiona a través de una factory concreta las cuales fueron vehiculosTierraFactory, vehiculoAcuaticoFactory y vehiculoAereoFactory, todas implementan la interfaz común vehiculoFcatory. Es una buena implementación ya que organiza la creación de las familias, mantiene bajo acoplamiento y permite escalabilidad.

## Reto # 4:

Se usó el patrón Strategy porque la clase ConversionService no sabe cómo se realiza 
la conversión de una moneda a otra, simplemente recibe una referencia a un objeto 
que implementa la estrategia adecuada. Esto permite que la lógica de conversión sea 
intercambiable sin modificar el servicio principal.

Básicamente, separa la preocupación del cálculo de las tasas de conversión
de la lógica de gestión de transacciones, y facilita la adición de nuevas conversiones
(por ejemplo, de USD a COP o de JPY a EUR) sin necesidad de modificar el código existente. 
Esto aumenta la extensibilidad, mantiene el código limpio
y cumple con el principio de abierto/cerrado de SOLID.

## Reto # 5:

Se usó el patrón Decorator porque la clase CafeBase no sabe cómo se agregan los toppings, 
simplemente es envuelta por objetos decoradores que añaden funcionalidades adicionales 
(como descripción y precio). Esto permite que la lógica de agregar complementos sea dinámica
y flexible sin modificar la clase base.

Básicamente, separa la preocupación del objeto principal (el café) de las responsabilidades
adicionales (toppings), y facilita la combinación de múltiples decoradores en tiempo de ejecución.
De esta forma se pueden añadir nuevos toppings sin modificar el código existente, lo que aumenta la extensibilidad, 
mantiene el sistema modular y cumple con el principio de abierto/cerrado de SOLID.

## Reto # 6:
Usamos el patrón Cadena de Responsabilidad para gestionar tickets según nivel y prioridad.
Creamos la clase Ticket con sus atributos, una interfaz Handler para procesar y escalar solicitudes, y clases concretas de técnicos (básico, intermedio, avanzado).
Cada técnico pasa el ticket al siguiente si no puede resolverlo; si nadie lo atiende, queda pendiente de escalamiento.
Además, usamos streams para contar tickets por nivel y prioridad.

## Reto # 7: 
Usamos el patrón Comando para manejar acciones como encender luces, abrir puertas o reproducir música.
Cada acción se implementa como una clase con métodos para ejecutar y deshacer, mientras que el control remoto actúa como invocador.
También se guarda un historial de acciones con el usuario que las realizó, lo que permite deshacer y mostrar un resumen final.

## Reto # 8:

Usamos herencia y polimorfismo para modelar animales (mamíferos, reptiles y aves) a partir de una interfaz común que define atributos y acciones.
Los cuidadores y visitantes se manejan como clases independientes, con asociaciones: los cuidadores cuidan animales y los visitantes pueden alimentar animales, dar propinas y subir fotos.
El diseño sigue principios SOLID y aplica un patrón creacional (Factory) para centralizar la creación de animales, cuidadores y visitantes.