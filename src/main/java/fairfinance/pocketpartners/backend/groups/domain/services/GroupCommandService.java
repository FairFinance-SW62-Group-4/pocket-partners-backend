package fairfinance.pocketpartners.backend.groups.domain.services;

import java.util.Optional;

import fairfinance.pocketpartners.backend.groups.domain.model.aggregates.Group;
import fairfinance.pocketpartners.backend.groups.domain.model.commands.CreateGroupCommand;

public interface GroupCommandService {

    Optional<Group> handle(CreateGroupCommand command);
}
