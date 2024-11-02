package com.ministerio.magia.gestorhechizos.service;

import com.ministerio.magia.gestorhechizos.aspect.annotations.ConcurrentExecution;
import com.ministerio.magia.gestorhechizos.model.EventoMagico;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class EventoMagicoService {

    private final List<EventoMagico> eventosMagicos = new CopyOnWriteArrayList<>(); // Para manejar la concurrencia de forma segura

    @ConcurrentExecution
    public void agregarEvento(EventoMagico eventoMagico) {
        if(eventoMagico == null || eventoMagico.getNombre() == null || eventoMagico.getTipo() == null) {
            throw new IllegalArgumentException("El evento mágico no puede ser nulo y debe tener nombre y tipo");
        }
        eventosMagicos.add(eventoMagico);
        System.out.println("Evento mágico agregado: " + eventoMagico + " en el hilo: " + Thread.currentThread().getName());
    }
}
