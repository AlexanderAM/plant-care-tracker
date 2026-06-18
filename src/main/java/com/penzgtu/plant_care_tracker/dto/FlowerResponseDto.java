package com.penzgtu.plant_care_tracker.dto;

import com.penzgtu.plant_care_tracker.model.Flower;
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
    private Boolean needWatering;

    public static FlowerResponseDto fromEntity(Flower flower) {
        FlowerResponseDto dto = new FlowerResponseDto();
        dto.setId(flower.getId());
        dto.setName(flower.getName());
        dto.setDescription(flower.getDescription());
        dto.setWateringIntervalDays(flower.getWateringIntervalDays());
        dto.setRoom(flower.getRoom().getName());
        dto.setLastWateringDate(flower.getLastWateringDate());

        if (flower.getLastWateringDate() == null) {
            dto.setNeedWatering(true);
        } else {
            LocalDate nextWateringDate = flower.getLastWateringDate().plusDays(flower.getWateringIntervalDays());
            dto.setNeedWatering(!LocalDate.now().isBefore(nextWateringDate));
        }
        return dto;
    }
}
