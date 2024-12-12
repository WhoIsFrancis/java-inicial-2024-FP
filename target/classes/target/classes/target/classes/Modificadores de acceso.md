Los **modificadores de acceso** en Java determinan la visibilidad y el alcance de clases, métodos, atributos y constructores dentro de un programa. Son fundamentales para controlar cómo las diferentes partes de un programa interactúan entre sí, ayudando a proteger los datos y modularizar el código.

Java tiene cuatro niveles principales de acceso:

1. **`public`**
2. **`protected`**
3. **(default)** (sin modificador, también llamado "package-private")
4. **`private`**

---

## **1. `public`**
Un miembro o clase declarado como `public` es accesible desde cualquier lugar del programa. Este modificador otorga la mayor visibilidad.

### **Ejemplo:**
```java
public class ClasePublica {
    public String atributoPublico = "Accesible desde cualquier lugar";

    public void metodoPublico() {
        System.out.println("Este método es público.");
    }
}
```

**Uso:**
```java
public class Main {
    public static void main(String[] args) {
        ClasePublica obj = new ClasePublica();
        System.out.println(obj.atributoPublico); // Salida: Accesible desde cualquier lugar
        obj.metodoPublico(); // Salida: Este método es público.
    }
}
```

**Restricciones:**
- Una clase `public` debe tener el mismo nombre que el archivo donde se encuentra.
- Solo puede haber una clase `public` por archivo.

---

## **2. `protected`**
Un miembro declarado como `protected` es accesible:
- Dentro de la misma clase.
- Dentro del mismo paquete.
- En clases hijas (subclases), incluso si están en paquetes diferentes.

### **Ejemplo:**
```java
public class ClaseBase {
    protected String atributoProtegido = "Accesible en subclases o mismo paquete";

    protected void metodoProtegido() {
        System.out.println("Este método es protegido.");
    }
}

class Subclase extends ClaseBase {
    public void mostrarAtributo() {
        System.out.println(atributoProtegido); // Acceso permitido
        metodoProtegido(); // Acceso permitido
    }
}
```

**Uso:**
```java
public class Main {
    public static void main(String[] args) {
        Subclase obj = new Subclase();
        obj.mostrarAtributo(); // Salida: Accesible en subclases o mismo paquete
                               //         Este método es protegido.
    }
}
```

---

## **3. Default (package-private)**
Si no especificas ningún modificador de acceso, se aplica el nivel de acceso **predeterminado**, también conocido como *package-private*. Esto significa que el miembro o clase es accesible solo dentro del mismo paquete.

### **Ejemplo:**
```java
class ClaseDefault {
    String atributoDefault = "Solo accesible dentro del paquete";

    void metodoDefault() {
        System.out.println("Este método tiene acceso predeterminado.");
    }
}
```

**Uso:**
```java
public class Main {
    public static void main(String[] args) {
        ClaseDefault obj = new ClaseDefault();
        System.out.println(obj.atributoDefault); // Salida: Solo accesible dentro del paquete
        obj.metodoDefault(); // Salida: Este método tiene acceso predeterminado.
    }
}
```

**Nota:**  
Si intentas acceder a `ClaseDefault` desde un paquete diferente, obtendrás un error de compilación.

---

## **4. `private`**
Un miembro declarado como `private` solo es accesible dentro de la misma clase. Este es el nivel de acceso más restrictivo y se utiliza para encapsular datos.

### **Ejemplo:**
```java
public class ClasePrivada {
    private String atributoPrivado = "Solo accesible dentro de esta clase";

    private void metodoPrivado() {
        System.out.println("Este método es privado.");
    }

    public void mostrarPrivados() {
        System.out.println(atributoPrivado); // Acceso permitido dentro de la clase
        metodoPrivado(); // Acceso permitido dentro de la clase
    }
}
```

**Uso:**
```java
public class Main {
    public static void main(String[] args) {
        ClasePrivada obj = new ClasePrivada();
        // System.out.println(obj.atributoPrivado); // Error: no es accesible
        // obj.metodoPrivado(); // Error: no es accesible
        obj.mostrarPrivados(); // Salida: Solo accesible dentro de esta clase
                               //         Este método es privado.
    }
}
```

---

## **Resumen de los niveles de acceso**

| **Nivel de acceso** | **Misma clase** | **Mismo paquete** | **Subclases (otros paquetes)** | **Cualquier lugar** |
|----------------------|-----------------|-------------------|---------------------------------|----------------------|
| `public`            | ✅              | ✅                | ✅                              | ✅                   |
| `protected`         | ✅              | ✅                | ✅                              | ❌                   |
| Default (*package-private*) | ✅       | ✅                | ❌                              | ❌                   |
| `private`           | ✅              | ❌                | ❌                              | ❌                   |

---

## **Casos prácticos de uso**
1. **Encapsulación de datos con `private`:**
   Los atributos de clase suelen ser `private` para proteger los datos, y se accede a ellos mediante métodos públicos como *getters* y *setters*:
   ```java
   public class Persona {
       private String nombre;

       public String getNombre() {
           return nombre;
       }

       public void setNombre(String nombre) {
           this.nombre = nombre;
       }
   }
   ```

2. **Definición de APIs públicas con `public`:**
   Los métodos `public` suelen utilizarse para exponer funcionalidades clave a otras clases:
   ```java
   public class Calculadora {
       public int sumar(int a, int b) {
           return a + b;
       }
   }
   ```

3. **Restricción a subclases con `protected`:**
   Métodos que deben ser implementados o extendidos por subclases, pero no expuestos públicamente:
   ```java
   abstract class Animal {
       protected abstract void hacerSonido();
   }
   ```

4. **Organización modular con `default`:**
   Las clases y métodos predeterminados facilitan el trabajo dentro de un paquete sin exponerlos globalmente:
   ```java
   class Utilidades {
       static String formatearTexto(String texto) {
           return texto.trim().toUpperCase();
       }
   }
   ```
   