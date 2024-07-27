package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static pages.LoginPage.*;

public class LoginPage {
    @Given("User navigates to the Login page")
    public void user_navigates_to_the_login_page() throws InterruptedException {
        open_login_page();
    }
    @When("User successfully enters the log details")
    public void user_successfully_enters_the_log_details() throws InterruptedException {
        enter_valid_email_address();
        click_continue_button();
        enter_valid_password();
        click_continue_button();
        enter_valid_2FA_code();
        click_submit_button();

    }
    @Then("User should be able to view portfolio page")
    public void user_should_be_able_to_view_portfolio_page() throws InterruptedException {
        wait_portfolio_page_load();
        boolean endsWithPortfolio = isUrlEndingWith("/portfolio");
        Assert.assertTrue(endsWithPortfolio, "URL does not end with /portfolio");

    }



}
