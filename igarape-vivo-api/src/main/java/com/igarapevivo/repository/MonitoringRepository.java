package com.igarapevivo.repository;

import com.igarapevivo.model.MonitoringData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoringRepository extends JpaRepository<MonitoringData, Long> {
}