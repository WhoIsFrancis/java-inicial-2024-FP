Ejemplos **intermedios** de uso de las estructuras `if`, `if-else`, `else if` y `switch` en **Java 15**, incluyendo características específicas de esta versión como *Pattern Matching para `instanceof`* y el uso de `switch` como expresión.

---

### **1. Uso intermedio de `if`**
Un ejemplo que utiliza lógica básica y operadores lógicos para validar múltiples condiciones.

```java
import java.util.Scanner;

public class IfExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su edad: ");
        int age = scanner.nextInt();

        // Validación simple con operadores lógicos
        if (age >= 18 && age <= 60) {
            System.out.println("Eres un adulto en edad laboral.");
        }

        // Validación inversa
        if (!(age >= 18 && age <= 60)) {
            System.out.println("No estás en edad laboral.");
        }

        scanner.close();
    }
}
```

---

### **2. Uso intermedio de `if-else`**
Un ejemplo que implementa un sistema básico de calificaciones basado en rangos de puntajes.

```java
import java.util.Scanner;

public class IfElseExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su puntaje (0-100): ");
        int score = scanner.nextInt();

        if (score >= 90) {
            System.out.println("Calificación: A");
        } else if (score >= 80) {
            System.out.println("Calificación: B");
        } else if (score >= 70) {
            System.out.println("Calificación: C");
        } else if (score >= 60) {
            System.out.println("Calificación: D");
        } else {
            System.out.println("Calificación: F");
        }

        scanner.close();
    }
}
```

---

### **3. Uso intermedio de `else if`**
Un programa que clasifica números en varias categorías con condiciones jerárquicas.

```java
import java.util.Scanner;

public class ElseIfExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número: ");
        int number = scanner.nextInt();

        if (number > 0) {
            System.out.println("El número es positivo.");
        } else if (number < 0) {
            System.out.println("El número es negativo.");
        } else {
            System.out.println("El número es cero.");
        }

        scanner.close();
    }
}
```

---

### **4. Uso intermedio de `switch` tradicional**
Un programa que usa un `switch` para manejar opciones de un menú básico.

```java
import java.util.Scanner;

public class SwitchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione una opción:");
        System.out.println("1. Iniciar");
        System.out.println("2. Pausar");
        System.out.println("3. Detener");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("Iniciando...");
                break;
            case 2:
                System.out.println("Pausando...");
                break;
            case 3:
                System.out.println("Deteniendo...");
                break;
            default:
                System.out.println("Opción no válida.");
        }

        scanner.close();
    }
}
```

---

### **5. Uso intermedio de `switch` como expresión (Java 15)**
Un ejemplo que convierte un número en su representación textual usando la expresión de `switch`.

```java
import java.util.Scanner;

public class SwitchExpressionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número del 1 al 3: ");
        int number = scanner.nextInt();

        // Usando switch como expresión
        String text = switch (number) {
            case 1 -> "Uno";
            case 2 -> "Dos";
            case 3 -> "Tres";
            default -> "Número no válido";
        };

        System.out.println("El número ingresado es: " + text);

        scanner.close();
    }
}
```

---

### **6. Uso de `if` combinado con `switch`**
Un ejemplo que maneja múltiples condiciones antes de pasar a un `switch`.

```java
import java.util.Scanner;

public class IfSwitchCombo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su edad: ");
        int age = scanner.nextInt();

        if (age < 0) {
            System.out.println("La edad no puede ser negativa.");
        } else if (age >= 18) {
            System.out.println("Seleccione una actividad:");
            System.out.println("1. Trabajar");
            System.out.println("2. Estudiar");
            System.out.println("3. Descansar");

            int activity = scanner.nextInt();

            switch (activity) {
                case 1 -> System.out.println("Has elegido trabajar.");
                case 2 -> System.out.println("Has elegido estudiar.");
                case 3 -> System.out.println("Has elegido descansar.");
                default -> System.out.println("Opción no válida.");
            }
        } else {
            System.out.println("Eres menor de edad, disfruta tu infancia.");
        }

        scanner.close();
    }
}
```

