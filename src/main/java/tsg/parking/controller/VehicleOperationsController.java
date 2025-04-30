package tsg.parking.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tsg.parking.dto.request.RegisterVehicleRequest;
import tsg.parking.dto.request.RecordDeleteRequest;
import tsg.parking.dto.request.VehicleUpdateRequest;
import tsg.parking.dto.response.VehicleEntryResponse;
import tsg.parking.dto.response.VehicleExitResponse;
import tsg.parking.dto.response.VehicleUpdatedResponse;
import tsg.parking.dto.response.RecordsResponse;
import tsg.parking.service.VehicleService;

@RestController
@RequestMapping(path = "/api/vehicles")
@Tag(name = "Vehicle Operations", description = "Operations related to vehicle registration and management")
public class VehicleOperationsController {

    VehicleService vehicleService;

    public VehicleOperationsController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/entry")
    @Operation(summary = "Register a vehicle entry", description = "Registers a new vehicle entry in the parking system.")
    @ApiResponse(responseCode = "201", description = "Vehicle registered successfully")
    @ApiResponse(responseCode = "400", description = "Invalid request data")
    public ResponseEntity<VehicleEntryResponse> registerVehicleEntry(@Valid @RequestBody RegisterVehicleRequest registerVehicleRequest) {
        VehicleEntryResponse response = vehicleService.registerVehicle(registerVehicleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/exit/{licencePlate}")
    @Operation(summary = "Register a vehicle exit", description = "Registers the exit of a vehicle from the parking system.")
    @ApiResponse(responseCode = "200", description = "Vehicle exit registered successfully")
    @ApiResponse(responseCode = "404", description = "Vehicle not found")

    public ResponseEntity<VehicleExitResponse> registerVehicleExit(@PathVariable String licencePlate) {
        VehicleExitResponse response = vehicleService.exitVehicle(licencePlate);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    @Operation(summary = "Active vehicles list", description = "Show the list of active vehicles in the parking system.")
    @ApiResponse(responseCode = "200", description = "Active vehicles list")
    @ApiResponse(responseCode = "404", description = "No vehicles found")
    public ResponseEntity<RecordsResponse> getVehicleList() {
        RecordsResponse response = vehicleService.getActiveVehicles();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/{licencePlate}")
    @Operation(summary = "Update vehicle information", description = "Update several features of the registered vehicle.")
    @ApiResponse(responseCode = "200", description = "Vehicle updated successfully")
    @ApiResponse(responseCode = "204", description = "No content")
    @ApiResponse(responseCode = "404", description = "Vehicle not found")
    public ResponseEntity<VehicleUpdatedResponse> updateVehicle(@PathVariable String licencePlate, @RequestBody @Valid VehicleUpdateRequest updateRequest) {
        VehicleUpdatedResponse response = vehicleService.updateVehicle(licencePlate, updateRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/{licencePlate}/delete")
    @Operation(summary = "Update vehicle information", description = "Update several features of the registered vehicle.")
    @ApiResponse(responseCode = "200", description = "Vehicle updated successfully")
    @ApiResponse(responseCode = "204", description = "No content")
    @ApiResponse(responseCode = "404", description = "Vehicle not found")
    public ResponseEntity<Void> softDeleteVehicle(@PathVariable String licencePlate, @RequestBody @Valid RecordDeleteRequest recordDeleteRequest) {
        vehicleService.softDeleteRecord(licencePlate, recordDeleteRequest);

        return ResponseEntity.ok().build();
    }

}
