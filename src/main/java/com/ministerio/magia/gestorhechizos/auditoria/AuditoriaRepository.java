package com.ministerio.magia.gestorhechizos.auditoria;

//Esta clase sirve para guardar los registros de auditoría en memoria

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuditoriaRepository {

    private final List<String> registrosAuditoria = new ArrayList<>();

    public void guardarRegistro(String registro) {
        registrosAuditoria.add(registro);
        System.out.println("AUDITORÍA - Registro guardado: " + registro);
    }

    public List<String> obtenerTodosLosRegistros() {
        return new ArrayList<>(registrosAuditoria);
    }
}
