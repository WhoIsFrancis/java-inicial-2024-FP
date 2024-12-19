Una **función lambda** es una función anónima (es decir, una función sin nombre) que puedes utilizar para expresar operaciones breves de manera concisa. En Java, las lambdas se introdujeron en Java 8 como parte de la programación funcional y permiten escribir código más compacto, especialmente cuando trabajas con la **API de Streams** o **interfaces funcionales**.

---

## **Sintaxis de una función lambda**

La sintaxis básica de una lambda en Java es:

```java
(parametros) -> { cuerpo }
```

### **Componentes de una lambda:**
1. **Parámetros:**
    - Los parámetros de entrada que recibe la función.
    - Si hay un solo parámetro, no es necesario usar paréntesis, por ejemplo: `x -> x * x`.
    - Si no hay parámetros, se usan paréntesis vacíos: `() -> System.out.println("Hola")`.

2. **Operador lambda:**
    - El símbolo `->` separa los parámetros del cuerpo de la función.

3. **Cuerpo:**
    - El código que se ejecuta cuando se llama a la función.
    - Si el cuerpo tiene una sola expresión, no es necesario usar llaves `{}` ni la palabra clave `return`.
    - Si hay varias líneas, usa `{}` y explícitamente `return` si corresponde.

---

## **Ejemplos básicos de funciones lambda**

### **1. Lambda con un solo parámetro**
```java
import java.util.function.Function;

public class LambdaExample {
    public static void main(String[] args) {
        // Función que calcula el cuadrado de un número
        Function<Integer, Integer> cuadrado = x -> x * x;

        System.out.println(cuadrado.apply(5)); // Salida: 25
    }
}
```

### **2. Lambda con múltiples parámetros**
```java
import java.util.function.BiFunction;

public class MultiParameterLambda {
    public static void main(String[] args) {
        // Función que suma dos números
        BiFunction<Integer, Integer, Integer> sumar = (a, b) -> a + b;

        System.out.println(sumar.apply(3, 7)); // Salida: 10
    }
}
```

### **3. Lambda sin parámetros**
```java
import java.util.function.Supplier;

public class NoParameterLambda {
    public static void main(String[] args) {
        // Función que devuelve un saludo
        Supplier<String> saludo = () -> "Hola, Mundo";

        System.out.println(saludo.get()); // Salida: Hola, Mundo
    }
}
```

---

## **Uso de lambdas con interfaces funcionales**

En Java, una **lambda** solo puede implementarse en el contexto de una **interface funcional**. Una interface funcional es aquella que tiene exactamente **un método abstracto**. Ejemplos comunes incluyen las interfaces del paquete `java.util.function` como `Function`, `Consumer`, `Supplier`, `Predicate`, y `BiFunction`.

### **Ejemplo con `Predicate`**
`Predicate<T>` es una interface funcional que representa una función que toma un argumento de tipo `T` y devuelve un valor booleano.

```java
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        // Función que verifica si un número es par
        Predicate<Integer> esPar = x -> x % 2 == 0;

        System.out.println(esPar.test(4)); // Salida: true
        System.out.println(esPar.test(7)); // Salida: false
    }
}
```

---

## **Lambdas en Streams**

Las lambdas se usan ampliamente con la **Streams API** para realizar operaciones como filtrado, mapeo y reducción.

### **Ejemplo: Filtrar números pares**
```java
import java.util.Arrays;
import java.util.List;

public class LambdaStreamExample {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        numeros.stream()
            .filter(n -> n % 2 == 0) // Filtra los números pares
            .forEach(System.out::println); // Salida: 2, 4, 6
    }
}
```

---

## **Ventajas de las funciones lambda**
1. **Código más conciso:**  
   Reduce la necesidad de clases anónimas para implementar interfaces funcionales.

2. **Legibilidad:**  
   Elimina el ruido del código al enfocarse en lo que hace la función.

3. **Mayor expresividad:**  
   Es más fácil expresar operaciones comunes como transformaciones y filtrados de datos.

---

## **Equivalencia entre clases anónimas y lambdas**

### **Con clase anónima**
```java
import java.util.function.Function;

public class AnonymousClassExample {
    public static void main(String[] args) {
        Function<Integer, Integer> cuadrado = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        System.out.println(cuadrado.apply(5)); // Salida: 25
    }
}
```

### **Con lambda**
```java
import java.util.function.Function;

public class LambdaExample {
    public static void main(String[] args) {
        Function<Integer, Integer> cuadrado = x -> x * x;

        System.out.println(cuadrado.apply(5)); // Salida: 25
    }
}
```

Ambos ejemplos hacen exactamente lo mismo, pero el código con lambda es más limpio y legible.

---
