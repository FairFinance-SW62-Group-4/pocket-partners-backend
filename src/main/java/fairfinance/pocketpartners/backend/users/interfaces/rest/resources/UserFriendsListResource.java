package fairfinance.pocketpartners.backend.users.interfaces.rest.resources;

import java.util.List;

public record UserFriendsListResource(Long id, Long userId, List<Long> friendIds) {
}