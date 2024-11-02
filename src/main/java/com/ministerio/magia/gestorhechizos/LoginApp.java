package com.ministerio.magia.gestorhechizos;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LoginApp {

    private static Map<String, String> userRoles;

    public static void main(String[] args) {
        // Inicializa los roles para el login
        userRoles = new HashMap<>();
        userRoles.put("admin", "Administrador");
        userRoles.put("user", "Usuario");
        userRoles.put("hechicero", "Hechicero Avanzado");

        // Mostrar la ventana de login
        displayLoginWindow();
    }

    private static void displayLoginWindow() {
        JFrame frame = new JFrame("Login - Sistema de Gestión Mágica");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        JLabel userLabel = new JLabel("Usuario:");
        JTextField userText = new JTextField();
        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passText = new JPasswordField();
        JButton loginButton = new JButton("Iniciar sesión");
        JLabel reminderLabel = new JLabel("Tu usuario es: admin. Tu contraseña es 1**4 (reemplaza * por números).");

        frame.add(userLabel);
        frame.add(userText);
        frame.add(passLabel);
        frame.add(passText);
        frame.add(new JLabel());
        frame.add(loginButton);
        frame.add(new JLabel());
        frame.add(reminderLabel);

        loginButton.addActionListener(e -> {
            String username = userText.getText().trim();
            String password = new String(passText.getPassword()).trim(); // Contraseña de ejemplo

            if (userRoles.containsKey(username) && "1234".equals(password)) { // Contraseña de prueba
                String role = userRoles.get(username);
                JOptionPane.showMessageDialog(frame, "Bienvenido, " + username + ". Tu rol es: " + role);
                frame.dispose(); // Cierra la ventana de login
                PantallaElegir.mostrarPantallaElegir(); // Redirige a PantallaElegir
            } else {
                JOptionPane.showMessageDialog(frame, "Credenciales incorrectas. Inténtalo de nuevo.");
            }
        });

        frame.setVisible(true);
    }
}
