package tsg.parking.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsg.parking.dto.DeletionReason;
import tsg.parking.exception.VehicleNotRegistered;
import tsg.parking.model.ParkingRecord;
import tsg.parking.model.ParkingSlot;
import tsg.parking.model.Vehicle;
import tsg.parking.repository.ParkingRecordRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParkingRecordService {

    private final ParkingRecordRepository parkingRecordRepository;

    public ParkingRecordService(ParkingRecordRepository parkingRecordRepository) {
        this.parkingRecordRepository = parkingRecordRepository;
    }

    @Transactional
    public ParkingRecord saveNewParkingRecord(Vehicle vehicle, ParkingSlot slot, BigDecimal pricePerHour) {
        ParkingRecord parkingRecord = new ParkingRecord(
                vehicle.hasDiscount(),
                pricePerHour,
                true,
                slot,
                vehicle
        );
        return parkingRecordRepository.save(parkingRecord);
    }

    public boolean existRecordByVehicleLicencePlate(String licencePlate) {
        return parkingRecordRepository.findByVehicle_LicensePlateAndIsParkedTrueAndIsDeletedFalse(licencePlate).isPresent();
    }

    @Transactional
    public ParkingRecord findActiveRecordByVehicle(String licencePlate) {
        return parkingRecordRepository.findByVehicle_LicensePlateAndIsParkedTrueAndIsDeletedFalse(licencePlate.toUpperCase())
                .orElseThrow(() -> new VehicleNotRegistered("Parking record not found"));
    }

    @Transactional
    public void updateRecordWithExit(ParkingRecord parkingRecord) {
        parkingRecordRepository.save(parkingRecord);
    }

    @Transactional
    public List<ParkingRecord> getActiveParkingRecords() {
        return parkingRecordRepository.findAllByIsParkedTrue();
    }

    @Transactional
    public void softDeleteRecord(ParkingRecord parkingRecord, DeletionReason reason) {
        parkingRecord.setDeleted(true);
        parkingRecord.setDeletedReason(reason);
        parkingRecordRepository.save(parkingRecord);
    }

    @Transactional
    public List<ParkingRecord> getTodayRecordsByToday() {
        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.plusDays(1).atStartOfDay();

        return parkingRecordRepository.findByEntryTimeBetweenAndIsDeletedFalse(start, end);
    }
}
