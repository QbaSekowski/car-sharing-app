package mate.academy.carsharingapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.carsharingapp.dto.car.CarDto;
import mate.academy.carsharingapp.dto.car.CreateCarRequestDto;
import mate.academy.carsharingapp.service.car.CarService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/cars")
@RequiredArgsConstructor
@Tag(name = "Car management", description = "Endpoints for managing cars")
public class CarController {
    private final CarService carService;

    @GetMapping("/{id}")
    @Operation(summary = "Get a car by ID", description = "Get all details of a specific car "
            + "by providing its ID")
    public CarDto getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @GetMapping
    @Operation(summary = "Get all cars", description = "Get a list of all available cars from DB")
    public List<CarDto> getAllCars(Pageable pageable) {
        return carService.getAllCars(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new car", description = "Create a new car by providing "
            + "its model, type, brand, number of these cars in inventory and daily fee")
    public CarDto createCar(@RequestBody CreateCarRequestDto createCarRequestDto) {
        return carService.createCar(createCarRequestDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a car by ID",
            description = "Update a car with given ID by providing its "
                    + "model, type, brand, number of these cars in inventory and daily fee")
    public CarDto updateCar(@PathVariable Long id,
                            @RequestBody CreateCarRequestDto createCarRequestDto) {
        return carService.updateById(id, createCarRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a car", description = "Remove a car by its ID from DB")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteById(id);
    }
}
