package restaurante;

import java.util.List;

public class PedidoJoel implements Comandable {
    private List<Comanda> comandas;

    @Override
    public void agregarComanda(Comanda comanda) {
        this.comandas.add(comanda);
    }

    @Override
    public int recuperarCantidadDeComandasTotales() {
        return this.comandas.size();
    }

    @Override
    public Comanda recuperarUltimaComandaAgregada() {
        return this.comandas.get(comandas.size() - 1); //this.comandas.getLast();
    }

    @Override
    public void eliminarUltimaComanda() {
        this.comandas.remove(this.comandas.get(comandas.size() - 1));
    }
}