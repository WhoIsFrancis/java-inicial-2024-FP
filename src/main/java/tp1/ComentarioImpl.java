package tp1;

import java.util.ArrayList;
import java.util.List;

public class ComentarioImpl implements IComentarios {

    private List<Comentario> listaComentarios = new ArrayList<>();

    /**
     * Este metodo permite persistir en una estructura de datos el comentqrio
     * pasado por parametro
     *
     * @param comentario
     * @return boolean true if
     */
    @Override
    public boolean ingresarComentario(Comentario comentario) {
        return listaComentarios.add(comentario);
    }

    @Override
    public List<Comentario> mostrarComentarios() {
        return listaComentarios;
    }

    @Override
    public boolean eliminarComentario(int index) {
        if (listaComentarios.remove(index) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int obtenerCantidadComentarios() {
        return 0;
    }
}
