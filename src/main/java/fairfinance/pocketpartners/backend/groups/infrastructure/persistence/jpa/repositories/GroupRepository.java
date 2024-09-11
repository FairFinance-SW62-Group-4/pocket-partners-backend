package fairfinance.pocketpartners.backend.groups.infrastructure.persistence.jpa.repositories;

import java.util.Optional;

import fairfinance.pocketpartners.backend.groups.domain.model.valueobjects.GroupName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fairfinance.pocketpartners.backend.groups.domain.model.aggregates.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findByName(GroupName name);
}
