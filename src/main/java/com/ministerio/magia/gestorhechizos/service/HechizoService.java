package com.ministerio.magia.gestorhechizos.service;

import com.ministerio.magia.gestorhechizos.model.Hechizo;
import com.ministerio.magia.gestorhechizos.aspect.annotations.ConcurrentExecution;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class HechizoService {

    private final List<Hechizo> hechizos = new CopyOnWriteArrayList<>(); // Para manejar la concurrencia de forma segura

    @ConcurrentExecution
    public void agregarHechizo(Hechizo hechizo) {
        if(hechizo == null || hechizo.getNombre() == null || hechizo.getTipo() == null) {
            throw new IllegalArgumentException("El hechizo no puede ser nulo y debe tener nombre y tipo");
        }
        hechizos.add(hechizo);
        System.out.println("Hechizo agregado: " + hechizo + " en el hilo: " + Thread.currentThread().getName());
    }

    @ConcurrentExecution
    public List<Hechizo> obtenerTodosHechizos() {
        System.out.println("Obteniendo todos los hechizos en el hilo: " + Thread.currentThread().getName());
        return new CopyOnWriteArrayList<>(hechizos);
    }

    public boolean eliminarHechizo(Long id){
        return hechizos.removeIf(hechizo -> hechizo.getId().equals(id));
    }

    public void actualizarHechizo(Long id, Hechizo hechizo) {
        if(hechizo == null || hechizo.getNombre() == null || hechizo.getTipo() == null) {
            throw new IllegalArgumentException("El hechizo no puede ser nulo y debe tener nombre y tipo");
        }
        hechizos.stream()
                .filter(hechizo1 -> hechizo1.getId().equals(id))
                .findFirst()
                .ifPresent(hechizo1 -> {
                    hechizo1.setNombre(hechizo.getNombre());
                    hechizo1.setTipo(hechizo.getTipo());
                });
    }
}
