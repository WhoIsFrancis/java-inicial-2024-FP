
Ejemplos **intermedios** de generación de salida de texto en Java 8 utilizando las librerías del núcleo de Java. Estos ejemplos demuestran cómo formatear texto, usar flujos de datos y manejar datos complejos para generar salidas.

---

### **1. Formateo básico con `String.format`**
Uso de formato para generar salidas estructuradas.

```java
public class StringFormatExample {
    public static void main(String[] args) {
        String name = "Grace";
        int age = 29;
        double salary = 55000.75;

        // Formateo de texto
        String formattedText = String.format("Nombre: %s, Edad: %d, Salario: $%.2f", name, age, salary);

        // Salida
        System.out.println(formattedText);
    }
}
```

---

### **2. Uso de `System.out.printf`**
Genera salidas con formato en consola directamente.

```java
public class PrintfExample {
    public static void main(String[] args) {
        System.out.printf("Tabla de multiplicar del %d:\n", 5);

        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d\n", 5, i, 5 * i);
        }
    }
}
```

---

### **3. Escribir en un archivo de texto con `FileWriter`**
Genera un archivo de texto con contenido dinámico.

```java
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        String content = "Esto es un ejemplo de escritura en un archivo.\n¡Java es genial!";

        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(content);
            System.out.println("Archivo escrito exitosamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    }
}
```

---

### **4. Escribir datos estructurados con `PrintWriter`**
Ejemplo para generar un archivo de texto con formato estructurado.

```java
import java.io.PrintWriter;
import java.io.IOException;

public class PrintWriterExample {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter("table.txt")) {
            writer.printf("%-10s %-10s %-10s\n", "Producto", "Cantidad", "Precio");
            writer.printf("%-10s %-10d $%-10.2f\n", "Manzanas", 10, 3.50);
            writer.printf("%-10s %-10d $%-10.2f\n", "Naranjas", 8, 4.20);
            writer.printf("%-10s %-10d $%-10.2f\n", "Peras", 5, 2.80);

            System.out.println("Archivo 'table.txt' generado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
```

---

### **5. Uso de `StringBuilder` para salida acumulativa**
Concatenar texto dinámicamente y generar una salida eficiente.

```java
public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder report = new StringBuilder();

        report.append("Reporte de Ventas\n");
        report.append("==================\n");

        String[] products = {"Manzanas", "Naranjas", "Peras"};
        int[] quantities = {10, 8, 5};
        double[] prices = {3.50, 4.20, 2.80};

        for (int i = 0; i < products.length; i++) {
            report.append(String.format("%-10s: %d unidades a $%.2f cada una.\n", 
                                        products[i], quantities[i], prices[i]));
        }

        System.out.println(report.toString());
    }
}
```

---

### **6. Generar salida en consola con `Stream` (Java 8)**
Uso de `Stream` para formatear y mostrar información.

```java
import java.util.Arrays;
import java.util.List;

public class StreamOutputExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Grace", "John", "Sarah", "Michael");

        System.out.println("Lista de nombres:");
        names.stream()
             .map(name -> "-> " + name)
             .forEach(System.out::println);
    }
}
```

---

### **7. Uso de `Formatter` para personalización avanzada**
Generar texto con formatos complejos y almacenar en una salida específica.

```java
import java.util.Formatter;

public class FormatterExample {
    public static void main(String[] args) {
        try (Formatter formatter = new Formatter("formatted_output.txt")) {
            formatter.format("%-10s %-10s %-10s\n", "Producto", "Cantidad", "Precio");
            formatter.format("%-10s %-10d $%-10.2f\n", "Manzanas", 10, 3.50);
            formatter.format("%-10s %-10d $%-10.2f\n", "Naranjas", 8, 4.20);
            formatter.format("%-10s %-10d $%-10.2f\n", "Peras", 5, 2.80);

            System.out.println("Archivo 'formatted_output.txt' generado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

---

### **8. Creación de un log básico con `Console`**
Utiliza la clase `Console` para manejar la entrada y salida de forma dinámica.

```java
import java.io.Console;

