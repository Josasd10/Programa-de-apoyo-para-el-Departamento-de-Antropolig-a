import Controladores.ControladorIngreso;
import Controladores.ControladorProyecto;
import Controladores.ControladorAnalisis;
import Modelo.Usuario;
import Modelo.Proyecto;
import Modelo.Documento;
import Vistas.VistaIngreso;
import Vistas.VistaAnalisis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControladorIngreso controladorIngreso = new ControladorIngreso();
        ControladorProyecto controladorProyecto = new ControladorProyecto();
        ControladorAnalisis controladorAnalisis = new ControladorAnalisis();
        VistaIngreso vistaIngreso = new VistaIngreso();
        VistaAnalisis vistaAnalisis = new VistaAnalisis();

        Usuario usuarioActual = null;
        boolean ejecutando = true;

        while (ejecutando) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Crear nuevo usuario");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Crear proyecto");
            System.out.println("4. Ver documentos de proyecto");
            System.out.println("5. Agregar documento");
            System.out.println("6. Analizar proyecto");
            System.out.println("7. Cerrar sesión");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    controladorIngreso.crearNuevoUsuario();
                    break;
                case "2":
                    controladorIngreso.ingresar();
                    usuarioActual = controladorIngreso.getUsuarioActual();
                    controladorProyecto.setUsuarioActual(usuarioActual);
                    break;
                case "3":
                    controladorProyecto.CrearProyecto();
                    break;
                case "4":
                    controladorProyecto.Verentrevistas();
                    break;
                case "5":
                    controladorProyecto.IngresarEntrevista();
                    break;
                case "6":
                    controladorAnalisis.ponerEtiquetas();
                    controladorAnalisis.resumirProyecto();
                    break;
                case "7":
                    controladorIngreso.cerrarSesion();
                    usuarioActual = null;
                    break;
                case "8":
                    ejecutando = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}