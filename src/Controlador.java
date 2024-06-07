package main.java.controller;

import main.java.model.Dueño;
import main.java.model.Mascota;
import main.java.view.VentanaPrincipal;
import main.java.view.VentanaServicios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private static Controlador instance;
    private List<Mascota> mascotas;
    private List<Dueño> dueños;
    private VentanaPrincipal ventanaPrincipal;
    private VentanaServicios ventanaServicios;

    private Controlador() {
        mascotas = new ArrayList<>();
        dueños = new ArrayList<>();
        cargarDatos();
        ventanaPrincipal = new VentanaPrincipal(this, mascotas, dueños);
        ventanaServicios = new VentanaServicios(this, dueños);
        ventanaPrincipal.setVisible(true);
    }

    public static Controlador getInstance() {
        if (instance == null) {
            instance = new Controlador();
        }
        return instance;
    }

    private void cargarDatos() {
        try {
            DataManager.cargarDatos(mascotas, dueños);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void guardarDatos() {
        try {
            DataManager.guardarDatos(mascotas, dueños);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registrarMascota(Mascota mascota) {
        mascotas.add(mascota);
        guardarDatos();
        ventanaPrincipal.actualizarMosaico();
    }

    public void registrarDueño(Dueño dueño) {
        dueños.add(dueño);
        guardarDatos();
    }

    public void mostrarServicios() {
        ventanaServicios.setVisible(true);
    }

    public void iniciar() {
        ventanaPrincipal.setVisible(true);
    }
}
