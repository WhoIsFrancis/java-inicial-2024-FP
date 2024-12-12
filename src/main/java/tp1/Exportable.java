package tp1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public interface Exportable {

    default boolean exportarACsv(List<Comentario> comentarioList) {
        for (Comentario comentario : comentarioList) {
            String content = comentario.toString();

            try (FileWriter writer = new FileWriter("output.csv")) {
                writer.write(content);
                writer.flush();
                System.out.println("Archivo escrito exitosamente.");
            } catch (IOException e) {
                System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
                return false;
            }
        }

        return true;
    }

}

