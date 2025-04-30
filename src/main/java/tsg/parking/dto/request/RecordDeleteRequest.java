package tsg.parking.dto.request;

import jakarta.validation.constraints.NotNull;
import tsg.parking.dto.DeletionReason;

public record RecordDeleteRequest(
        @NotNull(message =  "Deletion reason cannot be blank")
        DeletionReason reason
) {
}
