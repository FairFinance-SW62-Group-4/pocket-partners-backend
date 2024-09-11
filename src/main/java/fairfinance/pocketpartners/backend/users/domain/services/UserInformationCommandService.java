package fairfinance.pocketpartners.backend.users.domain.services;

import fairfinance.pocketpartners.backend.users.domain.model.aggregates.UserInformation;
import fairfinance.pocketpartners.backend.users.domain.model.commands.CreateUserInformationCommand;
import fairfinance.pocketpartners.backend.users.domain.model.commands.DeleteUserInformationCommand;
import fairfinance.pocketpartners.backend.users.domain.model.commands.UpdateUserInformationCommand;

import java.util.Optional;

public interface UserInformationCommandService {
    Optional<UserInformation> handle(CreateUserInformationCommand command);
    Optional<UserInformation> handle(DeleteUserInformationCommand command);
    Optional<UserInformation> handle(UpdateUserInformationCommand command);
}
