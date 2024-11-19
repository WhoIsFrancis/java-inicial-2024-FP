package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProcesadorDeTextoFranPassa implements AnalizadorDeTexto {

    @Override
    public int getCantidadDePalabras(String texto) {
        return texto.split("\\s+").length;
    }

    @Override
    public int getCantidadDeVocales(String texto) {
        int count_vocales = 0;
        char[] vocales = {'a', 'e', 'i', 'o', 'u', 'á', 'é', 'í', 'ó', 'ú', 'ü'};

        for (int i = 0; i < texto.length(); i++) {
            char c = Character.toLowerCase(texto.charAt(i));
            for (char vocal : vocales) {
                if (c == vocal) {
                    count_vocales++;
                    break;
                }
            }
        }
        return count_vocales;
    }

    @Override
    public int getCantidadDeConsonantes(String texto) {
        int count_consonantes = 0;
        char[] vocales = {'a', 'e', 'i', 'o', 'u', 'á', 'é', 'í', 'ó', 'ú', 'ü'};

        for (int i = 0; i < texto.length(); i++) {
            char c = Character.toLowerCase(texto.charAt(i));
            boolean isVocal = false;

            // Verifica si el carácter es una vocal
            for (char vocal : vocales) {
                if (c == vocal) {
                    isVocal = true;
                    break;
                }
            }

            // Cuenta como consonante si es letra, no es vocal, y no es un carácter especial
            if (!isVocal && Character.isLetter(c)) {
                count_consonantes++;
            }
        }

        return count_consonantes;
    }

    @Override
    public int getCantidadDeSignosDePuntuacion(String texto) {
        int count_signos = 0;
        char[] signos_puntuacion = {
                ',', '.', ';', ':', '¡', '!', '¿', '?'};

        for (int i = 0; i < texto.length(); i++) {
            for (char puntuacion : signos_puntuacion) {
                if (texto.charAt(i) == puntuacion) {
                    count_signos++;
                }
            }
        }
        return count_signos;
    }

    @Override
    public int getCantidadDeCaracteres(String texto) {
        return texto.length();
    }

//        int count_characteres = 0;
//        char[] vocales = {'a', 'e', 'i', 'o', 'u', 'á', 'é', 'í', 'ó', 'ú', 'ü'};
//        for (int i = 0; i < texto.length(); i++) {
//            char c = Character.toLowerCase(texto.charAt(i));
//            for (char vocal : vocales) {
//                if (c != vocal) {
//                    count_characteres++;
//                    break;
//                }
//            }
//        }
//        return count_characteres;
//    }

    @Override
    public int getCantidadDeMayusculas(String texto) {
        int count_mayusculas = 0;
        String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZÁÉÍÓÚÂÊÎÔÛÃÑÕÄËÏÖÜŸ";
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (abecedario.indexOf(c) != -1) {
                count_mayusculas++;
            }
        }
        return count_mayusculas;
    }

    @Override
    public String reemplazarPalabraPorOtra(String palabraOriginal, String palabraNueva) {
        return palabraOriginal.replace(palabraOriginal, palabraNueva);
    }

    @Override
    public Set<String> getListadoDePalabrasSinRepetirse(String texto) {
        String[] palabras = texto.split("\\s+"); // Splitea el texto por espacios
        Set<String> palabrasUnicas = new HashSet<>(Arrays.asList(palabras));
        return palabrasUnicas;
    }
}
