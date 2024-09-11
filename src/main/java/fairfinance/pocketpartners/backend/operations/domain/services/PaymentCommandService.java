package fairfinance.pocketpartners.backend.operations.domain.services;

import fairfinance.pocketpartners.backend.operations.domain.model.commands.CompletePaymentCommand;
import fairfinance.pocketpartners.backend.operations.domain.model.commands.CreatePaymentCommand;

public interface PaymentCommandService {
    Long handle(CreatePaymentCommand command);
    Long handle(CompletePaymentCommand command);
}
