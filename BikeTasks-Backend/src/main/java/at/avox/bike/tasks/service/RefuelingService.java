package at.avox.bike.tasks.service;

import at.avox.bike.tasks.controller.dto.RefuelingCreateDto;
import at.avox.bike.tasks.controller.dto.RefuelingDto;
import at.avox.bike.tasks.controller.dto.RefuelingUpdateDto;
import at.avox.bike.tasks.exceptions.NotFoundException;
import at.avox.bike.tasks.mapper.RefuelingMapper;
import at.avox.bike.tasks.persistance.RefuelingRepository;
import at.avox.bike.tasks.persistance.entity.RefuelingEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefuelingService {
    private final RefuelingRepository refuelingRepository;
    private final BikeService bikeService;
    private final RefuelingMapper refuelingMapper;

    public List<RefuelingDto> findAllRefuelingsByBikeId(UUID bikeId) {
        var bikeEntity = bikeService.findEntityByIdOrThrow(bikeId);
        var refuelings = refuelingRepository.findAllByBikeId(bikeEntity.getId());
        return refuelingMapper.toDto(refuelings);
    }

    @Transactional
    public RefuelingDto createRefueling(UUID bikeId, RefuelingCreateDto refuelingCreateDto) {
        var bikeEntity = bikeService.findEntityByIdOrThrow(bikeId);

        var refuelingEntity = refuelingMapper.toEntity(refuelingCreateDto, bikeEntity);
        refuelingRepository.save(refuelingEntity);

        return refuelingMapper.toDto(refuelingEntity);
    }

    @Transactional
    public RefuelingDto updateRefueling(UUID id, RefuelingUpdateDto refuelingUpdateDto) {
        var refuelingEntity =  findEntityByIdOrThrow(id);

        refuelingMapper.updateEntity(refuelingEntity, refuelingUpdateDto);
        refuelingRepository.save(refuelingEntity);

        return refuelingMapper.toDto(refuelingEntity);
    }

    public void deleteRefueling(UUID id) {
        var refuelingEntity = findEntityByIdOrThrow(id);
        refuelingRepository.delete(refuelingEntity);
    }

    private RefuelingEntity findEntityByIdOrThrow(UUID id) {
        return refuelingRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Refueling with id %s not found".formatted(id)));
    }
}
