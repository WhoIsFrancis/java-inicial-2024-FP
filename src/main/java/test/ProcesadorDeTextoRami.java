package test;

import java.util.Set;

public class ProcesadorDeTextoRami implements AnalizadorDeTexto {

    @Override
    public int getCantidadDePalabras(String texto) {
        // Elimina espacios en blanco al principio y al final
        texto = texto.strip();

        // Sustituye los signos de puntuación por espacios vacíos
        texto = texto.replaceAll("[\\p{Punct}]+", " ");

        // Verifica si el texto está vacío después de procesarlo
        if (texto.isBlank()) {
            return 0;
        }

        // Divide el texto en palabras utilizando uno o más espacios como separador
        String[] palabras = texto.split("\\s+");

        // Devuelve la cantidad de palabras encontradas
        return palabras.length;
    }

    @Override
    public int getCantidadDeVocales(String texto) {
        // Convierto el texto a minúsculas
        texto = texto.toLowerCase();
        int contadorVocales = 0;

        // Recorro cada carácter del texto
        for (char c : texto.toCharArray()) {
            // Verifico si el carácter es una vocal
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú') {
                contadorVocales++;
            }
        }
        return contadorVocales;
    }

    @Override
    public int getCantidadDeConsonantes(String texto) {
        // Convierto el texto a minúsculas
        texto = texto.toLowerCase();

        // Inicializo un contador para las consonantes
        int contadorConsonantes = 0;

        // Recorro cada carácter del texto
        for (char c : texto.toCharArray()) {
            // Verifico si el carácter es una consonante (excluye vocales y no letras)
            if ((c >= 'a' && c <= 'z' || "ñ".indexOf(c) >= 0) &&
                    !"aeiouáéíóú".contains(String.valueOf(c))) {
                contadorConsonantes++;
            }
        }
        return contadorConsonantes;
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