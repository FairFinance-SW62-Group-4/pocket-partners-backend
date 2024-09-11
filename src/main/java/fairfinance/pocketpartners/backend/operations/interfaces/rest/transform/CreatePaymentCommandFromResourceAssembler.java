package fairfinance.pocketpartners.backend.operations.interfaces.rest.transform;

import fairfinance.pocketpartners.backend.operations.domain.model.commands.CreatePaymentCommand;
import fairfinance.pocketpartners.backend.operations.interfaces.rest.resources.CreatePaymentResource;

public class CreatePaymentCommandFromResourceAssembler {
    public static CreatePaymentCommand toCommandFromResource(CreatePaymentResource resource) {
        return new CreatePaymentCommand(resource.description(), resource.amount(), resource.userId(), resource.expenseId());
    }
}
