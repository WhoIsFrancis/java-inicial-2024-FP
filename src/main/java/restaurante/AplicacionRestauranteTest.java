package restaurante;

import static org.assertj.core.api.Assertions.assertThat;

public class AplicacionRestauranteTest {

    public AplicacionRestauranteTest() {}

    void correrTests() {
        Comandable comanda;

        int pruebasPasadas = 0;
        int pruebasFallidas = 0;

        // Test 1
        try {
            comanda = setup();

            assertThat(comanda.recuperarCantidadDeComandasTotales()).isEqualTo(0);
            comanda.agregarComanda(new Comanda());
            assertThat(comanda.recuperarCantidadDeComandasTotales()).isEqualTo(1);
            pruebasPasadas++;
            System.out.println("Test 1 pasó");
        } catch (AssertionError e) {
            System.out.println("Test 1: " + e.getMessage() + "\n");
            pruebasFallidas++;
        }

        // Test 2
        try {
            comanda = setup();

            comanda.agregarComanda(new Comanda());
            comanda.agregarComanda(new Comanda());
            comanda.agregarComanda(new Comanda());

            assertThat(comanda.recuperarCantidadDeComandasTotales()).isEqualTo(3);
            pruebasPasadas++;
            System.out.println("Test 2 pasó");
        } catch (AssertionError e) {
            System.out.println("Test 2: " + e.getMessage() + "\n");
            pruebasFallidas++;
        }

        // Test 3
        try {
            comanda = setup();

            comanda.agregarComanda(new Comanda("Ceviche"));
            comanda.agregarComanda(new Comanda("Spaghetti"));
            comanda.agregarComanda(new Comanda("Asado"));

            Comanda ultimaComanda = comanda.recuperarUltimaComandaAgregada();

            assertThat(ultimaComanda.getDetalle()).isEqualTo("Asado");
            pruebasPasadas++;
            System.out.println("Test 3 pasó");
        } catch (AssertionError e) {
            System.out.println("Test 3: " + e.getMessage() + "\n");
            pruebasFallidas++;
        }

        // Test 4
        try {
            comanda = setup();

            comanda.agregarComanda(new Comanda("Ceviche"));
            comanda.agregarComanda(new Comanda("Spaghetti"));
            comanda.agregarComanda(new Comanda("Asado"));

            Comanda ultimaComanda = comanda.recuperarUltimaComandaAgregada();

            assertThat(ultimaComanda.getDetalle()).isEqualTo("Asado");

            comanda.eliminarUltimaComanda();

            ultimaComanda = comanda.recuperarUltimaComandaAgregada();

            assertThat(ultimaComanda.getDetalle()).isEqualTo("Spaghetti");

            pruebasPasadas++;
            System.out.println("Test 4 pasó");
        } catch (AssertionError e) {
            System.out.println("Test 4: " + e.getMessage() + "\n");
            pruebasFallidas++;
        }

        System.out.println("Pruebas pasadas: " + pruebasPasadas);
        System.out.println("Pruebas fallidas: " + pruebasFallidas);
    }

    public static void main(String[] args) {
        AplicacionRestauranteTest aplicacionRestauranteTest = new AplicacionRestauranteTest();
        aplicacionRestauranteTest.correrTests();
    }

    Comandable setup() {
        return new Pedido();
    }
}
