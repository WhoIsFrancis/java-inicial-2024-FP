package com.test;

import java.util.Set;

public class ProcesadorDeTexto implements AnalizadorDeTexto{
    @Override
    public int getCantidadDePalabras(String texto) {
        return 0;
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
