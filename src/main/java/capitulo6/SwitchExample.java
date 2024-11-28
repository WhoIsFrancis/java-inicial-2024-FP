package capitulo6;

import java.util.Scanner;

public class SwitchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
        System.out.println("Seleccione una opción:");
        System.out.println("1. Iniciar");
        System.out.println("2. Pausar");
        System.out.println("3. Detener");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("Iniciando...");
                break;
            case 2:
                System.out.println("Pausando...");
                break;
            case 3:
                System.out.println("Deteniendo...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
*/

        System.out.println("Ingrese dia: (lun, mar, mie, jue, vie, sab, dom): ");
        String dia = scanner.next();

        switch (dia) {
            case "lun":
            case "mar":
            case "mie":
            case "jue":
            case "vie":
                System.out.println("Es dia de semana");
                break;
            case "sab":
            case "dom":
                System.out.println("Es fin de semana");
        }

        scanner.close();
    }
}