package mate.academy.carsharingapp.service.user;

import mate.academy.carsharingapp.dto.user.UserRegistrationRequestDto;
import mate.academy.carsharingapp.dto.user.UserResponseDto;
import mate.academy.carsharingapp.dto.user.UserRoleUpdateDto;
import mate.academy.carsharingapp.exception.RegistrationException;
import mate.academy.carsharingapp.model.User;
import org.springframework.security.core.Authentication;

public interface UserService {
    void updateUserRole(Long id, UserRoleUpdateDto userRoleUpdateDto);

    UserResponseDto getUserInfo(Long id);

    UserResponseDto updateUserInfo(Long id, UserRegistrationRequestDto userRegistrationRequestDto);

    UserResponseDto register(UserRegistrationRequestDto userRegistrationRequestDto)
            throws RegistrationException;

    User getUserFromAuthentication(Authentication authentication);
}
