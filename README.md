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



---

# Operadores de Java

### En Java, los operadores se pueden clasificar en varias categorías según su uso. Aquí te detallo los operadores más comunes, junto con ejemplos de uso para cada uno:

### 1. **Operadores Aritméticos**
Los operadores aritméticos se utilizan para realizar operaciones matemáticas.

- **+ (Suma)**
  ```java
  int a = 5;
  int b = 3;
  int resultado = a + b;  // resultado es 8
  ```

- **- (Resta)**
  ```java
  int a = 5;
  int b = 3;
  int resultado = a - b;  // resultado es 2
  ```

- **\* (Multiplicación)**
  ```java
  int a = 5;
  int b = 3;
  int resultado = a * b;  // resultado es 15
  ```

- **/ (División)**
  ```java
  int a = 5;
  int b = 2;
  int resultado = a / b;  // resultado es 2 (entero)
  ```

- **% (Módulo o Resto)**
  ```java
  int a = 5;
  int b = 2;
  int resultado = a % b;  // resultado es 1 (resto de la división)
  ```

### 2. **Operadores Relacionales**
Los operadores relacionales se utilizan para comparar dos valores.

- **== (Igual a)**
  ```java
  int a = 5;
  int b = 5;
  boolean resultado = (a == b);  // resultado es true
  ```

- **!= (Distinto de)**
  ```java
  int a = 5;
  int b = 3;
  boolean resultado = (a != b);  // resultado es true
  ```

- **> (Mayor que)**
  ```java
  int a = 5;
  int b = 3;
  boolean resultado = (a > b);  // resultado es true
  ```

- **< (Menor que)**
  ```java
  int a = 5;
  int b = 10;
  boolean resultado = (a < b);  // resultado es true
  ```

- **>= (Mayor o igual que)**
  ```java
  int a = 5;
  int b = 5;
  boolean resultado = (a >= b);  // resultado es true
  ```

- **<= (Menor o igual que)**
  ```java
  int a = 3;
  int b = 5;
  boolean resultado = (a <= b);  // resultado es true
  ```

### 3. **Operadores Lógicos**
Los operadores lógicos se utilizan para realizar operaciones lógicas (booleanas).

- **&& (AND lógico)**
  ```java
  boolean a = true;
  boolean b = false;
  boolean resultado = (a && b);  // resultado es false
  ```

- **|| (OR lógico)**
  ```java
  boolean a = true;
  boolean b = false;
  boolean resultado = (a || b);  // resultado es true
  ```

- **! (NOT lógico)**
  ```java
  boolean a = true;
  boolean resultado = !a;  // resultado es false
  ```

### 4. **Operadores de Asignación**
Los operadores de asignación se utilizan para asignar valores a variables.

- **= (Asignación simple)**
  ```java
  int a = 5;
  int b = a;  // b es igual a 5
  ```

- **+= (Asignación con suma)**
  ```java
  int a = 5;
  a += 3;  // a es ahora 8
  ```

- **-= (Asignación con resta)**
  ```java
  int a = 5;
  a -= 2;  // a es ahora 3
  ```

- **\*= (Asignación con multiplicación)**
  ```java
  int a = 5;
  a *= 2;  // a es ahora 10
  ```

- **/= (Asignación con división)**
  ```java
  int a = 5;
  a /= 2;  // a es ahora 2 (resultado entero)
  ```

- **%= (Asignación con módulo)**
  ```java
  int a = 5;
  a %= 3;  // a es ahora 2
  ```

### 5. **Operadores Unarios**
Los operadores unarios afectan a un solo operando.

- **+ (Unario, positivo)**
  ```java
  int a = 5;
  int resultado = +a;  // resultado es 5
  ```

- **- (Unario, negativo)**
  ```java
  int a = 5;
  int resultado = -a;  // resultado es -5
  ```

- **++ (Incremento)**
  ```java
  int a = 5;
  a++;  // a es ahora 6
  ```

- **-- (Decremento)**
  ```java
  int a = 5;
  a--;  // a es ahora 4
  ```

### 6. **Operadores de Ternario**
El operador ternario es una forma compacta de realizar una condición `if-else`.

