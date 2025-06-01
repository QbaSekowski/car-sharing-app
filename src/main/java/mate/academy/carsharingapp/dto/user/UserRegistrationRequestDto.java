package mate.academy.carsharingapp.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/* @FieldMatch(firstField = "password", secondField = "repeatPassword",
        message = "The passwords must match") */
public record UserRegistrationRequestDto(
        @Email
        @NotBlank(message = "email may not be blank")
        String email,
        @NotBlank(message = "firstName may not be blank")
        String firstName,
        @NotBlank(message = "lastName may not be blank")
        String lastName,
        @NotBlank(message = "password may not be blank")
        @Length(min = 8, max = 25)
        String password,
        @NotBlank(message = "repeatPassword may not be blank")
        @Length(min = 8, max = 25)
        String repeatPassword
) {
}
