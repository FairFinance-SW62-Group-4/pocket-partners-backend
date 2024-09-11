package fairfinance.pocketpartners.backend.groups.application.internal.commandservices;

import fairfinance.pocketpartners.backend.groups.domain.model.commands.CreateGroupMemberCommand;
import fairfinance.pocketpartners.backend.groups.domain.model.entities.GroupMember;
import fairfinance.pocketpartners.backend.groups.domain.services.GroupMemberCommandService;
import fairfinance.pocketpartners.backend.groups.infrastructure.persistence.jpa.repositories.GroupMemberRepository;
import fairfinance.pocketpartners.backend.groups.infrastructure.persistence.jpa.repositories.GroupRepository;
import fairfinance.pocketpartners.backend.users.infrastructure.persistence.jpa.repositories.UserInformationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupMemberCommandServiceImpl implements GroupMemberCommandService {

    private final GroupMemberRepository groupMemberRepository;
    private final GroupRepository groupRepository;
    private final UserInformationRepository userInformationRepository;

    public GroupMemberCommandServiceImpl(GroupMemberRepository groupMemberRepository, GroupRepository groupRepository, UserInformationRepository userInformationRepository) {
        this.groupMemberRepository = groupMemberRepository;
        this.groupRepository = groupRepository;
        this.userInformationRepository = userInformationRepository;
    }


    @Override
    public Optional<GroupMember> handle(CreateGroupMemberCommand command) {
        if (command == null || groupMemberRepository.findByGroupIdAndUserInformationId(command.groupId(), command.userInformationId()).isPresent()) {
            throw new RuntimeException("Group member already exists");
        }
        var group = groupRepository.findById(command.groupId());
        var user = userInformationRepository.findById(command.userInformationId());
        if (group.isEmpty() || user.isEmpty()) {
            throw new RuntimeException("Group or user not found");
        }
        var groupMember = new GroupMember(group.get(), user.get());
        return Optional.of(groupMemberRepository.save(groupMember));
    }
}
