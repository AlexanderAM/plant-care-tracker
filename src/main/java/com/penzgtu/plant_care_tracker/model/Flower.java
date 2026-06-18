package com.penzgtu.plant_care_tracker.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "flowers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 100)
    private String type;

    @Column(name = "watering_interval_days", nullable = false)
    private Integer wateringIntervalDays;

    @Column(name = "room_id", nullable = false)
    private Long roomId;

    @Column(name = "last_watering_date", nullable = false)
    private LocalDate lastWateringDate;
}