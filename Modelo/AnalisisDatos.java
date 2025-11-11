package Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnalisisDatos {

    // Lista de palabras clave antropológicas para etiquetado automático
    private List<Etiquetas> etiquetasDisponibles;

    public AnalisisDatos() {
        etiquetasDisponibles = new ArrayList<>();
        etiquetasDisponibles.add(new Etiquetas("cultura", "Estudios sobre prácticas culturales"));
        etiquetasDisponibles.add(new Etiquetas("ritual", "Prácticas ceremoniales"));
        etiquetasDisponibles.add(new Etiquetas("tradición", "Costumbres heredadas"));
        etiquetasDisponibles.add(new Etiquetas("etnografía", "Estudio descriptivo de grupos humanos"));
        etiquetasDisponibles.add(new Etiquetas("arqueología", "Estudio de restos materiales"));
    }

    public void abrirDoc(Documento doc) {
        System.out.println("Documento: " + doc.getTitulo());
        System.out.println("Contenido:");
        System.out.println(doc.getContenido());
    }

    public void procesarDocumento(Documento doc) {
        List<String> etiquetasEncontradas = new ArrayList<>();

        for (Etiquetas etiqueta : etiquetasDisponibles) {
            int ocurrencias = etiqueta.contarOcurrenciasEnDocumento(doc);
            if (ocurrencias > 0) {
                etiqueta.aplicarADocumento(doc);
                etiquetasEncontradas.add(etiqueta.getNombreEtiqueta());
            }
        }

        doc.setEtiquetas(etiquetasEncontradas);
    }

    public void agregarEtiqueta(Etiquetas nuevaEtiqueta) {
        etiquetasDisponibles.add(nuevaEtiqueta);
    }

    public void generarResumenProyecto(Proyecto proyecto) {
        String descripcion = proyecto.getDescripcion();
        String[] palabras = descripcion.split(" ");
        int limite = Math.min(palabras.length, 20); // resumen de las primeras 20 palabras

        StringBuilder resumen = new StringBuilder();
        for (int i = 0; i < limite; i++) {
            resumen.append(palabras[i]).append(" ");
        }

        proyecto.setResumen(resumen.toString().trim());
    }
}