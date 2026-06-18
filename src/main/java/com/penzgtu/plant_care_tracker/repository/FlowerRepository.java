package com.penzgtu.plant_care_tracker.repository;

import com.penzgtu.plant_care_tracker.model.Flower;
import com.penzgtu.plant_care_tracker.model.Room;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FlowerRepository extends JpaRepository<Flower, Long> {

    List<Flower> findByRoom(Room room);

    boolean existsByRoomId(Long roomId);

    @Query("SELECT f FROM Flower f WHERE (CURRENT_DATE - f.lastWateringDate) >= f.wateringIntervalDays OR f.lastWateringDate IS NULL")
    List<Flower> findNeedWatering();
}
