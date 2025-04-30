package tsg.parking.exception;

import java.net.URI;

public class VehicleNotRegistered extends RuntimeException {
    public static final URI TYPE = URI.create("https://tsg.parking.com/docs/errors/vehicle-not-registered");
    public static final String TITLE = "Vehicle Not Registered";

    public VehicleNotRegistered(String message) {
        super(message);
    }
}
