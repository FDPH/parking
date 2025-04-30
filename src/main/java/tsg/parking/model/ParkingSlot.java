package tsg.parking.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tsg.parking.dto.VehicleType;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "parking_slots")
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "slot_number", nullable = false, length = 4)
    String slotNumber;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private VehicleType vehicleType;

    @Setter
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @Setter
    @Column(name = "is_available", nullable = false)
    boolean isAvailable;

}
