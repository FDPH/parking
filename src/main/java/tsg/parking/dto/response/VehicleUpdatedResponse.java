package tsg.parking.dto.response;

import tsg.parking.dto.FuelType;
import tsg.parking.dto.VehicleType;

public record VehicleUpdatedResponse(String licensePlate,
                                     VehicleType vehicleType,
                                     FuelType fuelType) {
}
