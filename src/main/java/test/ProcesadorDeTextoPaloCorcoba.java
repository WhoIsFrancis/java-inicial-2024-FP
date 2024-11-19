package test;

import java.util.Set;

public class ProcesadorDeTextoPaloCorcoba implements AnalizadorDeTexto {

    @Override
    public int getCantidadDePalabras(String texto) {
        if (texto == null || texto.isEmpty()) {
            return 0;
        }

        int contador = 0;
        boolean enPalabra = false;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            // Verifica si el carácter actual es parte de una palabra
            if (Character.isLetterOrDigit(c)) {
                if (!enPalabra) {
                    // Inicia una nueva palabra
                    contador++;
                    enPalabra = true;
                }
            } else {
                // Si es un delimitador, marca el final de una palabra
                enPalabra = false;
            }
        }

        return contador;
    }

    @Override
    public int getCantidadDeVocales(String texto) {
        if (texto == null || texto.isEmpty()) {
            return 0;
        }

        int contador = 0;
        String vocales = "aeiouáéíóúAEIOUÁÉÍÓÚ"; // Incluye vocales mayúsculas y acentuadas.

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            // Verifica si el carácter actual es una vocal.
            if (vocales.indexOf(c) != -1) {
                contador++;
            }
        }

        return contador;
    }


    @Override
    public int getCantidadDeConsonantes(String texto) {
        if (texto == null || texto.isEmpty()) {
            return 0;
        }

        int contador = 0;
        String vocales = "aeiouáéíóúAEIOUÁÉÍÓÚ"; // Vocales minúsculas, mayúsculas y acentuadas.

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            // Verifica si el carácter es una letra y no es una vocal.
            if (Character.isLetter(c) && vocales.indexOf(c) == -1) {
                contador++;
            }
        }

        return contador;
    }


    @Override
    public int getCantidadDeSignosDePuntuacion(String texto) {
        return 0;
    }

    @Override
    public int getCantidadDeCaracteres(String texto) {
        return 0;
    }

    @Override
    public int getCantidadDeMayusculas(String texto) {
        return 0;
    }

    @Override
    public String reemplazarPalabraPorOtra(String palabraOriginal, String palabraNueva) {
        return "";
    }

    @Override
    public Set<String> getListadoDePalabrasSinRepetirse(String texto) {
        return Set.of();
    }
}
