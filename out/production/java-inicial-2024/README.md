# java-inicial-2024

## Capitulo 1

En el contexto de Java:

---

**Java: JVM, JRE y JDK**

1. **Java Virtual Machine (JVM)**:  
   La JVM es una máquina virtual que permite ejecutar programas Java en cualquier sistema operativo. Toma el bytecode, que es el código intermedio de Java, y lo ejecuta en diferentes plataformas. La JVM también gestiona la memoria y realiza la recolección de basura para optimizar el rendimiento.

2. **Java Runtime Environment (JRE)**:  
   El JRE es el entorno de ejecución de Java, que incluye la JVM y bibliotecas esenciales para *ejecutar* aplicaciones Java. Es ideal para usuarios que solo quieren ejecutar programas Java sin desarrollarlos.

3. **Java Development Kit (JDK)**:  
   El JDK es el kit de desarrollo para programar en Java. Incluye el JRE, el compilador `javac`, un depurador y herramientas para crear, empaquetar y documentar aplicaciones. Si deseas escribir código en Java, necesitas instalar el JDK.

4. **Java**:  
   Java es un lenguaje de programación orientado a objetos, conocido por su independencia de plataforma, seguridad y robustez. Esto se logra al compilar el código en bytecode, que luego se ejecuta en la JVM de cualquier sistema operativo.


## IntelliJ IDEA

Primer programa Java

## POO: primer concepto clave

La **abstracción** en programación orientada a objetos (POO) es un principio que permite simplificar la complejidad de un sistema al enfocarse en los aspectos esenciales, ignorando los detalles innecesarios para el contexto. Se trata de modelar los objetos en términos de sus propiedades y comportamientos clave, permitiendo que los desarrolladores interactúen con objetos sin necesidad de conocer su implementación interna.

### ¿Cómo funciona la abstracción en POO?

1. **Enfocarse en lo esencial**:
    - La abstracción permite crear clases y objetos que representan entidades de la vida real solo en términos de lo que es relevante para el sistema. Por ejemplo, si se modela un "Coche", solo se incluyen las propiedades y métodos importantes, como `arrancar()` o `frenar()`, sin necesidad de detallar el funcionamiento interno del motor o el diseño de cada pieza.

2. **Ocultar la complejidad**:
    - La abstracción es una forma de ocultar la complejidad. En lugar de exponer todos los detalles de cómo algo funciona internamente, solo se proporcionan los métodos necesarios para interactuar con el objeto. Esto facilita el uso de clases sin tener que conocer cómo están implementadas.

3. **Uso de clases y métodos abstractos**:
    - En Java, se implementa la abstracción mediante **clases abstractas** e **interfaces**:
        - Una **clase abstracta** puede definir métodos abstractos (sin implementación) que luego serán implementados por sus subclases. Esto permite que una clase base defina el "qué" deben hacer las clases derivadas, mientras que las clases derivadas definen el "cómo".
        - Una **interfaz** puede declarar métodos que otras clases deben implementar, proporcionando una estructura de comportamiento sin especificar los detalles de la implementación.

### Ejemplo de Abstracción

Imagina un sistema de pago en una tienda. El sistema debe poder procesar pagos con tarjeta de crédito, débito o PayPal, entre otros. Sin embargo, no es necesario conocer todos los detalles internos de cada tipo de pago, sino solo las acciones esenciales: `procesarPago()` y `verificarFondos()`.

```java
// Clase abstracta que define los métodos comunes para cualquier tipo de pago
abstract class Pago {
    abstract void procesarPago(double monto);
    abstract boolean verificarFondos(double monto);
}

// Clase concreta que implementa los métodos para el pago con tarjeta
class PagoConTarjeta extends Pago {
    void procesarPago(double monto) {
        // Lógica específica para procesar un pago con tarjeta
    }

    boolean verificarFondos(double monto) {
        // Verificación de fondos para tarjeta
        return true;
    }
}
```

Con esta abstracción, el sistema puede trabajar con distintos tipos de pago sin preocuparse por cómo cada uno de ellos funciona internamente. Solo necesita saber que todos los pagos tienen los métodos `procesarPago()` y `verificarFondos()`.

### Ventajas de la Abstracción

