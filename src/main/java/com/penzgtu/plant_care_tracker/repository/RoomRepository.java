package com.penzgtu.plant_care_tracker.repository;

import com.penzgtu.plant_care_tracker.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

}