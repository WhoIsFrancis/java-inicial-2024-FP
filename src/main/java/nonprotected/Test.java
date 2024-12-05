package nonprotected;

import protectedexample.Finanzas;

public class Test {
    public static void main(String[] args) {
        Finanzas finanzas  = new Finanzas();
        SubClaseDeFinanzas subClaseDeFinanzas  = new SubClaseDeFinanzas();
        subClaseDeFinanzas.getMonto();
    }
}

