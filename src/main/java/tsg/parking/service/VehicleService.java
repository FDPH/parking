package tsg.parking.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsg.parking.dto.request.RegisterVehicleRequest;
import tsg.parking.dto.request.RecordDeleteRequest;
import tsg.parking.dto.request.VehicleUpdateRequest;
import tsg.parking.dto.response.VehicleEntryResponse;
import tsg.parking.dto.response.VehicleExitResponse;
import tsg.parking.dto.response.VehicleUpdatedResponse;
import tsg.parking.dto.response.RecordsResponse;
import tsg.parking.exception.NotActiveVehiclesAtTheMoment;
import tsg.parking.exception.VehicleAlreadyParked;
import tsg.parking.exception.VehicleNotRegistered;
import tsg.parking.model.ParkingRecord;
import tsg.parking.model.ParkingSlot;
import tsg.parking.model.Price;
import tsg.parking.model.Vehicle;
import tsg.parking.repository.VehicleRepository;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VehicleService {

    VehicleRepository vehicleRepository;
    PriceService priceService;
    ParkingSlotService parkingSlotService;
    ParkingRecordService parkingRecordService;

    public VehicleService(VehicleRepository vehicleRepository, PriceService priceService, ParkingSlotService parkingSlotService, ParkingRecordService parkingRecordService) {
        this.vehicleRepository = vehicleRepository;
        this.priceService = priceService;
        this.parkingSlotService = parkingSlotService;
        this.parkingRecordService = parkingRecordService;
    }

    /**
     * ver si ya existe un parkingRecord para ese vehiculo si es asi finalizar este metodo
     * Consultar si existen slots para este tipo de vehiculo
     * Si existen disponibles capturar ese objeto que tendra el slotNumber
     * --done
     * Ver si existe el vehiculo
     * si existe traer el objeto y usarlo, usar optional
     * guardarlo en vehicles
     * ese objeto usarlo para luego guardarlo en parkingRecord
     * Consultar el precio para ese tipo de vehiculo, traer objeto Price
     * Crear parkingRecord con los datos anteriores
     * Guardar parkingRecord
     * Si es exitoso retornar response
     */
    @Transactional
    public VehicleEntryResponse registerVehicle(RegisterVehicleRequest registerVehicleRequest) {
        if (parkingRecordService.existRecordByVehicleLicencePlate(registerVehicleRequest.licencePlate())) {
            throw new VehicleAlreadyParked("Vehicle already registered");
        }

        ParkingSlot slot = parkingSlotService.findAvailableSlotByVehicleType(registerVehicleRequest.vehicleType());
        Vehicle vehicle = vehicleRepository.findByLicensePlate(registerVehicleRequest.licencePlate().toUpperCase())
                .orElseGet(() -> {
                    Vehicle newVehicle = new Vehicle(
                            registerVehicleRequest.licencePlate().toUpperCase(),
                            registerVehicleRequest.vehicleType(),
                            registerVehicleRequest.fuelType()
                    );
                    return vehicleRepository.save(newVehicle);
                });

        Price price = priceService.getPriceByVehicleType(registerVehicleRequest.vehicleType());
        ParkingRecord parkingRecord = parkingRecordService.saveNewParkingRecord(vehicle, slot, price.getPricePerHour());

        return new VehicleEntryResponse(
                parkingRecord.getVehicle().getLicensePlate(),
                parkingRecord.getVehicle().getVehicleType(),
                parkingRecord.getVehicle().getFuelType(),
                parkingRecord.getPricePerHour(),
                parkingRecord.isHasDiscount(),
                parkingRecord.getEntryTime(),
                parkingRecord.getParkingSlot().getSlotNumber()
        );
    }

    /**
     * buscar si el vehiculo esta parqueado y guardar objeto
     * Arrojar error si no existe
     * calcular el monto que se debe pagar
     * actualizar el objeto con que ya esta saliendo, cambiar el estado isParked
     */
    @Transactional
    public VehicleExitResponse exitVehicle(String licencePlate) {
        ParkingRecord parkingRecord = parkingRecordService.findActiveRecordByVehicle(licencePlate);

        setTotalTime(parkingRecord);
        setTotalAmount(parkingRecord);

        parkingRecordService.updateRecordWithExit(parkingRecord);

        return new VehicleExitResponse(
                parkingRecord.getVehicle().getLicensePlate(),
                parkingRecord.getVehicle().getVehicleType(),
                parkingRecord.getVehicle().getFuelType(),
                parkingRecord.getPricePerHour(),
                parkingRecord.isHasDiscount(),
                parkingRecord.getTotalAmount(),
                parkingRecord.getEntryTime(),
                parkingRecord.getExitTime(),
                parkingRecord.getTotalDuration(),
                parkingRecord.getParkingSlot().getSlotNumber()
        );
    }

    /**
     * traer una lista de parkingRecord activos
     */
    public RecordsResponse getActiveVehicles() {
        List<ParkingRecord> activeRecords = parkingRecordService.getActiveParkingRecords();
        if (activeRecords == null || activeRecords.isEmpty()) {
            throw new NotActiveVehiclesAtTheMoment("No active vehicles at the moment");
        }
        return new RecordsResponse(activeRecords);
    }

    /**
     * Actualizar el vehiculo
     */
    public VehicleUpdatedResponse updateVehicle(String licencePlate, VehicleUpdateRequest registerVehicleRequest) {

        Vehicle vehicle = vehicleRepository.findByLicensePlate(licencePlate).
                orElseThrow(() -> new VehicleNotRegistered("Vehicle not registered"));

        vehicle.setVehicleType(registerVehicleRequest.vehicleType());
        vehicle.setFuelType(registerVehicleRequest.fuelType());
        return new VehicleUpdatedResponse(
                licencePlate,
                vehicle.getVehicleType(),
                vehicle.getFuelType()
        );
    }

    /**
     * Eliminar registro
     */
    public void softDeleteRecord(String licencePlat, RecordDeleteRequest recordDeleteRequest) {
        ParkingRecord activeRecordByVehicle = parkingRecordService.findActiveRecordByVehicle(licencePlat);

        parkingRecordService.softDeleteRecord(activeRecordByVehicle, recordDeleteRequest.reason());

    }

    public void setTotalTime(ParkingRecord parkingRecord) {
        LocalDateTime exitTime = LocalDateTime.now();
        parkingRecord.setExitTime(exitTime);
        Duration duration = Duration.between(parkingRecord.getEntryTime(), exitTime);
        long minutes = duration.toMinutes();
        long hours = (long) Math.ceil(minutes / 60.0);
        parkingRecord.setTotalDuration(hours);
    }

    public void setTotalAmount(ParkingRecord parkingRecord) {
        BigDecimal total = parkingRecord.getPricePerHour().multiply(BigDecimal.valueOf(parkingRecord.getTotalDuration()));
        if (parkingRecord.isHasDiscount()) {
            BigDecimal discount = total.multiply(new BigDecimal("0.25"));
            parkingRecord.setTotalAmount(total.subtract(discount));
        }
    }


}
