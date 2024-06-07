package main.java.view;

import main.java.controller.Controlador;
import main.java.model.Dueño;
import main.java.model.Mascota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaServicios extends JFrame {
    private Controlador controlador;
    private List<Dueño> dueños;

    public VentanaServicios(Controlador controlador, List<Dueño> dueños) {
        this.controlador = controlador;
        this.dueños = dueños;

        setTitle("Servicios para Mascotas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea serviciosArea = new JTextArea();
        serviciosArea.setEditable(false);
        add(new JScrollPane(serviciosArea), BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        for (Dueño dueño : dueños) {
            for (Mascota mascota : dueño.getMascotas()) {
                JButton btnMascota = new JButton(mascota.getNombre() + " (" + dueño.getNombre() + ")");
                btnMascota.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mostrarServiciosMascota(mascota);
                    }
                });
                panel.add(btnMascota);
            }
        }
        add(panel, BorderLayout.SOUTH);
    }

    private void mostrarServiciosMascota(Mascota mascota) {
        JFrame serviciosFrame = new JFrame("Servicios para " + mascota.getNombre());
        serviciosFrame.setSize(300, 200);
        serviciosFrame.setLayout(new GridLayout(0, 1));

        JButton btnBañar = new JButton("Bañar");
        btnBañar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mascota.bañar();
                JOptionPane.showMessageDialog(serviciosFrame, "Se ha bañado a " + mascota.getNombre());
            }
        });
        serviciosFrame.add(btnBañar);

        JButton btnCortarUñas = new JButton("Cortar Uñas");
        btnCortarUñas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mascota.cortarUñas();
                JOptionPane.showMessageDialog(serviciosFrame, "Se han cortado las uñas de " + mascota.getNombre());
            }
        });
        serviciosFrame.add(btnCortarUñas);

        JButton btnCepillarDientes = new JButton("Cepillar Dientes");
        btnCepillarDientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mascota.cepillarDientes();
                JOptionPane.showMessageDialog(serviciosFrame, "Se han cepillado los dientes de " + mascota.getNombre());
            }
        });
        serviciosFrame.add(btnCepillarDientes);

        JButton btnAnalizarSalud = new JButton("Analizar Salud");
        btnAnalizarSalud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String salud = mascota.analizarSalud();
                JOptionPane.showMessageDialog(serviciosFrame, "Salud de " + mascota.getNombre() + ": " + salud);
            }
        });
        serviciosFrame.add(btnAnalizarSalud);

        serviciosFrame.setVisible(true);
    }
}
