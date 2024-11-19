package test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ProcesadorDeTextoJoel implements AnalizadorDeTexto {

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
        if (texto == null || texto.isEmpty()){
            return 0;
        }

        int contadorVocales = 0;
        List<Character> vocales = Arrays.asList(
                'a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U',
                'á', 'é', 'í', 'ó', 'ú',
                'Á', 'É', 'Í', 'Ó', 'Ú'
        );
        for (int i = 0; i < texto.length(); i++) {
            if (vocales.contains(texto.charAt(i))) {
                contadorVocales++;
            }
        }
        return contadorVocales;
    }

    @Override
    public int getCantidadDeConsonantes(String texto) {
        if (texto == null || texto.isEmpty()){
            return 0;
        }

        int contadorConsonantes = 0;
        List<Character> vocales = Arrays.asList(
                'a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U',
                'á', 'é', 'í', 'ó', 'ú',
                'Á', 'É', 'Í', 'Ó', 'Ú'
        );
        for (int i = 0; i < texto.length(); i++) {
            if (vocales.contains(texto.charAt(i))) {
                //No se coloca nada dentro de esta condicion pq estaria tomando las vocales;
            } else {
                contadorConsonantes ++;
            }
        }
        return contadorConsonantes;
    }

    @Override
    public int getCantidadDeSignosDePuntuacion(String texto) {
        if (texto == null || texto.isEmpty()){
            return 0;
        }
        int contadorSignosPuntuacion = 0;
        List<Character> signosPuntuacion = Arrays.asList(
                '¿','?', '¡', '!', '.', ':',
                ',', '(', ')', ';', '"');

        for (int i = 0; i < texto.length(); i++){
            if (signosPuntuacion.contains(texto.charAt(i))){
                contadorSignosPuntuacion ++;
            }
        }
        return contadorSignosPuntuacion;
    }

    @Override
    public int getCantidadDeCaracteres(String texto) {
        if (texto == null || texto.isEmpty()) {
            return 0;
        }

        int contadorLetras = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (Character.isLetter(texto.charAt(i))) {
                contadorLetras++;
            }
        }
        return contadorLetras;
    }

    @Override
    public int getCantidadDeMayusculas(String texto) {
        if (texto == null || texto.isEmpty()){
            return 0;
        };

        int contadorMayusc = 0;
        for (int i = 0; i < texto.length(); i++){
            if (Character.isUpperCase(texto.charAt(i))){
                contadorMayusc ++;
            }
        }
        return contadorMayusc;
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
