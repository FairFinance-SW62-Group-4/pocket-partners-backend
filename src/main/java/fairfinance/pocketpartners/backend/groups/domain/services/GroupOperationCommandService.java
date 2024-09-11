package fairfinance.pocketpartners.backend.groups.domain.services;

import fairfinance.pocketpartners.backend.groups.domain.model.commands.AddGroupOperationCommand;
import fairfinance.pocketpartners.backend.groups.domain.model.commands.DeleteGroupOperationCommand;

public interface GroupOperationCommandService {
    Long handle(AddGroupOperationCommand command);
    void handle(DeleteGroupOperationCommand command);
}
