package com.ministerio.magia.gestorhechizos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MagiaGestorApp extends JFrame {

    private JTextArea displayArea;
    private JTextField hechizoInput;
    private JButton mostrarHechizosButton;
    private JButton agregarHechizoButton;
    private JButton actualizarHechizoButton;
    private JButton eliminarHechizoButton;
    private ExecutorService executorService;

    public MagiaGestorApp() {
        setTitle("Gestor de Hechizos y Eventos Mágicos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Iniciar el servicio de hilos con un pool fijo
        executorService = Executors.newFixedThreadPool(4);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout());

        // Área de visualización
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Panel de botones e input
        JPanel inputPanel = new JPanel(new FlowLayout());
        hechizoInput = new JTextField(20);
        inputPanel.add(new JLabel("Hechizo:"));
        inputPanel.add(hechizoInput);

        mostrarHechizosButton = new JButton("Mostrar Hechizos");
        agregarHechizoButton = new JButton("Agregar Hechizo");
        actualizarHechizoButton = new JButton("Actualizar Hechizo");
        eliminarHechizoButton = new JButton("Eliminar Hechizo");

        inputPanel.add(mostrarHechizosButton);
        inputPanel.add(agregarHechizoButton);
        inputPanel.add(actualizarHechizoButton);
        inputPanel.add(eliminarHechizoButton);

        panel.add(inputPanel, BorderLayout.SOUTH);

        // Añadir panel al frame
        add(panel);

        // Eventos de botón con ejecución concurrente
        mostrarHechizosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarTarea(() -> mostrarHechizos());
            }
        });

        agregarHechizoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hechizo = hechizoInput.getText().trim();
                if (!hechizo.isEmpty()) {
                    ejecutarTarea(() -> agregarHechizo(hechizo));
                } else {
                    mostrarMensaje("El campo de hechizo está vacío");
                }
            }
        });

        actualizarHechizoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hechizo = hechizoInput.getText().trim();
                if (!hechizo.isEmpty()) {
                    ejecutarTarea(() -> actualizarHechizo(hechizo));
                } else {
                    mostrarMensaje("El campo de hechizo está vacío");
                }
            }
        });

        eliminarHechizoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hechizo = hechizoInput.getText().trim();
                if (!hechizo.isEmpty()) {
                    ejecutarTarea(() -> eliminarHechizo(hechizo));
                } else {
                    mostrarMensaje("El campo de hechizo está vacío");
                }
            }
        });
    }

    private void ejecutarTarea(Runnable tarea) {
        executorService.submit(() -> {
            System.out.println("Inicio de tarea en hilo: " + Thread.currentThread().getName());
            tarea.run();
            System.out.println("Fin de tarea en hilo: " + Thread.currentThread().getName());
        });
    }

    // Métodos simulados para la demostración
    private void mostrarHechizos() {
        try {
            Thread.sleep(1000); // Simula el procesamiento
            mostrarMensaje("Mostrando lista de hechizos...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            mostrarMensaje("Error al mostrar los hechizos");
        }
    }

    private void agregarHechizo(String hechizo) {
        try {
            Thread.sleep(1000); // Simula el procesamiento
            mostrarMensaje("Hechizo '" + hechizo + "' agregado exitosamente.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            mostrarMensaje("Error al agregar el hechizo");
        }
    }

    private void actualizarHechizo(String hechizo) {
        try {
            Thread.sleep(1000); // Simula el procesamiento
            mostrarMensaje("Hechizo '" + hechizo + "' actualizado exitosamente.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            mostrarMensaje("Error al actualizar el hechizo");
        }
    }

    private void eliminarHechizo(String hechizo) {
        try {
            Thread.sleep(1000); // Simula el procesamiento
            mostrarMensaje("Hechizo '" + hechizo + "' eliminado exitosamente.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            mostrarMensaje("Error al eliminar el hechizo");
        }
    }

    private void mostrarMensaje(String mensaje) {
        SwingUtilities.invokeLater(() -> displayArea.append(mensaje + "\n"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MagiaGestorApp().setVisible(true);
        });
    }
}
