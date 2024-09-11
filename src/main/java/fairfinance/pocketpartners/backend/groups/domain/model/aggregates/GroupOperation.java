package fairfinance.pocketpartners.backend.groups.domain.model.aggregates;

import fairfinance.pocketpartners.backend.operations.domain.model.aggregates.Expense;
import fairfinance.pocketpartners.backend.operations.domain.model.aggregates.Payment;
import fairfinance.pocketpartners.backend.operations.domain.model.valueobjects.Description;
import fairfinance.pocketpartners.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
public class GroupOperation extends AuditableAbstractAggregateRoot<GroupOperation> {
    @Getter
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Getter
    @ManyToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;

    @Getter
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public GroupOperation() {}

    public GroupOperation(Group group, Expense expense, Payment payment) {
        this.group = group;
        this.expense = expense;
        this.payment = payment;
    }
}
