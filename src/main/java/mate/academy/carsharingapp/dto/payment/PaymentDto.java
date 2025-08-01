package mate.academy.carsharingapp.dto.payment;

import java.math.BigDecimal;
import mate.academy.carsharingapp.model.Payment;

public record PaymentDto(
        Long id,
        Payment.Status status,
        Payment.Type type,
        Long rentalId,
        String sessionUrl,
        String sessionId,
        BigDecimal amountToPay) {
}
