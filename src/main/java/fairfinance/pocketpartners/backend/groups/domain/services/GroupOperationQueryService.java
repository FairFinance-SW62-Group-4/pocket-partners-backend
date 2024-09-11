package fairfinance.pocketpartners.backend.groups.domain.services;

import fairfinance.pocketpartners.backend.groups.domain.model.aggregates.GroupOperation;
import fairfinance.pocketpartners.backend.groups.domain.model.queries.GetAllGroupOperationsByGroupIdQuery;
import fairfinance.pocketpartners.backend.groups.domain.model.queries.GetAllGroupOperationsQuery;
import fairfinance.pocketpartners.backend.groups.domain.model.queries.GetGroupOperationByGroupIdAndExpenseIdAndPaymentId;
import fairfinance.pocketpartners.backend.groups.domain.model.queries.GetGroupOperationByIdQuery;

import java.util.List;
import java.util.Optional;

public interface GroupOperationQueryService {
    List<GroupOperation> handle(GetAllGroupOperationsQuery query);
    Optional<GroupOperation> handle(GetGroupOperationByIdQuery query);
    List<GroupOperation> handle(GetAllGroupOperationsByGroupIdQuery query);
    Optional<GroupOperation> handle(GetGroupOperationByGroupIdAndExpenseIdAndPaymentId query);
}
