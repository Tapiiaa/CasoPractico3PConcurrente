package com.ministerio.magia.gestorhechizos.repository;

import com.ministerio.magia.gestorhechizos.model.EventoMagico;
import com.ministerio.magia.gestorhechizos.model.Hechizo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoMagicoRepository extends JpaRepository<EventoMagico, Long> {
}
