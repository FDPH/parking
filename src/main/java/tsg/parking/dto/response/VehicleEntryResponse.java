package tsg.parking.dto.response;

import tsg.parking.dto.FuelType;
import tsg.parking.dto.VehicleType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VehicleEntryResponse(String licensePlate,
                                   VehicleType vehicleType,
                                   FuelType fuelType,
                                   BigDecimal pricePerHour,
                                   boolean hasDiscount,
                                   LocalDateTime entryTime,
                                   String parkingSpot) {
}
