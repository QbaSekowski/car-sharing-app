package mate.academy.carsharingapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.carsharingapp.model.Car;
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
    public Car getCarById(@PathVariable Long id) {
        return carService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Get all cars", description = "Get a list of all available cars from DB")
    public List<Car> getAllCars(Pageable pageable) {
        return carService.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new car", description = "Create a new car by providing "
            + "its model, type, brand, number of these cars in inventory and daily fee")
    public Car createCar(@RequestBody Car car) {
        return carService.save(car);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a car by ID",
            description = "Update a car with given ID by providing its "
                    + "model, type, brand, number of these cars in inventory and daily fee")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        return carService.updateById(id, car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a car", description = "Remove a car by its ID from DB")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteById(id);
    }
}
