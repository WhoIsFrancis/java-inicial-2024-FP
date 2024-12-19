La **Java Streams API**, introducida en Java 8, es una poderosa herramienta para procesar colecciones de datos de forma funcional y declarativa. Permite realizar operaciones como filtrado, mapeo, agrupación y reducción de manera eficiente y concisa. Aquí tienes una explicación detallada con ejemplos de dificultad intermedia.

---

## **1. Conceptos básicos de Streams**
Un *Stream* es una secuencia de elementos sobre los que puedes realizar operaciones. Las operaciones pueden ser:
- **Intermedias:** Transforman un Stream en otro Stream (p. ej., `filter`, `map`, `sorted`).
- **Terminales:** Producen un resultado o efecto secundario y consumen el Stream (p. ej., `collect`, `forEach`, `reduce`).

Un Stream no almacena datos; actúa sobre ellos en un pipeline (*flujo*).

---

## **2. Crear Streams**
Puedes crear Streams desde diferentes fuentes:
- **Colecciones:** `List`, `Set`, etc.
- **Arrays:** Con `Arrays.stream()`.
- **Datos generados:** Usando `Stream.generate()` o `Stream.iterate()`.

**Ejemplo: Crear Streams**
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreationExample {
    public static void main(String[] args) {
        // Desde una lista
        List<String> nombres = Arrays.asList("Ana", "Pedro", "Juan");
        Stream<String> streamDesdeLista = nombres.stream();

        // Desde un array
        String[] nombresArray = {"Luis", "Carla", "Mario"};
        Stream<String> streamDesdeArray = Arrays.stream(nombresArray);

        // Generar datos
        Stream<Integer> streamGenerado = Stream.iterate(1, n -> n + 1).limit(5); // [1, 2, 3, 4, 5]
        streamGenerado.forEach(System.out::println);
    }
}
```

---

## **3. Operaciones intermedias**
Estas transforman el Stream pero no lo consumen.

### **3.1. `filter`**
Filtra elementos que cumplen una condición.

**Ejemplo:** Filtrar números pares.
```java
import java.util.stream.IntStream;

public class FilterExample {
    public static void main(String[] args) {
        IntStream.range(1, 10) // Stream de 1 a 9
            .filter(n -> n % 2 == 0) // Solo pares
            .forEach(System.out::println); // Salida: 2, 4, 6, 8
    }
}
```

### **3.2. `map`**
Transforma cada elemento en otro.

**Ejemplo:** Convertir nombres a mayúsculas.
```java
import java.util.Arrays;
import java.util.List;

public class MapExample {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("ana", "pedro", "juan");
        nombres.stream()
            .map(String::toUpperCase) // Convertir a mayúsculas
            .forEach(System.out::println); // Salida: ANA, PEDRO, JUAN
    }
}
```

### **3.3. `sorted`**
Ordena los elementos.

**Ejemplo:** Ordenar una lista de números en orden inverso.
```java
import java.util.Arrays;

public class SortedExample {
    public static void main(String[] args) {
        Arrays.asList(5, 3, 8, 1).stream()
            .sorted((a, b) -> b - a) // Orden descendente
            .forEach(System.out::println); // Salida: 8, 5, 3, 1
    }
}
```

---

## **4. Operaciones terminales**
Estas producen un resultado o un efecto secundario y consumen el Stream.

### **4.1. `collect`**
Recoge los elementos en una estructura, como una lista o un mapa.

**Ejemplo:** Recoger nombres en una lista.
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Luis", "Carla", "Mario");
        List<String> nombresMayusculas = nombres.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        System.out.println(nombresMayusculas); // Salida: [LUIS, CARLA, MARIO]
    }
}
```

### **4.2. `reduce`**
Reduce los elementos a un solo valor aplicando una función asociativa.

**Ejemplo:** Sumar todos los números de un Stream.
```java
import java.util.stream.IntStream;

public class ReduceExample {
    public static void main(String[] args) {
        int suma = IntStream.range(1, 5) // Stream de 1 a 4
            .reduce(0, Integer::sum); // Suma de todos los números

        System.out.println(suma); // Salida: 10
    }
}
```

---

## **5. Operaciones avanzadas**

### **5.1. `flatMap`**
Descompone elementos complejos en subelementos y los combina en un único Stream.

**Ejemplo:** Procesar listas dentro de listas.
```java
import java.util.Arrays;
import java.util.List;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<String>> nombresAnidados = Arrays.asList(
            Arrays.asList("Ana", "Luis"),
            Arrays.asList("Pedro", "Carla")
        );

        nombresAnidados.stream()
            .flatMap(List::stream) // Descomponer las sublistas
            .forEach(System.out::println); // Salida: Ana, Luis, Pedro, Carla
    }
}
```

### **5.2. `groupingBy`**
Agrupa elementos según un criterio.

**Ejemplo:** Agrupar números por pares e impares.
```java
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExample {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        Map<String, List<Integer>> agrupados = numeros.stream()
            .collect(Collectors.groupingBy(
                n -> (n % 2 == 0) ? "Pares" : "Impares"
            ));

        System.out.println(agrupados); // Salida: {Impares=[1, 3, 5], Pares=[2, 4, 6]}
    }
}
```

---

## **6. Paralelismo en Streams**
Los Streams pueden ejecutarse en paralelo para mejorar el rendimiento, especialmente con grandes volúmenes de datos.

**Ejemplo:** Calcular el cuadrado de cada número en paralelo.
```java
import java.util.stream.IntStream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        IntStream.range(1, 10)
            .parallel() // Habilitar procesamiento paralelo
            .map(n -> n * n)
            .forEach(System.out::println);
    }
}
```

---

## **Resumen**
La Streams API permite realizar operaciones complejas sobre colecciones de datos de forma concisa y eficiente, gracias al enfoque funcional. Algunos aspectos avanzados como `flatMap`, `groupingBy` y paralelismo requieren práctica, pero son muy útiles para manejar escenarios complejos.
