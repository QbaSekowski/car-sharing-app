package mate.academy.carsharingapp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import mate.academy.carsharingapp.dto.user.UserLoginRequestDto;
import mate.academy.carsharingapp.dto.user.UserLoginResponseDto;
import mate.academy.carsharingapp.dto.user.UserRegistrationRequestDto;
import mate.academy.carsharingapp.dto.user.UserResponseDto;
import mate.academy.carsharingapp.exception.RegistrationException;
import mate.academy.carsharingapp.security.AuthenticationService;
import mate.academy.carsharingapp.service.user.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/auth")
@Tag(name = "Authentication management",
        description = "Endpoints for managing authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    public UserResponseDto register(UserRegistrationRequestDto userRegistrationRequestDto)
            throws RegistrationException {

    }

    public UserLoginResponseDto login(UserLoginRequestDto userLoginRequestDto) {

    }
}
