package herencia;

public class Padre implements B { // super class
    String apellido = "Mendez";
    String domicilio = "Av abc ...";
    int dni = 333333333;

    private void setDni(int dni) {

    }

    @Override
    public void metodoA() {

    }

    // Sobrecarga de constructores
    public Padre(String apellido) {}

    public Padre(String apellido, int dni) {}

    public Padre(int dni, String apellido) {}

    public Padre() {}

    public Padre(int dni) {}
}
