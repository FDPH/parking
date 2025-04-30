package tsg.parking.exception;

import java.net.URI;

public class VehicleAlreadyParked extends RuntimeException {
    public static final URI TYPE = URI.create("https://tsg.parking.com/docs/errors/vehicle-already-parked");
    public static final String TITLE = "Vehicle Already Parked";
    public VehicleAlreadyParked(String message) {
        super(message);
    }
}