- **Facilita el mantenimiento**: Ocultar detalles innecesarios hace que el código sea más limpio y fácil de entender.
- **Reutilización de código**: La abstracción permite definir comportamientos comunes, lo cual reduce la duplicación.
- **Flexibilidad**: Los cambios en los detalles de implementación no afectan a las partes del sistema que solo interactúan con la interfaz abstracta.

En resumen, la abstracción en POO ayuda a modelar sistemas complejos enfocándose solo en los aspectos necesarios, simplificando el diseño y el uso de los objetos en el código.


## Tipos primitivos del lenguaje

En Java, los tipos de datos primitivos son básicos y se utilizan para almacenar valores simples. Existen ocho tipos primitivos:

1. **byte**
    - Tamaño: 8 bits (1 byte)
    - Rango: de -128 a 127
    - Usado para ahorrar memoria en grandes arreglos.

2. **short**
    - Tamaño: 16 bits (2 bytes)
    - Rango: de -32,768 a 32,767

3. **int**
    - Tamaño: 32 bits (4 bytes)
    - Rango: de -2,147,483,648 a 2,147,483,647
    - Tipo entero más utilizado.

4. **long**
    - Tamaño: 64 bits (8 bytes)
    - Rango: de -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807
    - Se usa para valores enteros muy grandes. Se denota con una "L" al final (por ejemplo, `100L`).

5. **float**
    - Tamaño: 32 bits (4 bytes)
    - Rango: Aproximadamente ±3.40282347E+38F
    - Usado para decimales de precisión simple. Se denota con una "F" al final (por ejemplo, `3.14F`).

6. **double**
    - Tamaño: 64 bits (8 bytes)
    - Rango: Aproximadamente ±1.79769313486231570E+308
    - Usado para decimales de precisión doble. Es el tipo decimal predeterminado.

7. **char**
    - Tamaño: 16 bits (2 bytes)
    - Representa un solo carácter Unicode (por ejemplo, 'A', '9', '&').

8. **boolean**
    - Tamaño: no está definido con precisión (pero usualmente ocupa 1 bit)
    - Valores posibles: `true` o `false`
    - Usado para representar condiciones o estados lógicos.

Estos tipos primitivos son esenciales, ya que son los bloques básicos para manejar datos simples en Java.

## Donde se almacenan los tipos primitivos?

En Java, los tipos de datos primitivos se almacenan en la **memoria de pila (stack)**, aunque esto depende del contexto en que se usen. Aquí tienes una explicación detallada de cómo y dónde se almacenan:

1. **Memoria de Pila (Stack)**:
    - Los tipos primitivos se almacenan directamente en la **pila** cuando se declaran como variables locales dentro de un método. La pila es una zona de memoria rápida y de tamaño limitado, y es ideal para almacenar datos de vida corta, como variables locales que se crean y destruyen dentro del contexto de un método.
    - Ejemplo: Si declaras una variable `int x = 10;` dentro de un método, `x` se almacenará en la pila.

2. **Memoria de Montículo (Heap)**:
    - Cuando los tipos primitivos son **atributos de una instancia de clase**, se almacenan en la **memoria de montículo (heap)**. La memoria de montículo es una zona más grande y de vida más larga, donde se almacenan los objetos y los atributos de las instancias.
    - Ejemplo: Si tienes una clase `Persona` con un atributo `int edad`, y creas un objeto `Persona persona = new Persona();`, el valor de `edad` se almacenará en el montículo como parte de la instancia del objeto.

3. **Objetos Envolventes (Wrapper)**:
    - Si los tipos primitivos se envuelven en clases envolventes (por ejemplo, `Integer`, `Double`, `Boolean`), se convierten en objetos y se almacenan en el montículo. Esto sucede cuando los primitivos se usan en estructuras de datos que solo aceptan objetos, como colecciones (`ArrayList`, `HashMap`, etc.) o cuando se necesita pasar un tipo primitivo a un método que requiere un objeto.
    - Ejemplo: `Integer numero = 5;` almacenará el valor `5` en el montículo como un objeto de tipo `Integer`.

### Resumen

- **Pila**: Variables locales de tipos primitivos en métodos.
- **Montículo**: Atributos primitivos de los objetos y objetos envolventes de tipos primitivos.




## Ejercicios:
Utilizando lo visto sobre datos primitivos abstraer una clase del mundo real y modelar sus atributos utilizando todos los tipos primitivos de uso mas comun (podriamos no incluir a byte)




