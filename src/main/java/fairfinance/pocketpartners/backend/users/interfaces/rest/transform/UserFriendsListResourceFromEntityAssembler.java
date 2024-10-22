package fairfinance.pocketpartners.backend.users.interfaces.rest.transform;

import fairfinance.pocketpartners.backend.users.domain.model.aggregates.UserFriendsList;
import fairfinance.pocketpartners.backend.users.interfaces.rest.resources.UserFriendsListResource;

import java.util.List;

public class UserFriendsListResourceFromEntityAssembler {
    public static UserFriendsListResource toResourceFromEntity(UserFriendsList userFriendsList) {
        return new UserFriendsListResource(userFriendsList.getId(), userFriendsList.getUser().getId(), List.copyOf(userFriendsList.getFriends()));
    }
}