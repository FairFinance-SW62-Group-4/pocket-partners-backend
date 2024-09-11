package fairfinance.pocketpartners.backend.operations.interfaces.rest.transform;

import fairfinance.pocketpartners.backend.operations.domain.model.aggregates.Expense;
import fairfinance.pocketpartners.backend.operations.interfaces.rest.resources.ExpenseResource;

public class ExpenseResourceFromEntityAssembler {
    public static ExpenseResource toResourceFromEntity(Expense expense){
        return new ExpenseResource(expense.getId(), expense.getName(), expense.getAmount(), expense.getUserInformation().getId(), expense.getGroup().getId(), expense.getCreatedAt(), expense.getUpdatedAt());
    }
}
