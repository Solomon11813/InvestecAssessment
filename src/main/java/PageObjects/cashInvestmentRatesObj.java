package PageObjects;

import Library.CommonMethods;
import org.openqa.selenium.By;

public class cashInvestmentRatesObj extends CommonMethods {


    By searchToggle = By.id("search-toggle");
    By searchInput = By.id("searchBarInput");
    By searchButton = By.id("searchBarButton");
    By investmentRatesPage = By.xpath("//a[@href='https://www.investec.com/en_za/focus/money/understanding-interest-rates.html']/h4");
    By signUpButton = By.xpath("//button[contains(.,'Sign up')]");
    By name = By.xpath("//input[@name='name']");
    By surname = By.name("surname");
    By emailAddress = By.name("email");
    By insightInterests = null;
    By thankYouMsg = By.xpath("//h3[contains(.,'Thank you')]");
    By msg = By.xpath("//h4[contains(.,'sharing out of the ordinary insights')]");
    By submit = By.xpath("//button[contains(.,'Submit')]");


    public void openSearchToggle() {
        startTest("Cash Investment Rates Insights Sign-up");
        clickElement(searchToggle);
        passTest("Browser launched and search bar opened");
    }

    public void inputDataOnSearchBar(final String data) {
        inputData(searchInput, data);
        clickElement(searchButton);
        passTest("Searching for '" + data + "'");
    }

    public void searchedResultsObj() {
        if (verifyElementIsPresent(investmentRatesPage))
            scrollToElement(investmentRatesPage);

    }

    public void clickOnSearchedItemObj() {
        clickElementUsingJScript(investmentRatesPage);
        passTest("Searched result opened");

    }


    public void verifyPageOpened() {
        if (verifyElementIsPresent(signUpButton))
            scrollToElement(signUpButton);
    }

    public void clickOnSignUp() {
        clickElementUsingJScript(signUpButton);
        pause(2);
    }

    public void fillInSignUpData(final String name, final String surname, final String emailAddress,
                                 final String insightInterest) {

        if (verifyElementIsPresent(this.name)) {
            scrollToElement(this.name);

            inputData(this.name, name);
            inputData(this.surname, surname);
            inputData(this.emailAddress, emailAddress);

            String btnNo = switch (insightInterest.toLowerCase()) {
                case "myself":
                    yield "1";
                case "intermediaries":
                    yield "2";
                default:
                    yield "3";
            };

            insightInterests = By.xpath("(//div[@class='checkbox-input__holder clearfix']/div/button)[" + btnNo + "]");
            clickElement(insightInterests);

            clickElement(submit);
            passTest("sign up details filled out: Name[" + name + "] Surname[" + surname + "] " +
                    "Email Address[" + emailAddress + "] Insights Interest[" + insightInterest + "]");


        }
    }

    public void confirmInsightsSignUpObj() {
        if (verifyElementIsPresent(thankYouMsg) && verifyElementIsPresent(msg))
            passTest("Insights sign-up was successful and email has been sent");
        else
            failTest("Insights sign-up was not successful");

        endTest();
    }
}
