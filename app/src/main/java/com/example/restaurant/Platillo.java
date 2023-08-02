package com.example.restaurant;

public class Platillo {
    public String getNombre;
    public String getCalificacion;
    private int id;
    private String nombre;
    private double calificacion;

    public Platillo() {
    }

    public Platillo(int id, String nombre, double calificacion) {
        this.id = id;
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}
