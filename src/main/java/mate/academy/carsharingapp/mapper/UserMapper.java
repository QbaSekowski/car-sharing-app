package mate.academy.carsharingapp.mapper;

import mate.academy.carsharingapp.dto.user.UserRegistrationRequestDto;
import mate.academy.carsharingapp.dto.user.UserResponseDto;
import mate.academy.carsharingapp.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toDto(User user);

    User toModel(UserRegistrationRequestDto userRegistrationRequestDto);

    User updateUser(UserRegistrationRequestDto userRegistrationRequestDto,
                    @MappingTarget User user);
}
