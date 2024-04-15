package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoAdivinaNumero extends JFrame implements ActionListener {
    private int numeroSecreto;
    private JTextField entradaTexto;
    private JLabel etiquetaResultado;

    public JuegoAdivinaNumero() {
        setTitle("Adivina el número");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        numeroSecreto = (int) (Math.random() * 100) + 1; // Generar número aleatorio del 1 al 100

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel etiquetaInstruccion = new JLabel("Intenta adivinar el número (1-100):");
        panel.add(etiquetaInstruccion);

        entradaTexto = new JTextField();
        panel.add(entradaTexto);

        JButton botonAdivinar = new JButton("Adivinar");
        botonAdivinar.addActionListener(this); // Añadir acción al botón
        panel.add(botonAdivinar);

        etiquetaResultado = new JLabel("");
        panel.add(etiquetaResultado);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JuegoAdivinaNumero());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int intento = Integer.parseInt(entradaTexto.getText());
            if (intento < numeroSecreto) {
                etiquetaResultado.setText("Demasiado bajo. ¡Inténtalo de nuevo!");
            } else if (intento > numeroSecreto) {
                etiquetaResultado.setText("Demasiado alto. ¡Inténtalo de nuevo!");
            } else {
                etiquetaResultado.setText("¡Correcto! Has adivinado el número.");
            }
        } catch (NumberFormatException ex) {
            etiquetaResultado.setText("Por favor, introduce un número válido.");
        }
        entradaTexto.setText(""); // Limpiar el campo de entrada después de cada intento
    }
}
