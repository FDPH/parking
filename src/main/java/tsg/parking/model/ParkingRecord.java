package tsg.parking.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import tsg.parking.dto.DeletionReason;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "parking_records")
public class ParkingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "has_discount")
    private boolean hasDiscount;

    @Setter
    @Column(name = "price_per_hour", nullable = false, precision = 14, scale = 2)
    private BigDecimal pricePerHour;

    @CreationTimestamp
    @Column(name = "entry_time", nullable = false)
    private LocalDateTime entryTime;

    @Setter
    @Column(name = "exit_time")
    private LocalDateTime exitTime;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @Setter
    @Column(name = "total_duration")
    private Long totalDuration;

    @Setter
    @Column(name = "amount_without_discount", precision = 14, scale = 2)
    private BigDecimal amountWithoutDiscount;

    @Setter
    @Column(name = "total_amount", precision = 14, scale = 2)
    private BigDecimal totalAmount;

    @Setter
    @Column(name = "is_parked", nullable = false)
    private boolean isParked;

    @Setter
    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Setter
    @Column(name = "deleted_reason")
    private DeletionReason deletedReason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parking_slots_id", nullable = false)
    private ParkingSlot parkingSlot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicles_id", nullable = false)
    private Vehicle vehicle;

    public ParkingRecord(boolean hasDiscount, BigDecimal pricePerHour, boolean isParked, ParkingSlot parkingSlot, Vehicle vehicle) {
        this.hasDiscount = hasDiscount;
        this.pricePerHour = pricePerHour;
        this.isParked = isParked;
        this.parkingSlot = parkingSlot;
        this.vehicle = vehicle;
    }

}
