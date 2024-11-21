package restaurante;

import java.util.ArrayList;
import java.util.List;

public class PedidoRami implements Comandable {
    private List<Comanda> comandas;

    public PedidoRami() {
        this.comandas = new ArrayList<>();
    }

    @Override
    public void agregarComanda(Comanda comanda) {
        if (comanda != null) {
            comandas.add(comanda);
        }
    }

    @Override
    public int recuperarCantidadDeComandasTotales() {
        return comandas.size();
    }

    @Override
    public Comanda recuperarUltimaComandaAgregada() {
        if (comandas.isEmpty()) {
            return null;
        }
        return comandas.get(comandas.size() - 1); //comandas.getLast();
    }

    @Override
    public void eliminarUltimaComanda() {
        if (!comandas.isEmpty()) {
            comandas.remove(comandas.size() - 1); //comandas.removeLast();
        }
    }
}