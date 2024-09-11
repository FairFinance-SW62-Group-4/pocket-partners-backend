package fairfinance.pocketpartners.backend.operations.domain.model.commands;

import java.math.BigDecimal;

public record UpdateExpenseCommand(Long id, String name, BigDecimal amount) {
}
