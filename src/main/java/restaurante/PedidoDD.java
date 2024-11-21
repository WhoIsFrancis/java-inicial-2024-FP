package restaurante;

import java.util.ArrayList;
import java.util.List;

public class PedidoDD implements Comandable {

    public List<Comanda> listaComandas = new ArrayList<>();;

    @Override
    public void agregarComanda(Comanda comanda) {
        listaComandas.add(comanda);
    }

    @Override
    public int recuperarCantidadDeComandasTotales() {
        return listaComandas.size();
    }

    @Override
    public Comanda recuperarUltimaComandaAgregada() {
        return  listaComandas.get(listaComandas.size() - 1);
    }

    @Override
    public void eliminarUltimaComanda() {
        listaComandas.remove(listaComandas.size() - 1);
    }
}