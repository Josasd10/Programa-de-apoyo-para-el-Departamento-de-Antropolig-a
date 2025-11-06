package Modelo;
import java.util.ArrayList;

public class Proyecto {
    private String nombreProyecto;
    private int idProyecto;
    private ArrayList<Documento> documentos;

    public Proyecto(String nombreProyecto, int idProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.idProyecto = idProyecto;
        this.documentos = new ArrayList<Documento>();
    }
     public void agregarDocumento(Documento doc) {
        this.documentos.add(doc);
    }

    
    public void eliminarDocumento(Documento doc) {
        this.documentos.remove(doc);
    }   
    public void editarDocumento(Documento doc, Documento nuevoDoc) {
        int index = this.documentos.indexOf(doc);
        if (index != -1) {
            this.documentos.set(index, nuevoDoc);
        }
    }
}