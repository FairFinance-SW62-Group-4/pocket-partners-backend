package fairfinance.pocketpartners.backend.users.interfaces.rest.transform;

import fairfinance.pocketpartners.backend.users.domain.model.commands.CreateUserFriendsListCommand;
import fairfinance.pocketpartners.backend.users.interfaces.rest.resources.CreateUserFriendsListResource;

public class CreateUserFriendsListCommandFromResourceAssembler {
    public static CreateUserFriendsListCommand toCommandFromResource(CreateUserFriendsListResource resource) {
        return new CreateUserFriendsListCommand(resource.userId());
    }
}