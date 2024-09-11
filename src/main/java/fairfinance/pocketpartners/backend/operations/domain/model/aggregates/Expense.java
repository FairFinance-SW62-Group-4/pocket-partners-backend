package fairfinance.pocketpartners.backend.operations.domain.model.aggregates;

import fairfinance.pocketpartners.backend.groups.domain.model.aggregates.Group;
import fairfinance.pocketpartners.backend.operations.domain.model.valueobjects.Amount;
import fairfinance.pocketpartners.backend.operations.domain.model.valueobjects.ExpenseName;
import fairfinance.pocketpartners.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import fairfinance.pocketpartners.backend.users.domain.model.aggregates.UserInformation;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Entity
public class Expense extends AuditableAbstractAggregateRoot<Expense> {

    @Embedded
    private ExpenseName name;

    @Embedded
    private Amount amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInformation userInformation;
  
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Expense(String name, BigDecimal amount, UserInformation userInformation, Group group){
        this.name = new ExpenseName(name);
        this.amount = new Amount(amount);
        this.userInformation = userInformation;
        this.group = group;
    }


    public Expense() {}

    public void UpdateExpenseName(String newName){this.name = new ExpenseName(newName);}

    public void UpdateAmount(BigDecimal newAmount){this.amount = new Amount(newAmount);}

    public Expense UpdateInformation(String newName, BigDecimal newAmount){
        this.name = new ExpenseName(newName);
        this.amount = new Amount(newAmount);
        return this;
    }

    public String getName(){return name.getName();}

    public BigDecimal getAmount(){return amount.getAmount();}
}
