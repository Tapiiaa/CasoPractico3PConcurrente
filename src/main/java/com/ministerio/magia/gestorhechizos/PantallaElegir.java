package com.ministerio.magia.gestorhechizos;


import javax.swing.*;
import java.awt.*;

public class PantallaElegir {

    public static void mostrarPantallaElegir() {
        JFrame frame = new JFrame("Elige tu tipo de hechicero");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));

        JButton botonFuego = new JButton("Hechicero de Fuego");
        JButton botonHielo = new JButton("Hechicero de Hielo");

        botonFuego.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Has elegido ser Hechicero de Fuego");
            frame.dispose(); // Cierra la ventana
            MagiaGestorApp.main(new String[0]); // Redirige a la aplicación principal
        });

        botonHielo.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Has elegido ser Hechicero de Hielo");
            frame.dispose(); // Cierra la ventana
            MagiaGestorApp.main(new String[0]); // Redirige a la aplicación principal
        });

        frame.add(botonFuego);
        frame.add(botonHielo);

        frame.setVisible(true);
    }
}
