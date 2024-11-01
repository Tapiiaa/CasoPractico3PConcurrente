package com.ministerio.magia.gestorhechizos.model;


import java.util.Date;
import java.util.List;

public class EventoMagico {
    private Long id;
    private String nombre;
    private Date fecha;
    private List<Hechizo> hechizos; // Los hechizos asociados a este evento

    // Constructor
    public EventoMagico(Long id, String nombre, Date fecha, List<Hechizo> hechizos) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hechizos = hechizos;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }
}
