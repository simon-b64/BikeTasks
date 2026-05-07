package at.avox.bike.tasks.persistance.entity;

import at.avox.bike.tasks.util.enums.FuelType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "bike")
@Getter
@Setter
public class BikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    // What bike is it
    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Integer year;

    @Column(name = "fuel_type")
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    // Legal information
    @Column(name = "vin")
    private String vin;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "initial_registration_date")
    private LocalDate initialRegistrationDate;
}
