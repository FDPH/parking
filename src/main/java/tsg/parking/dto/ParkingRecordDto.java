package tsg.parking.dto;

import tsg.parking.model.ParkingRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ParkingRecordDto(
        Long id,
        boolean hasDiscount,
        BigDecimal pricePerHour,
        LocalDateTime entryTime,
        LocalDateTime exitTime,
        Long totalDuration,
        BigDecimal amountWithoutDiscount,
        BigDecimal totalAmount,
        boolean isParked,
        String licensePlate,
        String vehicleType,
        String slotCode
) {
    public static ParkingRecordDto from(ParkingRecord parkingRecord) {
        return new ParkingRecordDto(
                parkingRecord.getId(),
                parkingRecord.isHasDiscount(),
                parkingRecord.getPricePerHour(),
                parkingRecord.getEntryTime(),
                parkingRecord.getExitTime(),
                parkingRecord.getTotalDuration(),
                parkingRecord.getAmountWithoutDiscount(),
                parkingRecord.getTotalAmount(),
                parkingRecord.isParked(),
                parkingRecord.getVehicle().getLicensePlate(),
                parkingRecord.getVehicle().getVehicleType().toString(),
                parkingRecord.getParkingSlot().getSlotNumber()
        );
    }
}
