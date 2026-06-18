package com.penzgtu.plant_care_tracker.controller;

import com.penzgtu.plant_care_tracker.dto.RoomDto;
import com.penzgtu.plant_care_tracker.dto.RoomResponseDto;
import com.penzgtu.plant_care_tracker.service.RoomService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public List<RoomResponseDto> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public RoomResponseDto getRoom(@PathVariable Long id) {
        return roomService.getRoom(id);
    }

    @PostMapping
    public RoomResponseDto createRoom(@Valid @RequestBody RoomDto request) {
        return roomService.createRoom(request);
    }

    @PutMapping("/{id}")
    public RoomResponseDto updateRoom(@PathVariable Long id, @Valid @RequestBody RoomDto request) {
        return roomService.updateRoom(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }
}