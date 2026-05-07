package at.avox.bike.tasks.controller.dto;

import at.avox.bike.tasks.util.enums.FuelType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record BikeUpdateDto(
    @NotBlank
    @Size(max = 255)
    String name,

    String brand,
    String model,
    Integer year,
    FuelType fuelType,

    String vin,
    String licensePlate,
    LocalDate initialRegistrationDate
) {
}
