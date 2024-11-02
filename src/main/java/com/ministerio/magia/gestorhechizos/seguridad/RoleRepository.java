package com.ministerio.magia.gestorhechizos.seguridad;

import com.ministerio.magia.gestorhechizos.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
