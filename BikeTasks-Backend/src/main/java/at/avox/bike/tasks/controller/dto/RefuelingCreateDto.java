package at.avox.bike.tasks.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RefuelingCreateDto(
    @NotNull
    LocalDate date,
    Integer odometerReading,
    BigDecimal fuelAmount,
    BigDecimal totalCost,
    boolean lastRefuelingMissed,
    @Size(max = 1000)
    String notes
) {
}
