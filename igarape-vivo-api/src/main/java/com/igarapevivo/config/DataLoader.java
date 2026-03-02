package com.igarapevivo.config;

import com.igarapevivo.model.MonitoringData;
import com.igarapevivo.repository.MonitoringRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final MonitoringRepository repository;

    public DataLoader(MonitoringRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        repository.save(new MonitoringData("Sensor 1", 12.5f, LocalDateTime.now()));
        repository.save(new MonitoringData("Sensor 2", 15.3f, LocalDateTime.now()));
        repository.save(new MonitoringData("Sensor 3", 9.8f, LocalDateTime.now()));
        System.out.println("✅ Dados de teste carregados no H2!");
    }
}