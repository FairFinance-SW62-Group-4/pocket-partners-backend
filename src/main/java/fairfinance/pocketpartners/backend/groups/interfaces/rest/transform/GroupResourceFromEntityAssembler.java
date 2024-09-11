package fairfinance.pocketpartners.backend.groups.interfaces.rest.transform;

import fairfinance.pocketpartners.backend.groups.domain.model.aggregates.Group;
import fairfinance.pocketpartners.backend.groups.interfaces.rest.resources.GroupResource;

public class GroupResourceFromEntityAssembler {
    public static GroupResource toResourceFromEntity(Group group) {
        return new GroupResource(group.getId(), group.getName(), group.getCurrencies(), group.getGroupPhoto(), group.getCreatedAt(), group.getUpdatedAt());
    }
}
