package com.penzgtu.plant_care_tracker.controller;

import com.penzgtu.plant_care_tracker.dto.FlowerDto;
import com.penzgtu.plant_care_tracker.dto.FlowerResponseDto;
import com.penzgtu.plant_care_tracker.service.FlowerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flowers")
@RequiredArgsConstructor
public class FlowerController {

    private final FlowerService flowerService;

    @GetMapping
    public List<FlowerResponseDto> getAllFlowers() {
        return flowerService.getAllFlowers();
    }

    @PostMapping
    public FlowerResponseDto createFlower(@Valid @RequestBody FlowerDto request) {
        return flowerService.createFlower(request);
    }

    @GetMapping("/{id}")
    public FlowerResponseDto getFlower(@PathVariable Long id) {
        return flowerService.getFlower(id);
    }

    @PutMapping("/{id}")
    public FlowerResponseDto updateFlower(@PathVariable Long id, @Valid @RequestBody FlowerDto request) {
        return flowerService.updateFlower(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteFlower(@PathVariable Long id) {
        flowerService.deleteFlower(id);
    }

    @PostMapping("/{id}/water")
    public FlowerResponseDto waterFlower(@PathVariable Long id) {
        return flowerService.waterFlower(id);
    }

    @GetMapping("/need-watering")
    public List<FlowerResponseDto> getNeedWatering() {
        return flowerService.getNeedWatering();
    }
}