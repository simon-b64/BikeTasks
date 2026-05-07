package at.avox.bike.tasks.service;

import at.avox.bike.tasks.controller.dto.BikeCreateDto;
import at.avox.bike.tasks.controller.dto.BikeDto;
import at.avox.bike.tasks.controller.dto.BikeUpdateDto;
import at.avox.bike.tasks.exceptions.NotFoundException;
import at.avox.bike.tasks.mapper.BikeMapper;
import at.avox.bike.tasks.persistance.BikeRepository;
import at.avox.bike.tasks.persistance.entity.BikeEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BikeService {
    private final BikeRepository bikeRepository;
    private final BikeMapper bikeMapper;

    public List<BikeDto> findAllBikes() {
        var bikes = bikeRepository.findAll();
        return bikeMapper.toDto(bikes);
    }

    public BikeDto findBikeById(UUID id) {
        var bike = findBikeEntityByIdOrThrow(id);
        return bikeMapper.toDto(bike);
    }

    @Transactional
    public BikeDto createBike(BikeCreateDto bikeCreateDto) {
        var bike = bikeMapper.toEntity(bikeCreateDto);

        var bikeEntity =  bikeRepository.save(bike);

        return bikeMapper.toDto(bikeEntity);
    }

    @Transactional
    public BikeDto updateBike(UUID id, BikeUpdateDto bikeUpdateDto) {
        var bike = findBikeEntityByIdOrThrow(id);

        bikeMapper.updateBike(bike, bikeUpdateDto);
        bikeRepository.save(bike);

        return bikeMapper.toDto(bike);
    }

    @Transactional
    public void deleteBike(UUID id) {
        var bike = findBikeEntityByIdOrThrow(id);
        bikeRepository.delete(bike);
    }

    private BikeEntity findBikeEntityByIdOrThrow(UUID id) {
        return bikeRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Bike with id %s not found".formatted(id)));
    }
}
