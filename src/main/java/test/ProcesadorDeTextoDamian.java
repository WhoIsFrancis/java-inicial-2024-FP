package test;

import java.util.Set;

public class ProcesadorDeTextoDamian implements AnalizadorDeTexto{
    @Override
    public int getCantidadDePalabras(String texto) {
        if (texto == null || texto.isEmpty()) {
            return 0;
        }
        String[] palabras = texto.split("\\s+");
        return palabras.length;
    }

    @Override
    public int getCantidadDeVocales(String texto) {
        int cantidadVocales = 0;
        Set<Character> caracteresPermitidos = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U', 'á', 'é', 'í', 'ó', 'ú', 'Á', 'É', 'Í', 'Ó', 'Ú');
        for (int i = 0; i < texto.length(); i++) {
            if (caracteresPermitidos.contains(texto.charAt(i))) {
                cantidadVocales++;
            }
        }
        return cantidadVocales;
    }

    @Override
    public int getCantidadDeConsonantes(String texto) {
        int cantidadConsonantes = 0;
        for (int i = 0; i < texto.length(); i++) {
            char caracter = Character.toLowerCase(texto.charAt(i));
            if (Character.isLetter(caracter) && !"aeiou".contains(String.valueOf(caracter))) {
                cantidadConsonantes++;
            }
        }
        return cantidadConsonantes;
    }

    @Override
    public int getCantidadDeSignosDePuntuacion(String texto) {
        int cantidadSignos = 0;
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (String.valueOf(caracter).matches("[\\p{Punct}]")) {
                cantidadSignos++;
            }
        }
        return cantidadSignos;
    }

    @Override
    public int getCantidadDeCaracteres(String texto) {
        int cantidadCaracteres = 0;
        for (int i = 0; i < texto.length(); i++) {
            cantidadCaracteres ++;
        }
        return cantidadCaracteres;
    }

    @Override
    public int getCantidadDeMayusculas(String texto) {
        int cantidadMayusculas = 0;
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (Character.isUpperCase(caracter)) {
                cantidadMayusculas++;
            }
        }
        return cantidadMayusculas;
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
