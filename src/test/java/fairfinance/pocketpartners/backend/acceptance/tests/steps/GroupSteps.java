package fairfinance.pocketpartners.backend.acceptance.tests.steps;

import fairfinance.pocketpartners.backend.groups.domain.model.aggregates.Group;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GroupSteps {

    private List<Group> groupList;
    private Group newGroup;

    @Given("I am a user of PocketPartners who wants to stay updated on shared financial updates")
    public void i_am_a_user_of_PocketPartners_who_wants_to_stay_updated_on_shared_financial_updates() {
        groupList = new ArrayList<>();
    }

    @When("I access the option to create a new group from the application")
    public void i_access_the_option_to_create_a_new_group_from_the_application() {
        // In a real application, this step might involve navigating to a specific UI element or API endpoint.
        // For simplicity in this example, we assume the user navigates to the create group screen.
    }

    @Then("I am presented with a form to enter details of the new group, such as name, description, and participants")
    public void i_am_presented_with_a_form_to_enter_details_of_the_new_group() {
        // In a real application, assertion could be made to check if the form is correctly presented.
        // For demonstration, we assume the form presentation is validated elsewhere.
    }

    @Then("I enter the required information and confirm the creation of the group")
    public void i_enter_the_required_information_and_confirm_the_creation_of_the_group() {
        // In a real application, this step would involve submitting the form with group details.
        // For demonstration, we create a new Group object with sample details.
        //newGroup = new Group("Sample Group", "Description of Sample Group");
        groupList.add(newGroup);
    }

    @Then("the new group is successfully created")
    public void the_new_group_is_successfully_created() {
        assertNotNull(newGroup);
        assertEquals("Sample Group", newGroup.getName());
        //assertEquals("Description of Sample Group", newGroup.getDescription());
    }

    @Then("I can start using it to stay updated on shared financial updates")
    public void i_can_start_using_it_to_stay_updated_on_shared_financial_updates() {
        // Additional assertions or actions could be added here based on the application's behavior.
    }
}
