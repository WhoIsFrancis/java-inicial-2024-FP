package restaurante;

public interface Comandable {
    void agregarComanda(Comanda comanda);

    int recuperarCantidadDeComandasTotales();

    Comanda recuperarUltimaComandaAgregada();

    void eliminarUltimaComanda();
}
