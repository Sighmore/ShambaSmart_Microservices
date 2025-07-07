package com.ShambaSmart.extension.repository;

import com.ShambaSmart.extension.model.AgronomyAdvice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgronomyAdviceRepository extends JpaRepository<AgronomyAdvice, Long> {


    AgronomyAdvice findByCropAndRegion(String crop, String region);
}
