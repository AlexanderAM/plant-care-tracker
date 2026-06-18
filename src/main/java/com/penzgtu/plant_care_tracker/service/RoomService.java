package com.penzgtu.plant_care_tracker.service;

import com.penzgtu.plant_care_tracker.dto.RoomDto;
import com.penzgtu.plant_care_tracker.dto.RoomResponseDto;
import com.penzgtu.plant_care_tracker.exception.ResourceConflictException;
import com.penzgtu.plant_care_tracker.exception.ResourceNotFoundException;
import com.penzgtu.plant_care_tracker.model.Room;
import com.penzgtu.plant_care_tracker.repository.FlowerRepository;
import com.penzgtu.plant_care_tracker.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final FlowerRepository flowerRepository;

    public List<RoomResponseDto> getAllRooms() {
        return roomRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public RoomResponseDto getRoom(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));
        return toResponse(room);
    }

    public RoomResponseDto createRoom(RoomDto request) {
        Room room = new Room();
        room.setName(request.getName());
        Room saved = roomRepository.save(room);
        return toResponse(saved);
    }

    public RoomResponseDto updateRoom(Long id, RoomDto request) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));
        room.setName(request.getName());
        Room updated = roomRepository.save(room);
        return toResponse(updated);
    }

    public void deleteRoom(Long id) {
        if (!roomRepository.existsById(id)) {
            throw new ResourceNotFoundException("Room not found");
        }
        if (flowerRepository.existsByRoomId(id)) {
            throw new ResourceConflictException("Cannot delete room: it contains flowers");
        }
        roomRepository.deleteById(id);
    }

    private RoomResponseDto toResponse(Room room) {
        RoomResponseDto response = new RoomResponseDto();
        response.setId(room.getId());
        response.setName(room.getName());
        return response;
    }
}
