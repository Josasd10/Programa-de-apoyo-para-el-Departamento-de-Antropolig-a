package Controladores;

import java.util.ArrayList;

public class ControladorAnalisis {
    public static ArrayList<String> generarAnalisis() {
        ArrayList<String> resultado = new ArrayList<>();
        for (String proyecto : ControladorProyecto.obtenerProyectos()) {
            resultado.add(proyecto + "\nEtiquetas: " + generarEtiquetas(proyecto));
        }
        return resultado;
    }

    private static ArrayList<String> generarEtiquetas(String texto) {
        ArrayList<String> etiquetas = new ArrayList<>();
        String[] palabras = texto.split("\\s+");
        for (String palabra : palabras) {
            if (palabra.length() > 5) etiquetas.add(palabra.toLowerCase());
        }
        return etiquetas;
    }
}