package main.java;

import main.java.controller.Controlador;

public class Main {
    public static void main(String[] args) {
        Controlador controlador = Controlador.getInstance(); 
        controlador.iniciar(); 
    }
}
