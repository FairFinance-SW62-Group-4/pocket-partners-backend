package fairfinance.pocketpartners.backend.groups.application.internal.commandservices;

import java.util.Optional;

import fairfinance.pocketpartners.backend.groups.infrastructure.persistence.jpa.repositories.GroupCurrencyRepository;
import org.springframework.stereotype.Service;

import fairfinance.pocketpartners.backend.groups.domain.model.aggregates.Group;
import fairfinance.pocketpartners.backend.groups.domain.model.commands.CreateGroupCommand;
import fairfinance.pocketpartners.backend.groups.domain.services.GroupCommandService;
import fairfinance.pocketpartners.backend.groups.infrastructure.persistence.jpa.repositories.GroupRepository;

@Service
public class GroupCommandServiceImpl implements GroupCommandService {

    private final GroupRepository groupRepository;

    public GroupCommandServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Optional<Group> handle(CreateGroupCommand command) {
        var group = new Group(command);
        groupRepository.save(group);
        return Optional.of(group);
    }

}
