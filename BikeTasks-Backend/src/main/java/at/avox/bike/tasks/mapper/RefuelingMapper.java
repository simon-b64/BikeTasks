package at.avox.bike.tasks.mapper;

import at.avox.bike.tasks.controller.dto.RefuelingCreateDto;
import at.avox.bike.tasks.controller.dto.RefuelingDto;
import at.avox.bike.tasks.controller.dto.RefuelingUpdateDto;
import at.avox.bike.tasks.persistance.entity.BikeEntity;
import at.avox.bike.tasks.persistance.entity.RefuelingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RefuelingMapper {

    @Mapping(target = "id", ignore = true)
    RefuelingEntity toEntity(RefuelingCreateDto refuelingCreateDto, BikeEntity bike);

    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget RefuelingEntity refuelingEntity, RefuelingUpdateDto refuelingUpdateDto);

    RefuelingDto toDto(RefuelingEntity refuelingEntity);
    default List<RefuelingDto> toDto(Collection<RefuelingEntity> refuelingEntities) {
        return refuelingEntities.stream()
            .map(this::toDto)
            .toList();
    }
}
