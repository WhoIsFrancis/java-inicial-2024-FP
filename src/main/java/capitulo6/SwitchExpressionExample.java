package capitulo6;

import java.util.Scanner;

public class SwitchExpressionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número del 1 al 3: ");
        int number = scanner.nextInt();

        // Usando switch como expresión
        String text = switch (number) {
            case 1 -> "Uno";
            case 2 -> "Dos";
            case 3 -> "Tres";
            default -> "Número no válido";
        };

        System.out.println("El número ingresado es: " + text);

        scanner.close();
    }
}
