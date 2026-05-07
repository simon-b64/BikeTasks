package at.avox.bike.tasks.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "refueling")
@Getter
@Setter
public class RefuelingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bike_id", nullable = false)
    private BikeEntity bike;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "odometer_reading")
    private Integer odometerReading;

    @Column(name = "fuel_amount", precision=10, scale=2)
    private BigDecimal fuelAmount;

    @Column(name = "total_cost", precision=10, scale=2)
    private BigDecimal totalCost;

    @Column(name = "last_refueling_missed", nullable = false)
    private boolean lastRefuelingMissed = false;

    @Column(name = "notes", length = 1000)
    private String notes;
}
