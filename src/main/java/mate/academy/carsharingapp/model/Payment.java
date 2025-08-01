package mate.academy.carsharingapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private Type type;
    @ManyToOne
    @JoinColumn(name = "rental_id", nullable = false, unique = true)
    private Rental rentalId;
    @Column(name = "session_url", nullable = false)
    private String sessionUrl;
    @Column(name = "session_id", nullable = false, unique = true)
    private String sessionId;
    @Column(name = "amount_to_pay", nullable = false)
    private BigDecimal amountToPay;

    public enum Type {
        PAYMENT,
        FINE
    }

    public enum Status {
        PENDING,
        PAID
    }
}
