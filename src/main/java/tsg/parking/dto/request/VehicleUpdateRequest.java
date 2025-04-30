package tsg.parking.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tsg.parking.dto.FuelType;
import tsg.parking.dto.VehicleType;

public record VehicleUpdateRequest(
        @NotNull(message = "Vehicle type cannot be blank")
        VehicleType vehicleType,

        @NotNull(message = "Fuel type cannot be blank")
        FuelType fuelType,

        @NotBlank(message = "Parking lot cannot be blank")
        @Size(min = 1, max = 10, message = "Parking lot must be between 1 and 10 characters")
        String locationInParking) {
}
