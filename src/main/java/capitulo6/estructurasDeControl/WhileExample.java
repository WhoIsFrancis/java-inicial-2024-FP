package capitulo6.estructurasDeControl;

import java.util.Scanner;

public class WhileExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la base: ");
        int base = scanner.nextInt();
        System.out.print("Ingrese el exponente: ");
        int exponent = scanner.nextInt();

        int result = 1;
        int count = 0;

        while (count < exponent) {
            result *= base;
            count++;

            if (count == 1) {
                System.out.println("Count vale 1 y salgo del bucle");
                break;
            }
        }

        System.out.println("El resultado de " + base + " elevado a la " + exponent + " es: " + result);
        scanner.close();
    }
}
