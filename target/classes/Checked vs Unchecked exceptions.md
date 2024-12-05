En Java, las **excepciones** se dividen en dos categorías principales: **checked exceptions** (excepciones comprobadas) y **unchecked exceptions** (excepciones no comprobadas). La diferencia principal radica en cómo el compilador las maneja y obliga al programador a tratarlas.

---

## **1. Checked Exceptions**
Son excepciones que el compilador **exige** que sean manejadas explícitamente usando un bloque `try-catch` o declarando que el método las lanza con `throws`.

### **Características:**
- Se heredan de la clase `Exception` (excluyendo a `RuntimeException` y sus subclases).
- El programador debe prever y manejar estas excepciones en tiempo de compilación.
- Generalmente representan errores **previsibles** en el entorno del programa (como problemas de E/S, conexiones de red, etc.).

### **Ejemplo:**
```java
import java.io.File;
import java.io.FileReader;

public class CheckedExample {
    public static void main(String[] args) {
        try {
            File archivo = new File("archivo_inexistente.txt");
            FileReader lector = new FileReader(archivo); // Puede lanzar FileNotFoundException
        } catch (java.io.FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado: " + e.getMessage());
        }
    }
}
```

En este caso:
- `FileNotFoundException` es una **checked exception**.
- El compilador obliga al uso de un bloque `try-catch` o al declarar `throws FileNotFoundException` en la firma del método.

---

## **2. Unchecked Exceptions**
Son excepciones que **no** son verificadas por el compilador. No es obligatorio manejarlas o declararlas en la firma del método.

### **Características:**
- Se heredan de la clase `RuntimeException`.
- Generalmente representan errores **lógicos** o problemas **imprevisibles** en tiempo de ejecución (como división por cero, acceso a índices inválidos en un array, etc.).
- Pueden ocurrir debido a errores en la lógica del programa o al no validar correctamente los datos.

### **Ejemplo:**
```java
public class UncheckedExample {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3};
        System.out.println(numeros[3]); // ArrayIndexOutOfBoundsException
    }
}
```

En este caso:
- `ArrayIndexOutOfBoundsException` es una **unchecked exception**.
- El compilador **no obliga** a manejar esta excepción, pero si ocurre, el programa fallará en tiempo de ejecución.

---

## **Diferencias clave entre Checked y Unchecked Exceptions**

| **Aspecto**                  | **Checked Exceptions**                          | **Unchecked Exceptions**                          |
|-------------------------------|------------------------------------------------|--------------------------------------------------|
| **Jerarquía**                 | Heredan de `Exception` (excepto `RuntimeException`). | Heredan de `RuntimeException`.                  |
| **Verificación del compilador** | Obligatorio manejarlas (`try-catch` o `throws`). | No es obligatorio manejarlas.                   |
| **Errores representados**     | Problemas externos/previsibles (E/S, conexiones). | Errores lógicos/imprevisibles (índices, null).   |
| **Impacto en el código**      | Fuerzan a manejar los errores explícitamente.    | Pueden ignorarse, pero podrían causar fallos.    |

---

## **3. Ejemplo práctico con ambas excepciones**

```java
public class ExceptionExample {
    public static void main(String[] args) {
        // Ejemplo de checked exception
        try {
            leerArchivo();
        } catch (java.io.IOException e) {
            System.out.println("Error manejado: " + e.getMessage());
        }

        // Ejemplo de unchecked exception
        try {
            dividirPorCero();
        } catch (ArithmeticException e) {
            System.out.println("Error manejado: " + e.getMessage());
        }
    }

    // Método que lanza una checked exception
    public static void leerArchivo() throws java.io.IOException {
        throw new java.io.IOException("Error al leer el archivo");
    }

    // Método que lanza una unchecked exception
    public static void dividirPorCero() {
        int resultado = 10 / 0; // ArithmeticException
    }
}
```

**Salida esperada:**
```
Error manejado: Error al leer el archivo
Error manejado: / by zero
```

---

## **4. Cuándo usar cada tipo de excepción**

- **Usa Checked Exceptions cuando:**
    - El error **puede preverse** y tiene sentido que el programador lo maneje (por ejemplo, problemas de red, E/S de archivos).
    - Deseas forzar a los usuarios de tu API a manejar excepciones críticas.

- **Usa Unchecked Exceptions cuando:**
    - El error ocurre debido a errores de programación (por ejemplo, división por cero, punteros nulos, índices inválidos).
    - Manejar el error no es obligatorio, pero se debe prevenir con validaciones.

---
