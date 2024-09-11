package fairfinance.pocketpartners.backend.groups.interfaces.rest.transform;

import fairfinance.pocketpartners.backend.groups.domain.model.entities.GroupMember;
import fairfinance.pocketpartners.backend.groups.interfaces.rest.resources.GroupMemberResource;

public class CreateGroupMemberCommandFromResourceAssembler {
    public static GroupMemberResource fromCommandToResource(GroupMember resource) {
        return new GroupMemberResource(resource.getGroup().getId(), resource.getUserInformation().getId(), resource.getJoinedAt());
    }
}
