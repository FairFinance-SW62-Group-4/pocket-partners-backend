package fairfinance.pocketpartners.backend.unit.tests;

import fairfinance.pocketpartners.backend.operations.domain.model.aggregates.Payment;
import fairfinance.pocketpartners.backend.operations.domain.model.aggregates.Expense;
import fairfinance.pocketpartners.backend.operations.domain.model.valueobjects.PaymentStatus;
import fairfinance.pocketpartners.backend.users.domain.model.aggregates.UserInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PaymentsTests {

    private Payment payment;
    private UserInformation userInformation;
    private Expense expense;

    @BeforeEach
    public void setUp() {
        userInformation = new UserInformation(/* mock or real user information */);
        expense = new Expense(/* mock or real expense */);
        payment = new Payment("Payment for service", BigDecimal.valueOf(100.0), userInformation, expense);
    }

    @Test
    public void createPaymentObject() {
        // Assert
        assertNotNull(payment);
        assertEquals("Payment for service", payment.getDescription());
        assertEquals(new BigDecimal("100.0").stripTrailingZeros(), payment.getAmount().stripTrailingZeros());
        assertEquals(PaymentStatus.PENDING.name().toLowerCase(), payment.getStatus());
        assertEquals(userInformation, payment.getUserInformation());
        assertEquals(expense, payment.getExpense());
    }

    @Test
    public void updatePaymentInformation() {
        // Act
        payment.UpdateInformation("Updated payment description", BigDecimal.valueOf(75.0));

        // Assert
        assertEquals("Updated payment description", payment.getDescription());
        assertEquals(BigDecimal.valueOf(75.0).compareTo(payment.getAmount()), 0);
    }

    @Test
    public void completePayment() {
        // Act
        payment.completePayment();

        // Assert
        assertEquals("completed", payment.getStatus());
    }
}
