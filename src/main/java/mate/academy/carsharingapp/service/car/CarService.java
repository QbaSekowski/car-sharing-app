package mate.academy.carsharingapp.service.car;

import java.util.List;
import mate.academy.carsharingapp.model.Car;
import org.springframework.data.domain.Pageable;

public interface CarService {
    Car findById(Long id);

    List<Car> findAll(Pageable pageable);

    Car save(Car car);

    Car updateById(Long id, Car car);

    void deleteById(Long id);
}
