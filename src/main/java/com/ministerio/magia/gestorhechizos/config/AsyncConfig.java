package com.ministerio.magia.gestorhechizos.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Slf4j
@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        log.info("Configurando el executor para realizar las tareas de forma asíncrona...");
        // Configuración del executor
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // Configuracion del pool de hilos.
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("Gestor-Hechizos-");

        executor.initialize();
        return executor;
    }
}
