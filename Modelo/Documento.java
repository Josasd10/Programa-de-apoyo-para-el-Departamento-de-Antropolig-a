package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Documento {
    private String nombreDocumento;
    private int idDocumento;
    private String contenido;
    private List<String> etiquetas;

    public Documento(String nombreDocumento, int idDocumento, String contenido) {
        this.nombreDocumento = nombreDocumento;
        this.idDocumento = idDocumento;
        this.contenido = contenido;
        this.etiquetas = new ArrayList<>();
    }

    public String getTitulo() {
        return nombreDocumento;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }
}