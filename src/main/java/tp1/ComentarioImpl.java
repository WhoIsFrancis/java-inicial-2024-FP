package tp1;

import java.util.List;

public class ComentarioImpl implements IComentarios {
    @Override
    public boolean ingresarComentario(Comentario comentario) {
        return false;
    }

    @Override
    public List<Comentario> mostrarComentarios() {
        return List.of();
    }

    @Override
    public boolean eliminarComentario(int index) {
        return false;
    }

    @Override
    public int obtenerCantidadComentarios() {
        return 0;
    }
}
