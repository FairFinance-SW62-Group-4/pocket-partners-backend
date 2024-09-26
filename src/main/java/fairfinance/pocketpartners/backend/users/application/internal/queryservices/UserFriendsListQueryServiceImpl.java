package fairfinance.pocketpartners.backend.users.application.internal.queryservices;

import fairfinance.pocketpartners.backend.users.domain.model.aggregates.UserFriendsList;
import fairfinance.pocketpartners.backend.users.domain.model.queries.GetUserFriendsListByUserIdQuery;
import fairfinance.pocketpartners.backend.users.domain.services.UserFriendsListQueryService;
import fairfinance.pocketpartners.backend.users.infrastructure.persistence.jpa.repositories.UserFriendsListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserFriendsListQueryServiceImpl implements UserFriendsListQueryService {

    private final UserFriendsListRepository friendsListRepository;

    @Autowired
    public UserFriendsListQueryServiceImpl(UserFriendsListRepository friendsListRepository) {
        this.friendsListRepository = friendsListRepository;
    }

    @Override
    public Optional<UserFriendsList> handle(GetUserFriendsListByUserIdQuery query) {
        return friendsListRepository.findById(query.id());
    }
}