package tsg.parking.dto.response;

import tsg.parking.model.ParkingRecord;

import java.math.BigDecimal;
import java.util.List;

public record ReportResponse(
        BigDecimal totalAmountEarnedToday,
        BigDecimal totalAmountFromPendingVehicles,
        List<ParkingRecord> pendingVehiclesToPay
        ) {
}
