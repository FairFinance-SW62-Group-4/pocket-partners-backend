package fairfinance.pocketpartners.backend.operations.domain.services;

import fairfinance.pocketpartners.backend.operations.domain.model.aggregates.Expense;
import fairfinance.pocketpartners.backend.operations.domain.model.commands.CreateExpenseCommand;
import fairfinance.pocketpartners.backend.operations.domain.model.commands.UpdateExpenseCommand;

import java.util.Optional;

public interface ExpenseCommandService {
    Optional<Expense> handle(CreateExpenseCommand command);
    Optional<Expense> handle(UpdateExpenseCommand command);
}
