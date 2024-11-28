package capitulo6;

import java.util.Scanner;

public class IfElseExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su puntaje (0-100): ");
        int score = scanner.nextInt();

        if (score >= 90) {
            System.out.println("Calificación: A");
        } else if (score >= 80) {
            System.out.println("Calificación: B");
        } else if (score >= 70) {
            System.out.println("Calificación: C");
        } else if (score >= 60) {
            System.out.println("Calificación: D");
        } else {
            System.out.println("Calificación: F");
        }

        scanner.close();
    }
}
