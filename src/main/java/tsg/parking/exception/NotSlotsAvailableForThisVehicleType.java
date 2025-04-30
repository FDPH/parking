package tsg.parking.exception;

import java.net.URI;

public class NotSlotsAvailableForThisVehicleType extends RuntimeException {

    public static final URI TYPE = URI.create("https://tsg.parking.com/docs/errors/not-slots-available-for-this-vehicle-type");
    public static final String TITLE = "Not Slots Available For This Vehicle Type";

    public NotSlotsAvailableForThisVehicleType(String message) {
        super(message);
    }
}
