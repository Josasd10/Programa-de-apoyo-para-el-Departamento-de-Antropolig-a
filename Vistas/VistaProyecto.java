package Vistas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VistaProyecto extends JFrame {

    private JLabel tituloLabel;
    private JTextArea descripcionArea;
    private JList<String> listaTareas;
    private DefaultListModel<String> modeloTareas;
    private JButton agregarTareaButton;
    private JButton eliminarTareaButton;

    public VistaProyecto() {
        setTitle("Vista del Proyecto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Título
        tituloLabel = new JLabel("Título del Proyecto");
        add(tituloLabel, BorderLayout.NORTH);

        // Descripción
        descripcionArea = new JTextArea("Descripción del proyecto...");
        add(descripcionArea, BorderLayout.CENTER);

        // Lista de Tareas
        modeloTareas = new DefaultListModel<>();
        listaTareas = new JList<>(modeloTareas);
        add(new JScrollPane(listaTareas), BorderLayout.EAST);

        // Botones
        JPanel panelBotones = new JPanel();
        agregarTareaButton = new JButton("Agregar Tarea");
        eliminarTareaButton = new JButton("Eliminar Tarea");
        panelBotones.add(agregarTareaButton);
        panelBotones.add(eliminarTareaButton);
        add(panelBotones, BorderLayout.SOUTH);

        // Acciones de los botones
        agregarTareaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tarea = JOptionPane.showInputDialog("Ingrese la tarea:");
                if (tarea != null && !tarea.trim().isEmpty()) {
                    modeloTareas.addElement(tarea);
                }
            }
        });

        eliminarTareaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = listaTareas.getSelectedIndex();
                if (indiceSeleccionado != -1) {
                    modeloTareas.remove(indiceSeleccionado);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaProyecto vista = new VistaProyecto();
            vista.setVisible(true);
        });
    }
}