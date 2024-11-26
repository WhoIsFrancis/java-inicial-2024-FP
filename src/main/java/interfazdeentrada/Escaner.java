package interfazdeentrada;

import java.util.Scanner;

public class Escaner implements Input {

    private String data;
    private Scanner input = new Scanner(System.in);

    // char charAt = input.nextLine().charAt(0);
    // System.out.println("El texto ingresado es: " + charAt);

    @Override
    public String ingresarData() {
        data = input.nextLine();
        return data;
    }

    @Override
    public void mostrarData() {
        System.out.println(data);
    }
}
