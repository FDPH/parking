package tsg.parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ParkingExceptionHandler {

    @ExceptionHandler(VehicleAlreadyExist.class)
    public ResponseEntity<ErrorDetails> handleVehicleAlreadyExist(VehicleAlreadyExist vehicleAlreadyExist) {
        ErrorDetails errorDetails = new ErrorDetails(
                VehicleAlreadyExist.TYPE,
                VehicleAlreadyExist.TITLE,
                HttpStatus.CONFLICT.value(),
                LocalDateTime.now().toString(),
                vehicleAlreadyExist.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }

    @ExceptionHandler(VehicleAlreadyParked.class)
    public ResponseEntity<ErrorDetails> handleVehicleAlreadyParked(VehicleAlreadyParked vehicleAlreadyParked) {
        ErrorDetails errorDetails = new ErrorDetails(
                VehicleAlreadyParked.TYPE,
                VehicleAlreadyParked.TITLE,
                HttpStatus.CONFLICT.value(),
                LocalDateTime.now().toString(),
                vehicleAlreadyParked.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }

    @ExceptionHandler(NotActiveVehiclesAtTheMoment.class)
    public ResponseEntity<ErrorDetails> handleNotActiveVehiclesAtTheMoment(NotActiveVehiclesAtTheMoment notActiveVehiclesAtTheMoment) {
        ErrorDetails errorDetails = new ErrorDetails(
                NotActiveVehiclesAtTheMoment.TYPE,
                NotActiveVehiclesAtTheMoment.TITLE,
                HttpStatus.CONFLICT.value(),
                LocalDateTime.now().toString(),
                notActiveVehiclesAtTheMoment.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }

    @ExceptionHandler(NotSlotsAvailableForThisVehicleType.class)
    public ResponseEntity<ErrorDetails> handleNotSlotsAvailableForThisVehicleType(NotSlotsAvailableForThisVehicleType notSlotsAvailableForThisVehicleType) {
        ErrorDetails errorDetails = new ErrorDetails(
                NotSlotsAvailableForThisVehicleType.TYPE,
                NotSlotsAvailableForThisVehicleType.TITLE,
                HttpStatus.FORBIDDEN.value(),
                LocalDateTime.now().toString(),
                notSlotsAvailableForThisVehicleType.getMessage()
        );
        return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(errorDetails);
    }

    @ExceptionHandler(PriceNotExistByType.class)
    public ResponseEntity<ErrorDetails> handlePriceNotExistByType(PriceNotExistByType priceNotExistByType) {
        ErrorDetails errorDetails = new ErrorDetails(
                PriceNotExistByType.TYPE,
                PriceNotExistByType.TITLE,
                HttpStatus.FORBIDDEN.value(),
                LocalDateTime.now().toString(),
                priceNotExistByType.getMessage()
        );
        return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(errorDetails);
    }

    @ExceptionHandler(VehicleNotRegistered.class)
    public ResponseEntity<ErrorDetails> handleVehicleNotRegistered(VehicleNotRegistered vehicleNotRegistered) {
        ErrorDetails errorDetails = new ErrorDetails(
                VehicleNotRegistered.TYPE,
                VehicleNotRegistered.TITLE,
                HttpStatus.FORBIDDEN.value(),
                LocalDateTime.now().toString(),
                vehicleNotRegistered.getMessage()
        );
        return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(errorDetails);
    }
}
