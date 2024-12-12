package tp1;

public class Aplicacion {
    public static void main(String[] args) {
        IMenu iMenu = new MenuImpl();
        boolean continuar = true;

        while (continuar) {
            iMenu.mostrarOpciones();
            int opcion = iMenu.seleccionarOpcion();
            continuar = opcion != 0;
            if (continuar) {
                iMenu.ejecutarOpcion(opcion);
            } else {
                System.out.println("Saliendo del programa...");
            }
        }
    }
}