package fairfinance.pocketpartners.backend.users.domain.services;

import fairfinance.pocketpartners.backend.users.domain.model.aggregates.UserFriendsList;
import fairfinance.pocketpartners.backend.users.domain.model.commands.AddFriendCommand;
import fairfinance.pocketpartners.backend.users.domain.model.commands.CreateUserFriendsListCommand;
import fairfinance.pocketpartners.backend.users.domain.model.commands.DeleteUserFriendsListCommand;

import java.util.Optional;

public interface UserFriendsListCommandService {

    Optional<UserFriendsList> handle(CreateUserFriendsListCommand command);

    Optional<UserFriendsList> handle(DeleteUserFriendsListCommand command);

    Optional<UserFriendsList> handle(AddFriendCommand command);
}