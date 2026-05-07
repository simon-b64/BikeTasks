package at.avox.bike.tasks.controller.dto;

import at.avox.bike.tasks.util.enums.FuelType;

import java.time.LocalDate;
import java.util.UUID;

public record BikeDto(
    UUID id,
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
