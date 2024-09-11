package fairfinance.pocketpartners.backend.operations.domain.model.commands;

import java.math.BigDecimal;

public record CreateExpenseCommand(String name, BigDecimal amount, Long userId, Long groupId) {
}
