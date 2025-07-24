package mate.academy.carsharingapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mate.academy.carsharingapp.dto.user.UserLoginRequestDto;
import mate.academy.carsharingapp.dto.user.UserLoginResponseDto;
import mate.academy.carsharingapp.dto.user.UserRegistrationRequestDto;
import mate.academy.carsharingapp.dto.user.UserResponseDto;
import mate.academy.carsharingapp.exception.RegistrationException;
import mate.academy.carsharingapp.security.AuthenticationService;
import mate.academy.carsharingapp.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/auth")
@Tag(name = "Authentication management",
        description = "Endpoints for managing authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new user",
            description = "Create a new user with given username, "
                    + " password, email, first name, last name")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationRequestDto userRegistrationRequestDto)
            throws RegistrationException {
        return userService.register(userRegistrationRequestDto);
    }

    @PostMapping("/login")
    @Operation(summary = "Log in the user",
            description = "Log registered user into the service "
                    + "using email and password")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto userLoginRequestDto) {
        return authenticationService.authenticate(userLoginRequestDto);
    }
}
