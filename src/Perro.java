package main.java.model;
import javax.swing.JOptionPane;
import java.util.Random;
import main.java.model.Mascota;
import main.java.model.Dueño;

public class Perro extends Mascota {
    private String imagen;

    public Perro(String nombre, String Raza, int edad, String dieta, String fotoPath) {
        super(nombre, "Perro", Raza, edad, dieta, fotoPath);
        Random random = new Random();
        int index = random.nextInt(5) + 1;
        imagen = "img/Perro" + index + ".png";
    }

    @Override
    public void mostrarDetalles() {
        String mensaje = "Detalles del Perro:\n" +
                         "Nombre: " + getNombre() + "\n" +
                         "Raza: " + getRaza() + "\n" +
                         "Edad: " + getEdad() + "\n" +
                         "Dieta: " + getDieta();

        JOptionPane.showMessageDialog(null, mensaje);
    }

}
