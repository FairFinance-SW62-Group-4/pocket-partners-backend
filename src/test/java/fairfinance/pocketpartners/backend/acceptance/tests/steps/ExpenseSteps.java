package fairfinance.pocketpartners.backend.acceptance.tests.steps;

import fairfinance.pocketpartners.backend.operations.domain.model.aggregates.Expense;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpenseSteps {

    private List<Expense> expenseList;
    private Expense selectedExpense;
    private BigDecimal initialBalance;

    @Given("a user with an initial balance of {bigDecimal}")
    public void a_user_with_initial_balance(BigDecimal balance) {
        initialBalance = balance;
        expenseList = new ArrayList<>();
    }

    @When("an expense of {bigDecimal} is added")
    public void an_expense_is_added(BigDecimal amount) {
        //Expense newExpense = new Expense(amount);
        //expenseList.add(newExpense);
    }

    @When("an expense of {bigDecimal} is selected for editing")
    public void an_expense_is_selected_for_editing(BigDecimal amount) {
        for (Expense expense : expenseList) {
            if (expense.getAmount().equals(amount)) {
                selectedExpense = expense;
                break;
            }
        }
    }

    @When("the selected expense amount is updated to {bigDecimal}")
    public void the_selected_expense_amount_is_updated(BigDecimal newAmount) {
        //selectedExpense.setAmount(newAmount);
    }

    @When("the selected expense is deleted")
    public void the_selected_expense_is_deleted() {
        expenseList.remove(selectedExpense);
    }

    @Then("the expense list should contain {int} expense")
    public void the_expense_list_should_contain_expense(int expectedCount) {
        assertEquals(expectedCount, expenseList.size());
    }

    @Then("the total balance should be {bigDecimal}")
    public void the_total_balance_should_be(BigDecimal expectedBalance) {
        BigDecimal totalBalance = initialBalance;
        for (Expense expense : expenseList) {
            totalBalance = totalBalance.subtract(expense.getAmount());
        }
        assertEquals(expectedBalance, totalBalance);
    }
}
