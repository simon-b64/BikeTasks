package at.avox.bike.tasks.controller;

import at.avox.bike.tasks.controller.dto.BikeCreateDto;
import at.avox.bike.tasks.controller.dto.BikeDto;
import at.avox.bike.tasks.controller.dto.BikeUpdateDto;
import at.avox.bike.tasks.controller.dto.RefuelingCreateDto;
import at.avox.bike.tasks.controller.dto.RefuelingDto;
import at.avox.bike.tasks.service.BikeService;
import at.avox.bike.tasks.service.RefuelingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bikes")
@RequiredArgsConstructor
public class BikeController {
    private final BikeService bikeService;
    private final RefuelingService refuelingService;

    @GetMapping
    public List<BikeDto> getAllBikes() {
        return bikeService.findAllBikes();
    }

    @GetMapping("/{id}")
    public BikeDto getBikeById(@PathVariable UUID id) {
        return bikeService.findBikeById(id);
    }

    @PostMapping
    public BikeDto createBike(@NotNull @Valid BikeCreateDto bikeCreateDto) {
        return bikeService.createBike(bikeCreateDto);
    }

    @PutMapping("/{id}")
    public BikeDto updateBike(@PathVariable UUID id, @NotNull @Valid BikeUpdateDto bikeUpdateDto) {
        return bikeService.updateBike(id, bikeUpdateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBike(@PathVariable UUID id) {
        bikeService.deleteBike(id);
    }

    @GetMapping("/{id}/refueling")
    public List<RefuelingDto> getRefueling(@PathVariable UUID id) {
        return refuelingService.findAllRefuelingsByBikeId(id);
    }

    @PostMapping("/{id}/refueling")
    public RefuelingDto createRefueling(@PathVariable UUID id, @NotNull @Valid RefuelingCreateDto refuelingDto) {
        return refuelingService.createRefueling(id, refuelingDto);
    }
}
