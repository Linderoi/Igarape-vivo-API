package com.igarapevivo.controller;

import com.igarapevivo.model.MonitoringData;
import com.igarapevivo.repository.MonitoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/monitoring")
public class MonitoringDataController {

    @Autowired
    private MonitoringRepository repository;

    // GET: lista todos os dados de monitoramento
    @GetMapping
    public List<MonitoringData> getAllData() {
        return repository.findAll();
    }

    // POST: adiciona novo dado de monitoramento
    @PostMapping
    public MonitoringData createData(@RequestParam String sensorName,
                                     @RequestParam float measurementValue) {
        MonitoringData data = new MonitoringData();
        data.setSensorName(sensorName);
        data.setMeasurementValue(measurementValue);
        data.setMeasurementTimestamp(LocalDateTime.now());
        return repository.save(data);
    }
}