package com.ministerio.magia.gestorhechizos.service;

import com.ministerio.magia.gestorhechizos.model.Hechizo;
import com.ministerio.magia.gestorhechizos.aspect.annotations.ConcurrentExecution;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HechizoService {

    private final List<Hechizo> hechizos = new ArrayList<>();

    @ConcurrentExecution
    public void agregarHechizo(Hechizo hechizo) {
        hechizos.add(hechizo);
        System.out.println("Hechizo agregado: " + hechizo + " en el hilo: " + Thread.currentThread().getName());
    }

    @ConcurrentExecution
    public List<Hechizo> obtenerTodosHechizos() {
        System.out.println("Obteniendo todos los hechizos en el hilo: " + Thread.currentThread().getName());
        return new ArrayList<>(hechizos);
    }
}
