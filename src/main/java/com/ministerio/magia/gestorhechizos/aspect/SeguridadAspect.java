package com.ministerio.magia.gestorhechizos.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Aspect
@Component
public class SeguridadAspect {

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    @Pointcut("execution(* com.ministerio.magia.gestorhechizos.service.*.*(..))")
    public void servicioMetodos() {}

    @Before("servicioMetodos()")
    public void verificarSeguridad(JoinPoint joinPoint) {
        executorService.submit(() -> {
            String nombreMetodo = joinPoint.getSignature().getName();
            System.out.println("VERIFICACIÓN DE SEGURIDAD CONCURRENTE - Acceso al método: " + nombreMetodo);
            // Lógica simulada de control de acceso
            boolean accesoPermitido = true; // Reemplazar con la lógica real de control de acceso

            if (!accesoPermitido) {
                throw new SecurityException("Acceso denegado al método: " + nombreMetodo);
            }
        });
    }
}

