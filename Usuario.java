public class Usuario {
    private String nombre;
    private String contacto;
    private String correo;
    private int idUsuario;
    private String contrasena;

    public Usuario(String nombre, String contacto, String correo, int idUsuario, String contrasena){
        this.nombre = nombre;
        this.contacto = contacto;
        this.correo = correo;
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;

    public boolean login(String contrasena){
        return this.contrasena.equals(contrasena);
    }

    public void logout(){
        
    }
    }
}