---

Estos ejemplos muestran cómo puedes usar las estructuras de control de flujo en **Java 15** de forma intermedia, incluyendo características modernas como `switch` como expresión para simplificar el manejo de opciones. 


---


Ejemplos **intermedios** de las estructuras de control `do`, `do-while`, `for`, `while` y el uso de las sentencias `break` y `continue` en **Java 15**. Los ejemplos combinan lógica práctica con buenas prácticas de programación.

---

### **1. Estructura `do`**
Un ejemplo que solicita al usuario un número positivo y lo verifica en cada iteración.

```java
import java.util.Scanner;

public class DoExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        do {
            System.out.print("Ingrese un número positivo: ");
            number = scanner.nextInt();
            if (number < 0) {
                System.out.println("El número no es positivo. Intente de nuevo.");
            }
        } while (number < 0);

        System.out.println("¡Número positivo ingresado: " + number + "!");
        scanner.close();
    }
}
```

---

### **2. Estructura `do-while`**
Un programa que realiza un cálculo iterativo hasta que el usuario decida detenerse.

```java
import java.util.Scanner;

public class DoWhileExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        int sum = 0;

        do {
            System.out.print("Ingrese un número para sumar: ");
            int number = scanner.nextInt();
            sum += number;

            System.out.print("¿Desea ingresar otro número? (sí/no): ");
            choice = scanner.next();

        } while (choice.equalsIgnoreCase("sí"));

        System.out.println("La suma total es: " + sum);
        scanner.close();
    }
}
```

---

### **3. Estructura `for`**
Un programa que imprime la tabla de multiplicar de un número ingresado por el usuario.

```java
import java.util.Scanner;

public class ForExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número para calcular su tabla de multiplicar: ");
        int number = scanner.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }

        scanner.close();
    }
}
```

---

### **4. Estructura `while`**
Un programa que calcula la potencia de un número utilizando multiplicación repetida.

```java
import java.util.Scanner;

public class WhileExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la base: ");
        int base = scanner.nextInt();
        System.out.print("Ingrese el exponente: ");
        int exponent = scanner.nextInt();

        int result = 1;
        int count = 0;

        while (count < exponent) {
            result *= base;
            count++;
        }

        System.out.println("El resultado de " + base + " elevado a la " + exponent + " es: " + result);
        scanner.close();
    }
}
```

---

### **5. Sentencia `break`**
Un ejemplo que busca un número en una lista y detiene la búsqueda al encontrarlo.

```java
public class BreakExample {
    public static void main(String[] args) {
        int[] numbers = {3, 8, 15, 23, 42, 56, 78};
        int target = 23;

        for (int num : numbers) {
            if (num == target) {
                System.out.println("¡Número encontrado: " + num + "!");
                break; // Salir del bucle una vez encontrado
            }
            System.out.println("Revisando número: " + num);
        }
    }
}
```

---

### **6. Sentencia `continue`**
Un programa que imprime solo los números impares en un rango.

```java
public class ContinueExample {
    public static void main(String[] args) {
        System.out.println("Números impares entre 1 y 10:");

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // Saltar el resto de la iteración para números pares
            }
            System.out.println(i);
        }
    }
}
```

---

### **7. Uso combinado de `break` y `continue`**
Un programa que calcula la suma de números hasta que el usuario ingrese un número negativo, pero omite los múltiplos de 3.

```java
import java.util.Scanner;

public class BreakContinueExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        while (true) {
            System.out.print("Ingrese un número (negativo para terminar): ");
            int number = scanner.nextInt();

            if (number < 0) {
                break; // Salir del bucle si el número es negativo
            }

            if (number % 3 == 0) {
                continue; // Saltar los números múltiplos de 3
            }

            sum += number;
        }

        System.out.println("La suma total (sin múltiplos de 3) es: " + sum);
        scanner.close();
    }
}
```

---

Estos ejemplos muestran cómo manejar tareas intermedias utilizando las estructuras de control clásicas y las sentencias `break` y `continue`. 