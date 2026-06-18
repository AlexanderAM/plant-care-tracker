package com.penzgtu.plant_care_tracker.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RoomDto {
    @NotBlank(message = "Name is required")
    private String name;
}