package Vistas;

import Modelo.Proyecto;
import Modelo.Documento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VistaProyecto extends JFrame {

    private JLabel tituloLabel;
    private JTextArea descripcionArea;
    private JList<String> listaDocumentos;
    private DefaultListModel<String> modeloDocumentos;
    private JButton agregarDocumentoButton;
    private JButton eliminarDocumentoButton;

    private Proyecto proyecto;

    public VistaProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;

        setTitle("Vista del Proyecto");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Título del proyecto
        tituloLabel = new JLabel("Proyecto: " + proyecto.getTitulo());
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(tituloLabel, BorderLayout.NORTH);

        // Área de descripción
        descripcionArea = new JTextArea(proyecto.getDescripcion());
        descripcionArea.setEditable(false);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        add(new JScrollPane(descripcionArea), BorderLayout.CENTER);

        // Lista de documentos
        modeloDocumentos = new DefaultListModel<>();
        for (Documento doc : proyecto.getDocumentos()) {
            modeloDocumentos.addElement(doc.getTitulo());
        }

        listaDocumentos = new JList<>(modeloDocumentos);
        listaDocumentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(listaDocumentos), BorderLayout.EAST);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        agregarDocumentoButton = new JButton("Agregar Documento");
        eliminarDocumentoButton = new JButton("Eliminar Documento");
        panelBotones.add(agregarDocumentoButton);
        panelBotones.add(eliminarDocumentoButton);
        add(panelBotones, BorderLayout.SOUTH);

        // Acción: Agregar documento
        agregarDocumentoButton.addActionListener(e -> {
            String titulo = JOptionPane.showInputDialog(this, "Título del documento:");
            String contenido = JOptionPane.showInputDialog(this, "Contenido del documento:");
            if (titulo != null && !titulo.trim().isEmpty()) {
                Documento nuevoDoc = new Documento(titulo, proyecto.getDocumentos().size() + 1, contenido);
                proyecto.agregarDocumento(nuevoDoc);
                modeloDocumentos.addElement(nuevoDoc.getTitulo());
            }
        });

        // Acción: Eliminar documento
        eliminarDocumentoButton.addActionListener(e -> {
            int index = listaDocumentos.getSelectedIndex();
            if (index != -1) {
                Documento doc = proyecto.getDocumentos().get(index);
                proyecto.eliminarDocumento(doc);
                modeloDocumentos.remove(index);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un documento para eliminar.");
            }
        });
    }

    // Método para iniciar la vista
    public void mostrar() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }

    // Método principal de prueba
    public static void main(String[] args) {
        Proyecto demo = new Proyecto("Estudio de Cultura Maya", 1);
        demo.setDescripcion("Este proyecto investiga las prácticas culturales de la civilización Maya.");
        VistaProyecto vista = new VistaProyecto(demo);
        vista.mostrar();
    }
}