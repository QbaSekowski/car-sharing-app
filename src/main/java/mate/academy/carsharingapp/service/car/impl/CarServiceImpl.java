package mate.academy.carsharingapp.service.car.impl;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.carsharingapp.dto.car.CarDto;
import mate.academy.carsharingapp.dto.car.CreateCarRequestDto;
import mate.academy.carsharingapp.dto.car.UpdateCarRequestDto;
import mate.academy.carsharingapp.mapper.CarMapper;
import mate.academy.carsharingapp.model.Car;
import mate.academy.carsharingapp.repository.car.CarRepository;
import mate.academy.carsharingapp.service.car.CarService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public CarDto getCarById(Long id) {
        return carMapper.toDto(carRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Car with id: " + id + " not found")));
    }

    @Override
    public List<CarDto> getAllCars(Pageable pageable) {
        return carRepository.findAll(pageable).stream()
                .map(carMapper::toDto)
                .toList();
    }

    @Transactional
    @Override
    public CarDto createCar(CreateCarRequestDto createCarRequestDto) {
        Car car = carMapper.toModel(createCarRequestDto);
        Car savedCar = carRepository.save(car);
        return carMapper.toDto(savedCar);
    }

    @Transactional
    @Override
    public CarDto updateById(Long id, UpdateCarRequestDto updateCarRequestDto) {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Car with id: " + id + " not found"));
        Car updatedCar = carMapper.updateCar(updateCarRequestDto, car);
        return carMapper.toDto(carRepository.save(updatedCar));
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
