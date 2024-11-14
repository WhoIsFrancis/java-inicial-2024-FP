package test;

import java.util.Set;

public interface AnalizadorDeTexto {

    int getCantidadDePalabras(String texto);
    int getCantidadDeVocales(String texto);
    int getCantidadDeConsonantes(String texto);
    int getCantidadDeSignosDePuntuacion(String texto);
    int getCantidadDeCaracteres(String texto);
    int getCantidadDeMayusculas(String texto);

    String reemplazarPalabraPorOtra(String palabraOriginal, String palabraNueva);
    Set<String> getListadoDePalabrasSinRepetirse(String texto);

}
