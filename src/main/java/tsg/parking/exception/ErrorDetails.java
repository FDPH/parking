package tsg.parking.exception;

import java.net.URI;

public record ErrorDetails(
        URI type,
        String title,
        int status,
        String timestamp,
        String detail
) {
}
