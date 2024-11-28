package capitulo6;

import java.util.Scanner;

public class IfSwitchCombo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su edad: ");
        int age = scanner.nextInt();

        if (age < 0) {
            System.out.println("La edad no puede ser negativa.");
        } else if (age >= 18) {
            System.out.println("Seleccione una actividad:");
            System.out.println("1. Trabajar");
            System.out.println("2. Estudiar");
            System.out.println("3. Descansar");

            int activity = scanner.nextInt();

            switch (activity) {
                case 1 -> System.out.println("Has elegido trabajar.");
                case 2 -> System.out.println("Has elegido estudiar.");
                case 3 -> System.out.println("Has elegido descansar.");
                default -> System.out.println("Opción no válida.");
            }
        } else {
            System.out.println("Eres menor de edad, disfruta tu infancia.");
        }

        scanner.close();
    }
}
