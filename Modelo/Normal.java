package Modelo;

import java.util.ArrayList;

public class Normal extends Usuario {

    public Normal(String nombre, String contacto, String correo, int idUsuario, String contrasena) {
        super(nombre, contacto, correo, idUsuario, contrasena);
    }

    public void verProyectosAsignados(ArrayList<Proyecto> proyectos) {
        if (proyectos.isEmpty()) {
            System.out.println("No hay proyectos disponibles para visualizar.");
        } else {
            System.out.println("Proyectos disponibles:");
            for (Proyecto p : proyectos) {
                System.out.println("- " + p.getTitulo() + ": " + p.getDescripcion());
            }
        }
    }
}