package mate.academy.carsharingapp.dto.user;

import jakarta.validation.constraints.NotNull;
import mate.academy.carsharingapp.model.Role;

public record UserRoleUpdateDto(
        @NotNull
        Role.RoleName name
) {
}
