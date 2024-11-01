package com.ministerio.magia.gestorhechizos.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class AuditoriaAspect {

    // Define un punto de corte para los métodos de los servicios. Interceptar todos los métodos de los servicios.
    @Pointcut("execution(* com.ministerio.magia.gestorhechizos.service.*.*(..))")
    public void servicioMetodos() {}

    // Antes de la ejecución de un método de un servicio, se imprime un mensaje con el nombre del método y los argumentos.
    @Before("servicioMetodos()")
    public void antesDeMetodo(JoinPoint joinPoint) {
        String nombreMetodo = joinPoint.getSignature().getName();
        Object[] argumentos = joinPoint.getArgs();
        log.info("AUDITORÍA - Invocando método: {} con argumentos: {} a las {}", nombreMetodo, argumentos, LocalDateTime.now());
    }

    // Después de la ejecución de un método de un servicio, se imprime un mensaje con el nombre del método y el resultado.
    @AfterReturning(pointcut = "servicioMetodos()", returning = "resultado")
    public void despuesDeMetodo(JoinPoint joinPoint, Object resultado) {
        String nombreMetodo = joinPoint.getSignature().getName();
        log.info("AUDITORÍA - Método: {} ejecutado con éxito. Resultado: {} a las {}", nombreMetodo, resultado, LocalDateTime.now());
    }
}
