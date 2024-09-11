package fairfinance.pocketpartners.backend.operations.infrastructure.persistence.jpa.repositories;

import fairfinance.pocketpartners.backend.operations.domain.model.aggregates.Expense;
import fairfinance.pocketpartners.backend.operations.domain.model.valueobjects.ExpenseName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    Optional<Expense> findByName(ExpenseName name);
    Optional<Expense> findByNameAndId(ExpenseName name, Long userId);
    List<Expense> findByUserInformationId(Long userInformationId);
    List<Expense> findByGroupId(Long groupId);
}
