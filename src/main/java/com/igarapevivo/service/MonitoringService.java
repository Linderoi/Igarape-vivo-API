package com.igarapevivo.service;

import com.igarapevivo.model.MonitoringData;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MonitoringService {

    private final List<MonitoringData> database = new ArrayList<>();
    private Long idCounter = 1L;

    public MonitoringData analyze(Double waterLevel) {
        String risk;
        if (waterLevel >= 80) {
            risk = "ALTO";
        } else if (waterLevel >= 50) {
            risk = "MÉDIO";
        } else {
            risk = "BAIXO";
        }

        MonitoringData data = new MonitoringData();
        database.add(data);
        return data;
    }

    public List<MonitoringData> listAll() {
        return database;
    }
}