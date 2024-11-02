package com.ministerio.magia.gestorhechizos.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class HechizoPanel extends JPanel {

    private static final Logger logger = Logger.getLogger(HechizoPanel.class.getName());
    private JTextField nombreField;
    private JTextField tipoField;
    private JTextField nivelPoderField;
    private JButton enviarButton;
    private JTextArea hechizosArea;

    public HechizoPanel() {
        // Configurar el logger para la terminal
        configurarLogger();

        // Configurar el diseño del panel
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        hechizosArea = new JTextArea();
        hechizosArea.setEditable(false);

        // Campos de entrada
        nombreField = new JTextField(20);
        tipoField = new JTextField(20);
        nivelPoderField = new JTextField(20);
        enviarButton = new JButton("Crear Hechizo");

        // Añadir los componentes al panel de entrada
        inputPanel.add(new JLabel("Nombre:", SwingConstants.RIGHT));
        inputPanel.add(nombreField);
        inputPanel.add(new JLabel("Tipo:", SwingConstants.RIGHT));
        inputPanel.add(tipoField);
        inputPanel.add(new JLabel("Nivel de Poder:", SwingConstants.RIGHT));
        inputPanel.add(nivelPoderField);
        inputPanel.add(new JLabel()); // Espacio vacío
        inputPanel.add(enviarButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(hechizosArea), BorderLayout.CENTER);

        // Listener para el botón "Crear Hechizo"
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearHechizo();
            }
        });
    }

    private void configurarLogger() {
        // Configurar un ConsoleHandler para mostrar los logs en la terminal
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);

        // Opcional: Desactivar el uso de handlers globales (para evitar duplicación de mensajes)
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.OFF);
    }

    private void crearHechizo() {
        String nombre = nombreField.getText();
        String tipo = tipoField.getText();
        String nivelPoder = nivelPoderField.getText();

        try {
            // Configurar la conexión HTTP
            URL url = new URL("http://localhost:8080/api/hechizos/agregar");  // Asegúrate de que esta URL es correcta
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            conn.setDoOutput(true);

            // Crear el JSON del hechizo
            String jsonInputString = String.format(
                    "{\"nombre\": \"%s\", \"tipo\": \"%s\", \"nivelPoder\": %s}",
                    nombre, tipo, nivelPoder
            );

            // Enviar el JSON en el cuerpo de la solicitud
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Procesar la respuesta del servidor
            int code = conn.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK || code == HttpURLConnection.HTTP_CREATED) {
                hechizosArea.append("Hechizo creado: " + nombre + ", Tipo: " + tipo + ", Nivel: " + nivelPoder + "\n");
            } else {
                JOptionPane.showMessageDialog(this, "Error al crear el hechizo: Código de respuesta " + code);
            }

            conn.disconnect();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
