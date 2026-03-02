package com.igarapevivo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "monitoring_data")
public class MonitoringData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sensor_name", nullable = false)
    private String sensorName;

    @Column(name = "measurement_value", nullable = false)
    private float measurementValue;

    @Column(name = "measurement_timestamp", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime measurementTimestamp;

    public MonitoringData() {}

    public MonitoringData(String sensorName, float measurementValue, LocalDateTime measurementTimestamp) {
        this.sensorName = sensorName;
        this.measurementValue = measurementValue;
        this.measurementTimestamp = measurementTimestamp;
    }

    public Long getId() { return id; }
    public String getSensorName() { return sensorName; }
    public void setSensorName(String sensorName) { this.sensorName = sensorName; }
    public float getMeasurementValue() { return measurementValue; }
    public void setMeasurementValue(float measurementValue) { this.measurementValue = measurementValue; }
    public LocalDateTime getMeasurementTimestamp() { return measurementTimestamp; }
    public void setMeasurementTimestamp(LocalDateTime measurementTimestamp) { this.measurementTimestamp = measurementTimestamp; }
}