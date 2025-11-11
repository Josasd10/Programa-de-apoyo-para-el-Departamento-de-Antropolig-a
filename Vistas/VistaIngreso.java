package Vistas;

import java.util.Scanner;

public class VistaIngreso {

    private Scanner scanner = new Scanner(System.in);

    public String solicitarCorreo() {
        System.out.print("Ingrese su correo: ");
        return scanner.nextLine();
    }

    public String solicitarContrasena() {
        System.out.print("Ingrese su contraseña: ");
        return scanner.nextLine();
    }

    public String solicitarNombre() {
        System.out.print("Ingrese su nombre: ");
        return scanner.nextLine();
    }

    public String solicitarContacto() {
        System.out.print("Ingrese su contacto: ");
        return scanner.nextLine();
    }

    public String solicitarTipoUsuario() {
        System.out.print("¿Es investigadora? (s/n): ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarSesion() {
        System.out.println("Cerrando sesión...");
    }
}
