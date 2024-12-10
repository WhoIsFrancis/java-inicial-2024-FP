package tp1;

import java.time.LocalDateTime;

public class Comentario {
    public static int counter = 0;

    private String resena; // limite de 140
    private float puntaje;
    private LocalDateTime fechaHora;
    private int id;

    public Comentario() {

    }

    public Comentario(String resena, float puntaje) {
        this.resena = resena;
        this.puntaje = puntaje;
        this.fechaHora = LocalDateTime.now();
        this.id = counter++;
    }

}
