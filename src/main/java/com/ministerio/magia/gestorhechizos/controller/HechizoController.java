package com.ministerio.magia.gestorhechizos.controller;

import com.ministerio.magia.gestorhechizos.model.Hechizo;
import com.ministerio.magia.gestorhechizos.service.HechizoService;
import com.ministerio.magia.gestorhechizos.service.TransaccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hechizos")
public class HechizoController {

    private final HechizoService hechizoService;
    private final TransaccionesService transaccionesService;

    @Autowired
    public HechizoController(HechizoService hechizoService, TransaccionesService transaccionesService) {
        this.hechizoService = hechizoService;
        this.transaccionesService = transaccionesService;
    }

    @GetMapping
    public List<Hechizo> obtenerHechizos() {
        return hechizoService.obtenerTodosHechizos();
    }

    @PostMapping
    public String agregarHechizo(@RequestBody Hechizo hechizo) {
        hechizoService.agregarHechizo(hechizo);
        return "Hechizo agregado exitosamente";
    }

    @PostMapping("/lanzar")
    public Hechizo lanzarHechizo(@RequestBody Hechizo hechizo, @RequestParam String descripcionEvento) {
        return transaccionesService.lanzarHechizoConEvento(hechizo, descripcionEvento);
    }

    @PutMapping("/{id}")
    public String actualizarHechizo(@PathVariable Long id, @RequestBody Hechizo hechizo) {
        hechizoService.actualizarHechizo(id, hechizo);
        return "Hechizo actualizado exitosamente";
    }

    @DeleteMapping("/{id}")
    public String eliminarHechizo(@PathVariable Long id) {
        hechizoService.eliminarHechizo(id);
        return "Hechizo eliminado exitosamente";
    }
}