- **?: (Operador ternario)**
  ```java
  int a = 5;
  int b = 3;
  int resultado = (a > b) ? a : b;  // resultado es 5
  ```

### 7. **Operadores de Tipo**
Los operadores de tipo permiten trabajar con tipos de datos.

- **instanceof (Verificación de tipo)**
  ```java
  String texto = "Hola";
  boolean resultado = texto instanceof String;  // resultado es true
  ```

### 8. **Operadores Bit a Bit**
Los operadores bit a bit se utilizan para manipular bits de números enteros.

- **& (AND bit a bit)**
  ```java
  int a = 5;   // 0101 en binario
  int b = 3;   // 0011 en binario
  int resultado = a & b;  // resultado es 1 (0001 en binario)
  ```

- **| (OR bit a bit)**
  ```java
  int a = 5;   // 0101 en binario
  int b = 3;   // 0011 en binario
  int resultado = a | b;  // resultado es 7 (0111 en binario)
  ```

- **^ (XOR bit a bit)**
  ```java
  int a = 5;   // 0101 en binario
  int b = 3;   // 0011 en binario
  int resultado = a ^ b;  // resultado es 6 (0110 en binario)
  ```

- **~ (Complemento a uno)**
  ```java
  int a = 5;   // 0101 en binario
  int resultado = ~a;  // resultado es -6 (complemento a uno de 0101)
  ```

- **<< (Desplazamiento a la izquierda)**
  ```java
  int a = 5;   // 0101 en binario
  int resultado = a << 1;  // resultado es 10 (1010 en binario)
  ```

- **>> (Desplazamiento a la derecha)**
  ```java
  int a = 5;   // 0101 en binario
  int resultado = a >> 1;  // resultado es 2 (0010 en binario)
  ```

- **>>> (Desplazamiento a la derecha sin signo)**
  ```java
  int a = -5;   // 11111111111111111111111111111011 en binario
  int resultado = a >>> 1;  // resultado es 2147483642 (00000000000000000000000000011110 en binario)
  ```

### Resumen

Java proporciona una amplia variedad de operadores para realizar diferentes tipos de operaciones. Algunos son muy útiles para manipular números, cadenas y realizar decisiones lógicas, mientras que otros permiten trabajar directamente con bits y tipos de datos. Si tienes alguna duda adicional sobre algún operador en particular, ¡no dudes en preguntar!



---

# Orden de precedencia

En Java, el orden de precedencia de los operadores determina en qué orden se evalúan las expresiones que contienen múltiples operadores. Los operadores con mayor precedencia se evalúan antes que los de menor precedencia, a menos que se utilicen paréntesis para cambiar el orden de evaluación.

Aquí te doy el **orden de precedencia de los operadores en Java**, junto con ejemplos prácticos para que puedas entenderlo mejor.

### Orden de Precedencia de los Operadores en Java (de mayor a menor)

1. **Operadores de paréntesis** `( )`
   Los paréntesis tienen la mayor precedencia y se usan para agrupar expresiones.

   ```java
   int resultado = (3 + 2) * 5;  // Se evalúa primero (3 + 2), luego * 5. Resultado: 25
   ```

2. **Operadores unarios** `++`, `--`, `+`, `-`, `!`, `~`
   Los operadores unarios tienen la siguiente precedencia: incremento (`++`), decremento (`--`), el cambio de signo (`+`, `-`), el negador lógico (`!`), y el complemento a uno (`~`).

   ```java
   int a = 5;
   int b = ++a;  // Primero se incrementa a, luego se asigna a b. b = 6, a = 6.
   
   int c = 5;
   int d = -c;  // El valor de d es -5.
   ```

3. **Multiplicación, división y módulo** `*`, `/`, `%`
   Estos operadores tienen la misma precedencia y se evalúan de izquierda a derecha.

   ```java
   int a = 6;
   int b = 2;
   int resultado = a * b / 3;  // Primero se realiza la multiplicación: 6 * 2 = 12, luego la división: 12 / 3 = 4
   ```

4. **Suma y resta** `+`, `-`
   Estos operadores tienen la misma precedencia y se evalúan después de la multiplicación y la división.

   ```java
   int a = 10;
   int b = 5;
   int resultado = a - b + 3;  // Se evalúa de izquierda a derecha: 10 - 5 = 5, luego 5 + 3 = 8
   ```

