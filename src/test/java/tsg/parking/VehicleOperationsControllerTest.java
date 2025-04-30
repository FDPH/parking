package tsg.parking;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tsg.parking.controller.VehicleOperationsController;
import tsg.parking.dto.request.RegisterVehicleRequest;
import tsg.parking.dto.request.RecordDeleteRequest;
import tsg.parking.dto.request.VehicleUpdateRequest;
import tsg.parking.dto.response.VehicleEntryResponse;
import tsg.parking.dto.response.VehicleExitResponse;
import tsg.parking.dto.response.VehicleUpdatedResponse;
import tsg.parking.dto.response.RecordsResponse;
import tsg.parking.service.VehicleService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VehicleOperationsController.class)
class VehicleOperationsControllerTest {
/*
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private VehicleService vehicleService;

    @Test
    void testRegisterVehicleEntry() throws Exception {
        RegisterVehicleRequest request = new RegisterVehicleRequest();
        // Configura los datos del request aquí

        VehicleEntryResponse response = new VehicleEntryResponse();
        // Configura los datos del response aquí

        Mockito.when(vehicleService.registerVehicle(any(RegisterVehicleRequest.class))).thenReturn(response);

        mockMvc.perform(post("/api/vehicles/entry")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.someField").value("expectedValue")); // Ajusta según el response
    }

    @Test
    void testRegisterVehicleExit() throws Exception {
        String licencePlate = "ABC123";
        VehicleExitResponse response = new VehicleExitResponse();
        // Configura los datos del response aquí

        Mockito.when(vehicleService.exitVehicle(eq(licencePlate))).thenReturn(response);

        mockMvc.perform(put("/api/vehicles/exit/{licencePlate}", licencePlate))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.someField").value("expectedValue")); // Ajusta según el response
    }

    @Test
    void testGetVehicleList() throws Exception {
        RecordsResponse response = new RecordsResponse();
        // Configura los datos del response aquí

        Mockito.when(vehicleService.getActiveVehicles()).thenReturn(response);

        mockMvc.perform(get("/api/vehicles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.someField").value("expectedValue")); // Ajusta según el response
    }

    @Test
    void testUpdateVehicle() throws Exception {
        String licencePlate = "ABC123";
        VehicleUpdateRequest request = new VehicleUpdateRequest();
        // Configura los datos del request aquí

        VehicleUpdatedResponse response = new VehicleUpdatedResponse();
        // Configura los datos del response aquí

        Mockito.when(vehicleService.updateVehicle(eq(licencePlate), any(VehicleUpdateRequest.class))).thenReturn(response);

        mockMvc.perform(patch("/api/vehicles/{licencePlate}", licencePlate)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.someField").value("expectedValue")); // Ajusta según el response
    }

    @Test
    void testSoftDeleteVehicle() throws Exception {
        String licencePlate = "ABC123";
        RecordDeleteRequest request = new RecordDeleteRequest();
        // Configura los datos del request aquí

        Mockito.doNothing().when(vehicleService).softDeleteRecord(eq(licencePlate), any(RecordDeleteRequest.class));

        mockMvc.perform(patch("/api/vehicles/{licencePlate}/delete", licencePlate)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
    */
}