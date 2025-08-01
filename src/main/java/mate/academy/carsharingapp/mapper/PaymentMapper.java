package mate.academy.carsharingapp.mapper;

import mate.academy.carsharingapp.config.MapperConfig;
import mate.academy.carsharingapp.dto.payment.PaymentDto;
import mate.academy.carsharingapp.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface PaymentMapper {
    @Mapping(target = "rentalId", source = "rental.id")
    PaymentDto toDto(Payment payment);
}
