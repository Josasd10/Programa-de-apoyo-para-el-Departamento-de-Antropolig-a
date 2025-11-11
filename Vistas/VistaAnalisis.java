package Vistas;

import Modelo.Documento;
import Modelo.Proyecto;

import java.util.List;
import java.util.Scanner;

public class VistaAnalisis {

    private Scanner scanner = new Scanner(System.in);

    public void mostrarEtiquetas(Documento doc) {
        List<String> etiquetas = doc.getEtiquetas();
        System.out.println("\n--- Etiquetas del Documento ---");
        System.out.println("Documento: " + doc.getTitulo());
        if (etiquetas.isEmpty()) {
            System.out.println("No se encontraron etiquetas.");
        } else {
            for (String etiqueta : etiquetas) {
                System.out.println("- " + etiqueta);
            }
        }
    }

    public void mostrarResumen(Proyecto proyecto) {
        System.out.println("\n--- Resumen del Proyecto ---");
        System.out.println("Proyecto: " + proyecto.getTitulo());
        String resumen = proyecto.getResumen();
        if (resumen == null || resumen.isEmpty()) {
            System.out.println("No se ha generado un resumen aún.");
        } else {
            System.out.println(resumen);
        }
    }

    public String mostrarOpcionesAnalisis() {
        System.out.println("\n--- Herramientas de Análisis ---");
        System.out.println("1. Etiquetado automático");
        System.out.println("2. Generar resumen");
        System.out.println("3. Exportar resultados");
        System.out.print("Seleccione una opción: ");
        return scanner.nextLine();
    }

    public void mostrarResultadosExportados(String formato) {
        System.out.println("Resultados exportados exitosamente en formato: " + formato);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
