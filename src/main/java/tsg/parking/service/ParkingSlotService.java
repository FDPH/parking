package tsg.parking.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsg.parking.dto.VehicleType;
import tsg.parking.exception.NotSlotsAvailableForThisVehicleType;
import tsg.parking.model.ParkingSlot;
import tsg.parking.repository.ParkingSlotRepository;

@Service
public class ParkingSlotService {

    ParkingSlotRepository parkingSlotRepository;

    public ParkingSlotService(ParkingSlotRepository parkingSlotRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
    }

    @Transactional
    public ParkingSlot findAvailableSlotByVehicleType(VehicleType vehicleType) {
        return parkingSlotRepository.findByVehicleTypeAndIsAvailableTrue(vehicleType)
                .orElseThrow(() -> new NotSlotsAvailableForThisVehicleType("No available parking slots for this vehicle type"));
    }
}
