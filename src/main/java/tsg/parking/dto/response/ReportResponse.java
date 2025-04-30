package tsg.parking.dto.response;

import tsg.parking.dto.ParkingRecordDto;

import java.math.BigDecimal;
import java.util.List;

public record ReportResponse(
        BigDecimal totalAmountEarnedToday,
        BigDecimal totalAmountFromPendingVehicles,
        List<ParkingRecordDto> pendingVehiclesToPay
        ) {
}
