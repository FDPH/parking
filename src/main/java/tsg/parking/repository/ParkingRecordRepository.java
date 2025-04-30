package tsg.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tsg.parking.model.ParkingRecord;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ParkingRecordRepository extends JpaRepository<ParkingRecord, Long> {
    Optional<ParkingRecord> findByVehicle_LicensePlateAndIsParkedTrueAndIsDeletedFalse(String licencePlate);

    List<ParkingRecord> findAllByIsParkedTrue();

    List<ParkingRecord>  findByEntryTimeBetweenAndIsDeletedFalse(LocalDateTime start, LocalDateTime end);
}
