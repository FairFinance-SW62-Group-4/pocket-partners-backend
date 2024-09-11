package fairfinance.pocketpartners.backend.unit.tests;

import fairfinance.pocketpartners.backend.groups.domain.model.aggregates.Group;
import fairfinance.pocketpartners.backend.operations.domain.model.aggregates.Expense;
import fairfinance.pocketpartners.backend.operations.domain.model.valueobjects.Amount;
import fairfinance.pocketpartners.backend.operations.domain.model.valueobjects.ExpenseName;
import fairfinance.pocketpartners.backend.users.domain.model.aggregates.UserInformation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ExpensesTests {

    @Test
    public void expenseNameNotBlank() {
        // Arrange
        UserInformation userInformation = new UserInformation();
        Group group = new Group();

        // Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Expense("", BigDecimal.TEN, userInformation, group));

        // Assert
        String expectedMessage = "Expense name cannot be null or blank";
        String actualMessage = exception.getMessage();

        // Assert the exception message
        assert actualMessage.contains(expectedMessage);
    }

    @Test
    public void expenseAmountNotNull() {
        // Arrange
        Executable createWithNullAmount = () -> new Expense("Food", null, null, null);

        // Act + Assert
        NullPointerException exception = assertThrows(NullPointerException.class, createWithNullAmount);
        assertEquals("amount cannot be null", exception.getMessage());
    }

    @Test
    public void createExpenseWithValidAmount() {
        // Arrange
        String expenseName = "Food";
        BigDecimal amount = BigDecimal.valueOf(50.75);

        // Act
        Expense expense = new Expense(expenseName, amount, null, null);

        // Assert
        assertNotNull(expense);
        assertEquals(expenseName, expense.getName());
        assertEquals(amount, expense.getAmount());
    }

    @Test
    public void updateExpenseName() {
        // Arrange
        Expense expense = new Expense("Food", BigDecimal.TEN, null, null);

        // Act
        expense.UpdateExpenseName("Groceries");

        // Assert
        assertEquals("Groceries", expense.getName());
    }

    @Test
    public void updateAmount() {
        // Arrange
        Expense expense = new Expense("Food", BigDecimal.TEN, null, null);

        // Act
        expense.UpdateAmount(BigDecimal.valueOf(20));

        // Assert
        assertEquals(0, BigDecimal.valueOf(20).compareTo(expense.getAmount()));
    }
}
