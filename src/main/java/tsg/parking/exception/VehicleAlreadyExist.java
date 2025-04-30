package tsg.parking.exception;

import java.net.URI;

public class VehicleAlreadyExist extends RuntimeException {
    public static final URI TYPE = URI.create("https://tsg.parking.com/docs/errors/vehicle-already-exist");
    public static final String TITLE = "Vehicle Already Exist";
    public VehicleAlreadyExist(String message) {
        super(message);
    }
}
