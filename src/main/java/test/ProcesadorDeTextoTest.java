package test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProcesadorDeTextoTest {

    public ProcesadorDeTextoTest() {
    }

    public void correrTests() {
        AnalizadorDeTexto procesadorDeTexto = new ProcesadorDeTexto();

        int pruebasPasadas = 0;
        int pruebasFallidas = 0;

        String texto = "\"Los músicos tienen la costumbre de volver eterna a la vida: en su arte, " +
                "nos devuelven el tiempo, nos enseñan a escuchar el mundo. La música es el sonido de la memoria; " +
                "es ese lenguaje universal que despierta la alegría que nos habita, aunque a veces no sabemos que " +
                "la tenemos. ¿Quién no se reconoce en una canción? " +
                "¿Quién no se ha perdido alguna vez en la infinita belleza de una melodía?\n" +
                "\n" + "Sin música, la vida sería silencio y los sueños, sombras que se desvanecen. " +
                "¡Que suene, que resuene... que nos recuerde quiénes somos y quiénes fuimos!\"";

        try {
            assertThat(procesadorDeTexto.getCantidadDePalabras(texto)).isEqualTo(97);
            pruebasPasadas++;
            System.out.println("1 passed");
        } catch (AssertionError e) {
            System.out.println("Test 1: " + e.getMessage() + "\n");
            pruebasFallidas++;
        }

        try {
            assertThat(procesadorDeTexto.getCantidadDePalabras(texto)).isNotEqualTo(96);
            pruebasPasadas++;
            System.out.println("1.b passed");
        } catch (AssertionError e) {
            System.out.println("Test 1.b: " + e.getMessage() + "\n");
            pruebasFallidas++;
        }

        /*try {
            assertThat(procesadorDeTexto.getCantidadDeVocales(texto)).isEqualTo(207);
            pruebasPasadas++;
            System.out.println("2 passed");
        } catch (AssertionError e) {
            System.out.println("Test 2: " + e.getMessage() + "\n");
            pruebasFallidas++;
        }

        try {
            assertThat(procesadorDeTexto.getCantidadDeConsonantes(texto)).isEqualTo(217);
            pruebasPasadas++;
            System.out.println("3 passed");
        } catch (AssertionError e) {
            System.out.println("Test 3: " + e.getMessage() + "\n");
            pruebasFallidas++;
        }

        try {
            assertThat(procesadorDeTexto.getCantidadDeSignosDePuntuacion(texto)).isEqualTo(17);
            pruebasPasadas++;
            System.out.println("4 passed");
        } catch (AssertionError e) {
            System.out.println("Test 4: " + e.getMessage() + "\n");
            pruebasFallidas++;
        }

        try {
            assertThat(procesadorDeTexto.getCantidadDeCaracteres(texto)).isEqualTo(543);
            pruebasPasadas++;
            System.out.println("5 passed");
        } catch (AssertionError e) {
            System.out.println("Test 5: " + e.getMessage() + "\n");
            pruebasFallidas++;
        }

        try {
            assertThat(procesadorDeTexto.getCantidadDeMayusculas(texto)).isEqualTo(6);
            pruebasPasadas++;
            System.out.println("6 passed");
        } catch (AssertionError e) {
            System.out.println("Test 6: " + e.getMessage() + "\n");
            pruebasFallidas++;
        }

        try {
            assertThat(procesadorDeTexto.reemplazarPalabraPorOtra("la", "lx")).isNotEmpty();
            pruebasPasadas++;
            System.out.println("7 passed");
        } catch (AssertionError e) {
            System.out.println("Test 7: " + e.getMessage() + "\n");
            pruebasFallidas++;
        }

        try {
            assertThat(procesadorDeTexto.getListadoDePalabrasSinRepetirse(texto).size()).isGreaterThan(0);
            pruebasPasadas++;
            System.out.println("8 passed");
        } catch (AssertionError e) {
            System.out.println("Test 8: " + e.getMessage() + "\n");
            pruebasFallidas++;
        }*/

        System.out.println("Pruebas pasadas: " + pruebasPasadas);
        System.out.println("Pruebas fallidas: " + pruebasFallidas);
    }

    public static void main(String[] args) {
        ProcesadorDeTextoTest test = new ProcesadorDeTextoTest();
        test.correrTests();
    }
}
