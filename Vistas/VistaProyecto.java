package Vistas;

import Controladores.ControladorProyecto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;

public class VistaProyecto extends JFrame {
    private JTextField txtTitulo;
    private JTextArea txtDescripcion;
    private JTextArea txtContenido;
    private JButton btnGuardar, btnArchivo, btnRegresar;
    private JList<String> listaProyectos;
    private DefaultListModel<String> modeloLista;
    private ControladorProyecto controlador;
    private File archivoSeleccionado;

    public VistaProyecto(ControladorProyecto controlador) {
        this.controlador = controlador;
        setTitle("Gestión de Proyectos");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 10, 10));
        txtTitulo = new JTextField();
        txtDescripcion = new JTextArea(3, 20);
        txtContenido = new JTextArea(5, 20);
        btnGuardar = new JButton("Guardar Proyecto");
        btnArchivo = new JButton("Subir Archivo (PDF/Video)");
        btnRegresar = new JButton("Regresar");

        btnArchivo.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                archivoSeleccionado = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(this, "Archivo seleccionado: " + archivoSeleccionado.getName());
            }
        });

        btnGuardar.addActionListener((ActionEvent e) -> {
            String titulo = txtTitulo.getText();
            String descripcion = txtDescripcion.getText();
            String contenido = txtContenido.getText();
            String archivo = (archivoSeleccionado != null) ? archivoSeleccionado.getAbsolutePath() : "Sin archivo";
            controlador.guardarProyecto(titulo, descripcion, contenido, archivo);
        });

        btnRegresar.addActionListener((ActionEvent e) -> controlador.regresar());

        panelFormulario.add(new JLabel("Título:"));
        panelFormulario.add(txtTitulo);
        panelFormulario.add(new JLabel("Descripción:"));
        panelFormulario.add(new JScrollPane(txtDescripcion));
        panelFormulario.add(new JLabel("Contenido:"));
        panelFormulario.add(new JScrollPane(txtContenido));
        panelFormulario.add(btnArchivo);
        panelFormulario.add(btnGuardar);
        panelFormulario.add(new JLabel());
        panelFormulario.add(btnRegresar);

        modeloLista = new DefaultListModel<>();
        listaProyectos = new JList<>(modeloLista);

        add(panelFormulario, BorderLayout.NORTH);
        add(new JScrollPane(listaProyectos), BorderLayout.CENTER);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void actualizarLista(List<String> proyectos) {
        modeloLista.clear();
        for (String p : proyectos) {
            modeloLista.addElement(p);
        }
    }
}