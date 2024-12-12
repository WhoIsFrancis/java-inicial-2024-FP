package tp1;

import java.util.Scanner;

public class MenuImpl implements IMenu {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void mostrarOpciones() {
        System.out.println("\nMenú de opciones:");
        System.out.println("1. Ingresar un nuevo comentario");
        System.out.println("2. Listar todos los comentarios");
        System.out.println("3. Eliminar un comentario");
        System.out.println("0. Salir");
    }

    @Override
    public int seleccionarOpcion() {
        int choice;

        System.out.print("\nElija una opción: ");
        choice = scanner.nextInt();

        return choice;
    }

    @Override
    public boolean ejecutarOpcion(int opcion) {
        IComentarios iComentarios = new ComentarioImpl();

        switch (opcion) {
            case 1:
                System.out.print("\nAhora ingrese los datos del comentario comenzando por la reseña: ");
                String trash = scanner.nextLine(); // permite que el siguiente nextLine() sea ejecutado, de lo contrario no funciona
                String resena = scanner.nextLine(); // TODO: limitar a 140 caracteres

                System.out.print("\nIngrese el puntaje (0 - 100): ");
                float puntaje = scanner.nextFloat();

                Comentario comentario = new Comentario(resena, puntaje);

                if (iComentarios.ingresarComentario(comentario)) {
                    System.out.println("Comentario agregado.");
                } else {
                    System.out.println("El comentario no pudo ser agregado.");
                }

                break;

            case 2:
                if (iComentarios.mostrarComentarios().isEmpty()) {
                    System.out.println("No hay comentarios.");
                } else {
                    System.out.println("Comentarios: ");
                    for (int i = 0; i < iComentarios.mostrarComentarios().size(); i++) {
                        System.out.printf("%d. %s%n", i, iComentarios.mostrarComentarios().get(i));
                    }
                }
                break;

            case 3:
                System.out.print("\nIngrese el índice del comentario a eliminar: ");
                int index = scanner.nextInt();


                if (iComentarios.eliminarComentario(index)) {
                    System.out.println("Comentario eliminado.");
                } else {
                    System.out.println("El comentario no pudo ser eliminado.");
                }
                break;

            case 0:
                System.out.println("\nSaliendo de la aplicación. ¡Hasta luego!");
                return false;

            default:
                System.out.println("Opción no válida. Intente nuevamente.");
                return false;
        }

        return true;
    }


    @Override
    protected void finalize() throws Throwable {
        scanner.close();
        super.finalize();
    }
}
