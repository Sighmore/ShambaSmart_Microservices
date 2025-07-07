package com.ShambaSmart.extension.repository;

import com.ShambaSmart.extension.model.FarmAlert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FarmAlertRepository extends JpaRepository<FarmAlert, Long> {

    List<FarmAlert> findByFarmId(String farmId);
}
