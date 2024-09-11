package fairfinance.pocketpartners.backend.groups.interfaces.rest.transform;

import fairfinance.pocketpartners.backend.groups.domain.model.commands.AddGroupOperationCommand;
import fairfinance.pocketpartners.backend.groups.interfaces.rest.resources.AddGroupOperationResource;

public class AddGroupOperationCommandFromResourceAssembler {
    public static AddGroupOperationCommand toCommandFromResource(AddGroupOperationResource resource) {
        return new AddGroupOperationCommand(resource.groupId(), resource.expenseId(), resource.paymentId());
    }
}
