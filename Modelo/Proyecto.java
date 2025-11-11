package Modelo;

import java.util.ArrayList;

public class Proyecto {
    private String nombreProyecto;
    private int idProyecto;
    private String descripcion;
    private String resumen;
    private ArrayList<Documento> documentos;

    public Proyecto(String nombreProyecto, int idProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.idProyecto = idProyecto;
        this.descripcion = "";
        this.resumen = "";
        this.documentos = new ArrayList<>();
    }

    public String getTitulo() {
        return nombreProyecto;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public void agregarDocumento(Documento doc) {
        documentos.add(doc);
    }

    public void eliminarDocumento(Documento doc) {
        documentos.remove(doc);
    }

    public void editarDocumento(Documento doc, Documento nuevoDoc) {
        int index = documentos.indexOf(doc);
        if (index != -1) {
            documentos.set(index, nuevoDoc);
        }
    }
}