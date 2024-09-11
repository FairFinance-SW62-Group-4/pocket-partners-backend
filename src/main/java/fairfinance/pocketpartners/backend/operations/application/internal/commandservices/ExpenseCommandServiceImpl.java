package fairfinance.pocketpartners.backend.operations.application.internal.commandservices;

import fairfinance.pocketpartners.backend.groups.domain.model.aggregates.Group;
import fairfinance.pocketpartners.backend.groups.infrastructure.persistence.jpa.repositories.GroupRepository;
import fairfinance.pocketpartners.backend.operations.domain.model.aggregates.Expense;
import fairfinance.pocketpartners.backend.operations.domain.model.commands.CreateExpenseCommand;
import fairfinance.pocketpartners.backend.operations.domain.model.commands.UpdateExpenseCommand;
import fairfinance.pocketpartners.backend.operations.domain.services.ExpenseCommandService;
import fairfinance.pocketpartners.backend.operations.infrastructure.persistence.jpa.repositories.ExpenseRepository;
import fairfinance.pocketpartners.backend.users.domain.model.aggregates.UserInformation;
import fairfinance.pocketpartners.backend.users.infrastructure.persistence.jpa.repositories.UserInformationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseCommandServiceImpl implements ExpenseCommandService {

    private final ExpenseRepository expenseRepository;
    private final UserInformationRepository userInformationRepository;
    private final GroupRepository groupRepository;

    public ExpenseCommandServiceImpl(ExpenseRepository expenseRepository, UserInformationRepository userInformationRepository, GroupRepository groupRepository) {
        this.expenseRepository = expenseRepository;
        this.userInformationRepository = userInformationRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public Optional<Expense> handle(CreateExpenseCommand command) {
        Optional<UserInformation> user = userInformationRepository.findById(command.userId());
        Optional<Group> group = groupRepository.findById(command.groupId());

        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        Expense expense = new Expense(command.name(), command.amount(), user.get(), group.get());
        expenseRepository.save(expense);
        return expenseRepository.findById(expense.getId());
    }

    @Override
    public Optional<Expense> handle(UpdateExpenseCommand command) {
        var result = expenseRepository.findById(command.id());
        if (result.isEmpty()) {throw new IllegalArgumentException("Expense not found");}
        var expenseToUpdate = result.get();
        try {
            var updateExpense = expenseRepository.save(expenseToUpdate.UpdateInformation(command.name(), command.amount()));
            return Optional.of(updateExpense);
        }catch (Exception e) {
            throw new IllegalArgumentException("Error while updating expense: " + e.getMessage());
        }
    }

}
