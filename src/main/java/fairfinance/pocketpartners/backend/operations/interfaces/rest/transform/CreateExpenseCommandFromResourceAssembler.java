package fairfinance.pocketpartners.backend.operations.interfaces.rest.transform;

import fairfinance.pocketpartners.backend.operations.domain.model.commands.CreateExpenseCommand;
import fairfinance.pocketpartners.backend.operations.interfaces.rest.resources.CreateExpenseResource;

public class CreateExpenseCommandFromResourceAssembler {
    public static CreateExpenseCommand toCommandFromResource(CreateExpenseResource resource) {
        return new CreateExpenseCommand(resource.name(), resource.amount(), resource.userId(), resource.groupId());
    }
}
