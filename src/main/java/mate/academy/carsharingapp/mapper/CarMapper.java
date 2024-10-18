package mate.academy.carsharingapp.mapper;

import mate.academy.carsharingapp.config.MapperConfig;
import mate.academy.carsharingapp.dto.car.CarDto;
import mate.academy.carsharingapp.dto.car.CreateCarRequestDto;
import mate.academy.carsharingapp.model.Car;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface CarMapper {
    CarDto toDto(Car car);

    Car toModel(CreateCarRequestDto createCarRequestDto);
}
