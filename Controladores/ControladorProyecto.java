package Controladores;

import Modelo.Proyecto;
import Modelo.Documento;
import Modelo.Usuario;
import Modelo.Investigador;

import java.util.ArrayList;
import java.util.Scanner;

public class ControladorProyecto {

    private ArrayList<Proyecto> proyectos = new ArrayList<>();
    private Usuario usuarioActual;
    private Scanner scanner = new Scanner(System.in);

    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
    }

    public void CrearProyecto() {
        if (!(usuarioActual instanceof Investigador)) {
            System.out.println("Solo investigadores pueden crear proyectos.");
            return;
        }

        System.out.print("Ingrese el nombre del proyecto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción del proyecto: ");
        String descripcion = scanner.nextLine();

        int id = proyectos.size() + 1;
        Proyecto nuevoProyecto = new Proyecto(nombre, id);
        nuevoProyecto.setDescripcion(descripcion);

        proyectos.add(nuevoProyecto);
        ((Investigador) usuarioActual).asignarProyecto(nuevoProyecto);

        System.out.println("Proyecto creado exitosamente.");
    }

    public void IngresarEntrevista() {
        System.out.print("Ingrese el nombre del proyecto: ");
        String nombre = scanner.nextLine();

        Proyecto proyecto = buscarProyectoPorNombre(nombre);
        if (proyecto == null) {
            System.out.println("Proyecto no encontrado.");
            return;
        }

        System.out.print("Ingrese el título del documento (entrevista): ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el contenido del documento: ");
        String contenido = scanner.nextLine();

        int idDoc = proyecto.getDocumentos().size() + 1;
        Documento doc = new Documento(titulo, idDoc, contenido);
        proyecto.agregarDocumento(doc);

        System.out.println("Entrevista agregada como documento al proyecto.");
    }

    public void TranscribirEntrevista() {
        System.out.println("Función de transcripción aún no implementada.");
        // Aquí podrías integrar una API de reconocimiento de voz si lo deseas
    }

    public void Verentrevistas() {
        System.out.print("Ingrese el nombre del proyecto: ");
        String nombre = scanner.nextLine();

        Proyecto proyecto = buscarProyectoPorNombre(nombre);
        if (proyecto == null) {
            System.out.println("Proyecto no encontrado.");
            return;
        }

        ArrayList<Documento> documentos = proyecto.getDocumentos();
        if (documentos.isEmpty()) {
            System.out.println("No hay entrevistas/documentos en este proyecto.");
        } else {
            System.out.println("Documentos en el proyecto \"" + proyecto.getTitulo() + "\":");
            for (Documento doc : documentos) {
                System.out.println("- " + doc.getTitulo() + ": " + doc.getContenido());
            }
        }
    }

    private Proyecto buscarProyectoPorNombre(String nombre) {
        for (Proyecto p : proyectos) {
            if (p.getTitulo().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }
}