5. **Desplazamiento de bits** `<<`, `>>`, `>>>`
   Se evalúan después de las operaciones aritméticas.

   ```java
   int a = 4;   // 0100 en binario
   int resultado = a << 1;  // Desplazamiento a la izquierda: 0100 se convierte en 1000 (8 en decimal)
   ```

6. **Operadores de comparación** `==`, `!=`, `<`, `>`, `<=`, `>=`
   Los operadores de comparación se evalúan después de los operadores aritméticos y de desplazamiento de bits.

   ```java
   int a = 5;
   int b = 10;
   boolean resultado = a < b;  // El resultado es true porque 5 es menor que 10.
   ```

7. **Operadores lógicos** `&&`, `||`
   Los operadores lógicos `&&` (AND) y `||` (OR) tienen una precedencia más baja y se evalúan después de los operadores de comparación.

   ```java
   boolean a = true;
   boolean b = false;
   boolean resultado = a && b;  // El resultado es false porque ambos deben ser true para que el AND sea true
   ```

8. **Operadores ternarios** `? :`
   El operador ternario tiene precedencia sobre los operadores lógicos y se evalúa de acuerdo a la condición.

   ```java
   int a = 10;
   int b = 5;
   int resultado = (a > b) ? a : b;  // Si a > b, resultado es a (10), si no es b (5). Resultado: 10
   ```

9. **Asignación** `=`, `+=`, `-=`, `*=`, `/=`, `%=`
   Los operadores de asignación tienen la menor precedencia, por lo que se evalúan al final, después de los operadores de comparación y lógicos.

   ```java
   int a = 5;
   int b = 3;
   a += b;  // Primero se suma a y b (a + b), luego se asigna el resultado a a. a es ahora 8.
   ```

### Ejemplo Completo con Orden de Precedencia

Considerando que tienes una expresión compleja, puedes ver cómo se evalúa según la precedencia:

```java
int a = 5;
int b = 10;
int c = 2;
int d = 8;

int resultado = a + b * c - d / 2;  // El resultado se evalúa así:
```

**Paso a paso:**

1. Primero, **multiplicación y división** se realizan:
   - `b * c` = 10 * 2 = 20
   - `d / 2` = 8 / 2 = 4

2. Luego se realiza **suma y resta**:
   - `a + 20 - 4` = 5 + 20 - 4 = 21

**Resultado:** `21`

### Resumen

- El **orden de precedencia** en Java asegura que las expresiones con operadores más fuertes (como paréntesis y operadores unarios) se evalúan primero.
- Los **operadores aritméticos** (`*`, `/`, `%`) tienen más precedencia que los de **suma y resta** (`+`, `-`), y los **operadores lógicos** (`&&`, `||`) tienen una precedencia aún más baja.
- Los **paréntesis** siempre tienen la mayor precedencia y pueden ser usados para cambiar el orden de evaluación.

Si tienes alguna duda adicional sobre el orden de precedencia o ejemplos más complejos, ¡no dudes en preguntar!


---

# Clases y objetos

En Java, las **clases** y los **objetos** son conceptos fundamentales de la programación orientada a objetos (OOP). Vamos a ver qué son y cómo se utilizan:

### ¿Qué es una Clase en Java?

Una **clase** en Java es una plantilla o un plano para crear objetos. Define las propiedades y comportamientos de los objetos de esa clase. Es una estructura que encapsula **atributos** (variables) y **métodos** (funciones) que representan las características y comportamientos de los objetos.

- **Atributos** (o **campos**): Son variables que describen las características de un objeto.
- **Métodos**: Son funciones que describen el comportamiento de los objetos y permiten realizar operaciones con los atributos.

### Ejemplo de Clase en Java

```java
public class Coche {
    // Atributos o características del coche
    String marca;
    String modelo;
    int año;
    String color;

    // Método para mostrar información del coche
    public void mostrarInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + año);
        System.out.println("Color: " + color);
    }

    // Método para arrancar el coche
    public void arrancar() {
        System.out.println("El coche está arrancando...");
    }
}
```

