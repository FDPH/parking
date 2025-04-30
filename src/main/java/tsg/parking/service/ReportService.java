package tsg.parking.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsg.parking.dto.ParkingRecordDto;
import tsg.parking.dto.response.ReportResponse;
import tsg.parking.exception.NotActiveVehiclesAtTheMoment;
import tsg.parking.model.ParkingRecord;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    ParkingRecordService parkingRecordService;
    VehicleService vehicleService;

    public ReportService(ParkingRecordService parkingRecordService, VehicleService vehicleService) {
        this.parkingRecordService = parkingRecordService;
        this.vehicleService = vehicleService;
    }

    @Transactional
    public ReportResponse closeDay() {
        List<ParkingRecord> todayRecords = parkingRecordService.getTodayRecordsByToday();
        if (todayRecords.isEmpty()) {
            throw new NotActiveVehiclesAtTheMoment("There are no active vehicles at the moment");
        }
        BigDecimal totalAmountFromPendingVehicles = BigDecimal.ZERO;
        BigDecimal totalAmountEarnedToday = BigDecimal.ZERO;

        List<ParkingRecord> pendingVehiclesToPay = new ArrayList<>();

        for (ParkingRecord parkingRecord : todayRecords) {
            if (parkingRecord.isParked()) {
                vehicleService.exitVehicle(parkingRecord.getVehicle().getLicensePlate());
                totalAmountFromPendingVehicles = totalAmountFromPendingVehicles.add(parkingRecord.getTotalAmount());
                pendingVehiclesToPay.add(parkingRecord);
            } else {
                totalAmountEarnedToday = totalAmountEarnedToday.add(parkingRecord.getTotalAmount());
            }
        }
        totalAmountEarnedToday = totalAmountEarnedToday.add(totalAmountFromPendingVehicles);

        List<ParkingRecordDto> pendingDtos = pendingVehiclesToPay.stream()
                .map(ParkingRecordDto::from)
                .toList();

        return new ReportResponse(
                totalAmountEarnedToday,
                totalAmountFromPendingVehicles,
                pendingDtos
        );
    }
}
