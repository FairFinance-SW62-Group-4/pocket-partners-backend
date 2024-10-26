package fairfinance.pocketpartners.backend.users.interfaces.rest.transform;

import fairfinance.pocketpartners.backend.users.domain.model.commands.UpdateUserFriendsListCommand;
import fairfinance.pocketpartners.backend.users.interfaces.rest.resources.UpdateUserFriendsListResource;

public class UpdateUserFriendsListCommandFromResourceAssembler {
    public static UpdateUserFriendsListCommand toCommandFromResource(Long userId, UpdateUserFriendsListResource resource) {
        return new UpdateUserFriendsListCommand(userId, resource.friendIds());
    }
}
