package protectedexample;

public class Finanzas {
    protected float monto = 120000.56f;

    private void calcularIndiceBlaBla() {
        this.monto *= 45;
    }

    public void calcularCoeficiente() {
        this.monto -= 3;
    }
}
