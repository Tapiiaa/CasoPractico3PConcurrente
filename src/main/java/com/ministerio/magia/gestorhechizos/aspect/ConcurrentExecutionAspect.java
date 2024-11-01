package com.ministerio.magia.gestorhechizos.aspect;

import org.springframework.stereotype.Component;
import org.springframework.aop.framework.AopContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class ConcurrentExecutionAspect {

    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public void handleConcurrentExecution(Runnable task) {
        executorService.submit(() -> {
            try {
                System.out.println("Inicio de ejecución en hilo: " + Thread.currentThread().getName());
                task.run();
                System.out.println("Finalización en hilo: " + Thread.currentThread().getName());
            } catch (Throwable throwable) {
                System.err.println("Error en la ejecución concurrente: " + throwable.getMessage());
            }
        });
    }

    public void shutdown() {
        try {
            System.out.println("Cerrando el executor...");
            executorService.shutdown();
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
