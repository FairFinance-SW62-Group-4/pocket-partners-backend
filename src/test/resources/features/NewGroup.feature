Feature: Create a New Group
    As a user of PocketPartners
    I want to create a new group
    So that I can stay updated on shared financial updates

    Scenario: Success in creating a new Group
        Given I am a user of PocketPartners who wants to stay updated on shared financial updates.
        When I access the option to create a new group from the application.
        Then I am presented with a form to enter details of the new group, such as name, description, and participants.
        And I enter the required information and confirm the creation of the group.
        And the new group is successfully created.
        And I can start using it to stay updated on shared financial updates.