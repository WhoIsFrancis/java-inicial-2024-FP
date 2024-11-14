package test;

import java.util.Set;

public class ProcesadorDeTexto implements AnalizadorDeTexto {

    @Override
    public int getCantidadDePalabras(String texto) {
        texto = texto.trim();

        // Elimina todos los signos de puntuación usando expresión regular
        texto = texto.replaceAll("[\\p{Punct}]", "");

        // Divide el texto en palabras usando espacios como delimitador
        if (texto.isEmpty()) {
            return 0;
        }

        // Divide el texto en palabras usando cualquier cantidad de espacios en blanco como delimitador
        String[] palabras = texto.split("\\s+");

        // Retorna la cantidad de palabras
        return palabras.length;
    }

    @Override
    public int getCantidadDeVocales(String texto) {
        return 0;
    }

    @Override
    public int getCantidadDeConsonantes(String texto) {
        return 0;
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
