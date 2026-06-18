package com.penzgtu.plant_care_tracker.controller;

import com.penzgtu.plant_care_tracker.model.Flower;
import com.penzgtu.plant_care_tracker.repository.FlowerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flowers")
@RequiredArgsConstructor
public class FlowerController {

    private final FlowerRepository flowerRepository;

    @GetMapping
    public List<Flower> getAllFlowers() {
        return flowerRepository.findAll();
    }

    @PostMapping
    public Flower createFlower(@RequestBody Flower flower) {
        // Пока просто сохраняем, предполагая, что lastWateringDate передан
        return flowerRepository.save(flower);
    }

    @GetMapping("/{id}")
    public Flower getFlower(@PathVariable Long id) {
        return flowerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flower not found"));
    }

    @PutMapping("/{id}")
    public Flower updateFlower(@PathVariable Long id, @RequestBody Flower flower) {
        flower.setId(id);
        return flowerRepository.save(flower);
    }

    @DeleteMapping("/{id}")
    public void deleteFlower(@PathVariable Long id) {
        flowerRepository.deleteById(id);
    }
    
}