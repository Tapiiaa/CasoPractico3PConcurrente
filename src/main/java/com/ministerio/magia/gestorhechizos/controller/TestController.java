package com.ministerio.magia.gestorhechizos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "El servidor está funcionando correctamente!";
    }
}
