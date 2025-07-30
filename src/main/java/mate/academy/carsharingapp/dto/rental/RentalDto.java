package mate.academy.carsharingapp.dto.rental;

import java.time.LocalDate;
import mate.academy.carsharingapp.dto.car.CarDto;

public record RentalDto(
        Long id,
        LocalDate rentalDate,
        LocalDate returnDate,
        LocalDate actualReturnDate,
        CarDto carDto,
        Long userId) {
}
