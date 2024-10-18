package mate.academy.carsharingapp.service.car;

import java.util.List;
import mate.academy.carsharingapp.dto.car.CarDto;
import mate.academy.carsharingapp.dto.car.CreateCarRequestDto;
import org.springframework.data.domain.Pageable;

public interface CarService {
    CarDto findById(Long id);

    List<CarDto> findAll(Pageable pageable);

    CarDto save(CreateCarRequestDto createCarRequestDto);

    CarDto updateById(Long id, CreateCarRequestDto createCarRequestDto);

    void deleteById(Long id);
}
