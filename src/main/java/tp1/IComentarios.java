package tp1;

import java.util.List;

public interface IComentarios {

    boolean ingresarComentario(Comentario comentario);

    List<Comentario> mostrarComentarios();

    boolean eliminarComentario(int index);

    int obtenerCantidadComentarios();
}