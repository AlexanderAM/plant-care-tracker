package com.penzgtu.plant_care_tracker.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class FlowerResponseDto {
    private Long id;
    private String name;
    private String description;
    private Integer wateringIntervalDays;
    private String room;
    private LocalDate lastWateringDate;
}
