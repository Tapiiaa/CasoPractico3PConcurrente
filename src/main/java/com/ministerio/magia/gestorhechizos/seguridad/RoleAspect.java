package com.ministerio.magia.gestorhechizos.seguridad;


import com.ministerio.magia.gestorhechizos.annotations.RequiresRole;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RoleAspect {

    private String currentUserRole;

    public void setCurrentUserRole(String role) {
        this.currentUserRole = role;
    }

    @Before("@annotation(com.ministerio.magia.gestorhechizos.annotations.RequiresRole) && @annotation(role)")
    public void checkUserRole(RequiresRole role) {
        if (currentUserRole == null || !currentUserRole.equals(role.value())) {
            throw new SecurityException("Acceso denegado. No tienes el rol requerido: " + role.value());
        }
    }
}
