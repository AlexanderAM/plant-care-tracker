package com.penzgtu.plant_care_tracker.repository;

import com.penzgtu.plant_care_tracker.model.Flower;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlowerRepository extends JpaRepository<Flower, Long> {

}
