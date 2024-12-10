package tp1;

public class Aplicacion {
    public static void main(String[] args) {

        IMenu iMenu = new MenuImpl();
        iMenu.mostrarOpciones();
        iMenu.ejecutarOpcion(iMenu.seleccionarOpcion());

        // TODO: terminar de completar los pasos
    }
}