package main.java.model;

import java.io.Serializable;
import java.util.Date;
import main.java.model.Mascota;
import main.java.model.Dueño;

public class Actividad implements Serializable {
    private String tipo;
    private Date fecha;
    private String descripcion;

    public Actividad(String tipo, Date fecha, String descripcion) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
