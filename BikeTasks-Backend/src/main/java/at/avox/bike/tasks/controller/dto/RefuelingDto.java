package at.avox.bike.tasks.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record RefuelingDto(
    UUID id,
    LocalDate date,
    Integer odometerReading,
    BigDecimal fuelAmount,
    BigDecimal totalCost,
    boolean lastRefuelingMissed,
    String notes
) {
}
