package com.ministerio.magia.gestorhechizos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin")
    public String admin() {
        return "Área de Administración - Acceso concedido!";
    }
}
