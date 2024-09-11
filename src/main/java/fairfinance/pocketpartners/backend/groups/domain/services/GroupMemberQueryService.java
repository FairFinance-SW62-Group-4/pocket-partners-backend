package fairfinance.pocketpartners.backend.groups.domain.services;

import fairfinance.pocketpartners.backend.groups.domain.model.entities.GroupMember;
import fairfinance.pocketpartners.backend.groups.domain.model.queries.GetAllGroupsOfUserByUserInformationId;
import fairfinance.pocketpartners.backend.groups.domain.model.queries.GetAllMembersInGroupQuery;

import java.util.List;

public interface GroupMemberQueryService {
    List<GroupMember> handle(GetAllMembersInGroupQuery query);
    List<GroupMember> handle(GetAllGroupsOfUserByUserInformationId query);
}
