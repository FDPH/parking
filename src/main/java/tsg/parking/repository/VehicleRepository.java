package tsg.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tsg.parking.model.Vehicle;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByLicensePlate(String licensePlate);
}
