package com.ministerio.magia.gestorhechizos.seguridad;

import com.ministerio.magia.gestorhechizos.model.Role;
import com.ministerio.magia.gestorhechizos.model.Usuario;
import com.ministerio.magia.gestorhechizos.seguridad.RoleRepository;
import com.ministerio.magia.gestorhechizos.seguridad.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeguridadService {
    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;



}
