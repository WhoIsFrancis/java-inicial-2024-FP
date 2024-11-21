package restaurante;

import java.util.ArrayList;
import java.util.List;


public class PedidoAA  implements Comandable {


    private List<Comanda> comandas = new ArrayList<>();


    @Override
    public void agregarComanda(Comanda comanda) {
        this.comandas.add(comanda);
    }


    @Override
    public int recuperarCantidadDeComandasTotales() {
        return comandas.size();
    }


    @Override
    public Comanda recuperarUltimaComandaAgregada() {
        if (comandas.isEmpty()||comandas== null) {
            System.out.println("No hay comandas");
            return null; }


        return comandas.get(comandas.size() - 1);
    }


    @Override
    public void eliminarUltimaComanda() {
        if (!comandas.isEmpty() || comandas== null) {
            comandas.remove(comandas.size() - 1); }
    }
}
