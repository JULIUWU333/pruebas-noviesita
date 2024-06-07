package main.java.model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import main.java.model.Mascota;
import main.java.model.Dueño;


public abstract class Mascota implements Serializable {
    private String nombre;
    private String especie;
    private String Raza;
    private int edad;
    private String dieta;
    private String fotoPath;
    private List<Actividad> actividades;

    // Debes definir la variable "imagen" si planeas utilizarla en el método getLabel()

    public Mascota(String nombre, String especie, String Raza, int edad, String dieta, String fotoPath) {
        this.nombre = nombre;
        this.especie = especie;
        this.Raza = Raza;
        this.edad = edad;
        this.dieta = dieta;
        this.fotoPath = fotoPath;
        this.actividades = new ArrayList<>();
    }

    public abstract void mostrarDetalles();

    // Este método devuelve un JLabel con la información de la mascota
    public JLabel getLabel() {
        ImageIcon icono = new ImageIcon(fotoPath); // Utiliza el fotoPath para crear el ImageIcon
        Image img = icono.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH);
        icono = new ImageIcon(img);
        JLabel label = new JLabel(nombre, icono, JLabel.CENTER); // Utiliza el nombre como texto del JLabel
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return label;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String Raza) {
        this.Raza = Raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public String getFotoPath() {
        return fotoPath;
    }

    public void setFotoPath(String fotoPath) {
        this.fotoPath = fotoPath;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void agregarActividad(Actividad actividad) {
        actividades.add(actividad);
    }

}