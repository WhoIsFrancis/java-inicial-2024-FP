package tp1;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MenuImpl implements IMenu {
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
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.print("Elija una opción: ");
        choice = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        scanner.close();

        return choice;
    }

    @Override
    public boolean ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                Scanner scanner = new Scanner(System.in);
                //System.out.print("Ingrese los datos del comentario: ");

                //System.out.print("Ingrese reseña del comentario: ");
                String resena = scanner.nextLine(); // TODO: encontrar el bug y luego limitar a 140 caracteres

                System.out.print("Ingrese el puntaje (0 - 100): ");
                float puntaje = scanner.nextFloat();

                Comentario comentario = new Comentario(resena, puntaje);
                IComentarios iComentarios = new ComentarioImpl();

                if (iComentarios.ingresarComentario(comentario)) {
                    System.out.println("Comentario agregado.");
                } else {
                    System.out.println("El omentario no pudo ser agregado.");
                }

                scanner.close();
                break;

            case 2:
                    /*List<String> comments = commentManager.getComments();
                    if (comments.isEmpty()) {
                        System.out.println("No hay comentarios.");
                    } else {
                        System.out.println("Comentarios:");
                        for (int i = 0; i < comments.size(); i++) {
                            System.out.printf("%d. %s%n", i, comments.get(i));
                        }
                    }
                    break;*/

            case 3:
                   /*
                    System.out.print("Ingrese el índice del comentario a eliminar: ");
                    int index = scanner.nextInt();
                    commentManager.deleteComment(index);
                    break;*/

            case 0:
                System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
                break;

            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }

        return false;
    }
}
