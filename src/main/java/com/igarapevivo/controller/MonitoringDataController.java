package com.igarapevivo.controller;

import com.igarapevivo.model.MonitoringData;
import com.igarapevivo.repository.MonitoringRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/monitoring")
public class MonitoringDataController {

    @Autowired
    private MonitoringRepository repository;

    // GET: lista todos os dados de monitoramento
    @GetMapping
    public ResponseEntity<List<MonitoringData>> getAllData() {
        return ResponseEntity.ok(repository.findAll());
    }

    // POST: adiciona novo dado de monitoramento
    @PostMapping
    public ResponseEntity<MonitoringData> createData(
            @RequestParam
            @NotBlank(message = "sensorName must not be blank")
            @Size(max = 100, message = "sensorName must not exceed 100 characters")
            String sensorName,

            @RequestParam
            @PositiveOrZero(message = "measurementValue must be zero or positive")
            Float measurementValue) {

        MonitoringData data = new MonitoringData();
        data.setSensorName(sensorName.trim());
        data.setMeasurementValue(measurementValue);
        data.setMeasurementTimestamp(LocalDateTime.now());
        MonitoringData saved = repository.save(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
