package Controladores;

import java.util.ArrayList;

public class ControladorProyecto {
    private static ArrayList<String> proyectos = new ArrayList<>();

    public static void guardarProyecto(String titulo, String descripcion, String contenido, String archivo) {
        proyectos.add("Título: " + titulo + "\nDescripción: " + descripcion + "\nContenido: " + contenido + "\nArchivo: " + archivo);
    }

    public static ArrayList<String> obtenerProyectos() {
        return proyectos;
    }

    public Object regresar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'regresar'");
    }
}