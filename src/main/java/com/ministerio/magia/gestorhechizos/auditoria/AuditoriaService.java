package com.ministerio.magia.gestorhechizos.auditoria;

//Esta clase se encarga de registrar eventos en la aplicación

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    public void registrarEvento(String descripcion) {
        String registro = "Evento registrado: " + descripcion + " en " + java.time.LocalDateTime.now();
        auditoriaRepository.guardarRegistro(registro);
    }

    public void mostrarTodosLosRegistros() {
        auditoriaRepository.obtenerTodosLosRegistros().forEach(System.out::println);
    }
}

