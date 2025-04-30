package tsg.parking.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsg.parking.dto.VehicleType;
import tsg.parking.exception.PriceNotExistByType;
import tsg.parking.model.Price;
import tsg.parking.repository.PriceRepository;

@Service
public class PriceService {

    PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Transactional
    public Price getPriceByVehicleType(VehicleType vehicleType) {
        return priceRepository.findByVehicleType(vehicleType)
                .orElseThrow(() -> new PriceNotExistByType("Price not found for vehicle type"));
    }
}
