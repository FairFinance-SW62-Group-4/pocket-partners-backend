package fairfinance.pocketpartners.backend.groups.domain.services;

import fairfinance.pocketpartners.backend.groups.domain.model.entities.GroupMember;
import fairfinance.pocketpartners.backend.groups.domain.model.commands.CreateGroupMemberCommand;
import java.util.Optional;

public interface GroupMemberCommandService {
    Optional<GroupMember> handle(CreateGroupMemberCommand command);
}
