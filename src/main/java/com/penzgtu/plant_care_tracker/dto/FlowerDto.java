package com.penzgtu.plant_care_tracker.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Data
public class FlowerDto {
    @NotBlank(message = "Name is required")
    private String name;
    private String description;
    @NotNull @Min(1)
    private Integer wateringIntervalDays;
    @NotNull
    private Long roomId;
}
