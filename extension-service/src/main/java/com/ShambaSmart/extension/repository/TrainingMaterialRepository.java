package com.ShambaSmart.extension.repository;

import com.ShambaSmart.extension.model.TrainingMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingMaterialRepository extends JpaRepository<TrainingMaterial, Long> {


    List<TrainingMaterial> findByTopic(String topic);
}
