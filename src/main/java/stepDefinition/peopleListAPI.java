package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class peopleListAPI {

    PageObjects.peopleListAPI peopleListAPI = new PageObjects.peopleListAPI();

    @Given("^As a user I have the people list \"(.*)\"$")
    public void initAPI(final String api) {
        peopleListAPI.init();
        peopleListAPI.startTest("People List");
        peopleListAPI.initializeTest(api);

    }

    @When("^I make a \"(.*)\" request$")
    public void sendRequest(final String requestType) {
        peopleListAPI.sRequest(requestType);

    }

    @Then("^I should get a response and confirm that \"(.*)\" skin color is \"(.*)\"$")
    public void responseResults(final String name, final String skinColor) {
        peopleListAPI.confirmResponse(name, skinColor);
    }

}
