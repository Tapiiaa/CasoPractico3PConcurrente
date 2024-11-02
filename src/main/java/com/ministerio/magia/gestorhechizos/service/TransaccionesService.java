package com.ministerio.magia.gestorhechizos.service;

import com.ministerio.magia.gestorhechizos.model.EventoMagico;
import com.ministerio.magia.gestorhechizos.model.Hechizo;
import com.ministerio.magia.gestorhechizos.repository.EventoMagicoRepository;
import com.ministerio.magia.gestorhechizos.repository.HechizoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransaccionesService {

    private final HechizoRepository hechizoRepository;
    private final EventoMagicoRepository eventoMagicoRepository;

    @Transactional
    public Hechizo lanzarHechizoConEvento(Hechizo hechizo, String descripcionEvento){
        Hechizo hechizoGuardado = hechizoRepository.save(hechizo); // Guardamos el hechizo

        // Creamos el evento magico relacionado con el hechizo.
        EventoMagico evento = new EventoMagico();
        evento.setDescripcion(descripcionEvento);
        evento.setFecha(LocalDateTime.now());
        evento.setUsuario(hechizo.getUsuario());

        // Guardamos el evento mágico
        eventoMagicoRepository.save(evento);

        return hechizoGuardado;
    }

}
