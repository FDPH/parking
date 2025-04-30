package tsg.parking.dto.response;

import tsg.parking.model.ParkingRecord;

import java.util.List;

public record RecordsResponse(List<ParkingRecord> parkingRecords) {
}
