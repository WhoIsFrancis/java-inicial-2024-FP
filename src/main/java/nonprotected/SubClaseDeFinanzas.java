package nonprotected;

import protectedexample.Finanzas;

class SubClaseDeFinanzas extends Finanzas {
    public float getMonto() {
        return super.monto;
    }
}
