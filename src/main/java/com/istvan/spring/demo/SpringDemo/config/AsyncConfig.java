package com.istvan.spring.demo.SpringDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name="asyncBean")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor poolExecutor = new ThreadPoolTaskExecutor();
        poolExecutor.setCorePoolSize(3);
        poolExecutor.setMaxPoolSize(3);
        poolExecutor.setQueueCapacity(100);
        poolExecutor.setThreadNamePrefix("");
        poolExecutor.initialize();
        return poolExecutor;
    }

}
