package tsg.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tsg.parking.dto.VehicleType;
import tsg.parking.model.Price;

import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Long> {
    Optional<Price> findByVehicleType(VehicleType vehicleType);
}
