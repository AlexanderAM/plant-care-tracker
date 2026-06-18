package com.penzgtu.plant_care_tracker.repository;

import com.penzgtu.plant_care_tracker.model.Flower;
import com.penzgtu.plant_care_tracker.model.Room;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FlowerRepository extends JpaRepository<Flower, Long> {

    List<Flower> findByRoom(Room room);

    boolean existsByRoomId(Long roomId);

    @Query(value = "SELECT * FROM flowers WHERE last_watering_date IS NULL OR DATEDIFF('DAY', last_watering_date, CURRENT_DATE) >= watering_interval_days", nativeQuery = true)
    List<Flower> findNeedWatering();
}
