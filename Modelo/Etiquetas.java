package Modelo;

public class Etiquetas {
    private String nombreEtiqueta;
    private String descripcionEtiqueta;

    public Etiquetas(String nombreEtiqueta, String descripcionEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
        this.descripcionEtiqueta = descripcionEtiqueta;
    }

    public String getNombreEtiqueta() {
        return nombreEtiqueta;
    }

    public String getDescripcionEtiqueta() {
        return descripcionEtiqueta;
    }

    public void aplicarADocumento(Documento doc) {
        if (!doc.getEtiquetas().contains(nombreEtiqueta)) {
            doc.getEtiquetas().add(nombreEtiqueta);
        }
    }

    public int contarOcurrenciasEnDocumento(Documento doc) {
        String contenido = doc.getContenido().toLowerCase();
        String palabra = nombreEtiqueta.toLowerCase();
        int contador = 0;
        int index = contenido.indexOf(palabra);

        while (index != -1) {
            contador++;
            index = contenido.indexOf(palabra, index + palabra.length());
        }

        return contador;
    }
}