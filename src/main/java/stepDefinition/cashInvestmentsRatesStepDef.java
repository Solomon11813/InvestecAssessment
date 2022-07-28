package stepDefinition;


import PageObjects.cashInvestmentRatesObj;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class cashInvestmentsRatesStepDef {

    PageObjects.cashInvestmentRatesObj cashInvestmentRatesObj = new cashInvestmentRatesObj();

    @Given("^As a user I am on the Investec website$")
    public void investecSite() {
        cashInvestmentRatesObj.initializeTest();
        cashInvestmentRatesObj.openSearchToggle();
    }

    @When("^I search for \"(.*)\"$")
    public void searchBar(final String data) {
        cashInvestmentRatesObj.inputDataOnSearchBar(data);
    }

    @Then("^the searched results should appear$")
    public void searchedResults() {
        cashInvestmentRatesObj.searchedResultsObj();
    }

    @When("^I click on the searched topic$")
    public void clickOnSearchedTopic() {
        cashInvestmentRatesObj.clickOnSearchedItemObj();
    }


    @Then("^Understanding cash investment interest rates page should be visible$")
    public void verifyPageIsVisible() {
        cashInvestmentRatesObj.verifyPageOpened();
    }

    @When("^I click on the sign up button$")
    public void clickOnSignUp() {
        cashInvestmentRatesObj.clickOnSignUp();
    }

    @And("^I fill in my \"(.*)\", \"(.*)\", \"(.*)\", select \"(.*)\" and click on submit$")
    public void fillInPersonalDetails(final String name, final String surname, final String emailAddress,
                                      final String insights) {
        cashInvestmentRatesObj.fillInSignUpData(name, surname, emailAddress, insights);
    }

    @Then("^Thank you message should be displayed to confirm sign up$")
    public void clickOnSubmitButton() {
        cashInvestmentRatesObj.confirmInsightsSignUpObj();
    }
}
