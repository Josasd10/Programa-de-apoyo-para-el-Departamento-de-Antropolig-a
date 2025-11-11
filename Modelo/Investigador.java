package Modelo;

import java.util.ArrayList;

public class Investigador extends Usuario {

    private ArrayList<Proyecto> proyectosAsignados;

    public Investigador(String nombre, String contacto, String correo, int idUsuario, String contrasena) {
        super(nombre, contacto, correo, idUsuario, contrasena);
        this.proyectosAsignados = new ArrayList<>();
    }

    public void asignarProyecto(Proyecto proyecto) {
        proyectosAsignados.add(proyecto);
        System.out.println("Proyecto asignado: " + proyecto.getTitulo());
    }

    public void editarProyecto(Proyecto proyecto, String nuevaDescripcion) {
        if (proyectosAsignados.contains(proyecto)) {
            proyecto.setDescripcion(nuevaDescripcion);
            System.out.println("Proyecto editado exitosamente.");
        } else {
            System.out.println("No tienes permisos para editar este proyecto.");
        }
    }

    public void eliminarProyecto(Proyecto proyecto) {
        if (proyectosAsignados.remove(proyecto)) {
            System.out.println("Proyecto eliminado.");
        } else {
            System.out.println("No se pudo eliminar el proyecto. Verifica si está asignado.");
        }
    }

    public void verProyectosCreados() {
        if (proyectosAsignados.isEmpty()) {
            System.out.println("No tienes proyectos asignados.");
        } else {
            System.out.println("Proyectos asignados:");
            for (Proyecto p : proyectosAsignados) {
                System.out.println("- " + p.getTitulo());
            }
        }
    }

    public ArrayList<Proyecto> getProyectosAsignados() {
        return proyectosAsignados;
    }
}
