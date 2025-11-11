package Controladores;

import Modelo.Usuario;
import Modelo.Investigador;
import Modelo.Normal;

import java.util.ArrayList;
import java.util.Scanner;

public class ControladorIngreso {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private Usuario usuarioActual;
    private Scanner scanner = new Scanner(System.in);

    public void ingresar() {
        System.out.print("Ingrese su correo: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        for (Usuario u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo) && u.login(contrasena)) {
                usuarioActual = u;
                System.out.println("Ingreso exitoso. Bienvenido/a " + u.getNombre());
                return;
            }
        }

        System.out.println("Correo o contraseña incorrectos.");
    }

    public void crearNuevoUsuario() {
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su contacto: ");
        String contacto = scanner.nextLine();
        System.out.print("Ingrese su correo: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese una contraseña: ");
        String contrasena = scanner.nextLine();
        System.out.print("¿Es investigadora? (s/n): ");
        String tipo = scanner.nextLine();

        int id = usuarios.size() + 1;
        Usuario nuevoUsuario;

        if (tipo.equalsIgnoreCase("s")) {
            nuevoUsuario = new Investigador(nombre, contacto, correo, id, contrasena);
        } else {
            nuevoUsuario = new Normal(nombre, contacto, correo, id, contrasena);
        }

        usuarios.add(nuevoUsuario);
        System.out.println("Usuario creado exitosamente.");
    }

    public void cerrarSesion() {
        if (usuarioActual != null) {
            usuarioActual.logout();
            usuarioActual = null;
        } else {
            System.out.println("No hay sesión activa.");
        }
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
}