package fairfinance.pocketpartners.backend.operations.domain.model.queries;

import fairfinance.pocketpartners.backend.operations.domain.model.valueobjects.PaymentStatus;

public record GetAllPaymentsByUserIdAndStatusQuery(Long userInformationId, PaymentStatus status) {
}
