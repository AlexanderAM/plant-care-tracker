package com.penzgtu.plant_care_tracker.service;

import com.penzgtu.plant_care_tracker.dto.FlowerDto;
import com.penzgtu.plant_care_tracker.dto.FlowerResponseDto;
import com.penzgtu.plant_care_tracker.model.Flower;
import com.penzgtu.plant_care_tracker.model.Room;
import com.penzgtu.plant_care_tracker.repository.FlowerRepository;
import com.penzgtu.plant_care_tracker.repository.RoomRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlowerService {

    private final FlowerRepository flowerRepository;
    private final RoomRepository roomRepository;

    public List<FlowerResponseDto> getAllFlowers() {
        return flowerRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public FlowerResponseDto getFlower(Long id) {
        Flower flower = flowerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Flower not found"));
        return toResponse(flower);
    }

    public FlowerResponseDto createFlower(FlowerDto request) {
        Room room = roomRepository.findById(request.getRoomId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found"));
        Flower flower = new Flower();
        flower.setName(request.getName());
        flower.setDescription(request.getDescription());
        flower.setWateringIntervalDays(request.getWateringIntervalDays());
        flower.setRoom(room);
        Flower saved = flowerRepository.save(flower);
        return toResponse(saved);
    }

    public FlowerResponseDto updateFlower(Long id, FlowerDto request) {
        Flower flower = flowerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Flower not found"));
        Room room = roomRepository.findById(request.getRoomId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found"));
        flower.setName(request.getName());
        flower.setDescription(request.getDescription());
        flower.setWateringIntervalDays(request.getWateringIntervalDays());
        flower.setRoom(room);
        Flower updated = flowerRepository.save(flower);
        return toResponse(updated);
    }

    public void deleteFlower(Long id) {
        if (!flowerRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flower not found");
        }
        flowerRepository.deleteById(id);
    }

    private FlowerResponseDto toResponse(Flower flower) {
        FlowerResponseDto response = new FlowerResponseDto();
        response.setId(flower.getId());
        response.setName(flower.getName());
        response.setDescription(flower.getDescription());
        response.setWateringIntervalDays(flower.getWateringIntervalDays());
        response.setRoom(flower.getRoom().getName());
        response.setLastWateringDate(flower.getLastWateringDate());
        return response;
    }

    public FlowerResponseDto waterFlower(Long id) {
        Flower flower = flowerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Flower not found"));
        flower.setLastWateringDate(LocalDate.now());
        flowerRepository.save(flower);
        return toResponse(flower);
    }

}