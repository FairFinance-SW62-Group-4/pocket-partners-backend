package fairfinance.pocketpartners.backend.users.infrastructure.persistence.jpa.repositories;

import fairfinance.pocketpartners.backend.users.domain.model.aggregates.UserFriendsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserFriendsListRepository extends JpaRepository<UserFriendsList, Long> {

    // Método para encontrar la lista de amigos por el ID del usuario
    Optional<UserFriendsList> findByUserId(Long userId);
}