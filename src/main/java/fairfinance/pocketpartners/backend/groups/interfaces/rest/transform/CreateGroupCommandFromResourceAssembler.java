package fairfinance.pocketpartners.backend.groups.interfaces.rest.transform;

import fairfinance.pocketpartners.backend.groups.domain.model.commands.CreateGroupCommand;
import fairfinance.pocketpartners.backend.groups.interfaces.rest.resources.CreateGroupResource;

public class CreateGroupCommandFromResourceAssembler {
    public static CreateGroupCommand toCommandFromResource(CreateGroupResource createGroupResource) {
        return new CreateGroupCommand(createGroupResource.name(), createGroupResource.groupPhoto(), createGroupResource.currency());
    }
}
