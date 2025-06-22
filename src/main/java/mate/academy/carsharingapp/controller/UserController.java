package mate.academy.carsharingapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mate.academy.carsharingapp.dto.user.UserRoleUpdateDto;
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

    @PutMapping("/{id}/roles")
    @Operation(summary = "Update user's role",
            description = "Update user's role")
    public void updateUserRole(@PathVariable Long id,
                               @RequestBody @Valid UserRoleUpdateDto userRoleUpdateDto) {
        //userService.updateUserRole(id, userRoleUpdateDto);
    }
}
