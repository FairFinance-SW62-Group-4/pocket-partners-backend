package fairfinance.pocketpartners.backend.operations.interfaces.rest.resources;

import java.math.BigDecimal;

public record ExpenseResource(Long id,
                              String name,
                              BigDecimal amount,
                              Long userId,
                              Long groupId,
                              java.util.Date createdAt,
                              java.util.Date updatedAt) {
}
