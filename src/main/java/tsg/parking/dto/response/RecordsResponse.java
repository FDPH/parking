package tsg.parking.dto.response;

import tsg.parking.dto.ParkingRecordDto;

import java.util.List;

public record RecordsResponse(List<ParkingRecordDto> parkingRecords) {
}
