package tp1;

public class Aplicacion {
    public static void main(String[] args) {

        IMenu iMenu = new MenuImpl();
        boolean continuar = true;

        while (continuar) {
            iMenu.mostrarOpciones();
            continuar = iMenu.ejecutarOpcion(iMenu.seleccionarOpcion());
        }
    }
}