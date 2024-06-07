package main.java.view;

import main.java.controller.Controlador;
import main.java.model.Gato;
import main.java.model.Mascota;
import main.java.model.Perro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class RegistroMascota extends JFrame {
    private Controlador controlador;
    private JTextField txtNombre;
    private JTextField txtRaza;
    private JTextField txtEdad;
    private JTextField txtDieta;
    private JTextField txtFotoPath;
    private JComboBox<String> comboEspecie;
    private JButton btnGuardar;
    private JButton btnChooseFile;
    private JFileChooser fileChooser;


    
    public RegistroMascota(Controlador controlador) {
        this.controlador = controlador;
        setTitle("Registrar Mascota");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Especie:"));
        comboEspecie = new JComboBox<>(new String[]{"Perro", "Gato"});
        comboEspecie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboEspecie.getSelectedItem().equals("Perro")) {
                    txtRaza.setEnabled(false);
                    txtRaza.setText("Automático"); 
                } else {
                    txtRaza.setEnabled(true);
                    txtRaza.setText(""); 
                }
            }
        });
        add(comboEspecie);

        add(new JLabel("Raza:"));
        txtRaza = new JTextField();
        add(txtRaza);

        add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        add(txtEdad);

        add(new JLabel("Dieta:"));
        txtDieta = new JTextField();
        add(txtDieta);

        add(new JLabel("Foto Path:"));
        txtFotoPath = new JTextField();
        txtFotoPath.setEditable(false);
        add(txtFotoPath);

        btnChooseFile = new JButton("Choose File");
        btnChooseFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFile();
            }
        });
        add(btnChooseFile);

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarMascota();
            }
        });
        add(btnGuardar);

        // Initialize file chooser
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("JPG files", "jpg", "jpeg", "png"));
    }

    private void chooseFile() {
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            txtFotoPath.setText(selectedFile.getAbsolutePath());
        }
    }

    private void guardarMascota() {
        try {
            String nombre = txtNombre.getText();
            String especie = comboEspecie.getSelectedItem().toString();
            String Raza = txtRaza.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String dieta = txtDieta.getText();
            String fotoPath = txtFotoPath.getText();

            Mascota mascota;
            if (especie.equals("Perro")) {
                mascota = new Perro(nombre, Raza, edad, dieta, fotoPath); 
            } else {
                mascota = new Gato(nombre, Raza, edad, dieta, fotoPath);
            }

            Controlador.getInstance().registrarMascota(mascota);
            JOptionPane.showMessageDialog(this, "Mascota registrada exitosamente");
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido para la edad", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
