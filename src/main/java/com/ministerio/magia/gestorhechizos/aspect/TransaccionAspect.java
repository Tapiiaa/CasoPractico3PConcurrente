package com.ministerio.magia.gestorhechizos.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Aspect
@Component
public class TransaccionAspect {

    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    @Pointcut("execution(* com.ministerio.magia.gestorhechizos.service.*.*(..))")
    public void servicioMetodos() {}

    @Around("servicioMetodos()")
    public Object gestionarTransaccion(ProceedingJoinPoint joinPoint) throws Throwable {
        return executorService.submit(() -> {
            Object resultado;
            System.out.println("INICIO DE TRANSACCIÓN CONCURRENTE - Método: " + joinPoint.getSignature().getName());
            try {
                // Iniciar y gestionar transacción
                resultado = joinPoint.proceed();
                System.out.println("TRANSACCIÓN COMPLETADA - Método: " + joinPoint.getSignature().getName());
            } catch (Exception e) {
                System.err.println("ERROR EN TRANSACCIÓN - Método: " + joinPoint.getSignature().getName() + ". Revirtiendo...");
                throw e;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
            return resultado;
        }).get(); // Usar get para devolver el resultado de la tarea
    }
}