En este ejemplo, la clase `Coche` tiene:
- **Atributos**: `marca`, `modelo`, `año` y `color`.
- **Métodos**: `mostrarInformacion()` para imprimir la información del coche y `arrancar()` para mostrar un mensaje de que el coche está arrancando.

### ¿Qué es un Objeto en Java?

Un **objeto** es una instancia de una clase. En otras palabras, un objeto es una copia concreta de una clase, que tiene valores específicos para sus atributos y puede ejecutar los métodos definidos en la clase. Los objetos se crean utilizando la palabra clave `new`.

### Ejemplo de Creación de un Objeto

Para crear un objeto de la clase `Coche`, hacemos lo siguiente:

```java
public class Main {
    public static void main(String[] args) {
        // Crear un objeto de la clase Coche
        Coche miCoche = new Coche();

        // Asignar valores a los atributos del objeto
        miCoche.marca = "Toyota";
        miCoche.modelo = "Corolla";
        miCoche.año = 2020;
        miCoche.color = "Rojo";

        // Llamar a los métodos del objeto
        miCoche.mostrarInformacion();
        miCoche.arrancar();
    }
}
```

### Explicación:
1. **Crear el objeto**:
   - `Coche miCoche = new Coche();` crea una nueva instancia de la clase `Coche` llamada `miCoche`. Esto significa que `miCoche` es un objeto de tipo `Coche`.

2. **Asignar valores a los atributos**:
   - Los valores como "Toyota", "Corolla", etc., se asignan a los atributos de `miCoche`. Cada objeto puede tener diferentes valores para los mismos atributos.

3. **Llamar a métodos**:
   - Los métodos `mostrarInformacion()` y `arrancar()` son llamados sobre el objeto `miCoche` para realizar acciones específicas sobre ese objeto.

### ¿Cómo funcionan las Clases y Objetos en Java?

#### 1. **Instanciación de Objetos**:
Cuando se utiliza el operador `new`, se crea un objeto en memoria. Este proceso se llama **instanciación**. Por ejemplo, `Coche miCoche = new Coche();` crea un nuevo objeto `miCoche` de la clase `Coche`.

#### 2. **Encapsulamiento**:
Java utiliza el concepto de **encapsulamiento**, que significa que los atributos de una clase generalmente son privados (se declaran con la palabra clave `private`), y el acceso a esos atributos se controla a través de métodos públicos. De esta forma, se pueden proteger los datos del objeto.

```java
public class Persona {
    private String nombre;
    private int edad;

    // Método para obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Método para establecer el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener la edad
    public int getEdad() {
        return edad;
    }

    // Método para establecer la edad
    public void setEdad(int edad) {
        if (edad > 0) {
            this.edad = edad;
        }
    }
}
```

En este ejemplo, la clase `Persona` tiene atributos privados y métodos públicos `get` y `set` que permiten acceder y modificar esos atributos de manera controlada.

#### 3. **Constructores**:
Los **constructores** son métodos especiales que se usan para inicializar objetos. Cuando se crea un objeto, el constructor se ejecuta automáticamente. Si no se define un constructor, Java proporciona uno por defecto (un constructor vacío).

Ejemplo con constructor:

```java
public class Coche {
    String marca;
    String modelo;

    // Constructor
    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void mostrarInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear un objeto usando el constructor
        Coche miCoche = new Coche("Honda", "Civic");
        miCoche.mostrarInformacion();
    }
}
```

En este ejemplo, el constructor `Coche(String marca, String modelo)` permite crear un objeto de la clase `Coche` con valores iniciales para `marca` y `modelo`.

### Resumen

1. **Clase**: Es una plantilla o modelo para crear objetos, que define atributos y métodos.
2. **Objeto**: Es una instancia concreta de una clase con atributos específicos y la capacidad de ejecutar métodos.
3. **Encapsulamiento**: Los atributos de una clase se protegen mediante modificadores de acceso, y se accede a ellos mediante métodos.
4. **Constructor**: Es un método especial utilizado para inicializar los objetos cuando se crean.

Las clases y objetos son fundamentales para entender la programación orientada a objetos en Java, y permiten crear aplicaciones modulares, reutilizables y fáciles de mantener.


## Uso del "this"

