package capitulo6.estructurasDeControl;

import java.util.Scanner;

public class DoExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        do {
            System.out.print("Ingrese un número positivo: ");
            number = scanner.nextInt();
            if (number < 0) {
                System.out.println("El número no es positivo. Intente de nuevo.");
            }
        } while (number < 0);

        System.out.println("¡Número positivo ingresado: " + number + "!");
        scanner.close();
    }
}
