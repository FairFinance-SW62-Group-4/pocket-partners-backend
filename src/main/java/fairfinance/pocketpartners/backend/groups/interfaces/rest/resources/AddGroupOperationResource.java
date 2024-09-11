package fairfinance.pocketpartners.backend.groups.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

public record AddGroupOperationResource(@NotNull
                                        Long groupId,
                                        @NotNull
                                        Long expenseId,
                                        @NotNull
                                        Long paymentId) {
}
