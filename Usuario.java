public class Usuario {
    private String nombre;
    private String contacto;
    private String correo;
    private int idUsuario;
    private String contraseña;

    public Usuario(String nombre, String contacto, String correo, int idUsuario, String contraseña){
        this.nombre = nombre;
        this.contacto = contacto;
        this.correo = correo;
        this.idUsuario = idUsuario;
        this.contraseña = contraseña;

    public boolean login(String contraseña){
        return this.contraseña.equals(contraseña);
    }

    public void logout(){
        
    }
    }
}
