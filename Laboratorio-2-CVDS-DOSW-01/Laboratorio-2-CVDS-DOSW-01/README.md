#Patrones y evidencias Por reto












#Reto 4 

Se usó el patrón Strategy porque la clase ConversionService no sabe cómo se realiza 
la conversión de una moneda a otra, simplemente recibe una referencia a un objeto 
que implementa la estrategia adecuada. Esto permite que la lógica de conversión sea 
intercambiable sin modificar el servicio principal.

Básicamente, separa la preocupación del cálculo de las tasas de conversión
de la lógica de gestión de transacciones, y facilita la adición de nuevas conversiones
(por ejemplo, de USD a COP o de JPY a EUR) sin necesidad de modificar el código existente. 
Esto aumenta la extensibilidad, mantiene el código limpio
y cumple con el principio de abierto/cerrado de SOLID.

#Reto 5 

Se usó el patrón Decorator porque la clase CafeBase no sabe cómo se agregan los toppings, 
simplemente es envuelta por objetos decoradores que añaden funcionalidades adicionales 
(como descripción y precio). Esto permite que la lógica de agregar complementos sea dinámica
 y flexible sin modificar la clase base.

Básicamente, separa la preocupación del objeto principal (el café) de las responsabilidades
adicionales (toppings), y facilita la combinación de múltiples decoradores en tiempo de ejecución.
De esta forma se pueden añadir nuevos toppings sin modificar el código existente, lo que aumenta la extensibilidad, 
mantiene el sistema modular y cumple con el principio de abierto/cerrado de SOLID.