package at.avox.bike.tasks.mapper;

import at.avox.bike.tasks.controller.dto.BikeCreateDto;
import at.avox.bike.tasks.controller.dto.BikeDto;
import at.avox.bike.tasks.controller.dto.BikeUpdateDto;
import at.avox.bike.tasks.persistance.entity.BikeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BikeMapper {

    @Mapping(target = "id", ignore = true)
    BikeEntity toEntity(BikeCreateDto bikeEntity);

    BikeDto toDto(BikeEntity bikeEntity);

    void updateBike(@MappingTarget BikeEntity entity, BikeUpdateDto dto);

    default List<BikeDto> toDto(List<BikeEntity> bikeEntities) {
        return bikeEntities.stream()
                .map(this::toDto)
                .toList();
    }
}
