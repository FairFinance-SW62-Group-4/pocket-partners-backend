package fairfinance.pocketpartners.backend.users.interfaces.rest.transform;

import fairfinance.pocketpartners.backend.users.domain.model.commands.UpdateUserInformationCommand;
import fairfinance.pocketpartners.backend.users.interfaces.rest.resources.UpdateUserInformationResource;

public class UpdateUserInformationCommandFromResourceAssembler {
    public static UpdateUserInformationCommand toCommandfromResource(Long userId, UpdateUserInformationResource resource) {
        return new UpdateUserInformationCommand(userId, resource.firstName(), resource.lastName(), resource.phoneNumber(), resource.photo(), resource.email());
    }
}