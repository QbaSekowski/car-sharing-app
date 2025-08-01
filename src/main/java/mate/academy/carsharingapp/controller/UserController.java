package mate.academy.carsharingapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mate.academy.carsharingapp.dto.user.UserRegistrationRequestDto;
import mate.academy.carsharingapp.dto.user.UserResponseDto;
import mate.academy.carsharingapp.dto.user.UserRoleUpdateDto;
import mate.academy.carsharingapp.service.user.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
@Tag(name = "User management",
        description = "Endpoints for managing users")
public class UserController {
    private final UserService userService;

    @PutMapping("/{id}/roles")
    @Operation(summary = "Update user's role",
            description = "Update user's role")
    public void updateUserRole(@PathVariable Long id,
                               @RequestBody @Valid UserRoleUpdateDto userRoleUpdateDto) {
        userService.updateUserRole(id, userRoleUpdateDto);
    }

    @GetMapping("/me")
    @Operation(summary = "Retrieve user's info",
            description = "Retrieve user's info")
    public UserResponseDto getUserInfo(Authentication authentication) {
        return userService.getUserInfo(
                userService.getUserFromAuthentication(authentication).getId());
    }

    @PutMapping("/me")
    @Operation(summary = "Update user's info",
            description = "Update user's info")
    public UserResponseDto updateUserInfo(Authentication authentication,
                                          @RequestBody @Valid UserRegistrationRequestDto userRegistrationRequestDto) {
        return userService.updateUserInfo(
                userService.getUserFromAuthentication(
                        authentication).getId(), userRegistrationRequestDto);
    }
}
