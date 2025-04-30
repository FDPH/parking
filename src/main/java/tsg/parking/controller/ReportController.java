package tsg.parking.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsg.parking.dto.response.ReportResponse;
import tsg.parking.service.ReportService;

@RestController
@RequestMapping(path = "/api/reports")
@Tag(name = "Reports Operations", description = "Operations related to reports")
public class ReportController {

    ReportService reportService;
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/closeday")
    @Operation(summary = "Close the day", description = "Update vehicle status and show a report of the actual day.")
    @ApiResponse(responseCode = "200", description = "The day was closed successfully")
    public ResponseEntity<ReportResponse> closeDay() {
        ReportResponse reportResponse = reportService.closeDay();
        return ResponseEntity.status(HttpStatus.OK).body(reportResponse);
    }
}
