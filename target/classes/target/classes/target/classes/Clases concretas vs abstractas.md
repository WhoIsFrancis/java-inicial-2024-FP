En Java, tanto las **clases concretas** como las **clases abstractas** son fundamentales para la programación orientada a objetos. Sirven para organizar y reutilizar el código, pero tienen diferencias significativas en términos de funcionalidad, propósito y restricciones.

---

## **1. Clase concreta**
Una **clase concreta** es una clase normal que puedes instanciar (crear objetos a partir de ella). Contiene implementaciones completas de métodos, y puede incluir constructores, campos y métodos.

### **Características de una clase concreta:**
- Se puede instanciar.
- Puede tener métodos y atributos concretos (implementados).
- Puede heredar de otras clases o implementar interfaces.

### **Ejemplo de clase concreta:**
```java
public class Perro {
    private String nombre;

    public Perro(String nombre) {
        this.nombre = nombre;
    }

    public void ladrar() {
        System.out.println(nombre + " está ladrando.");
    }
}
```

### Uso:
```java
public class Main {
    public static void main(String[] args) {
        Perro miPerro = new Perro("Fido");
        miPerro.ladrar(); // Salida: Fido está ladrando.
    }
}
```

---

## **2. Clase abstracta**
Una **clase abstracta** es una clase que no se puede instanciar directamente. Está diseñada para ser extendida por otras clases y puede contener métodos **abstractos** (sin implementación) y **concretos** (con implementación).

### **Características de una clase abstracta:**
- **No se puede instanciar directamente.**
- Puede tener métodos abstractos (sin cuerpo), que las subclases deben implementar.
- Puede tener métodos concretos, que las subclases heredan tal cual o sobrescriben.
- Puede tener constructores, aunque solo pueden ser llamados por las subclases.
- Se define con la palabra clave `abstract`.

### **Ejemplo de clase abstracta:**
```java
public abstract class Animal {
    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Método abstracto: las subclases deben implementarlo.
    public abstract void hacerSonido();
}
```

### Subclases:
```java
public class Gato extends Animal {
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " dice: Miau.");
    }
}

public class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " dice: Guau.");
    }
}
```

### Uso:
```java
public class Main {
    public static void main(String[] args) {
        Animal miGato = new Gato("Tom");
        Animal miPerro = new Perro("Rex");

        miGato.hacerSonido(); // Salida: Tom dice: Miau.
        miPerro.hacerSonido(); // Salida: Rex dice: Guau.
    }
}
```

---

## **Clases abstractas vs clases concretas**

| **Aspecto**              | **Clase concreta**                      | **Clase abstracta**                      |
|---------------------------|------------------------------------------|-------------------------------------------|
| **Instanciación**         | Se puede instanciar.                    | No se puede instanciar directamente.      |
| **Métodos abstractos**    | No puede tener métodos abstractos.      | Puede tener métodos abstractos.           |
| **Propósito principal**   | Proveer implementaciones completas.     | Proveer una base común y obligar a implementar métodos específicos. |
| **Extensibilidad**        | Puede extender otra clase concreta o abstracta. | Debe ser extendida por una clase concreta. |
| **Interfaces**            | Puede implementar interfaces.           | Puede implementar interfaces.             |

---

## **Novedades de Java 8: Interfaces vs Clases Abstractas**
En Java 8, las **interfaces** también pueden tener métodos concretos gracias a los **métodos predeterminados** (*default methods*). Esto reduce algunos casos de uso de clases abstractas.

### Diferencias clave entre interfaces y clases abstractas:
1. **Herencia múltiple:**
    - Una clase concreta puede implementar múltiples interfaces, pero solo puede extender una clase abstracta.
    - Ejemplo:
      ```java
      interface A {
          default void metodo() {
              System.out.println("Método de A");
          }
      }
 
      interface B {
          default void metodo() {
              System.out.println("Método de B");
          }
      }
 
      class MiClase implements A, B {
          @Override
          public void metodo() {
              A.super.metodo(); // Resuelve conflictos llamando a A
          }
      }
      ```

2. **Constructores:**
    - Las clases abstractas pueden tener constructores.
    - Las interfaces no pueden tener constructores.

3. **Campos:**
    - Las clases abstractas pueden tener campos con cualquier modificador de acceso.
    - Las interfaces solo pueden tener campos `public static final` (constantes).

4. **Compatibilidad binaria:**
    - Los métodos `default` de las interfaces permiten agregar nuevas funcionalidades sin romper clases existentes que ya las implementen. Esto no es posible con clases abstractas.

---

### Ejemplo combinado:
```java
interface Volador {
    default void volar() {
        System.out.println("Estoy volando!");
    }
}

abstract class Ave {
    private String nombre;

    public Ave(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void hacerSonido();
}

class Aguila extends Ave implements Volador {
    public Aguila(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " dice: Scree!");
    }
}

public class Main {
    public static void main(String[] args) {
        Aguila aguila = new Aguila("Águila Real");
        aguila.hacerSonido(); // Salida: Águila Real dice: Scree!
        aguila.volar();       // Salida: Estoy volando!
    }
}
```
