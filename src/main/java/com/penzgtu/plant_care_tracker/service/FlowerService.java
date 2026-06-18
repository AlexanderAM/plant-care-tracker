package com.penzgtu.plant_care_tracker.service;

import com.penzgtu.plant_care_tracker.dto.FlowerDto;
import com.penzgtu.plant_care_tracker.dto.FlowerResponseDto;
import com.penzgtu.plant_care_tracker.exception.ResourceNotFoundException;
import com.penzgtu.plant_care_tracker.model.Flower;
import com.penzgtu.plant_care_tracker.model.Room;
import com.penzgtu.plant_care_tracker.repository.FlowerRepository;
import com.penzgtu.plant_care_tracker.repository.RoomRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
                .map(FlowerResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    public FlowerResponseDto getFlower(Long id) {
        Flower flower = flowerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flower not found"));
        return FlowerResponseDto.fromEntity(flower);
    }

    public FlowerResponseDto createFlower(FlowerDto request) {
        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));
        Flower flower = new Flower();
        flower.setName(request.getName());
        flower.setDescription(request.getDescription());
        flower.setWateringIntervalDays(request.getWateringIntervalDays());
        flower.setRoom(room);
        Flower saved = flowerRepository.save(flower);
        return FlowerResponseDto.fromEntity(saved);
    }

    public FlowerResponseDto updateFlower(Long id, FlowerDto request) {
        Flower flower = flowerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flower not found"));
        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));
        flower.setName(request.getName());
        flower.setDescription(request.getDescription());
        flower.setWateringIntervalDays(request.getWateringIntervalDays());
        flower.setRoom(room);
        Flower updated = flowerRepository.save(flower);
        return FlowerResponseDto.fromEntity(updated);
    }

    public void deleteFlower(Long id) {
        if (!flowerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Flower not found");
        }
        flowerRepository.deleteById(id);
    }

    public FlowerResponseDto waterFlower(Long id) {
        Flower flower = flowerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flower not found"));
        flower.setLastWateringDate(LocalDate.now());
        flowerRepository.save(flower);
        return FlowerResponseDto.fromEntity(flower);
    }

    public List<FlowerResponseDto> getFlowersInRoom(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));
        return flowerRepository.findByRoom(room).stream()
                .map(FlowerResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    public List<FlowerResponseDto> getNeedWatering() {
        return flowerRepository.findNeedWatering().stream()
                .map(FlowerResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
}
