package test;

import java.util.Set;

public class ProcesadorDeTextoAgus implements AnalizadorDeTexto {
    @Override
    public int getCantidadDePalabras(String texto) {
        if (texto == null || texto.isEmpty())
            return 0;
        String[] cantPalabras = texto.split("\\s+");
        return cantPalabras.length;
    }

    @Override
    public int getCantidadDeVocales(String texto) {

        if (texto == null) {
            return 0;
        }
        int contadorVocales = 0;
        for (char c : texto.toLowerCase().toCharArray()) {
            if (Character.isLetter(c) && (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
                contadorVocales++;
            }
        }

        return contadorVocales;

    }

    @Override
    public int getCantidadDeConsonantes(String texto) {

        if (texto == null) {
            return 0;
        }

        int contadorConsonantes = 0;

        for (char c : texto.toLowerCase().toCharArray()) {

            if (Character.isLetter(c) && !(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
                contadorConsonantes++;
            }
        }
        return contadorConsonantes;


    }

    @Override
    public int getCantidadDeSignosDePuntuacion(String texto) {
       /* if (texto == null) return 0;
        int contadorPuntuacion = 0;
        for (char c : texto.toCharArray()) {
            if (".,;:!?".indexOf(c) != -1) {
                contadorPuntuacion++;
            }
        }
        return contadorPuntuacion;*/
        return 0;
    }

    @Override
    public int getCantidadDeCaracteres(String texto) {
        if (texto == null) return 0;
        return texto.length();
    }

    @Override
    public int getCantidadDeMayusculas(String texto) {
        if (texto == null)
            return 0;
        int contadorMayusculas = 0;
        for (char c : texto.toCharArray()) {
            if (Character.isUpperCase(c)) {
                contadorMayusculas++;
            }
        }
        return contadorMayusculas;
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
