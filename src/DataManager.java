package main.java.utils;

import main.java.model.Mascota;
import main.java.model.Dueño;

import javax.swing.*;
import java.io.*;
import java.util.List;

public class DataManager {
    private static final String FILE_PATH = "datos.dat";

    /**
     * Guarda las listas de mascotas y dueños en un archivo.
     *
     * @param mascotas la lista de mascotas a guardar
     * @param dueños   la lista de dueños a guardar
     * @throws IOException si ocurre un error durante la escritura del archivo
     */
    public static void guardarDatos(List<Mascota> mascotas, List<Dueño> dueños) throws IOException {
        System.out.println("Guardando datos...");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(mascotas);
            oos.writeObject(dueños);
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            // Mostrar un diálogo de error
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                    System.out.println("Archivo cerrado correctamente.");
                } catch (IOException e) {
                    // Manejar la excepción adecuadamente
                    JOptionPane.showMessageDialog(null, "Error al cerrar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Carga las listas de mascotas y dueños desde un archivo.
     *
     * @param mascotas la lista de mascotas a cargar
     * @param dueños   la lista de dueños a cargar
     * @throws IOException            si ocurre un error durante la lectura del archivo
     * @throws ClassNotFoundException si la clase de un objeto deserializado no puede ser encontrada
     */
    @SuppressWarnings("unchecked")
    public static void cargarDatos(List<Mascota> mascotas, List<Dueño> dueños) throws IOException, ClassNotFoundException {
        System.out.println("Cargando datos...");
        File file = new File(FILE_PATH);
        if (file.exists()) {
            System.out.println("El archivo existe. Procediendo con la carga.");
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(file));
                mascotas.addAll((List<Mascota>) ois.readObject());
                dueños.addAll((List<Dueño>) ois.readObject());
                System.out.println("Datos cargados correctamente.");
            } catch (IOException e) {
                // Mostrar un diálogo de error
                JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
                throw e; // Rethrow the exception to let the caller handle it if necessary
            } catch (ClassNotFoundException e) {
                // Mostrar un diálogo de error
                JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
                throw e; // Rethrow the exception to let the caller handle it if necessary
            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                        System.out.println("Archivo cerrado correctamente.");
                    } catch (IOException e) {
                        // Manejar la excepción adecuadamente
                        JOptionPane.showMessageDialog(null, "Error al cerrar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("El archivo no existe. No se cargaron datos.");
        }
    }
}
