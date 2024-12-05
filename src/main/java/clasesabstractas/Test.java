package clasesabstractas;

public class Test {
    public static void main(String[] args) {
        MiClase miClase = new MiClase();
        miClase.metodo();
    }
}

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
