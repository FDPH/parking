package tsg.parking.exception;

import java.net.URI;

public class NotActiveVehiclesAtTheMoment extends RuntimeException {
    public static final URI TYPE = URI.create("https://tsg.parking.com/docs/errors/not-active-vehicles-at-the-moment");
    public static final String TITLE = "Not Active Vehicles At The Moment";
    public NotActiveVehiclesAtTheMoment(String message) {
        super(message);
    }
}
