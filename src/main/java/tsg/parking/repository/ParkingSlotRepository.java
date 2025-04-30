package tsg.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tsg.parking.dto.VehicleType;
import tsg.parking.model.ParkingSlot;

import java.util.Optional;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {
    Optional<ParkingSlot> findByVehicleTypeAndIsAvailableTrue(VehicleType vehicleType);
}
