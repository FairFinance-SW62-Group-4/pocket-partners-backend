package fairfinance.pocketpartners.backend.users.application.internal.commandservices;

import fairfinance.pocketpartners.backend.users.domain.model.aggregates.User;
import fairfinance.pocketpartners.backend.users.domain.model.aggregates.UserFriendsList;
import fairfinance.pocketpartners.backend.users.domain.model.commands.AddFriendCommand;
import fairfinance.pocketpartners.backend.users.domain.model.commands.CreateUserFriendsListCommand;
import fairfinance.pocketpartners.backend.users.domain.model.commands.DeleteUserFriendsListCommand;
import fairfinance.pocketpartners.backend.users.domain.services.UserFriendsListCommandService;
import fairfinance.pocketpartners.backend.users.infrastructure.persistence.jpa.repositories.UserFriendsListRepository;
import fairfinance.pocketpartners.backend.users.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserFriendsListCommandServiceImpl implements UserFriendsListCommandService {

    private final UserFriendsListRepository friendsListRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserFriendsListCommandServiceImpl(UserFriendsListRepository friendsListRepository, UserRepository userRepository) {
        this.friendsListRepository = friendsListRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserFriendsList> handle(CreateUserFriendsListCommand command) {
        UserFriendsList friendsList = new UserFriendsList();
        Optional<User> userOptional = userRepository.findById(command.userId());
        if (userOptional.isPresent()) {
            friendsList.setUser(userOptional.get());
            friendsListRepository.save(friendsList);
            return Optional.of(friendsList);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserFriendsList> handle(DeleteUserFriendsListCommand command) {
        Optional<UserFriendsList> friendsList = friendsListRepository.findById(command.userId());
        friendsList.ifPresent(friendsListRepository::delete);
        return friendsList;
    }

    @Override
    public Optional<UserFriendsList> handle(AddFriendCommand command) {
        Optional<UserFriendsList> friendsList = friendsListRepository.findById(command.userId());
        friendsList.ifPresent(list -> {
            list.addFriend(command.friendId());
            friendsListRepository.save(list);
        });
        return friendsList;
    }
}