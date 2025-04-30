package tsg.parking.exception;

import java.net.URI;

public class PriceNotExistByType extends RuntimeException {
    public static final URI TYPE = URI.create("https://tsg.parking.com/docs/errors/price-not-exist-by-type");
    public static final String TITLE = "Price Not Exist By Type";

    public PriceNotExistByType(String message) {
        super(message);
    }
}
