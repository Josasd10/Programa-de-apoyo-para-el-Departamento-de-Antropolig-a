package Modelo;
import java.util.ArrayList;

public class Documento {
    private String nombreDocumento;
    private int idDocumento;
    private ArrayList<Etiquetas> etiquetas;

    public Documento(String nombreDocumento, int idDocumento) {
        this.nombreDocumento = nombreDocumento;
        this.idDocumento = idDocumento;
        this.etiquetas = new ArrayList<Etiquetas>();
    }



}