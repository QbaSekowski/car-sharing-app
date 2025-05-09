package mate.academy.carsharingapp.exception;

import java.time.LocalDateTime;

public record ExceptionResponse(String message, LocalDateTime localDateTime) {
}