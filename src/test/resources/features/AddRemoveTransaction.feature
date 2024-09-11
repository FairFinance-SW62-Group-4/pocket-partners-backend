Feature: Add or Remove Transactions

Scenario: View Options
    Given that the user has registered in the PocketPartners application and logged into their account,
    When they access the "Transaction History" or "Expense Log" section,
    Then they will see a list of all registered transactions, with options to edit or delete each one.

    Scenario: Edit Details
        Given that the user is viewing the list of transactions in the PocketPartners application,
        When they select a specific transaction they wish to edit,
        Then they can access an edit form where they can modify the transaction details, amount, description, or date.

    Scenario: Delete Transaction
        Given that the user wants to delete an incorrectly registered transaction,
        When they select the option to delete a specific transaction,
        Then they will see a deletion confirmation and upon confirming, the transaction will be permanently removed from their transaction history.