package mate.academy.carsharingapp.service.car.impl;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.carsharingapp.dto.car.CarDto;
import mate.academy.carsharingapp.dto.car.CreateCarRequestDto;
import mate.academy.carsharingapp.mapper.CarMapper;
import mate.academy.carsharingapp.model.Car;
import mate.academy.carsharingapp.repository.car.CarRepository;
import mate.academy.carsharingapp.service.car.CarService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public CarDto findById(Long id) {
        return carMapper.toDto(carRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Car with id: " + id + " not found")));
    }

    @Override
    public List<CarDto> findAll(Pageable pageable) {
        return carRepository.findAll(pageable).stream()
                .map(carMapper::toDto)
                .toList();
    }

    @Override
    public CarDto save(CreateCarRequestDto createCarRequestDto) {
        Car car = carMapper.toModel(createCarRequestDto);
        Car savedCar = carRepository.save(car);
        return carMapper.toDto(savedCar);
    }

    @Override
    public CarDto updateById(Long id, CreateCarRequestDto createCarRequestDto) {
        Car car = carMapper.toModel(createCarRequestDto);
        car.setId(id);
        return carMapper.toDto(carRepository.save(car));
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
