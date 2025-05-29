package mate.academy.carsharingapp.dto.car;

import java.math.BigDecimal;
import mate.academy.carsharingapp.model.Car;

public record CarDto(
        Long id,
        String model,
        String brand,
        Car.Type type,
        int inventory,
        BigDecimal dailyFee) {
}
