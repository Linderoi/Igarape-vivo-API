package com.igarapevivo.controller;

import com.igarapevivo.model.MonitoringData;
import com.igarapevivo.repository.MonitoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/monitoring")
public class MonitoringDataController {

    @Autowired
    private MonitoringRepository repository;

    // GET: lista todos os dados de monitoramento
    @GetMapping
    public ResponseEntity<List<MonitoringData>> getAllData() {
        List<MonitoringData> data = repository.findAll();
        return ResponseEntity.ok(data);
    }

    // POST: adiciona novo dado de monitoramento
    @PostMapping
    public ResponseEntity<?> createData(@RequestParam String sensorName,
                                        @RequestParam Float measurementValue) {

        // Validate sensorName: must not be blank
        if (sensorName == null || sensorName.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", "sensorName must not be blank"));
        }

        // Validate sensorName: enforce a reasonable max length
        if (sensorName.length() > 255) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", "sensorName must not exceed 255 characters"));
        }

        // Validate measurementValue: must not be negative
        if (measurementValue < 0) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", "measurementValue must not be negative"));
        }

        // Validate measurementValue: must be a finite number
        if (Float.isNaN(measurementValue) || Float.isInfinite(measurementValue)) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", "measurementValue must be a finite number"));
        }

        MonitoringData data = new MonitoringData();
        data.setSensorName(sensorName.trim());
        data.setMeasurementValue(measurementValue);
        data.setMeasurementTimestamp(LocalDateTime.now());

        MonitoringData saved = repository.save(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
