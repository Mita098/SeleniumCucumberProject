package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import Hooks.WebDriverHooks;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;


public class LoginPage extends WebDriverHooks {
    private static WebDriverWait wait;

    private static final String email_input_id = "email";
    private static final String password_input_id = "password";
    private static final String continue_button_xpath = "//button[text()='Continue']";
    private static final String submit_button_xpath = "//button[text()='Submit']";
    private static final String error_message_css_selector = ".sc-gWHgXt";
    private static final String error_message_wrong_2FA_xpath = "//div[contains(@data-cy,'input-number')]/p";

    public static void getLoginPage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://gs-app-qa.bullioninternational.info/login-email");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(email_input_id)));
    }

    public static WebElement getEmailAddress() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(email_input_id)));
        return driver.findElement(By.id(email_input_id));
    }

    public static WebElement getContinueButton() throws InterruptedException {
        return driver.findElement(By.xpath(continue_button_xpath));
    }
    public static WebElement getPassword() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(password_input_id)));
        return driver.findElement(By.id(password_input_id));
    }

    public static void get2FACode(String code) throws InterruptedException {
        if (code.length() != 6) {
            throw new IllegalArgumentException("2FA code must be exactly 6 digits long");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='react-code-input']/input[1]")));

        for (int i = 1; i <= 6; i++) {
            String elementXPath = String.format("//div[@class='react-code-input']/input[%d]", i);
            WebElement inputElement = driver.findElement(By.xpath(elementXPath));
            inputElement.sendKeys(Character.toString(code.charAt(i - 1)));
        }
    }

    public static WebElement getSubmitButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(submit_button_xpath)));
        return driver.findElement(By.xpath(submit_button_xpath));
    }
    public static void waitPortfolioPageLoad() throws InterruptedException {
        wait.until(ExpectedConditions.urlContains("/portfolio"));
    }

    public static String getUrl() {
        return driver.getCurrentUrl();
    }
    public static String getLoginErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(error_message_css_selector)));
        return driver.findElement(By.cssSelector(error_message_css_selector)).getText();
    }
    public static String get2FAErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(error_message_wrong_2FA_xpath)));
        WebElement pElement = driver.findElement(By.xpath(error_message_wrong_2FA_xpath));
        List<WebElement> spans = pElement.findElements(By.tagName("span"));
        return spans.get(0).getText() + " " + spans.get(1).getText();

    }

}
