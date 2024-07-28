package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static pages.LoginPage.*;

public class LoginPage {
    @Given("User navigates to the Login page")
    public void user_navigates_to_the_login_page() throws InterruptedException {
        getLoginPage();
    }
    @When("User successfully enters the log details")
    public void user_successfully_enters_the_log_details() throws InterruptedException {
        getEmailAddress().sendKeys("ppregression@gbi.co");
        getContinueButton().click();
        getPassword().sendKeys("Test22@@");
        getContinueButton().click();
        get2FACode("000000");
        getSubmitButton().click();

    }
    @Then("User should be able to view portfolio page")
    public void user_should_be_able_to_view_portfolio_page() throws InterruptedException {
        waitPortfolioPageLoad();
        boolean endsWithPortfolio = getUrl().endsWith("/portfolio");
        Assert.assertTrue(endsWithPortfolio, "URL does not end with /portfolio");

    }


    @When("User enters invalid email address")
    public void userEntersInvalidEmailAddress() throws InterruptedException {
        getEmailAddress().sendKeys("invalidEmail@gbi.co");
    }

    @And("User clicks continue button")
    public void userClicksContinueButton() throws InterruptedException {
        getContinueButton().click();
    }

    @Then("User should see an error message for invalid email")
    public void userShouldSeeAnErrorMessageForInvalidEmail() throws InterruptedException {
        Assert.assertEquals(getEmailErrorMessage(), "User with provided username or email does not exist", "Error message does not match");
    }
}
