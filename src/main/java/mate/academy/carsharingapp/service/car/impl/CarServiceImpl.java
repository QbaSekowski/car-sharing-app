package mate.academy.carsharingapp.service.car.impl;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.carsharingapp.model.Car;
import mate.academy.carsharingapp.repository.car.CarRepository;
import mate.academy.carsharingapp.service.car.CarService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Car with id: " + id + " not found"));
    }

    @Override
    public List<Car> findAll(Pageable pageable) {
        return carRepository.findAll(pageable).toList();
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateById(Long id, Car car) {
        car.setId(id);
        return carRepository.save(car);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
