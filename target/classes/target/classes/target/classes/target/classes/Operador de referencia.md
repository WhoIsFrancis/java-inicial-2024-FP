El operador `::` en Java se llama **operador de referencia a método** (*method reference operator*). Fue introducido en Java 8 y se usa para hacer referencia a métodos o constructores directamente, sin necesidad de invocarlos explícitamente. Es una forma abreviada y concisa de escribir expresiones lambda que simplemente llaman a un método.

---

## **Tipos de referencias de método**
Existen cuatro tipos principales de referencias de método:

### **1. Referencia a un método estático**
Sintaxis:
```java
Clase::métodoEstático
```

**Ejemplo:**
```java
import java.util.function.Function;

public class StaticMethodReference {
    public static void main(String[] args) {
        Function<String, Integer> convertirAEntero = Integer::parseInt;
        Integer numero = convertirAEntero.apply("123");
        System.out.println(numero); // Salida: 123
    }
}
```
En este caso, `Integer::parseInt` es equivalente a usar una expresión lambda como:
```java
Function<String, Integer> convertirAEntero = str -> Integer.parseInt(str);
```

---

### **2. Referencia a un método de instancia de un objeto específico**
Sintaxis:
```java
instancia::métodoDeInstancia
```

**Ejemplo:**
```java
import java.util.function.Supplier;

public class InstanceMethodReference {
    public static void main(String[] args) {
        String texto = "Hola, Mundo";
        Supplier<Integer> obtenerLongitud = texto::length;
        System.out.println(obtenerLongitud.get()); // Salida: 11
    }
}
```
Aquí, `texto::length` es una referencia directa al método `length()` del objeto `texto`.

---

### **3. Referencia a un método de instancia de un objeto arbitrario de un tipo**
Sintaxis:
```java
Clase::métodoDeInstancia
```

**Ejemplo:**
```java
import java.util.Arrays;
import java.util.List;

public class ArbitraryInstanceMethodReference {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Ana", "Pedro", "Juan");

        // Usando una referencia a método para ordenar ignorando mayúsculas
        nombres.sort(String::compareToIgnoreCase);

        System.out.println(nombres); // Salida: [Ana, Juan, Pedro]
    }
}
```
Aquí, `String::compareToIgnoreCase` hace referencia al método de instancia `compareToIgnoreCase` de cualquier objeto de tipo `String`.

---

### **4. Referencia a un constructor**
Sintaxis:
```java
Clase::new
```

**Ejemplo:**
```java
import java.util.function.Supplier;

public class ConstructorReference {
    public static void main(String[] args) {
        Supplier<String> crearCadena = String::new;
        String cadena = crearCadena.get();
        System.out.println(cadena); // Salida: (una cadena vacía)
    }
}
```
En este caso, `String::new` es una referencia al constructor sin argumentos de la clase `String`.

---

## **Cuándo usar `::` en lugar de una expresión lambda**
Usa `::` cuando la expresión lambda simplemente llama a un método o constructor ya existente. Es más conciso y mejora la legibilidad del código.

**Comparación:**
```java
// Usando una expresión lambda
nombres.forEach(nombre -> System.out.println(nombre));

// Usando una referencia a método
nombres.forEach(System.out::println);
```

Ambas hacen lo mismo, pero la segunda es más directa y legible.

---
