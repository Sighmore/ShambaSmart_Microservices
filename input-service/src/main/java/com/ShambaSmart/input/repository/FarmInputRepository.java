package com.ShambaSmart.input.repository;

import com.ShambaSmart.input.model.FarmInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmInputRepository extends JpaRepository<FarmInput,Long> {


}