public class ConsoleExample {
    public static void main(String[] args) {
        Console console = System.console();
        if (console != null) {
            console.printf("Bienvenido al sistema.\n");

            String username = console.readLine("Ingrese su nombre de usuario: ");
            char[] password = console.readPassword("Ingrese su contraseña: ");

            console.printf("Usuario '%s' autenticado.\n", username);
        } else {
            System.out.println("La consola no está disponible.");
        }
    }
}
```

---

### **9. Salida con múltiples formatos en consola**
Un ejemplo que mezcla formato condicional para generar salidas dinámicas.

```java
import java.util.Scanner;

public class ConditionalOutputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String name = scanner.nextLine();

        System.out.print("Ingrese su puntaje: ");
        int score = scanner.nextInt();

        System.out.printf("Hola, %s. ", name);

        if (score >= 90) {
            System.out.println("¡Excelente trabajo! Eres un estudiante sobresaliente.");
        } else if (score >= 70) {
            System.out.println("Buen trabajo, pero hay margen para mejorar.");
        } else {
            System.out.println("No te desanimes, sigue esforzándote.");
        }

        scanner.close();
    }
}
```

---

Estos ejemplos combinan diversas técnicas para generar salidas tanto en consola como en archivos de texto.

Tabla y explicaciones para los **formatos disponibles** en cada uno de los ejemplos anteriores, junto con recomendaciones de uso y ejemplos.

---

### **Tabla de formatos**

| Método/Formato               | Descripción                                                                                     | Ejemplo                                  |
|------------------------------|-------------------------------------------------------------------------------------------------|------------------------------------------|
| `%s`                         | Cadena de texto (string).                                                                      | `"Hola %s", "Grace"` → `"Hola Grace"`    |
| `%d`                         | Número entero (decimal).                                                                       | `"Edad: %d", 29` → `"Edad: 29"`          |
| `%f`                         | Número de punto flotante (decimal).                                                           | `"%.2f", 3.14159` → `"3.14"`             |
| `%n`                         | Nueva línea.                                                                                  | `"Primera línea%nSegunda línea"`         |
| `%x`                         | Entero en formato hexadecimal.                                                                | `"%x", 255` → `"ff"`                     |
| `%o`                         | Entero en formato octal.                                                                      | `"%o", 8` → `"10"`                       |
| `%b`                         | Booleano (true/false).                                                                        | `"%b", true` → `"true"`                  |
| `%c`                         | Carácter (char).                                                                              | `"%c", 'A'` → `"A"`                      |
| `%-10s`                      | Ajusta la longitud del texto a 10 caracteres, alineado a la izquierda.                        | `"%-10s", "Hola"` → `"Hola      "`       |
| `%10.2f`                     | Ajusta un número flotante a una longitud total de 10 caracteres con 2 decimales.              | `"%10.2f", 123.456` → `"    123.46"`     |

---

### **Explicación y ejemplos por caso**

#### **1. `String.format`**

El método `String.format` permite generar cadenas con formato, útil para almacenar o manipular texto antes de imprimir.

##### Formatos disponibles:
- `%s` (texto), `%d` (números enteros), `%f` (flotantes).

##### Ejemplo adicional:
```java
String formattedText = String.format("Hola %s, tienes %d años y tu saldo es $%.2f", "Grace", 29, 1234.56);
// Resultado: "Hola Grace, tienes 29 años y tu saldo es $1234.56"
```

##### **¿Cuándo usarlo?**
- Al generar textos que necesiten combinar datos dinámicos (nombres, edades, etc.).
- Útil para crear cadenas listas para ser almacenadas o procesadas.

---

#### **2. `System.out.printf`**

Se utiliza para imprimir texto formateado directamente en la consola.

##### Formatos disponibles:
- Todos los mencionados en la tabla, incluidos `%n` (nueva línea) y alineaciones.

##### Ejemplo adicional:
```java
System.out.printf("Producto: %-10s Precio: $%10.2f%n", "Manzanas", 3.5);
// Resultado:
// Producto: Manzanas   Precio: $      3.50
```

##### **¿Cuándo usarlo?**
- Ideal para mostrar información directamente en la consola con alineaciones.
- Útil en reportes o tablas simples.

---

#### **3. `FileWriter`**

Escribe texto sin formato en un archivo. Aquí, debes construir manualmente las cadenas antes de escribirlas.

##### Formatos disponibles:
- No aplica formatos automáticamente, pero puedes usar `String.format` o concatenar texto.

##### Ejemplo adicional:
```java
FileWriter writer = new FileWriter("output.txt");
writer.write(String.format("Nombre: %s, Edad: %d%n", "Grace", 29));
```

##### **¿Cuándo usarlo?**
- Para generar archivos de texto simples sin necesidad de alineaciones complejas.
- Cuando prefieras controlar el formato con otras funciones (como `String.format`).

---

#### **4. `PrintWriter`**

Permite escribir texto formateado en archivos con soporte directo para los mismos formatos que `printf`.

##### Formatos disponibles:
- Los mismos que `System.out.printf`.

##### Ejemplo adicional:
```java
PrintWriter writer = new PrintWriter("table.txt");
writer.printf("%-10s %-10s %-10s%n", "Producto", "Cantidad", "Precio");
// Producto   Cantidad   Precio    
// Manzanas   10         $ 3.50   
```

##### **¿Cuándo usarlo?**
- Cuando necesites escribir tablas o reportes con formatos en archivos.

---

#### **5. `StringBuilder`**

Acumula texto de manera eficiente. Úsalo para construir cadenas grandes antes de imprimirlas o guardarlas.

##### Formatos disponibles:
- Usa `String.format` para combinar datos dinámicos dentro del acumulador.

##### Ejemplo adicional:
```java
StringBuilder builder = new StringBuilder();
builder.append(String.format("Producto: %s - Precio: $%.2f%n", "Manzanas", 3.50));
System.out.println(builder.toString());
```

##### **¿Cuándo usarlo?**
- Para evitar el uso intensivo de concatenaciones de cadenas.
- Al construir texto dinámico de gran tamaño.

---

#### **6. `Stream` (Java 8)**

Se utiliza para procesar y formatear datos dinámicamente. Puede usarse con `map` y `forEach`.

##### Formatos disponibles:
- Puedes usar `String.format` o concatenar directamente en cada elemento.

##### Ejemplo adicional:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
numbers.stream()
       .map(n -> String.format("Número: %d", n))
       .forEach(System.out::println);
```

##### **¿Cuándo usarlo?**
- Para procesar listas o colecciones de manera funcional.
- Ideal en proyectos que usan colecciones dinámicas.

---

#### **7. `Formatter`**

Permite escribir texto con formato avanzado en archivos o salidas específicas.

##### Formatos disponibles:
- Todos los mencionados en la tabla.

##### Ejemplo adicional:
```java
Formatter formatter = new Formatter("formatted_output.txt");
formatter.format("Hola %s, tu puntaje es %d%n", "Grace", 95);
```

##### **¿Cuándo usarlo?**
- Cuando necesites un control detallado de la salida, especialmente en archivos formateados.

---

#### **8. `Console`**

Permite manejar entrada/salida directamente en la consola.

##### Formatos disponibles:
- Igual que `printf` (`%s`, `%d`, `%f`, etc.).

##### Ejemplo adicional:
```java
Console console = System.console();
console.printf("Bienvenido %s, tu saldo es $%.2f%n", "Grace", 123.45);
```

##### **¿Cuándo usarlo?**
- Para aplicaciones interactivas que utilicen la consola directamente.

---
