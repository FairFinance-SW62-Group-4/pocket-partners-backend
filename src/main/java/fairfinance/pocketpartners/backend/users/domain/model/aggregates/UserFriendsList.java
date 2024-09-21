package fairfinance.pocketpartners.backend.users.domain.model.aggregates;

import fairfinance.pocketpartners.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class UserFriendsList extends AuditableAbstractAggregateRoot<UserFriendsList> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera el ID automáticamente
    private Long id; // Asegúrate de tener un campo id como clave primaria

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true) // Asegúrate de que sea único
    private User user;

    @Setter
    @ElementCollection
    @CollectionTable(name = "user_friends", joinColumns = @JoinColumn(name = "user_friends_list_id")) // Cambiar nombre de la columna para que referencie correctamente
    @Column(name = "friend_user_id")
    private Set<Long> friends = new HashSet<>();

    public UserFriendsList(User user) {
        this.user = user;
    }

    public UserFriendsList() {}

    public void addFriend(Long friendUserId) {
        this.friends.add(friendUserId);
    }

    public void removeFriend(Long friendUserId) {
        this.friends.remove(friendUserId);
    }

    public boolean isFriend(Long friendUserId) {
        return this.friends.contains(friendUserId);
    }
}