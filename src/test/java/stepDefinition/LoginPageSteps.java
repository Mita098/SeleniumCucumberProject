package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


import static pages.LoginPage.*;

public class LoginPageSteps{


    @Given("User navigates to the Login page")
    public void user_navigates_to_the_login_page() throws InterruptedException {
        getLoginPage();
    }

    @When("User enters email address")
    public void userEntersEmailAddress() throws InterruptedException {
        getEmailAddress().sendKeys("ppregression@gbi.co");
    }

    @When("User enters invalid email address")
    public void userEntersInvalidEmailAddress() throws InterruptedException {
        getEmailAddress().sendKeys("invalidEmail@gbi.co");
    }

    @When("User enters valid email address")
    public void userEntersValidEmailAddress() throws InterruptedException {
        getEmailAddress().sendKeys("ppregression@gbi.co");
    }

    @When("User leaves email field empty")
    public void userLeavesEmailFieldEmpty() throws InterruptedException {
        getEmailAddress().sendKeys("");
        getContinueButton().click();
    }

    @And("User enters valid password")
    public void userEntersValidPassword() throws InterruptedException {
        getPassword().sendKeys("Test22@@");
    }

    @And("User enters 2FA code")
    public void userEntersFACode() throws InterruptedException {
        get2FACode("000000");
    }

    @And("User enters invalid {int}FA code")
    public void userEntersInvalidFACode(int arg0) throws InterruptedException {
        get2FACode("111111");
    }

    @And("User clicks submit button")
    public void userClicksSubmitButton() throws InterruptedException {
        getSubmitButton().click();
    }

    @And("User clicks continue button")
    public void userClicksContinueButton() throws InterruptedException {
        getContinueButton().click();
    }

    @And("User enters invalid password")
    public void userEntersInvalidPassword() throws InterruptedException {
        getPassword().sendKeys("InvalidPassword");
    }

    @And("User leaves password field empty")
    public void userLeavesPasswordFieldEmpty() throws InterruptedException {
        getPassword();
    }

    @And("User leaves 2FA code field empty")
    public void userLeavesFACodeFieldEmpty() throws InterruptedException {
        getSubmitButton().click();
    }

    @Then("User should be able to view portfolio page")
    public void user_should_be_able_to_view_portfolio_page() throws InterruptedException {
        waitPortfolioPageLoad();
        boolean endsWithPortfolio = getUrl().endsWith("/portfolio");
        Assert.assertTrue(endsWithPortfolio, "URL does not end with /portfolio");
    }

    @Then("User should see an error message for invalid email")
    public void userShouldSeeAnErrorMessageForInvalidEmail() throws InterruptedException {
        Assert.assertEquals(getLoginErrorMessage(), "User with provided username or email does not exist", "Error message does not match");
    }

    @Then("User should see an error message for invalid password")
    public void userShouldSeeAnErrorMessageForInvalidPassword() {
        Assert.assertEquals(getLoginErrorMessage(), "Invalid username or password.", "Error message does not match");
    }

    @Then("User should see an error message for invalid 2FA code")
    public void userShouldSeeAnErrorMessageForInvalid2FACode() {
        Assert.assertEquals(get2FAErrorMessage(), "The code you entered is invalid or has expired. Please check the code is correct or request a new one.", "Error message does not match");
    }

    @Then("User should see an error message for empty email field")
    public void userShouldSeeAnErrorMessageForEmptyEmailField() {
        Assert.assertEquals(getLoginErrorMessage(),"Email or username is required.", "Error message does not match");
    }

    @Then("User should see an error message for empty password field")
    public void userShouldSeeAnErrorMessageForEmptyPasswordField() {
        Assert.assertEquals(getLoginErrorMessage(),"Password is required.", "Error message does not match");
    }

    @Then("User should see an error message for empty 2FA code field")
    public void userShouldSeeAnErrorMessageForEmptyFACodeField() {
        Assert.assertEquals(getEmpty2FAErrorMessage(),"Security Code is required.", "Error message does not match");
    }
}
