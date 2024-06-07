package main.java.view;

import main.java.controller.Controlador;
import main.java.model.Mascota;
import main.java.model.Dueño;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaPrincipal extends JFrame {
    private List<Mascota> mascotas;
    private List<Dueño> dueños;
    private JPanel panelMosaico;
    private Controlador controlador;

    public VentanaPrincipal(Controlador controlador, List<Mascota> mascotas, List<Dueño> dueños) {
        this.controlador = controlador;
        this.mascotas = mascotas;
        this.dueños = dueños;

        setTitle("Guardería de Mascotas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelMosaico = new JPanel();
        panelMosaico.setLayout(new GridLayout(0, 3));
        add(panelMosaico, BorderLayout.CENTER);

        JButton btnRegistrarMascota = new JButton("Registrar Mascota");
        btnRegistrarMascota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroMascota(controlador).setVisible(true);
            }
        });
        add(btnRegistrarMascota, BorderLayout.SOUTH);

        JButton btnMostrarServicios = new JButton("Mostrar Servicios");
        btnMostrarServicios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.mostrarServicios();
            }
        });
        add(btnMostrarServicios, BorderLayout.NORTH);

        actualizarMosaico();
    }

    public void actualizarMosaico() {
        Mascota mascota;
        panelMosaico.removeAll();
        for (Dueño dueño : dueños) {
            for (Mascota mascota : dueño.op()) {
                JButton btnMascota = new JButton(mascota.getNombre());
                btnMascota.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Mascota currentMascota = mascota; // Create a new local variable
                        currentMascota.mostrarDetalles(); // Access the local variable
                    }
                });
                panelMosaico.add(btnMascota);
            }
        }
        panelMosaico.revalidate();
        panelMosaico.repaint();
    }
}
