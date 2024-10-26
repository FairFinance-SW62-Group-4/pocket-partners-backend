package fairfinance.pocketpartners.backend.users.domain.model.commands;

import java.util.List;

public record UpdateUserFriendsListCommand(Long userId, List<Long> friendIds) {
}
