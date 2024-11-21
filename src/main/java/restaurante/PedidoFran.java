package restaurante;

import java.util.ArrayList;
import java.util.List;

public class PedidoFran implements Comandable {
    public List<Comanda> comandas;

    public PedidoFran() {
        this.comandas = new ArrayList<>();
    }

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
        if (this.comandas.isEmpty()) {
            return null;
        } return this.comandas.get(comandas.size() - 1);
    }

    @Override
    public void eliminarUltimaComanda() {
        this.comandas.remove(comandas.size() - 1);
    }
}
