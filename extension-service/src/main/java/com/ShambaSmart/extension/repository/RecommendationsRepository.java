package com.ShambaSmart.extension.repository;

import com.ShambaSmart.extension.model.Recommendations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationsRepository extends JpaRepository<Recommendations,Long> {


    Recommendations findByFarmId(String farmId);
}
