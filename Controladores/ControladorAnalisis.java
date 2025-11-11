package Controladores;

import Modelo.AnalisisDatos;
import Modelo.Documento;
import Modelo.Proyecto;

import java.util.Scanner;

public class ControladorAnalisis {

    private AnalisisDatos analizador = new AnalisisDatos();
    private Scanner scanner = new Scanner(System.in);

    public void ponerEtiquetas() {
        System.out.print("Ingrese el título del documento a analizar: ");
        String titulo = scanner.nextLine();

        // Simulación de búsqueda de documento (en un proyecto real, se buscaría en una lista)
        Documento doc = new Documento(titulo, 1, "Contenido de ejemplo con cultura y tradición.");
        analizador.procesarDocumento(doc);

        System.out.println("Etiquetas aplicadas al documento:");
        for (String etiqueta : doc.getEtiquetas()) {
            System.out.println("- " + etiqueta);
        }
    }

    public void resumirProyecto() {
        System.out.print("Ingrese el nombre del proyecto a resumir: ");
        String nombre = scanner.nextLine();

        Proyecto proyecto = new Proyecto(nombre, 1);
        proyecto.setDescripcion("Este proyecto estudia las prácticas culturales, rituales y tradiciones de comunidades indígenas.");
        analizador.generarResumenProyecto(proyecto);

        System.out.println("Resumen generado:");
        System.out.println(proyecto.getResumen());
    }

    public void guardarAnalisis() {
        System.out.println("Guardando análisis... (simulado)");
        // Aquí podrías guardar en archivo o base de datos
    }

    public void seleccionHerramienta(String nombre) {
        System.out.println("Herramienta seleccionada: " + nombre);
        // Aquí podrías cambiar el tipo de análisis si tienes varios
    }

    public void exportarResultados(String formato) {
        System.out.println("Exportando resultados en formato: " + formato);
        // Aquí podrías generar un archivo .txt, .pdf, etc.
    }
}
