package Modelo;
import java.util.ArrayList;

public class Normal extends Usuario {
    public Normal(String nombre, String contacto, String correo, int idUsuario, String contraseña){
        super(nombre, contacto, correo, idUsuario, contraseña);
    }

    public void verProyectosAsignados(ArrayList<Proyecto> proyectos){
        
    }
}