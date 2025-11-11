package Vistas;

import Controladores.ControladorAnalisis;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VistaAnalisis extends JFrame {
    private JTextArea txtAnalisis;
    private ControladorAnalisis controlador;

    public VistaAnalisis(ControladorAnalisis controlador) {
        this.controlador = controlador;
        setTitle("Análisis de Proyectos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        txtAnalisis = new JTextArea();
        txtAnalisis.setEditable(false);
        add(new JScrollPane(txtAnalisis), BorderLayout.CENTER);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void actualizarAnalisis(List<String> analisis) {
        txtAnalisis.setText("");
        for (String a : analisis) {
            txtAnalisis.append(a + "\n\n");
        }
    }
}