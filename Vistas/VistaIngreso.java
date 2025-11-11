package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

public class VistaIngreso extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    // Panel Login
    private JTextField txtUsuario;
    private JComboBox<String> comboRol;

    // Panel Proyecto
    private JTextField txtTitulo;
    private JTextArea txtDescripcion;
    private JTextArea txtContenido;
    private File archivoSeleccionado;

    // Datos en memoria
    private ArrayList<String> proyectos = new ArrayList<>();

    public VistaIngreso() {
        setTitle("Sistema Antropología");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Crear paneles
        mainPanel.add(crearPanelLogin(), "Login");
        mainPanel.add(crearPanelMenuInvestigadora(), "MenuInvestigadora");
        mainPanel.add(crearPanelProyecto(), "Proyecto");
        mainPanel.add(crearPanelAnalisis(), "Analisis");

        add(mainPanel);
        cardLayout.show(mainPanel, "Login");
    }

    private JPanel crearPanelLogin() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        txtUsuario = new JTextField();
        comboRol = new JComboBox<>(new String[]{"Investigadora", "Lector"});
        JButton btnIngresar = new JButton("Ingresar");

        btnIngresar.addActionListener((ActionEvent e) -> {
            String usuario = txtUsuario.getText();
            String rol = (String) comboRol.getSelectedItem();
            if (usuario.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingresa un usuario.");
                return;
            }
            if (rol.equals("Investigadora")) {
                cardLayout.show(mainPanel, "MenuInvestigadora");
            } else {
                cardLayout.show(mainPanel, "Analisis");
            }
        });

        panel.add(new JLabel("Usuario:"));
        panel.add(txtUsuario);
        panel.add(new JLabel("Rol:"));
        panel.add(comboRol);
        panel.add(new JLabel());
        panel.add(btnIngresar);
        return panel;
    }

    private JPanel crearPanelMenuInvestigadora() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        JButton btnNuevo = new JButton("Ingresar Proyecto");
        JButton btnEditar = new JButton("Editar Proyecto");
        JButton btnAnalisis = new JButton("Ver Análisis");
        JButton btnRegresar = new JButton("Regresar");

        btnNuevo.addActionListener(e -> cardLayout.show(mainPanel, "Proyecto"));
        btnEditar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Función editar en desarrollo."));
        btnAnalisis.addActionListener(e -> cardLayout.show(mainPanel, "Analisis"));
        btnRegresar.addActionListener(e -> cardLayout.show(mainPanel, "Login"));

        panel.add(btnNuevo);
        panel.add(btnEditar);
        panel.add(btnAnalisis);
        panel.add(btnRegresar);
        return panel;
    }

    private JPanel crearPanelProyecto() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        txtTitulo = new JTextField();
        txtDescripcion = new JTextArea(3, 20);
        txtContenido = new JTextArea(5, 20);
        JButton btnArchivo = new JButton("Subir Archivo");
        JButton btnGuardar = new JButton("Guardar Proyecto");
        JButton btnRegresar = new JButton("Regresar");

        btnArchivo.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                archivoSeleccionado = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(this, "Archivo seleccionado: " + archivoSeleccionado.getName());
            }
        });

        btnGuardar.addActionListener(e -> {
            String titulo = txtTitulo.getText();
            String descripcion = txtDescripcion.getText();
            String contenido = txtContenido.getText();
            String archivo = (archivoSeleccionado != null) ? archivoSeleccionado.getName() : "Sin archivo";
            proyectos.add("Título: " + titulo + "\nDescripción: " + descripcion + "\nContenido: " + contenido + "\nArchivo: " + archivo);
            JOptionPane.showMessageDialog(this, "Proyecto guardado.");
            txtTitulo.setText("");
            txtDescripcion.setText("");
            txtContenido.setText("");
            archivoSeleccionado = null;
        });

        btnRegresar.addActionListener(e -> cardLayout.show(mainPanel, "MenuInvestigadora"));

        formPanel.add(new JLabel("Título:"));
        formPanel.add(txtTitulo);
        formPanel.add(new JLabel("Descripción:"));
        formPanel.add(new JScrollPane(txtDescripcion));
        formPanel.add(new JLabel("Contenido:"));
        formPanel.add(new JScrollPane(txtContenido));
        formPanel.add(btnArchivo);
        formPanel.add(btnGuardar);
        formPanel.add(new JLabel());
        formPanel.add(btnRegresar);

        panel.add(formPanel, BorderLayout.NORTH);
        return panel;
    }

    private JPanel crearPanelAnalisis() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea txtAnalisis = new JTextArea();
        txtAnalisis.setEditable(false);
        JButton btnRegresar = new JButton("Regresar");

        btnRegresar.addActionListener(e -> {
            if (comboRol.getSelectedItem().equals("Investigadora")) {
                cardLayout.show(mainPanel, "MenuInvestigadora");
            } else {
                cardLayout.show(mainPanel, "Login");
            }
        });

        JButton btnActualizar = new JButton("Actualizar Análisis");
        btnActualizar.addActionListener(e -> {
            txtAnalisis.setText("");
            for (String proyecto : proyectos) {
                txtAnalisis.append(proyecto + "\nEtiquetas: " + generarEtiquetas(proyecto) + "\n\n");
            }
        });

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(btnActualizar);
        topPanel.add(btnRegresar);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(txtAnalisis), BorderLayout.CENTER);
        return panel;
    }

    private ArrayList<String> generarEtiquetas(String texto) {
        ArrayList<String> etiquetas = new ArrayList<>();
        String[] palabras = texto.split("\\s+");
        for (String palabra : palabras) {
            if (palabra.length() > 5) etiquetas.add(palabra.toLowerCase());
        }
        return etiquetas;
    }
}