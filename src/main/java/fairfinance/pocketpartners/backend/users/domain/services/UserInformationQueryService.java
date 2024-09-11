package fairfinance.pocketpartners.backend.users.domain.services;

import fairfinance.pocketpartners.backend.users.domain.model.aggregates.UserInformation;
import fairfinance.pocketpartners.backend.users.domain.model.queries.GetAllUsersInformationQuery;
import fairfinance.pocketpartners.backend.users.domain.model.queries.GetUserInformationByIdQuery;
import fairfinance.pocketpartners.backend.users.domain.model.queries.GetUserInformationByUserIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserInformationQueryService {

    List<UserInformation> handle(GetAllUsersInformationQuery query);
    Optional<UserInformation> handle(GetUserInformationByIdQuery query);
    Optional<UserInformation> handle(GetUserInformationByUserIdQuery query);
}
