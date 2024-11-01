package com.ministerio.magia.gestorhechizos.controller;

import com.ministerio.magia.gestorhechizos.model.Hechizo;
import com.ministerio.magia.gestorhechizos.service.HechizoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hechizos")
public class HechizoController {

    private final HechizoService hechizoService;

    @Autowired
    public HechizoController(HechizoService hechizoService) {
        this.hechizoService = hechizoService;
    }

    @PostMapping
    public String agregarHechizo(@RequestBody Hechizo hechizo) {
        hechizoService.agregarHechizo(hechizo);
        return "Hechizo agregado exitosamente";
    }

    @GetMapping
    public List<Hechizo> obtenerHechizos() {
        return hechizoService.obtenerTodosHechizos();
    }
}
