package tsg.parking.dto.response;

import tsg.parking.dto.FuelType;
import tsg.parking.dto.VehicleType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VehicleExitResponse(String licensePlate,
                                  VehicleType vehicleType,
                                  FuelType fuelType,
                                  BigDecimal pricePerHour,
                                  boolean hasDiscount,
                                  BigDecimal totalAmount,
                                  LocalDateTime entryTime,
                                  LocalDateTime exitTime,
                                  Long totalTime,
                                  String parkingSpot) {

}
