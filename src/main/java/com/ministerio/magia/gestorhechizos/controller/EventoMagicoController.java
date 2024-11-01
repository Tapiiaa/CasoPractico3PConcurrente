package com.ministerio.magia.gestorhechizos.controller;

import com.ministerio.magia.gestorhechizos.model.EventoMagico;
import com.ministerio.magia.gestorhechizos.service.EventoMagicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoMagicoController {

    private final EventoMagicoService eventoMagicoService;

    @Autowired
    public EventoMagicoController(EventoMagicoService eventoMagicoService) {
        this.eventoMagicoService = eventoMagicoService;
    }

    @GetMapping
    public List<EventoMagico> obtenerEventosMagicos() {
        return eventoMagicoService.obtenerTodosEventos();
    }

    @PostMapping
    public String agregarEventoMagico(@RequestBody EventoMagico evento) {
        eventoMagicoService.agregarEvento(evento);
        return "Evento mágico agregado exitosamente";
    }
}
