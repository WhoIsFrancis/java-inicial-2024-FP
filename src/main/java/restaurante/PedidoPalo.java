package restaurante;

import java.util.ArrayList;
import java.util.List;

public class PedidoPalo implements Comandable {

    // Lista para almacenar las comandas
    private List<Comanda> comandas;

    // Constructor
    public PedidoPalo() {
        this.comandas = new ArrayList<>();
    }

    @Override
    public void agregarComanda(Comanda comanda) {
        comandas.add(comanda); // Agregar la comanda a la lista
    }

    @Override
    public int recuperarCantidadDeComandasTotales() {
        return comandas.size(); // Retorna el tamaño de la lista
    }

    @Override
    public Comanda recuperarUltimaComandaAgregada() {
        if (!comandas.isEmpty()) {
            return comandas.get(comandas.size() - 1); // Retorna la última comanda
        }
        return null; // Si no hay comandas, retorna null
    }

    @Override
    public void eliminarUltimaComanda() {
        if (!comandas.isEmpty()) {
            comandas.remove(comandas.size() - 1); // Elimina la última comanda
        }
    }
}
