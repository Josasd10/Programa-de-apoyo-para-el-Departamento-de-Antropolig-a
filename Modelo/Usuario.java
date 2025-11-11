package Modelo;

public class Usuario {
    private String nombre;
    private String contacto;
    private String correo;
    private int idUsuario;
    private String contrasena;

    public Usuario(String nombre, String contacto, String correo, int idUsuario, String contrasena) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.correo = correo;
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public String getCorreo() {
        return correo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public boolean login(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    public void logout() {
        System.out.println("Usuario " + nombre + " ha cerrado sesión.");
    }
}