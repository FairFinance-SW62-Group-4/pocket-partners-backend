package fairfinance.pocketpartners.backend.users.domain.services;

import fairfinance.pocketpartners.backend.users.domain.model.aggregates.UserFriendsList;
import fairfinance.pocketpartners.backend.users.domain.model.queries.GetUserFriendsListByUserIdQuery;

import java.util.Optional;

public interface UserFriendsListQueryService {

    Optional<UserFriendsList> handle(GetUserFriendsListByUserIdQuery query);
}