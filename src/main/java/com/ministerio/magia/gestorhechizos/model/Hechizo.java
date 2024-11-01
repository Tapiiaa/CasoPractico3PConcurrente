package com.ministerio.magia.gestorhechizos.model;

public class Hechizo {
    private String nombre;
    private String descripcion;
    private int nivelMagico;

    public Hechizo(String nombre, String descripcion, int nivelMagico) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivelMagico = nivelMagico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNivelMagico() {
        return nivelMagico;
    }

    public void setNivelMagico(int nivelMagico) {
        this.nivelMagico = nivelMagico;
    }

    @Override
    public String toString() {
        return "Hechizo{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", nivelMagico=" + nivelMagico +
                '}';
    }
}
