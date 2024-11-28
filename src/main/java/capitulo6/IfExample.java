package capitulo6;

import java.util.Scanner;

public class IfExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su edad: ");
        int age = scanner.nextInt();

        // Validación simple con operadores lógicos
        if (age >= 18 && age <= 60) { // rango de edad
            System.out.println("Eres un adulto en edad laboral.");
        }

        // Validación inversa
        if (!(age >= 18 && age <= 60)) {
            System.out.println("No estás en edad laboral.");
        }

        scanner.close();
    }
}
