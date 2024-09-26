package fairfinance.pocketpartners.backend.users.interfaces.rest.transform;

import fairfinance.pocketpartners.backend.users.domain.model.commands.AddFriendCommand;
import fairfinance.pocketpartners.backend.users.interfaces.rest.resources.AddFriendResource;

public class AddFriendCommandFromResourceAssembler {
    public static AddFriendCommand toCommandFromResource(AddFriendResource resource) {
        return new AddFriendCommand(resource.userId(), resource.friendId());
    }
}