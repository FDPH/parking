package tsg.parking.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tsg.parking.dto.FuelType;
import tsg.parking.dto.VehicleType;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "license_plate", nullable = false, length = 6)
    private String licensePlate;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private VehicleType vehicleType;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "fuelType", nullable = false)
    private FuelType fuelType;

    @Setter
    @Column(name = "has_discount")
    private boolean hasDiscount;

    @Setter
    @Column(name = "is_deleted")
    private boolean isDeleted;

    public Vehicle(String licensePlate, VehicleType vehicleType, FuelType fuelType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
    }
    public boolean hasDiscount() {
        return this.fuelType == FuelType.ELECTRIC || this.fuelType == FuelType.HYBRID;
    }
}
